package ws.stampe.cambiocontraenza;

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
 * User: V801068
 * Date: 21/05/15
 * Time: 17.58
 */
public class AppendiciteTest  extends TestCase {

    public static Test suite() {
        return new TestSuite(AppendiciteTest.class );
    }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("1000");
        trasportBean.setXml(getXml());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "AppendiciteCambioContraenza.pdf");
        } catch (Exception e) {
            LoggingUtils.error(e);
            assert false;
        }


    }

    private String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><AppendiceCC><dataRichiesta>2015-05-21T15:57:14.628+02:00</dataRichiesta><sollecito>false</sollecito><causale><causale>0</causale></causale><polizza><numeroID>7520043</numeroID><decorrenza>2001-04-05T00:00:00+02:00</decorrenza><contraente><titolo>Gentile Signora</titolo><cognome>RUSSO</cognome><nome>ANTONIA</nome><cf>RSSNTN34D66A064D</cf><indirizzo><via>VIA GARIGLIANO 5</via><cap>80016</cap><comune>MARANO DI NAPOLI</comune><provincia>NA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1934-04-26T00:00:00+01:00</dataNascita><sesso>F</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>RUSSO</cognome><nome>MATTEO</nome><cf>RSSMTT00S09F839J</cf><indirizzo><via>VIA GARIGLIANO 5</via><cap>80016</cap><comune>MARANO DI NAPOLI</comune><provincia>NA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>2000-11-09T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>MARUCCIA</cognome><nome>ANTONIO</nome><cf>MRCNTN67B15F839I</cf><indirizzo><via>VIA G M BOSCO ANG VIA ROSSELLI                    </via><cap>81100</cap><comune>CASERTA                  </comune><provincia>CE</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1967-02-15T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne><nuovoContraente><titolo>Spett.le</titolo><cognome>BRUNI</cognome><nome>ALESSANDRO</nome></nuovoContraente><dataEffettoCC>2015-05-21T00:00:00+02:00</dataEffettoCC></AppendiceCC>";
    }
}


