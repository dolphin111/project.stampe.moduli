package com.fideuram.chart.mock.prospetti.grafici2015.barra;

import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 28/02/14
 * Time: 21.26
 * To change this template use File | Settings | File Templates.
 */
public class CL04RA_B {
    public static Barre getMock(){
        Barre fagiolo = new Barre();
        fagiolo.setHeader("");
        fagiolo.setYaxis("Valori %");
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2004"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2005"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2006"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2007"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2008"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2009"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2010"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2011"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2012"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(1.02), "2013"));
        return fagiolo;
    }
}
