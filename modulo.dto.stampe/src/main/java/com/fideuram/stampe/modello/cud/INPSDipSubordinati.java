package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="INPSDipSubordinati")
@XmlAccessorType(XmlAccessType.FIELD)
public class INPSDipSubordinati {
	 
	private String matrAzienda; // Matricola azienda
	private String inps; // INPS
	private String altro; // Altro
	private double imponPrevid; // Imponibile previdenziale
	private double imponIVS; // Imponibile ai fini IVS
	private double contribLavTratt; // Contributi a carico del lavoratore trattenuti
	private char[] mesiDenUniemens; // MESI PER I QUALI 'STATA PRESENTATA LA DENUNCIA Uniemens
	
	
	
	public String getMatrAzienda() {
		return matrAzienda;
	}
	public void setMatrAzienda(String matrAzienda) {
		this.matrAzienda = matrAzienda;
	}
	public String getInps() {
		return inps;
	}
	public void setInps(String inps) {
		this.inps = inps;
	}
	public String getAltro() {
		return altro;
	}
	public void setAltro(String altro) {
		this.altro = altro;
	}
	public double getImponPrevid() {
		return imponPrevid;
	}
	public void setImponPrevid(double imponPrevid) {
		this.imponPrevid = imponPrevid;
	}
	public double getImponIVS() {
		return imponIVS;
	}
	public void setImponIVS(double imponIVS) {
		this.imponIVS = imponIVS;
	}
	public double getContribLavTratt() {
		return contribLavTratt;
	}
	public void setContribLavTratt(double contribLavTratt) {
		this.contribLavTratt = contribLavTratt;
	}
	public char[] getMesiDenUniemens() {
		return mesiDenUniemens;
	}
	public void setMesiDenUniemens(char[] mesiDenUniemens) {
		this.mesiDenUniemens = mesiDenUniemens;
	}

	
	
}
