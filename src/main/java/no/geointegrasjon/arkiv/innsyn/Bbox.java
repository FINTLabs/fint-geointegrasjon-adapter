
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
 * <p>Java class for Bbox complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Bbox"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Geometri"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nedreVenstre" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Koordinat"/&gt;
 *         &lt;element name="oevreHoeyre" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Koordinat"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bbox", namespace = "http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31", propOrder = {
    "nedreVenstre",
    "oevreHoeyre"
})
public class Bbox
    extends Geometri
    implements ToString2
{

    @XmlElement(required = true)
    protected Koordinat nedreVenstre;
    @XmlElement(required = true)
    protected Koordinat oevreHoeyre;

    /**
     * Gets the value of the nedreVenstre property.
     * 
     * @return
     *     possible object is
     *     {@link Koordinat }
     *     
     */
    public Koordinat getNedreVenstre() {
        return nedreVenstre;
    }

    /**
     * Sets the value of the nedreVenstre property.
     * 
     * @param value
     *     allowed object is
     *     {@link Koordinat }
     *     
     */
    public void setNedreVenstre(Koordinat value) {
        this.nedreVenstre = value;
    }

    /**
     * Gets the value of the oevreHoeyre property.
     * 
     * @return
     *     possible object is
     *     {@link Koordinat }
     *     
     */
    public Koordinat getOevreHoeyre() {
        return oevreHoeyre;
    }

    /**
     * Sets the value of the oevreHoeyre property.
     * 
     * @param value
     *     allowed object is
     *     {@link Koordinat }
     *     
     */
    public void setOevreHoeyre(Koordinat value) {
        this.oevreHoeyre = value;
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
            Koordinat theNedreVenstre;
            theNedreVenstre = this.getNedreVenstre();
            strategy.appendField(locator, this, "nedreVenstre", buffer, theNedreVenstre, (this.nedreVenstre!= null));
        }
        {
            Koordinat theOevreHoeyre;
            theOevreHoeyre = this.getOevreHoeyre();
            strategy.appendField(locator, this, "oevreHoeyre", buffer, theOevreHoeyre, (this.oevreHoeyre!= null));
        }
        return buffer;
    }

}
