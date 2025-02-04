package com.fideuram.stampe.modello.fpa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class DettaglioComparto {

	private String controvalore;
	private String controvaloreGarantito;
	private String dataNav;
	private String descrizioneComparto;
	private String numeroQuote;
	private String valoreNav;
	
	public String getControvalore() {
		return controvalore;
	}
	public void setControvalore(String controvalore) {
		this.controvalore = controvalore;
	}
	public String getControvaloreGarantito() {
		return controvaloreGarantito;
	}
	public void setControvaloreGarantito(String controvaloreGarantito) {
		this.controvaloreGarantito = controvaloreGarantito;
	}
	public String getDataNav() {
		return dataNav;
	}
	public void setDataNav(String dataNav) {
		this.dataNav = dataNav;
	}
	public String getDescrizioneComparto() {
		return descrizioneComparto;
	}
	public void setDescrizioneComparto(String descrizioneComparto) {
		this.descrizioneComparto = descrizioneComparto;
	}
	public String getNumeroQuote() {
		return numeroQuote;
	}
	public void setNumeroQuote(String numeroQuote) {
		this.numeroQuote = numeroQuote;
	}
	public String getValoreNav() {
		return valoreNav;
	}
	public void setValoreNav(String valoreNav) {
		this.valoreNav = valoreNav;
	}
	
}
