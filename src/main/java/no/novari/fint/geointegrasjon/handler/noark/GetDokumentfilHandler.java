package no.novari.fint.geointegrasjon.handler.noark;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.novari.fint.geointegrasjon.exception.FileNotFound;
import no.novari.fint.geointegrasjon.handler.Handler;
import no.novari.fint.geointegrasjon.service.noark.dokument.DokumentfilService;
import no.novari.fint.model.arkiv.noark.NoarkActions;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.arkiv.noark.DokumentfilResource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class GetDokumentfilHandler implements Handler {

    @Autowired
    private DokumentfilService dokumentfilService;

    private final MeterRegistry meterRegistry;
    private final Timer.Builder getDokumentfilTimer;

    public GetDokumentfilHandler(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
        getDokumentfilTimer = Timer.builder("fint.arkiv.get-dokumentfil.timer")
                .description("The GeoIntegrasjon Archive Dokumentfil Timer");
    }


    @Override
    public void accept(Event<FintLinks> response) {
        Timer.Sample sample = Timer.start(meterRegistry);

        try {
            String query = response.getQuery();
            if (!StringUtils.startsWithIgnoreCase(query, "systemid/")) {
                response.setResponseStatus(ResponseStatus.REJECTED);
                response.setStatusCode("INVALID_QUERY");
                response.setMessage("Invalid query: " + query);
                return;
            }
            DokumentfilResource dokumentfilResource = dokumentfilService.getDokumentfil(StringUtils.removeStartIgnoreCase(query, "systemid/"));
            response.addData(dokumentfilResource);
            response.setResponseStatus(ResponseStatus.ACCEPTED);
        } catch (FileNotFound | IOException e) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode("NOT_FOUND");
            response.setMessage(e.getMessage());
        } finally {
            sample.stop(getDokumentfilTimer.tag("request", "getDokumentfil")
                    .tag("status", response.getStatus().name())
                    .tag("statusCode", response.getStatusCode() != null ? response.getStatusCode() : "N/A")
                    .register(meterRegistry));
        }
    }

    @Override
    public Set<String> actions() {
        return new HashSet<>(Collections.singletonList(NoarkActions.GET_DOKUMENTFIL.name()));
    }

    @Override
    public boolean health() {
        return dokumentfilService.health();
    }
}
