package no.fint.provider.geointegrasjon.model;

import lombok.Builder;
import lombok.Data;
import no.fint.arkiv.geointegrasjon.Status;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document
public class FaxDocument {
    private String cacheFileId;
    private String fileUri;
    private ShipmentStatus shipmentStatus;
    private Date shipmentTime;
    private Status svarUtFirstStatus;
    private String svarUtShipmentId;
    private String errorMessage;

}
