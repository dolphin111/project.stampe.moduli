import com.fideuram.config.CrmProperties;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.StampeWsException;
import com.fideuram.stampeservice.controller.ControllerAction;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 07/10/14
 * Time: 9.17
 */
public class AreaRiservataClienteTest {


    public  static void main(String args[]) throws Exception {

        byte[]   meli  = new Stampe().getOdtFromXml(getAnomaliaMeli(),"16");
        StreamerFactory.saveFile(meli, CrmProperties.getProperty("crm.services.temp.path"), "AR_Meli.odt");

        byte[]   bruni  = new Stampe().getOdtFromXml(getXmlUniforme(),"16");
        StreamerFactory.saveFile(bruni, CrmProperties.getProperty("crm.services.temp.path"), "AR_Bruni.odt");

        //new ControllerAction().elaborazioneODT(getAnomaliaMeli(),"16");

    }


    private static String getAnomaliaMeli(){
        return  "<DatiLetteraPinPVO>\n" +
                "    <nome>STEFANO</nome>\n" +
                "    <cognome>PIANTA</cognome>\n" +
                "    <sesso>M</sesso>\n" +
                "    <indirizzo>VIA DON GIOVANNI VERITA' 7</indirizzo>\n" +
                "    <nazione>Italia</nazione>\n" +
                "    <comune>MILANO</comune>\n" +
                "    <provincia>MI</provincia>\n" +
                "    <cap>20158</cap>\n" +
                "    <user>EAABA4AE10</user>\n" +
                "    <password>Rqdxpwvv1!</password>\n" +
                "</DatiLetteraPinPVO>";
    }

    private static String getXmlUniforme(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
               "<areaRiservata><individuo><titolo>Spett.le</titolo><cognome>BRUNI</cognome><nome>ALESSANDRO</nome><indirizzo><via>VIA 420/MA 20</via><cap>63100</cap><comune>ASCOLI PICENO</comune><provincia>AP</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo></individuo><userId>EE8F6B274B</userId><passwd>Cedawohc6$</passwd></areaRiservata>";
    }
}
