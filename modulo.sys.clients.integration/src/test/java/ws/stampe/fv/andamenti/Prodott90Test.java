package ws.stampe.fv.andamenti;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Risposta;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.TrasportBean;
import com.fideuram.utils.LoggingUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with
 * User: logan
 * Date: 03/10/13
 * Time: 12.05
 */
public class Prodott90Test extends TestCase {

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(Prodott90Test.class );
    }


    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("11");
        //trasportBean.setXml(AndamentoProdotto90Mock.getXml());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "EsitoTestAndamentoRisultatiProdotto90.pdf");
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
