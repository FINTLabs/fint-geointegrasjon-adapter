package no.fint.geointegrasjon.model.kulturminne;

import lombok.extern.slf4j.Slf4j;
import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonFactory;
import no.fint.model.resource.kultur.kulturminnevern.TilskuddFartoyResource;
import no.geointegrasjon.arkiv.oppdatering.Saksmappe;
import org.jooq.lambda.function.Consumer2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TilskuddFartoyExporter implements Consumer2<TilskuddFartoyResource, Saksmappe> {
    @Autowired
    private GeoIntegrasjonFactory geoIntegrasjonFactory;

    @Override
    public void accept(TilskuddFartoyResource resource, Saksmappe saksmappe) {
        geoIntegrasjonFactory.addTilleggsinformasjon(saksmappe,
                geoIntegrasjonFactory.newTilleggsinformasjon("TILLEGG", "Fartøy: " + resource.getFartoyNavn()),
                geoIntegrasjonFactory.newTilleggsinformasjon("TILLEGG", "Kallesignal: " + resource.getKallesignal()),
                geoIntegrasjonFactory.newTilleggsinformasjon("TILLEGG", "KulturminneID: " + resource.getKulturminneId())
        );
    }
}
