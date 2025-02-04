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
 * Time: 12.10
 */
public class COREK_L extends MockBase {
    /**
     * ltb.addLinea(new String[]{"31/01/2011","28/02/2011","31/03/2011","30/04/2011","31/05/2011","30/06/2011","31/07/2011","31/08/2011","30/09/2011","31/10/2011","30/11/2011","31/12/2011"}, new Number[]{9.92,	10.02,	10.03,	9.98,	9.91,	9.90,	10.17,	10.25,	10.31,	10.32,	10.38,	10.45 },"CORE \"K\" ",true);
     */
    public static Linee getMockSommavillaFvInsieme() throws GraphException {
        Linee linee = new Linee();
        Linea linea = new Linea(new Categoria("CORE \"K\" "));
        linea.addPuntoLinea(new PuntoLinea("31/01/2013",97.70));
        linea.addPuntoLinea(new PuntoLinea("28/02/2013",97.89));
        linea.addPuntoLinea(new PuntoLinea("31/03/2013",98.85));
        linea.addPuntoLinea(new PuntoLinea("30/04/2013",99.62));
        linea.addPuntoLinea(new PuntoLinea("31/05/2013",99.52));
        linea.addPuntoLinea(new PuntoLinea("30/06/2013",95.60));
        linea.addPuntoLinea(new PuntoLinea("31/07/2013",97.32));
        linea.addPuntoLinea(new PuntoLinea("31/08/2013",95.89));
        linea.addPuntoLinea(new PuntoLinea("30/09/2013",98.09));
        linea.addPuntoLinea(new PuntoLinea("31/10/2013",99.14));
        linea.addPuntoLinea(new PuntoLinea("30/11/2013",99.33));
        linea.addPuntoLinea(new PuntoLinea("31/12/2013",98.76));
        linee.addLinea(linea);
        return linee;
    }
}
