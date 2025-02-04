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
 * Date: 07/08/15
 * Time: 11.59
 */
public class CambioBeneficiarioTest  extends TestCase {

    public static Test suite() {
        return new TestSuite(CambioBeneficiarioTest.class );
    }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("1002");
        trasportBean.setXml(getMock());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1002);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "AppendiceCambioBeneficiario.pdf");
        } catch (Exception e) {
            LoggingUtils.error(e);
            assert false;
        }
    }

    private String getMock(){
        return "<CambioBenficiario>\n" +
                "    <sollecito>false</sollecito>\n" +
                "    <polizza>\n" +
                "        <numeroID>90008819301</numeroID>\n" +
                "        <aderente>\n" +
                "            <titolo>Gentile Signor</titolo>\n" +
                "            <cognome>MARCHESE</cognome>\n" +
                "            <nome>PAOLO</nome>\n" +
                "            <cf>MRCPLA48H29B006D</cf>\n" +
                "            <indirizzo>\n" +
                "                <via>VLE CITTA' DI PRATO 15</via>\n" +
                "                <cap>38051</cap>\n" +
                "                <comune>BORGO VALSUGANA</comune>\n" +
                "                <provincia>TN</provincia>\n" +
                "                <tel_fax></tel_fax>\n" +
                "                <eMail></eMail>\n" +
                "            </indirizzo>\n" +
                "            <dataNascita>1948-06-29T00:00:00+02:00</dataNascita>\n" +
                "            <sesso>M</sesso>\n" +
                "        </aderente>\n" +
                "        <pb>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>FIORITO</cognome>\n" +
                "            <nome>LUCA</nome>\n" +
                "            <cf>FRTLCU62D19L378O</cf>\n" +
                "            <indirizzo>\n" +
                "                <via>VIA AMBROSI 1                                     </via>\n" +
                "                <cap>38100</cap>\n" +
                "                <comune>TRENTO                   </comune>\n" +
                "                <provincia>TN</provincia>\n" +
                "                <tel_fax></tel_fax>\n" +
                "                <eMail>LFIORITO@bancafideuram.it</eMail>\n" +
                "            </indirizzo>\n" +
                "        </pb>\n" +
                "    </polizza>\n" +
                "    <dataDecorrenza>2015-06-22T00:00:00+02:00</dataDecorrenza>\n" +
                "    <nuoviBeneficiari>\n" +
                "        <titolo>Spett.le</titolo>\n" +
                "        <cognome>BIANCHI</cognome>\n" +
                "        <nome>PAOLO</nome>\n" +
                "        <cf>BCHPLO54D52A501B</cf>\n" +
                "        <percentualeBeneficiario>50.00</percentualeBeneficiario>\n" +
                "    </nuoviBeneficiari>\n" +
                "    <nuoviBeneficiari>\n" +
                "        <titolo>Spett.le</titolo>\n" +
                "        <cognome>BIANCHI</cognome>\n" +
                "        <nome>EMILIO</nome>\n" +
                "        <cf>BCHMLI74D51S501H</cf>\n" +
                "        <percentualeBeneficiario>50.00</percentualeBeneficiario>\n" +
                "    </nuoviBeneficiari>\n" +
                "</CambioBenficiario>\n";
    }
}
