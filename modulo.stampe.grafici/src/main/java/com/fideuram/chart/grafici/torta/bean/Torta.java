package com.fideuram.chart.grafici.torta.bean;

import com.fideuram.chart.grafici.GraficoBase;
import com.fideuram.chart.lab.PanelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 02/07/13
 * Time: 10.42
 */
public class Torta extends GraficoBase {

    private List<Fetta> fettas;


    public List<Fetta> getFettas() {
        return fettas;
    }

    public void setFettas(List<Fetta> fettas) {
        this.fettas = fettas;
    }

    public void addFettas(Fetta fetta){
        if(null==fettas)
            fettas=new ArrayList<Fetta>();
        fettas.add(fetta);
    }


}
