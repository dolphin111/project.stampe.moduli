package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ELENCOBENEFICIARI", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class ElencoBeneficiari {

	 @XmlElement(name = "POLIZZA")
	private String polizza;
	 @XmlElement(name = "COGNOMECONTRAENTE")
	private String cognomeContraente;
	 @XmlElement(name = "NOMECONTRAENTE")
	private String nomeContraente;
	 @XmlElement(name = "COGNOMEBENEFICIARIO")
	private String cognomeBeneficiario;
	 @XmlElement(name = "NOMEBENEFICIARIO")
	private String nomeBeneficiario;
	 @XmlElement(name = "COGNOMEASSICURATO")
	private String cognomeAssicurato;
	 @XmlElement(name = "NOMEASSICURATO")
	private String nomeAssicurato;
	 
	 
	public String getPolizza() {
		return polizza;
	}
	public void setPolizza(String polizza) {
		this.polizza = polizza;
	}
	public String getCognomeContraente() {
		return cognomeContraente;
	}
	public void setCognomeContraente(String cognomeContraente) {
		this.cognomeContraente = cognomeContraente;
	}
	public String getNomeContraente() {
		return nomeContraente;
	}
	public void setNomeContraente(String nomeContraente) {
		this.nomeContraente = nomeContraente;
	}
	public String getCognomeBeneficiario() {
		return cognomeBeneficiario;
	}
	public void setCognomeBeneficiario(String cognomeBeneficiario) {
		this.cognomeBeneficiario = cognomeBeneficiario;
	}
	public String getNomeBeneficiario() {
		return nomeBeneficiario;
	}
	public void setNomeBeneficiario(String nomeBeneficiario) {
		this.nomeBeneficiario = nomeBeneficiario;
	}
	public String getCognomeAssicurato() {
		return cognomeAssicurato;
	}
	public void setCognomeAssicurato(String cognomeAssicurato) {
		this.cognomeAssicurato = cognomeAssicurato;
	}
	public String getNomeAssicurato() {
		return nomeAssicurato;
	}
	public void setNomeAssicurato(String nomeAssicurato) {
		this.nomeAssicurato = nomeAssicurato;
	}


    public String getContraente() {
        return cognomeContraente.trim() + " "+ nomeContraente.trim();
    }
    public String getAssicurato() {
        return cognomeAssicurato.trim() + " "+ nomeAssicurato.trim();
    }
    public String getBeneficiario() {
        return cognomeBeneficiario.trim() + " "+ nomeBeneficiario.trim();
    }
}
