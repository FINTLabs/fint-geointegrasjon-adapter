package no.fint.geointegrasjon.model.noark;

import lombok.extern.slf4j.Slf4j;
import no.fint.arkiv.AdditionalFieldService;
import no.fint.arkiv.CaseProperties;
import no.fint.arkiv.TitleService;
import no.fint.geointegrasjon.exception.InvalidCaseType;
import no.fint.geointegrasjon.utils.FintUtils;
import no.fint.model.arkiv.kodeverk.Merknadstype;
import no.fint.model.arkiv.kodeverk.Saksstatus;
import no.fint.model.arkiv.noark.AdministrativEnhet;
import no.fint.model.arkiv.noark.Arkivdel;
import no.fint.model.arkiv.noark.Arkivressurs;
import no.fint.model.resource.Link;
import no.fint.model.resource.arkiv.noark.KlasseResource;
import no.fint.model.resource.arkiv.noark.KlassifikasjonssystemResource;
import no.fint.model.resource.arkiv.noark.MerknadResource;
import no.fint.model.resource.arkiv.noark.SaksmappeResource;
import no.geointegrasjon.arkiv.innsyn.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static no.fint.geointegrasjon.utils.FintUtils.*;
import static org.apache.commons.lang3.StringUtils.substringAfter;
import static org.apache.commons.lang3.StringUtils.substringBefore;

@Service
@Slf4j
public class SaksmappeMapper {

    private final String tilleggstype;
    private final TitleService titleService;
    private final AdditionalFieldService additionalFieldService;

    public SaksmappeMapper(
            @Value("${fint.geointegrasjon.tilleggstype}") String tilleggstype,
            TitleService titleService,
            AdditionalFieldService additionalFieldService) {
        this.tilleggstype = tilleggstype;
        this.titleService = titleService;
        this.additionalFieldService = additionalFieldService;
    }

    public <R extends SaksmappeResource> Function<Saksmappe, R> toFintResource(CaseProperties caseProperties, Supplier<R> supplier, BiConsumer<Saksmappe, R> consumer) {
        return saksmappe -> {
            R resource = supplier.get();
            log.info("Sak SystemID {}", saksmappe.getSystemID());

            ifPresent(saksmappe.getTittel(), resource::setTittel);
            ifPresent(saksmappe.getOffentligTittel(), resource::setOffentligTittel);
            ifPresent(saksmappe.getSaksdato(), resource::setSaksdato, FintUtils::fromXmlDate);
            setIdentifikator(saksmappe.getSystemID(), resource::setSystemId);
            setIdentifikator(saksmappe.getSaksnr(), resource::setMappeId, s -> String.format("%d/%d", s.getSaksaar(), s.getSakssekvensnummer()));
            ifPresent(saksmappe.getSaksnr(), resource::setSaksaar, s -> s.getSaksaar().toString());
            ifPresent(saksmappe.getSaksnr(), resource::setSakssekvensnummer, s -> s.getSakssekvensnummer().toString());

            ifPresent(saksmappe.getAdministrativEnhet(), resource::addAdministrativEnhet, Link.apply(AdministrativEnhet.class, "systemid"));
            ifPresent(saksmappe.getSaksstatus(), resource::addSaksstatus, Link.apply(Saksstatus.class, "systemid").compose(Kode::getKodeverdi));
            ifPresent(saksmappe.getReferanseArkivdel(), resource::addArkivdel, Link.apply(Arkivdel.class, "systemid").compose(Kode::getKodeverdi));

            ifPresent(saksmappe.getMerknader(), resource::setMerknad, l -> l.getListe().stream().map(SaksmappeMapper::merknad).collect(Collectors.toList()));
            //ifPresent(saksmappe.getSakspart(), resource::setPart, p -> p.getListe().stream().map(this::part).collect(Collectors.toList()));

            ifPresent(saksmappe.getKlasse(), resource::setKlasse, l -> l.getListe().stream().map(SaksmappeMapper::klasse).collect(Collectors.toList()));

            if (!titleService.parseCaseTitle(caseProperties.getTitle(), resource, saksmappe.getTittel())) {
                log.warn("Title {} does not match expected format for {}", saksmappe.getTittel(), resource.getClass());
                throw new InvalidCaseType(resource.getClass().getSimpleName());
            }
            additionalFieldService.setFieldsForResource(caseProperties.getField(), resource,
                    ofNullable(saksmappe.getTilleggsinformasjon())
                            .map(TilleggsinformasjonListe::getListe)
                            .map(List::stream)
                            .orElse(Stream.empty())
                            .filter(t -> tilleggstype.equals(t.getInformasjonstype().getKodeverdi()))
                            .map(Tilleggsinformasjon::getInformasjon)
                            .filter(s -> s.contains(": "))
                            .peek(s -> log.debug("{}", s))
                            .map(s -> new AdditionalFieldService.Field(
                                    substringBefore(s, ":"),
                                    substringAfter(s, ": ")))
                            .collect(Collectors.toList()));

            consumer.accept(saksmappe, resource);

            ofNullable(saksmappe.getMerknader())
                    .map(MerknadListe::getListe)
                    .map(List::stream)
                    .orElse(Stream.empty())
                    .forEach(m ->
                            log.info("{} : {}", m.getMerknadstype(), m.getMerknadstekst()));

            ofNullable(saksmappe.getTilleggsinformasjon())
                    .map(TilleggsinformasjonListe::getListe)
                    .map(List::stream)
                    .orElse(Stream.empty())
                    .forEach(t ->
                            log.info("{} : \"{}\"", t.getInformasjonstype().getKodeverdi(), t.getInformasjon()));

            return resource;
        };
    }

    private static KlasseResource klasse(Klasse klasse) {
        final KlasseResource resource = new KlasseResource();
        ifPresent(klasse.getKlasseID(), resource::setKlasseId);
        ifPresent(klasse.getTittel(), resource::setTittel);
        ifPresent(klasse.getRekkefoelge(), resource::setRekkefolge, Integer::parseInt);
        ifPresent(klasse.getKlassifikasjonssystem(), resource::addKlassifikasjonssystem, linkTo(KlassifikasjonssystemResource.class, "systemid"));
        return resource;
    }

    /*
    private PartsinformasjonResource part(Sakspart sakspart) {
        PartsinformasjonResource r = new PartsinformasjonResource();
        ifPresent(sakspart.getSakspartRolle(), r::addPartRolle, linkTo(Link.apply(PartRolle.class, "systemid")));
        ifPresent(sakspart.getKontakt(), r::addPart, Link.apply(Part.class, "partid").compose(SaksmappeMapper::kontakt));
        return r;
    }

     */

    public static MerknadResource merknad(Merknad merknad) {
        MerknadResource r = new MerknadResource();
        ifPresent(merknad.getMerknadRegistrertAv(), r::addMerknadRegistrertAv, Link.apply(Arkivressurs.class, "systemid"));
        ifPresent(merknad.getMerknadstype(), r::addMerknadstype, Link.apply(Merknadstype.class, "systemid"));
        ifPresent(merknad.getMerknadstekst(), r::setMerknadstekst);
        ifPresent(merknad.getMerknadsdato(), r::setMerknadsdato, FintUtils::fromXmlDate);
        return r;
    }
}
