package no.fint.geointegrasjon.service.geointegrasjon;

import lombok.extern.slf4j.Slf4j;
import no.fint.arkiv.AdditionalFieldService;
import no.fint.arkiv.CaseProperties;
import no.fint.arkiv.TitleService;
import no.fint.geointegrasjon.utils.FintUtils;
import no.fint.geointegrasjon.utils.UrlUtils;
import no.fint.model.felles.kompleksedatatyper.Kontaktinformasjon;
import no.fint.model.resource.Link;
import no.fint.model.resource.arkiv.noark.*;
import no.fint.model.resource.felles.kompleksedatatyper.AdresseResource;
import no.geointegrasjon.arkiv.oppdatering.*;
import org.apache.commons.lang3.StringUtils;
import org.jooq.lambda.function.Consumer2;
import org.jooq.lambda.tuple.Tuple;
import org.jooq.lambda.tuple.Tuple2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static no.fint.geointegrasjon.utils.FintUtils.toXmlDate;
import static org.apache.commons.lang3.StringUtils.isNoneBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Slf4j
@Service
public class GeoIntegrasjonFactory {

    private final ObjectFactory objectFactory = new ObjectFactory();
    private final String fagsystem, tilleggstype;
    private final TitleService titleService;
    private final AdditionalFieldService additionalFieldService;

    public GeoIntegrasjonFactory(
            @Value("${fint.geointegrasjon.fagsystem}") String fagsystem,
            @Value("${fint.geointegrasjon.tilleggstype}") String tilleggstype,
            TitleService titleService,
            AdditionalFieldService additionalFieldService) {
        this.fagsystem = fagsystem;
        this.tilleggstype = tilleggstype;
        this.titleService = titleService;
        this.additionalFieldService = additionalFieldService;
    }

    public <T extends SaksmappeResource> Saksmappe newSak(CaseProperties caseProperties, T resource, String externalID, Consumer2<T, Saksmappe> consumer) {
        Saksmappe saksmappe = objectFactory.createSaksmappe();

        saksmappe.setTittel(titleService.getCaseTitle(caseProperties.getTitle(), resource));
        addTilleggsinformasjon(saksmappe,
                additionalFieldService.getFieldsForResource(caseProperties.getField(), resource)
                        .map(f -> newTilleggsinformasjon(tilleggstype, String.format("%s: %s", f.getName(), f.getValue())))
                        .toArray(Tilleggsinformasjon[]::new));
        saksmappe.setOffentligTittel(resource.getOffentligTittel());

        setKodeverdiFromLink(resource.getAdministrativEnhet(), saksmappe::setAdministrativEnhetInit);
        setKodeverdiFromLink(resource.getSaksansvarlig(), saksmappe::setSaksansvarligInit);

        setKodeverdiFromLink(resource.getArkivdel(), objectFactory::createArkivdel, saksmappe::setReferanseArkivdel);
        setKodeverdiFromLink(resource.getJournalenhet(), objectFactory::createJournalenhet, saksmappe::setJournalenhet);
        setKodeverdiFromLink(resource.getSaksstatus(), objectFactory::createSaksstatus, saksmappe::setSaksstatus);

        if (isNoneBlank(fagsystem, externalID)) {
            EksternNoekkel eksternNoekkel = objectFactory.createEksternNoekkel();
            eksternNoekkel.setFagsystem(fagsystem);
            eksternNoekkel.setNoekkel(externalID);
            saksmappe.setReferanseEksternNoekkel(eksternNoekkel);
        }

        saksmappe.setKlasse(newKlasseListe(resource.getKlasse()));

        consumer.accept(resource, saksmappe);

        return saksmappe;
    }

    private KlasseListe newKlasseListe(List<KlasseResource> resources) {
        if (resources == null || resources.isEmpty()) {
            return null;
        }
        final KlasseListe liste = new KlasseListe();
        resources.stream().map(this::newKlasse).forEach(liste.getListe()::add);
        return liste;
    }

    private Klasse newKlasse(KlasseResource resource) {
        final Klasse klasse = objectFactory.createKlasse();
        klasse.setKlasseID(resource.getKlasseId());
        klasse.setTittel(resource.getTittel());
        klasse.setRekkefoelge(String.valueOf(resource.getRekkefolge()));
        setKodeverdiFromLink(resource.getKlassifikasjonssystem(), objectFactory::createKlassifikasjonssystem, klasse::setKlassifikasjonssystem);
        return klasse;
    }


    public Tuple2<Journalpost, List<Tuple2<Dokument, String>>> newJournalpost(String caseId, JournalpostResource resource) {
        Journalpost journalpost = objectFactory.createJournalpost();
        journalpost.setReferanseSakSystemID(newSakSystemId(caseId));

        journalpost.setAntallVedlegg(Objects.toString(resource.getAntallVedlegg(), "0"));
        journalpost.setDokumentetsDato(toXmlDate(resource.getDokumentetsDato()));
        journalpost.setForfallsdato(toXmlDate(resource.getForfallsDato()));
        journalpost.setJournaldato(toXmlDate(resource.getJournalDato()));
        journalpost.setJournalpostnummer(String.valueOf(resource.getJournalPostnummer()));
        journalpost.setOffentligTittel(resource.getOffentligTittel());
        journalpost.setTittel(resource.getTittel());

        final KorrespondansepartListe korrespondansepartListe = objectFactory.createKorrespondansepartListe();
        Optional.ofNullable(resource.getKorrespondansepart())
                .map(List::stream)
                .orElse(Stream.empty())
                .map(this::newKorrespondansepart)
                .forEach(korrespondansepartListe.getListe()::add);

        korrespondansepartListe.getListe().add(newInternKorrespondansepart(resource));

        journalpost.setKorrespondansepart(korrespondansepartListe);

        setKodeverdiFromLink(resource.getJournalposttype(), objectFactory::createJournalposttype, journalpost::setJournalposttype);
        setKodeverdiFromLink(resource.getJournalstatus(), objectFactory::createJournalstatus, journalpost::setJournalstatus);
        //setKodeverdiFromLink(resource.getArkivdel(), objectFactory::createArkivdel, journalpost::setReferanseArkivdel);

        return Tuple.tuple(journalpost, resource.getDokumentbeskrivelse().stream().flatMap(this::newDokument).collect(Collectors.toList()));
    }

    private Korrespondansepart newInternKorrespondansepart(JournalpostResource resource) {
        Korrespondansepart korrespondansepart = objectFactory.createKorrespondansepart();
        //setKodeverdiFromLink(resource.getAdministrativEnhet(), korrespondansepart::setAdministrativEnhetInit);
        setKodeverdiFromLink(resource.getAdministrativEnhet(), korrespondansepart::setAdministrativEnhet);
        setKodeverdiFromLink(resource.getJournalenhet(), objectFactory::createJournalenhet, korrespondansepart::setJournalenhet);
        setKodeverdiFromLink(resource.getSaksbehandler(), korrespondansepart::setSaksbehandlerInit);
        setKodeverdiFromLink(resource.getSaksbehandler(), korrespondansepart::setSaksbehandler);

        Kontakt kontakt = objectFactory.createKontakt();
        setKodeverdiFromLink(resource.getSaksbehandler(), kontakt::setNavn);

        korrespondansepart.setBehandlingsansvarlig("1"); // Ref 4.1.11 in the standard
        korrespondansepart.setKontakt(kontakt);

        final Korrespondanseparttype korrespondanseparttype = objectFactory.createKorrespondanseparttype();
        korrespondanseparttype.setKodeverdi("IA"); // TODO
        korrespondansepart.setKorrespondanseparttype(korrespondanseparttype);
        return korrespondansepart;
    }

    private Korrespondansepart newKorrespondansepart(KorrespondansepartResource resource) {
        Korrespondansepart result = objectFactory.createKorrespondansepart();

        setKodeverdiFromLink(resource.getKorrespondanseparttype(), objectFactory::createKorrespondanseparttype, result::setKorrespondanseparttype);
        final Kontakt kontakt;
        if (isNotBlank(resource.getOrganisasjonsnummer())) {
            kontakt = createOrganisasjon(resource);
        } else if (isNotBlank(resource.getFodselsnummer())) {
            kontakt = createPerson(resource);
        } else {
            kontakt = objectFactory.createKontakt();
        }
        kontakt.setNavn(resource.getKorrespondansepartNavn());
        kontakt.setAdresser(createAdresser(resource.getAdresse()));
        kontakt.setElektroniskeAdresser(createElektroniskeAdresser(resource.getKontaktinformasjon()));

        result.setKontakt(kontakt);
        return result;
    }

    private ElektroniskAdresseListe createElektroniskeAdresser(Kontaktinformasjon resource) {
        if (resource == null) {
            return null;
        }
        ElektroniskAdresseListe result = objectFactory.createElektroniskAdresseListe();

        if (isNotBlank(resource.getEpostadresse())) {
            Epost epost = objectFactory.createEpost();
            epost.setEpostadresse(resource.getEpostadresse());
            result.getListe().add(epost);
        }

        if (isNotBlank(resource.getMobiltelefonnummer())) {
            Telefon telefon = objectFactory.createTelefon();
            telefon.setTelefonnummer(resource.getMobiltelefonnummer());
            result.getListe().add(telefon);
        }

        if (isNotBlank(resource.getTelefonnummer())) {
            Telefon telefon = objectFactory.createTelefon();
            telefon.setTelefonnummer(resource.getTelefonnummer());
            result.getListe().add(telefon);
        }

        return result;
    }

    private EnkelAdresseListe createAdresser(AdresseResource resource) {
        if (resource == null) {
            return null;
        }
        EnkelAdresseListe result = objectFactory.createEnkelAdresseListe();

        EnkelAdresse adresse = objectFactory.createEnkelAdresse();

        setKodeverdi(objectFactory::createEnkelAdressetype, "P", adresse::setAdressetype);
        setKodeverdiFromLink(resource.getLand(), objectFactory::createLandkode, adresse::setLandkode);

        if (resource.getAdresselinje() != null && !resource.getAdresselinje().isEmpty()) {
            adresse.setAdresselinje1(resource.getAdresselinje().get(0));
            if (resource.getAdresselinje().size() > 1) {
                adresse.setAdresselinje2(resource.getAdresselinje().get(1));
            }
        }

        PostadministrativeOmraader postadresse = objectFactory.createPostadministrativeOmraader();
        postadresse.setPostnummer(resource.getPostnummer());
        postadresse.setPoststed(resource.getPoststed());
        adresse.setPostadresse(postadresse);

        result.getListe().add(adresse);

        return result;
    }

    private Person createPerson(KorrespondansepartResource resource) {
        Person person = objectFactory.createPerson();
        Personidentifikator personidentifikator = objectFactory.createPersonidentifikator();
        personidentifikator.setPersonidentifikatorNr(resource.getFodselsnummer());
        setKodeverdi(objectFactory::createPersonidentifikatorType, "F", personidentifikator::setPersonidentifikatorType);
        person.setPersonid(personidentifikator);

        if (isNotBlank(resource.getKontaktperson())) {
            setNavn(resource.getKontaktperson(), person);
        } else {
            setNavn(resource.getKorrespondansepartNavn(), person);
        }

        return person;
    }

    private void setNavn(String navn, Person person) {
        if (StringUtils.contains(navn, ", ")) {
            person.setEtternavn(StringUtils.substringBefore(navn, ", "));
            person.setFornavn(StringUtils.substringAfter(navn, ", "));
        } else {
            person.setEtternavn(StringUtils.substringAfterLast(navn, " "));
            person.setFornavn(StringUtils.substringBeforeLast(navn, " "));
        }
    }

    private Organisasjon createOrganisasjon(KorrespondansepartResource resource) {
        Organisasjon organisasjon = objectFactory.createOrganisasjon();
        organisasjon.setOrganisasjonsnummer(resource.getOrganisasjonsnummer());
        return organisasjon;
    }

    private Stream<Tuple2<Dokument, String>> newDokument(DokumentbeskrivelseResource db) {
        return db.getDokumentobjekt().stream().flatMap(dobj -> dobj.getReferanseDokumentfil().stream().map(Link::getHref).map(UrlUtils::getFileIdFromUri).map(fileId -> {
            Dokument dokument = objectFactory.createDokument();

            dokument.setTittel(db.getTittel());
            FintUtils.ifPresent(db.getDokumentnummer(), dokument::setDokumentnummer, String::valueOf);
            dokument.setFormat(setKodeverdi(objectFactory::createFormat, dobj.getFormat()));

            setKodeverdiFromLink(db.getDokumentType(), objectFactory::createDokumenttype, dokument::setDokumenttype);
            setKodeverdiFromLink(db.getDokumentstatus(), objectFactory::createDokumentstatus, dokument::setDokumentstatus);
            setKodeverdiFromLink(db.getTilknyttetRegistreringSom(), objectFactory::createTilknyttetRegistreringSom, dokument::setTilknyttetRegistreringSom);
            setKodeverdiFromLink(dobj.getVariantFormat(), objectFactory::createVariantformat, dokument::setVariantformat);

            return Tuple.tuple(dokument, fileId);
        }));
    }

    private <T extends Kode> void setKodeverdiFromLink(List<Link> links, Supplier<T> supplier, Consumer<T> consumer) {
        links.stream().map(Link::getHref).map(UrlUtils::getFileIdFromUri).filter(StringUtils::isNotBlank).forEach(id -> {
            T item = supplier.get();
            item.setKodeverdi(id);
            consumer.accept(item);
        });
    }

    private void setKodeverdiFromLink(List<Link> links, Consumer<String> consumer) {
        links.stream().map(Link::getHref).map(UrlUtils::getFileIdFromUri).filter(StringUtils::isNotBlank).forEach(consumer);
    }

    private <T extends Kode> T setKodeverdi(Supplier<T> supplier, String kodeverdi) {
        T result = supplier.get();
        result.setKodeverdi(kodeverdi);
        return result;
    }

    private <T extends Kode> void setKodeverdi(Supplier<T> supplier, String kodeverdi, Consumer<T> consumer) {
        T result = supplier.get();
        result.setKodeverdi(kodeverdi);
        consumer.accept(result);
    }

    private SakSystemId newSakSystemId(String caseId) {
        SystemID systemID = objectFactory.createSystemID();
        systemID.setId(caseId);
        SakSystemId sakSystemId = objectFactory.createSakSystemId();
        sakSystemId.setSystemID(systemID);
        return sakSystemId;
    }

    public Filinnhold newFil(DokumentfilResource dokumentfilResource) {
        Filinnhold fil = objectFactory.createFilinnhold();
        fil.setBase64(Base64.getDecoder().decode(dokumentfilResource.getData()));
        fil.setFilnavn(dokumentfilResource.getFilnavn());
        fil.setMimeType(dokumentfilResource.getFormat());
        return fil;
    }

    public Tilleggsinformasjon newTilleggsinformasjon(String kodeverdi, String informasjon) {
        final Tilleggsinformasjon tilleggsinformasjon = objectFactory.createTilleggsinformasjon();
        setKodeverdi(objectFactory::createInformasjonstype, kodeverdi, tilleggsinformasjon::setInformasjonstype);
        tilleggsinformasjon.setInformasjon(informasjon);
        return tilleggsinformasjon;
    }

    public void addTilleggsinformasjon(Saksmappe saksmappe, Tilleggsinformasjon... tillegg) {
        final TilleggsinformasjonListe tilleggsinformasjonListe = objectFactory.createTilleggsinformasjonListe();
        Arrays.stream(tillegg).forEach(tilleggsinformasjonListe.getListe()::add);
        saksmappe.setTilleggsinformasjon(tilleggsinformasjonListe);
    }
}
