
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
 * <p>Java class for Filinnhold complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Filinnhold"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Arkiv/Dokument/xml.schema/2012.01.31}Fil"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="base64" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Filinnhold", namespace = "http://rep.geointegrasjon.no/Arkiv/Dokument/xml.schema/2012.01.31", propOrder = {
    "base64"
})
public class Filinnhold
    extends Fil
    implements ToString2
{

    @XmlElement(required = true)
    protected byte[] base64;

    /**
     * Gets the value of the base64 property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBase64() {
        return base64;
    }

    /**
     * Sets the value of the base64 property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBase64(byte[] value) {
        this.base64 = value;
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
            byte[] theBase64;
            theBase64 = this.getBase64();
            strategy.appendField(locator, this, "base64", buffer, theBase64, (this.base64 != null));
        }
        return buffer;
    }

}
