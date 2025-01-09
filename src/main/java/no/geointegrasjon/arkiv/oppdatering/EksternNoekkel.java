
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
 * <p>Java class for EksternNoekkel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EksternNoekkel"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="fagsystem" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="noekkel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EksternNoekkel", namespace = "http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31", propOrder = {
    "fagsystem",
    "noekkel"
})
public class EksternNoekkel implements ToString2
{

    @XmlElement(required = true)
    protected String fagsystem;
    protected String noekkel;

    /**
     * Gets the value of the fagsystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFagsystem() {
        return fagsystem;
    }

    /**
     * Sets the value of the fagsystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFagsystem(String value) {
        this.fagsystem = value;
    }

    /**
     * Gets the value of the noekkel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoekkel() {
        return noekkel;
    }

    /**
     * Sets the value of the noekkel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoekkel(String value) {
        this.noekkel = value;
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
            String theFagsystem;
            theFagsystem = this.getFagsystem();
            strategy.appendField(locator, this, "fagsystem", buffer, theFagsystem, (this.fagsystem!= null));
        }
        {
            String theNoekkel;
            theNoekkel = this.getNoekkel();
            strategy.appendField(locator, this, "noekkel", buffer, theNoekkel, (this.noekkel!= null));
        }
        return buffer;
    }

}
