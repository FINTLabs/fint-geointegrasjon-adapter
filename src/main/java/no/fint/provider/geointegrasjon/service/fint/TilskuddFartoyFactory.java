package no.fint.provider.geointegrasjon.service.fint;

import no.fint.model.resource.Link;
import no.fint.model.resource.administrasjon.arkiv.JournalpostResource;
import no.fint.model.resource.kultur.kulturminnevern.TilskuddFartoyResource;
import no.fint.provider.geointegrasjon.model.FaxShipment;
import no.fint.provider.geointegrasjon.service.geointegrasjon.GeoIntegrasjonService;
import no.fint.provider.geointegrasjon.utils.FintUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class TilskuddFartoyFactory extends SaksmappeFactory {

    public static final String FARTOYNAVN = "fartoynavn";
    public static final String KALLESIGNAL = "kallesignal";
    public static final String KULTURMINNEID = "kulturminneid";
    public static final String DIGISAKSNUMMER = "digisaksnummer";

    public TilskuddFartoyFactory(GeoIntegrasjonService geointegrasjonService) {
        super(geointegrasjonService);
    }

    public TilskuddFartoyResource toFintResource(FaxShipment faxShipment) {
        TilskuddFartoyResource tilskuddFartoyResource = new TilskuddFartoyResource();

        tilskuddFartoyResource.setFartoyNavn(faxShipment.getMetadata().get(FARTOYNAVN));
        tilskuddFartoyResource.setKallesignal(faxShipment.getMetadata().get(KALLESIGNAL));
        tilskuddFartoyResource.setKulturminneId(faxShipment.getMetadata().get(KULTURMINNEID));
        tilskuddFartoyResource.setSoknadsnummer(FintUtils.createIdentifikator(faxShipment.getMetadata().get(DIGISAKSNUMMER)));

        updateSaksmappeFromFaxShipment(faxShipment, tilskuddFartoyResource);

        tilskuddFartoyResource
                .getJournalpost()
                .stream()
                .map(JournalpostResource::getRegistreringsId)
                .filter(StringUtils::isNotBlank)
                .distinct()
                .map(Link.apply(TilskuddFartoyResource.class, "mappeid"))
                .forEach(tilskuddFartoyResource::addSelf);

        return tilskuddFartoyResource;

    }

}
