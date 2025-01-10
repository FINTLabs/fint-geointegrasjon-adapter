
package no.geointegrasjon.arkiv.innsyn;

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
 * <p>Java class for Tilleggsinformasjon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Tilleggsinformasjon"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="systemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="rekkefoelge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="informasjonstype" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Informasjonstype"/&gt;
 *         &lt;element name="tilgangsrestriksjon" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Tilgangsrestriksjon" minOccurs="0"/&gt;
 *         &lt;element name="oppbevaresTilDato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="informasjon" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="tilgangsgruppeNavn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="registrertDato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="registrertAv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="registrertAvInit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Tilleggsinformasjon", propOrder = {
    "systemID",
    "rekkefoelge",
    "informasjonstype",
    "tilgangsrestriksjon",
    "oppbevaresTilDato",
    "informasjon",
    "tilgangsgruppeNavn",
    "registrertDato",
    "registrertAv",
    "registrertAvInit"
})
public class Tilleggsinformasjon implements ToString2
{

    protected String systemID;
    protected String rekkefoelge;
    @XmlElement(required = true)
    protected Informasjonstype informasjonstype;
    protected Tilgangsrestriksjon tilgangsrestriksjon;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar oppbevaresTilDato;
    @XmlElement(required = true)
    protected String informasjon;
    protected String tilgangsgruppeNavn;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar registrertDato;
    protected String registrertAv;
    protected String registrertAvInit;

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
     * Gets the value of the rekkefoelge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRekkefoelge() {
        return rekkefoelge;
    }

    /**
     * Sets the value of the rekkefoelge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRekkefoelge(String value) {
        this.rekkefoelge = value;
    }

    /**
     * Gets the value of the informasjonstype property.
     * 
     * @return
     *     possible object is
     *     {@link Informasjonstype }
     *     
     */
    public Informasjonstype getInformasjonstype() {
        return informasjonstype;
    }

    /**
     * Sets the value of the informasjonstype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Informasjonstype }
     *     
     */
    public void setInformasjonstype(Informasjonstype value) {
        this.informasjonstype = value;
    }

    /**
     * Gets the value of the tilgangsrestriksjon property.
     * 
     * @return
     *     possible object is
     *     {@link Tilgangsrestriksjon }
     *     
     */
    public Tilgangsrestriksjon getTilgangsrestriksjon() {
        return tilgangsrestriksjon;
    }

    /**
     * Sets the value of the tilgangsrestriksjon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tilgangsrestriksjon }
     *     
     */
    public void setTilgangsrestriksjon(Tilgangsrestriksjon value) {
        this.tilgangsrestriksjon = value;
    }

    /**
     * Gets the value of the oppbevaresTilDato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOppbevaresTilDato() {
        return oppbevaresTilDato;
    }

    /**
     * Sets the value of the oppbevaresTilDato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOppbevaresTilDato(XMLGregorianCalendar value) {
        this.oppbevaresTilDato = value;
    }

    /**
     * Gets the value of the informasjon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformasjon() {
        return informasjon;
    }

    /**
     * Sets the value of the informasjon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformasjon(String value) {
        this.informasjon = value;
    }

    /**
     * Gets the value of the tilgangsgruppeNavn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTilgangsgruppeNavn() {
        return tilgangsgruppeNavn;
    }

    /**
     * Sets the value of the tilgangsgruppeNavn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTilgangsgruppeNavn(String value) {
        this.tilgangsgruppeNavn = value;
    }

    /**
     * Gets the value of the registrertDato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRegistrertDato() {
        return registrertDato;
    }

    /**
     * Sets the value of the registrertDato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRegistrertDato(XMLGregorianCalendar value) {
        this.registrertDato = value;
    }

    /**
     * Gets the value of the registrertAv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrertAv() {
        return registrertAv;
    }

    /**
     * Sets the value of the registrertAv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrertAv(String value) {
        this.registrertAv = value;
    }

    /**
     * Gets the value of the registrertAvInit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegistrertAvInit() {
        return registrertAvInit;
    }

    /**
     * Sets the value of the registrertAvInit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegistrertAvInit(String value) {
        this.registrertAvInit = value;
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
            String theRekkefoelge;
            theRekkefoelge = this.getRekkefoelge();
            strategy.appendField(locator, this, "rekkefoelge", buffer, theRekkefoelge, (this.rekkefoelge!= null));
        }
        {
            Informasjonstype theInformasjonstype;
            theInformasjonstype = this.getInformasjonstype();
            strategy.appendField(locator, this, "informasjonstype", buffer, theInformasjonstype, (this.informasjonstype!= null));
        }
        {
            Tilgangsrestriksjon theTilgangsrestriksjon;
            theTilgangsrestriksjon = this.getTilgangsrestriksjon();
            strategy.appendField(locator, this, "tilgangsrestriksjon", buffer, theTilgangsrestriksjon, (this.tilgangsrestriksjon!= null));
        }
        {
            XMLGregorianCalendar theOppbevaresTilDato;
            theOppbevaresTilDato = this.getOppbevaresTilDato();
            strategy.appendField(locator, this, "oppbevaresTilDato", buffer, theOppbevaresTilDato, (this.oppbevaresTilDato!= null));
        }
        {
            String theInformasjon;
            theInformasjon = this.getInformasjon();
            strategy.appendField(locator, this, "informasjon", buffer, theInformasjon, (this.informasjon!= null));
        }
        {
            String theTilgangsgruppeNavn;
            theTilgangsgruppeNavn = this.getTilgangsgruppeNavn();
            strategy.appendField(locator, this, "tilgangsgruppeNavn", buffer, theTilgangsgruppeNavn, (this.tilgangsgruppeNavn!= null));
        }
        {
            XMLGregorianCalendar theRegistrertDato;
            theRegistrertDato = this.getRegistrertDato();
            strategy.appendField(locator, this, "registrertDato", buffer, theRegistrertDato, (this.registrertDato!= null));
        }
        {
            String theRegistrertAv;
            theRegistrertAv = this.getRegistrertAv();
            strategy.appendField(locator, this, "registrertAv", buffer, theRegistrertAv, (this.registrertAv!= null));
        }
        {
            String theRegistrertAvInit;
            theRegistrertAvInit = this.getRegistrertAvInit();
            strategy.appendField(locator, this, "registrertAvInit", buffer, theRegistrertAvInit, (this.registrertAvInit!= null));
        }
        return buffer;
    }

}
