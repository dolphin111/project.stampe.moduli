package com.fideuram.chart.mock.prospetti.grafici2015.linea;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.Categoria;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;

/**
 * Created
 * User: v801068
 * Date: 28/02/14
 * Time: 21.15
 */
public class CL04RA_L {
    public static Linee getMockSommavillaFvInsieme() throws GraphException {
        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria("CL04RA"));
        linea.addPuntoLinea(new PuntoLinea("31/01/2013",10.53));
        linea.addPuntoLinea(new PuntoLinea("28/02/2013",10.58));
        linea.addPuntoLinea(new PuntoLinea("31/03/2013",10.66));
        linea.addPuntoLinea(new PuntoLinea("30/04/2013",10.78));
        linea.addPuntoLinea(new PuntoLinea("31/05/2013",10.71));
        linea.addPuntoLinea(new PuntoLinea("30/06/2013",10.41));
        linea.addPuntoLinea(new PuntoLinea("31/07/2013",10.48));
        linea.addPuntoLinea(new PuntoLinea("31/08/2013",10.43));
        linea.addPuntoLinea(new PuntoLinea("30/09/2013",10.47));
        linea.addPuntoLinea(new PuntoLinea("31/10/2013",10.58));
        linea.addPuntoLinea(new PuntoLinea("30/11/2013",10.54));
        linea.addPuntoLinea(new PuntoLinea("31/12/2013",10.55));
        linee.addLinea(linea);
        return linee;
    }
}
