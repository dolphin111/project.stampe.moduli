package com.fideuram.chart.grafici.linea.bean;

import com.fideuram.chart.grafici.GraficoBase;
import com.fideuram.chart.lab.line.bean.Linee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 20/01/14
 * Time: 15.24
 */
public class LineeChart extends GraficoBase{
    private List<Linea> linee;

    public List<Linea> getLinee() {
        return linee;
    }

    public void setLinee(List<Linea> linee) {
        this.linee = linee;
    }

    public void addLinea(Linea linea){
        if(linee==null)
            linee=new ArrayList<Linea>();
        linee.add(linea);
    }
}
