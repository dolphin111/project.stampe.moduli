package com.fideuram.chart.lab;

import com.fideuram.chart.configuration.Colore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 22/02/13
 * Time: 15.06
 */
public class Colori {
    private List<Colore> pantoni;

    private Colore backGroundColor;
    private Colore gridLineColor;

    public void setBackGroundColor(Colore backGroundColor) {this.backGroundColor = backGroundColor;}

    public void setGridLineColor(Colore gridLineColor) {this.gridLineColor = gridLineColor;}

    public void setPantoni(java.util.List<Colore> pantoni) {this.pantoni = pantoni;}

    public Colore getBackGroundColor() {
        if (null==backGroundColor)
            backGroundColor=new Colore(255,255,255);
        return backGroundColor;
    }

    public Colore getGridLineColor() {
        if (null==gridLineColor)
            gridLineColor=new Colore(0, 0, 0);
        return gridLineColor;
    }

    public List<Colore> getPantoni() {
        if(pantoni ==null){
            //aggiungo valori di default
            pantoni =new ArrayList<Colore>();
            pantoni.add(new Colore(80,170,150));
            pantoni.add(new Colore(51,51,51));
        }
        return pantoni;
    }


}
