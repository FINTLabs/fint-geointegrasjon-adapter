
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="nokkel" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}EksternNoekkel" minOccurs="0"/&gt;
 *         &lt;element name="journalpostnokkel" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Journpostnoekkel" minOccurs="0"/&gt;
 *         &lt;element name="kontekst" type="{http://rep.geointegrasjon.no/Felles/Teknisk/xml.schema/2012.01.31}ArkivKontekst" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nokkel",
    "journalpostnokkel",
    "kontekst"
})
@XmlRootElement(name = "OppdaterJournalpostEksternNoekkel")
public class OppdaterJournalpostEksternNoekkel implements ToString2
{

    protected EksternNoekkel nokkel;
    protected Journpostnoekkel journalpostnokkel;
    protected ArkivKontekst kontekst;

    /**
     * Gets the value of the nokkel property.
     * 
     * @return
     *     possible object is
     *     {@link EksternNoekkel }
     *     
     */
    public EksternNoekkel getNokkel() {
        return nokkel;
    }

    /**
     * Sets the value of the nokkel property.
     * 
     * @param value
     *     allowed object is
     *     {@link EksternNoekkel }
     *     
     */
    public void setNokkel(EksternNoekkel value) {
        this.nokkel = value;
    }

    /**
     * Gets the value of the journalpostnokkel property.
     * 
     * @return
     *     possible object is
     *     {@link Journpostnoekkel }
     *     
     */
    public Journpostnoekkel getJournalpostnokkel() {
        return journalpostnokkel;
    }

    /**
     * Sets the value of the journalpostnokkel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Journpostnoekkel }
     *     
     */
    public void setJournalpostnokkel(Journpostnoekkel value) {
        this.journalpostnokkel = value;
    }

    /**
     * Gets the value of the kontekst property.
     * 
     * @return
     *     possible object is
     *     {@link ArkivKontekst }
     *     
     */
    public ArkivKontekst getKontekst() {
        return kontekst;
    }

    /**
     * Sets the value of the kontekst property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArkivKontekst }
     *     
     */
    public void setKontekst(ArkivKontekst value) {
        this.kontekst = value;
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
            EksternNoekkel theNokkel;
            theNokkel = this.getNokkel();
            strategy.appendField(locator, this, "nokkel", buffer, theNokkel, (this.nokkel!= null));
        }
        {
            Journpostnoekkel theJournalpostnokkel;
            theJournalpostnokkel = this.getJournalpostnokkel();
            strategy.appendField(locator, this, "journalpostnokkel", buffer, theJournalpostnokkel, (this.journalpostnokkel!= null));
        }
        {
            ArkivKontekst theKontekst;
            theKontekst = this.getKontekst();
            strategy.appendField(locator, this, "kontekst", buffer, theKontekst, (this.kontekst!= null));
        }
        return buffer;
    }

}
