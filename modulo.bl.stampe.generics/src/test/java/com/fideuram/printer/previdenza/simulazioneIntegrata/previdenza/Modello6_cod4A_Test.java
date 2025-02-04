package com.fideuram.printer.previdenza.simulazioneIntegrata.previdenza;

import com.fideuram.decoder.MapperProcessiCrm;
import com.fideuram.printer.previdenza.ModelloTest;
import com.fideuram.utils.LoggingUtils;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 02/09/14
 * Time: 17.34
 * To change this template use File | Settings | File Templates.
 */
public class Modello6_cod4A_Test {
    public static void main(String args[]){
        int processo=MapperProcessiCrm.decodeProcess("4.A");
        LoggingUtils.info("template loading "+processo);
        new ModelloTest().test(processo, Modello6_cod4A_Test.getXml());
    }

    public static String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><Previdenza><primaIscrizione>2014-09-02T15:44:49.706+02:00</primaIscrizione><primaLiquidabilita>2014-09-02T15:44:49.706+02:00</primaLiquidabilita><polizza><numeroID>90014220410</numeroID><assicurato><titolo>Gentile Signor</titolo><cognome>BARSOCCHI</cognome><nome>ALFREDO</nome><indirizzo><via>CSO TE BIANCALANA N 8</via><cap>55100</cap><comune>LUCCA</comune><provincia>LU</provincia></indirizzo><dataNascita>1956-04-05T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><aderente><titolo>Gentile Signor</titolo><cognome>BARSOCCHI</cognome><nome>ALFREDO</nome><indirizzo><via>CSO TE BIANCALANA N 8</via><cap>55100</cap><comune>LUCCA</comune><provincia>LU</provincia></indirizzo><dataNascita>1956-04-05T00:00:00+01:00</dataNascita><sesso>M</sesso></aderente><pb><titolo>Gentile Signor</titolo><cognome>VILLANI</cognome><nome>ENRICO</nome><indirizzo><via>VIA CASTRACANI 194                                </via><cap>55100</cap><comune>LUCCA                    </comune><provincia>LU</provincia></indirizzo><dataNascita>1958-08-10T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><convenzione><titolo>Fondo Pensione Fideuram</titolo></convenzione><liquidazione><tipoLiquidazione>0</tipoLiquidazione><dataRichiesta>2014-09-02T15:44:51.309+02:00</dataRichiesta></liquidazione><documentazione><docIntegrativa>Riga di esempio documentazione mancante ben fatto</docIntegrativa><docIntegrativa>fotocopia fronte retro doc. d'identità</docIntegrativa><docIntegrativa>dichiarazione fiscale del datore di lavoro (*)</docIntegrativa><docIntegrativa>stato di famiglia ovvero certificato anagrafico con l'indicazione della paternità e della maternità dei figli ovvero dichiarazione sostitutiva di atto notorio autenticata dei medesimi certificati</docIntegrativa><docIntegrativa>informativa sul trattamento dei dati personali di cui all'art.13 del D, Lgs. 196/2003 compilata e sottoscritta dal coniuge o dai figli</docIntegrativa><docIntegrativa>attestazione di una struttura pubblica che dichiari che le terapie e gli interventi rivestono carattere di straordinarietà a seguito di gravissime situazioni</docIntegrativa><docIntegrativa>fatture o ricevute o altra documentazione attestante gli oneri effettivamente sosytenuti ovvero, in assenza, preventivi di spesa, fermo restando l'obbligo di inviare copia delle fatture definitive non appena disponibili e comunque non oltre 12 mesi dall'erogazione della somma</docIntegrativa><sollecito>true</sollecito></documentazione></Previdenza>";
    }
}
