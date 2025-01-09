
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Person complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Person"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Felles/Kontakt/xml.schema/2012.01.31}Kontakt"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="personid" type="{http://rep.geointegrasjon.no/Felles/Kontakt/xml.schema/2012.01.31}Personidentifikator" minOccurs="0"/&gt;
 *         &lt;element name="etternavn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fornavn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Person", namespace = "http://rep.geointegrasjon.no/Felles/Kontakt/xml.schema/2012.01.31", propOrder = {
    "personid",
    "etternavn",
    "fornavn"
})
public class Person
    extends Kontakt
    implements ToString2
{

    protected Personidentifikator personid;
    protected String etternavn;
    protected String fornavn;

    /**
     * Gets the value of the personid property.
     * 
     * @return
     *     possible object is
     *     {@link Personidentifikator }
     *     
     */
    public Personidentifikator getPersonid() {
        return personid;
    }

    /**
     * Sets the value of the personid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Personidentifikator }
     *     
     */
    public void setPersonid(Personidentifikator value) {
        this.personid = value;
    }

    /**
     * Gets the value of the etternavn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEtternavn() {
        return etternavn;
    }

    /**
     * Sets the value of the etternavn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEtternavn(String value) {
        this.etternavn = value;
    }

    /**
     * Gets the value of the fornavn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFornavn() {
        return fornavn;
    }

    /**
     * Sets the value of the fornavn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFornavn(String value) {
        this.fornavn = value;
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
        super.appendFields(locator, buffer, strategy);
        {
            Personidentifikator thePersonid;
            thePersonid = this.getPersonid();
            strategy.appendField(locator, this, "personid", buffer, thePersonid, (this.personid!= null));
        }
        {
            String theEtternavn;
            theEtternavn = this.getEtternavn();
            strategy.appendField(locator, this, "etternavn", buffer, theEtternavn, (this.etternavn!= null));
        }
        {
            String theFornavn;
            theFornavn = this.getFornavn();
            strategy.appendField(locator, this, "fornavn", buffer, theFornavn, (this.fornavn!= null));
        }
        return buffer;
    }

}
