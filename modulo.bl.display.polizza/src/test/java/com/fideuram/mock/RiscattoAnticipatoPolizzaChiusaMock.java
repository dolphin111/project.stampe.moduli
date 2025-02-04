package com.fideuram.mock;

/**
 * Created by
 * User: logan
 * Date: 12/04/13
 * Time: 16.25
 */
public class RiscattoAnticipatoPolizzaChiusaMock {
    public static String getXml(){

        String s="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizza>\n" +
                "    <dataElaborazione>2013-05-02</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>57108922</numeroPolizza>\n" +
                "        <codiceConferimento>108922ES008</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>ATTIVA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>IIAC1</codice>\n" +
                "            <descrizione>Invest Internazionale Premio Annuo</descrizione>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>22I</codice>\n" +
                "            <descrizione>Invest Internazionale Premio Annuo</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <tipoPrestazione>R</tipoPrestazione>\n" +
                "        <tipoPolizza>C</tipoPolizza>\n" +
                "        <dataEmissione>1997-11-01</dataEmissione>\n" +
                "        <dataScadenza>2017-11-01</dataScadenza>\n" +
                "        <reteVendita>SPI</reteVendita>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>MONTI</cognome>\n" +
                "                <nome>MARIA ROSA</nome>\n" +
                "                <codicefiscale>MNTMRS70S45F704E</codicefiscale>\n" +
                "                <datanascita>1970-11-05</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>MONTI</cognome>\n" +
                "                <nome>MARIA ROSA</nome>\n" +
                "                <codicefiscale>MNTMRS70S45F704E</codicefiscale>\n" +
                "                <datanascita>1970-11-05</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <beneficiarioVita>IL CONTRAENTE</beneficiarioVita>\n" +
                "        <beneficiarioMorte>IL FRATELLO ROBERTO MONTI</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>Postale</tipoIndirizzo>\n" +
                "            <indirizzo>V. L.CRISTOFORO COLOMBO, 4</indirizzo>\n" +
                "            <cap>21027</cap>\n" +
                "            <comune>ISPRA</comune>\n" +
                "            <provincia>VA</provincia>\n" +
                "            <regione>Manca</regione>\n" +
                "            <nazione>IT</nazione>\n" +
                "            <dataAggiornamento>2005-07-08</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>GUALTIERI</cognome>\n" +
                "                <nome>GIORGIO</nome>\n" +
                "                <codicefiscale>GLTGRG52L19I690E</codicefiscale>\n" +
                "                <datanascita>1952-07-19</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <dataInizio>1987-07-14</dataInizio>\n" +
                "            <stato>Attivo</stato>\n" +
                "            <livello>Private Banker</livello>\n" +
                "        </banker>\n" +
                "    </figureContrattuali>\n" +
                "    <prestazioni>\n" +
                "        <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>\n" +
                "        <importoBonusFvInsieme>0.0</importoBonusFvInsieme>\n" +
                "        <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>\n" +
                "        <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                "        <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>\n" +
                "        <eccedenza>0.0</eccedenza>\n" +
                "        <opzioni xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
                "        <simulazioniPrestazioniAssicurate>\n" +
                "            <eccedenza>0.0</eccedenza>\n" +
                "            <riscattoLordo>21110.08</riscattoLordo>\n" +
                "        </simulazioniPrestazioniAssicurate>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>0.0</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "        <dataFinePagamentoPremi>2016-11-01</dataFinePagamentoPremi>\n" +
                "    </contabile>\n" +
                "    <altriDati>\n" +
                "        <vincolo>\n" +
                "            <attivo>false</attivo>\n" +
                "        </vincolo>\n" +
                "        <decumuloCedola>\n" +
                "            <attivo>false</attivo>\n" +
                "        </decumuloCedola>\n" +
                "        <imponibileCongelamento>301.5</imponibileCongelamento>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>true</stato>\n" +
                "            <dataFineBeneficioFiscale>2017-11-01</dataFineBeneficioFiscale>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "    </altriDati>\n" +
                "</polizza>";
        return s;
    }
}
