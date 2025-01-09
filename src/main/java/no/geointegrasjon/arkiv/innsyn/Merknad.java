
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
 * <p>Java class for Merknad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Merknad"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="systemID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="merknadstekst" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="merknadstype" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="merknadsdato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="merknadRegistrertAv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="merknadRegistrertAvInit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Merknad", propOrder = {
    "systemID",
    "merknadstekst",
    "merknadstype",
    "merknadsdato",
    "merknadRegistrertAv",
    "merknadRegistrertAvInit"
})
public class Merknad implements ToString2
{

    protected String systemID;
    @XmlElement(required = true)
    protected String merknadstekst;
    protected String merknadstype;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar merknadsdato;
    protected String merknadRegistrertAv;
    protected String merknadRegistrertAvInit;

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
     * Gets the value of the merknadstekst property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerknadstekst() {
        return merknadstekst;
    }

    /**
     * Sets the value of the merknadstekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerknadstekst(String value) {
        this.merknadstekst = value;
    }

    /**
     * Gets the value of the merknadstype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerknadstype() {
        return merknadstype;
    }

    /**
     * Sets the value of the merknadstype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerknadstype(String value) {
        this.merknadstype = value;
    }

    /**
     * Gets the value of the merknadsdato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getMerknadsdato() {
        return merknadsdato;
    }

    /**
     * Sets the value of the merknadsdato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setMerknadsdato(XMLGregorianCalendar value) {
        this.merknadsdato = value;
    }

    /**
     * Gets the value of the merknadRegistrertAv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerknadRegistrertAv() {
        return merknadRegistrertAv;
    }

    /**
     * Sets the value of the merknadRegistrertAv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerknadRegistrertAv(String value) {
        this.merknadRegistrertAv = value;
    }

    /**
     * Gets the value of the merknadRegistrertAvInit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerknadRegistrertAvInit() {
        return merknadRegistrertAvInit;
    }

    /**
     * Sets the value of the merknadRegistrertAvInit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerknadRegistrertAvInit(String value) {
        this.merknadRegistrertAvInit = value;
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
            String theMerknadstekst;
            theMerknadstekst = this.getMerknadstekst();
            strategy.appendField(locator, this, "merknadstekst", buffer, theMerknadstekst, (this.merknadstekst!= null));
        }
        {
            String theMerknadstype;
            theMerknadstype = this.getMerknadstype();
            strategy.appendField(locator, this, "merknadstype", buffer, theMerknadstype, (this.merknadstype!= null));
        }
        {
            XMLGregorianCalendar theMerknadsdato;
            theMerknadsdato = this.getMerknadsdato();
            strategy.appendField(locator, this, "merknadsdato", buffer, theMerknadsdato, (this.merknadsdato!= null));
        }
        {
            String theMerknadRegistrertAv;
            theMerknadRegistrertAv = this.getMerknadRegistrertAv();
            strategy.appendField(locator, this, "merknadRegistrertAv", buffer, theMerknadRegistrertAv, (this.merknadRegistrertAv!= null));
        }
        {
            String theMerknadRegistrertAvInit;
            theMerknadRegistrertAvInit = this.getMerknadRegistrertAvInit();
            strategy.appendField(locator, this, "merknadRegistrertAvInit", buffer, theMerknadRegistrertAvInit, (this.merknadRegistrertAvInit!= null));
        }
        return buffer;
    }

}
