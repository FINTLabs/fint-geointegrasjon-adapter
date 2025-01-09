
package no.geointegrasjon.arkiv.oppdatering;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SoekeOperatorEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="SoekeOperatorEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="LT"/&gt;
 *     &lt;enumeration value="LE"/&gt;
 *     &lt;enumeration value="EQ"/&gt;
 *     &lt;enumeration value="GE"/&gt;
 *     &lt;enumeration value="GT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "SoekeOperatorEnum", namespace = "http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31")
@XmlEnum
public enum SoekeOperatorEnum {

    LT,
    LE,
    EQ,
    GE,
    GT;

    public String value() {
        return name();
    }

    public static SoekeOperatorEnum fromValue(String v) {
        return valueOf(v);
    }

}
