package com.fideuram.anomalia;

/**
 * Created by 
 * User: logan
 * Date: 23/04/13
 * Time: 12.24
 */
public class MockOccasionale {
    public static String getXml(){

                  //  <?xml version="1.0" encoding="UTF-8" standalone="yes"?>

        String s="<polizza>\n" +
                " <dataElaborazione>2014-12-01</dataElaborazione>\n" +
                " <datiTecnici>\n" +
                " <numeroPolizza>7519574</numeroPolizza>\n" +
                " <codiceConferimento>35106935004</codiceConferimento>\n" +
                " <stato>Attiva</stato>\n" +
                " <sottostato>ATTIVA</sottostato>\n" +
                " <prodotto>\n" +
                " <codice>35005</codice>\n" +
                " <descrizione>Fideuram Unit Linked 2</descrizione>\n" +
                " <tipoRamoLayout>3</tipoRamoLayout>\n" +
                " <garantito>true</garantito>\n" +
                " </prodotto>\n" +
                " <tariffa>\n" +
                " <codice>950</codice>\n" +
                " <descrizione>Capitale differito con controassicurazione a premio ricorrente di tipo Unit Linked</descrizione>\n" +
                " </tariffa>\n" +
                " <ramoMinisteriale>3</ramoMinisteriale>\n" +
                " <tipoPrestazione>C</tipoPrestazione>\n" +
                " <tipoPolizza>A</tipoPolizza>\n" +
                " <dataEmissione>2001-03-30</dataEmissione>\n" +
                " <dataScadenza>2024-12-31</dataScadenza>\n" +
                " <reteVendita>BFI</reteVendita>\n" +
                " <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                " <divisa>EUR</divisa>\n" +
                " <premioDiTariffa>3098.74</premioDiTariffa>\n" +
                " <importoRataBaseIniziale>3098.74</importoRataBaseIniziale>\n" +
                " <pianoVersamentoIniziale>3098.74</pianoVersamentoIniziale>\n" +
                " <durata>23</durata>\n" +
                " </datiTecnici>\n" +
                " <figureContrattuali>\n" +
                " <contraente>\n" +
                " <personaFisica>\n" +
                " <cognome>ROSSOTTI</cognome>\n" +
                " <nome>CLAUDIO</nome>\n" +
                " <codicefiscale>RSSCLD64C14L219P</codicefiscale>\n" +
                " <datanascita>1964-03-14</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </contraente>\n" +
                " <primoAssicurato>\n" +
                " <personaFisica>\n" +
                " <cognome>ROSSOTTI</cognome>\n" +
                " <nome>CLAUDIO</nome>\n" +
                " <codicefiscale>RSSCLD64C14L219P</codicefiscale>\n" +
                " <datanascita>1964-03-14</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </primoAssicurato>\n" +
                " <secondoAssicurato/>\n" +
                " <datoreDiLavoro/>\n" +
                " <beneficiarioVita>L' Assicurato</beneficiarioVita>\n" +
                " <beneficiarioMorte>Eredi testamentari o legittimi dell' Assicurato</beneficiarioMorte>\n" +
                " <indirizzoContratto>\n" +
                " <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                " <indirizzo>VIA BERIA 36 FRZ.REVIGLIASCO</indirizzo>\n" +
                " <cap>10024</cap>\n" +
                " <comune>MONCALIERI</comune>\n" +
                " <provincia>TO</provincia>\n" +
                " <regione>Piemonte</regione>\n" +
                " <nazione>Italia </nazione>\n" +
                " <dataAggiornamento>2014-07-08</dataAggiornamento>\n" +
                " </indirizzoContratto>\n" +
                " <rol>\n" +
                " <codiceStato>0</codiceStato>\n" +
                " </rol>\n" +
                " <banker>\n" +
                " <privateBanker>\n" +
                " <cognome>TROMBOTTO</cognome>\n" +
                " <nome>RENZO</nome>\n" +
                " <codicefiscale>TRMRNZ46M10G674B</codicefiscale>\n" +
                " <datanascita>1946-08-10</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <professione>LAVORATORI AUTONOMI E LIBERI PROFESSIONISTI</professione>\n" +
                " <vip>true</vip>\n" +
                " </privateBanker>\n" +
                " <dataInizio>1987-12-30</dataInizio>\n" +
                " <stato>Attivo</stato>\n" +
                " <livello>Private Banker</livello>\n" +
                " </banker>\n" +
                " <isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita>\n" +
                " <isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte>\n" +
                " <legaleRappresentante/>\n" +
                " </figureContrattuali>\n" +
                " <prestazioni>\n" +
                " <prestazioneGarantitaUltimaRivalutazione>69234.2</prestazioneGarantitaUltimaRivalutazione>\n" +
                " <importoBonus>0.0</importoBonus>\n" +
                " <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>\n" +
                " <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                " <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>\n" +
                " <valorePrestazioniControvalore>0.0</valorePrestazioniControvalore>\n" +
                " <eccedenza>0.0</eccedenza>\n" +
                " <opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/>\n" +
                " <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                " <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                " <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                " <totalePrestazioniCV>69234.2</totalePrestazioniCV>\n" +
                " <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                " <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                " <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                " <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                " <prestazioneGarantita>0.0</prestazioneGarantita>\n" +
                " <totalePrestazioniBase>69234.2</totalePrestazioniBase>\n" +
                " </prestazioni>\n" +
                " <finanziario>\n" +
                " <quoteTotali>305.621</quoteTotali>\n" +
                " <controvaloreTotale>3773.502487</controvaloreTotale>\n" +
                " <dataRiferimentoNAV>2014-11-24</dataRiferimentoNAV>\n" +
                " <dataElaborazione>2014-12-01</dataElaborazione>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
                " <listaAndamentoControvalori>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3286.036992</valore>\n" +
                " <data>2014-01-31</data>\n" +
                " <descrizione>Data Riferimento NAV: 31/01/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>GENNAIO 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3319.655302</valore>\n" +
                " <data>2014-02-28</data>\n" +
                " <descrizione>Data Riferimento NAV: 28/02/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>FEBBRAIO 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3401.867351</valore>\n" +
                " <data>2014-03-31</data>\n" +
                " <descrizione>Data Riferimento NAV: 31/03/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>MARZO 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3459.324099</valore>\n" +
                " <data>2014-04-30</data>\n" +
                " <descrizione>Data Riferimento NAV: 30/04/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>APRILE 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3453.822921</valore>\n" +
                " <data>2014-05-30</data>\n" +
                " <descrizione>Data Riferimento NAV: 30/05/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>MAGGIO 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3602.660348</valore>\n" +
                " <data>2014-06-30</data>\n" +
                " <descrizione>Data Riferimento NAV: 30/06/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>GIUGNO 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3644.836046</valore>\n" +
                " <data>2014-07-31</data>\n" +
                " <descrizione>Data Riferimento NAV: 31/07/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>LUGLIO 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3691.90168</valore>\n" +
                " <data>2014-08-29</data>\n" +
                " <descrizione>Data Riferimento NAV: 29/08/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>AGOSTO 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3767.390067</valore>\n" +
                " <data>2014-09-30</data>\n" +
                " <descrizione>Data Riferimento NAV: 30/09/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>SETTEMBRE 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3694.95789</valore>\n" +
                " <data>2014-10-31</data>\n" +
                " <descrizione>Data Riferimento NAV: 31/10/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>OTTOBRE 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " <andamentoControvalore>\n" +
                " <valore>3773.502487</valore>\n" +
                " <data>2014-11-27</data>\n" +
                " <descrizione>Data Riferimento NAV: 27/11/2014,Nessun evento registrato</descrizione>\n" +
                " <nome>NOVEMBRE 14</nome>\n" +
                " </andamentoControvalore>\n" +
                " </listaAndamentoControvalori>\n" +
                " <dettagliComposizioneInvestimento>\n" +
                " <dettaglioComposizioneInvestimentoRamo3>\n" +
                " <polizzaRiferimento>7519574</polizzaRiferimento>\n" +
                " <codiceFondo>01A24</codiceFondo>\n" +
                " <denominazioneFondoInvestimento>FONDO INTERNO UNIT LINKED 2001/2024</denominazioneFondoInvestimento>\n" +
                " <valoreNAV>12.347</valoreNAV>\n" +
                " <dataNav>2014-11-24</dataNav>\n" +
                " <numeroQuote>305.6209999999999809006112627685070037841796875</numeroQuote>\n" +
                " <controvaloreQuote>3773.502487</controvaloreQuote>\n" +
                " <idRepository>22716063</idRepository>\n" +
                " <pesoFondo>100.0</pesoFondo>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                " <isFondoProtetto>false</isFondoProtetto>\n" +
                " </dettaglioComposizioneInvestimentoRamo3>\n" +
                " </dettagliComposizioneInvestimento>\n" +
                " <composizionePortafoglioPerAssetClass>\n" +
                " <statistiche>\n" +
                " <totale>3773.502487</totale>\n" +
                " <valore>3773.502487</valore>\n" +
                " <percentuale>72.27</percentuale>\n" +
                " <descrizione>Comparto OICR ZeroCoupon</descrizione>\n" +
                " <codiceColore>#F9B47B</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>3773.502487</totale>\n" +
                " <valore>3773.502487</valore>\n" +
                " <percentuale>27.73</percentuale>\n" +
                " <descrizione>Fondi Azionari</descrizione>\n" +
                " <codiceColore>#D04242</codiceColore>\n" +
                " </statistiche>\n" +
                " </composizionePortafoglioPerAssetClass>\n" +
                " <composizionePortafoglioPerFondoOICR>\n" +
                " <statistiche>\n" +
                " <totale>3773.502487</totale>\n" +
                " <valore>7547.004974</valore>\n" +
                " <percentuale>100.0</percentuale>\n" +
                " <descrizione>FONDO INTERNO UNIT LINKED 2001/2024</descrizione>\n" +
                " <codiceColore>#4572A7</codiceColore>\n" +
                " </statistiche>\n" +
                " </composizionePortafoglioPerFondoOICR>\n" +
                " </finanziario>\n" +
                " <contabile>\n" +
                " <totalePremiAnnuiIncassati>3098.74</totalePremiAnnuiIncassati>\n" +
                " <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                " <totalePremiAnnuiIncassatiConTrasformate>3098.74</totalePremiAnnuiIncassatiConTrasformate>\n" +
                " <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                " <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                " <dataFinePagamentoPremi>2024-12-31</dataFinePagamentoPremi>\n" +
                " </contabile>\n" +
                " <altriDati>\n" +
                " <vincolo>\n" +
                " <attivo>false</attivo>\n" +
                " </vincolo>\n" +
                " <decumuloCedola>\n" +
                " <attivo>false</attivo>\n" +
                " <dettagli>\n" +
                " <imponibile>0.0</imponibile>\n" +
                " <importoPagato>0.0</importoPagato>\n" +
                " <cvn>0.0</cvn>\n" +
                " <percentuale>0.0</percentuale>\n" +
                " <importoRata>0.0</importoRata>\n" +
                " </dettagli>\n" +
                " </decumuloCedola>\n" +
                " <imponibileCongelamento>0.0</imponibileCongelamento>\n" +
                " <classeCPP>D</classeCPP>\n" +
                " <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                " <caricamentiCPP>\n" +
                " <caricamentoCPPR3>\n" +
                " <descrizione>Prima rata di prima annualita'</descrizione>\n" +
                " <tipoTitolo>01</tipoTitolo>\n" +
                " <percentualeCaricamento>3.0</percentualeCaricamento>\n" +
                " </caricamentoCPPR3>\n" +
                " </caricamentiCPP>\n" +
                " <importoPianoProgrammatoVersamenti>71271.02</importoPianoProgrammatoVersamenti>\n" +
                " <detraibilitaFiscale>\n" +
                " <stato>false</stato>\n" +
                " </detraibilitaFiscale>\n" +
                " <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                " <polizzaScudata>false</polizzaScudata>\n" +
                " <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                " <pegno>false</pegno>\n" +
                " <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                " </altriDati>\n" +
                " <trasformabile>true</trasformabile>\n" +
                " <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                "</polizza>";

        return s;
    }
}
