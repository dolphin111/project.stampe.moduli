package com.fideuram.chart.mock.generici.istogramma;

import com.fideuram.chart.configuration.Colore;
import com.fideuram.chart.grafici.istogramma.bean.BarElement;
import com.fideuram.chart.configuration.Gruppo;
import com.fideuram.chart.grafici.istogramma.bean.Istogramma;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 02/07/13
 * Time: 14.44
 */
public class IstogrammaGenerico {
    public static Istogramma getMock(){
        Gruppo beta15 = new Gruppo("Core 15",new Colore(255,255,255));

        Istogramma fagiolo = new Istogramma();
        fagiolo.setHeader("");
        fagiolo.setYaxis("Valori %");
        fagiolo.addBarElement(new BarElement(beta15, Double.valueOf(0), "2004"));
        fagiolo.addBarElement(new BarElement(beta15, Double.valueOf(0), "2005"));
        fagiolo.addBarElement(new BarElement(beta15, Double.valueOf(0), "2006"));
        fagiolo.addBarElement(new BarElement(beta15, Double.valueOf(0), "2007"));
        fagiolo.addBarElement(new BarElement(beta15, Double.valueOf(0), "2008"));
        fagiolo.addBarElement(new BarElement(beta15, Double.valueOf(0), "2009"));
        fagiolo.addBarElement(new BarElement(beta15, Double.valueOf(0), "2010"));
        fagiolo.addBarElement(new BarElement(beta15, Double.valueOf(0.66), "2011"));
        fagiolo.addBarElement(new BarElement(beta15, Double.valueOf(9.01), "2012"));

        Gruppo beta30 = new Gruppo("Core 30",new Colore(69,114,167));

        fagiolo.addBarElement(new BarElement(beta30,Double.valueOf(1),    "2004"));
        fagiolo.addBarElement(new BarElement(beta30,Double.valueOf(2),    "2005"));
        fagiolo.addBarElement(new BarElement(beta30,Double.valueOf(3),    "2006"));
        fagiolo.addBarElement(new BarElement(beta30,Double.valueOf(4),    "2007"));
        fagiolo.addBarElement(new BarElement(beta30,Double.valueOf(5),    "2008"));
        fagiolo.addBarElement(new BarElement(beta30,Double.valueOf(6),    "2009"));
        fagiolo.addBarElement(new BarElement(beta30,Double.valueOf(7),    "2010"));
        fagiolo.addBarElement(new BarElement(beta30,Double.valueOf(8.66), "2011"));
        fagiolo.addBarElement(new BarElement(beta30,Double.valueOf(9.01), "2012"));
        return fagiolo;
    }
}
