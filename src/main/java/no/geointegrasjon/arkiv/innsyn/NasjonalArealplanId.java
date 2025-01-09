
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for NasjonalArealplanId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NasjonalArealplanId"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nummer" type="{http://rep.geointegrasjon.no/Plan/Felles/xml.schema/2012.01.31}Administrativenhetsnummer"/&gt;
 *         &lt;element name="planidentifikasjon" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NasjonalArealplanId", namespace = "http://rep.geointegrasjon.no/Plan/Felles/xml.schema/2012.01.31", propOrder = {
    "nummer",
    "planidentifikasjon"
})
public class NasjonalArealplanId implements ToString2
{

    @XmlElement(required = true)
    protected Administrativenhetsnummer nummer;
    @XmlElement(required = true)
    protected String planidentifikasjon;

    /**
     * Gets the value of the nummer property.
     * 
     * @return
     *     possible object is
     *     {@link Administrativenhetsnummer }
     *     
     */
    public Administrativenhetsnummer getNummer() {
        return nummer;
    }

    /**
     * Sets the value of the nummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Administrativenhetsnummer }
     *     
     */
    public void setNummer(Administrativenhetsnummer value) {
        this.nummer = value;
    }

    /**
     * Gets the value of the planidentifikasjon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanidentifikasjon() {
        return planidentifikasjon;
    }

    /**
     * Sets the value of the planidentifikasjon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanidentifikasjon(String value) {
        this.planidentifikasjon = value;
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
            Administrativenhetsnummer theNummer;
            theNummer = this.getNummer();
            strategy.appendField(locator, this, "nummer", buffer, theNummer, (this.nummer!= null));
        }
        {
            String thePlanidentifikasjon;
            thePlanidentifikasjon = this.getPlanidentifikasjon();
            strategy.appendField(locator, this, "planidentifikasjon", buffer, thePlanidentifikasjon, (this.planidentifikasjon!= null));
        }
        return buffer;
    }

}
