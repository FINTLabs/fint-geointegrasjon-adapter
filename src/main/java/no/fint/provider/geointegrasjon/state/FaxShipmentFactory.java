package no.fint.provider.geointegrasjon.state;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.Link;
import no.fint.model.resource.administrasjon.arkiv.DokumentbeskrivelseResource;
import no.fint.model.resource.administrasjon.arkiv.DokumentobjektResource;
import no.fint.model.resource.administrasjon.arkiv.JournalpostResource;
import no.fint.model.resource.kultur.kulturminnevern.TilskuddFartoyResource;
import no.fint.provider.geointegrasjon.model.FaxDocument;
import no.fint.provider.geointegrasjon.model.FaxShipment;
import no.fint.provider.geointegrasjon.model.ShipmentStatus;
import no.fint.provider.geointegrasjon.service.fint.TilskuddFartoyFactory;
import no.fint.provider.geointegrasjon.service.fint.TitleService;
import no.fint.provider.geointegrasjon.utils.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class FaxShipmentFactory {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TitleService titleService;

    public FaxShipment tilskuddFartoyToFaxShipment(TilskuddFartoyResource tilskuddFartoy, String orgId) {
        FaxShipment fax = new FaxShipment();
        fax.setApplicationId(tilskuddFartoy.getSoknadsnummer().getIdentifikatorverdi());
        fax.setTitle(titleService.getTitle(tilskuddFartoy));
        HashMap<String, String> metadata = new HashMap<>();
        metadata.put(TilskuddFartoyFactory.FARTOYNAVN, tilskuddFartoy.getFartoyNavn());
        metadata.put(TilskuddFartoyFactory.DIGISAKSNUMMER, tilskuddFartoy.getSoknadsnummer().getIdentifikatorverdi());
        metadata.put(TilskuddFartoyFactory.KULTURMINNEID, tilskuddFartoy.getKulturminneId());
        metadata.put(TilskuddFartoyFactory.KALLESIGNAL, tilskuddFartoy.getKallesignal());
        try {
            fax.setPostamble(objectMapper
                    .enable(SerializationFeature.INDENT_OUTPUT)
                    .setSerializationInclusion(JsonInclude.Include.NON_EMPTY)
                    .writeValueAsString(tilskuddFartoy));
        } catch (JsonProcessingException ignore) {
        }
        fax.setMetadata(metadata);
        fax.setType("Tilskudd fartøy");
        fax.setOrgId(orgId);
        fax.setCreatedDate(new Date());
        fax.setDocuments(getFaxDocumentsFromJournalpost(tilskuddFartoy.getJournalpost()));
        return fax;
    }

    public List<FaxDocument> getFaxDocumentsFromJournalpost(List<JournalpostResource> journalposts) {
        return journalposts
                .stream()
                .map(JournalpostResource::getDokumentbeskrivelse)
                .flatMap(List::stream)
                .map(DokumentbeskrivelseResource::getDokumentobjekt)
                .flatMap(List::stream)
                .map(DokumentobjektResource::getReferanseDokumentfil)
                .flatMap(List::stream)
                .map(Link::getHref)
                .peek(log::debug)
                .map(uri ->
                        FaxDocument.builder()
                                .cacheFileId(UrlUtils.getFileIdFromUri(uri))
                                .shipmentStatus(ShipmentStatus.READY)
                                .fileUri(uri)
                                .build())
                .collect(Collectors.toCollection(ArrayList::new));
    }

}
