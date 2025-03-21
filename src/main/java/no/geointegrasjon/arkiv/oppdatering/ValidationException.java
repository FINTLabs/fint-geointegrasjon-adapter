
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.5.5
 * 2024-12-18T13:51:15.049+01:00
 * Generated source version: 3.5.5
 */

@WebFault(name = "ValidationFault", targetNamespace = "http://rep.geointegrasjon.no/Felles/Teknisk/xml.schema/2012.01.31")
public class ValidationException extends Exception {

    private no.geointegrasjon.arkiv.oppdatering.ValidationFault faultInfo;

    public ValidationException() {
        super();
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public ValidationException(String message, no.geointegrasjon.arkiv.oppdatering.ValidationFault validationFault) {
        super(message);
        this.faultInfo = validationFault;
    }

    public ValidationException(String message, no.geointegrasjon.arkiv.oppdatering.ValidationFault validationFault, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = validationFault;
    }

    public no.geointegrasjon.arkiv.oppdatering.ValidationFault getFaultInfo() {
        return this.faultInfo;
    }
}
