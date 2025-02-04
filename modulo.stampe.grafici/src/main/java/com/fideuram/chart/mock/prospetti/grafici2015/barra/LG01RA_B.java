package com.fideuram.chart.mock.prospetti.grafici2015.barra;

import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;
import com.fideuram.chart.mock.MockBase;

/**
 * Created by
 * User: logan
 * Date: 22/02/13
 * Time: 11.10
 */
public class LG01RA_B extends MockBase {

    public static Barre getMock(){
        Barre fagiolo = new Barre();
        fagiolo.setHeader("");
        fagiolo.setYaxis("Valori %");
        fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(0),    "2005"));
        fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(0),    "2006"));
        fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(0),    "2007"));
        fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(0),    "2008"));
        fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(0),    "2009"));
        fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(0),    "2010"));
        fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(0),    "2011"));
        //fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(8.25), "2012"));
        fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(0),    "2012"));
        //fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(0.78), "2013"));
        fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(0),    "2013"));
        fagiolo.addBarra(new Barra("LG01RA", Double.valueOf(4.61), "2014"));
        return fagiolo;
    }


}
