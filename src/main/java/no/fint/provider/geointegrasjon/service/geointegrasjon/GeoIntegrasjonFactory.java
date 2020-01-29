package no.fint.provider.geointegrasjon.service.geointegrasjon;

import lombok.extern.slf4j.Slf4j;
import no.fint.provider.geointegrasjon.AdapterProps;
import no.fint.provider.geointegrasjon.repository.InternalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GeoIntegrasjonFactory {

    @Autowired
    private AdapterProps adapterProps;

    @Autowired
    private InternalRepository internalRepository;

}
