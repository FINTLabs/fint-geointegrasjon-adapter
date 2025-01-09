
package no.geointegrasjon.arkiv.oppdatering;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for ByggIdent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ByggIdent"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bygningsNummer" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="endringsloepenummer" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ByggIdent", namespace = "http://rep.geointegrasjon.no/Matrikkel/Felles/xml.schema/2012.01.31", propOrder = {
    "bygningsNummer",
    "endringsloepenummer"
})
public class ByggIdent implements ToString2
{

    @XmlElement(required = true)
    protected BigInteger bygningsNummer;
    protected BigInteger endringsloepenummer;

    /**
     * Gets the value of the bygningsNummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBygningsNummer() {
        return bygningsNummer;
    }

    /**
     * Sets the value of the bygningsNummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBygningsNummer(BigInteger value) {
        this.bygningsNummer = value;
    }

    /**
     * Gets the value of the endringsloepenummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getEndringsloepenummer() {
        return endringsloepenummer;
    }

    /**
     * Sets the value of the endringsloepenummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setEndringsloepenummer(BigInteger value) {
        this.endringsloepenummer = value;
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
        {
            BigInteger theBygningsNummer;
            theBygningsNummer = this.getBygningsNummer();
            strategy.appendField(locator, this, "bygningsNummer", buffer, theBygningsNummer, (this.bygningsNummer!= null));
        }
        {
            BigInteger theEndringsloepenummer;
            theEndringsloepenummer = this.getEndringsloepenummer();
            strategy.appendField(locator, this, "endringsloepenummer", buffer, theEndringsloepenummer, (this.endringsloepenummer!= null));
        }
        return buffer;
    }

}
