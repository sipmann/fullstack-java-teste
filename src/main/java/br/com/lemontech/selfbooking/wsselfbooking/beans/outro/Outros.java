
package br.com.lemontech.selfbooking.wsselfbooking.beans.outro;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de outros complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="outros">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="outros" type="{http://lemontech.com.br/selfbooking/wsselfbooking/beans/outro}outro" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "outros", propOrder = {
    "outros"
})
public class Outros {

    protected List<Outro> outros;

    /**
     * Gets the value of the outros property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outros property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutros().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Outro }
     * 
     * 
     */
    public List<Outro> getOutros() {
        if (outros == null) {
            outros = new ArrayList<Outro>();
        }
        return this.outros;
    }

}
