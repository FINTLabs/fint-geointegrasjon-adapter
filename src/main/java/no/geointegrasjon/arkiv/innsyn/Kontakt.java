
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
 * <p>Java class for Kontakt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Kontakt"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="navn" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="adresser" type="{http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31}EnkelAdresseListe" minOccurs="0"/&gt;
 *         &lt;element name="elektroniskeAdresser" type="{http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31}ElektroniskAdresseListe" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Kontakt", namespace = "http://rep.geointegrasjon.no/Felles/Kontakt/xml.schema/2012.01.31", propOrder = {
    "navn",
    "adresser",
    "elektroniskeAdresser"
})
@XmlSeeAlso({
    Organisasjon.class,
    Person.class
})
public class Kontakt implements ToString2
{

    @XmlElement(required = true)
    protected String navn;
    protected EnkelAdresseListe adresser;
    protected ElektroniskAdresseListe elektroniskeAdresser;

    /**
     * Gets the value of the navn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNavn() {
        return navn;
    }

    /**
     * Sets the value of the navn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNavn(String value) {
        this.navn = value;
    }

    /**
     * Gets the value of the adresser property.
     * 
     * @return
     *     possible object is
     *     {@link EnkelAdresseListe }
     *     
     */
    public EnkelAdresseListe getAdresser() {
        return adresser;
    }

    /**
     * Sets the value of the adresser property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnkelAdresseListe }
     *     
     */
    public void setAdresser(EnkelAdresseListe value) {
        this.adresser = value;
    }

    /**
     * Gets the value of the elektroniskeAdresser property.
     * 
     * @return
     *     possible object is
     *     {@link ElektroniskAdresseListe }
     *     
     */
    public ElektroniskAdresseListe getElektroniskeAdresser() {
        return elektroniskeAdresser;
    }

    /**
     * Sets the value of the elektroniskeAdresser property.
     * 
     * @param value
     *     allowed object is
     *     {@link ElektroniskAdresseListe }
     *     
     */
    public void setElektroniskeAdresser(ElektroniskAdresseListe value) {
        this.elektroniskeAdresser = value;
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
            String theNavn;
            theNavn = this.getNavn();
            strategy.appendField(locator, this, "navn", buffer, theNavn, (this.navn!= null));
        }
        {
            EnkelAdresseListe theAdresser;
            theAdresser = this.getAdresser();
            strategy.appendField(locator, this, "adresser", buffer, theAdresser, (this.adresser!= null));
        }
        {
            ElektroniskAdresseListe theElektroniskeAdresser;
            theElektroniskeAdresser = this.getElektroniskeAdresser();
            strategy.appendField(locator, this, "elektroniskeAdresser", buffer, theElektroniskeAdresser, (this.elektroniskeAdresser!= null));
        }
        return buffer;
    }

}
