
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.5.5
 * 2024-12-18T13:51:15.060+01:00
 * Generated source version: 3.5.5
 */

@WebFault(name = "ImplementationFault", targetNamespace = "http://rep.geointegrasjon.no/Felles/Teknisk/xml.schema/2012.01.31")
public class ImplementationException extends Exception {

    private no.geointegrasjon.arkiv.oppdatering.ImplementationFault faultInfo;

    public ImplementationException() {
        super();
    }

    public ImplementationException(String message) {
        super(message);
    }

    public ImplementationException(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ImplementationException(String message, no.geointegrasjon.arkiv.oppdatering.ImplementationFault implementationFault) {
        super(message);
        this.faultInfo = implementationFault;
    }

    public ImplementationException(String message, no.geointegrasjon.arkiv.oppdatering.ImplementationFault implementationFault, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = implementationFault;
    }

    public no.geointegrasjon.arkiv.oppdatering.ImplementationFault getFaultInfo() {
        return this.faultInfo;
    }
}