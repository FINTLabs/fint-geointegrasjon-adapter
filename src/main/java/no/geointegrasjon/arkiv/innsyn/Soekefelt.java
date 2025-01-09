
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
 * <p>Java class for Soekefelt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Soekefelt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31}Kriterie"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="feltnavn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="feltverdi" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Soekefelt", namespace = "http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31", propOrder = {
    "feltnavn",
    "feltverdi"
})
public class Soekefelt
    extends Kriterie
    implements ToString2
{

    @XmlElement(required = true)
    protected String feltnavn;
    @XmlElement(required = true)
    protected String feltverdi;

    /**
     * Gets the value of the feltnavn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeltnavn() {
        return feltnavn;
    }

    /**
     * Sets the value of the feltnavn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeltnavn(String value) {
        this.feltnavn = value;
    }

    /**
     * Gets the value of the feltverdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeltverdi() {
        return feltverdi;
    }

    /**
     * Sets the value of the feltverdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeltverdi(String value) {
        this.feltverdi = value;
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
            String theFeltnavn;
            theFeltnavn = this.getFeltnavn();
            strategy.appendField(locator, this, "feltnavn", buffer, theFeltnavn, (this.feltnavn!= null));
        }
        {
            String theFeltverdi;
            theFeltverdi = this.getFeltverdi();
            strategy.appendField(locator, this, "feltverdi", buffer, theFeltverdi, (this.feltverdi!= null));
        }
        return buffer;
    }

}
