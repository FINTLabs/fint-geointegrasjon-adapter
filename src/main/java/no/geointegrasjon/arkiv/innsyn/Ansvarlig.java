
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Ansvarlig complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Ansvarlig"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31}Kriterie"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="eier" type="{http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31}AnsvarligEnum"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ansvarlig", namespace = "http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31", propOrder = {
    "eier"
})
public class Ansvarlig
    extends Kriterie
    implements ToString2
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected AnsvarligEnum eier;

    /**
     * Gets the value of the eier property.
     * 
     * @return
     *     possible object is
     *     {@link AnsvarligEnum }
     *     
     */
    public AnsvarligEnum getEier() {
        return eier;
    }

    /**
     * Sets the value of the eier property.
     * 
     * @param value
     *     allowed object is
     *     {@link AnsvarligEnum }
     *     
     */
    public void setEier(AnsvarligEnum value) {
        this.eier = value;
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
            AnsvarligEnum theEier;
            theEier = this.getEier();
            strategy.appendField(locator, this, "eier", buffer, theEier, (this.eier!= null));
        }
        return buffer;
    }

}
