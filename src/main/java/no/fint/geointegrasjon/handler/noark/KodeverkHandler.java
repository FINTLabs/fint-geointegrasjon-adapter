package no.fint.geointegrasjon.handler.noark;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import no.fint.event.model.Event;
import no.fint.event.model.ResponseStatus;
import no.fint.event.model.Status;
import no.fint.geointegrasjon.handler.Handler;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonService;
import no.fint.geointegrasjon.utils.FintUtils;
import no.fint.model.administrasjon.arkiv.ArkivActions;
import no.fint.model.felles.basisklasser.Begrep;
import no.fint.model.resource.FintLinks;
import no.fint.model.resource.administrasjon.arkiv.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static no.fint.model.administrasjon.arkiv.ArkivActions.*;

@Service
@Slf4j
public class KodeverkHandler implements Handler {

    @Autowired
    private GeoIntegrasjonService geoIntegrasjonService;

    @Getter
    private final EnumMap<ArkivActions, Supplier<Stream<? extends FintLinks>>> suppliers = new EnumMap<>(ArkivActions.class);

    @PostConstruct
    public void init() {
        suppliers.put(GET_ALL_DOKUMENTSTATUS, kodeverk("Dokumentstatus", DokumentStatusResource::new));
        suppliers.put(GET_ALL_DOKUMENTTYPE, kodeverk("Dokumenttype", DokumentTypeResource::new));
        suppliers.put(GET_ALL_JOURNALPOSTTYPE, kodeverk("Journalposttype", JournalpostTypeResource::new));
        suppliers.put(GET_ALL_JOURNALSTATUS, kodeverk("Journalstatus", JournalStatusResource::new));
        suppliers.put(GET_ALL_KORRESPONDANSEPARTTYPE, kodeverk("Korrespondanseparttype", KorrespondansepartTypeResource::new));
        suppliers.put(GET_ALL_PARTROLLE, kodeverk("SakspartRolle", PartRolleResource::new));
        suppliers.put(GET_ALL_SAKSSTATUS, kodeverk("Saksstatus", SaksstatusResource::new));
        suppliers.put(GET_ALL_SKJERMINGSHJEMMEL, kodeverk("SkjermingsHjemmel", SkjermingshjemmelResource::new));
        suppliers.put(GET_ALL_TILGANGSRESTRIKSJON, kodeverk("Tilgangsrestriksjon", TilgangsrestriksjonResource::new));
        suppliers.put(GET_ALL_TILKNYTTETREGISTRERINGSOM, kodeverk("TilknyttetRegistreringSom", TilknyttetRegistreringSomResource::new));
        suppliers.put(GET_ALL_VARIANTFORMAT, kodeverk("Variantformat", VariantformatResource::new));
        //suppliers.put(GET_ALL_MERKNADSTYPE, kodeverkRepository::getMerknadstype);
        //suppliers.put(GET_ALL_KLASSIFIKASJONSSYSTEM, kodeverk("Klassifikasjonssystem", KlassifikasjonssystemResource::new));
        //suppliers.put(GET_ALL_KLASSE, kodeverkRepository::getKlasse);
    }

    @Override
    public void accept(Event<FintLinks> response) {
        if (!health()) {
            response.setStatus(Status.ADAPTER_REJECTED);
            response.setMessage("Health test failed");
            return;
        }
        response.setResponseStatus(ResponseStatus.ACCEPTED);
        suppliers.getOrDefault(ArkivActions.valueOf(response.getAction()), Stream::empty)
                .get()
                .forEach(response::addData);
    }

    @Override
    public Set<String> actions() {
        return suppliers.keySet().stream().map(Enum::name).collect(Collectors.toSet());
    }

    private Supplier<Stream<? extends FintLinks>> kodeverk(String name, Supplier<? extends Begrep> supplier) {
        return () -> geoIntegrasjonService
                .hentKodeliste(name)
                .getListe()
                .stream()
                .map(kode -> {
                    Begrep begrep = supplier.get();
                    begrep.setKode(kode.getKodeverdi());
                    begrep.setNavn(kode.getKodebeskrivelse());
                    begrep.setSystemId(FintUtils.createIdentifikator(kode.getKodeverdi()));
                    return begrep;
                })
                .map(FintLinks.class::cast);
    }
}
