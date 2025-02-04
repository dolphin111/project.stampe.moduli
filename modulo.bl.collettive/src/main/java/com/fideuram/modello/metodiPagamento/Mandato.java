package com.fideuram.modello.metodiPagamento;

import java.util.Date;

import com.fideuram.factory.FormatterFactory;

public class Mandato {
	
	
	private String numeroProgressivo;
	//indirizzo beneficiario
	private String beneficiario;
	private String indiBen;
	private String capBen;
	private String cittaBen;
	private String provBen;
	//indirizzo destinatario
	private String altroDest;
	private String indiDest;
	private String capDest;
	private String cittaDest;
	private String provDest;
	//banca Iban
	private String banca;
	private String ibanBanca;
	
	private Double importo;
	
	private Date dataValuta;
	
	private Date dataLiquidazione;
	
	
	public String getIbanBanca() {
		String result = ibanBanca;
		if(ibanBanca!=null)
			result = ibanBanca.replace("*", "");
		return result;
	}
	public void setIbanBanca(String ibanBanca) {
		this.ibanBanca = ibanBanca;
	}
	public String getImporto() {
		return FormatterFactory.getStandardImporto(importo);
	}
	public void setImporto(Double importo) {
		this.importo = importo;
	}
	public String getDataValuta() {
		return FormatterFactory.getStandardDate(dataValuta);
	}
	public void setDataValuta(Date dataValuta) {
		this.dataValuta = dataValuta;
	}
	public String getDataLiquidazione() {
		return FormatterFactory.getStandardDate(dataLiquidazione);
	}
	public void setDataLiquidazione(Date dataLiquidazione) {
		this.dataLiquidazione = dataLiquidazione;
	}
	public String getNumeroProgressivo() {
		return numeroProgressivo;
	}
	public void setNumeroProgressivo(String numeroProgressivo) {
		this.numeroProgressivo = numeroProgressivo;
	}
	public String getBeneficiario() {
		return beneficiario;
	}
	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}
	public String getIndiBen() {
		return indiBen;
	}
	public void setIndiBen(String indiBen) {
		this.indiBen = indiBen;
	}
	public String getCapBen() {
		return capBen;
	}
	public void setCapBen(String capBen) {
		this.capBen = capBen;
	}
	public String getCittaBen() {
		return cittaBen;
	}
	public void setCittaBen(String cittaBen) {
		this.cittaBen = cittaBen;
	}
	public String getProvBen() {
		return provBen;
	}
	public void setProvBen(String provBen) {
		this.provBen = provBen;
	}
	public String getAltroDest() {
		return altroDest;
	}
	public void setAltroDest(String altroDest) {
		this.altroDest = altroDest;
	}
	public String getIndiDest() {
		return indiDest;
	}
	public void setIndiDest(String indiDest) {
		this.indiDest = indiDest;
	}
	public String getCapDest() {
		return capDest;
	}
	public void setCapDest(String capDest) {
		this.capDest = capDest;
	}
	public String getCittaDest() {
		return cittaDest;
	}
	public void setCittaDest(String cittaDest) {
		this.cittaDest = cittaDest;
	}
	public String getProvDest() {
		return provDest;
	}
	public void setProvDest(String provDest) {
		this.provDest = provDest;
	}
	public String getBanca() {
		return banca;
	}
	public void setBanca(String banca) {
		this.banca = banca;
	}
	
	@Override
	public String toString() {
		return "Mandato [numeroProgressivo=" + numeroProgressivo
				+ ", beneficiario=" + beneficiario + ", indiBen=" + indiBen
				+ ", capBen=" + capBen + ", cittaBen=" + cittaBen
				+ ", provBen=" + provBen + ", altroDest=" + altroDest
				+ ", indiDest=" + indiDest + ", capDest=" + capDest
				+ ", cittaDest=" + cittaDest + ", provDest=" + provDest
				+ ", banca=" + banca + ", ibanBanca=" + ibanBanca
				+ ", importo=" + importo + ", dataValuta=" + dataValuta
				+ ", dataLiquidazione=" + dataLiquidazione + "]";
	}


}
