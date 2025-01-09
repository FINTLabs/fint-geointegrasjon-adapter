
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
 * <p>Java class for Journalpost complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Journalpost"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="systemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="journalnummer" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Journalnummer" minOccurs="0"/&gt;
 *         &lt;element name="journalpostnummer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="journaldato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="journalposttype" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Journalposttype" minOccurs="0"/&gt;
 *         &lt;element name="dokumentetsDato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="journalstatus" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Journalstatus" minOccurs="0"/&gt;
 *         &lt;element name="tittel" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="skjermetTittel" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="forfallsdato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="skjerming" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Skjerming" minOccurs="0"/&gt;
 *         &lt;element name="referanseArkivdel" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Arkivdel" minOccurs="0"/&gt;
 *         &lt;element name="tilleggskode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="antallVedlegg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="offentligTittel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="saksnr" type="{http://rep.geointegrasjon.no/Arkiv/Felles/xml.schema/2012.01.31}Saksnummer" minOccurs="0"/&gt;
 *         &lt;element name="tilgangsgruppeNavn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="referanseSakSystemID" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}SakSystemId" minOccurs="0"/&gt;
 *         &lt;element name="korrespondansepart" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}KorrespondansepartListe" minOccurs="0"/&gt;
 *         &lt;element name="referanseEksternNoekkel" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}EksternNoekkel" minOccurs="0"/&gt;
 *         &lt;element name="referanseMappeEksternNoekkel" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}EksternNoekkel" minOccurs="0"/&gt;
 *         &lt;element name="referanseAvskrivninger" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}AvskrivningListe" minOccurs="0"/&gt;
 *         &lt;element name="merknader" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}MerknadListe" minOccurs="0"/&gt;
 *         &lt;element name="tilleggsinformasjon" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}TilleggsinformasjonListe" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Journalpost", propOrder = {
    "systemID",
    "journalnummer",
    "journalpostnummer",
    "journaldato",
    "journalposttype",
    "dokumentetsDato",
    "journalstatus",
    "tittel",
    "skjermetTittel",
    "forfallsdato",
    "skjerming",
    "referanseArkivdel",
    "tilleggskode",
    "antallVedlegg",
    "offentligTittel",
    "saksnr",
    "tilgangsgruppeNavn",
    "referanseSakSystemID",
    "korrespondansepart",
    "referanseEksternNoekkel",
    "referanseMappeEksternNoekkel",
    "referanseAvskrivninger",
    "merknader",
    "tilleggsinformasjon"
})
public class Journalpost implements ToString2
{

    protected String systemID;
    protected Journalnummer journalnummer;
    protected String journalpostnummer;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar journaldato;
    protected Journalposttype journalposttype;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dokumentetsDato;
    protected Journalstatus journalstatus;
    @XmlElement(required = true)
    protected String tittel;
    protected Boolean skjermetTittel;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar forfallsdato;
    protected Skjerming skjerming;
    protected Arkivdel referanseArkivdel;
    protected String tilleggskode;
    protected String antallVedlegg;
    protected String offentligTittel;
    protected Saksnummer saksnr;
    protected String tilgangsgruppeNavn;
    protected SakSystemId referanseSakSystemID;
    protected KorrespondansepartListe korrespondansepart;
    protected EksternNoekkel referanseEksternNoekkel;
    protected EksternNoekkel referanseMappeEksternNoekkel;
    protected AvskrivningListe referanseAvskrivninger;
    protected MerknadListe merknader;
    protected TilleggsinformasjonListe tilleggsinformasjon;

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
     * Gets the value of the journalnummer property.
     * 
     * @return
     *     possible object is
     *     {@link Journalnummer }
     *     
     */
    public Journalnummer getJournalnummer() {
        return journalnummer;
    }

    /**
     * Sets the value of the journalnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Journalnummer }
     *     
     */
    public void setJournalnummer(Journalnummer value) {
        this.journalnummer = value;
    }

    /**
     * Gets the value of the journalpostnummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJournalpostnummer() {
        return journalpostnummer;
    }

    /**
     * Sets the value of the journalpostnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJournalpostnummer(String value) {
        this.journalpostnummer = value;
    }

    /**
     * Gets the value of the journaldato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getJournaldato() {
        return journaldato;
    }

    /**
     * Sets the value of the journaldato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setJournaldato(XMLGregorianCalendar value) {
        this.journaldato = value;
    }

    /**
     * Gets the value of the journalposttype property.
     * 
     * @return
     *     possible object is
     *     {@link Journalposttype }
     *     
     */
    public Journalposttype getJournalposttype() {
        return journalposttype;
    }

    /**
     * Sets the value of the journalposttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Journalposttype }
     *     
     */
    public void setJournalposttype(Journalposttype value) {
        this.journalposttype = value;
    }

    /**
     * Gets the value of the dokumentetsDato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDokumentetsDato() {
        return dokumentetsDato;
    }

    /**
     * Sets the value of the dokumentetsDato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDokumentetsDato(XMLGregorianCalendar value) {
        this.dokumentetsDato = value;
    }

    /**
     * Gets the value of the journalstatus property.
     * 
     * @return
     *     possible object is
     *     {@link Journalstatus }
     *     
     */
    public Journalstatus getJournalstatus() {
        return journalstatus;
    }

    /**
     * Sets the value of the journalstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Journalstatus }
     *     
     */
    public void setJournalstatus(Journalstatus value) {
        this.journalstatus = value;
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
     * Gets the value of the forfallsdato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getForfallsdato() {
        return forfallsdato;
    }

    /**
     * Sets the value of the forfallsdato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setForfallsdato(XMLGregorianCalendar value) {
        this.forfallsdato = value;
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
     * Gets the value of the tilleggskode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTilleggskode() {
        return tilleggskode;
    }

    /**
     * Sets the value of the tilleggskode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTilleggskode(String value) {
        this.tilleggskode = value;
    }

    /**
     * Gets the value of the antallVedlegg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAntallVedlegg() {
        return antallVedlegg;
    }

    /**
     * Sets the value of the antallVedlegg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAntallVedlegg(String value) {
        this.antallVedlegg = value;
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
     * Gets the value of the referanseSakSystemID property.
     * 
     * @return
     *     possible object is
     *     {@link SakSystemId }
     *     
     */
    public SakSystemId getReferanseSakSystemID() {
        return referanseSakSystemID;
    }

    /**
     * Sets the value of the referanseSakSystemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link SakSystemId }
     *     
     */
    public void setReferanseSakSystemID(SakSystemId value) {
        this.referanseSakSystemID = value;
    }

    /**
     * Gets the value of the korrespondansepart property.
     * 
     * @return
     *     possible object is
     *     {@link KorrespondansepartListe }
     *     
     */
    public KorrespondansepartListe getKorrespondansepart() {
        return korrespondansepart;
    }

    /**
     * Sets the value of the korrespondansepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link KorrespondansepartListe }
     *     
     */
    public void setKorrespondansepart(KorrespondansepartListe value) {
        this.korrespondansepart = value;
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
     * Gets the value of the referanseMappeEksternNoekkel property.
     * 
     * @return
     *     possible object is
     *     {@link EksternNoekkel }
     *     
     */
    public EksternNoekkel getReferanseMappeEksternNoekkel() {
        return referanseMappeEksternNoekkel;
    }

    /**
     * Sets the value of the referanseMappeEksternNoekkel property.
     * 
     * @param value
     *     allowed object is
     *     {@link EksternNoekkel }
     *     
     */
    public void setReferanseMappeEksternNoekkel(EksternNoekkel value) {
        this.referanseMappeEksternNoekkel = value;
    }

    /**
     * Gets the value of the referanseAvskrivninger property.
     * 
     * @return
     *     possible object is
     *     {@link AvskrivningListe }
     *     
     */
    public AvskrivningListe getReferanseAvskrivninger() {
        return referanseAvskrivninger;
    }

    /**
     * Sets the value of the referanseAvskrivninger property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvskrivningListe }
     *     
     */
    public void setReferanseAvskrivninger(AvskrivningListe value) {
        this.referanseAvskrivninger = value;
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
            Journalnummer theJournalnummer;
            theJournalnummer = this.getJournalnummer();
            strategy.appendField(locator, this, "journalnummer", buffer, theJournalnummer, (this.journalnummer!= null));
        }
        {
            String theJournalpostnummer;
            theJournalpostnummer = this.getJournalpostnummer();
            strategy.appendField(locator, this, "journalpostnummer", buffer, theJournalpostnummer, (this.journalpostnummer!= null));
        }
        {
            XMLGregorianCalendar theJournaldato;
            theJournaldato = this.getJournaldato();
            strategy.appendField(locator, this, "journaldato", buffer, theJournaldato, (this.journaldato!= null));
        }
        {
            Journalposttype theJournalposttype;
            theJournalposttype = this.getJournalposttype();
            strategy.appendField(locator, this, "journalposttype", buffer, theJournalposttype, (this.journalposttype!= null));
        }
        {
            XMLGregorianCalendar theDokumentetsDato;
            theDokumentetsDato = this.getDokumentetsDato();
            strategy.appendField(locator, this, "dokumentetsDato", buffer, theDokumentetsDato, (this.dokumentetsDato!= null));
        }
        {
            Journalstatus theJournalstatus;
            theJournalstatus = this.getJournalstatus();
            strategy.appendField(locator, this, "journalstatus", buffer, theJournalstatus, (this.journalstatus!= null));
        }
        {
            String theTittel;
            theTittel = this.getTittel();
            strategy.appendField(locator, this, "tittel", buffer, theTittel, (this.tittel!= null));
        }
        {
            Boolean theSkjermetTittel;
            theSkjermetTittel = this.isSkjermetTittel();
            strategy.appendField(locator, this, "skjermetTittel", buffer, theSkjermetTittel, (this.skjermetTittel!= null));
        }
        {
            XMLGregorianCalendar theForfallsdato;
            theForfallsdato = this.getForfallsdato();
            strategy.appendField(locator, this, "forfallsdato", buffer, theForfallsdato, (this.forfallsdato!= null));
        }
        {
            Skjerming theSkjerming;
            theSkjerming = this.getSkjerming();
            strategy.appendField(locator, this, "skjerming", buffer, theSkjerming, (this.skjerming!= null));
        }
        {
            Arkivdel theReferanseArkivdel;
            theReferanseArkivdel = this.getReferanseArkivdel();
            strategy.appendField(locator, this, "referanseArkivdel", buffer, theReferanseArkivdel, (this.referanseArkivdel!= null));
        }
        {
            String theTilleggskode;
            theTilleggskode = this.getTilleggskode();
            strategy.appendField(locator, this, "tilleggskode", buffer, theTilleggskode, (this.tilleggskode!= null));
        }
        {
            String theAntallVedlegg;
            theAntallVedlegg = this.getAntallVedlegg();
            strategy.appendField(locator, this, "antallVedlegg", buffer, theAntallVedlegg, (this.antallVedlegg!= null));
        }
        {
            String theOffentligTittel;
            theOffentligTittel = this.getOffentligTittel();
            strategy.appendField(locator, this, "offentligTittel", buffer, theOffentligTittel, (this.offentligTittel!= null));
        }
        {
            Saksnummer theSaksnr;
            theSaksnr = this.getSaksnr();
            strategy.appendField(locator, this, "saksnr", buffer, theSaksnr, (this.saksnr!= null));
        }
        {
            String theTilgangsgruppeNavn;
            theTilgangsgruppeNavn = this.getTilgangsgruppeNavn();
            strategy.appendField(locator, this, "tilgangsgruppeNavn", buffer, theTilgangsgruppeNavn, (this.tilgangsgruppeNavn!= null));
        }
        {
            SakSystemId theReferanseSakSystemID;
            theReferanseSakSystemID = this.getReferanseSakSystemID();
            strategy.appendField(locator, this, "referanseSakSystemID", buffer, theReferanseSakSystemID, (this.referanseSakSystemID!= null));
        }
        {
            KorrespondansepartListe theKorrespondansepart;
            theKorrespondansepart = this.getKorrespondansepart();
            strategy.appendField(locator, this, "korrespondansepart", buffer, theKorrespondansepart, (this.korrespondansepart!= null));
        }
        {
            EksternNoekkel theReferanseEksternNoekkel;
            theReferanseEksternNoekkel = this.getReferanseEksternNoekkel();
            strategy.appendField(locator, this, "referanseEksternNoekkel", buffer, theReferanseEksternNoekkel, (this.referanseEksternNoekkel!= null));
        }
        {
            EksternNoekkel theReferanseMappeEksternNoekkel;
            theReferanseMappeEksternNoekkel = this.getReferanseMappeEksternNoekkel();
            strategy.appendField(locator, this, "referanseMappeEksternNoekkel", buffer, theReferanseMappeEksternNoekkel, (this.referanseMappeEksternNoekkel!= null));
        }
        {
            AvskrivningListe theReferanseAvskrivninger;
            theReferanseAvskrivninger = this.getReferanseAvskrivninger();
            strategy.appendField(locator, this, "referanseAvskrivninger", buffer, theReferanseAvskrivninger, (this.referanseAvskrivninger!= null));
        }
        {
            MerknadListe theMerknader;
            theMerknader = this.getMerknader();
            strategy.appendField(locator, this, "merknader", buffer, theMerknader, (this.merknader!= null));
        }
        {
            TilleggsinformasjonListe theTilleggsinformasjon;
            theTilleggsinformasjon = this.getTilleggsinformasjon();
            strategy.appendField(locator, this, "tilleggsinformasjon", buffer, theTilleggsinformasjon, (this.tilleggsinformasjon!= null));
        }
        return buffer;
    }

}
