package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="CompensiAnniPrecedenti")
@XmlAccessorType(XmlAccessType.FIELD)
public class CompensiAnniPrecedenti {
	 
	private double totCompArrDetr; // Totale compensi arretrati per i quali è possibile fruire delle detrazioni
	private double totCompArrNoDetr; // Totale compensi arretrati per i quali non e' possibile fruire delle detrazioni
	private double totRitOper; // Totale ritenute operate
	private double totRitSosp; // Totale ritenute sospese
	
	
	
	public double getTotCompArrDetr() {
		return totCompArrDetr;
	}
	public void setTotCompArrDetr(double totCompArrDetr) {
		this.totCompArrDetr = totCompArrDetr;
	}
	public double getTotCompArrNoDetr() {
		return totCompArrNoDetr;
	}
	public void setTotCompArrNoDetr(double totCompArrNoDetr) {
		this.totCompArrNoDetr = totCompArrNoDetr;
	}
	public double getTotRitOper() {
		return totRitOper;
	}
	public void setTotRitOper(double totRitOper) {
		this.totRitOper = totRitOper;
	}
	public double getTotRitSosp() {
		return totRitSosp;
	}
	public void setTotRitSosp(double totRitSosp) {
		this.totRitSosp = totRitSosp;
	}
	


}
