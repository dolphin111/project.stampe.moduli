package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="ALLEGATO4", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Allegato4 {
	
	@XmlElement(name = "SOTTOSCRITTO")
	private SottoscrittoAll4 sottoscritto;
	
	
	public SottoscrittoAll4 getSottoscritto() {
		return sottoscritto;
	}

	public void setSottoscritto(SottoscrittoAll4 sottoscritto) {
		this.sottoscritto = sottoscritto;
	}
	

}
