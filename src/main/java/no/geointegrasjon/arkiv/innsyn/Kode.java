
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Kode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Kode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="kodeverdi" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="kodebeskrivelse" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="erGyldig" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Kode", namespace = "http://rep.geointegrasjon.no/Felles/Kodeliste/xml.schema/2012.01.31", propOrder = {
    "kodeverdi",
    "kodebeskrivelse",
    "erGyldig"
})
@XmlSeeAlso({
    EnkelAdressetype.class,
    Landkode.class,
    Dokumenttype.class,
    Dokumentstatus.class,
    Format.class,
    TilknyttetRegistreringSom.class,
    Variantformat.class,
    SakspartRolle.class,
    Arkivdel.class,
    Avskrivningsmaate.class,
    Dokumentmedium.class,
    Forsendelsesmaate.class,
    Informasjonstype.class,
    Journalenhet.class,
    Journalposttype.class,
    Journalstatus.class,
    Kassasjonsvedtak.class,
    Klassifikasjonssystem.class,
    Korrespondanseparttype.class,
    Mappetype.class,
    Saksstatus.class,
    SkjermingOpphorerAksjon.class,
    SkjermingsHjemmel.class,
    Tilgangsrestriksjon.class,
    PersonidentifikatorType.class,
    KoordinatsystemKode.class
})
public class Kode implements ToString2
{

    @XmlElement(required = true)
    protected String kodeverdi;
    protected String kodebeskrivelse;
    protected Boolean erGyldig;

    /**
     * Gets the value of the kodeverdi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKodeverdi() {
        return kodeverdi;
    }

    /**
     * Sets the value of the kodeverdi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKodeverdi(String value) {
        this.kodeverdi = value;
    }

    /**
     * Gets the value of the kodebeskrivelse property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKodebeskrivelse() {
        return kodebeskrivelse;
    }

    /**
     * Sets the value of the kodebeskrivelse property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKodebeskrivelse(String value) {
        this.kodebeskrivelse = value;
    }

    /**
     * Gets the value of the erGyldig property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isErGyldig() {
        return erGyldig;
    }

    /**
     * Sets the value of the erGyldig property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setErGyldig(Boolean value) {
        this.erGyldig = value;
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
            String theKodeverdi;
            theKodeverdi = this.getKodeverdi();
            strategy.appendField(locator, this, "kodeverdi", buffer, theKodeverdi, (this.kodeverdi!= null));
        }
        {
            String theKodebeskrivelse;
            theKodebeskrivelse = this.getKodebeskrivelse();
            strategy.appendField(locator, this, "kodebeskrivelse", buffer, theKodebeskrivelse, (this.kodebeskrivelse!= null));
        }
        {
            Boolean theErGyldig;
            theErGyldig = this.isErGyldig();
            strategy.appendField(locator, this, "erGyldig", buffer, theErGyldig, (this.erGyldig!= null));
        }
        return buffer;
    }

}
