
package br.com.lemontech.selfbooking.wsselfbooking.beans.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoViagem.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoViagem">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="TODOS"/>
 *     &lt;enumeration value="NACIONAL"/>
 *     &lt;enumeration value="CONTINENTAL"/>
 *     &lt;enumeration value="INTERNACIONAL"/>
 *     &lt;enumeration value="INTERCONTINENTAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoViagem")
@XmlEnum
public enum TipoViagem {

    TODOS,
    NACIONAL,
    CONTINENTAL,
    INTERNACIONAL,
    INTERCONTINENTAL;

    public String value() {
        return name();
    }

    public static TipoViagem fromValue(String v) {
        return valueOf(v);
    }

}
