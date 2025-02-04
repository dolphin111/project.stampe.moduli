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
 * Time: 8.41
 * To change this template use File | Settings | File Templates.
 */
public class LG03RA_L_D extends MockBase {


    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {

        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        //Linea linea = new Linea(new Categoria("LG01RA"));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014",10.84));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014",11.18));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014",11.15));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",11.11));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014",11.39));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014",11.52));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014",11.56));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014",11.77));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014",11.68));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014",11.65));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014",11.92));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014",11.80));
        linee.addLinea(linea);

        Linea linea2 = new Linea(new Categoria("BMK"));
        linea2.addPuntoLinea(new PuntoLinea("31/01/2014",11.46));
        linea2.addPuntoLinea(new PuntoLinea("28/02/2014",11.55));
        linea2.addPuntoLinea(new PuntoLinea("31/03/2014",11.64));
        linea2.addPuntoLinea(new PuntoLinea("30/04/2014",11.69));
        linea2.addPuntoLinea(new PuntoLinea("31/05/2014",11.84));
        linea2.addPuntoLinea(new PuntoLinea("30/06/2014",11.94));
        linea2.addPuntoLinea(new PuntoLinea("31/07/2014",12.01));
        linea2.addPuntoLinea(new PuntoLinea("31/08/2014",12.17));
        linea2.addPuntoLinea(new PuntoLinea("30/09/2014",12.17));
        linea2.addPuntoLinea(new PuntoLinea("31/10/2014",12.22));
        linea2.addPuntoLinea(new PuntoLinea("30/11/2014",12.30));
        linea2.addPuntoLinea(new PuntoLinea("31/12/2014",12.32));
        linee.addLinea(linea2);
        return linee;
    }
}

























