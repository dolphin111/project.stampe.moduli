package com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI;

import java.util.List;

import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.dettaglioLiquidazioni.DettaglioLiquidazioneRiscatto;
import com.fideuram.factory.FormatterFactory;

public class TipoPraticaRiscatto extends TipoPratica{
	
	
	//totali tabella liquidazione
	private Double totPrestazioneBase;
	private Double totRivalutazione;
	private Double totBonus;
	private Double totRiservaMatematica;
	private Double totCapitaleCasoMorte;
	private Double totValoreDiRiscatto;
	private Double totEccedenza;
	//totali tabella imposte applicate
	private Double totImponibile;
	private Double totImposta;
	
	private List<DettaglioLiquidazioneRiscatto> listDettaglioLiquidazione;

	public String getTotPrestazioneBase() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totPrestazioneBase));
	}

	public void setTotPrestazioneBase(Double totPrestazioneBase) {
		this.totPrestazioneBase = totPrestazioneBase;
	}

	public String getTotRivalutazione() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totRivalutazione));
	}

	public void setTotRivalutazione(Double totRivalutazione) {
		this.totRivalutazione = totRivalutazione;
	}

	public String getTotBonus() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totBonus));
	}

	public void setTotBonus(Double totBonus) {
		this.totBonus = totBonus;
	}

	public String getTotRiservaMatematica() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totRiservaMatematica));
	}

	public void setTotRiservaMatematica(Double totRiservaMatematica) {
		this.totRiservaMatematica = totRiservaMatematica;
	}

	public String getTotCapitaleCasoMorte() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totCapitaleCasoMorte));
	}

	public void setTotCapitaleCasoMorte(Double totCapitaleCasoMorte) {
		this.totCapitaleCasoMorte = totCapitaleCasoMorte;
	}

	public String getTotValoreDiRiscatto() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totValoreDiRiscatto));
	}

	public void setTotValoreDiRiscatto(Double totValoreDiRiscatto) {
		this.totValoreDiRiscatto = totValoreDiRiscatto;
	}

	public String getTotEccedenza() {
        return FormatterFactory.getStandardImporto(Double.valueOf(totEccedenza));
	}

	public void setTotEccedenza(Double totEccedenza) {
		this.totEccedenza = totEccedenza;
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

	public List<DettaglioLiquidazioneRiscatto> getListDettaglioLiquidazione() {
		return listDettaglioLiquidazione;
	}

	public void setListDettaglioLiquidazione(
			List<DettaglioLiquidazioneRiscatto> listDettaglioLiquidazione) {
		this.listDettaglioLiquidazione = listDettaglioLiquidazione;
	}
}