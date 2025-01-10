
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Kurve complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Kurve"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Geometri"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="linje" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}KoordinatListe" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Kurve", namespace = "http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31", propOrder = {
    "linje"
})
public class Kurve
    extends Geometri
    implements ToString2
{

    protected KoordinatListe linje;

    /**
     * Gets the value of the linje property.
     * 
     * @return
     *     possible object is
     *     {@link KoordinatListe }
     *     
     */
    public KoordinatListe getLinje() {
        return linje;
    }

    /**
     * Sets the value of the linje property.
     * 
     * @param value
     *     allowed object is
     *     {@link KoordinatListe }
     *     
     */
    public void setLinje(KoordinatListe value) {
        this.linje = value;
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
            KoordinatListe theLinje;
            theLinje = this.getLinje();
            strategy.appendField(locator, this, "linje", buffer, theLinje, (this.linje!= null));
        }
        return buffer;
    }

}
