package com.fideuram.chart.grafici.torta.bean;

import com.fideuram.chart.configuration.Colore;

/**
 * Created with
 * User: logan
 * Date: 02/07/13
 * Time: 10.43
 */
public class Fetta {
    private String etichetta;
    private Double valore;
    private Colore colore;

    public Fetta(String etichetta, Double valore) {
        this.etichetta = etichetta;
        this.valore = valore;
    }

    public Fetta(String etichetta, Double valore, Colore colore) {
        this.etichetta = etichetta;
        this.valore = valore;
        this.colore = colore;
    }

    public String getEtichetta() {
        return etichetta;
    }

    public Double getValore() {
        return valore;
    }

    public Colore getColore() {
        return colore;
    }
}
