package com.fideuram.printer.preventivo;

import com.fideuram.exception.GenericsException;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.utils.LoggingUtils;


/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 05/08/14
 * Time: 18.33
 *
 */
public class Preventivo950Test {
    public static void main(String args[]){
    	// new Preventivo950Test().test(950);
        new Preventivo950Test().test(1127);
    }


    public void test(int richiesta){
        try {
            String xml = getXmlMockAnomalo();
            LoggingUtils.info(xml);
            new ControllerActionsGenerics().elaboraProcesso(xml, richiesta);
        } catch (GenericsException e) {
            LoggingUtils.error(e);
        }
    }
    
    private String getXmlMockAnomalo(){
      return "<Preventivo>\n" +
              "    <comunicazione>\n" +
              "        <cittaEmissione>Roma</cittaEmissione>\n" +
              "        <protocollo>I/17327/13</protocollo>\n" +
              "    </comunicazione>\n" +
              "    <prodotto>\n" +
              "        <codice>RS0U2</codice>\n" +
              "        <descrizione>Fideuram Vita Insieme</descrizione>\n" +
              "        <famigliaProdotto>\n" +
              "            <codice>1</codice>\n" +
              "            <descrizione>Fideuram Vita Insieme</descrizione>\n" +
              "        </famigliaProdotto>\n" +
              "    </prodotto>\n" +
              "    <assicurato>\n" +
              "        <titolo>Gentile Signor</titolo>\n" +
              "        <nome>CESARITTI ANNA MARIA</nome>\n" +
              "        <indirizzo>\n" +
              "            <via>VIA CONSOLAZIONE COOP.ERNICA Q 3</via>\n" +
              "            <cap>03012</cap>\n" +
              "            <comune>ANAGNI</comune>\n" +
              "            <provincia>FR</provincia>\n" +
              "        </indirizzo>\n" +
              "        <dataNascita>1956-07-06T00:00:00+01:00</dataNascita>\n" +
              "        <sesso>m</sesso>\n" +
              "    </assicurato>\n" +
              "    <rateo>\n" +
              "        <durataMinima>10</durataMinima>\n" +
              "        <decorrenza>2013-08-06T00:00:00+02:00</decorrenza>\n" +
              "        <decumulo>0</decumulo>\n" +
              "    </rateo>\n" +
              "    <vitalizio>\n" +
              "        <dataRiferimento>2024-08-06T00:00:00+02:00</dataRiferimento>\n" +
              "        <renditaAnnua>251100.43</renditaAnnua>\n" +
              "        <importoRendita>14400</importoRendita>\n" +
              "    </vitalizio>\n" +
              "</Preventivo>\n";
    }

  
    private String getXnlMock(){
        return "<Preventivo>\n" +
                "    <comunicazione>\n" +
                "        <cittaEmissione>Roma</cittaEmissione>\n" +
                "        <protocollo>I/17324/13</protocollo>\n" +
                "    </comunicazione>\n" +
                "    <prodotto>\n" +
                "        <codice>RS0U2</codice>\n" +
                "        <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                "        <famigliaProdotto>\n" +
                "            <codice>1</codice>\n" +
                "            <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                "        </famigliaProdotto>\n" +
                "    </prodotto>\n" +
                "    <assicurato>\n" +
                "        <titolo>Gentile Signor</titolo>\n" +
                "        <nome>CESARITTI ANNA MARIA</nome>\n" +
                "        <indirizzo>\n" +
                "            <via>VIA CONSOLAZIONE COOP.ERNICA Q 3</via>\n" +
                "            <cap>03012</cap>\n" +
                "            <comune>ANAGNI</comune>\n" +
                "            <provincia>FR</provincia>\n" +
                "        </indirizzo>\n" +
                "        <dataNascita>1960-07-01T00:00:00+01:00</dataNascita>\n" +
                "        <sesso>m</sesso>\n" +
                "    </assicurato>\n" +
                "    <rateo>\n" +
                "        <importoPremio>100000.00</importoPremio>\n" +
                "        <durataMinima>10</durataMinima>\n" +
                "        <decorrenza>2013-08-05T00:00:00+02:00</decorrenza>\n" +
                "        <decumulo>0</decumulo>\n" +
                "    </rateo>\n" +
                "    <vitalizio>\n" +
                "        <dataRiferimento>2024-08-05T00:00:00+02:00</dataRiferimento>\n" +
                "        <renditaAnnua>5087.59</renditaAnnua>\n" +
                "    </vitalizio>\n" +
                "</Preventivo>";
    }
}
