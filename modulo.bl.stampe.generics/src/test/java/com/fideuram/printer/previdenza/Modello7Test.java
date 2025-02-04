package com.fideuram.printer.previdenza;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by V801068 on 04/06/14.
 */
public class Modello7Test extends ModelloTest{
    public static void main(String args[]){

        //new ModelloTest().test(1107, Modello4_5_6_7Mock.getPrevidenzaMock());
        new Modello7Test().test(1107);
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

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Previdenza><primaIscrizione>2016-11-17T10:02:17.456+01:00</primaIscrizione><primaLiquidabilita>2016-11-17T10:02:17.456+01:00</primaLiquidabilita><polizza><fondoPensione><denominazione>Fondo Pensione Fideuram</denominazione></fondoPensione><numeroID>70004951406</numeroID><assicurato><titolo>Gentile Signor</titolo><cognome>MONDINI</cognome><nome>PIETRO MASSIMO</nome><cf>MNDPRM82D04D150P</cf><indirizzo><via>PZZA ROMA 7</via><cap>26100</cap><comune>CREMONA</comune><provincia>CR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1982-04-04T00:00:00+02:00</dataNascita><sesso>M</sesso></assicurato><aderente><titolo>Gentile Signor</titolo><cognome>MONDINI</cognome><nome>PIETRO MASSIMO</nome><cf>MNDPRM82D04D150P</cf><indirizzo><via>PZZA ROMA 7</via><cap>26100</cap><comune>CREMONA</comune><provincia>CR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1982-04-04T00:00:00+02:00</dataNascita><sesso>M</sesso></aderente><pb><titolo>Gentile Signor</titolo><cognome>SOSSI</cognome><nome>DIEGO</nome><cf>SSSDGI72M12D150Q</cf><indirizzo><via>VIA DANTE, 104/A                                  </via><cap>26100</cap><comune>CREMONA                  </comune><provincia>CR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1972-08-12T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><liquidazione><tipoLiquidazione>0</tipoLiquidazione><dataRichiesta>2016-11-09T00:00:00+01:00</dataRichiesta></liquidazione><documentazione><sollecito>false</sollecito><ultimoSollecito>false</ultimoSollecito><docIntegrativaAderente>Fotocopia fronte retro doc. d'identità</docIntegrativaAderente></documentazione><richiesta><data>2016-11-09T00:00:00+01:00</data></richiesta></Previdenza>";

        return xml;
    }
}
