package no.fint.geointegrasjon.model.noark;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.service.geointegrasjon.ClientException;
import no.fint.geointegrasjon.service.geointegrasjon.InnsynServiceFacade;
import no.fint.geointegrasjon.utils.FintUtils;
import no.fint.model.administrasjon.arkiv.JournalStatus;
import no.fint.model.administrasjon.arkiv.JournalpostType;
import no.fint.model.administrasjon.arkiv.KorrespondansepartType;
import no.fint.model.felles.kodeverk.iso.Landkode;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;
import no.fint.model.resource.Link;
import no.fint.model.resource.administrasjon.arkiv.DokumentbeskrivelseResource;
import no.fint.model.resource.administrasjon.arkiv.JournalpostResource;
import no.fint.model.resource.administrasjon.arkiv.KorrespondansepartResource;
import no.fint.model.resource.felles.kompleksedatatyper.AdresseResource;
import no.geointegrasjon.arkiv.innsyn.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Optional.ofNullable;
import static no.fint.geointegrasjon.utils.FintUtils.ifPresent;
import static no.fint.geointegrasjon.utils.FintUtils.linkTo;

@Service
@Slf4j
public class JournalpostMapper {

    @Autowired
    private InnsynServiceFacade innsynServiceFacade;

    @Autowired
    private DokumentbeskrivelseMapper dokumentbeskrivelseMapper;

    public Function<Journalpost, JournalpostResource> toFintResource(Supplier<JournalpostResource> supplier) {
        return journalpost -> {
            JournalpostResource resource = supplier.get();
            log.info("Journalpost SystemID {} for sak {}", journalpost.getSystemID(), journalpost.getReferanseSakSystemID().getSystemID().getId());
            ifPresent(journalpost.getTittel(), resource::setTittel);
            ifPresent(journalpost.getOffentligTittel(), resource::setOffentligTittel);

            ifPresent(journalpost.getJournaldato(), resource::setJournalDato, FintUtils::fromXmlDate);
            ifPresent(journalpost.getDokumentetsDato(), resource::setDokumentetsDato, FintUtils::fromXmlDate);
            ifPresent(journalpost.getForfallsdato(), resource::setForfallsDato, FintUtils::fromXmlDate);

            ifPresent(journalpost.getAntallVedlegg(), resource::setAntallVedlegg, Long::valueOf);

            ifPresent(journalpost.getJournalnummer(), resource::setJournalAr, j -> j.getJournalaar().toString());
            ifPresent(journalpost.getJournalnummer(), resource::setJournalSekvensnummer, j -> j.getJournalsekvensnummer().longValueExact());
            ifPresent(journalpost.getJournalpostnummer(), resource::setJournalPostnummer, Long::valueOf);

            ifPresent(journalpost.getAntallVedlegg(), resource::setAntallVedlegg, Long::valueOf);

            ifPresent(journalpost.getMerknader(), resource::setMerknad, l -> l.getListe().stream().map(SaksmappeMapper::merknad).collect(Collectors.toList()));

            ifPresent(journalpost.getKorrespondansepart(), resource::setKorrespondansepart, p -> p.getListe().stream().map(this::part).collect(Collectors.toList()));

            ifPresent(journalpost.getJournalposttype(), resource::addJournalposttype, Link.apply(JournalpostType.class, "systemid").compose(Kode::getKodeverdi));
            ifPresent(journalpost.getJournalstatus(), resource::addJournalstatus, Link.apply(JournalStatus.class, "systemid").compose(Kode::getKodeverdi));

            resource.setDokumentbeskrivelse(new LinkedList<>());
            try {
                innsynServiceFacade
                        .finnDokumenterGittJournalSystemID(journalpost.getSystemID())
                        .getListe()
                        .stream()
                        .map(dokumentbeskrivelseMapper.toFintResource(DokumentbeskrivelseResource::new))
                        .forEach(resource.getDokumentbeskrivelse()::add);
            } catch (ClientException e) {
                log.debug("No documents found for {}", journalpost.getSystemID());
            }

            ofNullable(journalpost.getMerknader())
                    .map(MerknadListe::getListe)
                    .map(List::stream)
                    .orElse(Stream.empty())
                    .forEach(m ->
                            log.debug("{} : {}", m.getMerknadstype(), m.getMerknadstekst()));

            ofNullable(journalpost.getTilleggsinformasjon())
                    .map(TilleggsinformasjonListe::getListe)
                    .map(List::stream)
                    .orElse(Stream.empty())
                    .forEach(t ->
                            log.debug("{} : \"{}\"", t.getInformasjonstype().getKodeverdi(), t.getInformasjon()));


            return resource;
        };
    }

    private KorrespondansepartResource part(Korrespondansepart korrespondansepart) {
        KorrespondansepartResource r = new KorrespondansepartResource();
        ifPresent(korrespondansepart.getKorrespondanseparttype(), r::addKorrespondanseparttype, linkTo(Link.apply(KorrespondansepartType.class, "systemid")));
        final Kontakt kontakt = korrespondansepart.getKontakt();
        ifPresent(kontakt.getNavn(), r::setKorrespondansepartNavn);

        if (kontakt instanceof Person) {
            updateKorrespondansepartPerson(r, (Person) kontakt);
        } else if (kontakt instanceof Organisasjon) {
            updateKorrespondansepartOrganisasjon(r, (Organisasjon) kontakt);
        }

        ofNullable(kontakt.getAdresser())
                .map(EnkelAdresseListe::getListe)
                .map(List::stream)
                .orElse(Stream.empty())
                .forEach(setAdresse(r));

        Kontaktinformasjon k = new Kontaktinformasjon();

        ofNullable(kontakt.getElektroniskeAdresser())
                .map(ElektroniskAdresseListe::getListe)
                .map(List::stream)
                .orElse(Stream.empty())
                .forEach(kontaktinformasjon(k));
        r.setKontaktinformasjon(k);

        return r;
    }

    private Consumer<? super ElektroniskAdresse> kontaktinformasjon(Kontaktinformasjon k) {
        return ea -> {
            if (ea instanceof Epost) {
                epostAdresse((Epost)ea, k);
            } else if (ea instanceof Telefon) {
                telefonnummer((Telefon)ea, k);
            }
        };
    }

    private void telefonnummer(Telefon telefon, Kontaktinformasjon k) {
        final String tlf = StringUtils.deleteWhitespace(telefon.getTelefonnummer());
        if (StringUtils.startsWithAny(tlf, "9", "4", "+479", "+474")) {
            k.setMobiltelefonnummer(tlf);
        } else {
            k.setTelefonnummer(tlf);
        }
    }

    private void epostAdresse(Epost epost, Kontaktinformasjon k) {
        k.setEpostadresse(epost.getEpostadresse());
    }

    private Consumer<? super EnkelAdresse> setAdresse(KorrespondansepartResource r) {
        return a -> {
            AdresseResource ar = new AdresseResource();
            List<String> adresselinjer = new LinkedList<>();
            ifPresent(a.getAdresselinje1(), adresselinjer::add);
            ifPresent(a.getAdresselinje2(), adresselinjer::add);
            ar.setAdresselinje(adresselinjer);
            ofNullable(a.getPostadresse()).map(PostadministrativeOmraader::getPostnummer).ifPresent(ar::setPostnummer);
            ofNullable(a.getPostadresse()).map(PostadministrativeOmraader::getPoststed).ifPresent(ar::setPoststed);
            ifPresent(a.getLandkode(), ar::addLand, linkTo(Link.apply(Landkode.class, "systemid")));
            r.setAdresse(ar);
        };
    }

    private void updateKorrespondansepartOrganisasjon(KorrespondansepartResource r, Organisasjon organisasjon) {
        ifPresent(organisasjon.getOrganisasjonsnummer(), r::setOrganisasjonsnummer);
    }

    private void updateKorrespondansepartPerson(KorrespondansepartResource r, Person person) {
        ifPresent(person.getPersonid(), r::setFodselsnummer, Personidentifikator::getPersonidentifikatorNr);
        List<String> names = new LinkedList<>();
        ifPresent(person.getFornavn(), names::add);
        ifPresent(person.getEtternavn(), names::add);
        r.setKontaktperson(String.join(" ", names));
    }

}
