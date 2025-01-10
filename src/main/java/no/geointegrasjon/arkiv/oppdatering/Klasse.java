
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
 * <p>Java class for Klasse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Klasse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rekkefoelge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="klassifikasjonssystem" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Klassifikasjonssystem"/&gt;
 *         &lt;element name="klasseID" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="skjermetKlasse" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="ledetekst" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tittel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Klasse", namespace = "http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31", propOrder = {
    "rekkefoelge",
    "klassifikasjonssystem",
    "klasseID",
    "skjermetKlasse",
    "ledetekst",
    "tittel"
})
public class Klasse implements ToString2
{

    protected String rekkefoelge;
    @XmlElement(required = true)
    protected Klassifikasjonssystem klassifikasjonssystem;
    @XmlElement(required = true)
    protected String klasseID;
    protected Boolean skjermetKlasse;
    protected String ledetekst;
    protected String tittel;

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
     * Gets the value of the klassifikasjonssystem property.
     * 
     * @return
     *     possible object is
     *     {@link Klassifikasjonssystem }
     *     
     */
    public Klassifikasjonssystem getKlassifikasjonssystem() {
        return klassifikasjonssystem;
    }

    /**
     * Sets the value of the klassifikasjonssystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link Klassifikasjonssystem }
     *     
     */
    public void setKlassifikasjonssystem(Klassifikasjonssystem value) {
        this.klassifikasjonssystem = value;
    }

    /**
     * Gets the value of the klasseID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKlasseID() {
        return klasseID;
    }

    /**
     * Sets the value of the klasseID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKlasseID(String value) {
        this.klasseID = value;
    }

    /**
     * Gets the value of the skjermetKlasse property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSkjermetKlasse() {
        return skjermetKlasse;
    }

    /**
     * Sets the value of the skjermetKlasse property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSkjermetKlasse(Boolean value) {
        this.skjermetKlasse = value;
    }

    /**
     * Gets the value of the ledetekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLedetekst() {
        return ledetekst;
    }

    /**
     * Sets the value of the ledetekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLedetekst(String value) {
        this.ledetekst = value;
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
            String theRekkefoelge;
            theRekkefoelge = this.getRekkefoelge();
            strategy.appendField(locator, this, "rekkefoelge", buffer, theRekkefoelge, (this.rekkefoelge!= null));
        }
        {
            Klassifikasjonssystem theKlassifikasjonssystem;
            theKlassifikasjonssystem = this.getKlassifikasjonssystem();
            strategy.appendField(locator, this, "klassifikasjonssystem", buffer, theKlassifikasjonssystem, (this.klassifikasjonssystem!= null));
        }
        {
            String theKlasseID;
            theKlasseID = this.getKlasseID();
            strategy.appendField(locator, this, "klasseID", buffer, theKlasseID, (this.klasseID!= null));
        }
        {
            Boolean theSkjermetKlasse;
            theSkjermetKlasse = this.isSkjermetKlasse();
            strategy.appendField(locator, this, "skjermetKlasse", buffer, theSkjermetKlasse, (this.skjermetKlasse!= null));
        }
        {
            String theLedetekst;
            theLedetekst = this.getLedetekst();
            strategy.appendField(locator, this, "ledetekst", buffer, theLedetekst, (this.ledetekst!= null));
        }
        {
            String theTittel;
            theTittel = this.getTittel();
            strategy.appendField(locator, this, "tittel", buffer, theTittel, (this.tittel!= null));
        }
        return buffer;
    }

}
