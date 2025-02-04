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
 * Time: 21.07
 */
public class COREDBK_L {
    public static Linee getMockSommavillaFvInsieme() throws GraphException {
        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria("CORE DIVERSIFIED BOND \"K\"\n"));
        linea.addPuntoLinea(new PuntoLinea("31/01/2013",100.00));
        linea.addPuntoLinea(new PuntoLinea("28/02/2013",100.39));
        linea.addPuntoLinea(new PuntoLinea("31/03/2013",100.99));
        linea.addPuntoLinea(new PuntoLinea("30/04/2013",101.97));
        linea.addPuntoLinea(new PuntoLinea("31/05/2013",100.59));
        linea.addPuntoLinea(new PuntoLinea("30/06/2013", 96.94));
        linea.addPuntoLinea(new PuntoLinea("31/07/2013", 97.53));
        linea.addPuntoLinea(new PuntoLinea("31/08/2013", 96.15));
        linea.addPuntoLinea(new PuntoLinea("30/09/2013", 97.14));
        linea.addPuntoLinea(new PuntoLinea("31/10/2013", 98.03));
        linea.addPuntoLinea(new PuntoLinea("30/11/2013", 97.43));
        linea.addPuntoLinea(new PuntoLinea("31/12/2013", 96.84));
        linee.addLinea(linea);
        return linee;
    }
}
