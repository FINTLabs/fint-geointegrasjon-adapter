package no.novari.fint.geointegrasjon.service.geointegrasjon;

import lombok.extern.slf4j.Slf4j;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

@Slf4j
public class FaultHandler {
    public static ClientException handleFault(no.geointegrasjon.arkiv.oppdatering.ApplicationFault faultInfo) {
        log.debug("Oppdatering ApplicationFault: {}", faultInfo);
        return new ClientException(faultInfo.getFeilKode(), faultInfo.getFeilBeskrivelse(),
                ofNullable(faultInfo.getFeilDetaljer()).map(no.geointegrasjon.arkiv.oppdatering.StringListe::getListe).orElse(emptyList()));
    }

    public static ServerException handleFault(no.geointegrasjon.arkiv.oppdatering.SystemFault faultInfo) {
        log.debug("Oppdatering SystemFault: {}", faultInfo);
        return new ServerException(faultInfo.getFeilKode(), faultInfo.getFeilBeskrivelse(),
                ofNullable(faultInfo.getFeilDetaljer()).map(no.geointegrasjon.arkiv.oppdatering.StringListe::getListe).orElse(emptyList()));
    }

    public static ClientException handleFault(no.geointegrasjon.arkiv.innsyn.ApplicationFault faultInfo) {
        log.debug("Innsyn ApplicationFault: {}", faultInfo);
        return new ClientException(faultInfo.getFeilKode(), faultInfo.getFeilBeskrivelse(),
                ofNullable(faultInfo.getFeilDetaljer()).map(no.geointegrasjon.arkiv.innsyn.StringListe::getListe).orElse(emptyList()));
    }

    public static ServerException handleFault(no.geointegrasjon.arkiv.innsyn.SystemFault faultInfo) {
        log.debug("Innsyn SystemFault: {}", faultInfo);
        return new ServerException(faultInfo.getFeilKode(), faultInfo.getFeilBeskrivelse(),
                ofNullable(faultInfo.getFeilDetaljer()).map(no.geointegrasjon.arkiv.innsyn.StringListe::getListe).orElse(emptyList()));
    }
}
