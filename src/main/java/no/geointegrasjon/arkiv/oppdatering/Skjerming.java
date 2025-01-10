
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Skjerming complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Skjerming"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="tilgangsrestriksjon" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}Tilgangsrestriksjon" minOccurs="0"/&gt;
 *         &lt;element name="skjermingshjemmel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="skjermingOpphoererDato" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="skjermingOpphoererAksjon" type="{http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31}SkjermingOpphorerAksjon" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Skjerming", namespace = "http://rep.geointegrasjon.no/Arkiv/Kjerne/xml.schema/2012.01.31", propOrder = {
    "tilgangsrestriksjon",
    "skjermingshjemmel",
    "skjermingOpphoererDato",
    "skjermingOpphoererAksjon"
})
public class Skjerming implements ToString2
{

    protected Tilgangsrestriksjon tilgangsrestriksjon;
    protected String skjermingshjemmel;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar skjermingOpphoererDato;
    protected SkjermingOpphorerAksjon skjermingOpphoererAksjon;

    /**
     * Gets the value of the tilgangsrestriksjon property.
     * 
     * @return
     *     possible object is
     *     {@link Tilgangsrestriksjon }
     *     
     */
    public Tilgangsrestriksjon getTilgangsrestriksjon() {
        return tilgangsrestriksjon;
    }

    /**
     * Sets the value of the tilgangsrestriksjon property.
     * 
     * @param value
     *     allowed object is
     *     {@link Tilgangsrestriksjon }
     *     
     */
    public void setTilgangsrestriksjon(Tilgangsrestriksjon value) {
        this.tilgangsrestriksjon = value;
    }

    /**
     * Gets the value of the skjermingshjemmel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSkjermingshjemmel() {
        return skjermingshjemmel;
    }

    /**
     * Sets the value of the skjermingshjemmel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSkjermingshjemmel(String value) {
        this.skjermingshjemmel = value;
    }

    /**
     * Gets the value of the skjermingOpphoererDato property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSkjermingOpphoererDato() {
        return skjermingOpphoererDato;
    }

    /**
     * Sets the value of the skjermingOpphoererDato property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSkjermingOpphoererDato(XMLGregorianCalendar value) {
        this.skjermingOpphoererDato = value;
    }

    /**
     * Gets the value of the skjermingOpphoererAksjon property.
     * 
     * @return
     *     possible object is
     *     {@link SkjermingOpphorerAksjon }
     *     
     */
    public SkjermingOpphorerAksjon getSkjermingOpphoererAksjon() {
        return skjermingOpphoererAksjon;
    }

    /**
     * Sets the value of the skjermingOpphoererAksjon property.
     * 
     * @param value
     *     allowed object is
     *     {@link SkjermingOpphorerAksjon }
     *     
     */
    public void setSkjermingOpphoererAksjon(SkjermingOpphorerAksjon value) {
        this.skjermingOpphoererAksjon = value;
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
            Tilgangsrestriksjon theTilgangsrestriksjon;
            theTilgangsrestriksjon = this.getTilgangsrestriksjon();
            strategy.appendField(locator, this, "tilgangsrestriksjon", buffer, theTilgangsrestriksjon, (this.tilgangsrestriksjon!= null));
        }
        {
            String theSkjermingshjemmel;
            theSkjermingshjemmel = this.getSkjermingshjemmel();
            strategy.appendField(locator, this, "skjermingshjemmel", buffer, theSkjermingshjemmel, (this.skjermingshjemmel!= null));
        }
        {
            XMLGregorianCalendar theSkjermingOpphoererDato;
            theSkjermingOpphoererDato = this.getSkjermingOpphoererDato();
            strategy.appendField(locator, this, "skjermingOpphoererDato", buffer, theSkjermingOpphoererDato, (this.skjermingOpphoererDato!= null));
        }
        {
            SkjermingOpphorerAksjon theSkjermingOpphoererAksjon;
            theSkjermingOpphoererAksjon = this.getSkjermingOpphoererAksjon();
            strategy.appendField(locator, this, "skjermingOpphoererAksjon", buffer, theSkjermingOpphoererAksjon, (this.skjermingOpphoererAksjon!= null));
        }
        return buffer;
    }

}
