
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
 * <p>Java class for Flate complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Flate"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Geometri"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="indreAvgrensning" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}RingListe" minOccurs="0"/&gt;
 *         &lt;element name="ytreAvgrensning" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Ring"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Flate", namespace = "http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31", propOrder = {
    "indreAvgrensning",
    "ytreAvgrensning"
})
public class Flate
    extends Geometri
    implements ToString2
{

    protected RingListe indreAvgrensning;
    @XmlElement(required = true)
    protected Ring ytreAvgrensning;

    /**
     * Gets the value of the indreAvgrensning property.
     * 
     * @return
     *     possible object is
     *     {@link RingListe }
     *     
     */
    public RingListe getIndreAvgrensning() {
        return indreAvgrensning;
    }

    /**
     * Sets the value of the indreAvgrensning property.
     * 
     * @param value
     *     allowed object is
     *     {@link RingListe }
     *     
     */
    public void setIndreAvgrensning(RingListe value) {
        this.indreAvgrensning = value;
    }

    /**
     * Gets the value of the ytreAvgrensning property.
     * 
     * @return
     *     possible object is
     *     {@link Ring }
     *     
     */
    public Ring getYtreAvgrensning() {
        return ytreAvgrensning;
    }

    /**
     * Sets the value of the ytreAvgrensning property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ring }
     *     
     */
    public void setYtreAvgrensning(Ring value) {
        this.ytreAvgrensning = value;
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
            RingListe theIndreAvgrensning;
            theIndreAvgrensning = this.getIndreAvgrensning();
            strategy.appendField(locator, this, "indreAvgrensning", buffer, theIndreAvgrensning, (this.indreAvgrensning!= null));
        }
        {
            Ring theYtreAvgrensning;
            theYtreAvgrensning = this.getYtreAvgrensning();
            strategy.appendField(locator, this, "ytreAvgrensning", buffer, theYtreAvgrensning, (this.ytreAvgrensning!= null));
        }
        return buffer;
    }

}
