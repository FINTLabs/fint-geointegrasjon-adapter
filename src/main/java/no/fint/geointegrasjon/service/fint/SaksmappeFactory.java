package no.fint.geointegrasjon.service.fint;

import no.fint.geointegrasjon.service.geointegrasjon.OppdateringServiceFacade;

public abstract class SaksmappeFactory {

    private final OppdateringServiceFacade oppdateringServiceFacade;

    protected SaksmappeFactory(OppdateringServiceFacade oppdateringServiceFacade) {
        this.oppdateringServiceFacade = oppdateringServiceFacade;
    }


}
