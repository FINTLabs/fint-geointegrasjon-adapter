
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
 * <p>Java class for Meldingsboks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Meldingsboks"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31}ElektroniskAdresse"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tilbyder" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="meldingsboksadresse" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Meldingsboks", namespace = "http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31", propOrder = {
    "tilbyder",
    "meldingsboksadresse"
})
public class Meldingsboks
    extends ElektroniskAdresse
    implements ToString2
{

    @XmlElement(required = true)
    protected String tilbyder;
    @XmlElement(required = true)
    protected String meldingsboksadresse;

    /**
     * Gets the value of the tilbyder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTilbyder() {
        return tilbyder;
    }

    /**
     * Sets the value of the tilbyder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTilbyder(String value) {
        this.tilbyder = value;
    }

    /**
     * Gets the value of the meldingsboksadresse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMeldingsboksadresse() {
        return meldingsboksadresse;
    }

    /**
     * Sets the value of the meldingsboksadresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMeldingsboksadresse(String value) {
        this.meldingsboksadresse = value;
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
            String theTilbyder;
            theTilbyder = this.getTilbyder();
            strategy.appendField(locator, this, "tilbyder", buffer, theTilbyder, (this.tilbyder!= null));
        }
        {
            String theMeldingsboksadresse;
            theMeldingsboksadresse = this.getMeldingsboksadresse();
            strategy.appendField(locator, this, "meldingsboksadresse", buffer, theMeldingsboksadresse, (this.meldingsboksadresse!= null));
        }
        return buffer;
    }

}
