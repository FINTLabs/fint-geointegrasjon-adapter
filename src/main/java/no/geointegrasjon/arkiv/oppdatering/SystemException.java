
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.5.5
 * 2024-12-18T13:51:15.055+01:00
 * Generated source version: 3.5.5
 */

@WebFault(name = "SystemFault", targetNamespace = "http://rep.geointegrasjon.no/Felles/Teknisk/xml.schema/2012.01.31")
public class SystemException extends Exception {

    private no.geointegrasjon.arkiv.oppdatering.SystemFault faultInfo;

    public SystemException() {
        super();
    }

    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public SystemException(String message, no.geointegrasjon.arkiv.oppdatering.SystemFault systemFault) {
        super(message);
        this.faultInfo = systemFault;
    }

    public SystemException(String message, no.geointegrasjon.arkiv.oppdatering.SystemFault systemFault, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = systemFault;
    }

    public no.geointegrasjon.arkiv.oppdatering.SystemFault getFaultInfo() {
        return this.faultInfo;
    }
}
