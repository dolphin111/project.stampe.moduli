package com.fideuram.mock;

/**
 * Created by
 * User: logan
 * Date: 12/04/13
 * Time: 17.05
 */
public class RiscattoAnticipatoPolizzaApertaRamo1CapitaleMock {
    public static String getXml(){

        String s="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizza>\n" +
                "    <dataElaborazione>2013-05-02</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>7391771</numeroPolizza>\n" +
                "        <codiceConferimento>22619730010</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>ATTIVA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>30001</codice>\n" +
                "            <descrizione>Globale vita (Previ)</descrizione>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>105</codice>\n" +
                "            <descrizione>Vita Intera a premio unico (tasso tecnico 4%)</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <tipoPrestazione>C</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>1997-10-27</dataEmissione>\n" +
                "        <dataScadenza>2049-10-22</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>GASPARATO</cognome>\n" +
                "                <nome>ROSA</nome>\n" +
                "                <codicefiscale>GSPRSO41B47C370X</codicefiscale>\n" +
                "                <datanascita>1941-02-07</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>GASPARATO</cognome>\n" +
                "                <nome>ROSA</nome>\n" +
                "                <codicefiscale>GSPRSO41B47C370X</codicefiscale>\n" +
                "                <datanascita>1941-02-07</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <beneficiarioMorte>IL SIG. ZULIANI CLAUDIO.</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>VIA OLMO, 28</indirizzo>\n" +
                "            <cap>37060</cap>\n" +
                "            <comune>SONA</comune>\n" +
                "            <provincia>VR</provincia>\n" +
                "            <regione>Manca</regione>\n" +
                "            <nazione>Italia</nazione>\n" +
                "            <dataAggiornamento>2007-04-21</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>ZAMPERINI</cognome>\n" +
                "                <nome>ENNIO</nome>\n" +
                "                <codicefiscale>ZMPNNE62E25L781W</codicefiscale>\n" +
                "                <datanascita>1962-05-25</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <dataInizio>1995-10-03</dataInizio>\n" +
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
                "            <riscattoLordo>7405.93</riscattoLordo>\n" +
                "            <dataRiferimento>2013-05-02</dataRiferimento>\n" +
                "        </simulazioniPrestazioniAssicurate>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>5164.57</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "    </contabile>\n" +
                "    <altriDati>\n" +
                "        <vincolo>\n" +
                "            <attivo>false</attivo>\n" +
                "        </vincolo>\n" +
                "        <decumuloCedola>\n" +
                "            <attivo>false</attivo>\n" +
                "        </decumuloCedola>\n" +
                "        <imponibileCongelamento>2016.83</imponibileCongelamento>\n" +
                "        <classeCPP>1</classeCPP>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>false</stato>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "    </altriDati>\n" +
                "</polizza>";
        return s;
    }
}
