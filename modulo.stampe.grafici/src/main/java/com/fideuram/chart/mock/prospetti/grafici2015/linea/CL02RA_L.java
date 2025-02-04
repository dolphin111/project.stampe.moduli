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
public class CL02RA_L  extends MockBase {
    /**
     * ltb3.addLinea(new String[]{"31/01/2011","28/02/2011","31/03/2011","30/04/2011","31/05/2011","30/06/2011","31/07/2011","31/08/2011","30/09/2011","31/10/2011","30/11/2011","31/12/2011"}, new Number[]{9.63,	9.89,	9.87,	9.80,	9.38,	9.52,	9.74,	9.82,	10.00,	9.96,	10.09,	10.20 },"CL02RA",true);
     */
    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {
        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014",10.08));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014",10.21));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014",10.27));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",10.31));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014",10.44));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014",10.47));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014",10.52));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014",10.54));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014",10.52));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014",10.45));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014",10.58));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014",10.51));
        linee.addLinea(linea);
        return linee;
    }














}
