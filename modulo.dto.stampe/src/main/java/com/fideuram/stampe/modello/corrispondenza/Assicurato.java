package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ASSICURATO", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Assicurato {
	
	@XmlElement(name = "COGNOME")
	private String cognome;
	@XmlElement(name = "NOME")
	private String nome;
	@XmlElement(name = "EGREGIO", nillable = true)
	private String egregio;
	
	
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

    public String getEgregio() {
		return egregio;
	}
	public void setEgregio(String egregio) {
		this.egregio = egregio;
	}
	@Override
    public String toString() {
        return  cognome.trim() + " " +nome.trim() ;
    }
}
