
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Kommune complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Kommune"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Plan/Felles/xml.schema/2012.01.31}Administrativenhetsnummer"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="kommunenummer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Kommune", namespace = "http://rep.geointegrasjon.no/Plan/Felles/xml.schema/2012.01.31", propOrder = {
    "kommunenummer"
})
public class Kommune
    extends Administrativenhetsnummer
    implements ToString2
{

    @XmlElement(required = true)
    protected String kommunenummer;

    /**
     * Gets the value of the kommunenummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKommunenummer() {
        return kommunenummer;
    }

    /**
     * Sets the value of the kommunenummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKommunenummer(String value) {
        this.kommunenummer = value;
    }

    public String toString() {
        final ToStringStrategy2 strategy = JAXBToStringStrategy.INSTANCE;
        final StringBuilder buffer = new StringBuilder();
        append(null, buffer, strategy);
        return buffer.toString();
    }

    public StringBuilder append(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        strategy.appendStart(locator, this, buffer);
        appendFields(locator, buffer, strategy);
        strategy.appendEnd(locator, this, buffer);
        return buffer;
    }

    public StringBuilder appendFields(ObjectLocator locator, StringBuilder buffer, ToStringStrategy2 strategy) {
        super.appendFields(locator, buffer, strategy);
        {
            String theKommunenummer;
            theKommunenummer = this.getKommunenummer();
            strategy.appendField(locator, this, "kommunenummer", buffer, theKommunenummer, (this.kommunenummer!= null));
        }
        return buffer;
    }

}
