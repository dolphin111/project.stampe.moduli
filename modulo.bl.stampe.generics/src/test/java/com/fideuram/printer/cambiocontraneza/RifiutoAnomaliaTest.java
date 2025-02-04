package com.fideuram.printer.cambiocontraneza;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.utils.LoggingUtils;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 13/04/15
 * Time: 17.45
 * To change this template use File | Settings | File Templates.
 */
public class RifiutoAnomaliaTest {

    public static void main(String args[]){
        new RifiutoAnomaliaTest().testRifiuto();
    }

    public void testRifiuto(){
        try {

            LoggingUtils.info(getXmlAnomale());

            byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(getXmlAnomale(), 1012);
            StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "RifiutoInterventoDiAppendicite.odt");
        } catch (GenericsException e) {
            LoggingUtils.error(e);
        } catch (Exception e) {
            LoggingUtils.error(e);
        }
    }
    public static String getXmlAnomale(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza>\n" +
                "<dataRichiesta>2015-04-14T10:16:55.288+02:00</dataRichiesta>\n" +
                "<sollecito>false</sollecito>\n" +
                "<causale><causale>0</causale></causale>\n" +
                "<polizza>" +
                "    <numeroID>7300005</numeroID>\n" +
                "    <contraente>\n" +
                "         <titolo>Gentile Signor</titolo>\n" +
                "         <cognome>FUSCO</cognome>\n" +
                "         <nome>GIUSEPPE</nome>\n" +
                "         <cf>FSCGPP62A27G602T</cf>\n" +
                "         <indirizzo>" +
                "               <via>SANTA LUCIA 51/B</via>" +
                "               <cap>52043</cap>" +
                "               <comune>CASTIGLION FIORENTINO</comune>" +
                "               <provincia>AR</provincia>" +
                "               <tel_fax></tel_fax>" +
                "               <eMail></eMail>" +
                "         </indirizzo>\n" +
                "         <dataNascita>1962-01-27T00:00:00+01:00</dataNascita>\n" +
                "         <sesso>M</sesso>\n" +
                "    </contraente>\n" +
                "    <assicurato>\n" +
                "         <titolo>Gentile Signor</titolo>\n" +
                "         <cognome>FUSCO</cognome>\n" +
                "         <nome>GIUSEPPE</nome>\n" +
                "         <cf>FSCGPP62A27G602T</cf>\n" +
                "         <indirizzo>\n" +
                "            <via>SANTA LUCIA 51/B</via>\n" +
                "            <cap>52043</cap>\n" +
                "            <comune>CASTIGLION FIORENTINO</comune>\n" +
                "            <provincia>AR</provincia>\n" +
                "            <tel_fax></tel_fax>\n" +
                "            <eMail></eMail>\n" +
                "         </indirizzo>\n" +
                "         <dataNascita>1962-01-27T00:00:00+01:00</dataNascita>\n" +
                "         <sesso>M</sesso>\n" +
                "   </assicurato>\n" +
                "   <pb>\n" +
                "       <titolo>Gentile Signor</titolo>\n" +
                "       <cognome>ROGGI</cognome>\n" +
                "       <nome>GIUSEPPE</nome>\n" +
                "       <cf>RGGGPP61T02C319P</cf>\n" +
                "       <indirizzo>\n" +
                "           <via>VIA MARTIRI DI CIVITELLA 3 </via>\n" +
                "           <cap>52100</cap>\n" +
                "           <comune>AREZZO </comune>\n" +
                "           <provincia>AR</provincia>\n" +
                "           <tel_fax></tel_fax>\n" +
                "           <eMail></eMail>\n" +
                "       </indirizzo>\n" +
                "       <dataNascita>1961-12-02T00:00:00+01:00</dataNascita>\n" +
                "       <sesso>M</sesso>\n" +
                "   </pb>\n" +
                "</polizza>\n" +
                "<passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza>\n" +
                "</CambioContraenza>";
    }
}
