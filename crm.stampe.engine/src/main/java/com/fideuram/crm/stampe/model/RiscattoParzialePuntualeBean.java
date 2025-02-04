package com.fideuram.crm.stampe.model;

import java.util.ArrayList;


public class RiscattoParzialePuntualeBean {

	private ArrayList<Fondo> listFondi;	
	private ArrayList<Fondo> listFondiInput;
	
	private Boolean isFondo;
	
	private String totaleQuotePresenti;
	private String totaleQuoteLiquidate;
	private String totaleControvaloreQuoteLiquidate;
	private String totaleQuoteResidue;
	
	
	public Boolean getIsFondo() {
		return isFondo;
	}
	public void setIsFondo(Boolean isFondo) {
		this.isFondo = isFondo;
	}
	public ArrayList<Fondo> getListFondi() {
		return listFondi;
	}
	public void setListFondi(ArrayList<Fondo> listFondi) {
		this.listFondi = listFondi;
	}
	public ArrayList<Fondo> getListFondiInput() {
		return listFondiInput;
	}
	public void setListFondiInput(ArrayList<Fondo> listFondiInput) {
		this.listFondiInput = listFondiInput;
	}
	public String getTotaleQuotePresenti() {
		return totaleQuotePresenti;
	}
	public void setTotaleQuotePresenti(String totaleQuotePresenti) {
		this.totaleQuotePresenti = totaleQuotePresenti;
	}
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
	public String getTotaleQuoteResidue() {
		return totaleQuoteResidue;
	}
	public void setTotaleQuoteResidue(String totaleQuoteResidue) {
		this.totaleQuoteResidue = totaleQuoteResidue;
	}
}