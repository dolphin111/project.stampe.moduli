package com.fideuram.preventivo.modello;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 04/12/12
 * Time: 12.05
 */
public class Dichiarazione implements Serializable {
    private List<String> risposta;

    public List<String> getRisposta() {
        return risposta;
    }

    public void setRisposta(List<String> risposta) {
        this.risposta = risposta;
    }
}
