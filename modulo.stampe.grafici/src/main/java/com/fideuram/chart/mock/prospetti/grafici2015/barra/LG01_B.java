package com.fideuram.chart.mock.prospetti.grafici2015.barra;

import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;
import com.fideuram.chart.mock.MockBase;

/**
 * User: V801068
 * Date: 03/03/15
 * Time: 10.20
 */
public class LG01_B  {
    public static Barre getMock(){
        Barre fagiolo = new Barre();
        fagiolo.setHeader("");
        fagiolo.setYaxis("Valori %");
        fagiolo.addBarra(new Barra("LG01", Double.valueOf(0),    "2005"));
        fagiolo.addBarra(new Barra("LG01", Double.valueOf(0),    "2006"));
        fagiolo.addBarra(new Barra("LG01", Double.valueOf(0),    "2007"));
        fagiolo.addBarra(new Barra("LG01", Double.valueOf(0),    "2008"));
        fagiolo.addBarra(new Barra("LG01", Double.valueOf(0),    "2009"));
        fagiolo.addBarra(new Barra("LG01", Double.valueOf(0),    "2010"));
        fagiolo.addBarra(new Barra("LG01", Double.valueOf(0),    "2011"));
        fagiolo.addBarra(new Barra("LG01", Double.valueOf(0),    "2012"));
        fagiolo.addBarra(new Barra("LG01", Double.valueOf(0),    "2013"));
        fagiolo.addBarra(new Barra("LG01", Double.valueOf(4.23), "2014"));
        return fagiolo;
    }
}
