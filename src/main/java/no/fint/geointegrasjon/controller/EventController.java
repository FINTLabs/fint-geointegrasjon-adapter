package no.fint.geointegrasjon.controller;

import no.fint.event.model.Event;
import no.fint.event.model.HeaderConstants;
import no.fint.geointegrasjon.service.EventHandlerService;
import org.apache.commons.lang3.StringUtils;
import org.omg.CORBA.Object;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;
import java.util.Map;

@RestController
public class EventController {

    private final EventHandlerService eventHandlerService;

    public EventController(EventHandlerService eventHandlerService) {
        this.eventHandlerService = eventHandlerService;
    }

    @PostMapping("/event/{action}")
    public Event handleEvent(
            @RequestHeader(name = HeaderConstants.ORG_ID, defaultValue = "fake.org") String orgId,
            @RequestHeader(name = HeaderConstants.CLIENT, defaultValue = "testing") String client,
            @PathVariable String action,
            @RequestBody(required = false) Map<String, Object> body,
            HttpServletRequest request
    ) {
        Event event = new Event(orgId, "HTTP", action, client);
        if (body != null) {
            event.addObject(body);
        }
        if (StringUtils.isNotBlank(request.getQueryString())) {
            event.setQuery(URLDecoder.decode(request.getQueryString()));
        }
        eventHandlerService.getActionsHandlerMap().get(action).accept(event);
        return event;
    }
}
