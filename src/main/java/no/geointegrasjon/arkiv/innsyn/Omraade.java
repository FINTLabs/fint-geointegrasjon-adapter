
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Omraade complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Omraade"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="punkt" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Punkt" minOccurs="0"/&gt;
 *         &lt;element name="flate" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Flate" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Omraade", namespace = "http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31", propOrder = {
    "punkt",
    "flate"
})
public class Omraade implements ToString2
{

    protected Punkt punkt;
    protected Flate flate;

    /**
     * Gets the value of the punkt property.
     * 
     * @return
     *     possible object is
     *     {@link Punkt }
     *     
     */
    public Punkt getPunkt() {
        return punkt;
    }

    /**
     * Sets the value of the punkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Punkt }
     *     
     */
    public void setPunkt(Punkt value) {
        this.punkt = value;
    }

    /**
     * Gets the value of the flate property.
     * 
     * @return
     *     possible object is
     *     {@link Flate }
     *     
     */
    public Flate getFlate() {
        return flate;
    }

    /**
     * Sets the value of the flate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Flate }
     *     
     */
    public void setFlate(Flate value) {
        this.flate = value;
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
            Punkt thePunkt;
            thePunkt = this.getPunkt();
            strategy.appendField(locator, this, "punkt", buffer, thePunkt, (this.punkt!= null));
        }
        {
            Flate theFlate;
            theFlate = this.getFlate();
            strategy.appendField(locator, this, "flate", buffer, theFlate, (this.flate!= null));
        }
        return buffer;
    }

}
