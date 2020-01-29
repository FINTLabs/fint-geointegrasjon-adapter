package no.fint.provider.geointegrasjon.state;

import no.fint.provider.geointegrasjon.model.FaxShipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FaxShipmentRepository extends MongoRepository<FaxShipment, String> {
    FaxShipment findById(String id);

    FaxShipment findByApplicationId(String applicationId);

    @Query("{'documents.svarUtShipmentId': ?0}")
    FaxShipment findBySvarUtShipmentId(String svarUtShipmentId);

    @Query("{'documents.shipmentStatus': ?0, orgId: ?1}")
    List<FaxShipment> findByOrgIdAndDocumentsShipmentStatus(String shipmentStatus, String orgId);

    List<FaxShipment> findAllByOrgId(String orgId);

}
