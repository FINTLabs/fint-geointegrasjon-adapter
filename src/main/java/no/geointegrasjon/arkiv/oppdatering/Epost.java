
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
 * <p>Java class for Epost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Epost"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31}ElektroniskAdresse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="epostadresse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Epost", namespace = "http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31", propOrder = {
    "epostadresse"
})
public class Epost
    extends ElektroniskAdresse
    implements ToString2
{

    @XmlElement(required = true)
    protected String epostadresse;

    /**
     * Gets the value of the epostadresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEpostadresse() {
        return epostadresse;
    }

    /**
     * Sets the value of the epostadresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEpostadresse(String value) {
        this.epostadresse = value;
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
            String theEpostadresse;
            theEpostadresse = this.getEpostadresse();
            strategy.appendField(locator, this, "epostadresse", buffer, theEpostadresse, (this.epostadresse!= null));
        }
        return buffer;
    }

}
