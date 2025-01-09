
package no.geointegrasjon.arkiv.innsyn;

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
 * <p>Java class for Journalnummer complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Journalnummer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Journpostnoekkel"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="journalaar" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="journalsekvensnummer" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Journalnummer", propOrder = {
    "journalaar",
    "journalsekvensnummer"
})
public class Journalnummer
    extends Journpostnoekkel
    implements ToString2
{

    @XmlElement(required = true)
    protected BigInteger journalaar;
    @XmlElement(required = true)
    protected BigInteger journalsekvensnummer;

    /**
     * Gets the value of the journalaar property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getJournalaar() {
        return journalaar;
    }

    /**
     * Sets the value of the journalaar property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setJournalaar(BigInteger value) {
        this.journalaar = value;
    }

    /**
     * Gets the value of the journalsekvensnummer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getJournalsekvensnummer() {
        return journalsekvensnummer;
    }

    /**
     * Sets the value of the journalsekvensnummer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setJournalsekvensnummer(BigInteger value) {
        this.journalsekvensnummer = value;
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
            BigInteger theJournalaar;
            theJournalaar = this.getJournalaar();
            strategy.appendField(locator, this, "journalaar", buffer, theJournalaar, (this.journalaar!= null));
        }
        {
            BigInteger theJournalsekvensnummer;
            theJournalsekvensnummer = this.getJournalsekvensnummer();
            strategy.appendField(locator, this, "journalsekvensnummer", buffer, theJournalsekvensnummer, (this.journalsekvensnummer!= null));
        }
        return buffer;
    }

}
