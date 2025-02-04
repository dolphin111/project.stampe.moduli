package com.fideuram.modello.elenchiufficiali.ramo;

public class Importi {

	private String text;
	private Double importo;
	
	public Importi(String t, Double i){
		this.text = t;
		this.importo = i;
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Double getImporto() {
		return importo;
	}
	public void setImporto(Double importo) {
		this.importo = importo;
	}

	@Override
	public String toString() {
		return "Importi [text=" + text + ", importo=" + importo
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
	
}
