package com.fideuram.chart.lab.line.bean;

import com.fideuram.chart.exception.GraphException;

/**
 * Created by  
 * User: logan
 * Date: 06/02/13
 * Time: 11.41
 */
public class PuntoLinea {
    private String data;
    private Double valore;

    public PuntoLinea() {}

    public PuntoLinea(String data, Double valore) throws GraphException{
        if(!validator(data))
            throw new GraphException("data: " + data + "Non Valida");
        this.data = data;
        this.valore = valore;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setValore(Double valore) {
        this.valore = valore;
    }

    public String getData() {
        return data;
    }

    public Double getValore() {
        return valore;
    }

    private boolean validator(String data){

        if(null==data||data.trim().equalsIgnoreCase(""))
            return false;
        else
            //todo processare se la string è una data valida
            return true;
    }
}
