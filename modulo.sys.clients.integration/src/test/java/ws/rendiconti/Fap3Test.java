package ws.rendiconti;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
//import com.fideuram.stampe.modello.rendiconti.prodotto.consob.Fap3Consob;
import com.fideuram.stampeservice.Risposta;

import com.fideuram.stampeservice.TrasportBean;
import com.fideuram.utils.LoggingUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

/**
 * Created
 * User: v801068
 * Date: 13/02/14
 * Time: 18.34
 */
public class Fap3Test extends TestCase {

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(Fap3Test.class);
    }


    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("6006");

      /*  try {
            File file = new File(CrmProperties.getProperty("crm.services.input.path")+"CONSOB_FAP3.xml");
            Fap3Consob fap3 = (Fap3Consob) Converter.xml2Object(new Fap3Consob(), file);
            trasportBean.setXml(Converter.objectToXml(fap3));
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "Gamba_ConsobFap3.pdf");
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }*/
    }

}
