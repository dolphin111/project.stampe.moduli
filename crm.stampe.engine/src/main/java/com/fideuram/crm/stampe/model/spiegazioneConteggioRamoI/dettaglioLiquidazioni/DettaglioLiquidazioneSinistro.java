package com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.dettaglioLiquidazioni;

public class DettaglioLiquidazioneSinistro extends DettaglioPrestazioneLiquidazione{
	private String controAssicurazione;
	private String prestazioneCasoMorte;
	private String annualita;
	
	public String getControAssicurazione() {
		return controAssicurazione;
	}
	public void setControAssicurazione(String controAssicurazione) {
		this.controAssicurazione = controAssicurazione;
	}
	public String getPrestazioneCasoMorte() {
		return prestazioneCasoMorte;
	}
	public void setPrestazioneCasoMorte(String prestazioneCasoMorte) {
		this.prestazioneCasoMorte = prestazioneCasoMorte;
	}
	public String getAnnualita() {
		return annualita;
	}
	public void setAnnualita(String annualita) {
		this.annualita = annualita;
	}
}