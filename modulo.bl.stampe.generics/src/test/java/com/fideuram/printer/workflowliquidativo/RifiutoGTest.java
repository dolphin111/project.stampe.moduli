package com.fideuram.printer.workflowliquidativo;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.utils.LoggingUtils;

public class RifiutoGTest {
	
	 public static void main(String args[]){
         new RifiutoGTest().test(1125);
     }
     
     
     public void test(int richiesta){
         try {

             LoggingUtils.info(getXmlAnomalia());
             byte[] b= (byte[])  new ControllerActionsGenerics().elaboraProcesso(getXmlAnomalia(), richiesta);
             StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "mod_"+richiesta+"_WFL.odt");
             
             System.out.println("Fine");

         } catch (GenericsException e)
         {
             LoggingUtils.error(e);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }


     private static String getXmlAnomalia(){

         /*String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
         		+ "<RifiutoWFL>"
         		+ "<dataRichiesta>2017-01-26T10:02:17.456+01:00</dataRichiesta>"
         		+ "<iscrizioneFPA>2016-11-17T10:02:17.456+01:00</iscrizioneFPA>"
         		+ "<dataTrasferimento>2016-11-17T10:02:17.456+01:00</dataTrasferimento>"
         		+ "<descrizioneFondo>INTESA SAN PAOLO VITA</descrizioneFondo>"
         		+ "<codiceCOVIP>5037</codiceCOVIP>"
         		+ "<dataIscrizioneFormaPensionisticaComplementare>2008-09-29T10:02:17.456+01:00</dataIscrizioneFormaPensionisticaComplementare>"
         		+  "<dataRichiestaErogazionePrestazionePensionistica>2016-09-29T10:02:17.456+01:00</dataRichiestaErogazionePrestazionePensionistica>"
         		+ "<polizza>"
         		+ "	<fondoPensione>"
         		+ "	<denominazione>Fondo Pensione Fideuram</denominazione>"
         		+ "	</fondoPensione><numeroID>70004951406</numeroID><assicurato><titolo>Gentile Signor</titolo><cognome>MONDINI</cognome><nome>PIETRO MASSIMO</nome><cf>MNDPRM82D04D150P</cf><indirizzo><via>PZZA ROMA 7</via><cap>26100</cap><comune>CREMONA</comune><provincia>CR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1982-04-04T00:00:00+02:00</dataNascita><sesso>M</sesso></assicurato><aderente><titolo>Gentile Signor</titolo><cognome>MONDINI</cognome><nome>PIETRO MASSIMO</nome><cf>MNDPRM82D04D150P</cf><indirizzo><via>PZZA ROMA 7</via><cap>26100</cap><comune>CREMONA</comune><provincia>CR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1982-04-04T00:00:00+02:00</dataNascita><sesso>M</sesso></aderente><pb><titolo>Gentile Signor</titolo><cognome>SOSSI</cognome><nome>DIEGO</nome><cf>SSSDGI72M12D150Q</cf><indirizzo><via>VIA DANTE, 104/A                                  </via><cap>26100</cap><comune>CREMONA                  </comune><provincia>CR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1972-08-12T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza></RifiutoWFL>";
         		*/
    	 
    	 String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> "
    	 		+ "<RifiutoWFL>"
           		+ "<dataRichiesta>2017-01-26T10:02:17.456+01:00</dataRichiesta>"
    	 		+ "<polizza>"
    	 		+ "	<fondoPensione>"
    	 		+ "	<denominazione>Fondo Pensione Fideuram</denominazione>"
    	 		+ "	</fondoPensione>"
    	 		+ "	<compagniaDiDestinazione>"
    	 		+ "		<titolo>Spett.le</titolo>"
    	 		+ "		<ragioneSociale>Fondo Pensione Fideuram</ragioneSociale>"
    	 		+ "		<indirizzo><via>via</via><cap>cap</cap><comune>comune</comune><provincia>provincia</provincia><tel_fax></tel_fax><eMail></eMail>"
    	 		+ "		</indirizzo>"
    	 		+ "	</compagniaDiDestinazione>"
    	 		+ "	<numeroID>70011705002</numeroID>"
    	 		+ "	<aderente>"
    	 		+ "		<titolo>Gentile Signor</titolo>"
    	 		+ "		<cognome>DI BUCCI</cognome>"
    	 		+ "		<nome>FRANCO</nome>"
    	 		+ "		<cf>DBCFNC56C24H501R</cf>"
    	 		+ "		<indirizzo><via>VIA CLEMENTE REBORA 46</via><cap>143</cap><comune>ROMA</comune><provincia>RM</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo>"
    	 		+ "		<dataNascita>1956-03-24T00:00:00+01:00</dataNascita>"
    	 		+ "		<sesso>M</sesso>"
    	 		+ "	</aderente>"
    	 		+ "	<pb><titolo>Gentile Signor</titolo><cognome>BARBERA</cognome><nome>DARIO</nome><cf>BRBDRA81E22H501G</cf><indirizzo><via>VIA DI VILLA EMILIANI 10                          </via><cap>00197</cap><comune>RM</comune><provincia>00197</provincia><tel_fax>ROMA                     </tel_fax><eMail>dbarbera@bancafideuram.it</eMail></indirizzo><dataNascita>1981-05-22T00:00:00+02:00</dataNascita><sesso>M</sesso>"
    	 		+ "	</pb>"
    	 		+ "</polizza>"
    	 		+ "</RifiutoWFL>";

         return xml;
     }

}
