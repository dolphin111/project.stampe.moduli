package com.fideuram.chart.mock.prospetti.grafici2015.linea;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.Categoria;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;
import com.fideuram.chart.mock.MockBase;

/**
 * User: V801068
 * Date: 03/03/15
 * Time: 9.55
 */
public class CL02_L extends MockBase {

    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {

        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014",10.19));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014",10.51));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014",10.54));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",10.55));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014",10.77));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014",10.87));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014",10.90));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014",11.02));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014",10.87));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014",10.86));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014",11.02));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014",10.85));
        linee.addLinea(linea);
        return linee;
    }
}













