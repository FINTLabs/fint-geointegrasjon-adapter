
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
 * <p>Java class for SakSystemId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SakSystemId"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Arkiv/Felles/xml.schema/2012.01.31}Saksnoekkel"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="systemID" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}SystemID"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SakSystemId", namespace = "http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31", propOrder = {
    "systemID"
})
public class SakSystemId
    extends Saksnoekkel
    implements ToString2
{

    @XmlElement(required = true)
    protected SystemID systemID;

    /**
     * Gets the value of the systemID property.
     * 
     * @return
     *     possible object is
     *     {@link SystemID }
     *     
     */
    public SystemID getSystemID() {
        return systemID;
    }

    /**
     * Sets the value of the systemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SystemID }
     *     
     */
    public void setSystemID(SystemID value) {
        this.systemID = value;
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
            SystemID theSystemID;
            theSystemID = this.getSystemID();
            strategy.appendField(locator, this, "systemID", buffer, theSystemID, (this.systemID!= null));
        }
        return buffer;
    }

}
