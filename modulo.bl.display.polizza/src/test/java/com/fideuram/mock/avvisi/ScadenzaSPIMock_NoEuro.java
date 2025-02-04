package com.fideuram.mock.avvisi;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 15/10/13
 * Time: 11.18
 * To change this template use File | Settings | File Templates.
 */
public class ScadenzaSPIMock_NoEuro {
    public static String getXml(){
        String s="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizza>\n" +
                "    <dataElaborazione>2013-10-11</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>57150897</numeroPolizza>\n" +
                "        <codiceConferimento>150897ES006</codiceConferimento>\n" +
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
                "        <dataEmissione>1998-11-01</dataEmissione>\n" +
                "        <dataScadenza>2013-11-01</dataScadenza>\n" +
                "        <reteVendita>SPI</reteVendita>\n" +
                "        <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>DELLE-DONNE</cognome>\n" +
                "                <nome>GIORGIO</nome>\n" +
                "                <codicefiscale>DLLGRG60S11L219E</codicefiscale>\n" +
                "                <datanascita>1960-11-11</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>DELLE-DONNE</cognome>\n" +
                "                <nome>GIORGIO</nome>\n" +
                "                <codicefiscale>DLLGRG60S11L219E</codicefiscale>\n" +
                "                <datanascita>1960-11-11</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <datoreDiLavoro/>\n" +
                "        <beneficiarioVita>IL CONTRAENTE</beneficiarioVita>\n" +
                "        <beneficiarioMorte>GLI EREDI TESTAMENTARI O, IN MANCANZA,I LEGITTIMI</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>C.SO COSENZA, 18/15</indirizzo>\n" +
                "            <cap>10100</cap>\n" +
                "            <comune>TORINO</comune>\n" +
                "            <provincia>TO</provincia>\n" +
                "            <regione>Piemonte</regione>\n" +
                "            <nazione>IT</nazione>\n" +
                "            <dataAggiornamento>2005-07-08</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>RAPONI</cognome>\n" +
                "                <nome>MARISA</nome>\n" +
                "                <codicefiscale>RPNMRS59C59L219Q</codicefiscale>\n" +
                "                <datanascita>1959-03-19</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <dataInizio>2005-01-11</dataInizio>\n" +
                "            <stato>Attivo</stato>\n" +
                "            <livello>Private Banker</livello>\n" +
                "        </banker>\n" +
                "    </figureContrattuali>\n" +
                "    <prestazioni>\n" +
                "        <prestazioneGarantitaUltimaRivalutazione>399.35</prestazioneGarantitaUltimaRivalutazione>\n" +
                "        <importoBonusFvInsieme>0.0</importoBonusFvInsieme>\n" +
                "        <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>\n" +
                "        <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                "        <dataUltimaRivalutazione>2012-11-01</dataUltimaRivalutazione>\n" +
                "        <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>\n" +
                "        <eccedenza>0.0</eccedenza>\n" +
                "        <rendita>\n" +
                "            <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                "            <stimaTotaleRenditaScadenza>407.34</stimaTotaleRenditaScadenza>\n" +
                "            <isPianoCompletato>false</isPianoCompletato>\n" +
                "            <stimaTotaleRenditaScadenzaPianoCompletatoSPI>0.0</stimaTotaleRenditaScadenzaPianoCompletatoSPI>\n" +
                "            <renditaAnnuaVitaliziaMinimaGarantita>0.0</renditaAnnuaVitaliziaMinimaGarantita>\n" +
                "            <stimaTotaleRenditaScadenzaPianoNonCompletatoSPI>0.0</stimaTotaleRenditaScadenzaPianoNonCompletatoSPI>\n" +
                "            <renditaTotaleAnnuaLordaPosticipataScadenza>0.0</renditaTotaleAnnuaLordaPosticipataScadenza>\n" +
                "        </rendita>\n" +
                "        <capitale>\n" +
                "            <capitaleLordo>\n" +
                "                <coefficienteCapitale>0.0</coefficienteCapitale>\n" +
                "                <importoEuro>0.0</importoEuro>\n" +
                "                <importoValuta>7217.71</importoValuta>\n" +
                "                <cambioInEuro>0.0</cambioInEuro>\n" +
                "            </capitaleLordo>\n" +
                "        </capitale>\n" +
                "        <opzioni xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
                "        <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                "        <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                "        <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                "        <totalePrestazioniCV>0.0</totalePrestazioniCV>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totaleIncassi>\n" +
                "            <importoEuro>7752.02</importoEuro>\n" +
                "            <importoValuta>0.0</importoValuta>\n" +
                "            <dataCambio>1999-01-04</dataCambio>\n" +
                "            <cambioInEuro>1.0</cambioInEuro>\n" +
                "            <divisa>USD</divisa>\n" +
                "        </totaleIncassi>\n" +
                "        <totalePremiAnnuiIncassati>0.0</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "    </contabile>\n" +
                "    <altriDati>\n" +
                "        <vincolo>\n" +
                "            <attivo>false</attivo>\n" +
                "        </vincolo>\n" +
                "        <decumuloCedola>\n" +
                "            <attivo>false</attivo>\n" +
                "            <dettagli>\n" +
                "                <imponibile>0.0</imponibile>\n" +
                "                <importoPagato>0.0</importoPagato>\n" +
                "                <cvn>0.0</cvn>\n" +
                "                <percentuale>0.0</percentuale>\n" +
                "                <importoRata>0.0</importoRata>\n" +
                "            </dettagli>\n" +
                "        </decumuloCedola>\n" +
                "        <imponibileCongelamento>488.17</imponibileCongelamento>\n" +
                "        <classeCPP>2</classeCPP>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>false</stato>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "    </altriDati>\n" +
                "    <trasformabile>false</trasformabile>\n" +
                "</polizza>";
        return s;
    }
}
