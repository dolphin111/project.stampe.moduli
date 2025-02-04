package com.fideuram.printer.previdenza;


import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.stampe.modello.previdenza.versamenti.VersamentiPrevidenza;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * User: V801068
 * Date: 23/07/14
 * Time: 10.35
 */
public class Modello18Test extends ModelloTest
{

    public static void main(String args[]){
        new Modello18Test().test(1118);
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

//    public static void main(String args[]){


        //new ModelloTest().test(1118, Modello18Mock.getPrevidenzaMock());
    //}

    private static String getXmlAnomalia(){

        //String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Previdenza><primaIscrizione>2016-09-08T12:29:16.571+02:00</primaIscrizione><primaLiquidabilita>2016-09-08T12:29:16.571+02:00</primaLiquidabilita><polizza><fondoPensione><denominazione>Fondo Pensione Fideuram</denominazione></fondoPensione><numeroID>90004037510</numeroID><assicurato><titolo>Gentile Signor</titolo><cognome>FLORIO</cognome><nome>REMO</nome><cf>FLRRME66L05D086G</cf><indirizzo><via>VIA POPILIA 78 D</via><cap>87100</cap><comune>COSENZA</comune><provincia>CS</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1966-07-05T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><aderente><titolo>Gentile Signor</titolo><cognome>FLORIO</cognome><nome>REMO</nome><cf>FLRRME66L05D086G</cf><indirizzo><via>VIA POPILIA 78 D</via><cap>87100</cap><comune>COSENZA</comune><provincia>CS</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1966-07-05T00:00:00+01:00</dataNascita><sesso>M</sesso></aderente><pb><titolo>Spett.le</titolo></pb></polizza><liquidazione><tipoLiquidazione>0</tipoLiquidazione><dataRichiesta>2016-07-08T00:00:00+02:00</dataRichiesta></liquidazione><documentazione><sollecito>false</sollecito><ultimoSollecito>false</ultimoSollecito><docIntegrativa>Conferma che il Vostro fondo rientra nelle categorie disciplinate dal D. Lgs. n. 252 del 13/12/2005;</docIntegrativa><docIntegrativa>Indicazione delle coordinate bancarie (codice IBAN) necessarie per il bonifico.</docIntegrativa><docIntegrativaAderente>Indicazione dell\u0092ultimo contributo che verr\u00E1 versato nel fondo dall\u0092aderente e/o dall\u0092Ente datore di lavoro.</docIntegrativaAderente><docIntegrativaAderente>Documento d\u0092identit\u00E1 dell\u0092aderente</docIntegrativaAderente><docIntegrativaAderente>Causale di trasferimento</docIntegrativaAderente></documentazione><richiesta><data>2016-07-08T00:00:00+02:00</data></richiesta></Previdenza>";
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Previdenza><primaIscrizione>2017-04-03T09:46:15.533+02:00</primaIscrizione><primaLiquidabilita>2017-04-03T09:46:15.533+02:00</primaLiquidabilita><polizza><fondoPensione><denominazione>Fondo Pensione Fideuram</denominazione></fondoPensione><numeroID>90003852203</numeroID><assicurato><titolo>Gentile Signor</titolo><cognome>SAJJADI</cognome><nome>MIRALI</nome><cf>SJJMRL59C22Z224S</cf><indirizzo><via>V. FRANCESCO P. MICHETTI, 1</via><cap>67100</cap><comune>L'AQUILA</comune><provincia>AQ</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1959-03-22T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><aderente><titolo>Gentile Signor</titolo><cognome>SAJJADI</cognome><nome>MIRALI</nome><cf>SJJMRL59C22Z224S</cf><indirizzo><via>V. FRANCESCO P. MICHETTI, 1</via><cap>67100</cap><comune>L'AQUILA</comune><provincia>AQ</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1959-03-22T00:00:00+01:00</dataNascita><sesso>M</sesso></aderente><pb><titolo>Gentile Signora</titolo><cognome>CIALFI</cognome><nome>DANIELA</nome><cf>CLFDNL76L65A345D</cf><indirizzo><via>VIA CARDINAL MAZZARINO 82 </via><cap>67100</cap><comune>L' AQUILA </comune><provincia>AQ</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1976-07-25T00:00:00+01:00</dataNascita><sesso>F</sesso></pb></polizza><liquidazione><tipoLiquidazione>0</tipoLiquidazione><dataRichiesta>2017-02-10T00:00:00+01:00</dataRichiesta></liquidazione><documentazione><sollecito>false</sollecito><ultimoSollecito>false</ultimoSollecito><docIntegrativa>Conferma che il nominativo in oggetto sia vostro iscritto</docIntegrativa><docIntegrativa>Conferma che il Vostro fondo rientra nelle categorie disciplinate dal D. Lgs. n. 252 del 13/12/2005;</docIntegrativa><docIntegrativa>Indicazione delle coordinate bancarie (codice IBAN) necessarie per il bonifico.</docIntegrativa><docIntegrativaAderente>Indicazione dell’ultimo contributo che verrà versato nel fondo dall’aderente e/o dall’Ente datore di lavoro.</docIntegrativaAderente></documentazione><richiesta><data>2017-02-10T00:00:00+01:00</data></richiesta></Previdenza>";

        return xml;
    }
}