package com.fideuram.stampe.bean.prestito;

/**
 * Created with
 * User: v801068
 * Date: 09/12/13
 * Time: 14.52
 */
public class Prestito {
    private boolean prestitiErogati;
    private Double importo;
    private Double tasso;
    private Double tassoBase;
    private String fondo;

    public Prestito(boolean prestitiErogati) {
        this.prestitiErogati = prestitiErogati;
    }

    public Prestito(Double importo, Double tasso, Double tassoBase,String fondo) {
        this.importo = importo;
        this.tasso = tasso;
        this.fondo = fondo;
        this.tassoBase=tassoBase;
    }

    public Double getImporto() {
        return importo;
    }

    public Double getTasso() {
        return tasso;
    }

    public Double getTassoBase() {
        return tassoBase;
    }

    public void setTassoBase(Double tassoBase) {
        this.tassoBase = tassoBase;
    }

    public String getFondo() {
        return fondo;
    }

    public boolean hasPrestitiErogati() {
        return prestitiErogati;
    }
}
