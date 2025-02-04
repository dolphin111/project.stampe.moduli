package com.fideuram.modello.tbd;

import java.io.Serializable;

/**
 * Questa CLasse Rappresenta La quota dei Costi Retrocessi ai Distributori
 * Created by 
 * User: logan
 * Date: 28/06/12
 * Time: 10.24
 */
public class CostoRetrocesso implements Serializable {
    private String descrizioneCosto; //Commissione di gestione (Fondo Interno)
    private Float  percentuale;      //82,69%

    public String getDescrizioneCosto() {
        return descrizioneCosto;
    }

    public void setDescrizioneCosto(String descrizioneCosto) {
        this.descrizioneCosto = descrizioneCosto;
    }

    public Float getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(Float percentuale) {
        this.percentuale = percentuale;
    }

    public CostoRetrocesso(String descrizioneCosto, Float percentuale) {
        this.descrizioneCosto = descrizioneCosto;
        this.percentuale = percentuale;
    }
}
