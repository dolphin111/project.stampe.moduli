package com.fideuram.chart.grafici.linea.bean;

import com.fideuram.chart.exception.GraphException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with
 * User: logan
 * Date: 11/07/13
 * Time: 10.43
 */
public class Punto {
    private Integer mese;
    private Integer anno;

    private Date    data;
    private Double  valore;


    public Punto(Integer mese, Integer anno, Double valore) {
        this.mese = mese;
        this.anno = anno;
        this.valore = valore;
    }

    public Integer getMese() {
        return mese;
    }

    public Integer getAnno() {
        return anno;
    }

    public Punto(Date   data, Double valore) throws GraphException {
        if(!validator(data))
            throw new GraphException("tag: " + data + "Non Valida");
        this.data = data;
        this.valore = valore;
    }

    public Date getData() {
        return data;
    }

    public Double getValore() {
        return valore;
    }

    private boolean validator(Date data){
        if(null==data)
            return false;
        else
            //todo processare se la string è una tag valida
            return true;
    }

    public String dateToString(){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }

}
