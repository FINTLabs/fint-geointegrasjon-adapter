
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
 * <p>Java class for Fylke complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Fylke"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Plan/Felles/xml.schema/2012.01.31}Administrativenhetsnummer"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fylkesnummer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fylke", namespace = "http://rep.geointegrasjon.no/Plan/Felles/xml.schema/2012.01.31", propOrder = {
    "fylkesnummer"
})
public class Fylke
    extends Administrativenhetsnummer
    implements ToString2
{

    @XmlElement(required = true)
    protected String fylkesnummer;

    /**
     * Gets the value of the fylkesnummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFylkesnummer() {
        return fylkesnummer;
    }

    /**
     * Sets the value of the fylkesnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFylkesnummer(String value) {
        this.fylkesnummer = value;
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
            String theFylkesnummer;
            theFylkesnummer = this.getFylkesnummer();
            strategy.appendField(locator, this, "fylkesnummer", buffer, theFylkesnummer, (this.fylkesnummer!= null));
        }
        return buffer;
    }

}
