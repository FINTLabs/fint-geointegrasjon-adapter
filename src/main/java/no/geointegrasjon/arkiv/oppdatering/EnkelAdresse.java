
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
 * <p>Java class for EnkelAdresse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="EnkelAdresse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="adressetype" type="{http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31}EnkelAdressetype"/&gt;
 *         &lt;element name="adresselinje1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="adresselinje2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="postadresse" type="{http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31}PostadministrativeOmraader" minOccurs="0"/&gt;
 *         &lt;element name="landkode" type="{http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31}Landkode" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EnkelAdresse", namespace = "http://rep.geointegrasjon.no/Felles/Adresse/xml.schema/2012.01.31", propOrder = {
    "adressetype",
    "adresselinje1",
    "adresselinje2",
    "postadresse",
    "landkode"
})
public class EnkelAdresse implements ToString2
{

    @XmlElement(required = true)
    protected EnkelAdressetype adressetype;
    protected String adresselinje1;
    protected String adresselinje2;
    protected PostadministrativeOmraader postadresse;
    protected Landkode landkode;

    /**
     * Gets the value of the adressetype property.
     * 
     * @return
     *     possible object is
     *     {@link EnkelAdressetype }
     *     
     */
    public EnkelAdressetype getAdressetype() {
        return adressetype;
    }

    /**
     * Sets the value of the adressetype property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnkelAdressetype }
     *     
     */
    public void setAdressetype(EnkelAdressetype value) {
        this.adressetype = value;
    }

    /**
     * Gets the value of the adresselinje1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresselinje1() {
        return adresselinje1;
    }

    /**
     * Sets the value of the adresselinje1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresselinje1(String value) {
        this.adresselinje1 = value;
    }

    /**
     * Gets the value of the adresselinje2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdresselinje2() {
        return adresselinje2;
    }

    /**
     * Sets the value of the adresselinje2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdresselinje2(String value) {
        this.adresselinje2 = value;
    }

    /**
     * Gets the value of the postadresse property.
     * 
     * @return
     *     possible object is
     *     {@link PostadministrativeOmraader }
     *     
     */
    public PostadministrativeOmraader getPostadresse() {
        return postadresse;
    }

    /**
     * Sets the value of the postadresse property.
     * 
     * @param value
     *     allowed object is
     *     {@link PostadministrativeOmraader }
     *     
     */
    public void setPostadresse(PostadministrativeOmraader value) {
        this.postadresse = value;
    }

    /**
     * Gets the value of the landkode property.
     * 
     * @return
     *     possible object is
     *     {@link Landkode }
     *     
     */
    public Landkode getLandkode() {
        return landkode;
    }

    /**
     * Sets the value of the landkode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Landkode }
     *     
     */
    public void setLandkode(Landkode value) {
        this.landkode = value;
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
            EnkelAdressetype theAdressetype;
            theAdressetype = this.getAdressetype();
            strategy.appendField(locator, this, "adressetype", buffer, theAdressetype, (this.adressetype!= null));
        }
        {
            String theAdresselinje1;
            theAdresselinje1 = this.getAdresselinje1();
            strategy.appendField(locator, this, "adresselinje1", buffer, theAdresselinje1, (this.adresselinje1 != null));
        }
        {
            String theAdresselinje2;
            theAdresselinje2 = this.getAdresselinje2();
            strategy.appendField(locator, this, "adresselinje2", buffer, theAdresselinje2, (this.adresselinje2 != null));
        }
        {
            PostadministrativeOmraader thePostadresse;
            thePostadresse = this.getPostadresse();
            strategy.appendField(locator, this, "postadresse", buffer, thePostadresse, (this.postadresse!= null));
        }
        {
            Landkode theLandkode;
            theLandkode = this.getLandkode();
            strategy.appendField(locator, this, "landkode", buffer, theLandkode, (this.landkode!= null));
        }
        return buffer;
    }

}
