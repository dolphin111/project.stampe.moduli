package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="SommeIncrementoProduttivita")
@XmlAccessorType(XmlAccessType.FIELD)
public class SommeIncrementoProduttivita {
	 
	private double totRedd13; // Totale redditi 2013
	private double totRit; // Totale ritenute operate
	private double ritSosp; // Ritenute sospese
	private String istruzioni; // Vedere istruzioni
	private double reddNoImp; // Redditi non imponibili art. 51, comma 6 del Tuir
	
	
	
	public double getTotRedd13() {
		return totRedd13;
	}
	public void setTotRedd13(double totRedd13) {
		this.totRedd13 = totRedd13;
	}
	public double getTotRit() {
		return totRit;
	}
	public void setTotRit(double totRit) {
		this.totRit = totRit;
	}
	public double getRitSosp() {
		return ritSosp;
	}
	public void setRitSosp(double ritSosp) {
		this.ritSosp = ritSosp;
	}
	public String getIstruzioni() {
		return istruzioni;
	}
	public void setIstruzioni(String istruzioni) {
		this.istruzioni = istruzioni;
	}
	public double getReddNoImp() {
		return reddNoImp;
	}
	public void setReddNoImp(double reddNoImp) {
		this.reddNoImp = reddNoImp;
	}
	
	
	
	
	
}
