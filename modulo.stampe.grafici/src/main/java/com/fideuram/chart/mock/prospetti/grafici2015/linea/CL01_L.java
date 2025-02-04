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
 * Time: 9.51
 */
public class CL01_L extends MockBase {

    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {

        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014",  9.78 ));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014",  9.87 ));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014",  9.89 ));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",  9.93 ));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014", 10.03 ));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014", 10.08 ));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014", 10.09 ));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014", 10.16 ));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014", 10.11 ));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014", 10.12 ));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014", 10.16 ));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014", 10.09 ));
        linee.addLinea(linea);
        return linee;
    }
}
















