package no.novari.fint.geointegrasjon.model.kulturminne;

import lombok.extern.slf4j.Slf4j;
import no.novari.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.novari.fint.model.resource.arkiv.kulturminnevern.DispensasjonAutomatiskFredaKulturminneResource;
import no.geointegrasjon.arkiv.oppdatering.Saksmappe;
import org.jooq.lambda.function.Consumer2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DispensasjonAutomatiskFredaKulturminneExporter implements Consumer2<DispensasjonAutomatiskFredaKulturminneResource, Saksmappe> {

    @Value("${fint.geointegrasjon.tilleggstype}")
    private String tilleggstype;

    private final GeoIntegrasjonFactory geoIntegrasjonFactory;

    public DispensasjonAutomatiskFredaKulturminneExporter(GeoIntegrasjonFactory geoIntegrasjonFactory) {
        this.geoIntegrasjonFactory = geoIntegrasjonFactory;
    }

    @Override
    public void accept(DispensasjonAutomatiskFredaKulturminneResource resource, Saksmappe saksmappe) {
    }
}
