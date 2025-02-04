package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="SOTTOSCRITTO", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class SottoscrittoAll4 extends SottoscrittoAll3{
	
	@XmlElement(name = "CODICEFISCALE")
	private String codiceFiscale;

	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	
	

}
