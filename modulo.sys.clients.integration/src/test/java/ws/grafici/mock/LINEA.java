package ws.grafici.mock;


import com.fideuram.graficiservice.Categoria;
import com.fideuram.graficiservice.Linea;
import com.fideuram.graficiservice.Linee;
import com.fideuram.graficiservice.PuntoLinea;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 06/03/13
 * Time: 9.52
 */
public class LINEA {

    /**
     * ANGELA CARELLA
     * PER FV INSIEME PREMIUM
     * LineaTimeBean ltb = new LineaTimeBean();
     * ltb.addLinea(new String[]{"31/01/2011","28/02/2011","31/03/2011","30/04/2011","31/05/2011","30/06/2011","31/07/2011","31/08/2011","30/09/2011","31/10/2011","30/11/2011","31/12/2011"}, new Number[]{10.307,	10.376,	10.360,	10.284,	10.188,	10.163,	10.418,	10.471,	10.512,	10.496,	10.531,	10.583},"LG01RA",true);
     * new LineaDay().generateGrafico(ltb, "LG01RA");
     * @return
     */
    public static Linee getMockCarellaPremium()  {
        Linee linee = new Linee();

        Categoria categoria = new Categoria();
        categoria.setCategoria("LG01RA");

        Linea linea = new Linea();
        linea.setCategoria(categoria);

        List<PuntoLinea> puntoLineas = new ArrayList<PuntoLinea>();
        PuntoLinea p1 = new PuntoLinea();
        p1.setData("31/01/2011");
        p1.setValore(10.307);

        PuntoLinea p2 = new PuntoLinea();
        p2.setData("28/02/2011");
        p2.setValore(10.376);

        PuntoLinea p3 = new PuntoLinea();
        p3.setData("31/03/2011");
        p3.setValore(10.284);

        PuntoLinea p4 = new PuntoLinea();
        p4.setData("30/04/2011");
        p4.setValore(10.188);

        PuntoLinea p5 = new PuntoLinea();
        p5.setData("31/05/2011");
        p5.setValore(10.360);

        PuntoLinea p6 = new PuntoLinea();
        p6.setData("30/06/2011");
        p6.setValore(10.163);

        PuntoLinea p7 = new PuntoLinea();
        p7.setData("31/07/2011");
        p7.setValore(10.418);

        PuntoLinea p8 = new PuntoLinea();
        p8.setData("31/08/2011");
        p8.setValore(10.471);

        PuntoLinea p9 = new PuntoLinea();
        p9.setData("30/09/2011");
        p9.setValore(10.512);

        PuntoLinea p10 = new PuntoLinea();
        p10.setData("31/10/2011");
        p10.setValore(10.496);

        PuntoLinea p11 = new PuntoLinea();
        p11.setData("30/11/2011");
        p11.setValore(10.531);

        PuntoLinea p12 = new PuntoLinea();
        p12.setData("31/12/2011");
        p12.setValore(10.583);


        linea.getPuntoLineas().add(p1);
        linea.getPuntoLineas().add(p2);
        linea.getPuntoLineas().add(p3);
        linea.getPuntoLineas().add(p4);
        linea.getPuntoLineas().add(p5);
        linea.getPuntoLineas().add(p6);
        linea.getPuntoLineas().add(p7);
        linea.getPuntoLineas().add(p8);
        linea.getPuntoLineas().add(p9);
        linea.getPuntoLineas().add(p10);
        linea.getPuntoLineas().add(p11);
        linea.getPuntoLineas().add(p12);

        linee.getLineas().add(linea);
        return linee;
    }
}
