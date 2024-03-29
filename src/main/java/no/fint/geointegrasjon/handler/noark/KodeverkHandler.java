package no.fint.geointegrasjon.handler.noark;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import no.fint.arkiv.NoarkMetadataService;
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

    @Getter
    private final EnumMap<KodeverkActions, Supplier<Stream<? extends FintLinks>>> suppliers = new EnumMap<>(
            KodeverkActions.class);
    @Autowired
    private NoarkMetadataService noarkMetadataService;
    @Autowired
    private InnsynServiceFacade innsynServiceFacade;

    @PostConstruct
    public void init() {
        suppliers.put(GET_ALL_DOKUMENTSTATUS,
                merge(noarkMetadataService::getDokumentStatus,
                        kodeverk("Dokumentstatus",
                                begrep(DokumentStatusResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_DOKUMENTTYPE,
                merge(noarkMetadataService::getDokumentType,
                        kodeverk("Dokumenttype", begrep(DokumentTypeResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_JOURNALPOSTTYPE,
                merge(noarkMetadataService::getJournalpostType,
                        kodeverk("Journalposttype",
                                begrep(JournalpostTypeResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_JOURNALSTATUS,
                merge(noarkMetadataService::getJournalStatus,
                        kodeverk("Journalstatus", begrep(JournalStatusResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_KORRESPONDANSEPARTTYPE,
                merge(noarkMetadataService::getKorrespondansepartType,
                        kodeverk("Korrespondanseparttype",
                                begrep(KorrespondansepartTypeResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_PARTROLLE,
                merge(noarkMetadataService::getPartRolle,
                        kodeverk("SakspartRolle", begrep(PartRolleResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_SAKSSTATUS,
                merge(noarkMetadataService::getSaksStatus,
                        kodeverk("Saksstatus", begrep(SaksstatusResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_SKJERMINGSHJEMMEL,
                merge(noarkMetadataService::getSkjermingshjemmel,
                        kodeverk("SkjermingsHjemmel",
                                begrep(SkjermingshjemmelResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_TILGANGSRESTRIKSJON,
                merge(noarkMetadataService::getTilgangsrestriksjon,
                        kodeverk("Tilgangsrestriksjon",
                                begrep(TilgangsrestriksjonResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_TILKNYTTETREGISTRERINGSOM,
                merge(noarkMetadataService::getTilknyttetRegistreringSom,
                        kodeverk("TilknyttetRegistreringSom",
                                begrep(TilknyttetRegistreringSomResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_VARIANTFORMAT,
                merge(noarkMetadataService::getVariantformat,
                        kodeverk("Variantformat", begrep(VariantformatResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_FORMAT,
                merge(noarkMetadataService::getFormat,
                        kodeverk("Format", begrep(FormatResource::new).andThen(FintLinks.class::cast))));

        suppliers.put(GET_ALL_SAKSMAPPETYPE,
                kodeverk("Mappetype", begrep(SaksmappetypeResource::new).andThen(FintLinks.class::cast)));

        // TODO suppliers.put(GET_ALL_MERKNADSTYPE, kodeverkRepository::getMerknadstype);
        // TODO suppliers.put(GET_ALL_KLASSIFIKASJONSSYSTEM, kodeverk("Klassifikasjonssystem", KlassifikasjonssystemResource::new));
        // TODO suppliers.put(GET_ALL_KLASSE, kodeverkRepository::getKlasse);

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

    Supplier<Stream<? extends FintLinks>> kodeverk(String name, Function<Kode, FintLinks> mapper) {
        return () -> innsynServiceFacade.hentKodeliste(name).getListe().stream().map(mapper);
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

    @SafeVarargs
    private final Supplier<Stream<? extends FintLinks>> merge(Supplier<Stream<? extends FintLinks>>... suppliers) {
        return () -> Stream.of(suppliers).flatMap(Supplier::get);
    }
}
