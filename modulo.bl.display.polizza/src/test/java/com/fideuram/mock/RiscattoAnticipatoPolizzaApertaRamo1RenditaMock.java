package com.fideuram.mock;

/**
 * Created by
 * User: logan
 * Date: 12/04/13
 * Time: 17.00
 */
public class RiscattoAnticipatoPolizzaApertaRamo1RenditaMock {
    public static String getXml(){

        String s="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizza>\n" +
                "    <dataElaborazione>2013-05-02</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>7262046</numeroPolizza>\n" +
                "        <codiceConferimento>48265636005</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>AFFRANCATA DA PREMI</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>36002</codice>\n" +
                "            <descrizione>Piano Pensione Fideuram - Previ</descrizione>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>701</codice>\n" +
                "            <descrizione>Rendita vitalizia differita con controassicurazione a premio annuo</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <tipoPrestazione>R</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>1993-11-11</dataEmissione>\n" +
                "        <dataScadenza>2013-11-03</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>FERRI</cognome>\n" +
                "                <nome>MARIO</nome>\n" +
                "                <codicefiscale>FRRMRA51D19I287J</codicefiscale>\n" +
                "                <datanascita>1951-04-19</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>FERRI</cognome>\n" +
                "                <nome>MASSIMILIANO</nome>\n" +
                "                <codicefiscale>FRRMSM80P18A944U</codicefiscale>\n" +
                "                <datanascita>1980-09-18</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <beneficiarioVita>L' Assicurato</beneficiarioVita>\n" +
                "        <beneficiarioMorte>Eredi testamentari o legittimi dell' Assicurato</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>VIA LEONCAVALLO 7</indirizzo>\n" +
                "            <cap>40033</cap>\n" +
                "            <comune>CASALECCHIO DI RENO</comune>\n" +
                "            <provincia>BO</provincia>\n" +
                "            <regione>Manca</regione>\n" +
                "            <nazione>Italia</nazione>\n" +
                "            <dataAggiornamento>2007-04-21</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>VACCARI</cognome>\n" +
                "                <nome>MASSIMO</nome>\n" +
                "                <codicefiscale>VCCMSM57L25A944W</codicefiscale>\n" +
                "                <datanascita>1957-07-25</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <dataInizio>1987-12-30</dataInizio>\n" +
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
                "            <eccedenza>27152.65</eccedenza>\n" +
                "            <riscattoLordo>112214.64</riscattoLordo>\n" +
                "            <dataRiferimento>2013-05-02</dataRiferimento>\n" +
                "        </simulazioniPrestazioniAssicurate>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>103291.51</totalePremiAnnuiIncassati>\n" +
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
                "        <imponibileCongelamento>30672.39</imponibileCongelamento>\n" +
                "        <classeCPP>1</classeCPP>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>false</stato>\n" +
                "            <dataFineBeneficioFiscale>2013-11-03</dataFineBeneficioFiscale>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "    </altriDati>\n" +
                "</polizza>";
        return s;
    }
}
