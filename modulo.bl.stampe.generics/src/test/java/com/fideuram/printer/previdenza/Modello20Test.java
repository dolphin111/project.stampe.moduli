package com.fideuram.printer.previdenza;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by V801068 on 04/06/14.
 */
public class Modello20Test extends ModelloTest{
    public static void main(String args[]){

        //new ModelloTest().test(1107, Modello4_5_6_7Mock.getPrevidenzaMock());
        new Modello20Test().test(1120);
    }

    public void test(int richiesta){
        try {

            LoggingUtils.info(getXmlAnomalia());
            byte[] b= (byte[])  new ControllerActionsGenerics().elaboraProcesso(getXmlAnomalia(), richiesta);
            StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "mod_"+richiesta+"_previdenza.odt");
            
            LoggingUtils.info("Fine");

        } catch (GenericsException e)
        {
            LoggingUtils.error(e);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String getXmlAnomalia(){

        /*String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>"
        		+ "<Previdenza>"
        		+ "<primaIscrizione>2016-11-17T10:02:17.456+01:00</primaIscrizione>"
        		+ "<primaLiquidabilita>2016-11-17T10:02:17.456+01:00</primaLiquidabilita>"
        		+ "<polizza>"
        		+ "	<fondoPensione>"
        		+ "	<tipoLiquidazione>Prestito</tipoLiquidazione>"
        		+ "	</fondoPensione>"
				+ "	<denominazione>Fondo Pensione Fideuram</denominazione>"
        		+ "	<numeroID>70004951406</numeroID>"
        		+ "	<assicurato><titolo>Gentile Signor</titolo><cognome>MONDINI</cognome><nome>PIETRO MASSIMO</nome><cf>MNDPRM82D04D150P</cf><indirizzo><via>PZZA ROMA 7</via><cap>26100</cap><comune>CREMONA</comune><provincia>CR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1982-04-04T00:00:00+02:00</dataNascita><sesso>M</sesso></assicurato><aderente><titolo>Gentile Signor</titolo><cognome>MONDINI</cognome><nome>PIETRO MASSIMO</nome><cf>MNDPRM82D04D150P</cf><indirizzo><via>PZZA ROMA 7</via><cap>26100</cap><comune>CREMONA</comune><provincia>CR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1982-04-04T00:00:00+02:00</dataNascita><sesso>M</sesso></aderente><pb><titolo>Gentile Signor</titolo><cognome>SOSSI</cognome><nome>DIEGO</nome><cf>SSSDGI72M12D150Q</cf><indirizzo><via>VIA DANTE, 104/A                                  </via><cap>26100</cap><comune>CREMONA                  </comune><provincia>CR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1972-08-12T00:00:00+01:00</dataNascita><sesso>M</sesso></pb>"
        		+ "</polizza>"
        		+ "<liquidazione><tipoLiquidazione>0</tipoLiquidazione>"
        		+ "<dataRichiesta>2016-11-09T00:00:00+01:00</dataRichiesta>"
        		+ "<dataPagamento>2016-11-17T10:02:17.456+01:00</dataPagamento>"        		
        		+ "</liquidazione>"
        		+ "<documentazione>"
        		+ "	<sollecito>false</sollecito>"
        		+ " <ultimoSollecito>false</ultimoSollecito>"
        		+ "	<docIntegrativaAderente>Copia dell'atto notarile di compravendita</docIntegrativaAderente>"
        		+ "	<docIntegrativaAderente>Copia della/e fattura/e che attesta il pagamento degli oneri effettivamente sostenuti</docIntegrativaAderente>"
        		+ "</documentazione>"
        		+ "<richiesta><data>2016-11-09T00:00:00+01:00</data></richiesta>"
        		+ "</Previdenza>";*/
    	String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Previdenza><primaIscrizione>2016-12-01T11:22:56.006+01:00</primaIscrizione><primaLiquidabilita>2016-12-01T11:22:56.006+01:00</primaLiquidabilita><polizza><fondoPensione><denominazione>Fondo Pensione Fideuram</denominazione></fondoPensione><compagniaDiDestinazione><titolo>Spett.le</titolo><indirizzo><via>VIA NAPOLI, 1</via><cap>20813</cap><comune>BOVISIO MASCIAGO</comune><provincia>MB</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo></compagniaDiDestinazione><tipoLiquidazione>Prestito</tipoLiquidazione><numeroID>90001652111</numeroID><assicurato><titolo>Gentile Signora</titolo><cognome>BUFFAGNI</cognome><nome>FRANCA</nome><cf>BFFFNC44T55L831T</cf><indirizzo><via>VIA CALATAFIMI 9 5</via><cap>42020</cap><comune>MONTECAVOLO</comune><provincia>RE</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1944-12-15T00:00:00+01:00</dataNascita><sesso>F</sesso></assicurato><aderente><titolo>Gentile Signora</titolo><cognome>BUFFAGNI</cognome><nome>FRANCA</nome><cf>BFFFNC44T55L831T</cf><indirizzo><via>VIA CALATAFIMI 9 5</via><cap>42020</cap><comune>MONTECAVOLO</comune><provincia>RE</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1944-12-15T00:00:00+01:00</dataNascita><sesso>F</sesso></aderente><pb><titolo>Gentile Signora</titolo><cognome>LAZZARETTI</cognome><nome>FEDERICA</nome><cf>LZZFRC59L71H223R</cf><indirizzo><via>VIA LUIGI SANI 13 13 A </via><cap>42121</cap><comune>REGGIO EMILIA </comune><provincia>RE</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1959-07-31T00:00:00+01:00</dataNascita><sesso>F</sesso></pb></polizza><liquidazione><tipoLiquidazione>0</tipoLiquidazione><dataRichiesta>2014-10-04T11:20:05.393+02:00</dataRichiesta><dataPagamento>2015-01-20T00:00:00+01:00</dataPagamento></liquidazione><documentazione><sollecito>false</sollecito><ultimoSollecito>false</ultimoSollecito><docIntegrativaAderente>copia della/e fattura/e che attestano il pagamento degli oneri effettivamente sostenuti </docIntegrativaAderente></documentazione><richiesta><data>2014-10-04T11:20:05.393+02:00</data></richiesta></Previdenza>";

        return xml;
    }
}
