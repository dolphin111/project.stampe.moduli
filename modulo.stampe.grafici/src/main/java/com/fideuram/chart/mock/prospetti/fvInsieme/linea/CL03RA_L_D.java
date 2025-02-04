package com.fideuram.chart.mock.prospetti.fvInsieme.linea;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.Categoria;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;
import com.fideuram.chart.mock.MockBase;

/**
 * User: V801068
 * Date: 04/03/15
 * Time: 9.12
 */
public class CL03RA_L_D extends MockBase {
    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {

        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        //Linea linea = new Linea(new Categoria("LG01RA"));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014", 10.03));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014", 10.17));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014", 10.19));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014", 10.22));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014", 10.40));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014", 10.48));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014", 10.55));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014", 10.61));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014", 10.60));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014", 10.45));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014", 10.63));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014", 10.57));
        linee.addLinea(linea);
        return linee;
    }

}













