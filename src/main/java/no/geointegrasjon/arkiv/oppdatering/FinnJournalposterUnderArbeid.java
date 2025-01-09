
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
 *         &lt;element name="ansvarlig" type="{http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31}Ansvarlig" minOccurs="0"/&gt;
 *         &lt;element name="returnerMerknad" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="returnerTilleggsinformasjon" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="returnerKorrespondansepart" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="returnerAvskrivning" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
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
    "ansvarlig",
    "returnerMerknad",
    "returnerTilleggsinformasjon",
    "returnerKorrespondansepart",
    "returnerAvskrivning",
    "kontekst"
})
@XmlRootElement(name = "FinnJournalposterUnderArbeid")
public class FinnJournalposterUnderArbeid implements ToString2
{

    protected Ansvarlig ansvarlig;
    protected Boolean returnerMerknad;
    protected Boolean returnerTilleggsinformasjon;
    protected Boolean returnerKorrespondansepart;
    protected Boolean returnerAvskrivning;
    protected ArkivKontekst kontekst;

    /**
     * Gets the value of the ansvarlig property.
     * 
     * @return
     *     possible object is
     *     {@link Ansvarlig }
     *     
     */
    public Ansvarlig getAnsvarlig() {
        return ansvarlig;
    }

    /**
     * Sets the value of the ansvarlig property.
     * 
     * @param value
     *     allowed object is
     *     {@link Ansvarlig }
     *     
     */
    public void setAnsvarlig(Ansvarlig value) {
        this.ansvarlig = value;
    }

    /**
     * Gets the value of the returnerMerknad property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnerMerknad() {
        return returnerMerknad;
    }

    /**
     * Sets the value of the returnerMerknad property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnerMerknad(Boolean value) {
        this.returnerMerknad = value;
    }

    /**
     * Gets the value of the returnerTilleggsinformasjon property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnerTilleggsinformasjon() {
        return returnerTilleggsinformasjon;
    }

    /**
     * Sets the value of the returnerTilleggsinformasjon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnerTilleggsinformasjon(Boolean value) {
        this.returnerTilleggsinformasjon = value;
    }

    /**
     * Gets the value of the returnerKorrespondansepart property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnerKorrespondansepart() {
        return returnerKorrespondansepart;
    }

    /**
     * Sets the value of the returnerKorrespondansepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnerKorrespondansepart(Boolean value) {
        this.returnerKorrespondansepart = value;
    }

    /**
     * Gets the value of the returnerAvskrivning property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isReturnerAvskrivning() {
        return returnerAvskrivning;
    }

    /**
     * Sets the value of the returnerAvskrivning property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setReturnerAvskrivning(Boolean value) {
        this.returnerAvskrivning = value;
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
            Ansvarlig theAnsvarlig;
            theAnsvarlig = this.getAnsvarlig();
            strategy.appendField(locator, this, "ansvarlig", buffer, theAnsvarlig, (this.ansvarlig!= null));
        }
        {
            Boolean theReturnerMerknad;
            theReturnerMerknad = this.isReturnerMerknad();
            strategy.appendField(locator, this, "returnerMerknad", buffer, theReturnerMerknad, (this.returnerMerknad!= null));
        }
        {
            Boolean theReturnerTilleggsinformasjon;
            theReturnerTilleggsinformasjon = this.isReturnerTilleggsinformasjon();
            strategy.appendField(locator, this, "returnerTilleggsinformasjon", buffer, theReturnerTilleggsinformasjon, (this.returnerTilleggsinformasjon!= null));
        }
        {
            Boolean theReturnerKorrespondansepart;
            theReturnerKorrespondansepart = this.isReturnerKorrespondansepart();
            strategy.appendField(locator, this, "returnerKorrespondansepart", buffer, theReturnerKorrespondansepart, (this.returnerKorrespondansepart!= null));
        }
        {
            Boolean theReturnerAvskrivning;
            theReturnerAvskrivning = this.isReturnerAvskrivning();
            strategy.appendField(locator, this, "returnerAvskrivning", buffer, theReturnerAvskrivning, (this.returnerAvskrivning!= null));
        }
        {
            ArkivKontekst theKontekst;
            theKontekst = this.getKontekst();
            strategy.appendField(locator, this, "kontekst", buffer, theKontekst, (this.kontekst!= null));
        }
        return buffer;
    }

}
