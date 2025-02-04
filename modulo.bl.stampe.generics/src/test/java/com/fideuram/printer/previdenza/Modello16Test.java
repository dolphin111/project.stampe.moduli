package com.fideuram.printer.previdenza;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.utils.LoggingUtils;

/**
 * User: V801068
 * Date: 02/07/14
 * Time: 8.52
 */
public class Modello16Test extends ModelloTest{

	 public static void main(String args[]){
         new Modello16Test().test(1116);
     }
     
     
     public void test(int richiesta){
         try {

             LoggingUtils.info(getXmlAnomalia());
             byte[] b= (byte[])  new ControllerActionsGenerics().elaboraProcesso(getXmlAnomalia(), richiesta);
             StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "mod_"+richiesta+"_previdenza.odt");
             //Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(FromPremium2Facile.getMock("U", 117), 807)), CrmProperties.getProperty("crm.services.temp.path"), "FromPremium_2_FacileED112011.pdf");

         } catch (GenericsException e)
         {
             LoggingUtils.error(e);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }


     private static String getXmlAnomalia(){

         String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Previdenza> <polizza> <fondoPensione> <dataCostituzione>1998-12-23T00:00:00+01:00</dataCostituzione> <IBAN>IT34S0343901600000001021650</IBAN> <cfPiva>10830461009</cfPiva> <denominazione>Fondo Pensione Fideuram - Fondo Pensione Aperto</denominazione> <iscrizioneAlbo>7</iscrizioneAlbo> <gestioneAmmVa>FIDEURAM VITA SPA VIA ENNIO QUIRINO VISCONTI 80 00198 ROMA</gestioneAmmVa> <tipologia>Fondo di tipo Finanziario</tipologia> </fondoPensione> <compagniaDiProvenienza> <titolo>Spett.le</titolo> <ragioneSociale>AXA MPS PREVIDENZA PER TE - FONDO PENSIONE APERTO</ragioneSociale> <indirizzo> <via>Via Aldo Fabrizi 9</via> <cap>00128</cap> <comune>ROMA</comune> <provincia>RM</provincia> <tel_fax></tel_fax> <eMail></eMail> </indirizzo> </compagniaDiProvenienza> <aderente> <titolo>Spett.le</titolo> <cognome>CRISTANTE</cognome> <nome>STEFANO</nome> <cf>CRSSFN68B24I403G</cf> </aderente> </polizza></Previdenza>";

         return xml;
     }
}