package no.fint.geointegrasjon.service.geointegrasjon;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.AdapterProps;
import no.geointegrasjon.arkiv.innsyn.ArkivInnsynPort;
import no.geointegrasjon.arkiv.innsyn.InnsynService;
import no.geointegrasjon.arkiv.oppdatering.OppdateringService;
import no.geointegrasjon.arkiv.oppdatering.SakArkivOppdateringPort;
import org.apache.cxf.configuration.security.AuthorizationPolicy;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.common.ext.WSPasswordCallback;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import javax.security.auth.callback.CallbackHandler;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.apache.commons.lang3.StringUtils.isNotBlank;

@Slf4j
@Configuration
public class GeoIntegrasjonConfiguration {

    private static final String API_KEY = "apikey";

    @Autowired
    private AdapterProps adapterProps;

    @Value("${fint.geointegrasjon.innsyn:/ArkivInnsynService.svc/ArkivInnsynService}")
    private String innsynLocation;

    @Value("${fint.geointegrasjon.oppdatering:/ArkivOppdateringService.svc/ArkivOppdateringService}")
    private String oppdateringLocation;

    @Value("${fint.geointegrasjon.tracing:false}")
    private boolean tracing;

    @Value("${fint.geointegrasjon.use-wss:false}")
    private boolean useWSS;

    private ArkivInnsynPort arkivInnsyn;
    private SakArkivOppdateringPort sakArkivOppdatering;

    @PostConstruct
    private void init() {
        log.info("Configuring InnsynService at {}{} ...", adapterProps.getServiceUrl(), innsynLocation);
        arkivInnsyn = new InnsynService().getArkivInnsyn();
        setupEndpoint(arkivInnsyn, adapterProps.getServiceUrl() + innsynLocation, adapterProps.getUsername(), adapterProps.getPassword());

        log.info("Configuring OppdateringService at {}{} ...", adapterProps.getServiceUrl(), oppdateringLocation);
        sakArkivOppdatering = new OppdateringService().getSakArkivOppdatering();
        setupEndpoint(sakArkivOppdatering, adapterProps.getServiceUrl() + oppdateringLocation, adapterProps.getUsername(), adapterProps.getPassword());

    }

    @Bean
    public ArkivInnsynPort arkivInnsynPort() {
        return arkivInnsyn;
    }

    @Bean
    public SakArkivOppdateringPort sakArkivOppdateringPort() {
        return sakArkivOppdatering;
    }

    private void setupEndpoint(Object port, String address, String username, String password) {
        final Client client = ClientProxy.getClient(port);
        client.getRequestContext().put(Message.ENDPOINT_ADDRESS, address);

        if (useWSS) {
            client
                    .getEndpoint()
                    .getOutInterceptors()
                    .add(
                            new WSS4JOutInterceptor(
                                    ImmutableMap.of(
                                            WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN,
                                            WSHandlerConstants.USER, username,
                                            WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT,
                                            WSHandlerConstants.PW_CALLBACK_REF, passwordCallbackHandler(password)
                                    )));
        } else if (isNotBlank(adapterProps.getApikey())) {
            log.info("Using the newly added API key authentication feature!");
            Map<String, List<String>> headers = new HashMap<String, List<String>>();
            headers.put(API_KEY, Arrays.asList(adapterProps.getApikey()));
            client.getRequestContext().put(Message.PROTOCOL_HEADERS, headers);
        } else {
            HTTPConduit conduit = (HTTPConduit) client.getConduit();
            conduit.setAuthorization(basicAuthorization(username, password));
        }

        if (tracing) {
            client.getInInterceptors().add(new LoggingInInterceptor());
            client.getOutInterceptors().add(new LoggingOutInterceptor());
        }
    }

    private AuthorizationPolicy basicAuthorization(String username, String password) {
        AuthorizationPolicy authorizationPolicy =
                new AuthorizationPolicy();
        authorizationPolicy.setUserName(username);
        authorizationPolicy.setPassword(password);
        authorizationPolicy.setAuthorizationType("Basic");

        return authorizationPolicy;
    }

    private CallbackHandler passwordCallbackHandler(String password) {
        return callbacks -> Arrays
                .stream(callbacks)
                .filter(WSPasswordCallback.class::isInstance)
                .map(WSPasswordCallback.class::cast)
                .forEach(c -> c.setPassword(password));
    }

/*
    private <T> T createServiceProxy(Class<T> serviceClass, String address) {
        T port;
        Map<String, Object> props = new HashMap<>();
        //props.put("mtom-enabled", Boolean.TRUE);

        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(serviceClass);
        factory.setAddress(address);
        factory.setUsername(adapterProps.getUsername());
        factory.setPassword(adapterProps.getPassword());
        //factory.setProperties(props);
        //factory.getFeatures().add(new WSAddressingFeature());
        port = serviceClass.cast(factory.create());
        Client proxy = ClientProxy.getClient(port);
        HTTPConduit conduit = (HTTPConduit) proxy.getConduit();

        HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
        httpClientPolicy.setConnectionTimeout(adapterProps.getConnectionTimeout());
        httpClientPolicy.setReceiveTimeout(adapterProps.getReceiveTimeout());
        conduit.setClient(httpClientPolicy);
        return port;
    }
*/

}
