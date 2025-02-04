package com.fideuram.crm.stampe.engine.modello.bean;


/**
 * Date: 23/11/11
 * Time: 9.30
 */
public class Pagamento{
	
	/*      DATI PAGAMENTO        */
	private String importoLordo;
	private String importoNetto;
	private String dataValuta;
	private String modalitaPagamento;
	private String iban;
	private String numeroConto;
	private String beneficiarioLiquidazione;
	/* DATI PAGAMENTO DESCRIZIONI  */
	private String descImportoLordo;
	private String descImportoNetto;
	private String descDataValuta;
	private String descModalitaPagamento;
	private String descIban;
	private String descNumeroConto;
	private String descBeneficiarioLiquidazione;
	
	public String getImportoLordo() {
		return importoLordo;
	}
	public void setImportoLordo(String importoLordo) {
		this.importoLordo = importoLordo;
	}
	public String getImportoNetto() {
		return importoNetto;
	}
	public void setImportoNetto(String importoNetto) {
		this.importoNetto = importoNetto;
	}
	public String getDataValuta() {
		return dataValuta;
	}
	public void setDataValuta(String dataValuta) {
		this.dataValuta = dataValuta;
	}
	public String getModalitaPagamento() {
		return modalitaPagamento;
	}
	public void setModalitaPagamento(String modalitaPagamento) {
		this.modalitaPagamento = modalitaPagamento;
	}
	public String getIban() {
		return iban;
	}
	public void setIban(String iban) {
		this.iban = iban;
	}
	public String getNumeroConto() {
		return numeroConto;
	}
	public void setNumeroConto(String numeroConto) {
		this.numeroConto = numeroConto;
	}
	public String getBeneficiarioLiquidazione() {
		return beneficiarioLiquidazione;
	}
	public void setBeneficiarioLiquidazione(String beneficiarioLiquidazione) {
		this.beneficiarioLiquidazione = beneficiarioLiquidazione;
	}
	public String getDescImportoLordo() {
		return descImportoLordo;
	}
	public void setDescImportoLordo(String descImportoLordo) {
		this.descImportoLordo = descImportoLordo;
	}
	public String getDescImportoNetto() {
		return descImportoNetto;
	}
	public void setDescImportoNetto(String descImportoNetto) {
		this.descImportoNetto = descImportoNetto;
	}
	public String getDescDataValuta() {
		return descDataValuta;
	}
	public void setDescDataValuta(String descDataValuta) {
		this.descDataValuta = descDataValuta;
	}
	public String getDescModalitaPagamento() {
		return descModalitaPagamento;
	}
	public void setDescModalitaPagamento(String descModalitaPagamento) {
		this.descModalitaPagamento = descModalitaPagamento;
	}
	public String getDescIban() {
		return descIban;
	}
	public void setDescIban(String descIban) {
		this.descIban = descIban;
	}
	public String getDescNumeroConto() {
		return descNumeroConto;
	}
	public void setDescNumeroConto(String descNumeroConto) {
		this.descNumeroConto = descNumeroConto;
	}
	public String getDescBeneficiarioLiquidazione() {
		return descBeneficiarioLiquidazione;
	}
	public void setDescBeneficiarioLiquidazione(String descBeneficiarioLiquidazione) {
		this.descBeneficiarioLiquidazione = descBeneficiarioLiquidazione;
	}
}