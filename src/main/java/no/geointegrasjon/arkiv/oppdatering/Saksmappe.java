
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
 * <p>Java class for Saksmappe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Saksmappe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="systemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="saksnr" type="{http://rep.geointegrasjon.no/Arkiv/Felles/xml.schema/2012.01.31}Saksnummer" minOccurs="0"/&gt;
 *         &lt;element name="mappetype" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Mappetype" minOccurs="0"/&gt;
 *         &lt;element name="saksdato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="tittel" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="offentligTittel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="skjermetTittel" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="skjerming" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Skjerming" minOccurs="0"/&gt;
 *         &lt;element name="saksstatus" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Saksstatus" minOccurs="0"/&gt;
 *         &lt;element name="dokumentmedium" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Dokumentmedium" minOccurs="0"/&gt;
 *         &lt;element name="referanseArkivdel" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Arkivdel" minOccurs="0"/&gt;
 *         &lt;element name="journalenhet" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Journalenhet" minOccurs="0"/&gt;
 *         &lt;element name="bevaringstid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="kassasjonsvedtak" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Kassasjonsvedtak" minOccurs="0"/&gt;
 *         &lt;element name="kassasjonsdato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="prosjekt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="administrativEnhetInit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="administrativEnhet" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="saksansvarligInit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="saksansvarlig" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tilgangsgruppeNavn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Matrikkelnummer" type="{http://rep.geointegrasjon.no/Matrikkel/Felles/xml.schema/2012.01.31}MatrikkelnummerListe" minOccurs="0"/&gt;
 *         &lt;element name="klasse" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}KlasseListe" minOccurs="0"/&gt;
 *         &lt;element name="sakspart" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}SakspartListe" minOccurs="0"/&gt;
 *         &lt;element name="Punkt" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}PunktListe" minOccurs="0"/&gt;
 *         &lt;element name="tilleggsinformasjon" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}TilleggsinformasjonListe" minOccurs="0"/&gt;
 *         &lt;element name="ByggIdent" type="{http://rep.geointegrasjon.no/Matrikkel/Felles/xml.schema/2012.01.31}ByggIdentListe" minOccurs="0"/&gt;
 *         &lt;element name="referanseEksternNoekkel" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}EksternNoekkel" minOccurs="0"/&gt;
 *         &lt;element name="merknader" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}MerknadListe" minOccurs="0"/&gt;
 *         &lt;element name="planIdent" type="{http://rep.geointegrasjon.no/Plan/Felles/xml.schema/2012.01.31}NasjonalArealplanId" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Saksmappe", namespace = "http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31", propOrder = {
    "systemID",
    "saksnr",
    "mappetype",
    "saksdato",
    "tittel",
    "offentligTittel",
    "skjermetTittel",
    "skjerming",
    "saksstatus",
    "dokumentmedium",
    "referanseArkivdel",
    "journalenhet",
    "bevaringstid",
    "kassasjonsvedtak",
    "kassasjonsdato",
    "prosjekt",
    "administrativEnhetInit",
    "administrativEnhet",
    "saksansvarligInit",
    "saksansvarlig",
    "tilgangsgruppeNavn",
    "matrikkelnummer",
    "klasse",
    "sakspart",
    "punkt",
    "tilleggsinformasjon",
    "byggIdent",
    "referanseEksternNoekkel",
    "merknader",
    "planIdent"
})
public class Saksmappe implements ToString2
{

    protected String systemID;
    protected Saksnummer saksnr;
    protected Mappetype mappetype;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar saksdato;
    @XmlElement(required = true)
    protected String tittel;
    protected String offentligTittel;
    protected Boolean skjermetTittel;
    protected Skjerming skjerming;
    protected Saksstatus saksstatus;
    protected Dokumentmedium dokumentmedium;
    protected Arkivdel referanseArkivdel;
    protected Journalenhet journalenhet;
    protected String bevaringstid;
    protected Kassasjonsvedtak kassasjonsvedtak;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar kassasjonsdato;
    protected String prosjekt;
    protected String administrativEnhetInit;
    protected String administrativEnhet;
    protected String saksansvarligInit;
    protected String saksansvarlig;
    protected String tilgangsgruppeNavn;
    @XmlElement(name = "Matrikkelnummer")
    protected MatrikkelnummerListe matrikkelnummer;
    protected KlasseListe klasse;
    protected SakspartListe sakspart;
    @XmlElement(name = "Punkt")
    protected PunktListe punkt;
    protected TilleggsinformasjonListe tilleggsinformasjon;
    @XmlElement(name = "ByggIdent")
    protected ByggIdentListe byggIdent;
    protected EksternNoekkel referanseEksternNoekkel;
    protected MerknadListe merknader;
    protected NasjonalArealplanId planIdent;

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
     * Gets the value of the saksnr property.
     * 
     * @return
     *     possible object is
     *     {@link Saksnummer }
     *     
     */
    public Saksnummer getSaksnr() {
        return saksnr;
    }

    /**
     * Sets the value of the saksnr property.
     * 
     * @param value
     *     allowed object is
     *     {@link Saksnummer }
     *     
     */
    public void setSaksnr(Saksnummer value) {
        this.saksnr = value;
    }

    /**
     * Gets the value of the mappetype property.
     * 
     * @return
     *     possible object is
     *     {@link Mappetype }
     *     
     */
    public Mappetype getMappetype() {
        return mappetype;
    }

    /**
     * Sets the value of the mappetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Mappetype }
     *     
     */
    public void setMappetype(Mappetype value) {
        this.mappetype = value;
    }

    /**
     * Gets the value of the saksdato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSaksdato() {
        return saksdato;
    }

    /**
     * Sets the value of the saksdato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSaksdato(XMLGregorianCalendar value) {
        this.saksdato = value;
    }

    /**
     * Gets the value of the tittel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTittel() {
        return tittel;
    }

    /**
     * Sets the value of the tittel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTittel(String value) {
        this.tittel = value;
    }

    /**
     * Gets the value of the offentligTittel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOffentligTittel() {
        return offentligTittel;
    }

    /**
     * Sets the value of the offentligTittel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOffentligTittel(String value) {
        this.offentligTittel = value;
    }

    /**
     * Gets the value of the skjermetTittel property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkjermetTittel() {
        return skjermetTittel;
    }

    /**
     * Sets the value of the skjermetTittel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkjermetTittel(Boolean value) {
        this.skjermetTittel = value;
    }

    /**
     * Gets the value of the skjerming property.
     * 
     * @return
     *     possible object is
     *     {@link Skjerming }
     *     
     */
    public Skjerming getSkjerming() {
        return skjerming;
    }

    /**
     * Sets the value of the skjerming property.
     * 
     * @param value
     *     allowed object is
     *     {@link Skjerming }
     *     
     */
    public void setSkjerming(Skjerming value) {
        this.skjerming = value;
    }

    /**
     * Gets the value of the saksstatus property.
     * 
     * @return
     *     possible object is
     *     {@link Saksstatus }
     *     
     */
    public Saksstatus getSaksstatus() {
        return saksstatus;
    }

    /**
     * Sets the value of the saksstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Saksstatus }
     *     
     */
    public void setSaksstatus(Saksstatus value) {
        this.saksstatus = value;
    }

    /**
     * Gets the value of the dokumentmedium property.
     * 
     * @return
     *     possible object is
     *     {@link Dokumentmedium }
     *     
     */
    public Dokumentmedium getDokumentmedium() {
        return dokumentmedium;
    }

    /**
     * Sets the value of the dokumentmedium property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dokumentmedium }
     *     
     */
    public void setDokumentmedium(Dokumentmedium value) {
        this.dokumentmedium = value;
    }

    /**
     * Gets the value of the referanseArkivdel property.
     * 
     * @return
     *     possible object is
     *     {@link Arkivdel }
     *     
     */
    public Arkivdel getReferanseArkivdel() {
        return referanseArkivdel;
    }

    /**
     * Sets the value of the referanseArkivdel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Arkivdel }
     *     
     */
    public void setReferanseArkivdel(Arkivdel value) {
        this.referanseArkivdel = value;
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
     * Gets the value of the bevaringstid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBevaringstid() {
        return bevaringstid;
    }

    /**
     * Sets the value of the bevaringstid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBevaringstid(String value) {
        this.bevaringstid = value;
    }

    /**
     * Gets the value of the kassasjonsvedtak property.
     * 
     * @return
     *     possible object is
     *     {@link Kassasjonsvedtak }
     *     
     */
    public Kassasjonsvedtak getKassasjonsvedtak() {
        return kassasjonsvedtak;
    }

    /**
     * Sets the value of the kassasjonsvedtak property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kassasjonsvedtak }
     *     
     */
    public void setKassasjonsvedtak(Kassasjonsvedtak value) {
        this.kassasjonsvedtak = value;
    }

    /**
     * Gets the value of the kassasjonsdato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getKassasjonsdato() {
        return kassasjonsdato;
    }

    /**
     * Sets the value of the kassasjonsdato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setKassasjonsdato(XMLGregorianCalendar value) {
        this.kassasjonsdato = value;
    }

    /**
     * Gets the value of the prosjekt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProsjekt() {
        return prosjekt;
    }

    /**
     * Sets the value of the prosjekt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProsjekt(String value) {
        this.prosjekt = value;
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
     * Gets the value of the saksansvarligInit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaksansvarligInit() {
        return saksansvarligInit;
    }

    /**
     * Sets the value of the saksansvarligInit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaksansvarligInit(String value) {
        this.saksansvarligInit = value;
    }

    /**
     * Gets the value of the saksansvarlig property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSaksansvarlig() {
        return saksansvarlig;
    }

    /**
     * Sets the value of the saksansvarlig property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSaksansvarlig(String value) {
        this.saksansvarlig = value;
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
     * Gets the value of the matrikkelnummer property.
     * 
     * @return
     *     possible object is
     *     {@link MatrikkelnummerListe }
     *     
     */
    public MatrikkelnummerListe getMatrikkelnummer() {
        return matrikkelnummer;
    }

    /**
     * Sets the value of the matrikkelnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link MatrikkelnummerListe }
     *     
     */
    public void setMatrikkelnummer(MatrikkelnummerListe value) {
        this.matrikkelnummer = value;
    }

    /**
     * Gets the value of the klasse property.
     * 
     * @return
     *     possible object is
     *     {@link KlasseListe }
     *     
     */
    public KlasseListe getKlasse() {
        return klasse;
    }

    /**
     * Sets the value of the klasse property.
     * 
     * @param value
     *     allowed object is
     *     {@link KlasseListe }
     *     
     */
    public void setKlasse(KlasseListe value) {
        this.klasse = value;
    }

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
     * Gets the value of the punkt property.
     * 
     * @return
     *     possible object is
     *     {@link PunktListe }
     *     
     */
    public PunktListe getPunkt() {
        return punkt;
    }

    /**
     * Sets the value of the punkt property.
     * 
     * @param value
     *     allowed object is
     *     {@link PunktListe }
     *     
     */
    public void setPunkt(PunktListe value) {
        this.punkt = value;
    }

    /**
     * Gets the value of the tilleggsinformasjon property.
     * 
     * @return
     *     possible object is
     *     {@link TilleggsinformasjonListe }
     *     
     */
    public TilleggsinformasjonListe getTilleggsinformasjon() {
        return tilleggsinformasjon;
    }

    /**
     * Sets the value of the tilleggsinformasjon property.
     * 
     * @param value
     *     allowed object is
     *     {@link TilleggsinformasjonListe }
     *     
     */
    public void setTilleggsinformasjon(TilleggsinformasjonListe value) {
        this.tilleggsinformasjon = value;
    }

    /**
     * Gets the value of the byggIdent property.
     * 
     * @return
     *     possible object is
     *     {@link ByggIdentListe }
     *     
     */
    public ByggIdentListe getByggIdent() {
        return byggIdent;
    }

    /**
     * Sets the value of the byggIdent property.
     * 
     * @param value
     *     allowed object is
     *     {@link ByggIdentListe }
     *     
     */
    public void setByggIdent(ByggIdentListe value) {
        this.byggIdent = value;
    }

    /**
     * Gets the value of the referanseEksternNoekkel property.
     * 
     * @return
     *     possible object is
     *     {@link EksternNoekkel }
     *     
     */
    public EksternNoekkel getReferanseEksternNoekkel() {
        return referanseEksternNoekkel;
    }

    /**
     * Sets the value of the referanseEksternNoekkel property.
     * 
     * @param value
     *     allowed object is
     *     {@link EksternNoekkel }
     *     
     */
    public void setReferanseEksternNoekkel(EksternNoekkel value) {
        this.referanseEksternNoekkel = value;
    }

    /**
     * Gets the value of the merknader property.
     * 
     * @return
     *     possible object is
     *     {@link MerknadListe }
     *     
     */
    public MerknadListe getMerknader() {
        return merknader;
    }

    /**
     * Sets the value of the merknader property.
     * 
     * @param value
     *     allowed object is
     *     {@link MerknadListe }
     *     
     */
    public void setMerknader(MerknadListe value) {
        this.merknader = value;
    }

    /**
     * Gets the value of the planIdent property.
     * 
     * @return
     *     possible object is
     *     {@link NasjonalArealplanId }
     *     
     */
    public NasjonalArealplanId getPlanIdent() {
        return planIdent;
    }

    /**
     * Sets the value of the planIdent property.
     * 
     * @param value
     *     allowed object is
     *     {@link NasjonalArealplanId }
     *     
     */
    public void setPlanIdent(NasjonalArealplanId value) {
        this.planIdent = value;
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
            Saksnummer theSaksnr;
            theSaksnr = this.getSaksnr();
            strategy.appendField(locator, this, "saksnr", buffer, theSaksnr, (this.saksnr!= null));
        }
        {
            Mappetype theMappetype;
            theMappetype = this.getMappetype();
            strategy.appendField(locator, this, "mappetype", buffer, theMappetype, (this.mappetype!= null));
        }
        {
            XMLGregorianCalendar theSaksdato;
            theSaksdato = this.getSaksdato();
            strategy.appendField(locator, this, "saksdato", buffer, theSaksdato, (this.saksdato!= null));
        }
        {
            String theTittel;
            theTittel = this.getTittel();
            strategy.appendField(locator, this, "tittel", buffer, theTittel, (this.tittel!= null));
        }
        {
            String theOffentligTittel;
            theOffentligTittel = this.getOffentligTittel();
            strategy.appendField(locator, this, "offentligTittel", buffer, theOffentligTittel, (this.offentligTittel!= null));
        }
        {
            Boolean theSkjermetTittel;
            theSkjermetTittel = this.isSkjermetTittel();
            strategy.appendField(locator, this, "skjermetTittel", buffer, theSkjermetTittel, (this.skjermetTittel!= null));
        }
        {
            Skjerming theSkjerming;
            theSkjerming = this.getSkjerming();
            strategy.appendField(locator, this, "skjerming", buffer, theSkjerming, (this.skjerming!= null));
        }
        {
            Saksstatus theSaksstatus;
            theSaksstatus = this.getSaksstatus();
            strategy.appendField(locator, this, "saksstatus", buffer, theSaksstatus, (this.saksstatus!= null));
        }
        {
            Dokumentmedium theDokumentmedium;
            theDokumentmedium = this.getDokumentmedium();
            strategy.appendField(locator, this, "dokumentmedium", buffer, theDokumentmedium, (this.dokumentmedium!= null));
        }
        {
            Arkivdel theReferanseArkivdel;
            theReferanseArkivdel = this.getReferanseArkivdel();
            strategy.appendField(locator, this, "referanseArkivdel", buffer, theReferanseArkivdel, (this.referanseArkivdel!= null));
        }
        {
            Journalenhet theJournalenhet;
            theJournalenhet = this.getJournalenhet();
            strategy.appendField(locator, this, "journalenhet", buffer, theJournalenhet, (this.journalenhet!= null));
        }
        {
            String theBevaringstid;
            theBevaringstid = this.getBevaringstid();
            strategy.appendField(locator, this, "bevaringstid", buffer, theBevaringstid, (this.bevaringstid!= null));
        }
        {
            Kassasjonsvedtak theKassasjonsvedtak;
            theKassasjonsvedtak = this.getKassasjonsvedtak();
            strategy.appendField(locator, this, "kassasjonsvedtak", buffer, theKassasjonsvedtak, (this.kassasjonsvedtak!= null));
        }
        {
            XMLGregorianCalendar theKassasjonsdato;
            theKassasjonsdato = this.getKassasjonsdato();
            strategy.appendField(locator, this, "kassasjonsdato", buffer, theKassasjonsdato, (this.kassasjonsdato!= null));
        }
        {
            String theProsjekt;
            theProsjekt = this.getProsjekt();
            strategy.appendField(locator, this, "prosjekt", buffer, theProsjekt, (this.prosjekt!= null));
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
            String theSaksansvarligInit;
            theSaksansvarligInit = this.getSaksansvarligInit();
            strategy.appendField(locator, this, "saksansvarligInit", buffer, theSaksansvarligInit, (this.saksansvarligInit!= null));
        }
        {
            String theSaksansvarlig;
            theSaksansvarlig = this.getSaksansvarlig();
            strategy.appendField(locator, this, "saksansvarlig", buffer, theSaksansvarlig, (this.saksansvarlig!= null));
        }
        {
            String theTilgangsgruppeNavn;
            theTilgangsgruppeNavn = this.getTilgangsgruppeNavn();
            strategy.appendField(locator, this, "tilgangsgruppeNavn", buffer, theTilgangsgruppeNavn, (this.tilgangsgruppeNavn!= null));
        }
        {
            MatrikkelnummerListe theMatrikkelnummer;
            theMatrikkelnummer = this.getMatrikkelnummer();
            strategy.appendField(locator, this, "matrikkelnummer", buffer, theMatrikkelnummer, (this.matrikkelnummer!= null));
        }
        {
            KlasseListe theKlasse;
            theKlasse = this.getKlasse();
            strategy.appendField(locator, this, "klasse", buffer, theKlasse, (this.klasse!= null));
        }
        {
            SakspartListe theSakspart;
            theSakspart = this.getSakspart();
            strategy.appendField(locator, this, "sakspart", buffer, theSakspart, (this.sakspart!= null));
        }
        {
            PunktListe thePunkt;
            thePunkt = this.getPunkt();
            strategy.appendField(locator, this, "punkt", buffer, thePunkt, (this.punkt!= null));
        }
        {
            TilleggsinformasjonListe theTilleggsinformasjon;
            theTilleggsinformasjon = this.getTilleggsinformasjon();
            strategy.appendField(locator, this, "tilleggsinformasjon", buffer, theTilleggsinformasjon, (this.tilleggsinformasjon!= null));
        }
        {
            ByggIdentListe theByggIdent;
            theByggIdent = this.getByggIdent();
            strategy.appendField(locator, this, "byggIdent", buffer, theByggIdent, (this.byggIdent!= null));
        }
        {
            EksternNoekkel theReferanseEksternNoekkel;
            theReferanseEksternNoekkel = this.getReferanseEksternNoekkel();
            strategy.appendField(locator, this, "referanseEksternNoekkel", buffer, theReferanseEksternNoekkel, (this.referanseEksternNoekkel!= null));
        }
        {
            MerknadListe theMerknader;
            theMerknader = this.getMerknader();
            strategy.appendField(locator, this, "merknader", buffer, theMerknader, (this.merknader!= null));
        }
        {
            NasjonalArealplanId thePlanIdent;
            thePlanIdent = this.getPlanIdent();
            strategy.appendField(locator, this, "planIdent", buffer, thePlanIdent, (this.planIdent!= null));
        }
        return buffer;
    }

}
