package com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI;

import java.util.List;

import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.dettaglioLiquidazioni.DettaglioLiquidazioneSinistro;

public class TipoPraticaSinistro {
	
	private String valoreSinistro;
	private String interessiRitardatoPagamento;
	private String interessiMora;
	//totali tabella
	private String totPrestazione;
	private String totRivalutazione;
	private String totBonus;
	private String totControassicurazione;
	private String totPrestazioneCasoMorte;
	
	private List<DettaglioLiquidazioneSinistro> listDettaglioLiquidazione;

	public String getValoreSinistro() {
		return valoreSinistro;
	}

	public void setValoreSinistro(String valoreSinistro) {
		this.valoreSinistro = valoreSinistro;
	}

	public String getInteressiRitardatoPagamento() {
		return interessiRitardatoPagamento;
	}

	public void setInteressiRitardatoPagamento(String interessiRitardatoPagamento) {
		this.interessiRitardatoPagamento = interessiRitardatoPagamento;
	}

	public String getInteressiMora() {
		return interessiMora;
	}

	public void setInteressiMora(String interessiMora) {
		this.interessiMora = interessiMora;
	}

	public String getTotPrestazione() {
		return totPrestazione;
	}

	public void setTotPrestazione(String totPrestazione) {
		this.totPrestazione = totPrestazione;
	}

	public String getTotRivalutazione() {
		return totRivalutazione;
	}

	public void setTotRivalutazione(String totRivalutazione) {
		this.totRivalutazione = totRivalutazione;
	}

	public String getTotBonus() {
		return totBonus;
	}

	public void setTotBonus(String totBonus) {
		this.totBonus = totBonus;
	}

	public List<DettaglioLiquidazioneSinistro> getListDettaglioLiquidazione() {
		return listDettaglioLiquidazione;
	}

	public void setListDettaglioLiquidazione(
			List<DettaglioLiquidazioneSinistro> listDettaglioLiquidazione) {
		this.listDettaglioLiquidazione = listDettaglioLiquidazione;
	}

	public String getTotControassicurazione() {
		return totControassicurazione;
	}

	public void setTotControassicurazione(String totControassicurazione) {
		this.totControassicurazione = totControassicurazione;
	}

	public String getTotPrestazioneCasoMorte() {
		return totPrestazioneCasoMorte;
	}

	public void setTotPrestazioneCasoMorte(String totPrestazioneCasoMorte) {
		this.totPrestazioneCasoMorte = totPrestazioneCasoMorte;
	}
}