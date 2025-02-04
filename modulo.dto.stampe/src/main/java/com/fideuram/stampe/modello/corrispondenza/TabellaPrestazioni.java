package com.fideuram.stampe.modello.corrispondenza;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="TABELLAPRESTAZIONI", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class TabellaPrestazioni {
	
	@XmlElement(name = "PRESTAZIONE")
	private List<Prestazione> prestazione;
	 

	public List<Prestazione> getPrestazione() {
		return prestazione;
	}

	public void setPrestazione(List<Prestazione> prestazione) {
		this.prestazione = prestazione;
	}

}
