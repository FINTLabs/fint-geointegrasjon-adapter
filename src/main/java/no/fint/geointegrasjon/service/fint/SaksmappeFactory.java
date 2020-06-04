package no.fint.geointegrasjon.service.fint;

import no.fint.geointegrasjon.service.geointegrasjon.GeoIntegrasjonService;

public abstract class SaksmappeFactory {

    private final GeoIntegrasjonService geointegrasjonService;

    protected SaksmappeFactory(GeoIntegrasjonService geointegrasjonService) {
        this.geointegrasjonService = geointegrasjonService;
    }


}
