package com.fideuram.chart.mock.prospetti.grafici2015.barra;

import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;

/**
 * User: V801068
 * Date: 02/03/15
 * Time: 17.19
 */
public class CL02UA_B {
    public static Barre getMock(){
        Barre fagiolo = new Barre();
        fagiolo.setHeader("");
        fagiolo.setYaxis("Valori %");
        fagiolo.addBarra(new Barra("CL02UA", Double.valueOf(0),    "2005"));
        fagiolo.addBarra(new Barra("CL02UA", Double.valueOf(0),    "2006"));
        fagiolo.addBarra(new Barra("CL02UA", Double.valueOf(0),    "2007"));
        fagiolo.addBarra(new Barra("CL02UA", Double.valueOf(0),    "2008"));
        fagiolo.addBarra(new Barra("CL02UA", Double.valueOf(0),    "2009"));
        fagiolo.addBarra(new Barra("CL02UA", Double.valueOf(0),    "2010"));
        fagiolo.addBarra(new Barra("CL02UA", Double.valueOf(0),    "2011"));
        fagiolo.addBarra(new Barra("CL02UA", Double.valueOf(0),    "2012"));
        fagiolo.addBarra(new Barra("CL02UA", Double.valueOf(0),    "2013"));
        fagiolo.addBarra(new Barra("CL02UA", Double.valueOf(3.66), "2014"));
        return fagiolo;
    }
}
