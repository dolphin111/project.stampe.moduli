package com.fideuram.crm.stampe.model;

public class Fondo {

	private String fondoInternoOicr;
	private String quote;
	private String valoreQuota;
	private String controvaloreQuoteLiquidate;
	//campi aggiunti per il riscatto parziale puntuale
	private String quotePresenti;
	private String quoteResidue;
	
	
	public String getQuotePresenti() {
		return quotePresenti;
	}
	public void setQuotePresenti(String quotePresenti) {
		this.quotePresenti = quotePresenti;
	}
	public String getQuoteResidue() {
		return quoteResidue;
	}
	public void setQuoteResidue(String quoteResidue) {
		this.quoteResidue = quoteResidue;
	}
	public String getFondoInternoOicr() {
		return fondoInternoOicr;
	}
	public void setFondoInternoOicr(String fondoInternoOicr) {
		this.fondoInternoOicr = fondoInternoOicr;
	}
	public String getQuote() {
		return quote;
	}
	public void setQuote(String quote) {
		this.quote = quote;
	}
	public String getValoreQuota() {
		return valoreQuota;
	}
	public void setValoreQuota(String valoreQuota) {
		this.valoreQuota = valoreQuota;
	}
	public String getControvaloreQuoteLiquidate() {
		return controvaloreQuoteLiquidate;
	}
	public void setControvaloreQuoteLiquidate(String controvaloreQuoteLiquidate) {
		this.controvaloreQuoteLiquidate = controvaloreQuoteLiquidate;
	}	
}