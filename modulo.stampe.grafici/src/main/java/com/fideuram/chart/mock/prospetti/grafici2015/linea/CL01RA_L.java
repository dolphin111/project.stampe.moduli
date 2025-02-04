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
 * Time: 12.29
 */
public class CL01RA_L extends MockBase{
    /**
     * ltb2.addLinea(new String[]{"31/01/2011","28/02/2011","31/03/2011","30/04/2011","31/05/2011","30/06/2011","31/07/2011","31/08/2011","30/09/2011","31/10/2011","30/11/2011","31/12/2011"}, new Number[]{9.98,	10.09,	10.12,	10.10,	10.04,	10.09,	10.29,	10.37,	10.45,	10.49,	10.55,	10.63 },"CL01RA",true);
     */
    public static Linee getMockSommavillaFvInsieme(String categoria) throws GraphException {
        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria(categoria));
        linea.addPuntoLinea(new PuntoLinea("31/01/2014", 9.84));
        linea.addPuntoLinea(new PuntoLinea("28/02/2014", 9.93));
        linea.addPuntoLinea(new PuntoLinea("31/03/2014", 9.96));
        linea.addPuntoLinea(new PuntoLinea("30/04/2014",10.01));
        linea.addPuntoLinea(new PuntoLinea("31/05/2014",10.14));
        linea.addPuntoLinea(new PuntoLinea("30/06/2014",10.20));
        linea.addPuntoLinea(new PuntoLinea("31/07/2014",10.25));
        linea.addPuntoLinea(new PuntoLinea("31/08/2014",10.30));
        linea.addPuntoLinea(new PuntoLinea("30/09/2014",10.23));
        linea.addPuntoLinea(new PuntoLinea("31/10/2014",10.27));
        linea.addPuntoLinea(new PuntoLinea("30/11/2014",10.32));
        linea.addPuntoLinea(new PuntoLinea("31/12/2014",10.25));
        linee.addLinea(linea);
        return linee;
    }













}
