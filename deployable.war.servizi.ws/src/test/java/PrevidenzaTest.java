import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;

/**
 * User: V801068
 * Date: 02/07/15
 * Time: 12.42
 */
public class PrevidenzaTest {

    public static void main(String args[]) throws Exception {
        Stampe s=new Stampe();

        byte[]   b  =   s.getPdfFromXml(getXmlMockBeneficiario(),"1002");
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "PrevidenzaLocale.pdf");
    }

    public static String getXmlMockBeneficiario(){
        return  "<CambioBenficiario>\n" +
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
                "        <titolo>Gentile Signor</titolo>\n" +
                "        <cognome>BIANCHI</cognome>\n" +
                "        <nome>PAOLO</nome>\n" +
                "        <cf>BCHPLO54D52A501B</cf>\n" +
                "        <dataNascita>1965-10-06T00:00:00+01:00</dataNascita>\n" +
                "        <sesso>M</sesso>\n" +
                "    </nuoviBeneficiari>\n" +
                "    <nuoviBeneficiari>\n" +
                "        <titolo>Gentile Signor</titolo>\n" +
                "        <cognome>BIANCHI</cognome>\n" +
                "        <nome>EMILIO</nome>\n" +
                "        <cf>BCHMLI74D51S501H</cf>\n" +
                "        <dataNascita>1965-10-06T00:00:00+01:00</dataNascita>\n" +
                "        <sesso>M</sesso>\n" +
                "    </nuoviBeneficiari>\n" +
                "</CambioBenficiario>\n";
    }
}
