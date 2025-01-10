
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Avskrivning complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Avskrivning"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="systemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="avskrivningsdato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="avskrevetAv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="avskrivningsmaate" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Avskrivningsmaate" minOccurs="0"/&gt;
 *         &lt;element name="referanseAvskriverJournalnummer" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Journalnummer" minOccurs="0"/&gt;
 *         &lt;element name="referanseAvskrivesAvJournalnummer" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Journalnummer" minOccurs="0"/&gt;
 *         &lt;element name="referanseAvskriverEksternNoekkel" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}EksternNoekkel" minOccurs="0"/&gt;
 *         &lt;element name="referanseAvskrivesAvEksternNoekkel" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}EksternNoekkel" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Avskrivning", propOrder = {
    "systemID",
    "avskrivningsdato",
    "avskrevetAv",
    "avskrivningsmaate",
    "referanseAvskriverJournalnummer",
    "referanseAvskrivesAvJournalnummer",
    "referanseAvskriverEksternNoekkel",
    "referanseAvskrivesAvEksternNoekkel"
})
public class Avskrivning implements ToString2
{

    protected String systemID;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar avskrivningsdato;
    protected String avskrevetAv;
    protected Avskrivningsmaate avskrivningsmaate;
    protected Journalnummer referanseAvskriverJournalnummer;
    protected Journalnummer referanseAvskrivesAvJournalnummer;
    protected EksternNoekkel referanseAvskriverEksternNoekkel;
    protected EksternNoekkel referanseAvskrivesAvEksternNoekkel;

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
     * Gets the value of the avskrivningsdato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAvskrivningsdato() {
        return avskrivningsdato;
    }

    /**
     * Sets the value of the avskrivningsdato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAvskrivningsdato(XMLGregorianCalendar value) {
        this.avskrivningsdato = value;
    }

    /**
     * Gets the value of the avskrevetAv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAvskrevetAv() {
        return avskrevetAv;
    }

    /**
     * Sets the value of the avskrevetAv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAvskrevetAv(String value) {
        this.avskrevetAv = value;
    }

    /**
     * Gets the value of the avskrivningsmaate property.
     * 
     * @return
     *     possible object is
     *     {@link Avskrivningsmaate }
     *     
     */
    public Avskrivningsmaate getAvskrivningsmaate() {
        return avskrivningsmaate;
    }

    /**
     * Sets the value of the avskrivningsmaate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Avskrivningsmaate }
     *     
     */
    public void setAvskrivningsmaate(Avskrivningsmaate value) {
        this.avskrivningsmaate = value;
    }

    /**
     * Gets the value of the referanseAvskriverJournalnummer property.
     * 
     * @return
     *     possible object is
     *     {@link Journalnummer }
     *     
     */
    public Journalnummer getReferanseAvskriverJournalnummer() {
        return referanseAvskriverJournalnummer;
    }

    /**
     * Sets the value of the referanseAvskriverJournalnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Journalnummer }
     *     
     */
    public void setReferanseAvskriverJournalnummer(Journalnummer value) {
        this.referanseAvskriverJournalnummer = value;
    }

    /**
     * Gets the value of the referanseAvskrivesAvJournalnummer property.
     * 
     * @return
     *     possible object is
     *     {@link Journalnummer }
     *     
     */
    public Journalnummer getReferanseAvskrivesAvJournalnummer() {
        return referanseAvskrivesAvJournalnummer;
    }

    /**
     * Sets the value of the referanseAvskrivesAvJournalnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Journalnummer }
     *     
     */
    public void setReferanseAvskrivesAvJournalnummer(Journalnummer value) {
        this.referanseAvskrivesAvJournalnummer = value;
    }

    /**
     * Gets the value of the referanseAvskriverEksternNoekkel property.
     * 
     * @return
     *     possible object is
     *     {@link EksternNoekkel }
     *     
     */
    public EksternNoekkel getReferanseAvskriverEksternNoekkel() {
        return referanseAvskriverEksternNoekkel;
    }

    /**
     * Sets the value of the referanseAvskriverEksternNoekkel property.
     * 
     * @param value
     *     allowed object is
     *     {@link EksternNoekkel }
     *     
     */
    public void setReferanseAvskriverEksternNoekkel(EksternNoekkel value) {
        this.referanseAvskriverEksternNoekkel = value;
    }

    /**
     * Gets the value of the referanseAvskrivesAvEksternNoekkel property.
     * 
     * @return
     *     possible object is
     *     {@link EksternNoekkel }
     *     
     */
    public EksternNoekkel getReferanseAvskrivesAvEksternNoekkel() {
        return referanseAvskrivesAvEksternNoekkel;
    }

    /**
     * Sets the value of the referanseAvskrivesAvEksternNoekkel property.
     * 
     * @param value
     *     allowed object is
     *     {@link EksternNoekkel }
     *     
     */
    public void setReferanseAvskrivesAvEksternNoekkel(EksternNoekkel value) {
        this.referanseAvskrivesAvEksternNoekkel = value;
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
            XMLGregorianCalendar theAvskrivningsdato;
            theAvskrivningsdato = this.getAvskrivningsdato();
            strategy.appendField(locator, this, "avskrivningsdato", buffer, theAvskrivningsdato, (this.avskrivningsdato!= null));
        }
        {
            String theAvskrevetAv;
            theAvskrevetAv = this.getAvskrevetAv();
            strategy.appendField(locator, this, "avskrevetAv", buffer, theAvskrevetAv, (this.avskrevetAv!= null));
        }
        {
            Avskrivningsmaate theAvskrivningsmaate;
            theAvskrivningsmaate = this.getAvskrivningsmaate();
            strategy.appendField(locator, this, "avskrivningsmaate", buffer, theAvskrivningsmaate, (this.avskrivningsmaate!= null));
        }
        {
            Journalnummer theReferanseAvskriverJournalnummer;
            theReferanseAvskriverJournalnummer = this.getReferanseAvskriverJournalnummer();
            strategy.appendField(locator, this, "referanseAvskriverJournalnummer", buffer, theReferanseAvskriverJournalnummer, (this.referanseAvskriverJournalnummer!= null));
        }
        {
            Journalnummer theReferanseAvskrivesAvJournalnummer;
            theReferanseAvskrivesAvJournalnummer = this.getReferanseAvskrivesAvJournalnummer();
            strategy.appendField(locator, this, "referanseAvskrivesAvJournalnummer", buffer, theReferanseAvskrivesAvJournalnummer, (this.referanseAvskrivesAvJournalnummer!= null));
        }
        {
            EksternNoekkel theReferanseAvskriverEksternNoekkel;
            theReferanseAvskriverEksternNoekkel = this.getReferanseAvskriverEksternNoekkel();
            strategy.appendField(locator, this, "referanseAvskriverEksternNoekkel", buffer, theReferanseAvskriverEksternNoekkel, (this.referanseAvskriverEksternNoekkel!= null));
        }
        {
            EksternNoekkel theReferanseAvskrivesAvEksternNoekkel;
            theReferanseAvskrivesAvEksternNoekkel = this.getReferanseAvskrivesAvEksternNoekkel();
            strategy.appendField(locator, this, "referanseAvskrivesAvEksternNoekkel", buffer, theReferanseAvskrivesAvEksternNoekkel, (this.referanseAvskrivesAvEksternNoekkel!= null));
        }
        return buffer;
    }

}
