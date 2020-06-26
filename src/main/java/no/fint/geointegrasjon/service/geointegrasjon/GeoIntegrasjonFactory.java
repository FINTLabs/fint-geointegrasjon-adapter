package no.fint.geointegrasjon.service.geointegrasjon;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.utils.FintUtils;
import no.fint.geointegrasjon.utils.UrlUtils;
import no.fint.model.resource.Link;
import no.fint.model.resource.administrasjon.arkiv.*;
import no.geointegrasjon.arkiv.oppdatering.*;
import org.apache.commons.lang3.StringUtils;
import org.jooq.lambda.function.Consumer2;
import org.jooq.lambda.tuple.Tuple;
import org.jooq.lambda.tuple.Tuple2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static no.fint.geointegrasjon.utils.FintUtils.toXmlDate;

@Slf4j
@Service
public class GeoIntegrasjonFactory {

    private final ObjectFactory objectFactory = new ObjectFactory();
    private final String fagsystem;

    public GeoIntegrasjonFactory(
            @Value("${fint.geointegrasjon.fagsystem}") String fagsystem) {
        this.fagsystem = fagsystem;
    }

    public <T extends SaksmappeResource> Saksmappe newSak(T resource, String externalID, Consumer2<T, Saksmappe> consumer) {
        Saksmappe saksmappe = objectFactory.createSaksmappe();

        saksmappe.setTittel(resource.getTittel());
        saksmappe.setOffentligTittel(resource.getOffentligTittel());

        setKodeverdiFromLink(resource.getAdministrativEnhet(), saksmappe::setAdministrativEnhet);
        setKodeverdiFromLink(resource.getSaksansvarlig(), saksmappe::setSaksansvarligInit);

        setKodeverdiFromLink(resource.getArkivdel(), objectFactory::createArkivdel, saksmappe::setReferanseArkivdel);
        setKodeverdiFromLink(resource.getJournalenhet(), objectFactory::createJournalenhet, saksmappe::setJournalenhet);
        setKodeverdiFromLink(resource.getSaksstatus(), objectFactory::createSaksstatus, saksmappe::setSaksstatus);

        if (StringUtils.isNotBlank(externalID)) {
            EksternNoekkel eksternNoekkel = objectFactory.createEksternNoekkel();
            eksternNoekkel.setFagsystem(fagsystem);
            eksternNoekkel.setNoekkel(externalID);
            saksmappe.setReferanseEksternNoekkel(eksternNoekkel);
        }

        consumer.accept(resource, saksmappe);

        return saksmappe;
    }


    public Tuple2<Journalpost, List<Tuple2<Dokument, String>>> newJournalpost(String caseId, JournalpostResource resource) {
        Journalpost journalpost = objectFactory.createJournalpost();
        journalpost.setReferanseSakSystemID(newSakSystemId(caseId));

        journalpost.setAntallVedlegg(String.valueOf(resource.getAntallVedlegg()));
        journalpost.setDokumentetsDato(toXmlDate(resource.getDokumentetsDato()));
        journalpost.setForfallsdato(toXmlDate(resource.getForfallsDato()));
        journalpost.setJournaldato(toXmlDate(resource.getJournalDato()));
        journalpost.setJournalpostnummer(String.valueOf(resource.getJournalPostnummer()));
        journalpost.setOffentligTittel(resource.getOffentligTittel());
        journalpost.setTittel(resource.getTittel());

        final KorrespondansepartListe korrespondansepartListe = objectFactory.createKorrespondansepartListe();
        Optional.ofNullable(resource.getKorrespondansepart()).map(List::stream).orElse(Stream.empty()).map(this::newKorrespondansepart).forEach(korrespondansepartListe.getListe()::add);
        journalpost.setKorrespondansepart(korrespondansepartListe);

        setKodeverdiFromLink(resource.getJournalposttype(), objectFactory::createJournalposttype, journalpost::setJournalposttype);
        setKodeverdiFromLink(resource.getJournalstatus(), objectFactory::createJournalstatus, journalpost::setJournalstatus);

        return Tuple.tuple(journalpost, resource.getDokumentbeskrivelse().stream().flatMap(this::newDokument).collect(Collectors.toList()));
    }

    private Korrespondansepart newKorrespondansepart(KorrespondansepartResource resource) {
        Korrespondansepart result = objectFactory.createKorrespondansepart();

        setKodeverdiFromLink(resource.getKorrespondanseparttype(), objectFactory::createKorrespondanseparttype, result::setKorrespondanseparttype);
        final Kontakt kontakt = objectFactory.createKontakt();
        kontakt.setNavn(resource.getKorrespondansepartNavn());
        result.setKontakt(kontakt);
        return result;
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
