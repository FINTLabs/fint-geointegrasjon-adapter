
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="sakspart" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}SakspartListe" minOccurs="0"/&gt;
 *         &lt;element name="saksnokkel" type="{http://rep.geointegrasjon.no/Arkiv/Felles/xml.schema/2012.01.31}Saksnoekkel" minOccurs="0"/&gt;
 *         &lt;element name="kontekst" type="{http://rep.geointegrasjon.no/Felles/Teknisk/xml.schema/2012.01.31}ArkivKontekst" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sakspart",
    "saksnokkel",
    "kontekst"
})
@XmlRootElement(name = "NySakspart")
public class NySakspart implements ToString2
{

    protected SakspartListe sakspart;
    protected Saksnoekkel saksnokkel;
    protected ArkivKontekst kontekst;

    /**
     * Gets the value of the sakspart property.
     * 
     * @return
     *     possible object is
     *     {@link SakspartListe }
     *     
     */
    public SakspartListe getSakspart() {
        return sakspart;
    }

    /**
     * Sets the value of the sakspart property.
     * 
     * @param value
     *     allowed object is
     *     {@link SakspartListe }
     *     
     */
    public void setSakspart(SakspartListe value) {
        this.sakspart = value;
    }

    /**
     * Gets the value of the saksnokkel property.
     * 
     * @return
     *     possible object is
     *     {@link Saksnoekkel }
     *     
     */
    public Saksnoekkel getSaksnokkel() {
        return saksnokkel;
    }

    /**
     * Sets the value of the saksnokkel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Saksnoekkel }
     *     
     */
    public void setSaksnokkel(Saksnoekkel value) {
        this.saksnokkel = value;
    }

    /**
     * Gets the value of the kontekst property.
     * 
     * @return
     *     possible object is
     *     {@link ArkivKontekst }
     *     
     */
    public ArkivKontekst getKontekst() {
        return kontekst;
    }

    /**
     * Sets the value of the kontekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArkivKontekst }
     *     
     */
    public void setKontekst(ArkivKontekst value) {
        this.kontekst = value;
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
            SakspartListe theSakspart;
            theSakspart = this.getSakspart();
            strategy.appendField(locator, this, "sakspart", buffer, theSakspart, (this.sakspart!= null));
        }
        {
            Saksnoekkel theSaksnokkel;
            theSaksnokkel = this.getSaksnokkel();
            strategy.appendField(locator, this, "saksnokkel", buffer, theSaksnokkel, (this.saksnokkel!= null));
        }
        {
            ArkivKontekst theKontekst;
            theKontekst = this.getKontekst();
            strategy.appendField(locator, this, "kontekst", buffer, theKontekst, (this.kontekst!= null));
        }
        return buffer;
    }

}
