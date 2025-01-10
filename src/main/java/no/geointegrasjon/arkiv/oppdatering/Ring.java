
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Ring complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ring"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="lukketKurve" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}KoordinatListe" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ring", namespace = "http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31", propOrder = {
    "lukketKurve"
})
public class Ring implements ToString2
{

    protected KoordinatListe lukketKurve;

    /**
     * Gets the value of the lukketKurve property.
     * 
     * @return
     *     possible object is
     *     {@link KoordinatListe }
     *     
     */
    public KoordinatListe getLukketKurve() {
        return lukketKurve;
    }

    /**
     * Sets the value of the lukketKurve property.
     * 
     * @param value
     *     allowed object is
     *     {@link KoordinatListe }
     *     
     */
    public void setLukketKurve(KoordinatListe value) {
        this.lukketKurve = value;
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
            KoordinatListe theLukketKurve;
            theLukketKurve = this.getLukketKurve();
            strategy.appendField(locator, this, "lukketKurve", buffer, theLukketKurve, (this.lukketKurve!= null));
        }
        return buffer;
    }

}
