
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
 * <p>Java class for Dokument complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Dokument"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="systemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dokumentnummer" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tilknyttetRegistreringSom" type="{http://rep.geointegrasjon.no/Arkiv/Dokument/xml.schema/2012.01.31}TilknyttetRegistreringSom" minOccurs="0"/&gt;
 *         &lt;element name="dokumenttype" type="{http://rep.geointegrasjon.no/Arkiv/Dokument/xml.schema/2012.01.31}Dokumenttype" minOccurs="0"/&gt;
 *         &lt;element name="tittel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dokumentstatus" type="{http://rep.geointegrasjon.no/Arkiv/Dokument/xml.schema/2012.01.31}Dokumentstatus" minOccurs="0"/&gt;
 *         &lt;element name="variantformat" type="{http://rep.geointegrasjon.no/Arkiv/Dokument/xml.schema/2012.01.31}Variantformat" minOccurs="0"/&gt;
 *         &lt;element name="format" type="{http://rep.geointegrasjon.no/Arkiv/Dokument/xml.schema/2012.01.31}Format" minOccurs="0"/&gt;
 *         &lt;element name="referanseJournalpostSystemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Fil" type="{http://rep.geointegrasjon.no/Arkiv/Dokument/xml.schema/2012.01.31}Fil" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dokument", namespace = "http://rep.geointegrasjon.no/Arkiv/Dokument/xml.schema/2012.01.31", propOrder = {
    "systemID",
    "dokumentnummer",
    "tilknyttetRegistreringSom",
    "dokumenttype",
    "tittel",
    "dokumentstatus",
    "variantformat",
    "format",
    "referanseJournalpostSystemID",
    "fil"
})
public class Dokument implements ToString2
{

    protected String systemID;
    protected String dokumentnummer;
    protected TilknyttetRegistreringSom tilknyttetRegistreringSom;
    protected Dokumenttype dokumenttype;
    protected String tittel;
    protected Dokumentstatus dokumentstatus;
    protected Variantformat variantformat;
    protected Format format;
    protected String referanseJournalpostSystemID;
    @XmlElement(name = "Fil")
    protected Fil fil;

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
     * Gets the value of the dokumentnummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDokumentnummer() {
        return dokumentnummer;
    }

    /**
     * Sets the value of the dokumentnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDokumentnummer(String value) {
        this.dokumentnummer = value;
    }

    /**
     * Gets the value of the tilknyttetRegistreringSom property.
     * 
     * @return
     *     possible object is
     *     {@link TilknyttetRegistreringSom }
     *     
     */
    public TilknyttetRegistreringSom getTilknyttetRegistreringSom() {
        return tilknyttetRegistreringSom;
    }

    /**
     * Sets the value of the tilknyttetRegistreringSom property.
     * 
     * @param value
     *     allowed object is
     *     {@link TilknyttetRegistreringSom }
     *     
     */
    public void setTilknyttetRegistreringSom(TilknyttetRegistreringSom value) {
        this.tilknyttetRegistreringSom = value;
    }

    /**
     * Gets the value of the dokumenttype property.
     * 
     * @return
     *     possible object is
     *     {@link Dokumenttype }
     *     
     */
    public Dokumenttype getDokumenttype() {
        return dokumenttype;
    }

    /**
     * Sets the value of the dokumenttype property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dokumenttype }
     *     
     */
    public void setDokumenttype(Dokumenttype value) {
        this.dokumenttype = value;
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
     * Gets the value of the dokumentstatus property.
     * 
     * @return
     *     possible object is
     *     {@link Dokumentstatus }
     *     
     */
    public Dokumentstatus getDokumentstatus() {
        return dokumentstatus;
    }

    /**
     * Sets the value of the dokumentstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dokumentstatus }
     *     
     */
    public void setDokumentstatus(Dokumentstatus value) {
        this.dokumentstatus = value;
    }

    /**
     * Gets the value of the variantformat property.
     * 
     * @return
     *     possible object is
     *     {@link Variantformat }
     *     
     */
    public Variantformat getVariantformat() {
        return variantformat;
    }

    /**
     * Sets the value of the variantformat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Variantformat }
     *     
     */
    public void setVariantformat(Variantformat value) {
        this.variantformat = value;
    }

    /**
     * Gets the value of the format property.
     * 
     * @return
     *     possible object is
     *     {@link Format }
     *     
     */
    public Format getFormat() {
        return format;
    }

    /**
     * Sets the value of the format property.
     * 
     * @param value
     *     allowed object is
     *     {@link Format }
     *     
     */
    public void setFormat(Format value) {
        this.format = value;
    }

    /**
     * Gets the value of the referanseJournalpostSystemID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReferanseJournalpostSystemID() {
        return referanseJournalpostSystemID;
    }

    /**
     * Sets the value of the referanseJournalpostSystemID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReferanseJournalpostSystemID(String value) {
        this.referanseJournalpostSystemID = value;
    }

    /**
     * Gets the value of the fil property.
     * 
     * @return
     *     possible object is
     *     {@link Fil }
     *     
     */
    public Fil getFil() {
        return fil;
    }

    /**
     * Sets the value of the fil property.
     * 
     * @param value
     *     allowed object is
     *     {@link Fil }
     *     
     */
    public void setFil(Fil value) {
        this.fil = value;
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
            String theDokumentnummer;
            theDokumentnummer = this.getDokumentnummer();
            strategy.appendField(locator, this, "dokumentnummer", buffer, theDokumentnummer, (this.dokumentnummer!= null));
        }
        {
            TilknyttetRegistreringSom theTilknyttetRegistreringSom;
            theTilknyttetRegistreringSom = this.getTilknyttetRegistreringSom();
            strategy.appendField(locator, this, "tilknyttetRegistreringSom", buffer, theTilknyttetRegistreringSom, (this.tilknyttetRegistreringSom!= null));
        }
        {
            Dokumenttype theDokumenttype;
            theDokumenttype = this.getDokumenttype();
            strategy.appendField(locator, this, "dokumenttype", buffer, theDokumenttype, (this.dokumenttype!= null));
        }
        {
            String theTittel;
            theTittel = this.getTittel();
            strategy.appendField(locator, this, "tittel", buffer, theTittel, (this.tittel!= null));
        }
        {
            Dokumentstatus theDokumentstatus;
            theDokumentstatus = this.getDokumentstatus();
            strategy.appendField(locator, this, "dokumentstatus", buffer, theDokumentstatus, (this.dokumentstatus!= null));
        }
        {
            Variantformat theVariantformat;
            theVariantformat = this.getVariantformat();
            strategy.appendField(locator, this, "variantformat", buffer, theVariantformat, (this.variantformat!= null));
        }
        {
            Format theFormat;
            theFormat = this.getFormat();
            strategy.appendField(locator, this, "format", buffer, theFormat, (this.format!= null));
        }
        {
            String theReferanseJournalpostSystemID;
            theReferanseJournalpostSystemID = this.getReferanseJournalpostSystemID();
            strategy.appendField(locator, this, "referanseJournalpostSystemID", buffer, theReferanseJournalpostSystemID, (this.referanseJournalpostSystemID!= null));
        }
        {
            Fil theFil;
            theFil = this.getFil();
            strategy.appendField(locator, this, "fil", buffer, theFil, (this.fil!= null));
        }
        return buffer;
    }

}
