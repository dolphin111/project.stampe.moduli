package com.fideuram.crm.stampe.model;

import java.util.ArrayList;

public class RiscattoParzialeTendenzaBean {
	private String dataValutazione;
	private String riscattoAnticipato;
	private String costo;
	private String prestazione;	
	private String importoUtente;
	private String totaleControvaloreQuoteLiquidate;
	private String totaleQuoteLiquidate;
	
	private Boolean isFondo;
	
	private ArrayList<Fondo> listFondi;
	
	
	public Boolean getIsFondo() {
		return isFondo;
	}
	public void setIsFondo(Boolean isFondo) {
		this.isFondo = isFondo;
	}
	public String getTotaleControvaloreQuoteLiquidate() {
		return totaleControvaloreQuoteLiquidate;
	}
	public void setTotaleControvaloreQuoteLiquidate(
			String totaleControvaloreQuoteLiquidate) {
		this.totaleControvaloreQuoteLiquidate = totaleControvaloreQuoteLiquidate;
	}
	public String getTotaleQuoteLiquidate() {
		return totaleQuoteLiquidate;
	}
	public void setTotaleQuoteLiquidate(String totaleQuoteLiquidate) {
		this.totaleQuoteLiquidate = totaleQuoteLiquidate;
	}
	public ArrayList<Fondo> getListFondi() {
		return listFondi;
	}
	public void setListFondi(ArrayList<Fondo> listFondi) {
		this.listFondi = listFondi;
	}
	public String getImportoUtente() {
		return importoUtente;
	}
	public void setImportoUtente(String importoUtente) {
		this.importoUtente = importoUtente;
	}
	public String getDataValutazione() {
		return dataValutazione;
	}
	public void setDataValutazione(String dataValutazione) {
		this.dataValutazione = dataValutazione;
	}
	public String getRiscattoAnticipato() {
		return riscattoAnticipato;
	}
	public void setRiscattoAnticipato(String riscattoAnticipato) {
		this.riscattoAnticipato = riscattoAnticipato;
	}
	public String getCosto() {
		return costo;
	}
	public void setCosto(String costo) {
		this.costo = costo;
	}public String getPrestazione() {
		return prestazione;
	}
	public void setPrestazione(String prestazione) {
		this.prestazione = prestazione;
	}	
}