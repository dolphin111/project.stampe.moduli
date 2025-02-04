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
 * Time: 12.23
 */
public class LG03RA_L extends MockBase {
    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {
        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014", 9.93));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014",10.05));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014",10.05));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",10.05));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014",10.18));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014",10.25));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014",10.33));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014",10.42));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014",10.40));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014",10.31));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014",10.45));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014",10.41));
        linee.addLinea(linea);

        Linea linea2 = new Linea(new Categoria("benchmark"));
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

























