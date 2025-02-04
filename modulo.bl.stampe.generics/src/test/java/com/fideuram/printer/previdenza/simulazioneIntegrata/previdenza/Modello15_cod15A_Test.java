package com.fideuram.printer.previdenza.simulazioneIntegrata.previdenza;

import com.fideuram.decoder.MapperProcessiCrm;
import com.fideuram.printer.previdenza.ModelloTest;
import com.fideuram.utils.LoggingUtils;

/**
 * User: V801068
 * Date: 08/10/14
 * Time: 17.42
 */
public class Modello15_cod15A_Test {
    public static void main(String args[]){
        int processo= MapperProcessiCrm.decodeProcess("5.A");
        LoggingUtils.info("template loading " + processo);
        new ModelloTest().test(processo, Modello15_cod15A_Test.getXml());
    }

    public static String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Previdenza><primaIscrizione>2014-10-08T17:47:51.987+02:00</primaIscrizione><primaLiquidabilita>2014-10-08T17:47:51.987+02:00</primaLiquidabilita><polizza><fondoPensione><denominazione>Fondo Pensione Fideuram</denominazione></fondoPensione><compagniaDiDestinazione><titolo>Spett.le</titolo></compagniaDiDestinazione><numeroID>90017178011</numeroID><assicurato><titolo>Gentile Signor</titolo><cognome>BORACCHI</cognome><nome>ROBERTO</nome><indirizzo><via>VIA VESPUCCI, 24</via><cap>21013</cap><comune>GALLARATE</comune><provincia>VA</provincia></indirizzo><dataNascita>1940-10-07T00:00:00+02:00</dataNascita><sesso>M</sesso></assicurato><aderente><titolo>Gentile Signor</titolo><cognome>BORACCHI</cognome><nome>ROBERTO</nome><indirizzo><via>VIA VESPUCCI, 24</via><cap>21013</cap><comune>GALLARATE</comune><provincia>VA</provincia></indirizzo><dataNascita>1940-10-07T00:00:00+02:00</dataNascita><sesso>M</sesso></aderente><pb><titolo>Gentile Signor</titolo><cognome>VEZZARO</cognome><nome>GIOVANNI</nome><indirizzo><via>PZA TRENTO E TRIESTE 11 B                         </via><cap>21052</cap><comune>BUSTO ARSIZIO            </comune><provincia>VA</provincia></indirizzo><dataNascita>1952-08-25T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><liquidazione><tipoLiquidazione>0</tipoLiquidazione><dataRichiesta>2014-10-08T17:47:54.181+02:00</dataRichiesta></liquidazione><documentazione><sollecito>true</sollecito><docIntegrativa>dichiarazione fiscale del datore di lavoro (*)</docIntegrativa></documentazione><richiesta><data>2014-10-03T10:02:50.200+02:00</data></richiesta></Previdenza>";
    }
}
