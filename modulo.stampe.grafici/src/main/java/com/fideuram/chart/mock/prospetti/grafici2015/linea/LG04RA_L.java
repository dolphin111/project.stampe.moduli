package com.fideuram.chart.mock.prospetti.grafici2015.linea;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.Categoria;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;
import com.fideuram.chart.mock.MockBase;

/**
 * User: V801068
 * Date: 02/03/15
 * Time: 12.43
 */
public class LG04RA_L extends MockBase {
    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {
        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014",10.18));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014",10.33));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014",10.30));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",10.27));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014",10.44));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014",10.54));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014",10.62));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014",10.74));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014",10.78));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014",10.64));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014",10.88));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014",10.89));
        linee.addLinea(linea);

        Linea linea2 = new Linea(new Categoria("benchmark"));
        linea2.addPuntoLinea(new PuntoLinea("31/01/2014",13.99));
        linea2.addPuntoLinea(new PuntoLinea("28/02/2014",14.13));
        linea2.addPuntoLinea(new PuntoLinea("31/03/2014",14.21));
        linea2.addPuntoLinea(new PuntoLinea("30/04/2014",14.28));
        linea2.addPuntoLinea(new PuntoLinea("31/05/2014",14.50));
        linea2.addPuntoLinea(new PuntoLinea("30/06/2014",14.64));
        linea2.addPuntoLinea(new PuntoLinea("31/07/2014",14.74));
        linea2.addPuntoLinea(new PuntoLinea("31/08/2014",15.00));
        linea2.addPuntoLinea(new PuntoLinea("30/09/2014",15.06));
        linea2.addPuntoLinea(new PuntoLinea("31/10/2014",15.14));
        linea2.addPuntoLinea(new PuntoLinea("30/11/2014",15.30));
        linea2.addPuntoLinea(new PuntoLinea("31/12/2014",15.39));
        linee.addLinea(linea2);

        return linee;
    }
}

























