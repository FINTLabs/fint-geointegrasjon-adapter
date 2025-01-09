
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
 * <p>Java class for BboxKriterie complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BboxKriterie"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31}Kriterie"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bbox" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Bbox"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BboxKriterie", namespace = "http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31", propOrder = {
    "bbox"
})
public class BboxKriterie
    extends Kriterie
    implements ToString2
{

    @XmlElement(required = true)
    protected Bbox bbox;

    /**
     * Gets the value of the bbox property.
     * 
     * @return
     *     possible object is
     *     {@link Bbox }
     *     
     */
    public Bbox getBbox() {
        return bbox;
    }

    /**
     * Sets the value of the bbox property.
     * 
     * @param value
     *     allowed object is
     *     {@link Bbox }
     *     
     */
    public void setBbox(Bbox value) {
        this.bbox = value;
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
            Bbox theBbox;
            theBbox = this.getBbox();
            strategy.appendField(locator, this, "bbox", buffer, theBbox, (this.bbox!= null));
        }
        return buffer;
    }

}
