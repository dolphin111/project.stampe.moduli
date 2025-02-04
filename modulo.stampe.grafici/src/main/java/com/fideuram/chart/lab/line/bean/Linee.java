package com.fideuram.chart.lab.line.bean;

import com.fideuram.chart.lab.PanelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 06/02/13
 * Time: 11.31
 */
public class Linee extends PanelBean{

    protected List<Linea> lineas;

    public List<Linea> getLineas() {
        return lineas;
    }

    public void setLineas(List<Linea> lineas) {
        this.lineas = lineas;
    }

    public void addLinea(Linea linea){
        if(lineas==null)
            lineas=new ArrayList<Linea>();
        lineas.add(linea);
    }
}
