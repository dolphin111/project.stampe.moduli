import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.*;
import com.fideuram.utils.LoggingUtils;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 03/02/16
 * Time: 8.37
 * To change this template use File | Settings | File Templates.
 */
public class Previdenza5DTest {
    public static void main(String args[]) throws Exception {
        Stampe s=new Stampe();
        byte[]   b  =   s.getPdfFromXml(getXml(),"5.D");
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "Previdenza5DLocalHost.pdf");
    }


    public static String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Previdenza><primaIscrizione>2015-08-17T10:22:19.549+02:00</primaIscrizione><primaLiquidabilita>2015-08-17T10:22:19.549+02:00</primaLiquidabilita><polizza><fondoPensione><denominazione>Fondo Pensione Fideuram</denominazione></fondoPensione><numeroID>70003267800</numeroID><assicurato><titolo>Gentile Signor</titolo><cognome>CRESTALE</cognome><nome>GELINDO</nome><cf>CRSGND49H25I867H</cf><indirizzo><via>VIA FRASSENELLA, 12 A</via><cap>36040</cap><comune>SOSSANO</comune><provincia>VI</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1949-06-25T00:00:00+02:00</dataNascita><sesso>M</sesso></assicurato><aderente><titolo>Gentile Signor</titolo><cognome>CRESTALE</cognome><nome>GELINDO</nome><cf>CRSGND49H25I867H</cf><indirizzo><via>VIA FRASSENELLA, 12 A</via><cap>36040</cap><comune>SOSSANO</comune><provincia>VI</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1949-06-25T00:00:00+02:00</dataNascita><sesso>M</sesso></aderente><pb><titolo>Gentile Signora</titolo><cognome>GALLO</cognome><nome>REGINA MARIA</nome><cf>GLLRNM50L54A154U</cf><indirizzo><via>VLE TRENTO, 52                                    </via><cap>36100</cap><comune>VICENZA                  </comune><provincia>VI</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1950-07-14T00:00:00+01:00</dataNascita><sesso>F</sesso></pb></polizza><liquidazione><tipoLiquidazione>0</tipoLiquidazione><dataRichiesta>2015-08-17T10:22:20.862+02:00</dataRichiesta></liquidazione><documentazione><sollecito>false</sollecito><docIntegrativaAderente>copia della comunicazione rilasciata dall'Ente di previdenza di base di appartenenza, attestante la maturazione dei requisiti di accesso alle prestazioni pensionistiche stabiliti nel regime obbligatorio</docIntegrativaAderente></documentazione><richiesta><data>2014-11-17T13:03:40.237+01:00</data></richiesta></Previdenza>";
    }
}
