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
 * Time: 9.16
 */
public class WebDatoriRPTest  extends TestCase {

    public static Test suite() {
        return new TestSuite(WebDatoriRPTest.class );
    }




    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("19");
        trasportBean.setXml(getDatiLetteraPinVO());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "EsitoWebDatoriRP.pdf");
        } catch (Exception e) {
            assert false;
        }
    }

    private String getDatiLetteraPinVO(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016459005</polizza>\n" +
                "    <user>EAABA4AE10</user>\n" +
                "    <password>Rqdxpwvv1!</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <ragioneSociale>Aprilia S.P.A.</ragioneSociale>\n" +
                "    <sesso>G</sesso>\n" +
                "    <provincia>VE</provincia>\n" +
                "    <regione>Veneto</regione>\n" +
                "    <cap>30033</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA G. Galilei 1</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>Noale</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
}
