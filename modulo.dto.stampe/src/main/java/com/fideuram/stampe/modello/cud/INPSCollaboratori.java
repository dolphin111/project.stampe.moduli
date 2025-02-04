package com.fideuram.stampe.modello.cud;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="INPSCollaboratori")
@XmlAccessorType(XmlAccessType.FIELD)
public class INPSCollaboratori {
	 
	private double compensi; // Compensi corrisposti al collaboratore
	private double contribDovuti; // Contributi dovuti
	private double contribTrattenuti; // Contributi a carico del collaboratore trattenuti
	private double contribVersati; // Contributi versati
	private char[] mesiDenUniemens; // MESI PER I QUALI e' STATA PRESENTATA LA DENUNCIA Uniemens
	
	
	

	public double getCompensi() {
		return compensi;
	}
	public void setCompensi(double compensi) {
		this.compensi = compensi;
	}
	public double getContribDovuti() {
		return contribDovuti;
	}
	public void setContribDovuti(double contribDovuti) {
		this.contribDovuti = contribDovuti;
	}
	public double getContribTrattenuti() {
		return contribTrattenuti;
	}
	public void setContribTrattenuti(double contribTrattenuti) {
		this.contribTrattenuti = contribTrattenuti;
	}
	public double getContribVersati() {
		return contribVersati;
	}
	public void setContribVersati(double contribVersati) {
		this.contribVersati = contribVersati;
	}
	public char[] getMesiDenUniemens() {
		return mesiDenUniemens;
	}
	public void setMesiDenUniemens(char[] mesiDenUniemens) {
		this.mesiDenUniemens = mesiDenUniemens;
	}

	
	
	
}
