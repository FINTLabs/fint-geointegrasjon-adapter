package no.novari.fint.geointegrasjon.handler.noark;

import no.fint.event.model.Event;
import no.novari.fint.geointegrasjon.handler.Handler;
import no.novari.fint.model.arkiv.noark.NoarkActions;
import no.novari.fint.model.resource.FintLinks;
import no.novari.fint.model.resource.arkiv.noark.KlassifikasjonssystemResource;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;

import static no.novari.fint.geointegrasjon.utils.FintUtils.createIdentifikator;

@Service
public class KlassifikasjonssystemHandler implements Handler {
    private final KodeverkHandler kodeverkHandler;

    public KlassifikasjonssystemHandler(KodeverkHandler kodeverkHandler) {
        this.kodeverkHandler = kodeverkHandler;
    }

    @Override
    public void accept(Event<FintLinks> event) {
        kodeverkHandler.kodeverk("Klassifikasjonssystem",
                kode -> {
                    KlassifikasjonssystemResource r = new KlassifikasjonssystemResource();
                    r.setTittel(kode.getKodebeskrivelse());
                    r.setSystemId(createIdentifikator(kode.getKodeverdi()));
                    return r;
                }).get().forEach(event::addData);

    }

    @Override
    public Set<String> actions() {
        return Collections.singleton(NoarkActions.GET_ALL_KLASSIFIKASJONSSYSTEM.name());
    }
}
