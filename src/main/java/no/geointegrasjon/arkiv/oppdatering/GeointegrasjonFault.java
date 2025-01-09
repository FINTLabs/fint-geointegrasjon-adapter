
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for GeointegrasjonFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GeointegrasjonFault"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="feilKode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="feilBeskrivelse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="feilDetaljer" type="{http://rep.geointegrasjon.no/Felles/Teknisk/xml.schema/2012.01.31}StringListe" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GeointegrasjonFault", namespace = "http://rep.geointegrasjon.no/Felles/Teknisk/xml.schema/2012.01.31", propOrder = {
    "feilKode",
    "feilBeskrivelse",
    "feilDetaljer"
})
@XmlSeeAlso({
    SystemFault.class,
    ApplicationFault.class
})
public class GeointegrasjonFault implements ToString2
{

    @XmlElement(required = true)
    protected String feilKode;
    protected String feilBeskrivelse;
    protected StringListe feilDetaljer;

    /**
     * Gets the value of the feilKode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeilKode() {
        return feilKode;
    }

    /**
     * Sets the value of the feilKode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeilKode(String value) {
        this.feilKode = value;
    }

    /**
     * Gets the value of the feilBeskrivelse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeilBeskrivelse() {
        return feilBeskrivelse;
    }

    /**
     * Sets the value of the feilBeskrivelse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeilBeskrivelse(String value) {
        this.feilBeskrivelse = value;
    }

    /**
     * Gets the value of the feilDetaljer property.
     * 
     * @return
     *     possible object is
     *     {@link StringListe }
     *     
     */
    public StringListe getFeilDetaljer() {
        return feilDetaljer;
    }

    /**
     * Sets the value of the feilDetaljer property.
     * 
     * @param value
     *     allowed object is
     *     {@link StringListe }
     *     
     */
    public void setFeilDetaljer(StringListe value) {
        this.feilDetaljer = value;
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
            String theFeilKode;
            theFeilKode = this.getFeilKode();
            strategy.appendField(locator, this, "feilKode", buffer, theFeilKode, (this.feilKode!= null));
        }
        {
            String theFeilBeskrivelse;
            theFeilBeskrivelse = this.getFeilBeskrivelse();
            strategy.appendField(locator, this, "feilBeskrivelse", buffer, theFeilBeskrivelse, (this.feilBeskrivelse!= null));
        }
        {
            StringListe theFeilDetaljer;
            theFeilDetaljer = this.getFeilDetaljer();
            strategy.appendField(locator, this, "feilDetaljer", buffer, theFeilDetaljer, (this.feilDetaljer!= null));
        }
        return buffer;
    }

}
