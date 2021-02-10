package no.fint.geointegrasjon.service;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import no.fint.adapter.event.EventResponseService;
import no.fint.adapter.event.EventStatusService;
import no.fint.event.model.Event;
import no.fint.event.model.Problem;
import no.fint.event.model.ResponseStatus;
import no.fint.event.model.Status;
import no.fint.event.model.health.Health;
import no.fint.event.model.health.HealthStatus;
import no.fint.geointegrasjon.SupportedActions;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.service.geointegrasjon.ClientException;
import no.fint.geointegrasjon.service.geointegrasjon.NotFoundException;
import no.fint.geointegrasjon.service.geointegrasjon.ServerException;
import no.fint.model.resource.FintLinks;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

@Slf4j
@Service
public class EventHandlerService {

    @Autowired
    private EventResponseService eventResponseService;

    @Autowired
    private EventStatusService eventStatusService;

    @Autowired
    private SupportedActions supportedActions;

    @Autowired
    private Collection<Handler> handlers;

    @Getter
    private Map<String, Handler> actionsHandlerMap;

    @Autowired
    @Qualifier("responseHandler")
    private Executor executor;

    public void handleEvent(String component, Event event) {
        if (event.isHealthCheck()) {
            postHealthCheckResponse(component, event);
        } else {
            if (eventStatusService.verifyEvent(component, event)) {
                executor.execute(() ->
                        handleResponse(component, event.getAction(), new Event<>(event)));
            }
        }
    }

    private void handleResponse(String component, String action, Event<FintLinks> response) {
        try {
            actionsHandlerMap.getOrDefault(action, e -> {
                log.warn("No handler found for {}", action);
                e.setStatus(Status.ADAPTER_REJECTED);
                e.setResponseStatus(ResponseStatus.REJECTED);
                e.setMessage("Unsupported action");
            }).accept(response);
        } catch (NotFoundException e) {
            log.debug("{}", e, e);
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode(HttpStatus.NOT_FOUND.name());
            response.setMessage(e.getMessage());
        } catch (ClientException e) {
            log.debug("{}", e, e);
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode(e.getCode());
            response.setMessage(e.getDescription());
            response.setProblems(e.getDetails().stream().map(s -> {
                Problem p = new Problem();
                p.setMessage(s);
                return p;
            }).collect(Collectors.toList()));
        } catch (ServerException e) {
            log.debug("{}", e, e);
            response.setResponseStatus(ResponseStatus.ERROR);
            response.setStatusCode(e.getCode());
            response.setMessage(e.getDescription());
            response.setProblems(e.getDetails().stream().map(s -> {
                Problem p = new Problem();
                p.setMessage(s);
                return p;
            }).collect(Collectors.toList()));
        } catch (Exception e) {
            response.setResponseStatus(ResponseStatus.ERROR);
            response.setMessage(ExceptionUtils.getStackTrace(e));
        } finally {
            if (response.getData() != null) {
                log.info("{}: Response for {}: {}, {} items", component, response.getAction(), response.getResponseStatus(), response.getData().size());
                log.trace("Event data: {}", response.getData());
            } else {
                log.info("{}: Response for {}: {}", component, response.getAction(), response.getResponseStatus());
            }
            eventResponseService.postResponse(component, response);
        }
    }

    public void postHealthCheckResponse(String component, Event event) {
        Event<Health> healthCheckEvent = new Event<>(event);
        healthCheckEvent.setStatus(Status.TEMP_UPSTREAM_QUEUE);

        if (healthCheck()) {
            healthCheckEvent.addData(new Health("adapter", HealthStatus.APPLICATION_HEALTHY));
        } else {
            healthCheckEvent.addData(new Health("adapter", HealthStatus.APPLICATION_UNHEALTHY));
            healthCheckEvent.setMessage("The adapter is unable to communicate with the application.");
        }

        eventResponseService.postResponse(component, healthCheckEvent);
    }

    private boolean healthCheck() {
        return handlers.stream().allMatch(Handler::health);
    }

    @PostConstruct
    void init() {
        actionsHandlerMap = new HashMap<>();
        handlers.forEach(h -> h.actions().forEach(a -> {
            actionsHandlerMap.put(a, h);
            supportedActions.add(a);
        }));
        log.info("Registered {} handlers, supporting actions: {}", handlers.size(), supportedActions.getActions());
    }
}
