package com.fideuram.stampe.modello.cud;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="INPSDipPubblici")
@XmlAccessorType(XmlAccessType.FIELD)
public class INPSDipPubblici {
	 
	private String codFisAmm; // Codice fiscale Amministrazione
	private String progAzienda; // Progressivo Azienda
	private String codSPT_MEF; // Codice identificativo attribuito da SPT del MEF
	
	// Gestione
	private double gestPens; // Pens.
	private double gestPrev; // Prev.
	private double GestCredEndep; // Cred.Endep
	private double GestCredEnam; // Cred. Enam
	
	private String annoRif ; // Anno di riferimento
	private double totImpPens; // Totale imponibile pensionistico
	private double totContribPens; // Totale contributi pensionistici
	private double totImpTFS; // Totale imponibili TFS
	private double totContribTFS; // Totale contributi TFS
	private double totImpTFR; // Totale imponibile TFR
	private double totContribTFR; // Totale contributi TFR
	private double totImpGestCred; // Totale imponibile Gestione Credito
	private double totContribGestCred; // Totale contributo Gestione Credito
	private double totImpENPDEP_ENAM; // Totale imponibile ENPDEP/ENAM
	private double totContribENPDEP_ENAM; // Totale contributi ENPDEP/ENAM
	
	
	
	
	public String getCodFisAmm() {
		return codFisAmm;
	}
	public void setCodFisAmm(String codFisAmm) {
		this.codFisAmm = codFisAmm;
	}
	public String getProgAzienda() {
		return progAzienda;
	}
	public void setProgAzienda(String progAzienda) {
		this.progAzienda = progAzienda;
	}
	public String getCodSPT_MEF() {
		return codSPT_MEF;
	}
	public void setCodSPT_MEF(String codSPT_MEF) {
		this.codSPT_MEF = codSPT_MEF;
	}
	public double getGestPens() {
		return gestPens;
	}
	public void setGestPens(double gestPens) {
		this.gestPens = gestPens;
	}
	public double getGestPrev() {
		return gestPrev;
	}
	public void setGestPrev(double gestPrev) {
		this.gestPrev = gestPrev;
	}
	public double getGestCredEndep() {
		return GestCredEndep;
	}
	public void setGestCredEndep(double gestCredEndep) {
		GestCredEndep = gestCredEndep;
	}
	public double getGestCredEnam() {
		return GestCredEnam;
	}
	public void setGestCredEnam(double gestCredEnam) {
		GestCredEnam = gestCredEnam;
	}
	public String getAnnoRif() {
		return annoRif;
	}
	public void setAnnoRif(String annoRif) {
		this.annoRif = annoRif;
	}
	public double getTotImpPens() {
		return totImpPens;
	}
	public void setTotImpPens(double totImpPens) {
		this.totImpPens = totImpPens;
	}
	public double getTotContribPens() {
		return totContribPens;
	}
	public void setTotContribPens(double totContribPens) {
		this.totContribPens = totContribPens;
	}
	public double getTotImpTFS() {
		return totImpTFS;
	}
	public void setTotImpTFS(double totImpTFS) {
		this.totImpTFS = totImpTFS;
	}
	public double getTotContribTFS() {
		return totContribTFS;
	}
	public void setTotContribTFS(double totContribTFS) {
		this.totContribTFS = totContribTFS;
	}
	public double getTotImpTFR() {
		return totImpTFR;
	}
	public void setTotImpTFR(double totImpTFR) {
		this.totImpTFR = totImpTFR;
	}
	public double getTotContribTFR() {
		return totContribTFR;
	}
	public void setTotContribTFR(double totContribTFR) {
		this.totContribTFR = totContribTFR;
	}
	public double getTotImpGestCred() {
		return totImpGestCred;
	}
	public void setTotImpGestCred(double totImpGestCred) {
		this.totImpGestCred = totImpGestCred;
	}
	public double getTotContribGestCred() {
		return totContribGestCred;
	}
	public void setTotContribGestCred(double totContribGestCred) {
		this.totContribGestCred = totContribGestCred;
	}
	public double getTotImpENPDEP_ENAM() {
		return totImpENPDEP_ENAM;
	}
	public void setTotImpENPDEP_ENAM(double totImpENPDEP_ENAM) {
		this.totImpENPDEP_ENAM = totImpENPDEP_ENAM;
	}
	public double getTotContribENPDEP_ENAM() {
		return totContribENPDEP_ENAM;
	}
	public void setTotContribENPDEP_ENAM(double totContribENPDEP_ENAM) {
		this.totContribENPDEP_ENAM = totContribENPDEP_ENAM;
	}
	
	
	
}
