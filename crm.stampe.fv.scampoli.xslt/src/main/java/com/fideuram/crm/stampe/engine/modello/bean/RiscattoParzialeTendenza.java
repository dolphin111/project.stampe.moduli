package com.fideuram.crm.stampe.engine.modello.bean;

import java.util.ArrayList;


public class RiscattoParzialeTendenza {
	//RAMO III
	private Boolean isRamoIII;
	private String dataRiferimentoNav;
	private String valoreRiscattoParzialeRichiesto;
	private Boolean fondo;
	private String totaleQuoteLiquidate;
	private String totaleControvaloreQuoteLiquidate;
	//descrizioni
	private String descValoreRiscattoParzialeRichiesto;
	private String descTotaleQuoteLiquidate;
	private String descTotaleControvaloreQuoteLiquidate;
	//lista fondi
	private ArrayList<Fondo> listFondi;
	
	//RAMO I
	private String valoreRiscattoParzialeLordo;
	private String costoOperazione;
	private String valorePrestazioneRiscatto;
	//descrizioni
	private String descValoreRiscattoParzialeLordo;
	private String descCostoOperazione;
	private String descValorePrestazioneRiscatto;
	
	
	public String getTotaleQuoteLiquidate() {
		return totaleQuoteLiquidate;
	}
	public void setTotaleQuoteLiquidate(String totaleQuoteLiquidate) {
		this.totaleQuoteLiquidate = totaleQuoteLiquidate;
	}
	public String getTotaleControvaloreQuoteLiquidate() {
		return totaleControvaloreQuoteLiquidate;
	}
	public void setTotaleControvaloreQuoteLiquidate(
			String totaleControvaloreQuoteLiquidate) {
		this.totaleControvaloreQuoteLiquidate = totaleControvaloreQuoteLiquidate;
	}
	public String getDescTotaleQuoteLiquidate() {
		return descTotaleQuoteLiquidate;
	}
	public void setDescTotaleQuoteLiquidate(String descTotaleQuoteLiquidate) {
		this.descTotaleQuoteLiquidate = descTotaleQuoteLiquidate;
	}
	public String getDescTotaleControvaloreQuoteLiquidate() {
		return descTotaleControvaloreQuoteLiquidate;
	}
	public void setDescTotaleControvaloreQuoteLiquidate(
			String descTotaleControvaloreQuoteLiquidate) {
		this.descTotaleControvaloreQuoteLiquidate = descTotaleControvaloreQuoteLiquidate;
	}
	public Boolean getIsRamoIII() {
		return isRamoIII;
	}
	public void setIsRamoIII(Boolean isRamoIII) {
		this.isRamoIII = isRamoIII;
	}
	public String getDataRiferimentoNav() {
		return dataRiferimentoNav;
	}
	public void setDataRiferimentoNav(String dataRiferimentoNav) {
		this.dataRiferimentoNav = dataRiferimentoNav;
	}
	public String getValoreRiscattoParzialeRichiesto() {
		return valoreRiscattoParzialeRichiesto;
	}
	public void setValoreRiscattoParzialeRichiesto(
			String valoreRiscattoParzialeRichiesto) {
		this.valoreRiscattoParzialeRichiesto = valoreRiscattoParzialeRichiesto;
	}
	public Boolean getFondo() {
		return fondo;
	}
	public void setFondo(Boolean fondo) {
		this.fondo = fondo;
	}
	public String getDescValoreRiscattoParzialeRichiesto() {
		return descValoreRiscattoParzialeRichiesto;
	}
	public void setDescValoreRiscattoParzialeRichiesto(
			String descValoreRiscattoParzialeRichiesto) {
		this.descValoreRiscattoParzialeRichiesto = descValoreRiscattoParzialeRichiesto;
	}
	public ArrayList<Fondo> getListFondi() {
		return listFondi;
	}
	public void setListFondi(ArrayList<Fondo> listFondi) {
		this.listFondi = listFondi;
	}
	public String getValoreRiscattoParzialeLordo() {
		return valoreRiscattoParzialeLordo;
	}
	public void setValoreRiscattoParzialeLordo(String valoreRiscattoParzialeLordo) {
		this.valoreRiscattoParzialeLordo = valoreRiscattoParzialeLordo;
	}
	public String getCostoOperazione() {
		return costoOperazione;
	}
	public void setCostoOperazione(String costoOperazione) {
		this.costoOperazione = costoOperazione;
	}
	public String getValorePrestazioneRiscatto() {
		return valorePrestazioneRiscatto;
	}
	public void setValorePrestazioneRiscatto(String valorePrestazioneRiscatto) {
		this.valorePrestazioneRiscatto = valorePrestazioneRiscatto;
	}
	public String getDescValoreRiscattoParzialeLordo() {
		return descValoreRiscattoParzialeLordo;
	}
	public void setDescValoreRiscattoParzialeLordo(
			String descValoreRiscattoParzialeLordo) {
		this.descValoreRiscattoParzialeLordo = descValoreRiscattoParzialeLordo;
	}
	public String getDescCostoOperazione() {
		return descCostoOperazione;
	}
	public void setDescCostoOperazione(String descCostoOperazione) {
		this.descCostoOperazione = descCostoOperazione;
	}
	public String getDescValorePrestazioneRiscatto() {
		return descValorePrestazioneRiscatto;
	}
	public void setDescValorePrestazioneRiscatto(
			String descValorePrestazioneRiscatto) {
		this.descValorePrestazioneRiscatto = descValorePrestazioneRiscatto;
	}
}