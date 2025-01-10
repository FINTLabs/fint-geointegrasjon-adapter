
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Personidentifikator complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Personidentifikator"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="personidentifikatorNr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="personidentifikatorType" type="{http://rep.geointegrasjon.no/Felles/Kontakt/xml.schema/2012.01.31}PersonidentifikatorType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Personidentifikator", namespace = "http://rep.geointegrasjon.no/Felles/Kontakt/xml.schema/2012.01.31", propOrder = {
    "personidentifikatorNr",
    "personidentifikatorType"
})
public class Personidentifikator implements ToString2
{

    protected String personidentifikatorNr;
    protected PersonidentifikatorType personidentifikatorType;

    /**
     * Gets the value of the personidentifikatorNr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPersonidentifikatorNr() {
        return personidentifikatorNr;
    }

    /**
     * Sets the value of the personidentifikatorNr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPersonidentifikatorNr(String value) {
        this.personidentifikatorNr = value;
    }

    /**
     * Gets the value of the personidentifikatorType property.
     * 
     * @return
     *     possible object is
     *     {@link PersonidentifikatorType }
     *     
     */
    public PersonidentifikatorType getPersonidentifikatorType() {
        return personidentifikatorType;
    }

    /**
     * Sets the value of the personidentifikatorType property.
     * 
     * @param value
     *     allowed object is
     *     {@link PersonidentifikatorType }
     *     
     */
    public void setPersonidentifikatorType(PersonidentifikatorType value) {
        this.personidentifikatorType = value;
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
            String thePersonidentifikatorNr;
            thePersonidentifikatorNr = this.getPersonidentifikatorNr();
            strategy.appendField(locator, this, "personidentifikatorNr", buffer, thePersonidentifikatorNr, (this.personidentifikatorNr!= null));
        }
        {
            PersonidentifikatorType thePersonidentifikatorType;
            thePersonidentifikatorType = this.getPersonidentifikatorType();
            strategy.appendField(locator, this, "personidentifikatorType", buffer, thePersonidentifikatorType, (this.personidentifikatorType!= null));
        }
        return buffer;
    }

}
