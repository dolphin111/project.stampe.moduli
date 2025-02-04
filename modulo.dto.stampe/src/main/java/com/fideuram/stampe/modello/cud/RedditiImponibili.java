package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="RedditiImponibili")
@XmlAccessorType(XmlAccessType.FIELD)
public class RedditiImponibili {
	 
	private double totRedd; // Totale redditi
	private double totRitIrpef; // Totale ritenute Irpef
	private double totAddRegIrpef; // Totale addizionale regionale all'Irpef
	private double totRitIrpefSosp; // Totale ritenute Irpef sospese
	private double totAddRegIrpefSosp; // Totale addizionale regionale all'Irpef sospesa
	
	
	
	public double getTotRedd() {
		return totRedd;
	}
	public void setTotRedd(double totRedd) {
		this.totRedd = totRedd;
	}
	public double getTotRitIrpef() {
		return totRitIrpef;
	}
	public void setTotRitIrpef(double totRitIrpef) {
		this.totRitIrpef = totRitIrpef;
	}
	public double getTotAddRegIrpef() {
		return totAddRegIrpef;
	}
	public void setTotAddRegIrpef(double totAddRegIrpef) {
		this.totAddRegIrpef = totAddRegIrpef;
	}
	public double getTotRitIrpefSosp() {
		return totRitIrpefSosp;
	}
	public void setTotRitIrpefSosp(double totRitIrpefSosp) {
		this.totRitIrpefSosp = totRitIrpefSosp;
	}
	public double getTotAddRegIrpefSosp() {
		return totAddRegIrpefSosp;
	}
	public void setTotAddRegIrpefSosp(double totAddRegIrpefSosp) {
		this.totAddRegIrpefSosp = totAddRegIrpefSosp;
	}
	
	

}
