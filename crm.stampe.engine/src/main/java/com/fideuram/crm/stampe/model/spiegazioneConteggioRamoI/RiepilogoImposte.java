package com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI;

import com.fideuram.factory.FormatterFactory;

public class RiepilogoImposte {
	private String descrizioneImposte;
	private Double imponibile;
	private String aliquota;
	private Double imposta;
	
	public String getDescrizioneImposte() {
		return descrizioneImposte;
	}
	public void setDescrizioneImposte(String descrizioneImposte) {
		this.descrizioneImposte = descrizioneImposte;
	}
	public String getImponibile() {
        return FormatterFactory.getStandardImporto(Double.valueOf(imponibile));
	}
	public void setImponibile(Double imponibile) {
		this.imponibile = imponibile;
	}
	public String getAliquota() {
		return aliquota;
	}
	public void setAliquota(String aliquota) {
		this.aliquota = aliquota;
	}
	public String getImposta() {
        return FormatterFactory.getStandardImporto(Double.valueOf(imposta));
	}
	public void setImposta(Double imposta) {
		this.imposta = imposta;
	}
}