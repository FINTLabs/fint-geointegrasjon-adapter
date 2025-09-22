package no.fint.geointegrasjon.handler.samferdsel;

import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.geointegrasjon.handler.Handler;
import no.novari.fint.model.arkiv.samferdsel.SamferdselActions;
import no.novari.fint.model.resource.FintLinks;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

@Service
public class GetAllSoknadDrosjeloyve implements Handler {

    @Override
    public void accept(Event<FintLinks> response) {
        response.setResponseStatus(ResponseStatus.REJECTED);
        response.setStatusCode("NOT_IMPLEMENTED");
        response.setMessage("A 🚖 will probably not arrive at a stop near you. You've have to walk the walk.");
    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(SamferdselActions.GET_ALL_SOKNADDROSJELOYVE.name());
    }
}
