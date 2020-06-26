package no.fint.geointegrasjon.service.geointegrasjon;

public class FaultHandler {
    public static ClientException handleFault(no.geointegrasjon.arkiv.oppdatering.ApplicationFault faultInfo) {
        return new ClientException(faultInfo.getFeilKode(), faultInfo.getFeilBeskrivelse(), faultInfo.getFeilDetaljer().getListe());
    }

    public static ServerException handleFault(no.geointegrasjon.arkiv.oppdatering.SystemFault faultInfo) {
        return new ServerException(faultInfo.getFeilKode(), faultInfo.getFeilBeskrivelse(), faultInfo.getFeilDetaljer().getListe());
    }

    public static ClientException handleFault(no.geointegrasjon.arkiv.innsyn.ApplicationFault faultInfo) {
        return new ClientException(faultInfo.getFeilKode(), faultInfo.getFeilBeskrivelse(), faultInfo.getFeilDetaljer().getListe());
    }

    public static ServerException handleFault(no.geointegrasjon.arkiv.innsyn.SystemFault faultInfo) {
        return new ServerException(faultInfo.getFeilKode(), faultInfo.getFeilBeskrivelse(), faultInfo.getFeilDetaljer().getListe());
    }
}
