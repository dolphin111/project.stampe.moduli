package com.fideuram.mock.avvisi;

/**
 * Created by
 * User: logan
 * Date: 10/09/13
 * Time: 10.53
 */
public class AvvisiScadenzaPAMock {
    public static String getXml(){

        String s="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizza>\n" +
                "    <dataElaborazione>2013-09-05</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>7019468</numeroPolizza>\n" +
                "        <codiceConferimento>01029936117</codiceConferimento>\n" +
                "        <stato>Rendita</stato>\n" +
                "        <sottostato>IN GODIMENTO RENDITA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>36000</codice>\n" +
                "            <descrizione>Piano Pensione Fideuram - Viva</descrizione>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>051</codice>\n" +
                "            <descrizione>Rendita vitalizia differita con controassicurazione a premio unico</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <tipoPrestazione>R</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>1986-02-28</dataEmissione>\n" +
                "        <dataScadenza>2013-02-28</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>SACELLA</cognome>\n" +
                "                <nome>MARINA</nome>\n" +
                "                <codicefiscale>SCLMRN58D49B240L</codicefiscale>\n" +
                "                <datanascita>1958-04-09</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>SACELLA</cognome>\n" +
                "                <nome>MARINA</nome>\n" +
                "                <codicefiscale>SCLMRN58D49B240L</codicefiscale>\n" +
                "                <datanascita>1958-04-09</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <datoreDiLavoro/>\n" +
                "        <beneficiarioVita>L' Assicurato</beneficiarioVita>\n" +
                "        <beneficiarioMorte>Il coniuge dell'assicurato al momento del decesso o, in mancanza, i figli dell'assicurato, nati e nascituri in parti uguali</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>Postale</tipoIndirizzo>\n" +
                "            <indirizzo>V. VITTORIO EMANUELE 21</indirizzo>\n" +
                "            <cap>20090</cap>\n" +
                "            <comune>BUCCINASCO</comune>\n" +
                "            <provincia>MI</provincia>\n" +
                "            <regione>Lombardia</regione>\n" +
                "            <nazione>Italia</nazione>\n" +
                "            <dataAggiornamento>2010-03-15</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>BERTELLI TOGNASCIOLI</cognome>\n" +
                "                <nome>VALTER</nome>\n" +
                "                <codicefiscale>BRTVTR57B24G393N</codicefiscale>\n" +
                "                <datanascita>1957-02-24</datanascita>\n" +
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
                "        <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                "        <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                "        <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                "        <totalePrestazioniCV>0.0</totalePrestazioniCV>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "        <dataRiferimentoNAV>2013-04-16</dataRiferimentoNAV>\n"+
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>516.46</totalePremiAnnuiIncassati>\n" +
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
                "        <imponibileCongelamento>2180.43</imponibileCongelamento>\n" +
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
                "    <stimeScadenza>\n" +
                "        <polizzaID>7019468</polizzaID>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <dataRiferimentoNav>2013-04-16</dataRiferimentoNav>\n"+
                "        <renditaAnnuavitaliziaMinimaGarantita>0.0</renditaAnnuavitaliziaMinimaGarantita>\n" +
                "        <valoreRiscattoScadenzaGarantito>2850.22</valoreRiscattoScadenzaGarantito>\n" +
                "        <ipotesiRenditaAnnuaPosticipataScadenzaCVT>95.9876</ipotesiRenditaAnnuaPosticipataScadenzaCVT>\n" +
                "        <ipotesiValoreriScattoScadenzaCVT>2850.22</ipotesiValoreriScattoScadenzaCVT>\n" +
                "        <totalerenditaFrazionataAnnualePosticipata>95.9876</totalerenditaFrazionataAnnualePosticipata>\n" +
                "        <totalerenditaFrazionataSemestralePosticipata>95.51</totalerenditaFrazionataSemestralePosticipata>\n" +
                "        <totalerenditaFrazionataTrimestralePosticipata>47.36</totalerenditaFrazionataTrimestralePosticipata>\n" +
                "        <anniCertezza1>5</anniCertezza1>\n"+
                "        <totalerenditaFrazionataMensilePosticipata>15.7</totalerenditaFrazionataMensilePosticipata>\n" +
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
                "        <timestamp>2012-11-28</timestamp>\n" +
                "        <dataScadenza>2013-02-28</dataScadenza>\n" +
                "        <dataCalcolo>2012-11-28</dataCalcolo>\n" +
                "        <importoNettoRiscattoTermine>2644.03</importoNettoRiscattoTermine>\n" +
                "        <isACLSLungaSopravvivenza>false</isACLSLungaSopravvivenza>\n" +
                "        <renditaVitaliziaAnnuaPosticipata>0.0</renditaVitaliziaAnnuaPosticipata>\n" +
                "    </stimeScadenza>\n" +
                "    <trasformabile>false</trasformabile>\n" +
                "</polizza>";
        return s;
    }
}
