package no.fint.geointegrasjon;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AdapterProps {

    @Value("${fint.geointegrasjon.service-url}")
    private String serviceUrl;

    @Value("${fint.geointegrasjon.username}")
    private String username;

    @Value("${fint.geointegrasjon.password}")
    private String password;

    @Value("${fint.geointegrasjon.connection-timeout:120000}")
    private long connectionTimeout;

    @Value("${fint.geointegrasjon.receive-timeout:120000}")
    private long receiveTimeout;

    @Value("${fint.adapter.organizations}")
    private String orgId;


}