package ws.stampe.sicurezza;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Risposta;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.TrasportBean;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 23/09/14
 * Time: 9.11
 */
public class WebDatoriTest extends TestCase {

    public static Test suite() {
        return new TestSuite(WebDatoriTest.class );
    }




    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("18");
        trasportBean.setXml(getDatiLetteraPinVO());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            //Risposta r =Stampe.generatePdf(trasportBean);
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "Esito18.pdf");
        } catch (Exception e) {
            assert false;
        }
    }

    private String getDatiLetteraPinVO(){
        return "<DatiLetteraPinPVO>\n" +
                "    <user>EAABA4AE10</user>\n" +
                "    <password>Rqdxpwvv1!</password>\n" +
                "    <ragioneSociale>Aprilia S.P.A.</ragioneSociale>\n" +
                "    <provincia>VE</provincia>\n" +
                "    <regione>Veneto</regione>\n" +
                "    <cap>30033</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA G. Galilei 1</indirizzo>\n" +
                "    <citta>Noale</citta>\n" +
                "</DatiLetteraPinPVO>";
    }

}
