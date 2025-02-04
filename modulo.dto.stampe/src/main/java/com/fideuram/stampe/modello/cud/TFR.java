package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="TFR")
@XmlAccessorType(XmlAccessType.FIELD)
public class TFR {
	 
	private double indAccAntSomAnno; // Indennita', acconti, anticipazioni e somme erogate nell'anno
	private double accAntAnniPrec; // Acconti ed anticipazioni erogati in anni precedenti
	private double detrazione; // Detrazione
	private double ritenutaAnno; // Ritenuta operata nell'anno
	private double ritenuteSosp; // Ritenute sospese
	private double ritenAnniPrec; // Ritenute operate in anni precedenti
	private double ritenAnniPrecSosp; // Ritenute di anni precedenti sospese
	private double indArt2122; // Quota spettante per indennit' erogate ai sensi art. 2122 c.c.
	private double tfrNoPrelMatFi00; // TFR maturato fino al 31/12/2000 e rimasto in azienda
	private double tfrNoPrelMatDa01; // TFR maturato dall' 1/1/2001 e rimasto in azienda
	private double tfrVersMatFi00; // TFR maturato fino al 31/12/2000 e versato al fondo
	private double tfrVersMat01_06; // TFR maturato dall  1/1/2001 al 31/12/2006 e versato al fondo
	private double tfrVersMatDa07; // TFR maturato dall 1/1/2007 e versato al fondo
	
	
	
	public double getIndAccAntSomAnno() {
		return indAccAntSomAnno;
	}
	public void setIndAccAntSomAnno(double indAccAntSomAnno) {
		this.indAccAntSomAnno = indAccAntSomAnno;
	}
	public double getAccAntAnniPrec() {
		return accAntAnniPrec;
	}
	public void setAccAntAnniPrec(double accAntAnniPrec) {
		this.accAntAnniPrec = accAntAnniPrec;
	}
	public double getDetrazione() {
		return detrazione;
	}
	public void setDetrazione(double detrazione) {
		this.detrazione = detrazione;
	}
	public double getRitenutaAnno() {
		return ritenutaAnno;
	}
	public void setRitenutaAnno(double ritenutaAnno) {
		this.ritenutaAnno = ritenutaAnno;
	}
	public double getRitenuteSosp() {
		return ritenuteSosp;
	}
	public void setRitenuteSosp(double ritenuteSosp) {
		this.ritenuteSosp = ritenuteSosp;
	}
	public double getRitenAnniPrec() {
		return ritenAnniPrec;
	}
	public void setRitenAnniPrec(double ritenAnniPrec) {
		this.ritenAnniPrec = ritenAnniPrec;
	}
	public double getRitenAnniPrecSosp() {
		return ritenAnniPrecSosp;
	}
	public void setRitenAnniPrecSosp(double ritenAnniPrecSosp) {
		this.ritenAnniPrecSosp = ritenAnniPrecSosp;
	}
	public double getIndArt2122() {
		return indArt2122;
	}
	public void setIndArt2122(double indArt2122) {
		this.indArt2122 = indArt2122;
	}
	public double getTfrNoPrelMatFi00() {
		return tfrNoPrelMatFi00;
	}
	public void setTfrNoPrelMatFi00(double tfrNoPrelMatFi00) {
		this.tfrNoPrelMatFi00 = tfrNoPrelMatFi00;
	}
	public double getTfrNoPrelMatDa01() {
		return tfrNoPrelMatDa01;
	}
	public void setTfrNoPrelMatDa01(double tfrNoPrelMatDa01) {
		this.tfrNoPrelMatDa01 = tfrNoPrelMatDa01;
	}
	public double getTfrVersMatFi00() {
		return tfrVersMatFi00;
	}
	public void setTfrVersMatFi00(double tfrVersMatFi00) {
		this.tfrVersMatFi00 = tfrVersMatFi00;
	}
	public double getTfrVersMat01_06() {
		return tfrVersMat01_06;
	}
	public void setTfrVersMat01_06(double tfrVersMat01_06) {
		this.tfrVersMat01_06 = tfrVersMat01_06;
	}
	public double getTfrVersMatDa07() {
		return tfrVersMatDa07;
	}
	public void setTfrVersMatDa07(double tfrVersMatDa07) {
		this.tfrVersMatDa07 = tfrVersMatDa07;
	}
	
	
}
