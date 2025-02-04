package com.fideuram.stampe.modello.attori;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by
 * User: logan
 * Date: 04/12/12
 * Time: 11.37
 */

@XmlType(name="SegniParticolari")
public class SegniParticolari implements Serializable{
	private static final long serialVersionUID = 8526060112293643062L;
	private String peso;
    private String altezza;
    private String eta;
    
	public String getEta() {
		return eta;
	}
	public void setEta(String eta) {
		this.eta = eta;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getAltezza() {
		return altezza;
	}
	public void setAltezza(String altezza) {
		this.altezza = altezza;
	}
}