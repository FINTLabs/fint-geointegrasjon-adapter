
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
 * <p>Java class for Sakspart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Sakspart"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="systemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="skjermetSakspart" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="kortnavn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="kontaktperson" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sakspartRolle" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}SakspartRolle" minOccurs="0"/&gt;
 *         &lt;element name="merknad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Kontakt" type="{http://rep.geointegrasjon.no/Felles/Kontakt/xml.schema/2012.01.31}Kontakt"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Sakspart", namespace = "http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31", propOrder = {
    "systemID",
    "skjermetSakspart",
    "kortnavn",
    "kontaktperson",
    "sakspartRolle",
    "merknad",
    "kontakt"
})
public class Sakspart implements ToString2
{

    protected String systemID;
    protected Boolean skjermetSakspart;
    protected String kortnavn;
    protected String kontaktperson;
    protected SakspartRolle sakspartRolle;
    protected String merknad;
    @XmlElement(name = "Kontakt", required = true)
    protected Kontakt kontakt;

    /**
     * Gets the value of the systemID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemID() {
        return systemID;
    }

    /**
     * Sets the value of the systemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemID(String value) {
        this.systemID = value;
    }

    /**
     * Gets the value of the skjermetSakspart property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkjermetSakspart() {
        return skjermetSakspart;
    }

    /**
     * Sets the value of the skjermetSakspart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkjermetSakspart(Boolean value) {
        this.skjermetSakspart = value;
    }

    /**
     * Gets the value of the kortnavn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKortnavn() {
        return kortnavn;
    }

    /**
     * Sets the value of the kortnavn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKortnavn(String value) {
        this.kortnavn = value;
    }

    /**
     * Gets the value of the kontaktperson property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKontaktperson() {
        return kontaktperson;
    }

    /**
     * Sets the value of the kontaktperson property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKontaktperson(String value) {
        this.kontaktperson = value;
    }

    /**
     * Gets the value of the sakspartRolle property.
     * 
     * @return
     *     possible object is
     *     {@link SakspartRolle }
     *     
     */
    public SakspartRolle getSakspartRolle() {
        return sakspartRolle;
    }

    /**
     * Sets the value of the sakspartRolle property.
     * 
     * @param value
     *     allowed object is
     *     {@link SakspartRolle }
     *     
     */
    public void setSakspartRolle(SakspartRolle value) {
        this.sakspartRolle = value;
    }

    /**
     * Gets the value of the merknad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerknad() {
        return merknad;
    }

    /**
     * Sets the value of the merknad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerknad(String value) {
        this.merknad = value;
    }

    /**
     * Gets the value of the kontakt property.
     * 
     * @return
     *     possible object is
     *     {@link Kontakt }
     *     
     */
    public Kontakt getKontakt() {
        return kontakt;
    }

    /**
     * Sets the value of the kontakt property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kontakt }
     *     
     */
    public void setKontakt(Kontakt value) {
        this.kontakt = value;
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
            String theSystemID;
            theSystemID = this.getSystemID();
            strategy.appendField(locator, this, "systemID", buffer, theSystemID, (this.systemID!= null));
        }
        {
            Boolean theSkjermetSakspart;
            theSkjermetSakspart = this.isSkjermetSakspart();
            strategy.appendField(locator, this, "skjermetSakspart", buffer, theSkjermetSakspart, (this.skjermetSakspart!= null));
        }
        {
            String theKortnavn;
            theKortnavn = this.getKortnavn();
            strategy.appendField(locator, this, "kortnavn", buffer, theKortnavn, (this.kortnavn!= null));
        }
        {
            String theKontaktperson;
            theKontaktperson = this.getKontaktperson();
            strategy.appendField(locator, this, "kontaktperson", buffer, theKontaktperson, (this.kontaktperson!= null));
        }
        {
            SakspartRolle theSakspartRolle;
            theSakspartRolle = this.getSakspartRolle();
            strategy.appendField(locator, this, "sakspartRolle", buffer, theSakspartRolle, (this.sakspartRolle!= null));
        }
        {
            String theMerknad;
            theMerknad = this.getMerknad();
            strategy.appendField(locator, this, "merknad", buffer, theMerknad, (this.merknad!= null));
        }
        {
            Kontakt theKontakt;
            theKontakt = this.getKontakt();
            strategy.appendField(locator, this, "kontakt", buffer, theKontakt, (this.kontakt!= null));
        }
        return buffer;
    }

}
