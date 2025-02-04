package ws.stampe.fv.andamenti;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Risposta;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.TrasportBean;

/**
 * Created with
 * User: logan
 * Date: 10/07/13
 * Time: 11.56
 */
public class AndamentoRisultatiTest extends TestCase {
        /**
         * @return the suite of tests being tested
         */
        public static Test suite() {
            return new TestSuite(AndamentoRisultatiTest.class );
        }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("11");
        //trasportBean.setXml(AndamentiERisultatiMock.getXml());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "EsitoTestAndamentoRisultati.pdf");
        } catch (Exception e) {
            assert false;
        }
    }
}
