package com.fideuram.chart.mock.prospetti.fvInsieme.linea;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.Categoria;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;
import com.fideuram.chart.mock.MockBase;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 04/03/15
 * Time: 9.21
 * To change this template use File | Settings | File Templates.
 */
public class CL04UD_L_D  extends MockBase {
    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {

        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        //Linea linea = new Linea(new Categoria("LG01RA"));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014",  9.96 ));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014", 10.08 ));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014", 10.09 ));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014", 10.09 ));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014", 10.22 ));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014", 10.30 ));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014", 10.38 ));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014", 10.47 ));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014", 10.45 ));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014", 10.37 ));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014", 10.52 ));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014", 10.48 ));
        linee.addLinea(linea);
        return linee;
    }
}













