package com.fideuram.printer.sicurezza;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.utils.Streamer;

/**
 * User: V801068
 * Date: 12/09/14
 * Time: 9.29
 */
@Deprecated
public class AreaRiservataTest {

    public static void main(String args[]) throws Exception {
       byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(AreaRiservataTest.getXmlAnomalo(), 19);
       Streamer.saveToFile(b, CrmProperties.getProperty("crm.services.temp.path"), "letteraPin.odt");
       // new ControllerActionsGenerics().elaboraProcesso(AreaRiservataTest.getXmlPinVoMock(),18);
       // new ControllerActionsGenerics().elaboraProcesso(AreaRiservataTest.getXmlPinVoMock(),19);
       // new ControllerActionsGenerics().elaboraProcesso(AreaRiservataTest.getXmlPinVoMock(),16);
       // new ControllerActionsGenerics().elaboraProcesso(AreaRiservataTest.getXmlPinVoMock(),17);
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
