package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="DATIPRIVATEBANKER", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatiPrivateBanker {
	
	@XmlElement(name = "COGNOMEPRIVATEBANKER")
	private String cognomePrivateBanker;
	@XmlElement(name = "NOMEPRIVATEBANKER")
	private String nomePrivateBanker;
	@XmlElement(name = "SESSOPRIVATEBANKER",nillable = true)
	private String sessoPrivateBanker;
	@XmlElement(name = "INDIRPRIVATEBANKER",nillable = true)
	private String indirPrivateBanker;
	@XmlElement(name = "CITTAPRIVATEBANKER",nillable = true)
	private String cittaPrivateBanker;
	@XmlElement(name = "PROVIPRIVATEBANKER",nillable = true)
	private String proviPrivateBanker;
	@XmlElement(name = "CAPPRIVATEBANKER",nillable = true)
	private String capPrivateBanker;
	@XmlElement(name = "EGREGIO",nillable = true)
	private String egregio;
	
	
	public String getCognomePrivateBanker() {
		return cognomePrivateBanker;
	}
	public void setCognomePrivateBanker(String cognomePrivateBanker) {
		this.cognomePrivateBanker = cognomePrivateBanker;
	}
	public String getNomePrivateBanker() {
		return nomePrivateBanker;
	}
	public void setNomePrivateBanker(String nomePrivateBanker) {
		this.nomePrivateBanker = nomePrivateBanker;
	}


    public String getSessoPrivateBanker() {
		return sessoPrivateBanker;
	}
	public void setSessoPrivateBanker(String sessoPrivateBanker) {
		this.sessoPrivateBanker = sessoPrivateBanker;
	}
	public String getIndirPrivateBanker() {
		return indirPrivateBanker;
	}
	public void setIndirPrivateBanker(String indirPrivateBanker) {
		this.indirPrivateBanker = indirPrivateBanker;
	}
	public String getCittaPrivateBanker() {
		return cittaPrivateBanker;
	}
	public void setCittaPrivateBanker(String cittaPrivateBanker) {
		this.cittaPrivateBanker = cittaPrivateBanker;
	}
	public String getProviPrivateBanker() {
		return proviPrivateBanker;
	}
	public void setProviPrivateBanker(String proviPrivateBanker) {
		this.proviPrivateBanker = proviPrivateBanker;
	}
	public String getCapPrivateBanker() {
		return capPrivateBanker;
	}
	public void setCapPrivateBanker(String capPrivateBanker) {
		this.capPrivateBanker = capPrivateBanker;
	}
	
	public String getEgregio() {
		return egregio;
	}
	public void setEgregio(String egregio) {
		this.egregio = egregio;
	}
	@Override
    public String toString() {
        return  cognomePrivateBanker.trim() +" "+nomePrivateBanker.trim();
    }
}
