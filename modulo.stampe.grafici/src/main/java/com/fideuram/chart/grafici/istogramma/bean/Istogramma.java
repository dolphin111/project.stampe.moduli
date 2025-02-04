package com.fideuram.chart.grafici.istogramma.bean;

import com.fideuram.chart.grafici.GraficoBase;
import com.fideuram.chart.lab.PanelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 02/07/13
 * Time: 12.25
 */
public class Istogramma extends GraficoBase {
    private List<BarElement>  barElements;

    public List<BarElement> getBarElements() {
        return barElements;
    }

    public void setBarElements(List<BarElement> barElements) {
        this.barElements = barElements;
    }

    public void addBarElement(BarElement barra){
        if(null==barElements)
            barElements=new ArrayList<BarElement>();
        barElements.add(barra);
    }
}
