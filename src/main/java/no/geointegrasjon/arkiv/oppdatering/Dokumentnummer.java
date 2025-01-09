
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
 * <p>Java class for Dokumentnummer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Dokumentnummer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Journpostnoekkel"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="saksaar" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="sakssekvensnummer" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="journalpostnummer" type="{http://www.w3.org/2001/XMLSchema}integer" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Dokumentnummer", namespace = "http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31", propOrder = {
    "saksaar",
    "sakssekvensnummer",
    "journalpostnummer"
})
public class Dokumentnummer
    extends Journpostnoekkel
    implements ToString2
{

    @XmlElement(required = true)
    protected BigInteger saksaar;
    @XmlElement(required = true)
    protected BigInteger sakssekvensnummer;
    protected BigInteger journalpostnummer;

    /**
     * Gets the value of the saksaar property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSaksaar() {
        return saksaar;
    }

    /**
     * Sets the value of the saksaar property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSaksaar(BigInteger value) {
        this.saksaar = value;
    }

    /**
     * Gets the value of the sakssekvensnummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getSakssekvensnummer() {
        return sakssekvensnummer;
    }

    /**
     * Sets the value of the sakssekvensnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setSakssekvensnummer(BigInteger value) {
        this.sakssekvensnummer = value;
    }

    /**
     * Gets the value of the journalpostnummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getJournalpostnummer() {
        return journalpostnummer;
    }

    /**
     * Sets the value of the journalpostnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setJournalpostnummer(BigInteger value) {
        this.journalpostnummer = value;
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
            BigInteger theSaksaar;
            theSaksaar = this.getSaksaar();
            strategy.appendField(locator, this, "saksaar", buffer, theSaksaar, (this.saksaar!= null));
        }
        {
            BigInteger theSakssekvensnummer;
            theSakssekvensnummer = this.getSakssekvensnummer();
            strategy.appendField(locator, this, "sakssekvensnummer", buffer, theSakssekvensnummer, (this.sakssekvensnummer!= null));
        }
        {
            BigInteger theJournalpostnummer;
            theJournalpostnummer = this.getJournalpostnummer();
            strategy.appendField(locator, this, "journalpostnummer", buffer, theJournalpostnummer, (this.journalpostnummer!= null));
        }
        return buffer;
    }

}
