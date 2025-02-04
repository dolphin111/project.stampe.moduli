package com.fideuram.chart.grafici.linea.bean;

import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.grafici.GraficoBase;
import com.fideuram.chart.grafici.istogramma.bean.BarElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 11/07/13
 * Time: 10.42
 */
public class Linea  extends GraficoBase {
    //String intestazione="";
    List<Punto> punti;
    Colore colore;

    public List<Punto> getPunti() {
        return punti;
    }

    public void addPunto(Punto punto){
        if(null==punti)
            punti=new ArrayList<Punto>();
        punti.add(punto);
    }

    public Colore getColore() {
        return colore;
    }

    public void setColore(Colore colore) {
        this.colore = colore;
    }

    /*public String getIntestazione() {
        return intestazione;
    }

    public void setIntestazione(String intestazione) {
        this.intestazione = intestazione;
    }*/
}
