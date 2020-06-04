package no.fint.geointegrasjon.handler.kulturminne;

import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.exception.GetTilskuddFartoyNotFoundException;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.service.fint.TilskuddFartoyFactory;
import no.fint.geointegrasjon.state.FaxShipmentState;
import no.fint.model.kultur.kulturminnevern.KulturminnevernActions;
import no.fint.model.resource.FintLinks;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class GetTilskuddFartoyHandler implements Handler {

    @Autowired
    private FaxShipmentState faxShipmentState;

    @Autowired
    private TilskuddFartoyFactory tilskuddFartoyFactory;

    @Override
    public void accept(Event<FintLinks> response) {
        String query = response.getQuery();
        try {
            response.getData().clear();
            if (StringUtils.startsWithIgnoreCase(query, "systemid/")) {
                String systemId = StringUtils.removeStartIgnoreCase(query, "systemid/");
                response.addData(tilskuddFartoyFactory.toFintResource(faxShipmentState.getById(systemId)));
            } else if (StringUtils.startsWithIgnoreCase(query, "mappeid/")) {
                String svarUtShipmentId = StringUtils.removeStartIgnoreCase(query, "mappeid/");
                response.addData(tilskuddFartoyFactory.toFintResource(faxShipmentState.getBySvarUtShipmentId(svarUtShipmentId)));
            } else if (StringUtils.startsWithIgnoreCase(query, "soknadsnummer/")) {
                String applicationId = StringUtils.removeStartIgnoreCase(query, "soknadsnummer/");
                response.addData(tilskuddFartoyFactory.toFintResource(faxShipmentState.getByApplicationId(applicationId)));
            } else {
                throw new IllegalArgumentException("Invalid query: " + query);
            }
            response.setResponseStatus(ResponseStatus.ACCEPTED);
        } catch (GetTilskuddFartoyNotFoundException e) {
            response.setResponseStatus(ResponseStatus.REJECTED);
            response.setStatusCode("NOT_FOUND");
            response.setMessage(e.getMessage());
        }
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(KulturminnevernActions.GET_TILSKUDDFARTOY.name());
    }
}
