package com.fideuram.preventivo.modello;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;


@XmlType(name="PremiFVIStr")
public class PremiFVIStr implements Serializable {
	
	private String premioAnnuoCostanteComplessivo;
    private String eta;
    private String dataDiDecorrenza;
    private String descrizione;
    
    
	public String getPremioAnnuoCostanteComplessivo() {
		return premioAnnuoCostanteComplessivo;
	}
	public void setPremioAnnuoCostanteComplessivo(
			String premioAnnuoCostanteComplessivo) {
		this.premioAnnuoCostanteComplessivo = premioAnnuoCostanteComplessivo;
	}
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public String getDataDiDecorrenza() {
		return dataDiDecorrenza;
	}
	public void setDataDiDecorrenza(String dataDiDecorrenza) {
		this.dataDiDecorrenza = dataDiDecorrenza;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
    
}
