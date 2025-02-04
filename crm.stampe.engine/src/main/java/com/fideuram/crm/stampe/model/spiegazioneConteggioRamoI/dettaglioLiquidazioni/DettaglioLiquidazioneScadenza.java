package com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.dettaglioLiquidazioni;

import com.fideuram.factory.FormatterFactory;

public class DettaglioLiquidazioneScadenza extends DettaglioPrestazioneLiquidazione{
	private Double prestazioneTotaleLorda;
	private String coefficenteRiscatto;
	
	public String getPrestazioneTotaleLorda() {
        return FormatterFactory.getStandardImporto(Double.valueOf(prestazioneTotaleLorda));
	}
	public void setPrestazioneTotaleLorda(Double prestazioneTotaleLorda) {
		this.prestazioneTotaleLorda = prestazioneTotaleLorda;
	}
	public String getCoefficenteRiscatto() {
		return coefficenteRiscatto;
	}
	public void setCoefficenteRiscatto(String coefficenteRiscatto) {
		this.coefficenteRiscatto = coefficenteRiscatto;
	}	
}