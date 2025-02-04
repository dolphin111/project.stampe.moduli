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
 * Time: 8.38
 * To change this template use File | Settings | File Templates.
 */
public class LG04UD_L_D extends MockBase {


    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {

        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        //Linea linea = new Linea(new Categoria("LG01RA"));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014",10.36  ));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014",10.46  ));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014",10.49  ));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",10.53  ));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014",10.64  ));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014",10.69  ));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014",10.71  ));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014",10.78  ));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014",10.73  ));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014",10.75  ));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014",10.79  ));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014",10.72  ));
        linee.addLinea(linea);

        Linea linea2 = new Linea(new Categoria("BMK"));
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











