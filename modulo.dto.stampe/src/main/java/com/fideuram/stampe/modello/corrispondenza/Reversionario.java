package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="REVERSIONARIO", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Reversionario {
	
	@XmlElement(name = "COGNOMEREVERS")
	private String cognomeRevers;
	@XmlElement(name = "NOMEREVERS")
	private String nomeRevers;
	@XmlElement(name = "EGREGIO",nillable = true)
	private String egregio;
	
	public String getCognomeRevers() {
		return cognomeRevers;
	}
	public void setCognomeRevers(String cognomeRevers) {
		this.cognomeRevers = cognomeRevers;
	}
	public String getNomeRevers() {
		return nomeRevers;
	}
	public void setNomeRevers(String nomeRevers) {
		this.nomeRevers = nomeRevers;
	}
	public String getEgregio() {
		return egregio;
	}
	public void setEgregio(String egregio) {
		this.egregio = egregio;
	}
	
	
}
