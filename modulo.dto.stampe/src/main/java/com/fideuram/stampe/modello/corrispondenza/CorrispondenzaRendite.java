package com.fideuram.stampe.modello.corrispondenza;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name="TIPOLOGIE", namespace= "")
@XmlAccessorType(XmlAccessType.FIELD)
public class CorrispondenzaRendite {
	

	 @XmlElement(name = "TIPOLETTERA")
	private List<TipoLettera> tipoLettera;
	 @XmlElement(name = "NUMEROPEZZI")
	private String numeropezzi;
	

	public List<TipoLettera> getTipoLettera() {
		return tipoLettera;
	}

	public void setTipoLettera(List<TipoLettera> tipoLettera) {
		this.tipoLettera = tipoLettera;
	}

	public String getNumeropezzi() {
		return numeropezzi;
	}

	public void setNumeropezzi(String numeropezzi) {
		this.numeropezzi = numeropezzi;
	}
	

}
