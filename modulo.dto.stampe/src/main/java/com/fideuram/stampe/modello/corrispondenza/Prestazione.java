package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="RECORD", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Prestazione {
	
	
	@XmlElement(name = "PROGRESSIVO")
	private String progressivo;
	@XmlElement(name = "POLIZZA")
	private String polizza;
	@XmlElement(name = "SCADENZARATA")
	private String scadenzaRata;
	@XmlElement(name = "IMPORTO")
	private String importo;
	
	
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
	public String getScadenzaRata() {
		return scadenzaRata;
	}
	public void setScadenzaRata(String scadenzaRata) {
		this.scadenzaRata = scadenzaRata;
	}
	public String getImporto() {
		return importo;
	}
	public void setImporto(String importo) {
		this.importo = importo;
	}
	

}
