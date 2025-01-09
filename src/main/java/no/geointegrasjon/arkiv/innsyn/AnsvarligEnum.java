
package no.geointegrasjon.arkiv.innsyn;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for AnsvarligEnum.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="AnsvarligEnum"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="EGEN"/&gt;
 *     &lt;enumeration value="EGENENHET"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "AnsvarligEnum", namespace = "http://rep.geointegrasjon.no/Felles/Filter/xml.schema/2012.01.31")
@XmlEnum
public enum AnsvarligEnum {

    EGEN,
    EGENENHET;

    public String value() {
        return name();
    }

    public static AnsvarligEnum fromValue(String v) {
        return valueOf(v);
    }

}
