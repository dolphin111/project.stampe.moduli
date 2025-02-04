package ws.rendiconti;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
//import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Fao;
import com.fideuram.stampeservice.Risposta;
import com.fideuram.stampeservice.TrasportBean;
import com.fideuram.utils.LoggingUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 07/02/14
 * Time: 15.12
 */
public class Ante551FaoTest extends TestCase {

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(Ante551FaoTest.class);
    }


    /*public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("6001");

        try {
            File file = new File(CrmProperties.getProperty("crm.services.input.path")+"FAOANTE551.xml");
            Fao fao = (Fao) Converter.xml2Object(new Fao(),file );
            trasportBean.setXml(Converter.objectToXml(fao));
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "RendicontoFao.pdf");
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }*/

}
