package com.fideuram.stampe.modello.corrispondenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="ALLEGATO3", namespace = "")
@XmlAccessorType(XmlAccessType.FIELD)
public class Allegato3 {
	
	
	@XmlElement(name = "ELENCOBENEFICIARI")
	private ElencoBeneficiari elencoBeneficiari;
	@XmlElement(name = "SOTTOSCRITTO")
	private SottoscrittoAll3 sottoscritto;
	@XmlElement(name = "DATIPRIVATEBANKER")
	private DatiPrivateBanker datiPrivateBanker;
	
	
	public ElencoBeneficiari getElencoBeneficiari() {
		return elencoBeneficiari;
	}
	public void setElencoBeneficiari(ElencoBeneficiari elencoBeneficiari) {
		this.elencoBeneficiari = elencoBeneficiari;
	}
	public SottoscrittoAll3 getSottoscritto() {
		return sottoscritto;
	}
	public void setSottoscritto(SottoscrittoAll3 sottoscritto) {
		this.sottoscritto = sottoscritto;
	}
	public DatiPrivateBanker getDatiPrivateBanker() {
		return datiPrivateBanker;
	}
	public void setDatiPrivateBanker(DatiPrivateBanker datiPrivateBanker) {
		this.datiPrivateBanker = datiPrivateBanker;
	}
	

}
