package ws.stampe.fv.riscatti;

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
 * Created by V801068 on 10/04/14.
 */
public class RiscattoAnticipatoTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(RiscattoAnticipatoTest.class );
    }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("4538");
        //trasportBean.setXml(RiscattoAnticipatoMock.getXmlPersonaGiuridica());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            //Risposta r =Stampe.generateOdt(trasportBean);
            Risposta r =Stampe.generatePdf(trasportBean);

            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "EsitoTestRiscattoAnticipato.pdf");
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
