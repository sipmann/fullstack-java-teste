
package br.com.lemontech.selfbooking.wsselfbooking.beans.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de tipoIntegracao.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoIntegracao">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CONCLUSAO"/>
 *     &lt;enumeration value="CANCELAMENTO"/>
 *     &lt;enumeration value="PENDENCIA_APROVACAO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoIntegracao")
@XmlEnum
public enum TipoIntegracao {

    CONCLUSAO,
    CANCELAMENTO,
    PENDENCIA_APROVACAO;

    public String value() {
        return name();
    }

    public static TipoIntegracao fromValue(String v) {
        return valueOf(v);
    }

}
