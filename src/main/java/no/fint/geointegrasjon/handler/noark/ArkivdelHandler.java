package no.fint.geointegrasjon.handler.noark;

import no.fint.event.model.Event;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.model.arkiv.noark.NoarkActions;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.arkiv.noark.ArkivdelResource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

import static no.fint.geointegrasjon.utils.FintUtils.createIdentifikator;

@Service
public class ArkivdelHandler implements Handler {
    private final KodeverkHandler kodeverkHandler;

    public ArkivdelHandler(KodeverkHandler kodeverkHandler) {
        this.kodeverkHandler = kodeverkHandler;
    }

    @Override
    public void accept(Event<FintLinks> event) {
        kodeverkHandler.kodeverk("Arkivdel",
                kode -> {
                    ArkivdelResource r = new ArkivdelResource();
                    r.setTittel(kode.getKodebeskrivelse());
                    r.setSystemId(createIdentifikator(kode.getKodeverdi()));
                    return r;
                }).get().forEach(event::addData);

    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(NoarkActions.GET_ALL_ARKIVDEL.name());
    }
}
