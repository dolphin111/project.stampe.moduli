package ws.stampe.previdenza;

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
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 03/09/14
 * Time: 10.16
 * To change this template use File | Settings | File Templates.
 */
public class PrevidenzaTest  extends TestCase {

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PrevidenzaTest.class );
    }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("5.D");
        trasportBean.setXml(getXml());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "TestPrevidenza5.D_Erogazione.pdf");
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }

    public static String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Previdenza><primaIscrizione>2015-08-17T10:22:19.549+02:00</primaIscrizione><primaLiquidabilita>2015-08-17T10:22:19.549+02:00</primaLiquidabilita><polizza><fondoPensione><denominazione>Fondo Pensione Fideuram</denominazione></fondoPensione><numeroID>70003267800</numeroID><assicurato><titolo>Gentile Signor</titolo><cognome>CRESTALE</cognome><nome>GELINDO</nome><cf>CRSGND49H25I867H</cf><indirizzo><via>VIA FRASSENELLA, 12 A</via><cap>36040</cap><comune>SOSSANO</comune><provincia>VI</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1949-06-25T00:00:00+02:00</dataNascita><sesso>M</sesso></assicurato><aderente><titolo>Gentile Signor</titolo><cognome>CRESTALE</cognome><nome>GELINDO</nome><cf>CRSGND49H25I867H</cf><indirizzo><via>VIA FRASSENELLA, 12 A</via><cap>36040</cap><comune>SOSSANO</comune><provincia>VI</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1949-06-25T00:00:00+02:00</dataNascita><sesso>M</sesso></aderente><pb><titolo>Gentile Signora</titolo><cognome>GALLO</cognome><nome>REGINA MARIA</nome><cf>GLLRNM50L54A154U</cf><indirizzo><via>VLE TRENTO, 52                                    </via><cap>36100</cap><comune>VICENZA                  </comune><provincia>VI</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1950-07-14T00:00:00+01:00</dataNascita><sesso>F</sesso></pb></polizza><liquidazione><tipoLiquidazione>0</tipoLiquidazione><dataRichiesta>2015-08-17T10:22:20.862+02:00</dataRichiesta></liquidazione><documentazione><sollecito>false</sollecito><docIntegrativaAderente>copia della comunicazione rilasciata dall'Ente di previdenza di base di appartenenza, attestante la maturazione dei requisiti di accesso alle prestazioni pensionistiche stabiliti nel regime obbligatorio</docIntegrativaAderente></documentazione><richiesta><data>2014-11-17T13:03:40.237+01:00</data></richiesta></Previdenza>";
    }


}
