package com.fideuram.chart.lab.bar.bean;

import com.fideuram.chart.lab.PanelBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 04/02/13
 * Time: 11.43
 */
public class Barre extends PanelBean{


    private List<Barra> barre;

    public List<Barra> getBarre() {
        return barre;
    }

    public void addBarra(Barra barra){
       if(null==barre)
           barre=new ArrayList<Barra>();
       barre.add(barra);
    }

    public void setBarre(List<Barra> barre) {
        this.barre = barre;
    }
}
