package com.fideuram.printer.richiestaFacta;

import com.fideuram.exception.GenericsException;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.utils.LoggingUtils;


/**
 * Created by FrancescoD
 * Date: 17/10/18
 *
 */
public class RichiestaFatca1127Test {
    public static void main(String args[]){
        new RichiestaFatca1127Test().test(1127);
        //new RichiestaFatca1127Test().test(1128);
        //new RichiestaFatca1127Test().test(1129);
    }

    public void test(int richiesta){
        try {
            String xml = "";
            if(richiesta==1127){
            	xml = getXmlMockFactaPrimoInvio();
            }
            if(richiesta==1128){
            	xml = getXmlMockFactaSollecito();
            }
            if(richiesta==1129){
            	xml = getXmlMockFactaAltriSolleciti();
            }
            LoggingUtils.info(xml);
            new ControllerActionsGenerics().elaboraProcesso(xml, richiesta);
        } catch (GenericsException e) {
            LoggingUtils.error(e);
        }
    }

    private String getXmlMockFactaPrimoInvio(){
        		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<RichiestaFacta>\n" +
                "    <dataRichiesta>2014-05-21T16:20:40.088+02:00</dataRichiesta> \n" +
                "    <polizza>\n" +
                "        <numeroID>12434534</numeroID>\n" +
                "        <assicurato>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>Cruijff</cognome>\n" +
                "            <nome>Joahn</nome>\n" +
                "            <indirizzo>\n" +
                "                <via>Via della navicella 85</via>\n" +
                "                <cap>00100</cap>\n" +
                "                <comune>Roma</comune>\n" +
                "                <provincia>RM</provincia>\n" +
                "            </indirizzo>\n" +
                "        </assicurato>\n" +
                "        <pb>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>Neckens</cognome>\n" +
                "            <nome>Joahn</nome>\n" +
                "            <indirizzo>\n" +
                "                <via>Via della navicella 95</via>\n" +
                "                <cap>00100</cap>\n" +
                "                <comune>Roma</comune>\n" +
                "                <provincia>RM</provincia>\n" +
                "            </indirizzo>\n" +
                "        </pb>\n" +
                "    </polizza>\n" +
                "    <docIntgrativa><ID>101</ID><descrizione>Riga Esempio 11</descrizione></docIntgrativa>\n" +
                "    <docIntgrativa><ID>102</ID><descrizione>Riga Esempio 12</descrizione></docIntgrativa>\n" +
                "    <docIntgrativa><ID>103</ID><descrizione>Riga Esempio 12</descrizione></docIntgrativa>\n" +
//                "    <docIntgrativa><ID>L3</ID><descrizione>Dichiarazione sostitutiva di notorietà (prodotta secondo le modalita' sotto riportate)</descrizione></docIntgrativa>\n" +
                "</RichiestaFacta>";
      }
	
	 private String getXmlMockFactaSollecito(){
 		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
         "<RichiestaFacta>\n" +
         "    <dataRichiesta>2014-05-21T16:20:40.088+02:00</dataRichiesta> \n" +
         "    <polizza>\n" +
         "        <numeroID>12434534</numeroID>\n" +
         "        <assicurato>\n" +
         "            <titolo>Spett.le</titolo>\n" +
         "            <cognome>Cruijff</cognome>\n" +
         "            <nome>Joahn</nome>\n" +
         "            <indirizzo>\n" +
         "                <via>Via della navicella 85</via>\n" +
         "                <cap>00100</cap>\n" +
         "                <comune>Roma</comune>\n" +
         "                <provincia>RM</provincia>\n" +
         "            </indirizzo>\n" +
         "        </assicurato>\n" +
         "        <pb>\n" +
         "            <titolo>Spett.le</titolo>\n" +
         "            <cognome>Neckens</cognome>\n" +
         "            <nome>Joahn</nome>\n" +
         "            <indirizzo>\n" +
         "                <via>Via della navicella 95</via>\n" +
         "                <cap>00100</cap>\n" +
         "                <comune>Roma</comune>\n" +
         "                <provincia>RM</provincia>\n" +
         "            </indirizzo>\n" +
         "        </pb>\n" +
         "    </polizza>\n" +
         "    <docIntgrativa><ID>101</ID><descrizione>Riga Esempio 11</descrizione></docIntgrativa>\n" +
         "    <docIntgrativa><ID>102</ID><descrizione>Riga Esempio 12</descrizione></docIntgrativa>\n" +
         "    <docIntgrativa><ID>103</ID><descrizione>Riga Esempio 12</descrizione></docIntgrativa>\n" +
//         "    <docIntgrativa><ID>L3</ID><descrizione>Dichiarazione sostitutiva di notorietà (prodotta secondo le modalita' sotto riportate)</descrizione></docIntgrativa>\n" +
         "</RichiestaFacta>";
}
	
	 private String getXmlMockFactaAltriSolleciti(){
	 		return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
	         "<RichiestaFacta>\n" +
	         "    <dataRichiesta>2014-05-21T16:20:40.088+02:00</dataRichiesta> \n" +
	         "    <polizza>\n" +
	         "        <numeroID>12434534</numeroID>\n" +
	         "        <assicurato>\n" +
	         "            <titolo>Spett.le</titolo>\n" +
	         "            <cognome>Cruijff</cognome>\n" +
	         "            <nome>Joahn</nome>\n" +
	         "            <indirizzo>\n" +
	         "                <via>Via della navicella 85</via>\n" +
	         "                <cap>00100</cap>\n" +
	         "                <comune>Roma</comune>\n" +
	         "                <provincia>RM</provincia>\n" +
	         "            </indirizzo>\n" +
	         "        </assicurato>\n" +
	         "        <pb>\n" +
	         "            <titolo>Spett.le</titolo>\n" +
	         "            <cognome>Neckens</cognome>\n" +
	         "            <nome>Joahn</nome>\n" +
	         "            <indirizzo>\n" +
	         "                <via>Via della navicella 95</via>\n" +
	         "                <cap>00100</cap>\n" +
	         "                <comune>Roma</comune>\n" +
	         "                <provincia>RM</provincia>\n" +
	         "            </indirizzo>\n" +
	         "        </pb>\n" +
	         "    </polizza>\n" +
	         "    <docIntgrativa><ID>101</ID><descrizione>Riga Esempio 11</descrizione></docIntgrativa>\n" +
	         "    <docIntgrativa><ID>102</ID><descrizione>Riga Esempio 12</descrizione></docIntgrativa>\n" +
	         "    <docIntgrativa><ID>103</ID><descrizione>Riga Esempio 12</descrizione></docIntgrativa>\n" +
//	         "    <docIntgrativa><ID>L3</ID><descrizione>Dichiarazione sostitutiva di notorietà (prodotta secondo le modalita' sotto riportate)</descrizione></docIntgrativa>\n" +
	         "</RichiestaFacta>";
	}
}
