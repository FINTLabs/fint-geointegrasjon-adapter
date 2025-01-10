
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Fil complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Fil"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="filnavn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="mimeType" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Fil", namespace = "http://rep.geointegrasjon.no/Arkiv/Dokument/xml.schema/2012.01.31", propOrder = {
    "filnavn",
    "mimeType"
})
@XmlSeeAlso({
    Filinnhold.class,
    Filreferanse.class
})
public class Fil implements ToString2
{

    @XmlElement(required = true)
    protected String filnavn;
    @XmlElement(required = true)
    protected String mimeType;

    /**
     * Gets the value of the filnavn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFilnavn() {
        return filnavn;
    }

    /**
     * Sets the value of the filnavn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFilnavn(String value) {
        this.filnavn = value;
    }

    /**
     * Gets the value of the mimeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Sets the value of the mimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMimeType(String value) {
        this.mimeType = value;
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
            String theFilnavn;
            theFilnavn = this.getFilnavn();
            strategy.appendField(locator, this, "filnavn", buffer, theFilnavn, (this.filnavn!= null));
        }
        {
            String theMimeType;
            theMimeType = this.getMimeType();
            strategy.appendField(locator, this, "mimeType", buffer, theMimeType, (this.mimeType!= null));
        }
        return buffer;
    }

}
