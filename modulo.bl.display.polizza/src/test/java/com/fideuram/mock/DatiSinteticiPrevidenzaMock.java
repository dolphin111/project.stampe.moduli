package com.fideuram.mock;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 19.14
 */
public class DatiSinteticiPrevidenzaMock {
    public static String getXml(){
       String s = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
               "<polizza>" +
               "    <dataElaborazione>2013-04-09</dataElaborazione>" +
               "    <datiTecnici>" +
               "        <numeroPolizza>90000002701</numeroPolizza>" +
               "        <codiceConferimento>00002790001</codiceConferimento>" +
               "        <stato>Attiva</stato>" +
               "        <sottostato>ATTIVA</sottostato>" +
               "        <prodotto>" +
               "            <codice>90   </codice>" +
               "            <descrizione>FONDO PENSIONE FIDEURAM</descrizione>" +
               "        </prodotto>" +
               "        <tariffa>" +
               "            <codice>F60</codice>" +
               "            <descrizione>Previdenza</descrizione>" +
               "        </tariffa>" +
               "        <ramoMinisteriale>6</ramoMinisteriale>" +
               "        <tipoPrestazione>R</tipoPrestazione>" +
               "        <tipoPolizza>A</tipoPolizza>" +
               "        <dataEmissione>1999-03-15</dataEmissione>" +
               "        <dataScadenza>2100-12-31</dataScadenza>" +
               "        <reteVendita>BFI</reteVendita>" +
               "    </datiTecnici>" +
               "    <figureContrattuali>" +
               "       <dataFineBeneficiarioMorte>2006-12-01</dataFineBeneficiarioMorte>     \n"+
               "       <dataInizioBeneficiarioMorte>1999-12-23</dataInizioBeneficiarioMorte> \n"+
               "       <isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita>   \n"+
               "       <isAttivoBeneficiarioMorte>false</isAttivoBeneficiarioMorte>\n"+
               "        <datoreDiLavoro>\n" +
               "            <personaFisica>\n" +
               "                <cognome>DELUCA</cognome>\n" +
               "                <nome>MICHELE</nome>\n" +
               "                <codicefiscale>DLCMHL61P13A669C</codicefiscale>\n" +
               "                <datanascita>1961-09-13</datanascita>\n" +
               "                <sesso>M</sesso>\n" +
               "                <vip>false</vip>\n" +
               "            </personaFisica>\n" +
               "        </datoreDiLavoro>\n" +
               "        <contraente>" +
               "            <personaFisica>" +
               "                <cognome>BORIN</cognome>" +
               "                <nome>DANIELE</nome>" +
               "                <codicefiscale>BRNDNL49D21B132D</codicefiscale>" +
               "                <datanascita>1949-04-21</datanascita>" +
               "                <sesso>M</sesso>" +
               "                <vip>false</vip>" +
               "            </personaFisica>" +
               "        </contraente>" +
               "        <primoAssicurato>" +
               "            <personaFisica>" +
               "                <cognome>BORIN</cognome>" +
               "                <nome>DANIELE</nome>" +
               "                <codicefiscale>BRNDNL49D21B132D</codicefiscale>" +
               "                <datanascita>1949-04-21</datanascita>" +
               "                <sesso>M</sesso>" +
               "                <vip>false</vip>" +
               "            </personaFisica>" +
               "        </primoAssicurato>" +
               "        <secondoAssicurato/>" +
               "        <beneficiarioVita>L' Assicurato</beneficiarioVita>"+
               "        <beneficiarioMorte>Eredi testamentari o legittimi dell' Assicurato</beneficiarioMorte>"+
               "        <indirizzoContratto>" +
               "            <tipoIndirizzo>POSTALE</tipoIndirizzo>" +
               "            <indirizzo>VIA CASTELLETTO, 113</indirizzo>" +
               "            <cap>36042</cap>" +
               "            <comune>BREGANZE</comune>" +
               "            <provincia>VI</provincia>" +
               "            <regione></regione>" +
               "            <nazione>IT</nazione>" +
               "            <dataAggiornamento>1900-01-01</dataAggiornamento>" +
               "        </indirizzoContratto>" +
               "        <rol>" +
               "            <codiceStato>0</codiceStato>" +
               "        </rol>" +
               "        <banker>" +
               "            <privateBanker>" +
               "                <cognome>BORIN</cognome>" +
               "                <nome>DANIELE</nome>" +
               "                <codicefiscale>BRNDNL49D21B132D</codicefiscale>" +
               "                <datanascita>1949-04-21</datanascita>" +
               "                <sesso>M</sesso>" +
               "                <vip>false</vip>" +
               "            </privateBanker>" +
               "            <dataInizio>1987-12-30</dataInizio>" +
               "            <stato>Attivo</stato>" +
               "            <livello>Private Banker</livello>" +
               "        </banker>" +
               "    </figureContrattuali>" +
               "    <prestazioni>" +
               "        <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>" +
               "        <importoBonusFvInsieme>0.0</importoBonusFvInsieme>" +
               "        <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>" +
               "        <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>" +
               "        <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>" +
               "        <eccedenza>0.0</eccedenza>" +
               "        <opzioni xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>" +
               "        <Bonus>" +
               "            <BonusFacile>" +
               "                <bonusMaturatoGiornaliero>5.95</bonusMaturatoGiornaliero>" +
               "                <dataRiferimentoGiornaliero>2013-04-09</dataRiferimentoGiornaliero>" +
               "                <bonusIQuinquennio>50000.0</bonusIQuinquennio>" +
               "                <dataRiferimentoIQuinquennio>2018-04-01</dataRiferimentoIQuinquennio>" +
               "                <bonusIIQuinquennio>10000.0</bonusIIQuinquennio>" +
               "                <dataRiferimentoIIQuinquennio>2023-04-01</dataRiferimentoIIQuinquennio>" +
               "            </BonusFacile>" +
               "        </Bonus>" +
               "    </prestazioni>" +
               "    <previdenza>" +
               "        <importoContributi>43837.66</importoContributi>" +
               "        <importoAnticipazione>0.0</importoAnticipazione>" +
               "        <valorePosizioneIndividuale>49903.2781</valorePosizioneIndividuale>" +
               "        <contributiNonDedotti>0.0</contributiNonDedotti>" +
               "        <dataIngressoSistemaPrevidenziale>1999-03-11</dataIngressoSistemaPrevidenziale>" +
               "        <dataAdesioneFondo>1999-03-15</dataAdesioneFondo>" +
               "        <dataUltimoSwitch>2011-01-05</dataUltimoSwitch>" +
               "        <movimentiEventiPrevidenza>" +
               "            <movimentoPrevidenza>" +
               "                <dataOperazione>2012-12-18</dataOperazione>" +
               "                <dataQuota>2012-12-31</dataQuota>" +
               "                <causale>Contributo</causale>" +
               "                <costi>0.0</costi>" +
               "                <iscritto>1720.0</iscritto>" +
               "                <datore>0.0</datore>" +
               "                <tfr>0.0</tfr>" +
               "                <totale>1720.0</totale>" +
               "            </movimentoPrevidenza>" +
               "            <movimentoPrevidenza>" +
               "                <dataOperazione>2012-08-10</dataOperazione>" +
               "                <dataQuota>2012-08-31</dataQuota>" +
               "                <causale>Contributo</causale>" +
               "                <costi>0.0</costi>" +
               "                <iscritto>430.0</iscritto>" +
               "                <datore>0.0</datore>" +
               "                <tfr>0.0</tfr>" +
               "                <totale>430.0</totale>" +
               "            </movimentoPrevidenza>" +
               "            <movimentoPrevidenza>" +
               "                <dataOperazione>2012-07-10</dataOperazione>" +
               "                <dataQuota>2012-07-31</dataQuota>" +
               "                <causale>Contributo</causale>" +
               "                <costi>0.0</costi>" +
               "                <iscritto>430.0</iscritto>" +
               "                <datore>0.0</datore>" +
               "                <tfr>0.0</tfr>" +
               "                <totale>430.0</totale>" +
               "            </movimentoPrevidenza>" +
               "            <movimentoPrevidenza>" +
               "                <dataOperazione>2012-06-11</dataOperazione>" +
               "                <dataQuota>2012-06-29</dataQuota>" +
               "                <causale>Contributo</causale>" +
               "                <costi>0.0</costi>" +
               "                <iscritto>430.0</iscritto>" +
               "                <datore>0.0</datore>" +
               "                <tfr>0.0</tfr>" +
               "                <totale>430.0</totale>" +
               "            </movimentoPrevidenza>" +
               "            <movimentoPrevidenza>" +
               "                <dataOperazione>2012-05-10</dataOperazione>" +
               "                <dataQuota>2012-05-31</dataQuota>" +
               "                <causale>Contributo</causale>" +
               "                <costi>0.0</costi>" +
               "                <iscritto>430.0</iscritto>" +
               "                <datore>0.0</datore>" +
               "                <tfr>0.0</tfr>" +
               "                <totale>430.0</totale>" +
               "            </movimentoPrevidenza>" +
               "            <movimentoPrevidenza>" +
               "                <dataOperazione>2012-04-11</dataOperazione>" +
               "                <dataQuota>2012-04-30</dataQuota>" +
               "                <causale>Contributo</causale>" +
               "                <costi>0.0</costi>" +
               "                <iscritto>430.0</iscritto>" +
               "                <datore>0.0</datore>" +
               "                <tfr>0.0</tfr>" +
               "                <totale>430.0</totale>" +
               "            </movimentoPrevidenza>" +
               "        </movimentiEventiPrevidenza>" +
               "        <riepilogoPrevidenza>" +
               "            <riepilogo>" +
               "                <descrizioneComparto>FIDEURAM EQUILIBRIO</descrizioneComparto>" +
               "                <importoContributi>10710.0</importoContributi>" +
               "                <importoAnticipazione>0.0</importoAnticipazione>" +
               "                <importoSwitch>34455.86</importoSwitch>" +
               "                <numeroQuote>3152.848</numeroQuote>" +
               "                <valoreQuota>15.828</valoreQuota>" +
               "                <valorePosizioneIndividuale>49903.2781</valorePosizioneIndividuale>" +
               "            </riepilogo>" +
               "            <riepilogo>" +
               "                <descrizioneComparto>FIDEURAM CRESCITA</descrizioneComparto>" +
               "                <importoContributi>33127.66</importoContributi>" +
               "                <importoAnticipazione>0.0</importoAnticipazione>" +
               "                <importoSwitch>-34455.86</importoSwitch>" +
               "                <numeroQuote>0.0</numeroQuote>" +
               "                <valoreQuota>0.0</valoreQuota>" +
               "                <valorePosizioneIndividuale>0.0</valorePosizioneIndividuale>" +
               "            </riepilogo>" +
               "        </riepilogoPrevidenza>" +
               "    </previdenza>" +
               "</polizza>"  ;

        return s;
    }
}
