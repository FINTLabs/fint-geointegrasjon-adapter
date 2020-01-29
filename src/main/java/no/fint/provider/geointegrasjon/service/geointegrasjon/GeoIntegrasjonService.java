package no.fint.provider.geointegrasjon.service.geointegrasjon;

import lombok.extern.slf4j.Slf4j;
import no.fint.provider.geointegrasjon.AdapterProps;
import no.fint.provider.geointegrasjon.model.FaxShipment;
import no.fint.provider.geointegrasjon.model.ShipmentStatus;
import no.fint.provider.geointegrasjon.state.FaxShipmentState;
import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class GeoIntegrasjonService {

    @Autowired
    private FaxShipmentState faxShipmentState;

    @Autowired
    private AdapterProps adapterProps;

    @Autowired
    private GeoIntegrasjonFactory geointegrasjonFactory;

    private ForsendelsesServiceV11 serviceV11;

    @PostConstruct
    private void init() {
        Map<String, Object> props = new HashMap<>();
        props.put("mtom-enabled", Boolean.TRUE);

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(ForsendelsesServiceV11.class);
        factory.setAddress(adapterProps.getServiceUrl());
        factory.setUsername(adapterProps.getUsername());
        factory.setPassword(adapterProps.getPassword());
        factory.setProperties(props);
        factory.getFeatures().add(new WSAddressingFeature());
        serviceV11 = (ForsendelsesServiceV11) factory.create();
        Client proxy = ClientProxy.getClient(serviceV11);
        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();

        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(adapterProps.getConnectionTimeout());
        httpClientPolicy.setReceiveTimeout(adapterProps.getReceiveTimeout());
        conduit.setClient(httpClientPolicy);

    }

    public Boolean healthy() {
        List<String> shipmentTypes = serviceV11.retreiveForsendelsesTyper();
        return shipmentTypes.size() > 0;
    }

    public ForsendelsesStatus getForsendelsesStatus(String id) {
        ForsendelsesId forsendelsesId = new ForsendelsesId();
        forsendelsesId.setId(id);
        return serviceV11.retrieveForsendelsesStatus(forsendelsesId);
    }

    public void fax(FaxShipment fax) {

        log.debug("Fax: {}", fax);
        try {
            Forsendelse forsendelse = geointegrasjonFactory.createForsendelse(fax);
            log.debug("Forsendelse: {}", forsendelse);
            ForsendelsesId forsendelsesId = serviceV11.sendForsendelse(forsendelse);
            log.info("ForsendelsesId: {}", forsendelsesId);
            ForsendelsesStatus forsendelsesStatus = serviceV11.retrieveForsendelsesStatus(forsendelsesId);
            log.info("ForsendelsesStatus: {}", forsendelsesStatus);

            if (!forsendelsesStatus.getStatus().equals(Status.AVVIST)) {
                fax.getDocuments()
                        .stream()
                        .filter(document -> document.getShipmentStatus().equals(ShipmentStatus.READY))
                        .forEach(doc -> {
                            doc.setSvarUtShipmentId(forsendelsesId.getId());
                            doc.setShipmentStatus(ShipmentStatus.SENT_TO_SVARUT);
                            doc.setShipmentTime(new Date());
                            doc.setSvarUtFirstStatus(forsendelsesStatus.getStatus());
                        });
            } else {
                fax.getDocuments()
                        .stream()
                        .filter(document -> document.getShipmentStatus().equals(ShipmentStatus.READY))
                        .forEach(doc -> {
                            doc.setSvarUtShipmentId(forsendelsesId.getId());
                            doc.setShipmentStatus(ShipmentStatus.ERROR);
                            doc.setShipmentTime(new Date());
                            doc.setSvarUtFirstStatus(forsendelsesStatus.getStatus());
                            doc.setErrorMessage("Forsendelsen er ikke validert pga. manglende/korrupt metadata, eller fordi forsendelsesfil ikke kunne dannes.");
                        });
            }
        } catch (Exception e) {
            log.warn("Crap!", e);
            fax.getDocuments()
                    .stream()
                    .filter(document -> document.getShipmentStatus().equals(ShipmentStatus.READY))
                    .forEach(doc -> {
                        doc.setShipmentStatus(ShipmentStatus.ERROR);
                        doc.setShipmentTime(new Date());
                        doc.setErrorMessage(e.toString());
                    });

        } finally {
            faxShipmentState.save(fax);
        }

    }

    @Scheduled(initialDelayString = "${fint.geointegrasjon.delay.initial:30000}", fixedDelayString = "${fint.geointegrasjon.delay.fixed:30000}")
    public void sendFaxes() {
        List<FaxShipment> notSent = faxShipmentState.getNotSent();
        if (!notSent.isEmpty()) {
            log.info("The fax machine will shoot {} faxes into the galaxy... ", StringUtils.repeat("\uD83D\uDCE0", notSent.size()));
            notSent.forEach(this::fax);
            log.debug("The fax machine will enjoy a \uD83C\uDF7A waiting for the next deployment!");
        }
    }
}
