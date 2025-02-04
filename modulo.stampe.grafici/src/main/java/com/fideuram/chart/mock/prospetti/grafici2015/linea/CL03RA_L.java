package com.fideuram.chart.mock.prospetti.grafici2015.linea;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.Categoria;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;
import com.fideuram.chart.mock.MockBase;

/**
 * Created by
 * User: logan
 * Date: 22/02/13
 * Time: 12.30
 */
public class CL03RA_L  extends MockBase {
    /**
     * ltb4.addLinea(new String[]{"31/01/2011","28/02/2011","31/03/2011","30/04/2011","31/05/2011","30/06/2011","31/07/2011","31/08/2011","30/09/2011","31/10/2011","30/11/2011","31/12/2011"}, new Number[]{9.86,	10.03,	10.02,	9.99,	9.86,	9.91,	10.16,	10.23,	10.31,	10.32,	10.36,	10.48 },"CL03RA",true);
     */
    public static Linee getMockSommavillaFvInsieme(String c) throws GraphException {
        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(c));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014",10.55));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014",10.77));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014",10.74));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",10.82));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014",11.14));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014",11.24));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014",11.42));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014",11.54));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014",11.51));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014",11.37));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014",11.71));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014",11.64));
        linee.addLinea(linea);
        return linee;
    }














}
