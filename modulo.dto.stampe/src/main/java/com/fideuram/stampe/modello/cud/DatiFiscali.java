package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DatiFiscali")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatiFiscali {
 
	//Redditi per i quali e' possibile fruire della detrazione di cui all'art. 13
	private double redditi1234Tuir; // commi 1, 2, 3 e 4 del Tuir
	private double redditi5_5bisTuir; // commi 5 e 5-bis del Tuir
	
	// Numero di giorni per i quali spettano le detrazioni di cui all'art. 13, commi 1, 2, 3 e 4 del Tuir
	private String giorni1234TuirLavDip; // Lavoro dipendente
	private String giorni1234TuirPensione; // Pensione
	
	private double ritenutaIrpef;
	
	//Addizionale regionale all'Irpef
	private double addRegIrpef;
	
	//Addizionale comunale all'Irpef
	private double addComIrpefAccPrec; // Acconto anno precedente
	private double addComIrpefAccCorr; // Acconto anno corrente
	private double addComIrpefSaldoPrec; // Saldo anno precedente
	
	private double ritenIrpefSosp; // Ritenute Irpef sospese
	private double addRegIrpefSosp; //Addizionale regionale all'Irpef sospesa

	//Addizionale comunale all'Irpef sospesa
	private double addComIrpefSospAccPrec; // Acconto anno precedente
	private double addComIrpefSospSaldoPrec; // Saldo anno precedente
	
	private double primAccIrpefTrat; //Primo acconto Irpef trattenuto nell'anno
	private double sec_unicAccIrpefTrat; // Secondo o unico acconto Irpef trattenuto nell'anno
	private double accIrpefSosp; // Acconti Irpef sospesi
	private double accAddComIrpef; // Acconto addizionale comunale all'Irpef
	private double accAddComIrpefSosp; // Acconto addizionale comunale all'Irpef sospeso
	private double primRataAccCedSec; // Prima rata di acconto cedolare secca
	private double sec_unicRataAccCedSec; // Seconda o unica rata di acconto cedolare secca
	private double accCedSecSosp; // Acconti cedolare secca sospesi
	private double credIrpefNoRimb; // Credito Irpef non rimborsato
	private double credAddRegIrpefNoRimb; // Credito di addizionale regionale all'Irpef non rimborsato
	private double credAddComIrpefNoRimb; // Credito di addizionale comunale all'Irpef non rimborsato
	private double credCedSecNoRimb; // Credito cedolare secca non rimborsato
	
	
	
	public double getRedditi1234Tuir() {
		return redditi1234Tuir;
	}
	public void setRedditi1234Tuir(double redditi1234Tuir) {
		this.redditi1234Tuir = redditi1234Tuir;
	}
	public double getRedditi5_5bisTuir() {
		return redditi5_5bisTuir;
	}
	public void setRedditi5_5bisTuir(double redditi5_5bisTuir) {
		this.redditi5_5bisTuir = redditi5_5bisTuir;
	}
	public String getGiorni1234TuirLavDip() {
		return giorni1234TuirLavDip;
	}
	public void setGiorni1234TuirLavDip(String giorni1234TuirLavDip) {
		this.giorni1234TuirLavDip = giorni1234TuirLavDip;
	}
	public String getGiorni1234TuirPensione() {
		return giorni1234TuirPensione;
	}
	public void setGiorni1234TuirPensione(String giorni1234TuirPensione) {
		this.giorni1234TuirPensione = giorni1234TuirPensione;
	}
	public double getRitenutaIrpef() {
		return ritenutaIrpef;
	}
	public void setRitenutaIrpef(double ritenutaIrpef) {
		this.ritenutaIrpef = ritenutaIrpef;
	}
	public double getAddRegIrpef() {
		return addRegIrpef;
	}
	public void setAddRegIrpef(double addRegIrpef) {
		this.addRegIrpef = addRegIrpef;
	}
	public double getAddComIrpefAccPrec() {
		return addComIrpefAccPrec;
	}
	public void setAddComIrpefAccPrec(double addComIrpefAccPrec) {
		this.addComIrpefAccPrec = addComIrpefAccPrec;
	}
	public double getAddComIrpefAccCorr() {
		return addComIrpefAccCorr;
	}
	public void setAddComIrpefAccCorr(double addComIrpefAccCorr) {
		this.addComIrpefAccCorr = addComIrpefAccCorr;
	}
	public double getAddComIrpefSaldoPrec() {
		return addComIrpefSaldoPrec;
	}
	public void setAddComIrpefSaldoPrec(double addComIrpefSaldoPrec) {
		this.addComIrpefSaldoPrec = addComIrpefSaldoPrec;
	}
	public double getRitenIrpefSosp() {
		return ritenIrpefSosp;
	}
	public void setRitenIrpefSosp(double ritenIrpefSosp) {
		this.ritenIrpefSosp = ritenIrpefSosp;
	}
	public double getAddRegIrpefSosp() {
		return addRegIrpefSosp;
	}
	public void setAddRegIrpefSosp(double addRegIrpefSosp) {
		this.addRegIrpefSosp = addRegIrpefSosp;
	}
	public double getAddComIrpefSospAccPrec() {
		return addComIrpefSospAccPrec;
	}
	public void setAddComIrpefSospAccPrec(double addComIrpefSospAccPrec) {
		this.addComIrpefSospAccPrec = addComIrpefSospAccPrec;
	}
	public double getAddComIrpefSospSaldoPrec() {
		return addComIrpefSospSaldoPrec;
	}
	public void setAddComIrpefSospSaldoPrec(double addComIrpefSospSaldoPrec) {
		this.addComIrpefSospSaldoPrec = addComIrpefSospSaldoPrec;
	}
	public double getPrimAccIrpefTrat() {
		return primAccIrpefTrat;
	}
	public void setPrimAccIrpefTrat(double primAccIrpefTrat) {
		this.primAccIrpefTrat = primAccIrpefTrat;
	}
	public double getSec_unicAccIrpefTrat() {
		return sec_unicAccIrpefTrat;
	}
	public void setSec_unicAccIrpefTrat(double sec_unicAccIrpefTrat) {
		this.sec_unicAccIrpefTrat = sec_unicAccIrpefTrat;
	}
	public double getAccIrpefSosp() {
		return accIrpefSosp;
	}
	public void setAccIrpefSosp(double accIrpefSosp) {
		this.accIrpefSosp = accIrpefSosp;
	}
	public double getAccAddComIrpef() {
		return accAddComIrpef;
	}
	public void setAccAddComIrpef(double accAddComIrpef) {
		this.accAddComIrpef = accAddComIrpef;
	}
	public double getAccAddComIrpefSosp() {
		return accAddComIrpefSosp;
	}
	public void setAccAddComIrpefSosp(double accAddComIrpefSosp) {
		this.accAddComIrpefSosp = accAddComIrpefSosp;
	}
	public double getPrimRataAccCedSec() {
		return primRataAccCedSec;
	}
	public void setPrimRataAccCedSec(double primRataAccCedSec) {
		this.primRataAccCedSec = primRataAccCedSec;
	}
	public double getSec_unicRataAccCedSec() {
		return sec_unicRataAccCedSec;
	}
	public void setSec_unicRataAccCedSec(double sec_unicRataAccCedSec) {
		this.sec_unicRataAccCedSec = sec_unicRataAccCedSec;
	}
	public double getAccCedSecSosp() {
		return accCedSecSosp;
	}
	public void setAccCedSecSosp(double accCedSecSosp) {
		this.accCedSecSosp = accCedSecSosp;
	}
	public double getCredIrpefNoRimb() {
		return credIrpefNoRimb;
	}
	public void setCredIrpefNoRimb(double credIrpefNoRimb) {
		this.credIrpefNoRimb = credIrpefNoRimb;
	}
	public double getCredAddRegIrpefNoRimb() {
		return credAddRegIrpefNoRimb;
	}
	public void setCredAddRegIrpefNoRimb(double credAddRegIrpefNoRimb) {
		this.credAddRegIrpefNoRimb = credAddRegIrpefNoRimb;
	}
	public double getCredAddComIrpefNoRimb() {
		return credAddComIrpefNoRimb;
	}
	public void setCredAddComIrpefNoRimb(double credAddComIrpefNoRimb) {
		this.credAddComIrpefNoRimb = credAddComIrpefNoRimb;
	}
	public double getCredCedSecNoRimb() {
		return credCedSecNoRimb;
	}
	public void setCredCedSecNoRimb(double credCedSecNoRimb) {
		this.credCedSecNoRimb = credCedSecNoRimb;
	}

	
	
}
