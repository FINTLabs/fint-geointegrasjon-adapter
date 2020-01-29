package no.fint.provider.geointegrasjon.service.geointegrasjon;

import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.administrasjon.arkiv.DokumentfilResource;
import no.fint.provider.geointegrasjon.AdapterProps;
import no.fint.provider.geointegrasjon.model.FaxDocument;
import no.fint.provider.geointegrasjon.model.FaxShipment;
import no.fint.provider.geointegrasjon.model.ShipmentStatus;
import no.fint.provider.geointegrasjon.repository.InternalRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
public class GeoIntegrasjonFactory {

    @Autowired
    private AdapterProps adapterProps;

    @Autowired
    private InternalRepository internalRepository;

    public Forsendelse createForsendelse(FaxShipment fax) {
        Forsendelse forsendelse = new Forsendelse();
        forsendelse.setAvgivendeSystem("FINT");
        forsendelse.setLeveringsmetode(adapterProps.getLeveringsmetode());

        forsendelse.setMetadataFraAvleverendeSystem(createMetadataFraAvleverendeSystem(fax));

        forsendelse.setMottaker(createAdresse());
        forsendelse.setUtskriftsKonfigurasjon(createUtskriftsKonfigurasjon());
        forsendelse.setTittel(fax.getTitle());

        forsendelse.getDokumenter().addAll(createDocuments(fax));

        if (StringUtils.isNotBlank(fax.getPostamble())) {
            forsendelse.getDokumenter().add(createMetadataDokument(fax.getPostamble()));
        }
        return forsendelse;
    }

    private NoarkMetadataFraAvleverendeSaksSystem createMetadataFraAvleverendeSystem(FaxShipment fax) {
        NoarkMetadataFraAvleverendeSaksSystem metadata = new NoarkMetadataFraAvleverendeSaksSystem();
        metadata.setSaksSekvensNummer(0);
        metadata.setSaksAar(0);
        metadata.setJournalAar(0);
        metadata.setJournalSekvensNummer(0);
        metadata.setJournalPostNummer(0);

        metadata.setTittel(fax.getTitle());
        fax.getMetadata().entrySet().stream().map(this::createEntry).forEach(metadata.getEkstraMetadata()::add);
        return metadata;
    }

    private Entry createEntry(Map.Entry<String, String> input) {
        Entry entry = new Entry();
        entry.setKey(input.getKey());
        entry.setValue(input.getValue());
        return entry;
    }

    private Dokument createMetadataDokument(String json) {
        Dokument dokument = new Dokument();
        dokument.setFilnavn("metadata.json");
        dokument.setEkskluderesFraUtskrift(true);
        dokument.setSkalSigneres(false);
        dokument.setMimeType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        dokument.setData(new DataHandler(json.getBytes(StandardCharsets.UTF_8), MediaType.APPLICATION_JSON_UTF8_VALUE));
        return dokument;
    }

    private List<Dokument> createDocuments(FaxShipment fax) {
        return fax.getDocuments()
                .stream()
                .filter(document -> document.getShipmentStatus().equals(ShipmentStatus.READY))
                .map(this::createDokument)
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    private Dokument createDokument(FaxDocument document) {
        try {
            Dokument dokument = new Dokument();
            DokumentfilResource dokumentfilResource = internalRepository.getFile(document.getCacheFileId());
            dokument.setMimeType(dokumentfilResource.getFormat());
            //dokument.setFilnavn(Utils.createFileName(faxShipment, dokumentfilResource.getFormat()));
            dokument.setFilnavn(dokumentfilResource.getFilnavn());
            dokument.setEkskluderesFraUtskrift(true);
            dokument.setSkalSigneres(false);

            byte[] base64Document = Base64.getDecoder().decode(dokumentfilResource.getData());
            DataHandler dataHandler = new DataHandler(base64Document, dokumentfilResource.getFormat());
            dokument.setData(dataHandler);
            return dokument;

        } catch (Exception e) {
            log.debug("Unable to add document! {}", document, e);
            document.setShipmentStatus(ShipmentStatus.ERROR);
            document.setErrorMessage(e.toString());
        }
        return null;
    }

    private Adresse createAdresse() {
        Adresse adresse = new Adresse();
        adresse.setDigitalAdresse(createOrganisationDigialAdresse(adapterProps.getOrganisationNumber()));
        adresse.setPostAdresse(createPostAdresse());

        return adresse;
    }

    private PostAdresse createPostAdresse() {
        PostAdresse postAdresse = new PostAdresse();
        postAdresse.setNavn(adapterProps.getOrganisationName());
        postAdresse.setAdresse1(adapterProps.getOrganisationAdresse1());
        if (!Strings.isNullOrEmpty(adapterProps.getOrganisationAdresse2())) {
            postAdresse.setAdresse2(adapterProps.getOrganisationAdresse2());
        }
        if (!Strings.isNullOrEmpty(adapterProps.getOrganisationAdresse3())) {
            postAdresse.setAdresse3(adapterProps.getOrganisationAdresse3());
        }
        postAdresse.setPostNummer(adapterProps.getOrganisationPostalCode());
        postAdresse.setPostSted(adapterProps.getOrganisationPostalCode());

        return postAdresse;
    }

    private UtskriftsKonfigurasjon createUtskriftsKonfigurasjon() {
        UtskriftsKonfigurasjon utskriftsKonfigurasjon = new UtskriftsKonfigurasjon();
        utskriftsKonfigurasjon.setTosidig(true);
        utskriftsKonfigurasjon.setUtskriftMedFarger(false);

        return utskriftsKonfigurasjon;
    }

    private OrganisasjonDigitalAdresse createOrganisationDigialAdresse(String organisationNumber) {
        OrganisasjonDigitalAdresse organisasjonDigitalAdresse = new OrganisasjonDigitalAdresse();
        OrganisasjonsNummer organisasjonsNummer = new OrganisasjonsNummer();
        organisasjonsNummer.setId(organisationNumber);
        organisasjonDigitalAdresse.setOrganisasjonsNummer(organisasjonsNummer);

        return organisasjonDigitalAdresse;
    }
}
