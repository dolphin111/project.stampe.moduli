package com.fideuram.preventivo.modello;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 04/12/12
 * Time: 12.05
 */
public class DichiarazioneDomandaRisposta implements Serializable {
    private List<String> risposta;
    private List<String> domanda;

    public List<String> getRisposta() {
        return risposta;
    }

    public void setRisposta(List<String> risposta) {
        this.risposta = risposta;
    }

	public List<String> getDomanda() {
		return domanda;
	}

	public void setDomanda(List<String> domanda) {
		this.domanda = domanda;
	}
}
