
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for PostadministrativeOmraader complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PostadministrativeOmraader"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="postnummer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="poststed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PostadministrativeOmraader", namespace = "http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31", propOrder = {
    "postnummer",
    "poststed"
})
public class PostadministrativeOmraader implements ToString2
{

    protected String postnummer;
    protected String poststed;

    /**
     * Gets the value of the postnummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPostnummer() {
        return postnummer;
    }

    /**
     * Sets the value of the postnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPostnummer(String value) {
        this.postnummer = value;
    }

    /**
     * Gets the value of the poststed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPoststed() {
        return poststed;
    }

    /**
     * Sets the value of the poststed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPoststed(String value) {
        this.poststed = value;
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
            String thePostnummer;
            thePostnummer = this.getPostnummer();
            strategy.appendField(locator, this, "postnummer", buffer, thePostnummer, (this.postnummer!= null));
        }
        {
            String thePoststed;
            thePoststed = this.getPoststed();
            strategy.appendField(locator, this, "poststed", buffer, thePoststed, (this.poststed!= null));
        }
        return buffer;
    }

}
