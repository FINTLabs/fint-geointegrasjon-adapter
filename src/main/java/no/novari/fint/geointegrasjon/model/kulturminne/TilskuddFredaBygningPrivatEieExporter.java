package no.novari.fint.geointegrasjon.model.kulturminne;

import lombok.extern.slf4j.Slf4j;
import no.novari.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.novari.fint.model.resource.arkiv.kulturminnevern.TilskuddFredaBygningPrivatEieResource;
import no.geointegrasjon.arkiv.oppdatering.Saksmappe;
import org.jooq.lambda.function.Consumer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TilskuddFredaBygningPrivatEieExporter implements Consumer2<TilskuddFredaBygningPrivatEieResource, Saksmappe> {
    @Value("${fint.geointegrasjon.tilleggstype}") String tilleggstype;
    
    @Autowired
    private GeoIntegrasjonFactory geoIntegrasjonFactory;

    @Override
    public void accept(TilskuddFredaBygningPrivatEieResource resource, Saksmappe saksmappe) {
        /*
        geoIntegrasjonFactory.addTilleggsinformasjon(saksmappe,
                geoIntegrasjonFactory.newTilleggsinformasjon(tilleggstype, "Fartøy: " + resource.getFartoyNavn()),
                geoIntegrasjonFactory.newTilleggsinformasjon(tilleggstype, "Kallesignal: " + resource.getKallesignal()),
                geoIntegrasjonFactory.newTilleggsinformasjon(tilleggstype, "KulturminneID: " + resource.getKulturminneId())
        );

         */
    }
}
