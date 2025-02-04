package com.fideuram.crm.stampe.engine.modello.bean;


/**
 * Date: 23/11/11
 * Time: 9.30
 */
public class Disinvestimento{
	
	/*      DATI DISINVESTIMENTO        */
	private String numeroQuote;
	private String controvaloreQuote;
	private String dataNavDisinvestimento;	
	/* DATI DISINVESTIMENTO DESCRIZIONI  */
	private String descNumeroQuote;
	private String descControvaloreQuote;
	private String descDataNavDisinvestimento;
	
	public String getNumeroQuote() {
		return numeroQuote;
	}
	public void setNumeroQuote(String numeroQuote) {
		this.numeroQuote = numeroQuote;
	}
	public String getControvaloreQuote() {
		return controvaloreQuote;
	}
	public void setControvaloreQuote(String controvaloreQuote) {
		this.controvaloreQuote = controvaloreQuote;
	}
	public String getDataNavDisinvestimento() {
		return dataNavDisinvestimento;
	}
	public void setDataNavDisinvestimento(String dataNavDisinvestimento) {
		this.dataNavDisinvestimento = dataNavDisinvestimento;
	}
	public String getDescNumeroQuote() {
		return descNumeroQuote;
	}
	public void setDescNumeroQuote(String descNumeroQuote) {
		this.descNumeroQuote = descNumeroQuote;
	}
	public String getDescControvaloreQuote() {
		return descControvaloreQuote;
	}
	public void setDescControvaloreQuote(String descControvaloreQuote) {
		this.descControvaloreQuote = descControvaloreQuote;
	}
	public String getDescDataNavDisinvestimento() {
		return descDataNavDisinvestimento;
	}
	public void setDescDataNavDisinvestimento(String descDataNavDisinvestimento) {
		this.descDataNavDisinvestimento = descDataNavDisinvestimento;
	}
}