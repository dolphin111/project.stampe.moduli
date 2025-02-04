package com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI;

import com.fideuram.factory.FormatterFactory;

public class TipoPratica {
	
	private Double valoreRiscattoLordo;
	private Double valoreRiscattoNetto;
	private Double interessiRitardatoPagamento;
	private String dataLiquidazione;
	private String dataValuta;
	private Double valoreImportoPagato;
	private Double interessiMora;
	private java.util.List<RiepilogoImposte> listRiepilogoImposte;
	
	public String getValoreRiscattoLordo() {
        return FormatterFactory.getStandardImporto(Double.valueOf(valoreRiscattoLordo));
	}
	public void setValoreRiscattoLordo(Double valoreRiscattoLordo) {
		this.valoreRiscattoLordo = valoreRiscattoLordo;
	}
	public String getValoreRiscattoNetto() {
        return FormatterFactory.getStandardImporto(Double.valueOf(valoreRiscattoNetto));
	}
	public void setValoreRiscattoNetto(Double valoreRiscattoNetto) {
		this.valoreRiscattoNetto = valoreRiscattoNetto;
	}
	public String getInteressiRitardatoPagamento() {
        return FormatterFactory.getStandardImporto(Double.valueOf(interessiRitardatoPagamento));
	}
	public void setInteressiRitardatoPagamento(Double interessiRitardatoPagamento) {
		this.interessiRitardatoPagamento = interessiRitardatoPagamento;
	}
	public String getDataLiquidazione() {
		return dataLiquidazione;
	}
	public void setDataLiquidazione(String dataLiquidazione) {
		this.dataLiquidazione = dataLiquidazione;
	}
	public String getDataValuta() {
		return dataValuta;
	}
	public void setDataValuta(String dataValuta) {
		this.dataValuta = dataValuta;
	}
	public String getValoreImportoPagato() {
        return FormatterFactory.getStandardImporto(Double.valueOf(valoreImportoPagato));
	}
	public void setValoreImportoPagato(Double valoreImportoPagato) {
		this.valoreImportoPagato = valoreImportoPagato;
	}
	public String getInteressiMora() {
        return FormatterFactory.getStandardImporto(Double.valueOf(interessiMora));
	}
	public void setInteressiMora(Double interessiMora) {
		this.interessiMora = interessiMora;
	}
	public java.util.List<RiepilogoImposte> getListRiepilogoImposte() {
		return listRiepilogoImposte;
	}
	public void setListRiepilogoImposte(
			java.util.List<RiepilogoImposte> listRiepilogoImposte) {
		this.listRiepilogoImposte = listRiepilogoImposte;
	}
}