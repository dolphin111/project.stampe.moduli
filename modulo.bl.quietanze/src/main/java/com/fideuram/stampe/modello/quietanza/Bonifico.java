package com.fideuram.stampe.modello.quietanza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by
 * User: logan
 * Date: 14/02/13
 * Time: 14.57
 */
@XmlRootElement(name="QUIETANZA")
@XmlAccessorType(XmlAccessType.FIELD)
public class Bonifico extends Quietanza {
    @XmlElement(name = "DATAORDINE")
    private String dataOrdine;
    @XmlElement(name = "BANCABENEFICIARIA")
    private String bancaBeneficiaria;
    @XmlElement(name = "IBAN")
    private String iban;
    @XmlElement(name = "Cro")
    private String cro;
    @XmlElement(name = "DATAVALUTA")
    private String dataValuta;

    public String getIban() {
    	if(iban != null)
    		iban = iban.trim();	
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCro() {
    	if(cro != null)
    		cro = cro.trim();	
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getDataOrdine() {
    	if(dataOrdine != null)
    		dataOrdine = dataOrdine.trim();	
        return dataOrdine;
    }

    public void setDataOrdine(String dataOrdine) {
        this.dataOrdine = dataOrdine;
    }

    public String getBancaBeneficiaria() {
    	if(bancaBeneficiaria != null)
    		bancaBeneficiaria = bancaBeneficiaria.trim();	
        return bancaBeneficiaria;
    }

    public void setBancaBeneficiaria(String bancaBeneficiaria) {
        this.bancaBeneficiaria = bancaBeneficiaria;
    }

    public String getDataValuta() {
    	if(dataValuta != null)
    		dataValuta = dataValuta.trim();	
        return dataValuta;
    }

    public void setDataValuta(String dataValuta) {
        this.dataValuta = dataValuta;
    }
}
