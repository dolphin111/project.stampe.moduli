package com.fideuram.crm.stampe.engine.modello.bean;


/**
 * Date: 23/11/11
 * Time: 9.30
 */
public class Pratica{
	
	/*      DATI PRATICA        */
	private String numeroPratica;
	private String statoPratica;
	private String tipoPratica;
	private String dataRichiesta;
	private String dataEffetto;
	private String dataPresuntoPagamento;
	private String dataPresuntoDisinvestimento;
	private String servizioDescStPratica;
	private String noteInCalce;
	private String reteVendita;
	/* DATI PRATICA DESCRIZIONI  */
	private String descNumeroPratica;
	private String descStatoPratica;
	private String descTipoPratica;
	private String descDataRichiesta;
	private String descDataEffetto;
	private String descDataPresuntoPagamento;
	private String descNoteInCalce;
	private String descDataPresuntoDisinvestimento;
	private String descServizioDescStPratica;
	//controllo per visualizzare le date
	//1 = data presunto pagamento valorizzato
	//2 = data presunto disinvestimento presente
	//3 = entrambe le date presenti
	//0 nessuna delle due
	private int visualizzatoreDate;
		
	public String getReteVendita() {
		return reteVendita;
	}
	public void setReteVendita(String reteVendita) {
		this.reteVendita = reteVendita;
	}
	public int getVisualizzatoreDate() {
		return visualizzatoreDate;
	}
	public void setVisualizzatoreDate(int visualizzatoreDate) {
		this.visualizzatoreDate = visualizzatoreDate;
	}
	public String getDataPresuntoDisinvestimento() {
		return dataPresuntoDisinvestimento;
	}
	public void setDataPresuntoDisinvestimento(String dataPresuntoDisinvestimento) {
		this.dataPresuntoDisinvestimento = dataPresuntoDisinvestimento;
	}
	public String getServizioDescStPratica() {
		return servizioDescStPratica;
	}
	public void setServizioDescStPratica(String servizioDescStPratica) {
		this.servizioDescStPratica = servizioDescStPratica;
	}
	public String getDescDataPresuntoDisinvestimento() {
		return descDataPresuntoDisinvestimento;
	}
	public void setDescDataPresuntoDisinvestimento(
			String descDataPresuntoDisinvestimento) {
		this.descDataPresuntoDisinvestimento = descDataPresuntoDisinvestimento;
	}
	public String getDescServizioDescStPratica() {
		return descServizioDescStPratica;
	}
	public void setDescServizioDescStPratica(String descServizioDescStPratica) {
		this.descServizioDescStPratica = descServizioDescStPratica;
	}
	public String getNoteInCalce() {
		return noteInCalce;
	}
	public void setNoteInCalce(String noteInCalce) {
		this.noteInCalce = noteInCalce;
	}
	public String getDescNoteInCalce() {
		return descNoteInCalce;
	}
	public void setDescNoteInCalce(String descNoteInCalce) {
		this.descNoteInCalce = descNoteInCalce;
	}
	public String getNumeroPratica() {
		return numeroPratica;
	}
	public void setNumeroPratica(String numeroPratica) {
		this.numeroPratica = numeroPratica;
	}
	public String getStatoPratica() {
		return statoPratica;
	}
	public void setStatoPratica(String statoPratica) {
		this.statoPratica = statoPratica;
	}
	public String getTipoPratica() {
		return tipoPratica;
	}
	public void setTipoPratica(String tipoPratica) {
		this.tipoPratica = tipoPratica;
	}
	public String getDataRichiesta() {
		return dataRichiesta;
	}
	public void setDataRichiesta(String dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}
	public String getDataEffetto() {
		return dataEffetto;
	}
	public void setDataEffetto(String dataEffetto) {
		this.dataEffetto = dataEffetto;
	}
	public String getDataPresuntoPagamento() {
		return dataPresuntoPagamento;
	}
	public void setDataPresuntoPagamento(String dataPresuntoPagamento) {
		this.dataPresuntoPagamento = dataPresuntoPagamento;
	}
	public String getDescNumeroPratica() {
		return descNumeroPratica;
	}
	public void setDescNumeroPratica(String descNumeroPratica) {
		this.descNumeroPratica = descNumeroPratica;
	}
	public String getDescStatoPratica() {
		return descStatoPratica;
	}
	public void setDescStatoPratica(String descStatoPratica) {
		this.descStatoPratica = descStatoPratica;
	}
	public String getDescTipoPratica() {
		return descTipoPratica;
	}
	public void setDescTipoPratica(String descTipoPratica) {
		this.descTipoPratica = descTipoPratica;
	}
	public String getDescDataRichiesta() {
		return descDataRichiesta;
	}
	public void setDescDataRichiesta(String descDataRichiesta) {
		this.descDataRichiesta = descDataRichiesta;
	}
	public String getDescDataEffetto() {
		return descDataEffetto;
	}
	public void setDescDataEffetto(String descDataEffetto) {
		this.descDataEffetto = descDataEffetto;
	}
	public String getDescDataPresuntoPagamento() {
		return descDataPresuntoPagamento;
	}
	public void setDescDataPresuntoPagamento(String descDataPresuntoPagamento) {
		this.descDataPresuntoPagamento = descDataPresuntoPagamento;
	}
}