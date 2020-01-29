package no.fint.provider.geointegrasjon;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Component
public class AdapterProps {

    @Value("${fint.geointegrasjon.service-url:https://test.svarut.ks.no/tjenester/forsendelseservice/ForsendelsesServiceV11}")
    private String serviceUrl;

    @Value("${fint.geointegrasjon.username}")
    private String username;

    @Value("${fint.geointegrasjon.password}")
    private String password;

    @Value("${fint.geointegrasjon.connection-timeout:120000}")
    private long connectionTimeout;

    @Value("${fint.geointegrasjon.receive-timeout:120000}")
    private long receiveTimeout;

    @Value("${fint.geointegrasjon.organisation.number}")
    private String organisationNumber;

    @Value("${fint.geointegrasjon.organisation.name}")
    private String organisationName;

    @Value("${fint.geointegrasjon.organisation.adresse1}")
    private String organisationAdresse1;

    @Value("${fint.geointegrasjon.organisation.adresse2:''}")
    private String organisationAdresse2;

    @Value("${fint.geointegrasjon.organisation.adresse3:''}")
    private String organisationAdresse3;

    @Value("${fint.geointegrasjon.organisation.postalcode}")
    private String organisationPostalCode;

    @Value("${fint.geointegrasjon.organisation.city}")
    private String organisationCity;

    @Value("${fint.adapter.organizations}")
    private String orgId;


}