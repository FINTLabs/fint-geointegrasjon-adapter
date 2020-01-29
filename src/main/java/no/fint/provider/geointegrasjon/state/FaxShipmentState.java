package no.fint.provider.geointegrasjon.state;

import lombok.extern.slf4j.Slf4j;
import no.fint.model.resource.kultur.kulturminnevern.TilskuddFartoyResource;
import no.fint.provider.geointegrasjon.AdapterProps;
import no.fint.provider.geointegrasjon.exception.GetTilskuddFartoyNotFoundException;
import no.fint.provider.geointegrasjon.model.FaxShipment;
import no.fint.provider.geointegrasjon.model.ShipmentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class FaxShipmentState {

    @Autowired
    private FaxShipmentRepository faxShipmentRepository;

    @Autowired
    private AdapterProps adapterProps;

    @Autowired
    private FaxShipmentFactory faxShipmentFactory;

    public FaxShipment getById(String id) {
        FaxShipment faxShipment = faxShipmentRepository.findById(id);
        if (faxShipment == null) {
            throw new GetTilskuddFartoyNotFoundException("Case could not be found");
        }
        return faxShipment;
    }

    public FaxShipment getByApplicationId(String applicationId) {
        FaxShipment faxShipment = faxShipmentRepository.findByApplicationId(applicationId);
        if (faxShipment == null) {
            throw new GetTilskuddFartoyNotFoundException("Case could not be found");
        }
        return faxShipment;
    }

    public FaxShipment getBySvarUtShipmentId(String svarUtShipmentId) {
        FaxShipment faxShipment = faxShipmentRepository.findBySvarUtShipmentId(svarUtShipmentId);
        log.info("faxShipment: {}", faxShipment);
        if (faxShipment == null) {
            throw new GetTilskuddFartoyNotFoundException("Case could not be found");
        }
        return faxShipment;
    }

    public void createFaxShipment(TilskuddFartoyResource tilskuddFartoy) {
        save(faxShipmentFactory.tilskuddFartoyToFaxShipment(tilskuddFartoy, adapterProps.getOrgId()));
    }

    public void updateFaxShipment(TilskuddFartoyResource tilskuddFartoy, String applicationId) {
        FaxShipment faxShipment = getByApplicationId(applicationId);
        faxShipment.getDocuments().addAll(faxShipmentFactory.getFaxDocumentsFromJournalpost(tilskuddFartoy.getJournalpost()));
        save(faxShipment);
    }

    public void save(FaxShipment fax) {
        faxShipmentRepository.save(fax);
    }

    public List<FaxShipment> getNotSent() {
        return faxShipmentRepository.findByOrgIdAndDocumentsShipmentStatus(ShipmentStatus.READY.name(), adapterProps.getOrgId());
    }

    public List<FaxShipment> getAll() {
        return faxShipmentRepository.findAllByOrgId(adapterProps.getOrgId());
    }

}
