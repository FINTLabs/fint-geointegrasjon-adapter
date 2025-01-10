
package no.geointegrasjon.arkiv.oppdatering;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Matrikkelnummer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Matrikkelnummer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="kommunenummer" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="gaardsnummer" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="bruksnummer" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="festenummer" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *         &lt;element name="seksjonsnummer" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Matrikkelnummer", namespace = "http://rep.geointegrasjon.no/Matrikkel/Felles/xml.schema/2012.01.31", propOrder = {
    "kommunenummer",
    "gaardsnummer",
    "bruksnummer",
    "festenummer",
    "seksjonsnummer"
})
public class Matrikkelnummer implements ToString2
{

    @XmlElement(required = true)
    protected String kommunenummer;
    @XmlElement(required = true)
    protected BigInteger gaardsnummer;
    @XmlElement(required = true)
    protected BigInteger bruksnummer;
    protected BigInteger festenummer;
    protected BigInteger seksjonsnummer;

    /**
     * Gets the value of the kommunenummer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKommunenummer() {
        return kommunenummer;
    }

    /**
     * Sets the value of the kommunenummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKommunenummer(String value) {
        this.kommunenummer = value;
    }

    /**
     * Gets the value of the gaardsnummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getGaardsnummer() {
        return gaardsnummer;
    }

    /**
     * Sets the value of the gaardsnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setGaardsnummer(BigInteger value) {
        this.gaardsnummer = value;
    }

    /**
     * Gets the value of the bruksnummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getBruksnummer() {
        return bruksnummer;
    }

    /**
     * Sets the value of the bruksnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setBruksnummer(BigInteger value) {
        this.bruksnummer = value;
    }

    /**
     * Gets the value of the festenummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getFestenummer() {
        return festenummer;
    }

    /**
     * Sets the value of the festenummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setFestenummer(BigInteger value) {
        this.festenummer = value;
    }

    /**
     * Gets the value of the seksjonsnummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSeksjonsnummer() {
        return seksjonsnummer;
    }

    /**
     * Sets the value of the seksjonsnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSeksjonsnummer(BigInteger value) {
        this.seksjonsnummer = value;
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
            String theKommunenummer;
            theKommunenummer = this.getKommunenummer();
            strategy.appendField(locator, this, "kommunenummer", buffer, theKommunenummer, (this.kommunenummer!= null));
        }
        {
            BigInteger theGaardsnummer;
            theGaardsnummer = this.getGaardsnummer();
            strategy.appendField(locator, this, "gaardsnummer", buffer, theGaardsnummer, (this.gaardsnummer!= null));
        }
        {
            BigInteger theBruksnummer;
            theBruksnummer = this.getBruksnummer();
            strategy.appendField(locator, this, "bruksnummer", buffer, theBruksnummer, (this.bruksnummer!= null));
        }
        {
            BigInteger theFestenummer;
            theFestenummer = this.getFestenummer();
            strategy.appendField(locator, this, "festenummer", buffer, theFestenummer, (this.festenummer!= null));
        }
        {
            BigInteger theSeksjonsnummer;
            theSeksjonsnummer = this.getSeksjonsnummer();
            strategy.appendField(locator, this, "seksjonsnummer", buffer, theSeksjonsnummer, (this.seksjonsnummer!= null));
        }
        return buffer;
    }

}
