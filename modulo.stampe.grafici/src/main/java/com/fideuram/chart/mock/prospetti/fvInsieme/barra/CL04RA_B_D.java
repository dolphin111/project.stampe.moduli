package com.fideuram.chart.mock.prospetti.fvInsieme.barra;

import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;
import com.fideuram.chart.mock.MockBase;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 04/03/15
 * Time: 10.28
 * To change this template use File | Settings | File Templates.
 */
public class CL04RA_B_D extends MockBase {

    public static Barre getMock(){
        Barre fagiolo = new Barre();
        fagiolo.setHeader("");
        fagiolo.setYaxis("Valori %");
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2005"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2006"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2007"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2008"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2009"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2010"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2011"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(0),    "2012"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(-1.02),    "2013"));
        fagiolo.addBarra(new Barra("CL04RA", Double.valueOf(5.22),    "2014"));
        return fagiolo;
    }

}
