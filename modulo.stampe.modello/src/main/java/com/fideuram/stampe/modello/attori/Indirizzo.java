package com.fideuram.stampe.modello.attori;


import java.io.Serializable;

/**
 * Date: 02/05/121
 * Time: 17.20
 */
public class Indirizzo implements Serializable {
	private static final long serialVersionUID = -6414920111919111841L;
	private String indirizzoContratto;
	//valori
    private String tipoIndirizzo;
    private String indirizzo;
    private String cap;
    private String comune;
    private String provincia;
    private String regione;
    private String nazione;
    private String dataAggiornamento;    
    //descrizioni
    private String descTipoIndirizzo;
    private String descIndirizzo;
    private String descCap;
    private String descComune;
    private String descProvincia;
    private String descRegione;
    private String descNazione;
    private String descDataAggiornamento;
    
    
	public String getIndirizzoContratto() {
		return indirizzoContratto;
	}
	public void setIndirizzoContratto(String indirizzoContratto) {
		this.indirizzoContratto = indirizzoContratto;
	}
	public String getTipoIndirizzo() {
		return tipoIndirizzo;
	}
	public void setTipoIndirizzo(String tipoIndirizzo) {
		this.tipoIndirizzo = tipoIndirizzo;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public String getCap() {
		return cap;
	}
	public void setCap(String cap) {
		this.cap = cap;
	}
	public String getComune() {
		return comune;
	}
	public void setComune(String comune) {
		this.comune = comune;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getRegione() {
		return regione;
	}
	public void setRegione(String regione) {
		this.regione = regione;
	}
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	public String getDataAggiornamento() {
		return dataAggiornamento;
	}
	public void setDataAggiornamento(String dataAggiornamento) {
		this.dataAggiornamento = dataAggiornamento;
	}
	public String getDescTipoIndirizzo() {
		return descTipoIndirizzo;
	}
	public void setDescTipoIndirizzo(String descTipoIndirizzo) {
		this.descTipoIndirizzo = descTipoIndirizzo;
	}
	public String getDescIndirizzo() {
		return descIndirizzo;
	}
	public void setDescIndirizzo(String descIndirizzo) {
		this.descIndirizzo = descIndirizzo;
	}
	public String getDescCap() {
		return descCap;
	}
	public void setDescCap(String descCap) {
		this.descCap = descCap;
	}
	public String getDescComune() {
		return descComune;
	}
	public void setDescComune(String descComune) {
		this.descComune = descComune;
	}
	public String getDescProvincia() {
		return descProvincia;
	}
	public void setDescProvincia(String descProvincia) {
		this.descProvincia = descProvincia;
	}
	public String getDescRegione() {
		return descRegione;
	}
	public void setDescRegione(String descRegione) {
		this.descRegione = descRegione;
	}
	public String getDescNazione() {
		return descNazione;
	}
	public void setDescNazione(String descNazione) {
		this.descNazione = descNazione;
	}
	public String getDescDataAggiornamento() {
		return descDataAggiornamento;
	}
	public void setDescDataAggiornamento(String descDataAggiornamento) {
		this.descDataAggiornamento = descDataAggiornamento;
	}   
}