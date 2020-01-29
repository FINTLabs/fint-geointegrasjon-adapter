package no.fint.provider.geointegrasjon.service.geointegrasjon;

import lombok.extern.slf4j.Slf4j;
import no.fint.provider.geointegrasjon.AdapterProps;
import no.fint.provider.geointegrasjon.state.FaxShipmentState;
import no.geointegrasjon.arkiv.innsyn.ArkivInnsynPort;
import no.geointegrasjon.arkiv.oppdatering.SakArkivOppdateringPort;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;
import org.apache.cxf.ws.addressing.WSAddressingFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
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

    private ArkivInnsynPort arkivInnsyn;
    private SakArkivOppdateringPort sakArkivOppdatering;

    @PostConstruct
    private void init() {
        arkivInnsyn = createServiceProxy(ArkivInnsynPort.class);
        sakArkivOppdatering = createServiceProxy(SakArkivOppdateringPort.class);
    }

    private <T> T createServiceProxy(Class<T> serviceClass) {
        T port;
        Map<String, Object> props = new HashMap<>();
        props.put("mtom-enabled", Boolean.TRUE);

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(serviceClass);
        factory.setAddress(adapterProps.getServiceUrl());
        factory.setUsername(adapterProps.getUsername());
        factory.setPassword(adapterProps.getPassword());
        factory.setProperties(props);
        factory.getFeatures().add(new WSAddressingFeature());
        port = serviceClass.cast(factory.create());
        Client proxy = ClientProxy.getClient(port);
        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();

        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(adapterProps.getConnectionTimeout());
        httpClientPolicy.setReceiveTimeout(adapterProps.getReceiveTimeout());
        conduit.setClient(httpClientPolicy);
        return port;
    }

}
