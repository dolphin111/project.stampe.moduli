package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="RECORD", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Record {
	
	
	@XmlElement(name = "PROGRESSIVO")
	private String progressivo;
	@XmlElement(name = "POLIZZA")
	private String polizza;
	@XmlElement(name = "ASSICURATO")
	private Assicurato assicurato;
	@XmlElement(name = "BENEFICIARIO")
	private Beneficiario beneficiario;
	@XmlElement(name = "DESTINATARIO")
	private Beneficiario destinatario;
	@XmlElement(name = "SCADENZA")
	private String scadenza;
	
	
	public String getProgressivo() {
		return progressivo;
	}
	public void setProgressivo(String progressivo) {
		this.progressivo = progressivo;
	}
	public String getPolizza() {
		return polizza;
	}
	public void setPolizza(String polizza) {
		this.polizza = polizza;
	}
	public Assicurato getAssicurato() {
		return assicurato;
	}
	public void setAssicurato(Assicurato assicurato) {
		this.assicurato = assicurato;
	}
	public Beneficiario getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(Beneficiario beneficiario) {
		this.beneficiario = beneficiario;
	}
	public Beneficiario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Beneficiario destinatario) {
		this.destinatario = destinatario;
	}
	public String getScadenza() {
		return scadenza;
	}
	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}




}
