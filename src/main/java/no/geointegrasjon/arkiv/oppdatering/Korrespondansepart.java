
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Korrespondansepart complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Korrespondansepart"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="systemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="korrespondanseparttype" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Korrespondanseparttype"/&gt;
 *         &lt;element name="behandlingsansvarlig" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="skjermetKorrespondansepart" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="kortnavn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deresReferanse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="journalenhet" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Journalenhet" minOccurs="0"/&gt;
 *         &lt;element name="fristBesvarelse" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="forsendelsesmaate" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Forsendelsesmaate" minOccurs="0"/&gt;
 *         &lt;element name="administrativEnhetInit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="administrativEnhet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="saksbehandlerInit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="saksbehandler" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
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
@XmlType(name = "Korrespondansepart", namespace = "http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31", propOrder = {
    "systemID",
    "korrespondanseparttype",
    "behandlingsansvarlig",
    "skjermetKorrespondansepart",
    "kortnavn",
    "deresReferanse",
    "journalenhet",
    "fristBesvarelse",
    "forsendelsesmaate",
    "administrativEnhetInit",
    "administrativEnhet",
    "saksbehandlerInit",
    "saksbehandler",
    "kontakt"
})
public class Korrespondansepart implements ToString2
{

    protected String systemID;
    @XmlElement(required = true)
    protected Korrespondanseparttype korrespondanseparttype;
    protected String behandlingsansvarlig;
    protected Boolean skjermetKorrespondansepart;
    protected String kortnavn;
    protected String deresReferanse;
    protected Journalenhet journalenhet;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fristBesvarelse;
    protected Forsendelsesmaate forsendelsesmaate;
    protected String administrativEnhetInit;
    protected String administrativEnhet;
    protected String saksbehandlerInit;
    protected String saksbehandler;
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
     * Gets the value of the korrespondanseparttype property.
     * 
     * @return
     *     possible object is
     *     {@link Korrespondanseparttype }
     *     
     */
    public Korrespondanseparttype getKorrespondanseparttype() {
        return korrespondanseparttype;
    }

    /**
     * Sets the value of the korrespondanseparttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Korrespondanseparttype }
     *     
     */
    public void setKorrespondanseparttype(Korrespondanseparttype value) {
        this.korrespondanseparttype = value;
    }

    /**
     * Gets the value of the behandlingsansvarlig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBehandlingsansvarlig() {
        return behandlingsansvarlig;
    }

    /**
     * Sets the value of the behandlingsansvarlig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBehandlingsansvarlig(String value) {
        this.behandlingsansvarlig = value;
    }

    /**
     * Gets the value of the skjermetKorrespondansepart property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkjermetKorrespondansepart() {
        return skjermetKorrespondansepart;
    }

    /**
     * Sets the value of the skjermetKorrespondansepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkjermetKorrespondansepart(Boolean value) {
        this.skjermetKorrespondansepart = value;
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
     * Gets the value of the deresReferanse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeresReferanse() {
        return deresReferanse;
    }

    /**
     * Sets the value of the deresReferanse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeresReferanse(String value) {
        this.deresReferanse = value;
    }

    /**
     * Gets the value of the journalenhet property.
     * 
     * @return
     *     possible object is
     *     {@link Journalenhet }
     *     
     */
    public Journalenhet getJournalenhet() {
        return journalenhet;
    }

    /**
     * Sets the value of the journalenhet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Journalenhet }
     *     
     */
    public void setJournalenhet(Journalenhet value) {
        this.journalenhet = value;
    }

    /**
     * Gets the value of the fristBesvarelse property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFristBesvarelse() {
        return fristBesvarelse;
    }

    /**
     * Sets the value of the fristBesvarelse property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFristBesvarelse(XMLGregorianCalendar value) {
        this.fristBesvarelse = value;
    }

    /**
     * Gets the value of the forsendelsesmaate property.
     * 
     * @return
     *     possible object is
     *     {@link Forsendelsesmaate }
     *     
     */
    public Forsendelsesmaate getForsendelsesmaate() {
        return forsendelsesmaate;
    }

    /**
     * Sets the value of the forsendelsesmaate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Forsendelsesmaate }
     *     
     */
    public void setForsendelsesmaate(Forsendelsesmaate value) {
        this.forsendelsesmaate = value;
    }

    /**
     * Gets the value of the administrativEnhetInit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdministrativEnhetInit() {
        return administrativEnhetInit;
    }

    /**
     * Sets the value of the administrativEnhetInit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdministrativEnhetInit(String value) {
        this.administrativEnhetInit = value;
    }

    /**
     * Gets the value of the administrativEnhet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdministrativEnhet() {
        return administrativEnhet;
    }

    /**
     * Sets the value of the administrativEnhet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdministrativEnhet(String value) {
        this.administrativEnhet = value;
    }

    /**
     * Gets the value of the saksbehandlerInit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaksbehandlerInit() {
        return saksbehandlerInit;
    }

    /**
     * Sets the value of the saksbehandlerInit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaksbehandlerInit(String value) {
        this.saksbehandlerInit = value;
    }

    /**
     * Gets the value of the saksbehandler property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaksbehandler() {
        return saksbehandler;
    }

    /**
     * Sets the value of the saksbehandler property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaksbehandler(String value) {
        this.saksbehandler = value;
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
            Korrespondanseparttype theKorrespondanseparttype;
            theKorrespondanseparttype = this.getKorrespondanseparttype();
            strategy.appendField(locator, this, "korrespondanseparttype", buffer, theKorrespondanseparttype, (this.korrespondanseparttype!= null));
        }
        {
            String theBehandlingsansvarlig;
            theBehandlingsansvarlig = this.getBehandlingsansvarlig();
            strategy.appendField(locator, this, "behandlingsansvarlig", buffer, theBehandlingsansvarlig, (this.behandlingsansvarlig!= null));
        }
        {
            Boolean theSkjermetKorrespondansepart;
            theSkjermetKorrespondansepart = this.isSkjermetKorrespondansepart();
            strategy.appendField(locator, this, "skjermetKorrespondansepart", buffer, theSkjermetKorrespondansepart, (this.skjermetKorrespondansepart!= null));
        }
        {
            String theKortnavn;
            theKortnavn = this.getKortnavn();
            strategy.appendField(locator, this, "kortnavn", buffer, theKortnavn, (this.kortnavn!= null));
        }
        {
            String theDeresReferanse;
            theDeresReferanse = this.getDeresReferanse();
            strategy.appendField(locator, this, "deresReferanse", buffer, theDeresReferanse, (this.deresReferanse!= null));
        }
        {
            Journalenhet theJournalenhet;
            theJournalenhet = this.getJournalenhet();
            strategy.appendField(locator, this, "journalenhet", buffer, theJournalenhet, (this.journalenhet!= null));
        }
        {
            XMLGregorianCalendar theFristBesvarelse;
            theFristBesvarelse = this.getFristBesvarelse();
            strategy.appendField(locator, this, "fristBesvarelse", buffer, theFristBesvarelse, (this.fristBesvarelse!= null));
        }
        {
            Forsendelsesmaate theForsendelsesmaate;
            theForsendelsesmaate = this.getForsendelsesmaate();
            strategy.appendField(locator, this, "forsendelsesmaate", buffer, theForsendelsesmaate, (this.forsendelsesmaate!= null));
        }
        {
            String theAdministrativEnhetInit;
            theAdministrativEnhetInit = this.getAdministrativEnhetInit();
            strategy.appendField(locator, this, "administrativEnhetInit", buffer, theAdministrativEnhetInit, (this.administrativEnhetInit!= null));
        }
        {
            String theAdministrativEnhet;
            theAdministrativEnhet = this.getAdministrativEnhet();
            strategy.appendField(locator, this, "administrativEnhet", buffer, theAdministrativEnhet, (this.administrativEnhet!= null));
        }
        {
            String theSaksbehandlerInit;
            theSaksbehandlerInit = this.getSaksbehandlerInit();
            strategy.appendField(locator, this, "saksbehandlerInit", buffer, theSaksbehandlerInit, (this.saksbehandlerInit!= null));
        }
        {
            String theSaksbehandler;
            theSaksbehandler = this.getSaksbehandler();
            strategy.appendField(locator, this, "saksbehandler", buffer, theSaksbehandler, (this.saksbehandler!= null));
        }
        {
            Kontakt theKontakt;
            theKontakt = this.getKontakt();
            strategy.appendField(locator, this, "kontakt", buffer, theKontakt, (this.kontakt!= null));
        }
        return buffer;
    }

}
