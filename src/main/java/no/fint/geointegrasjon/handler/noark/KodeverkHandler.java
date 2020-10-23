package no.fint.geointegrasjon.handler.noark;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.event.model.Status;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.fint.model.arkiv.kodeverk.KodeverkActions;
import no.fint.model.felles.basisklasser.Begrep;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.arkiv.kodeverk.*;
import no.geointegrasjon.arkiv.innsyn.Kode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static no.fint.geointegrasjon.utils.FintUtils.createIdentifikator;
import static no.fint.model.arkiv.kodeverk.KodeverkActions.*;

@Service
@Slf4j
public class KodeverkHandler implements Handler {

    @Autowired
    private InnsynServiceFacade innsynServiceFacade;

    @Getter
    private final EnumMap<KodeverkActions, Supplier<Stream<? extends FintLinks>>> suppliers = new EnumMap<>(KodeverkActions.class);

    @PostConstruct
    public void init() {
        suppliers.put(GET_ALL_DOKUMENTSTATUS,
                kodeverk("Dokumentstatus",
                        begrep(DokumentStatusResource::new)
                                .andThen(FintLinks.class::cast)));

        suppliers.put(GET_ALL_DOKUMENTTYPE,
                kodeverk("Dokumenttype",
                        begrep(DokumentTypeResource::new)
                                .andThen(FintLinks.class::cast)));

        suppliers.put(GET_ALL_JOURNALPOSTTYPE,
                kodeverk("Journalposttype",
                        begrep(JournalpostTypeResource::new)
                                .andThen(FintLinks.class::cast)));

        suppliers.put(GET_ALL_JOURNALSTATUS,
                kodeverk("Journalstatus",
                        begrep(JournalStatusResource::new)
                                .andThen(FintLinks.class::cast)));

        suppliers.put(GET_ALL_KORRESPONDANSEPARTTYPE,
                kodeverk("Korrespondanseparttype",
                        begrep(KorrespondansepartTypeResource::new)
                                .andThen(FintLinks.class::cast)));

        suppliers.put(GET_ALL_PARTROLLE,
                kodeverk("SakspartRolle",
                        begrep(PartRolleResource::new)
                                .andThen(FintLinks.class::cast)));

        suppliers.put(GET_ALL_SAKSSTATUS,
                kodeverk("Saksstatus",
                        begrep(SaksstatusResource::new)
                                .andThen(FintLinks.class::cast)));

        suppliers.put(GET_ALL_SKJERMINGSHJEMMEL,
                kodeverk("SkjermingsHjemmel",
                        begrep(SkjermingshjemmelResource::new)
                                .andThen(FintLinks.class::cast)));

        suppliers.put(GET_ALL_TILGANGSRESTRIKSJON,
                kodeverk("Tilgangsrestriksjon",
                        begrep(TilgangsrestriksjonResource::new)
                                .andThen(FintLinks.class::cast)));

        suppliers.put(GET_ALL_TILKNYTTETREGISTRERINGSOM,
                kodeverk("TilknyttetRegistreringSom",
                        begrep(TilknyttetRegistreringSomResource::new)
                                .andThen(FintLinks.class::cast)));

        suppliers.put(GET_ALL_VARIANTFORMAT,
                kodeverk("Variantformat",
                        begrep(VariantformatResource::new)
                                .andThen(FintLinks.class::cast)));

        //suppliers.put(GET_ALL_MERKNADSTYPE, kodeverkRepository::getMerknadstype);
        //suppliers.put(GET_ALL_KLASSIFIKASJONSSYSTEM, kodeverk("Klassifikasjonssystem", KlassifikasjonssystemResource::new));
        //suppliers.put(GET_ALL_KLASSE, kodeverkRepository::getKlasse);

        /* TODO suppliers.put(GET_ALL_ARKIVDEL,
                kodeverk("Arkivdel",
                        kode -> {
                            ArkivdelResource r = new ArkivdelResource();
                            r.setTittel(kode.getKodebeskrivelse());
                            r.setSystemId(createIdentifikator(kode.getKodeverdi()));
                            return r;
                        }));

         */

        /* TODO suppliers.put(GET_ALL_KLASSIFIKASJONSSYSTEM,
                kodeverk("Klassifikasjonssystem",
                        kode -> {
                            KlassifikasjonssystemResource r = new KlassifikasjonssystemResource();
                            r.setTittel(kode.getKodebeskrivelse());
                            r.setSystemId(createIdentifikator(kode.getKodeverdi()));
                            return r;
                        }));

         */

    }

    @Override
    public void accept(Event<FintLinks> response) {
        if (!health()) {
            response.setStatus(Status.ADAPTER_REJECTED);
            response.setMessage("Health test failed");
            return;
        }
        response.setResponseStatus(ResponseStatus.ACCEPTED);
        suppliers.getOrDefault(KodeverkActions.valueOf(response.getAction()), Stream::empty)
                .get()
                .forEach(response::addData);
    }

    @Override
    public Set<String> actions() {
        return suppliers.keySet().stream().map(Enum::name).collect(Collectors.toSet());
    }

    private Supplier<Stream<? extends FintLinks>> kodeverk(String name, Function<Kode, FintLinks> mapper) {
        return () -> innsynServiceFacade
                .hentKodeliste(name)
                .getListe()
                .stream()
                .map(mapper);
    }

    private Function<Kode, Begrep> begrep(Supplier<? extends Begrep> supplier) {
        return kode -> {
            Begrep begrep = supplier.get();
            begrep.setKode(kode.getKodeverdi());
            begrep.setNavn(kode.getKodebeskrivelse());
            begrep.setSystemId(createIdentifikator(kode.getKodeverdi()));
            return begrep;
        };
    }

}
