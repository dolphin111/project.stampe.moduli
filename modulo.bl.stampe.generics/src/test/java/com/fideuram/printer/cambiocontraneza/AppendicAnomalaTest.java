package com.fideuram.printer.cambiocontraneza;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.utils.LoggingUtils;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 09/04/15
 * Time: 11.21
 */
public class AppendicAnomalaTest {
    public static void main(String args[]){
        new AppendicAnomalaTest().testeppendice();
    }

    public void testeppendice(){
        try {

            LoggingUtils.info(getXml());


           //byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(getXml(), 1001);
            byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(getXml(), 1010);
            StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "Appendicite.odt");
        } catch (GenericsException e) {
            LoggingUtils.error(e);
        } catch (Exception e) {
            LoggingUtils.error(e);
        }
    }

    private String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2016-01-25T16:42:00.873+01:00</dataRichiesta><sollecito>false</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7469937</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>SCATTOLIN</cognome><nome>RINO</nome><cf>SCTRNI23D16F269L</cf><indirizzo><via>VIA MAMELI</via><cap>31021</cap><comune>MOGLIANO VENETO</comune><provincia>TV</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1923-04-16T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>SCATTOLIN</cognome><nome>SANDRO</nome><cf>SCTSDR73A03L407F</cf><indirizzo><via>VIA MAMELI</via><cap>31021</cap><comune>MOGLIANO VENETO</comune><provincia>TV</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1973-01-03T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Spett.le</titolo></pb></polizza><docIntgrativa> Modulo Cambio Contraenza</docIntgrativa><docIntgrativa>Integrazione dati di  Adeguata Verifica mod.022090/200720-12.2014 relativa al contraente in entrata – Persona Fisica (mini qav)</docIntgrativa><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></CambioContraenza>";
    }
}
