
package br.com.lemontech.selfbooking.wsselfbooking.beans.types;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de perfilFuncionarioParametrizacao.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="perfilFuncionarioParametrizacao">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="APROVADOR"/>
 *     &lt;enumeration value="SOLICITANTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "perfilFuncionarioParametrizacao")
@XmlEnum
public enum PerfilFuncionarioParametrizacao {

    APROVADOR,
    SOLICITANTE;

    public String value() {
        return name();
    }

    public static PerfilFuncionarioParametrizacao fromValue(String v) {
        return valueOf(v);
    }

}
