
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for ArkivKontekst complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArkivKontekst"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Teknisk/xml.schema/2012.01.31}Kontekst"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="koordinatsystem" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}KoordinatsystemKode" minOccurs="0"/&gt;
 *         &lt;element name="referanseoppsett" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArkivKontekst", namespace = "http://rep.geointegrasjon.no/Felles/Teknisk/xml.schema/2012.01.31", propOrder = {
    "koordinatsystem",
    "referanseoppsett"
})
public class ArkivKontekst
    extends Kontekst
    implements ToString2
{

    protected KoordinatsystemKode koordinatsystem;
    protected String referanseoppsett;

    /**
     * Gets the value of the koordinatsystem property.
     * 
     * @return
     *     possible object is
     *     {@link KoordinatsystemKode }
     *     
     */
    public KoordinatsystemKode getKoordinatsystem() {
        return koordinatsystem;
    }

    /**
     * Sets the value of the koordinatsystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link KoordinatsystemKode }
     *     
     */
    public void setKoordinatsystem(KoordinatsystemKode value) {
        this.koordinatsystem = value;
    }

    /**
     * Gets the value of the referanseoppsett property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferanseoppsett() {
        return referanseoppsett;
    }

    /**
     * Sets the value of the referanseoppsett property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferanseoppsett(String value) {
        this.referanseoppsett = value;
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
            KoordinatsystemKode theKoordinatsystem;
            theKoordinatsystem = this.getKoordinatsystem();
            strategy.appendField(locator, this, "koordinatsystem", buffer, theKoordinatsystem, (this.koordinatsystem!= null));
        }
        {
            String theReferanseoppsett;
            theReferanseoppsett = this.getReferanseoppsett();
            strategy.appendField(locator, this, "referanseoppsett", buffer, theReferanseoppsett, (this.referanseoppsett!= null));
        }
        return buffer;
    }

}
