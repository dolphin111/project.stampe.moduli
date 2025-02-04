package com.fideuram.chart.mock.prospetti.grafici2015.linea;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.Categoria;
import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.Colori;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;
import com.fideuram.chart.mock.MockBase;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by
 * User: logan
 * Date: 22/02/13
 * Time: 12.24
 */
public class BMKCORE30_L extends MockBase{
    /**
     *          ltb6.addLinea(new String[]{"31/01/2011","28/02/2011","31/03/2011","30/04/2011","31/05/2011","30/06/2011","31/07/2011","31/08/2011","30/09/2011","31/10/2011","30/11/2011","31/12/2011"}, new Number[]{113.97	,116.17	,116.42	,116.10	,114.93	,115.54 ,118.71	,118.92	,120.27	,120.09	,121.40	,122.09 },"Benchmark Core Beta 30",true);
     */
    public static Linee getMockSommavillaFvInsieme() throws GraphException {
        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria("Benchmark CORE BETA 30"));
        linea.addPuntoLinea(new PuntoLinea("31/01/2013",131.03));
        linea.addPuntoLinea(new PuntoLinea("28/02/2013",132.98));
        linea.addPuntoLinea(new PuntoLinea("31/03/2013",134.82));
        linea.addPuntoLinea(new PuntoLinea("30/04/2013",136.25));
        linea.addPuntoLinea(new PuntoLinea("31/05/2013",136.29));
        linea.addPuntoLinea(new PuntoLinea("30/06/2013",133.99));
        linea.addPuntoLinea(new PuntoLinea("31/07/2013",135.61));
        linea.addPuntoLinea(new PuntoLinea("31/08/2013",134.81));
        linea.addPuntoLinea(new PuntoLinea("30/09/2013",136.35));
        linea.addPuntoLinea(new PuntoLinea("31/10/2013",138.76));
        linea.addPuntoLinea(new PuntoLinea("30/11/2013",139.58));
        linea.addPuntoLinea(new PuntoLinea("31/12/2013",139.38));
        linee.addLinea(linea);
        return linee;

    }


    public static ConfigurationGraph getConfigurationBar(){
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
    }
}
