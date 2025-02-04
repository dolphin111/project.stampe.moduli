package com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI;

import java.util.List;

import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.dettaglioLiquidazioni.DettaglioLiquidazioneScadenza;
import com.fideuram.factory.FormatterFactory;


public class TipoPraticaScadenza extends TipoPratica{
	//totali liquidazione
	private Double totPrestazioneBase;
	private Double totRivalutazioni;
	private Double totBonus;
	private Double totPrestazioneTotaleLorda;
	
	//totali imposte applicate
	private Double totImponibile;
	private Double totImposta;
	
	private List<DettaglioLiquidazioneScadenza> listDettaglioLiquidazione;

	public String getTotPrestazioneBase() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totPrestazioneBase));
	}

	public void setTotPrestazioneBase(Double totPrestazioneBase) {
		this.totPrestazioneBase = totPrestazioneBase;
	}

	public String getTotRivalutazioni() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totRivalutazioni));
	}

	public void setTotRivalutazioni(Double totRivalutazioni) {
		this.totRivalutazioni = totRivalutazioni;
	}

	public String getTotBonus() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totBonus));
	}

	public void setTotBonus(Double totBonus) {
		this.totBonus = totBonus;
	}

	public String getTotPrestazioneTotaleLorda() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totPrestazioneTotaleLorda));
	}

	public void setTotPrestazioneTotaleLorda(Double totPrestazioneTotaleLorda) {
		this.totPrestazioneTotaleLorda = totPrestazioneTotaleLorda;
	}

	public String getTotImponibile() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totImponibile));
	}

	public void setTotImponibile(Double totImponibile) {
		this.totImponibile = totImponibile;
	}

	public String getTotImposta() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totImposta));
	}

	public void setTotImposta(Double totImposta) {
		this.totImposta = totImposta;
	}

	public List<DettaglioLiquidazioneScadenza> getListDettaglioLiquidazione() {
		return listDettaglioLiquidazione;
	}

	public void setListDettaglioLiquidazione(
			List<DettaglioLiquidazioneScadenza> listDettaglioLiquidazione) {
		this.listDettaglioLiquidazione = listDettaglioLiquidazione;
	}	
}