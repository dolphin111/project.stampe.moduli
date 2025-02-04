package com.fideuram.chart.mock.prospetti.grafici2015.linea;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.Categoria;
import com.fideuram.chart.lab.line.bean.Linea;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.lab.line.bean.PuntoLinea;
import com.fideuram.chart.mock.MockBase;

/**
 * User: V801068
 * Date: 03/03/15
 * Time: 8.34
 */
public class LG01_L extends MockBase{
    /**
     * ltb.addLinea(new String[]{"31/01/2011","28/02/2011","31/03/2011","30/04/2011","31/05/2011","30/06/2011","31/07/2011","31/08/2011","30/09/2011","31/10/2011","30/11/2011","31/12/2011"}, new Number[]{9.92,	10.02,	10.03,	9.98,	9.91,	9.90,	10.17,	10.25,	10.31,	10.32,	10.38,	10.45 },"LG01RA",true);
     * @return
     */
    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {

        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014",  9.93));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014", 10.06));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014", 10.08));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014", 10.10));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014", 10.28));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014", 10.35));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014", 10.42));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014", 10.47));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014", 10.45));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014", 10.30));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014", 10.47));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014", 10.41));
        linee.addLinea(linea);
        return linee;
    }
}

























