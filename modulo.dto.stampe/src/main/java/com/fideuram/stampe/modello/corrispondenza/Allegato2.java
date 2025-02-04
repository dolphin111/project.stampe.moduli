package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ALLEGATO2", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Allegato2 {

	@XmlElement(name = "SOTTOSCRITTO")
	private SottoscrittoAll2 sottoscritto;
	@XmlElement(name = "POLIZZA")
	private String polizza;
	
	
	public SottoscrittoAll2 getSottoscritto() {
		return sottoscritto;
	}
	public void setSottoscritto(SottoscrittoAll2 sottoscritto) {
		this.sottoscritto = sottoscritto;
	}
	public String getPolizza() {
		return polizza;
	}
	public void setPolizza(String polizza) {
		this.polizza = polizza;
	}

	
}
