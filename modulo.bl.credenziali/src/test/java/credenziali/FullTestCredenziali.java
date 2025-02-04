package credenziali;

import com.fideuram.config.CrmProperties;
import com.fideuram.processo.FacadeCredenziali;
import com.fideuram.utils.Streamer;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 01/02/16
 * Time: 14.07
 */
public class FullTestCredenziali {
    public static void main(String args[]) throws Exception {

        byte[] b= (byte[]) new FacadeCredenziali().stampa(getXmlPinVoMock(), 16);
        Streamer.saveToFile(b, CrmProperties.getProperty("crm.services.temp.path"), "letteraPin16.pdf");

        b= (byte[]) new FacadeCredenziali().stampa(getXmlPinVoMock(), 17);
        Streamer.saveToFile(b, CrmProperties.getProperty("crm.services.temp.path"), "letteraPin17.pdf");

        b= (byte[]) new FacadeCredenziali().stampa(getXmlPinVoMock(), 18);
        Streamer.saveToFile(b, CrmProperties.getProperty("crm.services.temp.path"), "letteraPin18.pdf");

        b= (byte[]) new FacadeCredenziali().stampa(getXmlPinVoMock(), 19);
        Streamer.saveToFile(b, CrmProperties.getProperty("crm.services.temp.path"), "letteraPin19.pdf");

    }


    private static String getXmlAnomalo(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><areaRiservata><individuo><titolo>Spett.le</titolo><cognome>NUCCI</cognome><nome>MICHELE</nome><indirizzo><via>VIA AUGUSTO MURRI. 53</via><cap>05100</cap><comune>TERNI</comune><provincia>TR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo></individuo><userId>E74035F986</userId><passwd>Dhpukzty0$</passwd></areaRiservata>";
    }

    private static String getXmlPinVoMock(){
        return  "<DatiLetteraPinPVO>\n" +
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
