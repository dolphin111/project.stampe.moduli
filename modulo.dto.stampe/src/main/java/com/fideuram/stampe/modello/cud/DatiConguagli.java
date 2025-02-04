package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="DatiConguagli")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatiConguagli {
 
	private double irpefTratSuc28Feb; // Irpef da trattenere dal sostituto successivamente al 28 febbraio
	private double irpefDaVers; // Irpef da versare all'erario da parte del dipendente
	private double totredCong1; // Totale redditi conguagliato già compreso nel punto 1
	private double totredCong2; // Totale redditi conguagliato già compreso nel punto 2
	
	
	
	public double getIrpefTratSuc28Feb() {
		return irpefTratSuc28Feb;
	}
	public void setIrpefTratSuc28Feb(double irpefTratSuc28Feb) {
		this.irpefTratSuc28Feb = irpefTratSuc28Feb;
	}
	public double getIrpefDaVers() {
		return irpefDaVers;
	}
	public void setIrpefDaVers(double irpefDaVers) {
		this.irpefDaVers = irpefDaVers;
	}
	public double getTotredCong1() {
		return totredCong1;
	}
	public void setTotredCong1(double totredCong1) {
		this.totredCong1 = totredCong1;
	}
	public double getTotredCong2() {
		return totredCong2;
	}
	public void setTotredCong2(double totredCong2) {
		this.totredCong2 = totredCong2;
	}
	
	
	
	
}
