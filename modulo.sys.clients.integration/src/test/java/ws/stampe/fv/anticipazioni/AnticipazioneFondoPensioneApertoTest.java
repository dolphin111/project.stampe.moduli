package ws.stampe.fv.anticipazioni;

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
 * Created
 * User: logan
 * Date: 05/09/13
 * Time: 12.35
 */
public class AnticipazioneFondoPensioneApertoTest extends TestCase {

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AnticipazioneFondoPensioneApertoTest.class);
    }


    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("601");
       // trasportBean.setXml(AnticipazioneFondoPensioneApertoMock.getXml());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            //NB: QUESTO SERVIZIO ANCORA NON è ATTIVO
            //Risposta r =Stampe.generatePdf(trasportBean);
            //assertNotNull(r.getStreams());
            //assertTrue(r.getStreams().get(0).length > 1000);
            //StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "AnticipazioneFondoPensioneAperto.pdf");
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
