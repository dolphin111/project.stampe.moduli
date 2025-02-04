package ws.stampe.fv.avvisi;

/**
 * Created with
 * User: v801068
 * Date: 04/02/14
 * Time: 9.53
 */
public class ScadenzaPAMock {
    public static String getXml(){
        String s="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizza>\n" +
                "    <dataElaborazione>2014-02-04</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>7278001</numeroPolizza>\n" +
                "        <codiceConferimento>42549636006</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>RIDOTTA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>36001</codice>\n" +
                "            <descrizione>Piano Pensione Fideuram - Previ</descrizione>\n" +
                "            <tipoRamoLayout>1</tipoRamoLayout>\n" +
                "            <garantito>true</garantito>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>701</codice>\n" +
                "            <descrizione>Rendita vitalizia differita con controassicurazione a premio annuo</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <tipoPrestazione>R</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>1994-05-16</dataEmissione>\n" +
                "        <dataScadenza>2014-05-02</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "        <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                "        <divisa>EUR</divisa>\n" +
                "        <premioDiTariffa>0.0</premioDiTariffa>\n" +
                "        <importoRataBaseIniziale>1549.37</importoRataBaseIniziale>\n" +
                "        <pianoVersamentoIniziale>1549.37</pianoVersamentoIniziale>\n" +
                "        <durata>20</durata>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>PAPPACENA</cognome>\n" +
                "                <nome>ROBERTO</nome>\n" +
                "                <codicefiscale>PPPRRT65R19G834W</codicefiscale>\n" +
                "                <datanascita>1965-10-19</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>PAPPACENA</cognome>\n" +
                "                <nome>LUCIO</nome>\n" +
                "                <codicefiscale>PPPLCU62D01G834O</codicefiscale>\n" +
                "                <datanascita>1962-04-01</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <datoreDiLavoro/>\n" +
                "        <beneficiarioVita>Il Contraente</beneficiarioVita>\n" +
                "        <beneficiarioMorte>Eredi testamentari o legittimi dell' Assicurato</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>Postale</tipoIndirizzo>\n" +
                "            <indirizzo>VIA ARNO 5</indirizzo>\n" +
                "            <cap>84098</cap>\n" +
                "            <comune>PONTECAGNANO</comune>\n" +
                "            <provincia>SA</provincia>\n" +
                "            <regione>Campania</regione>\n" +
                "            <nazione>Italia</nazione>\n" +
                "            <dataAggiornamento>2007-04-21</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>D'ARMINIO</cognome>\n" +
                "                <nome>FABIO</nome>\n" +
                "                <codicefiscale>DRMFBA64E18G834C</codicefiscale>\n" +
                "                <datanascita>1964-05-18</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <dataInizio>2000-01-12</dataInizio>\n" +
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
                "        <valorePrestazioniControvalore>0.0</valorePrestazioniControvalore>\n" +
                "        <eccedenza>0.0</eccedenza>\n" +
                "        <opzioni xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
                "        <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                "        <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                "        <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                "        <totalePrestazioniCV>545.99</totalePrestazioniCV>\n" +
                "        <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                "        <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                "        <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                "        <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                "        <prestazioneGarantita>0.0</prestazioneGarantita>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "        <isETF>false</isETF>\n" +
                "        <isCustom>false</isCustom>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>4648.11</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                "        <totalePremiAnnuiIncassatiConTrasformate>4648.11</totalePremiAnnuiIncassatiConTrasformate>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "        <dataFinePagamentoPremi>2013-05-02</dataFinePagamentoPremi>\n" +
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
                "        <imponibileCongelamento>2004.1</imponibileCongelamento>\n" +
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
                "        <polizzaID>7278001</polizzaID>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <renditaAnnuavitaliziaMinimaGarantita>0.0</renditaAnnuavitaliziaMinimaGarantita>\n" +
                "        <valoreRiscattoScadenzaGarantito>7091.41</valoreRiscattoScadenzaGarantito>\n" +
                "        <ipotesiRenditaAnnuaPosticipataScadenzaCVT>246.426</ipotesiRenditaAnnuaPosticipataScadenzaCVT>\n" +
                "        <ipotesiValoreriScattoScadenzaCVT>7091.41</ipotesiValoreriScattoScadenzaCVT>\n" +
                "        <totalerenditaFrazionataAnnualePosticipata>246.426</totalerenditaFrazionataAnnualePosticipata>\n" +
                "        <totalerenditaFrazionataSemestralePosticipata>245.2</totalerenditaFrazionataSemestralePosticipata>\n" +
                "        <totalerenditaFrazionataTrimestralePosticipata>121.57</totalerenditaFrazionataTrimestralePosticipata>\n" +
                "        <totalerenditaFrazionataMensilePosticipata>40.3</totalerenditaFrazionataMensilePosticipata>\n" +
                "        <anniCertezza1>5</anniCertezza1>\n" +
                "        <totaleRenditaCerta1AnnualePosticipata>495.38</totaleRenditaCerta1AnnualePosticipata>\n" +
                "        <totaleRenditaCerta1SemestralePosticipata>243.68</totaleRenditaCerta1SemestralePosticipata>\n" +
                "        <totaleRenditaCerta1TrimestralePosticipata>120.86</totaleRenditaCerta1TrimestralePosticipata>\n" +
                "        <totaleRenditaCerta1MensilePosticipata>40.07</totaleRenditaCerta1MensilePosticipata>\n" +
                "        <anniCertezza2>10</anniCertezza2>\n" +
                "        <totaleRenditaCerta2AnnualePosticipata>486.6</totaleRenditaCerta2AnnualePosticipata>\n" +
                "        <totaleRenditaCerta2Semestraleposticipata>239.57</totaleRenditaCerta2Semestraleposticipata>\n" +
                "        <totaleRenditaCerta2TrimestralePosticipata>118.87</totaleRenditaCerta2TrimestralePosticipata>\n" +
                "        <totaleRenditaCerta2MensilePosticipata>39.42</totaleRenditaCerta2MensilePosticipata>\n" +
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
                "        <timestamp>2014-02-02</timestamp>\n" +
                "        <dataScadenza>2014-05-02</dataScadenza>\n" +
                "        <dataCalcolo>2014-02-02</dataCalcolo>\n" +
                "        <importoNettoRiscattoTermine>6813.96</importoNettoRiscattoTermine>\n" +
                "        <isACLSLungaSopravvivenza>false</isACLSLungaSopravvivenza>\n" +
                "        <renditaVitaliziaAnnuaPosticipata>498.83</renditaVitaliziaAnnuaPosticipata>\n" +
                "    </stimeScadenza>\n" +
                "    <trasformabile>false</trasformabile>\n" +
                "    <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                "</polizza>\n";
        return s;
    }
}
