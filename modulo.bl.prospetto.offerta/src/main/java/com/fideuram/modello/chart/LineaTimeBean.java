package com.fideuram.modello.chart;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.Categoria;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;
import com.fideuram.utils.LoggingUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 
 * User: logan
 * Date: 12/06/12
 * Time: 10.43
 */
public class LineaTimeBean extends Linee implements Serializable {

    private String nome;
    private String header="";
    private boolean hasOicr=false;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void addLinea(String[] date, Number[] valori, String datoRappresentato,boolean isOicr){
       if(isOicr)
           hasOicr=true;
       if(lineas==null)
           lineas=new ArrayList<Linea>();
        List<PuntoLinea> puntoLineas=new ArrayList<PuntoLinea>();
        for (int i=0; i<date.length;i++){
            try {
                if(null!=valori[i]){
                    PuntoLinea puntoLinea = new PuntoLinea(date[i],valori[i].doubleValue());
                    puntoLineas.add(puntoLinea);
                }
            } catch (GraphException e) {
                LoggingUtils.debug("Errore nel caricamento dei valori PuntoLinea relativi al grafico 2:",e.getCause());
                e.printStackTrace();
                //todo throw this exeption
            }
        }
        
        lineas.add(new Linea(new Categoria(datoRappresentato),puntoLineas));
    }



    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public boolean isHasOicr() {
        return hasOicr;
    }

}
