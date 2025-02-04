package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="OGGETTO", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Oggetto {
	
	 @XmlElement(name = "POLIZZA")
	private String polizza;

	
	public String getPolizza() {
		return polizza;
	}

	public void setPolizza(String polizza) {
		this.polizza = polizza;
	}

}
