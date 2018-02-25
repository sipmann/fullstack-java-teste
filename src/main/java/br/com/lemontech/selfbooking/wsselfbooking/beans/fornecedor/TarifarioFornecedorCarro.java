
package br.com.lemontech.selfbooking.wsselfbooking.beans.fornecedor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import br.com.lemontech.selfbooking.wsselfbooking.beans.types.Moeda;


/**
 * <p>Classe Java de tarifarioFornecedorCarro complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="tarifarioFornecedorCarro">
 *   &lt;complexContent>
 *     &lt;extension base="{http://lemontech.com.br/selfbooking/wsselfbooking/beans/fornecedor}tarifarioFornecedorCarroRef">
 *       &lt;sequence>
 *         &lt;element name="vencimento" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="descricao" type="{http://lemontech.com.br/selfbooking/wsselfbooking/common/types}descricaoElemento255" minOccurs="0"/>
 *         &lt;element name="tarifa" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="seguro" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tarifaDiariaAdicional" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="tarifaHoraAdicional" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="moeda" type="{http://lemontech.com.br/selfbooking/wsselfbooking/beans/types}moeda"/>
 *         &lt;element name="ativo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tarifarioFornecedorCarro", propOrder = {
    "vencimento",
    "descricao",
    "tarifa",
    "seguro",
    "tarifaDiariaAdicional",
    "tarifaHoraAdicional",
    "moeda",
    "ativo"
})
public class TarifarioFornecedorCarro
    extends TarifarioFornecedorCarroRef
{

    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar vencimento;
    protected String descricao;
    protected double tarifa;
    protected double seguro;
    protected double tarifaDiariaAdicional;
    protected double tarifaHoraAdicional;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Moeda moeda;
    protected boolean ativo;

    /**
     * Obt�m o valor da propriedade vencimento.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getVencimento() {
        return vencimento;
    }

    /**
     * Define o valor da propriedade vencimento.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setVencimento(XMLGregorianCalendar value) {
        this.vencimento = value;
    }

    /**
     * Obt�m o valor da propriedade descricao.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define o valor da propriedade descricao.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescricao(String value) {
        this.descricao = value;
    }

    /**
     * Obt�m o valor da propriedade tarifa.
     * 
     */
    public double getTarifa() {
        return tarifa;
    }

    /**
     * Define o valor da propriedade tarifa.
     * 
     */
    public void setTarifa(double value) {
        this.tarifa = value;
    }

    /**
     * Obt�m o valor da propriedade seguro.
     * 
     */
    public double getSeguro() {
        return seguro;
    }

    /**
     * Define o valor da propriedade seguro.
     * 
     */
    public void setSeguro(double value) {
        this.seguro = value;
    }

    /**
     * Obt�m o valor da propriedade tarifaDiariaAdicional.
     * 
     */
    public double getTarifaDiariaAdicional() {
        return tarifaDiariaAdicional;
    }

    /**
     * Define o valor da propriedade tarifaDiariaAdicional.
     * 
     */
    public void setTarifaDiariaAdicional(double value) {
        this.tarifaDiariaAdicional = value;
    }

    /**
     * Obt�m o valor da propriedade tarifaHoraAdicional.
     * 
     */
    public double getTarifaHoraAdicional() {
        return tarifaHoraAdicional;
    }

    /**
     * Define o valor da propriedade tarifaHoraAdicional.
     * 
     */
    public void setTarifaHoraAdicional(double value) {
        this.tarifaHoraAdicional = value;
    }

    /**
     * Obt�m o valor da propriedade moeda.
     * 
     * @return
     *     possible object is
     *     {@link Moeda }
     *     
     */
    public Moeda getMoeda() {
        return moeda;
    }

    /**
     * Define o valor da propriedade moeda.
     * 
     * @param value
     *     allowed object is
     *     {@link Moeda }
     *     
     */
    public void setMoeda(Moeda value) {
        this.moeda = value;
    }

    /**
     * Obt�m o valor da propriedade ativo.
     * 
     */
    public boolean isAtivo() {
        return ativo;
    }

    /**
     * Define o valor da propriedade ativo.
     * 
     */
    public void setAtivo(boolean value) {
        this.ativo = value;
    }

}
