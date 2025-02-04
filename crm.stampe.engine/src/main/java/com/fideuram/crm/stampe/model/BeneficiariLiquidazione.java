package com.fideuram.crm.stampe.model;

public class BeneficiariLiquidazione {
	
	private String beneficiario;
	private String percentualeLiquidazione;
	private String liquidazioneSpettante;



	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	public String getPercentualeLiquidazione() {
		return percentualeLiquidazione;
	}
	public void setPercentualeLiquidazione(String percentualeLiquidazione) {
		this.percentualeLiquidazione = percentualeLiquidazione;
	}
	public String getLiquidazioneSpettante() {
		return liquidazioneSpettante;
	}
	public void setLiquidazioneSpettante(String liquidazioneSpettante) {
		this.liquidazioneSpettante = liquidazioneSpettante;
	}
}