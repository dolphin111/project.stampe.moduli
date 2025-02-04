package com.fideuram.chart.mock.prospetti.grafici2015.barra;

import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;

/**
 * Created with
 * User: v801068
 * Date: 28/02/14
 * Time: 21.22
 */
public class COREDBK_B {
    public static Barre getMock(){


        Barre fagiolo = new Barre();
        fagiolo.setHeader("");
        fagiolo.setYaxis("Valori %");
        fagiolo.addBarra(new Barra("CORE DIVERSIFIED BOND \"K\"", Double.valueOf(0),    "2004"));
        fagiolo.addBarra(new Barra("CORE DIVERSIFIED BOND \"K\"", Double.valueOf(0),    "2005"));
        fagiolo.addBarra(new Barra("CORE DIVERSIFIED BOND \"K\"", Double.valueOf(0),    "2006"));
        fagiolo.addBarra(new Barra("CORE DIVERSIFIED BOND \"K\"", Double.valueOf(0),    "2007"));
        fagiolo.addBarra(new Barra("CORE DIVERSIFIED BOND \"K\"", Double.valueOf(0),    "2008"));
        fagiolo.addBarra(new Barra("CORE DIVERSIFIED BOND \"K\"", Double.valueOf(0),    "2009"));
        fagiolo.addBarra(new Barra("CORE DIVERSIFIED BOND \"K\"", Double.valueOf(0),    "2010"));
        fagiolo.addBarra(new Barra("CORE DIVERSIFIED BOND \"K\"", Double.valueOf(0),    "2011"));
        fagiolo.addBarra(new Barra("CORE DIVERSIFIED BOND \"K\"", Double.valueOf(0),     "2012"));
        fagiolo.addBarra(new Barra("CORE DIVERSIFIED BOND \"K\"", Double.valueOf(-5.24), "2013"));
        return fagiolo;
    }
}
