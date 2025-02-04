package com.fideuram.preventivo.modello;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

/**
 * Created by
 * User: logan
 * Date: 04/12/12
 * Time: 11.43
 */
@XmlType(name="Questionario")
public class Questionario implements Serializable {
      private Integer indice;
      private String domanda;
      private String risposta;
   

    public Integer getIndice() {
		return indice;
	}

	public void setIndice(Integer indice) {
		this.indice = indice;
	}

	public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }
}
