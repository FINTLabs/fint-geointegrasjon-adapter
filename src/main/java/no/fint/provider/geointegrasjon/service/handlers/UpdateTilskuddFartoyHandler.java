package no.fint.provider.geointegrasjon.service.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.event.model.Operation;
import no.fint.event.model.ResponseStatus;
import no.fint.model.kultur.kulturminnevern.KulturminnevernActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.kultur.kulturminnevern.TilskuddFartoyResource;
import no.fint.provider.geointegrasjon.state.FaxShipmentState;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Set;

@Slf4j
@Component
public class UpdateTilskuddFartoyHandler implements Handler {
    @Autowired
    private FaxShipmentState faxShipmentState;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public void accept(Event<FintLinks> response) {

        if (response.getData().size() != 1) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setMessage("Invalid request");
            return;
        }

        TilskuddFartoyResource tilskuddFartoyResource = objectMapper.convertValue(response.getData().get(0), TilskuddFartoyResource.class);

        if (response.getOperation() == Operation.CREATE) {
            log.trace("Complete document for creation: {}", tilskuddFartoyResource);

            faxShipmentState.createFaxShipment(tilskuddFartoyResource);

            response.setData(ImmutableList.of(tilskuddFartoyResource));
            response.setResponseStatus(ResponseStatus.ACCEPTED);

        } else if (response.getOperation() == Operation.UPDATE) {
            String query = response.getQuery();
            if (!StringUtils.startsWithIgnoreCase(query, "mappeid/")
                    && !StringUtils.startsWithIgnoreCase(query, "soknadsnummer/")) {
                throw new IllegalArgumentException("Invalid query: " + query);
            }

            if (tilskuddFartoyResource.getJournalpost().isEmpty()) {
                throw new IllegalArgumentException("Update must contain at least one Journalpost");
            }

            log.trace("Complete document for update: {}", tilskuddFartoyResource);

            faxShipmentState.updateFaxShipment(tilskuddFartoyResource, StringUtils.removeStartIgnoreCase(query, "soknadsnummer/"));

            response.setData(ImmutableList.of(tilskuddFartoyResource));
            response.setResponseStatus(ResponseStatus.ACCEPTED);

        } else {
            throw new IllegalArgumentException("Invalid operation: " + response.getOperation());
        }
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(KulturminnevernActions.UPDATE_TILSKUDDFARTOY.name());
    }
}
