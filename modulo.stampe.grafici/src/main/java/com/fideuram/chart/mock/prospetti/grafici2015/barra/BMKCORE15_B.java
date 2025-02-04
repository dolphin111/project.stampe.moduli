package com.fideuram.chart.mock.prospetti.grafici2015.barra;

import com.fideuram.chart.lab.bar.bean.Barra;
import com.fideuram.chart.lab.bar.bean.Barre;
import com.fideuram.chart.mock.MockBase;

/**
 * Created by
 * User: logan
 * Date: 22/02/13
 * Time: 11.12
 */
public class BMKCORE15_B extends MockBase {
    public static Barre getMock(){
        Barre fagiolo = new Barre();
        fagiolo.setHeader("");
        fagiolo.setYaxis("Valori %");
        fagiolo.addBarra(new Barra("Benchmark CORE BETA 15 EM ", Double.valueOf(0),    "2004"));
        fagiolo.addBarra(new Barra("Benchmark CORE BETA 15 EM ", Double.valueOf(0),    "2005"));
        fagiolo.addBarra(new Barra("Benchmark CORE BETA 15 EM ", Double.valueOf(0),    "2006"));
        fagiolo.addBarra(new Barra("Benchmark CORE BETA 15 EM ", Double.valueOf(0),    "2007"));
        fagiolo.addBarra(new Barra("Benchmark CORE BETA 15 EM ", Double.valueOf(0),    "2008"));
        fagiolo.addBarra(new Barra("Benchmark CORE BETA 15 EM ", Double.valueOf(0),    "2009"));
        fagiolo.addBarra(new Barra("Benchmark CORE BETA 15 EM ", Double.valueOf(0),    "2010"));
        fagiolo.addBarra(new Barra("Benchmark CORE BETA 15 EM ", Double.valueOf(1.01), "2011"));
        fagiolo.addBarra(new Barra("Benchmark CORE BETA 15 EM ", Double.valueOf(9.41), "2012"));
        fagiolo.addBarra(new Barra("Benchmark CORE BETA 15 EM ", Double.valueOf(3.09), "2013"));
        return fagiolo;

    }

    /*public static ConfigurationGraph getConfigurationBar(){
        ConfigurationGraph cb = new ConfigurationGraph();

        Colori colori = new Colori();
        ArrayList colors = new ArrayList();
        colors.add(new Color(51, 51, 51));
        colors.add(new Color(80,170,150));
        colori.setPantoni(colors);
        cb.setColori(colori);

        cb.setOrientation(ConfigurationGraph.ORIENTATION_VERTICALE);
        cb.setxPixelDimension(500);
        cb.setyPixelDimension(300);
        cb.setOmbraSulleBarre(false);
        cb.setLegenda(true);
        cb.setTooltip(true);
        return cb;
    }*/
}
