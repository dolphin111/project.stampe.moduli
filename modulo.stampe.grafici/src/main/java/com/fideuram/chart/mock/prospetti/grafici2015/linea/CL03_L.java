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
 * Time: 9.58
 */
public class CL03_L extends MockBase {

    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {

        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014", 9.85));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014", 9.93));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014", 9.94));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",10.00));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014",10.13));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014",10.17));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014",10.23));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014",10.30));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014",10.25));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014",10.30));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014",10.38));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014",10.32));
        linee.addLinea(linea);
        return linee;
    }
}













