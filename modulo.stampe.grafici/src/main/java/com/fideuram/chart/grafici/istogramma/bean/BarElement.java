package com.fideuram.chart.grafici.istogramma.bean;

import com.fideuram.chart.configuration.Gruppo;

/**
 * Created with
 * User: logan
 * Date: 02/07/13
 * Time: 12.29
 */
public class BarElement {
    private Gruppo group;
    private Double valore;
    private String anno;    //todo rafactor for rename "anno" into "etichetta"

    public BarElement(Gruppo group, Double valore, String anno) {
        this.group = group;
        this.valore = valore;
        this.anno = anno;
    }

    public Gruppo getGroup() {
        return group;
    }

    public Double getValore() {
        return valore;
    }

    public String getAnno() {
        return anno;
    }
}
