package com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.dettaglioLiquidazioni;

public class DettaglioPrestazioneLiquidazione {
	private String tariffa;
	private String prestazione;
	private String rivalutazione;
	private String bonus;
	private String numeroAppendice;
	
	public String getNumeroAppendice() {
		return numeroAppendice;
	}
	public void setNumeroAppendice(String numeroAppendice) {
		this.numeroAppendice = numeroAppendice;
	}
	public String getTariffa() {
		return tariffa;
	}
	public void setTariffa(String tariffa) {
		this.tariffa = tariffa;
	}
	public String getPrestazione() {
		return prestazione;
	}
	public void setPrestazione(String prestazione) {
		this.prestazione = prestazione;
	}
	public String getRivalutazione() {
		return rivalutazione;
	}
	public void setRivalutazione(String rivalutazione) {
		this.rivalutazione = rivalutazione;
	}
	public String getBonus() {
		return bonus;
	}
	public void setBonus(String bonus) {
		this.bonus = bonus;
	}	
}