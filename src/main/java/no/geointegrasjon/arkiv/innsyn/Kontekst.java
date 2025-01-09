
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Kontekst complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Kontekst"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="spraak" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="klientnavn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="klientversjon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="systemversjon" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Kontekst", namespace = "http://rep.geointegrasjon.no/Felles/Teknisk/xml.schema/2012.01.31", propOrder = {
    "spraak",
    "klientnavn",
    "klientversjon",
    "systemversjon"
})
@XmlSeeAlso({
    ArkivKontekst.class,
    MatrikkelKontekst.class,
    PlanKontekst.class
})
public class Kontekst implements ToString2
{

    protected String spraak;
    protected String klientnavn;
    protected String klientversjon;
    protected String systemversjon;

    /**
     * Gets the value of the spraak property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSpraak() {
        return spraak;
    }

    /**
     * Sets the value of the spraak property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSpraak(String value) {
        this.spraak = value;
    }

    /**
     * Gets the value of the klientnavn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKlientnavn() {
        return klientnavn;
    }

    /**
     * Sets the value of the klientnavn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKlientnavn(String value) {
        this.klientnavn = value;
    }

    /**
     * Gets the value of the klientversjon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKlientversjon() {
        return klientversjon;
    }

    /**
     * Sets the value of the klientversjon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKlientversjon(String value) {
        this.klientversjon = value;
    }

    /**
     * Gets the value of the systemversjon property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSystemversjon() {
        return systemversjon;
    }

    /**
     * Sets the value of the systemversjon property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSystemversjon(String value) {
        this.systemversjon = value;
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
            String theSpraak;
            theSpraak = this.getSpraak();
            strategy.appendField(locator, this, "spraak", buffer, theSpraak, (this.spraak!= null));
        }
        {
            String theKlientnavn;
            theKlientnavn = this.getKlientnavn();
            strategy.appendField(locator, this, "klientnavn", buffer, theKlientnavn, (this.klientnavn!= null));
        }
        {
            String theKlientversjon;
            theKlientversjon = this.getKlientversjon();
            strategy.appendField(locator, this, "klientversjon", buffer, theKlientversjon, (this.klientversjon!= null));
        }
        {
            String theSystemversjon;
            theSystemversjon = this.getSystemversjon();
            strategy.appendField(locator, this, "systemversjon", buffer, theSystemversjon, (this.systemversjon!= null));
        }
        return buffer;
    }

}
