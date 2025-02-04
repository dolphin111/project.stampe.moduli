package com.fideuram.crm.stampe.engine.modello.bean.accessoripolizza;

/** 
 * Date: 02/05/121
 * Time: 17.20
 */
public class DetraibilitaFiscale{
	private String detraibilita;
	//valori
	private String stato;
	private String dataFineBeneficioFiscale;
	private String note;
	
	//descrizione
	private String descStato;
	private String descDataFineBeneficioFiscale;
	private String descNote;
	
	
	public String getDetraibilita() {
		return detraibilita;
	}
	public void setDetraibilita(String detraibilita) {
		this.detraibilita = detraibilita;
	}
	public String getStato() {
		return stato;
	}
	public void setStato(String stato) {
		this.stato = stato;
	}
	public String getDataFineBeneficioFiscale() {
		return dataFineBeneficioFiscale;
	}
	public void setDataFineBeneficioFiscale(String dataFineBeneficioFiscale) {
		this.dataFineBeneficioFiscale = dataFineBeneficioFiscale;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getDescStato() {
		return descStato;
	}
	public void setDescStato(String descStato) {
		this.descStato = descStato;
	}
	public String getDescDataFineBeneficioFiscale() {
		return descDataFineBeneficioFiscale;
	}
	public void setDescDataFineBeneficioFiscale(String descDataFineBeneficioFiscale) {
		this.descDataFineBeneficioFiscale = descDataFineBeneficioFiscale;
	}
	public String getDescNote() {
		return descNote;
	}
	public void setDescNote(String descNote) {
		this.descNote = descNote;
	}
}