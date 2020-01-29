package no.fint.provider.geointegrasjon.service.fint;

import no.fint.arkiv.geointegrasjon.ForsendelsesStatus;
import no.fint.model.administrasjon.arkiv.DokumentStatus;
import no.fint.model.resource.Link;
import no.fint.model.resource.administrasjon.arkiv.DokumentbeskrivelseResource;
import no.fint.model.resource.administrasjon.arkiv.DokumentobjektResource;
import no.fint.model.resource.administrasjon.arkiv.JournalpostResource;
import no.fint.model.resource.administrasjon.arkiv.SaksmappeResource;
import no.fint.provider.geointegrasjon.model.FaxDocument;
import no.fint.provider.geointegrasjon.model.FaxShipment;
import no.fint.provider.geointegrasjon.model.ShipmentStatus;
import no.fint.provider.geointegrasjon.service.geointegrasjon.GeoIntegrasjonService;
import no.fint.provider.geointegrasjon.utils.FintUtils;

import javax.xml.ws.soap.SOAPFaultException;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class SaksmappeFactory {
    public static final String FEIL_VED_SENDING_TIL_SVARUT = "FEIL_VED_SENDING_TIL_SVARUT";
    public static final String KLART_TIL_SVARUT = "KLART_TIL_SVARUT";
    public static final String FINNER_IKKE_DOKUMENTET_I_SVARUT = "FINNER_IKKE_DOKUMENTET_I_SVARUT";

    private final GeoIntegrasjonService geointegrasjonService;

    protected SaksmappeFactory(GeoIntegrasjonService geointegrasjonService) {
        this.geointegrasjonService = geointegrasjonService;
    }

    protected void updateSaksmappeFromFaxShipment(FaxShipment faxShipment, SaksmappeResource saksmappeResource) {
        saksmappeResource.setSystemId(FintUtils.createIdentifikator(faxShipment.getId()));

        saksmappeResource.setTittel(faxShipment.getTitle());
        saksmappeResource.setJournalpost(
                faxShipment
                        .getDocuments()
                        .stream()
                        .map(this::getJournalpostFromFaxDocument)
                        .collect(Collectors.toList())
        );

    }

    protected JournalpostResource getJournalpostFromFaxDocument(FaxDocument doc) {
        JournalpostResource journalpostResource = new JournalpostResource();
        journalpostResource.setRegistreringsId(doc.getSvarUtShipmentId());
        journalpostResource.setTittel("Sendt via SvarUT");
        journalpostResource.setBeskrivelse(doc.getErrorMessage());
        DokumentbeskrivelseResource dokumentbeskrivelseResource = new DokumentbeskrivelseResource();
        if (doc.getShipmentStatus().equals(ShipmentStatus.ERROR)) {
            dokumentbeskrivelseResource.addDokumentstatus(Link.with(DokumentStatus.class, "systemid", FEIL_VED_SENDING_TIL_SVARUT));
        } else if (doc.getShipmentStatus().equals(ShipmentStatus.READY)) {
            dokumentbeskrivelseResource.addDokumentstatus(Link.with(DokumentStatus.class, "systemid", KLART_TIL_SVARUT));
        } else {
            try {
                ForsendelsesStatus forsendelsesStatus = geointegrasjonService.getForsendelsesStatus(doc.getSvarUtShipmentId());
                dokumentbeskrivelseResource.addDokumentstatus(Link.with(DokumentStatus.class, "systemid", forsendelsesStatus.getStatus().name()));
            } catch (SOAPFaultException e) {
                dokumentbeskrivelseResource.addDokumentstatus(Link.with(DokumentStatus.class, "systemid", FINNER_IKKE_DOKUMENTET_I_SVARUT));
            }

        }
        DokumentobjektResource dokumentobjektResource = new DokumentobjektResource();
        dokumentobjektResource.addReferanseDokumentfil(Link.with(doc.getFileUri()));
        dokumentbeskrivelseResource.setDokumentobjekt(Collections.singletonList(dokumentobjektResource));
        journalpostResource.setDokumentbeskrivelse(Collections.singletonList(dokumentbeskrivelseResource));
        return journalpostResource;
    }
}
