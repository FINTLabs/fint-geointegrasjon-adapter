
package no.geointegrasjon.arkiv.oppdatering;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for PunktListe complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PunktListe"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="liste" type="{http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31}Punkt" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PunktListe", namespace = "http://rep.geointegrasjon.no/Felles/Geometri/xml.schema/2012.01.31", propOrder = {
    "liste"
})
public class PunktListe implements ToString2
{

    protected List<Punkt> liste;

    /**
     * Gets the value of the liste property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the liste property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListe().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Punkt }
     * 
     * 
     */
    public List<Punkt> getListe() {
        if (liste == null) {
            liste = new ArrayList<Punkt>();
        }
        return this.liste;
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
            List<Punkt> theListe;
            theListe = (((this.liste!= null)&&(!this.liste.isEmpty()))?this.getListe():null);
            strategy.appendField(locator, this, "liste", buffer, theListe, ((this.liste!= null)&&(!this.liste.isEmpty())));
        }
        return buffer;
    }

}