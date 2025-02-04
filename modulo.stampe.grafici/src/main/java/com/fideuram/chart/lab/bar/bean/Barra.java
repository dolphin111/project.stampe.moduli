package com.fideuram.chart.lab.bar.bean;

/**
 * Created by
 * User: logan
 * Date: 04/02/13
 * Time: 11.50
 */
public class Barra {
    String etichetta;
    Double valore;
    String anno;

    public Barra() {}

    public Barra(String etichetta, Double valore, String anno) {
        this.etichetta = etichetta;
        this.valore = valore;
        this.anno = anno;
    }

    public String getEtichetta() {
        return etichetta;
    }

    public void setEtichetta(String etichetta) {
        this.etichetta = etichetta;
    }

    public Double getValore() {
        return valore;
    }

    public void setValore(Double valore) {
        this.valore = valore;
    }

    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }
}
