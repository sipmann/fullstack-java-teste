
package br.com.lemontech.selfbooking.wsselfbooking.beans.types;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de itensFaturamentoHotel complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="itensFaturamentoHotel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="itenFaturamento" type="{http://lemontech.com.br/selfbooking/wsselfbooking/beans/types}itenFaturamento" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itensFaturamentoHotel", propOrder = {
    "itenFaturamento"
})
public class ItensFaturamentoHotel {

    @XmlSchemaType(name = "string")
    protected List<ItenFaturamento> itenFaturamento;

    /**
     * Gets the value of the itenFaturamento property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itenFaturamento property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItenFaturamento().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItenFaturamento }
     * 
     * 
     */
    public List<ItenFaturamento> getItenFaturamento() {
        if (itenFaturamento == null) {
            itenFaturamento = new ArrayList<ItenFaturamento>();
        }
        return this.itenFaturamento;
    }

}
