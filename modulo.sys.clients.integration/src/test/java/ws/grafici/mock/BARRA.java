package ws.grafici.mock;

import com.fideuram.graficiservice.Barra;
import com.fideuram.graficiservice.Barre;

/**
 * Created by
 * User: logan
 * Date: 07/03/13
 * Time: 12.16
 */
public class BARRA {
    public static Barre getMock(){
        Barre fagiolo = new Barre();
        fagiolo.setHeader("");
        fagiolo.setYaxis("Valori %");
        Barra barra1  = new Barra();
        Barra barra2  = new Barra();
        Barra barra3  = new Barra();
        Barra barra4  = new Barra();
        Barra barra5  = new Barra();
        Barra barra6  = new Barra();
        Barra barra7  = new Barra();
        Barra barra8  = new Barra();
        Barra barra9  = new Barra();
        Barra barra10 = new Barra();

        barra1.setAnno("2003");
        barra2.setAnno("2004");
        barra3.setAnno("2005");
        barra4.setAnno("2006");
        barra5.setAnno("2007");
        barra6.setAnno("2008");
        barra7.setAnno("2009");
        barra8.setAnno("2010");
        barra9.setAnno("2011");
        barra10.setAnno("2012");

        barra1.setEtichetta("CL01RA");
        barra2.setEtichetta("CL01RA");
        barra3.setEtichetta("CL01RA");
        barra4.setEtichetta("CL01RA");
        barra5.setEtichetta("CL01RA");
        barra6.setEtichetta("CL01RA");
        barra7.setEtichetta("CL01RA");
        barra8.setEtichetta("CL01RA");
        barra9.setEtichetta("CL01RA");
        barra10.setEtichetta("CL01RA");

        barra1.setValore(Double.valueOf(0));
        barra2.setValore(Double.valueOf(0));
        barra3.setValore(Double.valueOf(0));
        barra4.setValore(Double.valueOf(0));
        barra5.setValore(Double.valueOf(0));
        barra6.setValore(Double.valueOf(0));
        barra7.setValore(Double.valueOf(0));
        barra8.setValore(Double.valueOf(0));
        barra9.setValore(Double.valueOf(0));
        barra10.setValore(Double.valueOf(8.77));

        fagiolo.getBarre().add(barra1);
        fagiolo.getBarre().add(barra2);
        fagiolo.getBarre().add(barra3);
        fagiolo.getBarre().add(barra4);
        fagiolo.getBarre().add(barra5);
        fagiolo.getBarre().add(barra6);
        fagiolo.getBarre().add(barra7);
        fagiolo.getBarre().add(barra8);
        fagiolo.getBarre().add(barra9);
        fagiolo.getBarre().add(barra10);
        return fagiolo;
    }
}
