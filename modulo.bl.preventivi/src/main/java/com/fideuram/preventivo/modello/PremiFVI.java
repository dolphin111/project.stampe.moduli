package com.fideuram.preventivo.modello;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.XmlType;


@XmlType(name="PremiFVI")
public class PremiFVI implements Serializable {
	
	private Double premioAnnuoCostanteComplessivo;
    private Integer eta;
    private Date dataDiDecorrenza;
    private String descrizione;
    
    
	public Double getPremioAnnuoCostanteComplessivo() {
		return premioAnnuoCostanteComplessivo;
	}
	
	public void setPremioAnnuoCostanteComplessivo(
			Double premioAnnuoCostanteComplessivo) {
		this.premioAnnuoCostanteComplessivo = premioAnnuoCostanteComplessivo;
	}
	
	public Integer getEta() {
		return eta;
	}
	
	public void setEta(Integer eta) {
		this.eta = eta;
	}
	
	public Date getDataDiDecorrenza() {
		return dataDiDecorrenza;
	}
	
	public void setDataDiDecorrenza(Date dataDiDecorrenza) {
		this.dataDiDecorrenza = dataDiDecorrenza;
	}
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
}
