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
 * Time: 9.49
 */
public class CL06UD_L_D  extends MockBase {
    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {

        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        //Linea linea = new Linea(new Categoria("LG01RA"));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014", 9.96 ));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014",10.04 ));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014",10.05 ));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",10.12 ));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014",10.25 ));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014",10.28 ));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014",10.34 ));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014",10.42 ));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014",10.36 ));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014",10.42 ));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014",10.50 ));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014",10.44 ));
        linee.addLinea(linea);
        return linee;
    }

}













