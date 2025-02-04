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
 * Time: 12.17
 */
public class BMKCORE15_L extends MockBase{
    /**
     *  ltb5.addLinea(new String[]{"31/01/2011","28/02/2011","31/03/2011","30/04/2011","31/05/2011","30/06/2011","31/07/2011","31/08/2011","30/09/2011","31/10/2011","30/11/2011","31/12/2011"}, new Number[]{103.36	,104.84	,104.93	,104.81	,104.13	,104.77	,106.64	,107.01	,108.02	,108.26	,109.15	,109.87 },"Benchmark Core Beta 15 EM",true);
     */
    public static Linee getMockSommavillaFvInsieme() throws GraphException {
        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria("Benchmark CORE BETA 15 EM"));
        linea.addPuntoLinea(new PuntoLinea("31/01/2013",110.47));
        linea.addPuntoLinea(new PuntoLinea("28/02/2013",111.64));
        linea.addPuntoLinea(new PuntoLinea("31/03/2013",112.57));
        linea.addPuntoLinea(new PuntoLinea("30/04/2013",113.80));
        linea.addPuntoLinea(new PuntoLinea("31/05/2013",113.30));
        linea.addPuntoLinea(new PuntoLinea("30/06/2013",111.43));
        linea.addPuntoLinea(new PuntoLinea("31/07/2013",112.18));
        linea.addPuntoLinea(new PuntoLinea("31/08/2013",111.56));
        linea.addPuntoLinea(new PuntoLinea("30/09/2013",112.74));
        linea.addPuntoLinea(new PuntoLinea("31/10/2013",114.39));
        linea.addPuntoLinea(new PuntoLinea("30/11/2013",114.51));
        linea.addPuntoLinea(new PuntoLinea("31/12/2013",114.09));
        linee.addLinea(linea);
        return linee;
    }


    public static ConfigurationGraph getConfigurationBar(){
        ConfigurationGraph cb = new ConfigurationGraph();

        Colori colori = new Colori();
        ArrayList colors = new ArrayList();
        colors.add(new Color(51,51,51));
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
