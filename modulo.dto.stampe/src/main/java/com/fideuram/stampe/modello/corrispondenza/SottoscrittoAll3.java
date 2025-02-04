package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="SOTTOSCRITTO", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class SottoscrittoAll3 extends SottoscrittoAll2 {

	
	@XmlElement(name = "DATANASCITA")
	private String dataNascita;
	@XmlElement(name = "COMUNENASCITA")
	private String comuneNascita;
	@XmlElement(name = "PROVINCIANASCITA")
	private String provinciaNascita;
	@XmlElement(name = "RENDITAVITALIZA")
	private String renditaVitalizia;
	

	public String getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(String dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getComuneNascita() {
		return comuneNascita;
	}
	public void setComuneNascita(String comuneNascita) {
		this.comuneNascita = comuneNascita;
	}
	public String getProvinciaNascita() {
		return provinciaNascita;
	}
	public void setProvinciaNascita(String provinciaNascita) {
		this.provinciaNascita = provinciaNascita;
	}
	public String getRenditaVitalizia() {
		return renditaVitalizia;
	}
	public void setRenditaVitalizia(String renditaVitalizia) {
		this.renditaVitalizia = renditaVitalizia;
	}


    @Override
    public String toString() {
        return getCognome().trim() + " "+ getNome().trim();
    }
}
