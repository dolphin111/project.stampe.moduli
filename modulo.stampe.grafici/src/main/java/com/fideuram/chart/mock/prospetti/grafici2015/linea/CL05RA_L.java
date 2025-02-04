package com.fideuram.chart.mock.prospetti.grafici2015.linea;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.Categoria;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 28/02/14
 * Time: 21.31
 * To change this template use File | Settings | File Templates.
 */
public class CL05RA_L {
    public static Linee getMockSommavillaFvInsieme() throws GraphException {













        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria("CL05RA"));
        linea.addPuntoLinea(new PuntoLinea("31/01/2013",10.69));
        linea.addPuntoLinea(new PuntoLinea("28/02/2013",10.73));
        linea.addPuntoLinea(new PuntoLinea("31/03/2013",10.74));
        linea.addPuntoLinea(new PuntoLinea("30/04/2013",10.85));
        linea.addPuntoLinea(new PuntoLinea("31/05/2013",10.81));
        linea.addPuntoLinea(new PuntoLinea("30/06/2013",10.48));
        linea.addPuntoLinea(new PuntoLinea("31/07/2013",10.57));
        linea.addPuntoLinea(new PuntoLinea("31/08/2013",10.49));
        linea.addPuntoLinea(new PuntoLinea("30/09/2013",10.64));
        linea.addPuntoLinea(new PuntoLinea("31/10/2013",10.77));
        linea.addPuntoLinea(new PuntoLinea("30/11/2013",10.78));
        linea.addPuntoLinea(new PuntoLinea("31/12/2013",10.76));
        linee.addLinea(linea);
        return linee;
    }
}
