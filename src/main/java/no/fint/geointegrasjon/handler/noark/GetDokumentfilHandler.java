package no.fint.geointegrasjon.handler.noark;

import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.exception.FileNotFound;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.service.noark.dokument.DokumentfilService;
import no.fint.model.arkiv.noark.NoarkActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.arkiv.noark.DokumentfilResource;
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

    @Override
    public void accept(Event<FintLinks> response) {
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
