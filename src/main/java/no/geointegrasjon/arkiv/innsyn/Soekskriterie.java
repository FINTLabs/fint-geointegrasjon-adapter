
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import org.jvnet.jaxb2_commons.lang.JAXBToStringStrategy;
import org.jvnet.jaxb2_commons.lang.ToString2;
import org.jvnet.jaxb2_commons.lang.ToStringStrategy2;
import org.jvnet.jaxb2_commons.locator.ObjectLocator;


/**
 * <p>Java class for Soekskriterie complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Soekskriterie"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="operator" type="{http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31}SoekeOperatorEnum"/&gt;
 *         &lt;element name="Kriterie" type="{http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31}Kriterie"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Soekskriterie", namespace = "http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31", propOrder = {
    "operator",
    "kriterie"
})
public class Soekskriterie implements ToString2
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SoekeOperatorEnum operator;
    @XmlElement(name = "Kriterie", required = true)
    protected Kriterie kriterie;

    /**
     * Gets the value of the operator property.
     * 
     * @return
     *     possible object is
     *     {@link SoekeOperatorEnum }
     *     
     */
    public SoekeOperatorEnum getOperator() {
        return operator;
    }

    /**
     * Sets the value of the operator property.
     * 
     * @param value
     *     allowed object is
     *     {@link SoekeOperatorEnum }
     *     
     */
    public void setOperator(SoekeOperatorEnum value) {
        this.operator = value;
    }

    /**
     * Gets the value of the kriterie property.
     * 
     * @return
     *     possible object is
     *     {@link Kriterie }
     *     
     */
    public Kriterie getKriterie() {
        return kriterie;
    }

    /**
     * Sets the value of the kriterie property.
     * 
     * @param value
     *     allowed object is
     *     {@link Kriterie }
     *     
     */
    public void setKriterie(Kriterie value) {
        this.kriterie = value;
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
            SoekeOperatorEnum theOperator;
            theOperator = this.getOperator();
            strategy.appendField(locator, this, "operator", buffer, theOperator, (this.operator!= null));
        }
        {
            Kriterie theKriterie;
            theKriterie = this.getKriterie();
            strategy.appendField(locator, this, "kriterie", buffer, theKriterie, (this.kriterie!= null));
        }
        return buffer;
    }

}
