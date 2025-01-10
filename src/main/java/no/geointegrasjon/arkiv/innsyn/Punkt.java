
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
 * <p>Java class for Punkt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Punkt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Geometri"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="posisjon" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Koordinat"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Punkt", namespace = "http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31", propOrder = {
    "posisjon"
})
public class Punkt
    extends Geometri
    implements ToString2
{

    @XmlElement(required = true)
    protected Koordinat posisjon;

    /**
     * Gets the value of the posisjon property.
     * 
     * @return
     *     possible object is
     *     {@link Koordinat }
     *     
     */
    public Koordinat getPosisjon() {
        return posisjon;
    }

    /**
     * Sets the value of the posisjon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Koordinat }
     *     
     */
    public void setPosisjon(Koordinat value) {
        this.posisjon = value;
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
            Koordinat thePosisjon;
            thePosisjon = this.getPosisjon();
            strategy.appendField(locator, this, "posisjon", buffer, thePosisjon, (this.posisjon!= null));
        }
        return buffer;
    }

}
