
package no.geointegrasjon.arkiv.innsyn;

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
 * <p>Java class for Geometri complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Geometri"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="koordinatsystem" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}KoordinatsystemKode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Geometri", namespace = "http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31", propOrder = {
    "koordinatsystem"
})
@XmlSeeAlso({
    Flate.class,
    Kurve.class,
    Punkt.class,
    Bbox.class
})
public class Geometri implements ToString2
{

    @XmlElement(required = true)
    protected KoordinatsystemKode koordinatsystem;

    /**
     * Gets the value of the koordinatsystem property.
     * 
     * @return
     *     possible object is
     *     {@link KoordinatsystemKode }
     *     
     */
    public KoordinatsystemKode getKoordinatsystem() {
        return koordinatsystem;
    }

    /**
     * Sets the value of the koordinatsystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link KoordinatsystemKode }
     *     
     */
    public void setKoordinatsystem(KoordinatsystemKode value) {
        this.koordinatsystem = value;
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
            KoordinatsystemKode theKoordinatsystem;
            theKoordinatsystem = this.getKoordinatsystem();
            strategy.appendField(locator, this, "koordinatsystem", buffer, theKoordinatsystem, (this.koordinatsystem!= null));
        }
        return buffer;
    }

}
