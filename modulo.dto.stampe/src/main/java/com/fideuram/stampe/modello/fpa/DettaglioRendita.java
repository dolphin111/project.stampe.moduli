package com.fideuram.stampe.modello.fpa;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class DettaglioRendita {

	private String ammontarePosizioneIndividualeMaturata;
	private String coefficienteRenditaFrazionata;
	private String rateazioneAnnua;
	private String rateazioneMensile;
	private String rateazioneSemestrale;
	private String rateazioneTrimestrale;
	public String getAmmontarePosizioneIndividualeMaturata() {
		return ammontarePosizioneIndividualeMaturata;
	}
	public void setAmmontarePosizioneIndividualeMaturata(
			String ammontarePosizioneIndividualeMaturata) {
		this.ammontarePosizioneIndividualeMaturata = ammontarePosizioneIndividualeMaturata;
	}
	public String getCoefficienteRenditaFrazionata() {
		return coefficienteRenditaFrazionata;
	}
	public void setCoefficienteRenditaFrazionata(
			String coefficienteRenditaFrazionata) {
		this.coefficienteRenditaFrazionata = coefficienteRenditaFrazionata;
	}
	public String getRateazioneAnnua() {
		return rateazioneAnnua;
	}
	public void setRateazioneAnnua(String rateazioneAnnua) {
		this.rateazioneAnnua = rateazioneAnnua;
	}
	public String getRateazioneMensile() {
		return rateazioneMensile;
	}
	public void setRateazioneMensile(String rateazioneMensile) {
		this.rateazioneMensile = rateazioneMensile;
	}
	public String getRateazioneSemestrale() {
		return rateazioneSemestrale;
	}
	public void setRateazioneSemestrale(String rateazioneSemestrale) {
		this.rateazioneSemestrale = rateazioneSemestrale;
	}
	public String getRateazioneTrimestrale() {
		return rateazioneTrimestrale;
	}
	public void setRateazioneTrimestrale(String rateazioneTrimestrale) {
		this.rateazioneTrimestrale = rateazioneTrimestrale;
	}
	
}
