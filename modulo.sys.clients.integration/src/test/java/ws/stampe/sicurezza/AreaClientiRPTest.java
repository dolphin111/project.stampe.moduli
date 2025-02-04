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
 * Created by V801068 on 09/06/14.
 */
public class AreaClientiRPTest extends TestCase {

    public static Test suite() {
        return new TestSuite(AreaClientiRPTest.class );
    }




    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("16");
        //trasportBean.setXml(AreaClientiMock.getXml());
        trasportBean.setXml(getDatiLetteraPinVO());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "EsitoAreaClientiRP.pdf");
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
                "    <nome>FILOMENA</nome>\n" +
                "    <cognome>SACCOMANNO</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>NA</provincia>\n" +
                "    <regione>Campania</regione>\n" +
                "    <cap>80133</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA AGOSTINO DEPRETIS 19</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>NAPOLI</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
}
