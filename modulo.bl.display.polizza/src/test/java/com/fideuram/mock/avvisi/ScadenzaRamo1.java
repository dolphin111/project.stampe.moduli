package com.fideuram.mock.avvisi;

/**
 * Created by
 * User: logan
 * Date: 11/09/13
 * Time: 10.05
 */
public class ScadenzaRamo1 {
    public static String getXml(){

        String s="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizza>\n" +
                "    <dataElaborazione>2013-09-10</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>7090936</numeroPolizza>\n" +
                "        <codiceConferimento>04582136237</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>ATTIVA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>36000</codice>\n" +
                "            <descrizione>Piano Pensione Fideuram - Viva</descrizione>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>048</codice>\n" +
                "            <descrizione>Rendita vitalizia differita con controassicurazione a premio annuo</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <tipoPrestazione>R</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>1987-10-19</dataEmissione>\n" +
                "        <dataScadenza>2013-10-02</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>LAMBERT</cognome>\n" +
                "                <nome>MASSIMO</nome>\n" +
                "                <codicefiscale>LMBMSM63P04L219Q</codicefiscale>\n" +
                "                <datanascita>1963-09-04</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>LAMBERT</cognome>\n" +
                "                <nome>MASSIMO</nome>\n" +
                "                <codicefiscale>LMBMSM63P04L219Q</codicefiscale>\n" +
                "                <datanascita>1963-09-04</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <datoreDiLavoro/>\n" +
                "        <beneficiarioVita>L' Assicurato</beneficiarioVita>\n" +
                "        <beneficiarioMorte>Eredi testamentari o legittimi dell' Assicurato</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>Postale</tipoIndirizzo>\n" +
                "            <indirizzo>VIA CARMELO PISANI BORG 3</indirizzo>\n" +
                "            <cap>10141</cap>\n" +
                "            <comune>TORINO</comune>\n" +
                "            <provincia>TO</provincia>\n" +
                "            <regione>Piemonte</regione>\n" +
                "            <nazione>Italia</nazione>\n" +
                "            <dataAggiornamento>2007-04-21</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>TROMBOTTO</cognome>\n" +
                "                <nome>RENZO</nome>\n" +
                "                <codicefiscale>TRMRNZ46M10G674B</codicefiscale>\n" +
                "                <datanascita>1946-08-10</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>true</vip>\n" +
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
                "        <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                "        <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                "        <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                "        <totalePrestazioniCV>2526.17</totalePrestazioniCV>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>20237.44</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "        <dataFinePagamentoPremi>2012-10-02</dataFinePagamentoPremi>\n" +
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
                "        <imponibileCongelamento>15185.57</imponibileCongelamento>\n" +
                "        <classeCPP>1</classeCPP>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>true</stato>\n" +
                "            <dataFineBeneficioFiscale>2013-10-02</dataFineBeneficioFiscale>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "    </altriDati>\n" +
                "    <stimeScadenza>\n" +
                "        <polizzaID>7090936</polizzaID>\n" +
                "        <dataRiferimentoNav>2013-04-16</dataRiferimentoNav>\n"+
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <renditaAnnuavitaliziaMinimaGarantita>0.0</renditaAnnuavitaliziaMinimaGarantita>\n" +
                "        <valoreRiscattoScadenzaGarantito>38026.69</valoreRiscattoScadenzaGarantito>\n" +
                "        <ipotesiRenditaAnnuaPosticipataScadenzaCVT>1248.6622</ipotesiRenditaAnnuaPosticipataScadenzaCVT>\n" +
                "        <ipotesiValoreriScattoScadenzaCVT>38026.69</ipotesiValoreriScattoScadenzaCVT>\n" +
                "        <totalerenditaFrazionataAnnualePosticipata>1248.6622</totalerenditaFrazionataAnnualePosticipata>\n" +
                "        <totalerenditaFrazionataSemestralePosticipata>1242.45</totalerenditaFrazionataSemestralePosticipata>\n" +
                "        <totalerenditaFrazionataTrimestralePosticipata>616.19</totalerenditaFrazionataTrimestralePosticipata>\n" +
                "        <totalerenditaFrazionataMensilePosticipata>204.29</totalerenditaFrazionataMensilePosticipata>\n" +
                "        <totaleRenditaCerta1AnnualePosticipata>0.0</totaleRenditaCerta1AnnualePosticipata>\n" +
                "        <totaleRenditaCerta1SemestralePosticipata>0.0</totaleRenditaCerta1SemestralePosticipata>\n" +
                "        <totaleRenditaCerta1TrimestralePosticipata>0.0</totaleRenditaCerta1TrimestralePosticipata>\n" +
                "        <totaleRenditaCerta1MensilePosticipata>0.0</totaleRenditaCerta1MensilePosticipata>\n" +
                "        <totaleRenditaCerta2AnnualePosticipata>0.0</totaleRenditaCerta2AnnualePosticipata>\n" +
                "        <totaleRenditaCerta2Semestraleposticipata>0.0</totaleRenditaCerta2Semestraleposticipata>\n" +
                "        <totaleRenditaCerta2TrimestralePosticipata>0.0</totaleRenditaCerta2TrimestralePosticipata>\n" +
                "        <totaleRenditaCerta2MensilePosticipata>0.0</totaleRenditaCerta2MensilePosticipata>\n" +
                "        <totaleRenditaCerta3AnnualePosticipata>0.0</totaleRenditaCerta3AnnualePosticipata>\n" +
                "        <totaleRenditaCerta3SemestralePosticipata>0.0</totaleRenditaCerta3SemestralePosticipata>\n" +
                "        <totaleRenditaCerta3TrimestralePosticipata>0.0</totaleRenditaCerta3TrimestralePosticipata>\n" +
                "        <totaleRenditaCerta3MensilePosticipata>0.0</totaleRenditaCerta3MensilePosticipata>\n" +
                "        <totaleRenditaCerta4AnnualePosticipata>0.0</totaleRenditaCerta4AnnualePosticipata>\n" +
                "        <totaleRenditaCerta4SemestralePosticipata>0.0</totaleRenditaCerta4SemestralePosticipata>\n" +
                "        <totaleRenditaCerta4TrimestralePosticipata>0.0</totaleRenditaCerta4TrimestralePosticipata>\n" +
                "        <totaleRenditaCerta4MensilePosticipata>0.0</totaleRenditaCerta4MensilePosticipata>\n" +
                "        <totaleRenditaReversibile>0.0</totaleRenditaReversibile>\n" +
                "        <percentualeReversibilita>0.0</percentualeReversibilita>\n" +
                "        <nav>0.0</nav>\n" +
                "        <ControValoreQuote>0.0</ControValoreQuote>\n" +
                "        <numeroQuote>0.0</numeroQuote>\n" +
                "        <timestamp>2013-07-02</timestamp>\n" +
                "        <dataScadenza>2013-10-02</dataScadenza>\n" +
                "        <dataCalcolo>2013-07-02</dataCalcolo>\n" +
                "        <importoNettoRiscattoTermine>36333.44</importoNettoRiscattoTermine>\n" +
                "        <isACLSLungaSopravvivenza>false</isACLSLungaSopravvivenza>\n" +
                "        <renditaVitaliziaAnnuaPosticipata>2526.17</renditaVitaliziaAnnuaPosticipata>\n" +
                "    </stimeScadenza>\n" +
                "</polizza>";
        return s;
    }
}
