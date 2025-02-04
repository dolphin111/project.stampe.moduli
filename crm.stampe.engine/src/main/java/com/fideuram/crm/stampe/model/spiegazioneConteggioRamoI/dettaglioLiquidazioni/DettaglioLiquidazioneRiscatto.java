package com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.dettaglioLiquidazioni;


import com.fideuram.factory.FormatterFactory;

public class DettaglioLiquidazioneRiscatto extends DettaglioPrestazioneLiquidazione {
	
	private Double costoLiquidazione;
	private Double riservaMatematica;
	private Double capitaleCasoMorte;
	private Double valoreRiscatto;
	private Double eccedenza;
	private String dataRiservaMatematica;
	
	public String getCostoLiquidazione() {
        return FormatterFactory.getStandardImporto(Double.valueOf(costoLiquidazione));
	}
	public void setCostoLiquidazione(Double costoLiquidazione) {
		this.costoLiquidazione = costoLiquidazione;
	}
	public String getRiservaMatematica() {
        return FormatterFactory.getStandardImporto(Double.valueOf(riservaMatematica));
	}
	public void setRiservaMatematica(Double riservaMatematica) {
		this.riservaMatematica = riservaMatematica;
	}
	public String getCapitaleCasoMorte() {
        return FormatterFactory.getStandardImporto(Double.valueOf(capitaleCasoMorte));
	}
	public void setCapitaleCasoMorte(Double capitaleCasoMorte) {
		this.capitaleCasoMorte = capitaleCasoMorte;
	}
	public String getValoreRiscatto() {
        return FormatterFactory.getStandardImporto(Double.valueOf(valoreRiscatto));
	}
	public void setValoreRiscatto(Double valoreRiscatto) {
		this.valoreRiscatto = valoreRiscatto;
	}
	public String getEccedenza() {
        return FormatterFactory.getStandardImporto(Double.valueOf(eccedenza));
	}
	public void setEccedenza(Double eccedenza) {
		this.eccedenza = eccedenza;
	}
	public String getDataRiservaMatematica() {
		return dataRiservaMatematica;
	}
	public void setDataRiservaMatematica(String dataRiservaMatematica) {
		this.dataRiservaMatematica = dataRiservaMatematica;
	}
}