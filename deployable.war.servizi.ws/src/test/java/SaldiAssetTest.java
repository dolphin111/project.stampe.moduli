import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.StampeWsException;
import com.fideuram.stampeservice.response.Risposta;

/**
 * User: V801068
 * Date: 01/12/14
 * Time: 10.46
 */
public class SaldiAssetTest {
    public static void main(String args[]) throws Exception {
        Stampe s=new Stampe();

        byte[]   b  =   s.getPdfFromXml(getXmlMX3(),"12");
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "SaldiAsset.pdf");
    }

    public static String getXmlMX3() {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizza>\n" +
                " <dataElaborazione>2016-07-21</dataElaborazione>\n" +
                " <datiTecnici>\n" +
                " <numeroPolizza>71001333273</numeroPolizza>\n" +
                " <codiceConferimento>71001333273MIXT3</codiceConferimento>\n" +
                " <stato>Attiva</stato>\n" +
                " <sottostato>ATTIVA</sottostato>\n" +
                " <prodotto>\n" +
                " <codice>MIXT3</codice>\n" +
                " <descrizione>Synthesis HNWI</descrizione>\n" +
                " <tipoRamoLayout>X</tipoRamoLayout>\n" +
                " <macroFamigliaID>1</macroFamigliaID>\n" +
                " <descrizioneMacroFamiglia>Fideuram Vita Insieme</descrizioneMacroFamiglia>\n" +
                " </prodotto>\n" +
                " <tariffa>\n" +
                " <codice>32MB2</codice>\n" +
                " <descrizione>Synthesis HNWI</descrizione>\n" +
                " </tariffa>\n" +
                " <ramoMinisteriale>3</ramoMinisteriale>\n" +
                " <tipoPrestazione>C</tipoPrestazione>\n" +
                " <tipoPolizza>C</tipoPolizza>\n" +
                " <dataEmissione>2016-07-08</dataEmissione>\n" +
                " <dataScadenza>2116-07-08</dataScadenza>\n" +
                " <reteVendita>ISPB</reteVendita>\n" +
                " <tipoSistemaProvenienza>8</tipoSistemaProvenienza>\n" +
                " <divisa>EUR</divisa>\n" +
                " <premioDiTariffa>0.0</premioDiTariffa>\n" +
                " <importoRataBaseIniziale>0.0</importoRataBaseIniziale>\n" +
                " <pianoVersamentoIniziale>0.0</pianoVersamentoIniziale>\n" +
                " <durata>100</durata>\n" +
                " </datiTecnici>\n" +
                " <figureContrattuali>\n" +
                " <contraente>\n" +
                " <personaFisica>\n" +
                " <cognome>GIALDINI</cognome>\n" +
                " <nome>LIVIO</nome>\n" +
                " <codicefiscale>GLDLVI44M24I812H</codicefiscale>\n" +
                " <datanascita>1944-08-24</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </contraente>\n" +
                " <primoAssicurato>\n" +
                " <personaFisica>\n" +
                " <cognome>GIALDINI</cognome>\n" +
                " <nome>LIVIO</nome>\n" +
                " <codicefiscale>GLDLVI44M24I812H</codicefiscale>\n" +
                " <datanascita>1944-08-24</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </primoAssicurato>\n" +
                " <secondoAssicurato/>\n" +
                " <datoreDiLavoro/>\n" +
                " <indirizzoContratto>\n" +
                " <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                " <indirizzo>VIA JACOPO BERENGARIO,111</indirizzo>\n" +
                " <cap>41012</cap>\n" +
                " <comune>CARPI</comune>\n" +
                " <provincia>MO</provincia>\n" +
                " <regione>Emilia Romagna</regione>\n" +
                " <nazione>Italia </nazione>\n" +
                " <dataAggiornamento>2016-07-01</dataAggiornamento>\n" +
                " </indirizzoContratto>\n" +
                " <rol>\n" +
                " <codiceStato>0</codiceStato>\n" +
                " </rol>\n" +
                " <banker>\n" +
                " <privateBanker>\n" +
                " <cognome>SIRTORI</cognome>\n" +
                " <nome>MAURIZIO LUIGI</nome>\n" +
                " <codicefiscale>U033998BANKERISP</codicefiscale>\n" +
                " <vip>false</vip>\n" +
                " </privateBanker>\n" +
                " <dataInizio>2016-03-29</dataInizio>\n" +
                " <dataFine>2100-12-31</dataFine>\n" +
                " <stato>Attivo</stato>\n" +
                " <livello>Private Banker</livello>\n" +
                " </banker>\n" +
                " <isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita>\n" +
                " <isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte>\n" +
                " <legaleRappresentante/>\n" +
                " </figureContrattuali>\n" +
                " <prestazioni>\n" +
                " <prestazioneGarantitaUltimaRivalutazione>2500000.0</prestazioneGarantitaUltimaRivalutazione>\n" +
                " <importoBonus>0.0</importoBonus>\n" +
                " <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>\n" +
                " <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                " <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>\n" +
                " <valorePrestazioniControvalore>5013945.1676</valorePrestazioniControvalore>\n" +
                " <eccedenza>0.0</eccedenza>\n" +
                " <rendita>\n" +
                " <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                " <stimaTotaleRenditaScadenza>0.0</stimaTotaleRenditaScadenza>\n" +
                " <isPianoCompletato>false</isPianoCompletato>\n" +
                " <stimaTotaleRenditaScadenzaPianoCompletatoSPI>0.0</stimaTotaleRenditaScadenzaPianoCompletatoSPI>\n" +
                " <renditaAnnuaVitaliziaMinimaGarantita>0.0</renditaAnnuaVitaliziaMinimaGarantita>\n" +
                " <stimaTotaleRenditaScadenzaPianoNonCompletatoSPI>0.0</stimaTotaleRenditaScadenzaPianoNonCompletatoSPI>\n" +
                " <renditaTotaleAnnuaLordaPosticipataScadenza>0.0</renditaTotaleAnnuaLordaPosticipataScadenza>\n" +
                " <totalePrestazioniRendita>2500000.0</totalePrestazioniRendita>\n" +
                " </rendita>\n" +
                " <opzioni xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
                " <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                " <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                " <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                " <totalePrestazioniCV>0.0</totalePrestazioniCV>\n" +
                " <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                " <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                " <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                " <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                " <prestazioneGarantita>0.0</prestazioneGarantita>\n" +
                " <totalePrestazioniBase>2500000.0</totalePrestazioniBase>\n" +
                " </prestazioni>\n" +
                " <finanziario>\n" +
                " <quoteTotali>183206.48209</quoteTotali>\n" +
                " <controvaloreTotale>2513945.1676</controvaloreTotale>\n" +
                " <dataRiferimentoNAV>2016-07-15</dataRiferimentoNAV>\n" +
                " <dataElaborazione>2016-07-21</dataElaborazione>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
                " <listaAndamentoControvalori>\n" +
                " <andamentoControvalore>\n" +
                " <valore>2513945.167569</valore>\n" +
                " <data>2016-07-19</data>\n" +
                " <descrizione>Data Riferimento NAV: 19/07/2016,Incasso Premio Investito (08/07/2016)</descrizione>\n" +
                " <nome>LUGLIO 16</nome>\n" +
                " </andamentoControvalore>\n" +
                " </listaAndamentoControvalori>\n" +
                " <dettagliComposizioneInvestimento>\n" +
                " <dettaglioComposizioneInvestimentoRamo3>\n" +
                " <polizzaRiferimento>71001333273</polizzaRiferimento>\n" +
                " <codiceFondo>ISPA0009</codiceFondo>\n" +
                " <denominazioneFondoInvestimento>Synthesis Multiasset 30 </denominazioneFondoInvestimento>\n" +
                " <valoreNAV>9.973</valoreNAV>\n" +
                " <dataNav>2016-07-14</dataNav>\n" +
                " <numeroQuote>151224.92186999999103136360645294189453125</numeroQuote>\n" +
                " <controvaloreQuote>1508166.14581</controvaloreQuote>\n" +
                " <idRepository>26317942</idRepository>\n" +
                " <pesoFondo>59.992005</pesoFondo>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                " <isFondoProtetto>false</isFondoProtetto>\n" +
                " <descrizioneInvestimento>Fondi Azionari</descrizioneInvestimento>\n" +
                " </dettaglioComposizioneInvestimentoRamo3>\n" +
                " <dettaglioComposizioneInvestimentoRamo3>\n" +
                " <polizzaRiferimento>71001333273</polizzaRiferimento>\n" +
                " <codiceFondo>ISPA0048</codiceFondo>\n" +
                " <denominazioneFondoInvestimento>BlackRock Fixed Income Strategies Fund </denominazioneFondoInvestimento>\n" +
                " <valoreNAV>121.81</valoreNAV>\n" +
                " <dataNav>2016-07-15</dataNav>\n" +
                " <numeroQuote>1235.78843000000006213667802512645721435546875</numeroQuote>\n" +
                " <controvaloreQuote>150531.388658</controvaloreQuote>\n" +
                " <isin>LU0438336421</isin>\n" +
                " <idRepository>26332702</idRepository>\n" +
                " <pesoFondo>5.987854</pesoFondo>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                " <isFondoProtetto>false</isFondoProtetto>\n" +
                " <descrizioneInvestimento>Fondi Flessibili</descrizioneInvestimento>\n" +
                " </dettaglioComposizioneInvestimentoRamo3>\n" +
                " <dettaglioComposizioneInvestimentoRamo3>\n" +
                " <polizzaRiferimento>71001333273</polizzaRiferimento>\n" +
                " <codiceFondo>ISPA0036</codiceFondo>\n" +
                " <denominazioneFondoInvestimento>BNY Mellon Absolute Return Bond Fund </denominazioneFondoInvestimento>\n" +
                " <valoreNAV>109.5131</valoreNAV>\n" +
                " <dataNav>2016-07-15</dataNav>\n" +
                " <numeroQuote>1368.668089999999892825144343078136444091796875</numeroQuote>\n" +
                " <controvaloreQuote>149887.085407</controvaloreQuote>\n" +
                " <isin>IE00B706BP88</isin>\n" +
                " <idRepository>26332667</idRepository>\n" +
                " <pesoFondo>5.962225</pesoFondo>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                " <isFondoProtetto>false</isFondoProtetto>\n" +
                " <descrizioneInvestimento>Fondi Flessibili</descrizioneInvestimento>\n" +
                " </dettaglioComposizioneInvestimentoRamo3>\n" +
                " <dettaglioComposizioneInvestimentoRamo3>\n" +
                " <polizzaRiferimento>71001333273</polizzaRiferimento>\n" +
                " <codiceFondo>ISPA0056</codiceFondo>\n" +
                " <denominazioneFondoInvestimento>Invesco Global Targeted Returns Fund </denominazioneFondoInvestimento>\n" +
                " <valoreNAV>11.2616</valoreNAV>\n" +
                " <dataNav>2016-07-15</dataNav>\n" +
                " <numeroQuote>8963.7862999999997555278241634368896484375</numeroQuote>\n" +
                " <controvaloreQuote>100946.575796</controvaloreQuote>\n" +
                " <isin>LU1004133028</isin>\n" +
                " <idRepository>26332718</idRepository>\n" +
                " <pesoFondo>4.015464</pesoFondo>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                " <isFondoProtetto>false</isFondoProtetto>\n" +
                " <descrizioneInvestimento>Fondi Flessibili</descrizioneInvestimento>\n" +
                " </dettaglioComposizioneInvestimentoRamo3>\n" +
                " <dettaglioComposizioneInvestimentoRamo3>\n" +
                " <polizzaRiferimento>71001333273</polizzaRiferimento>\n" +
                " <codiceFondo>ISPA0026</codiceFondo>\n" +
                " <denominazioneFondoInvestimento>Invesco Pan European High Income Fund </denominazioneFondoInvestimento>\n" +
                " <valoreNAV>20.87</valoreNAV>\n" +
                " <dataNav>2016-07-15</dataNav>\n" +
                " <numeroQuote>4880.4294799999997849226929247379302978515625</numeroQuote>\n" +
                " <controvaloreQuote>101854.563248</controvaloreQuote>\n" +
                " <isin>LU0243957668</isin>\n" +
                " <idRepository>26332674</idRepository>\n" +
                " <pesoFondo>4.051582</pesoFondo>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                " <isFondoProtetto>false</isFondoProtetto>\n" +
                " <descrizioneInvestimento>Fondi Flessibili</descrizioneInvestimento>\n" +
                " </dettaglioComposizioneInvestimentoRamo3>\n" +
                " <dettaglioComposizioneInvestimentoRamo3>\n" +
                " <polizzaRiferimento>71001333273</polizzaRiferimento>\n" +
                " <codiceFondo>ISPA0033</codiceFondo>\n" +
                " <denominazioneFondoInvestimento>M&amp;G Optimal Income Fund </denominazioneFondoInvestimento>\n" +
                " <valoreNAV>19.7721</valoreNAV>\n" +
                " <dataNav>2016-07-15</dataNav>\n" +
                " <numeroQuote>7663.1484300000001894659362733364105224609375</numeroQuote>\n" +
                " <controvaloreQuote>151516.537073</controvaloreQuote>\n" +
                " <isin>GB00B1VMD022</isin>\n" +
                " <idRepository>26332657</idRepository>\n" +
                " <pesoFondo>6.027042</pesoFondo>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                " <isFondoProtetto>false</isFondoProtetto>\n" +
                " <descrizioneInvestimento>Fondi Obbligazionari</descrizioneInvestimento>\n" +
                " </dettaglioComposizioneInvestimentoRamo3>\n" +
                " <dettaglioComposizioneInvestimentoRamo3>\n" +
                " <polizzaRiferimento>71001333273</polizzaRiferimento>\n" +
                " <codiceFondo>ISPA0037</codiceFondo>\n" +
                " <denominazioneFondoInvestimento>Muzinich Global Tactical Credit Fund </denominazioneFondoInvestimento>\n" +
                " <valoreNAV>107.99</valoreNAV>\n" +
                " <dataNav>2016-07-15</dataNav>\n" +
                " <numeroQuote>1388.11770999999998821294866502285003662109375</numeroQuote>\n" +
                " <controvaloreQuote>149902.831503</controvaloreQuote>\n" +
                " <isin>IE00BHLSJ159</isin>\n" +
                " <idRepository>26332671</idRepository>\n" +
                " <pesoFondo>5.962852</pesoFondo>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                " <isFondoProtetto>false</isFondoProtetto>\n" +
                " <descrizioneInvestimento>Fondi Obbligazionari</descrizioneInvestimento>\n" +
                " </dettaglioComposizioneInvestimentoRamo3>\n" +
                " <dettaglioComposizioneInvestimentoRamo3>\n" +
                " <polizzaRiferimento>71001333273</polizzaRiferimento>\n" +
                " <codiceFondo>ISPA0024</codiceFondo>\n" +
                " <denominazioneFondoInvestimento>Nordea 1 Stable Return Fund </denominazioneFondoInvestimento>\n" +
                " <valoreNAV>18.1</valoreNAV>\n" +
                " <dataNav>2016-07-15</dataNav>\n" +
                " <numeroQuote>5540.1661999999996623955667018890380859375</numeroQuote>\n" +
                " <controvaloreQuote>100277.00822</controvaloreQuote>\n" +
                " <isin>LU0351545230</isin>\n" +
                " <idRepository>26332690</idRepository>\n" +
                " <pesoFondo>3.98883</pesoFondo>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                " <isFondoProtetto>false</isFondoProtetto>\n" +
                " <descrizioneInvestimento>Fondi Flessibili</descrizioneInvestimento>\n" +
                " </dettaglioComposizioneInvestimentoRamo3>\n" +
                " </dettagliComposizioneInvestimento>\n" +
                " <composizionePortafoglioPerAssetClass>\n" +
                " <statistiche>\n" +
                " <totale>4818.880933</totale>\n" +
                " <valore>4818.880933</valore>\n" +
                " <percentuale>0.191686</percentuale>\n" +
                " <descrizione>Liquidità</descrizione>\n" +
                " <codiceColore>#7BF9B4</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>3096984.308443</totale>\n" +
                " <valore>1032328.102814</valore>\n" +
                " <percentuale>41.064066</percentuale>\n" +
                " <descrizione>Fondi Obbligazionari</descrizione>\n" +
                " <codiceColore>#BEDA86</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>373838.17702</totale>\n" +
                " <valore>373838.17702</valore>\n" +
                " <percentuale>14.870578</percentuale>\n" +
                " <descrizione>Fondi Azionari</descrizione>\n" +
                " <codiceColore>#D04242</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>19341.31368</totale>\n" +
                " <valore>19341.31368</valore>\n" +
                " <percentuale>0.769361</percentuale>\n" +
                " <descrizione>Fondi Bilanciati</descrizione>\n" +
                " <codiceColore>#D7BBA5</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>5896533.25582</totale>\n" +
                " <valore>982755.542636</valore>\n" +
                " <percentuale>39.092163</percentuale>\n" +
                " <descrizione>Fondi Flessibili</descrizione>\n" +
                " <codiceColore>#E07806</codiceColore>\n" +
                " </statistiche>\n" +
                " </composizionePortafoglioPerAssetClass>\n" +
                " <composizionePortafoglioPerFondoOICR>\n" +
                " <statistiche>\n" +
                " <totale>2513945.167569</totale>\n" +
                " <valore>150531.388658</valore>\n" +
                " <percentuale>5.987854</percentuale>\n" +
                " <descrizione>BlackRock Fixed Income Strategies Fund </descrizione>\n" +
                " <codiceColore>#4572A7</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>2513945.167569</totale>\n" +
                " <valore>151516.537073</valore>\n" +
                " <percentuale>6.027042</percentuale>\n" +
                " <descrizione>M&amp;G Optimal Income Fund </descrizione>\n" +
                " <codiceColore>#AA4643</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>2513945.167569</totale>\n" +
                " <valore>149887.085407</valore>\n" +
                " <percentuale>5.962225</percentuale>\n" +
                " <descrizione>BNY Mellon Absolute Return Bond Fund </descrizione>\n" +
                " <codiceColore>#89A54E</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>2513945.167569</totale>\n" +
                " <valore>101854.563248</valore>\n" +
                " <percentuale>4.051582</percentuale>\n" +
                " <descrizione>Invesco Pan European High Income Fund </descrizione>\n" +
                " <codiceColore>#80699B</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>2513945.167569</totale>\n" +
                " <valore>100277.00822</valore>\n" +
                " <percentuale>3.98883</percentuale>\n" +
                " <descrizione>Nordea 1 Stable Return Fund </descrizione>\n" +
                " <codiceColore>#3D96AE</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>2513945.167569</totale>\n" +
                " <valore>100946.575796</valore>\n" +
                " <percentuale>4.015464</percentuale>\n" +
                " <descrizione>Invesco Global Targeted Returns Fund </descrizione>\n" +
                " <codiceColore>#DB843D</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>2513945.167569</totale>\n" +
                " <valore>7540830.729049999</valore>\n" +
                " <percentuale>59.992005</percentuale>\n" +
                " <descrizione>Synthesis Multiasset 30 </descrizione>\n" +
                " <codiceColore>#92A8CD</codiceColore>\n" +
                " </statistiche>\n" +
                " <statistiche>\n" +
                " <totale>2513945.167569</totale>\n" +
                " <valore>149902.831503</valore>\n" +
                " <percentuale>5.962852</percentuale>\n" +
                " <descrizione>Muzinich Global Tactical Credit Fund </descrizione>\n" +
                " <codiceColore>#A47D7C</codiceColore>\n" +
                " </statistiche>\n" +
                " </composizionePortafoglioPerFondoOICR>\n" +
                " </finanziario>\n" +
                " <contabile>\n" +
                " <totalePremiAnnuiIncassati>5000100.0</totalePremiAnnuiIncassati>\n" +
                " <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                " <totalePremiAnnuiIncassatiConTrasformate>5000100.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
                " <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                " <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                " <dataFinePagamentoPremi>2016-07-08</dataFinePagamentoPremi>\n" +
                " <premiTrasferimentoDaAltriFondi>0.0</premiTrasferimentoDaAltriFondi>\n" +
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
                " <classeCPP>1</classeCPP>\n" +
                " <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                " <caricamentiCPP>\n" +
                " <caricamentoCPPR3>\n" +
                " <descrizione>Premio Unico</descrizione>\n" +
                " <tipoTitolo>02</tipoTitolo>\n" +
                " <percentualeCaricamento>0.0</percentualeCaricamento>\n" +
                " </caricamentoCPPR3>\n" +
                " </caricamentiCPP>\n" +
                " <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
                " <detraibilitaFiscale>\n" +
                " <stato>false</stato>\n" +
                " </detraibilitaFiscale>\n" +
                " <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                " <polizzaScudata>false</polizzaScudata>\n" +
                " <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                " <pegno>false</pegno>\n" +
                " <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                " <tipoClasseBonus></tipoClasseBonus>\n" +
                " <isRiallocazioneGuidata>false</isRiallocazioneGuidata>\n" +
                " <isNoteBloccanti>false</isNoteBloccanti>\n" +
                " </altriDati>\n" +
                " <trasformabile>false</trasformabile>\n" +
                " <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                " <isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>\n" +
                "</polizza>";
    }


    private static String getMockAnomalo(){
        return "<polizza>\n" +
                "    <dataElaborazione>2015-12-01</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>70009333102</numeroPolizza>\n" +
                "        <codiceConferimento>34298190002</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>Migrata IP</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>MIXT1</codice>\n" +
                "            <descrizione>Fondo Pensione Fideuram</descrizione>\n" +
                "            <tipoRamoLayout>X</tipoRamoLayout>\n" +
                "            <garantito>false</garantito>\n" +
                "            <macroFamigliaID>4</macroFamigliaID>\n" +
                "            <descrizioneMacroFamiglia>Fondo Pensione</descrizioneMacroFamiglia>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>F60</codice>\n" +
                "            <descrizione>Previdenza</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>6</ramoMinisteriale>\n" +
                "        <tipoPrestazione>R</tipoPrestazione>\n" +
                "        <tipoPolizza>C</tipoPolizza>\n" +
                "        <dataEmissione>2012-11-13</dataEmissione>\n" +
                "        <dataScadenza>2050-12-31</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "        <tipoSistemaProvenienza>4</tipoSistemaProvenienza>\n" +
                "        <divisa>EUR</divisa>\n" +
                "        <premioDiTariffa>0.0</premioDiTariffa>\n" +
                "        <importoRataBaseIniziale>0.0</importoRataBaseIniziale>\n" +
                "        <pianoVersamentoIniziale>0.0</pianoVersamentoIniziale>\n" +
                "        <durata>0</durata>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>MAMMI</cognome>\n" +
                "                <nome>ELISA</nome>\n" +
                "                <codicefiscale>MMMLSE83E64H223M</codicefiscale>\n" +
                "                <datanascita>1983-05-24</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <professione>LAVORATORI DIPENDENTI DEL SETTORE PRIVATO</professione>\n" +
                "                <vip>false</vip>\n" +
                "                <datiSupplementariAnagraficiPrevidenza>\n" +
                "                    <anzianitaIscrizione>3/0</anzianitaIscrizione>\n" +
                "                    <codiceIscritto>40037058</codiceIscritto>\n" +
                "                    <isVecchioIscritto>false</isVecchioIscritto>\n" +
                "                    <categoriaIscritto>DIPENDENTE</categoriaIscritto>\n" +
                "                </datiSupplementariAnagraficiPrevidenza>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>MAMMI</cognome>\n" +
                "                <nome>ELISA</nome>\n" +
                "                <codicefiscale>MMMLSE83E64H223M</codicefiscale>\n" +
                "                <datanascita>1983-05-24</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <professione>LAVORATORI DIPENDENTI DEL SETTORE PRIVATO</professione>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <datoreDiLavoro>\n" +
                "            <personaGiuridica>\n" +
                "                <formaSocietaria>Previdenza</formaSocietaria>\n" +
                "                <partitaIva>PV990720000</partitaIva>\n" +
                "                <ragioneSociale>-- </ragioneSociale>\n" +
                "            </personaGiuridica>\n" +
                "        </datoreDiLavoro>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>VIA BERTANI 2/D</indirizzo>\n" +
                "            <cap>42027</cap>\n" +
                "            <comune>MONTECCHIO EMILIA</comune>\n" +
                "            <provincia>RE</provincia>\n" +
                "            <regione>Emilia Romagna</regione>\n" +
                "            <nazione>ITALIA</nazione>\n" +
                "            <dataAggiornamento>2014-12-17</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>LAZZARETTI</cognome>\n" +
                "                <nome>FEDERICA</nome>\n" +
                "                <codicefiscale>LZZFRC59L71H223R</codicefiscale>\n" +
                "                <datanascita>1959-07-31</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <dataInizio>1987-12-30</dataInizio>\n" +
                "            <stato>Attivo</stato>\n" +
                "            <livello>Private Banker</livello>\n" +
                "        </banker>\n" +
                "        <isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita>\n" +
                "        <isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte>\n" +
                "        <legaleRappresentante/>\n" +
                "    </figureContrattuali>\n" +
                "    <prestazioni>\n" +
                "        <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>\n" +
                "        <importoBonus>0.0</importoBonus>\n" +
                "        <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>\n" +
                "        <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                "        <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>\n" +
                "        <valorePrestazioniControvalore>0.0</valorePrestazioniControvalore>\n" +
                "        <eccedenza>0.0</eccedenza>\n" +
                "        <opzioni xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
                "        <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                "        <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                "        <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                "        <totalePrestazioniCV>0.0</totalePrestazioniCV>\n" +
                "        <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                "        <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                "        <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                "        <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                "        <prestazioneGarantita>0.0</prestazioneGarantita>\n" +
                "        <totalePrestazioniBase>0.0</totalePrestazioniBase>\n" +
                "        <dataUltimaRivalutazione>2015-10-31</dataUltimaRivalutazione>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>821.81</quoteTotali>\n" +
                "        <controvaloreTotale>15344.8363</controvaloreTotale>\n" +
                "        <dataRiferimentoNAV>2015-10-31</dataRiferimentoNAV>\n" +
                "        <dataElaborazione>2015-12-01</dataElaborazione>\n" +
                "        <isETF>false</isETF>\n" +
                "        <isCustom>false</isCustom>\n" +
                "        <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
                "        <listaAndamentoControvalori>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>14923.075124</valore>\n" +
                "                <data>2015-01-30</data>\n" +
                "                <descrizione>Data Riferimento NAV: 30/01/2015,Investimento contributo (30/01/2015),Spese amministrative prelevate dal versamento (30/01/2015)</descrizione>\n" +
                "                <nome>GENNAIO 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>15473.03868</valore>\n" +
                "                <data>2015-02-27</data>\n" +
                "                <descrizione>Data Riferimento NAV: 27/02/2015,Investimento contributo (27/02/2015)</descrizione>\n" +
                "                <nome>FEBBRAIO 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>15578.23036</valore>\n" +
                "                <data>2015-03-31</data>\n" +
                "                <descrizione>Data Riferimento NAV: 31/03/2015,Nessun evento registrato</descrizione>\n" +
                "                <nome>MARZO 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>15474.6823</valore>\n" +
                "                <data>2015-04-30</data>\n" +
                "                <descrizione>Data Riferimento NAV: 30/04/2015,Nessun evento registrato</descrizione>\n" +
                "                <nome>APRILE 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>15378.53053</valore>\n" +
                "                <data>2015-05-29</data>\n" +
                "                <descrizione>Data Riferimento NAV: 29/05/2015,Nessun evento registrato</descrizione>\n" +
                "                <nome>MAGGIO 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>15030.9049</valore>\n" +
                "                <data>2015-06-30</data>\n" +
                "                <descrizione>Data Riferimento NAV: 30/06/2015,Nessun evento registrato</descrizione>\n" +
                "                <nome>GIUGNO 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>15330.04374</valore>\n" +
                "                <data>2015-07-31</data>\n" +
                "                <descrizione>Data Riferimento NAV: 31/07/2015,Nessun evento registrato</descrizione>\n" +
                "                <nome>LUGLIO 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>14954.47657</valore>\n" +
                "                <data>2015-08-31</data>\n" +
                "                <descrizione>Data Riferimento NAV: 31/08/2015,Nessun evento registrato</descrizione>\n" +
                "                <nome>AGOSTO 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>14955.29838</valore>\n" +
                "                <data>2015-09-30</data>\n" +
                "                <descrizione>Data Riferimento NAV: 30/09/2015,Nessun evento registrato</descrizione>\n" +
                "                <nome>SETTEMBRE 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>15344.83632</valore>\n" +
                "                <data>2015-10-31</data>\n" +
                "                <descrizione>Data Riferimento NAV: 31/10/2015,Nessun evento registrato</descrizione>\n" +
                "                <nome>OTTOBRE 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>15344.83632</valore>\n" +
                "                <data>2015-11-30</data>\n" +
                "                <descrizione>Data Riferimento NAV: 30/11/2015,Nessun evento registrato</descrizione>\n" +
                "                <nome>NOVEMBRE 15</nome>\n" +
                "            </andamentoControvalore>\n" +
                "        </listaAndamentoControvalori>\n" +
                "        <dettagliComposizioneInvestimento>\n" +
                "            <dettaglioComposizioneInvestimentoRamo3>\n" +
                "                <polizzaRiferimento>70009333102</polizzaRiferimento>\n" +
                "                <codiceFondo>30072</codiceFondo>\n" +
                "                <denominazioneFondoInvestimento>FPF EQUILIBRIO</denominazioneFondoInvestimento>\n" +
                "                <valoreNAV>18.672</valoreNAV>\n" +
                "                <dataNav>2015-10-31</dataNav>\n" +
                "                <numeroQuote>821.80999999999994543031789362430572509765625</numeroQuote>\n" +
                "                <controvaloreQuote>15344.83632</controvaloreQuote>\n" +
                "                <idRepository>24979783</idRepository>\n" +
                "                <pesoFondo>100.0</pesoFondo>\n" +
                "                <isETF>false</isETF>\n" +
                "                <isCustom>false</isCustom>\n" +
                "                <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                "                <isFondoProtetto>false</isFondoProtetto>\n" +
                "                <descrizioneInvestimento>Altre Attività Nette</descrizioneInvestimento>\n" +
                "            </dettaglioComposizioneInvestimentoRamo3>\n" +
                "        </dettagliComposizioneInvestimento>\n" +
                "        <composizionePortafoglioPerAssetClass>\n" +
                "            <statistiche>\n" +
                "                <totale>567.758943</totale>\n" +
                "                <valore>567.758943</valore>\n" +
                "                <percentuale>3.7</percentuale>\n" +
                "                <descrizione>Altre Attività Nette</descrizione>\n" +
                "                <codiceColore>#AB9D9D</codiceColore>\n" +
                "            </statistiche>\n" +
                "            <statistiche>\n" +
                "                <totale>4772.244095</totale>\n" +
                "                <valore>4772.244095</valore>\n" +
                "                <percentuale>31.1</percentuale>\n" +
                "                <descrizione>Fondi Azionari</descrizione>\n" +
                "                <codiceColore>#D04242</codiceColore>\n" +
                "            </statistiche>\n" +
                "            <statistiche>\n" +
                "                <totale>10004.83328</totale>\n" +
                "                <valore>10004.83328</valore>\n" +
                "                <percentuale>65.2</percentuale>\n" +
                "                <descrizione>Titoli di Stato</descrizione>\n" +
                "                <codiceColore>#8D9DB5</codiceColore>\n" +
                "            </statistiche>\n" +
                "        </composizionePortafoglioPerAssetClass>\n" +
                "        <composizionePortafoglioPerFondoOICR>\n" +
                "            <statistiche>\n" +
                "                <totale>15344.83632</totale>\n" +
                "                <valore>46034.50896</valore>\n" +
                "                <percentuale>100.0</percentuale>\n" +
                "                <descrizione>FPF EQUILIBRIO</descrizione>\n" +
                "                <codiceColore>#4572A7</codiceColore>\n" +
                "            </statistiche>\n" +
                "        </composizionePortafoglioPerFondoOICR>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>13662.99</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                "        <totalePremiAnnuiIncassatiConTrasformate>13662.99</totalePremiAnnuiIncassatiConTrasformate>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "        <premiTrasferimentoDaAltriFondi>0.0</premiTrasferimentoDaAltriFondi>\n" +
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
                "        <imponibileCongelamento>0.0</imponibileCongelamento>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>true</stato>\n" +
                "            <dataFineBeneficioFiscale>2100-12-13</dataFineBeneficioFiscale>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "        <pegno>false</pegno>\n" +
                "        <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                "        <tipoClasseBonus></tipoClasseBonus>\n" +
                "        <isRiallocazioneGuidata>false</isRiallocazioneGuidata>\n" +
                "        <isNoteBloccanti>false</isNoteBloccanti>\n" +
                "    </altriDati>\n" +
                "    <previdenza>\n" +
                "        <importoContributi>13532.99</importoContributi>\n" +
                "        <importoContributiLordi>13662.99</importoContributiLordi>\n" +
                "        <importoAnticipazione>0.0</importoAnticipazione>\n" +
                "        <valorePosizioneIndividuale>15344.8363</valorePosizioneIndividuale>\n" +
                "        <contributiNonDedotti>0.0</contributiNonDedotti>\n" +
                "        <dataIngressoSistemaPrevidenziale>2012-11-23</dataIngressoSistemaPrevidenziale>\n" +
                "        <dataAdesioneFondo>2012-11-13</dataAdesioneFondo>\n" +
                "        <beneficiarioVita>Aderente</beneficiarioVita>\n" +
                "        <movimentiEventiPrevidenza>\n" +
                "            <movimentoPrevidenza>\n" +
                "                <dataOperazione>2015-02-16</dataOperazione>\n" +
                "                <dataQuota>2015-02-16</dataQuota>\n" +
                "                <causale>Contributo</causale>\n" +
                "                <costi>0.0</costi>\n" +
                "                <iscritto>250.0</iscritto>\n" +
                "                <datore>0.0</datore>\n" +
                "                <tfr>0.0</tfr>\n" +
                "                <totale>250.0</totale>\n" +
                "            </movimentoPrevidenza>\n" +
                "            <movimentoPrevidenza>\n" +
                "                <dataOperazione>2015-01-15</dataOperazione>\n" +
                "                <dataQuota>2015-01-15</dataQuota>\n" +
                "                <causale>Contributo</causale>\n" +
                "                <costi>20.0</costi>\n" +
                "                <iscritto>250.0</iscritto>\n" +
                "                <datore>0.0</datore>\n" +
                "                <tfr>0.0</tfr>\n" +
                "                <totale>250.0</totale>\n" +
                "            </movimentoPrevidenza>\n" +
                "            <movimentoPrevidenza>\n" +
                "                <dataOperazione>2014-12-16</dataOperazione>\n" +
                "                <dataQuota>2014-12-15</dataQuota>\n" +
                "                <causale>Contributo</causale>\n" +
                "                <costi>0.0</costi>\n" +
                "                <iscritto>250.0</iscritto>\n" +
                "                <datore>0.0</datore>\n" +
                "                <tfr>0.0</tfr>\n" +
                "                <totale>250.0</totale>\n" +
                "            </movimentoPrevidenza>\n" +
                "        </movimentiEventiPrevidenza>\n" +
                "        <riepilogoPrevidenza>\n" +
                "            <riepilogo>\n" +
                "                <idComparto>30072</idComparto>\n" +
                "                <descrizioneComparto>FIDEURAM EQUILIBRIO</descrizioneComparto>\n" +
                "                <importoContributi>13532.99</importoContributi>\n" +
                "                <importoAnticipazione>0.0</importoAnticipazione>\n" +
                "                <importoSwitch>0.0</importoSwitch>\n" +
                "                <numeroQuote>821.81</numeroQuote>\n" +
                "                <valoreQuota>18.672</valoreQuota>\n" +
                "                <valorePosizioneIndividuale>15344.8363</valorePosizioneIndividuale>\n" +
                "            </riepilogo>\n" +
                "        </riepilogoPrevidenza>\n" +
                "        <beneficiariMorte>\n" +
                "            <beneficiarioMorte>GIANCARLO MAMMI  0,00%</beneficiarioMorte>\n" +
                "            <beneficiarioMorte>IONE BONIBURINI  0,00%</beneficiarioMorte>\n" +
                "        </beneficiariMorte>\n" +
                "    </previdenza>\n" +
                "    <trasformabile>false</trasformabile>\n" +
                "    <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                "    <isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>\n" +
                "</polizza>";
    }

    public static String getXml(){
        String s="<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza>\n" +
                "    <dataElaborazione>2014-11-28</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>70011293100</numeroPolizza>\n" +
                "        <codiceConferimento>005947RS700</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>ATTIVA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>RS0U1</codice>\n" +
                "            <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                "            <tipoRamoLayout>3</tipoRamoLayout>\n" +
                "            <garantito>false</garantito>\n" +
                "            <macroFamigliaID>1</macroFamigliaID>\n" +
                "            <descrizioneMacroFamiglia>Fideuram Vita Insieme</descrizioneMacroFamiglia>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>931</codice>\n" +
                "            <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>3</ramoMinisteriale>\n" +
                "        <tipoPrestazione>C</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>2013-03-05</dataEmissione>\n" +
                "        <dataScadenza>2100-12-31</dataScadenza>\n" +
                "        <reteVendita>SPI</reteVendita>\n" +
                "        <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                "        <divisa>EUR</divisa>\n" +
                "        <premioDiTariffa>0.0</premioDiTariffa>\n" +
                "        <importoRataBaseIniziale>0.0</importoRataBaseIniziale>\n" +
                "        <pianoVersamentoIniziale>0.0</pianoVersamentoIniziale>\n" +
                "        <durata>37</durata>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>FATICA</cognome>\n" +
                "                <nome>GIOVANNINO</nome>\n" +
                "                <codicefiscale>FTCGNN50B18G086J</codicefiscale>\n" +
                "                <datanascita>1950-02-18</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>FATICA</cognome>\n" +
                "                <nome>GIOVANNINO</nome>\n" +
                "                <codicefiscale>FTCGNN50B18G086J</codicefiscale>\n" +
                "                <datanascita>1950-02-18</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <datoreDiLavoro/>\n" +
                "        <beneficiarioMorte>Gli eredi testamentari dell'Assicurato, o in mancanza gli eredi legittimi, in parti uguali</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>VIA CAPACI 54</indirizzo>\n" +
                "            <cap>00132</cap>\n" +
                "            <comune>ROMA</comune>\n" +
                "            <provincia>RM</provincia>\n" +
                "            <regione>Lazio</regione>\n" +
                "            <nazione>Italia</nazione>\n" +
                "            <dataAggiornamento>2013-03-05</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "            <dataAttivazione>2014-11-11</dataAttivazione>\n" +
                "            <descrizioneTipoFruitore>Area Clienti</descrizioneTipoFruitore>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>IPPOLITI</cognome>\n" +
                "                <nome>FRANCESCO</nome>\n" +
                "                <codicefiscale>PPLFNC64A14H501V</codicefiscale>\n" +
                "                <datanascita>1970-01-01</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <professione/>\n" +
                "                <titolo/>\n" +
                "                <vip>true</vip>\n" +
                "            </privateBanker>\n" +
                "            <dataInizio>2011-10-01</dataInizio>\n" +
                "            <stato>Attivo</stato>\n" +
                "            <livello>Private Banker</livello>\n" +
                "        </banker>\n" +
                "        <isAttivoBeneficiarioVita>false</isAttivoBeneficiarioVita>\n" +
                "        <isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte>\n" +
                "        <legaleRappresentante/>\n" +
                "    </figureContrattuali>\n" +
                "    <prestazioni>\n" +
                "        <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>\n" +
                "        <importoBonus>0.0</importoBonus>\n" +
                "        <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>\n" +
                "        <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                "        <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>\n" +
                "        <valorePrestazioniControvalore>0.0</valorePrestazioniControvalore>\n" +
                "        <eccedenza>0.0</eccedenza>\n" +
                "        <opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/>\n" +
                "        <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                "        <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                "        <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                "        <totalePrestazioniCV>0.0</totalePrestazioniCV>\n" +
                "        <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                "        <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                "        <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                "        <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                "        <prestazioneGarantita>0.0</prestazioneGarantita>\n" +
                "        <totalePrestazioniBase>0.0</totalePrestazioniBase>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>20916.48633</quoteTotali>\n" +
                "        <controvaloreTotale>370196.531038</controvaloreTotale>\n" +
                "        <dataRiferimentoNAV>2014-11-26</dataRiferimentoNAV>\n" +
                "        <dataElaborazione>2014-11-28</dataElaborazione>\n" +
                "        <isETF>false</isETF>\n" +
                "        <isCustom>false</isCustom>\n" +
                "        <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
                "        <listaAndamentoControvalori>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>363878.370898</valore>\n" +
                "                <data>2013-12-31</data>\n" +
                "                <descrizione>Data Riferimento NAV: 31/12/2013,Nessun evento registrato</descrizione>\n" +
                "                <nome>DICEMBRE 13</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>359947.565763</valore>\n" +
                "                <data>2014-01-31</data>\n" +
                "                <descrizione>Data Riferimento NAV: 31/01/2014,Prelievo quote per commissioni di gestione (03/01/2014),Prelievo quote per finanziamento caso morte (03/01/2014),Switch Fondo (21/01/2014)</descrizione>\n" +
                "                <nome>GENNAIO 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>366256.038108</valore>\n" +
                "                <data>2014-02-28</data>\n" +
                "                <descrizione>Data Riferimento NAV: 28/02/2014,Nessun evento registrato</descrizione>\n" +
                "                <nome>FEBBRAIO 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>364978.150924</valore>\n" +
                "                <data>2014-03-31</data>\n" +
                "                <descrizione>Data Riferimento NAV: 31/03/2014,Nessun evento registrato</descrizione>\n" +
                "                <nome>MARZO 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>361220.562432</valore>\n" +
                "                <data>2014-04-30</data>\n" +
                "                <descrizione>Data Riferimento NAV: 30/04/2014,Prelievo quote per commissioni di gestione (02/04/2014),Prelievo quote per finanziamento caso morte (02/04/2014)</descrizione>\n" +
                "                <nome>APRILE 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>364418.482979</valore>\n" +
                "                <data>2014-05-30</data>\n" +
                "                <descrizione>Data Riferimento NAV: 30/05/2014,Nessun evento registrato</descrizione>\n" +
                "                <nome>MAGGIO 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>364023.500715</valore>\n" +
                "                <data>2014-06-30</data>\n" +
                "                <descrizione>Data Riferimento NAV: 30/06/2014,Nessun evento registrato</descrizione>\n" +
                "                <nome>GIUGNO 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>361619.384135</valore>\n" +
                "                <data>2014-07-31</data>\n" +
                "                <descrizione>Data Riferimento NAV: 31/07/2014,Prelievo quote per commissioni di gestione (02/07/2014),Prelievo quote per finanziamento caso morte (02/07/2014)</descrizione>\n" +
                "                <nome>LUGLIO 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>363718.553682</valore>\n" +
                "                <data>2014-08-29</data>\n" +
                "                <descrizione>Data Riferimento NAV: 29/08/2014,Nessun evento registrato</descrizione>\n" +
                "                <nome>AGOSTO 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>368104.281198</valore>\n" +
                "                <data>2014-09-30</data>\n" +
                "                <descrizione>Data Riferimento NAV: 30/09/2014,Nessun evento registrato</descrizione>\n" +
                "                <nome>SETTEMBRE 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>367308.464399</valore>\n" +
                "                <data>2014-10-31</data>\n" +
                "                <descrizione>Data Riferimento NAV: 31/10/2014,Prelievo quote per commissioni di gestione (02/10/2014),Prelievo quote per finanziamento caso morte (02/10/2014)</descrizione>\n" +
                "                <nome>OTTOBRE 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "            <andamentoControvalore>\n" +
                "                <valore>370196.531038</valore>\n" +
                "                <data>2014-11-26</data>\n" +
                "                <descrizione>Data Riferimento NAV: 26/11/2014,Nessun evento registrato</descrizione>\n" +
                "                <nome>NOVEMBRE 14</nome>\n" +
                "            </andamentoControvalore>\n" +
                "        </listaAndamentoControvalori>\n" +
                "        <dettagliComposizioneInvestimento>\n" +
                "            <dettaglioComposizioneInvestimentoRamo3>\n" +
                "                <polizzaRiferimento>70011293100</polizzaRiferimento>\n" +
                "                <codiceFondo>FF002</codiceFondo>\n" +
                "                <denominazioneFondoInvestimento>FIDEURAM FUND MARSHALL WACE TOPS</denominazioneFondoInvestimento>\n" +
                "                <valoreNAV>11.404</valoreNAV>\n" +
                "                <dataNav>2014-11-26</dataNav>\n" +
                "                <numeroQuote>9760.8747199999997974373400211334228515625</numeroQuote>\n" +
                "                <controvaloreQuote>111313.015307</controvaloreQuote>\n" +
                "                <isin>LU0139057037</isin>\n" +
                "                <idRepository>0</idRepository>\n" +
                "                <pesoFondo>30.068627</pesoFondo>\n" +
                "                <isETF>false</isETF>\n" +
                "                <isCustom>false</isCustom>\n" +
                "                <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                "                <isFondoProtetto>false</isFondoProtetto>\n" +
                "            </dettaglioComposizioneInvestimentoRamo3>\n" +
                "            <dettaglioComposizioneInvestimentoRamo3>\n" +
                "                <polizzaRiferimento>70011293100</polizzaRiferimento>\n" +
                "                <codiceFondo>FO022</codiceFondo>\n" +
                "                <denominazioneFondoInvestimento>FONDITALIA FLEXIBLE ITALY \"T\"</denominazioneFondoInvestimento>\n" +
                "                <valoreNAV>13.271</valoreNAV>\n" +
                "                <dataNav>2014-11-26</dataNav>\n" +
                "                <numeroQuote>2792.06539000000020678271539509296417236328125</numeroQuote>\n" +
                "                <controvaloreQuote>37053.499791</controvaloreQuote>\n" +
                "                <isin>LU0553727644</isin>\n" +
                "                <idRepository>0</idRepository>\n" +
                "                <pesoFondo>10.009142</pesoFondo>\n" +
                "                <isETF>false</isETF>\n" +
                "                <isCustom>false</isCustom>\n" +
                "                <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                "                <isFondoProtetto>false</isFondoProtetto>\n" +
                "            </dettaglioComposizioneInvestimentoRamo3>\n" +
                "            <dettaglioComposizioneInvestimentoRamo3>\n" +
                "                <polizzaRiferimento>70011293100</polizzaRiferimento>\n" +
                "                <codiceFondo>FT004</codiceFondo>\n" +
                "                <denominazioneFondoInvestimento>TEMPLETON GLB TOT RETURN \"I\" ACC (EUR H1)</denominazioneFondoInvestimento>\n" +
                "                <valoreNAV>19.77</valoreNAV>\n" +
                "                <dataNav>2014-11-26</dataNav>\n" +
                "                <numeroQuote>2861.453989999999976134859025478363037109375</numeroQuote>\n" +
                "                <controvaloreQuote>56570.945382</controvaloreQuote>\n" +
                "                <isin>LU0316493237</isin>\n" +
                "                <idRepository>0</idRepository>\n" +
                "                <pesoFondo>15.281327</pesoFondo>\n" +
                "                <isETF>false</isETF>\n" +
                "                <isCustom>false</isCustom>\n" +
                "                <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                "                <isFondoProtetto>false</isFondoProtetto>\n" +
                "            </dettaglioComposizioneInvestimentoRamo3>\n" +
                "            <dettaglioComposizioneInvestimentoRamo3>\n" +
                "                <polizzaRiferimento>70011293100</polizzaRiferimento>\n" +
                "                <codiceFondo>IV003</codiceFondo>\n" +
                "                <denominazioneFondoInvestimento>INVESCO EURO CORPORATE BOND \"C\"</denominazioneFondoInvestimento>\n" +
                "                <valoreNAV>17.6815</valoreNAV>\n" +
                "                <dataNav>2014-11-26</dataNav>\n" +
                "                <numeroQuote>2150.10546999999996842234395444393157958984375</numeroQuote>\n" +
                "                <controvaloreQuote>38017.089868</controvaloreQuote>\n" +
                "                <isin>LU0243958047</isin>\n" +
                "                <idRepository>0</idRepository>\n" +
                "                <pesoFondo>10.269434</pesoFondo>\n" +
                "                <isETF>false</isETF>\n" +
                "                <isCustom>false</isCustom>\n" +
                "                <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                "                <isFondoProtetto>false</isFondoProtetto>\n" +
                "            </dettaglioComposizioneInvestimentoRamo3>\n" +
                "            <dettaglioComposizioneInvestimentoRamo3>\n" +
                "                <polizzaRiferimento>70011293100</polizzaRiferimento>\n" +
                "                <codiceFondo>IV005</codiceFondo>\n" +
                "                <denominazioneFondoInvestimento>INVESCO PAN EUROPEAN EQ \"C\"</denominazioneFondoInvestimento>\n" +
                "                <valoreNAV>19.51</valoreNAV>\n" +
                "                <dataNav>2014-11-26</dataNav>\n" +
                "                <numeroQuote>999.5415100000000165891833603382110595703125</numeroQuote>\n" +
                "                <controvaloreQuote>19501.05486</controvaloreQuote>\n" +
                "                <isin>LU0100598282</isin>\n" +
                "                <idRepository>0</idRepository>\n" +
                "                <pesoFondo>5.267757</pesoFondo>\n" +
                "                <isETF>false</isETF>\n" +
                "                <isCustom>false</isCustom>\n" +
                "                <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                "                <isFondoProtetto>false</isFondoProtetto>\n" +
                "            </dettaglioComposizioneInvestimentoRamo3>\n" +
                "            <dettaglioComposizioneInvestimentoRamo3>\n" +
                "                <polizzaRiferimento>70011293100</polizzaRiferimento>\n" +
                "                <codiceFondo>MS001</codiceFondo>\n" +
                "                <denominazioneFondoInvestimento>MSS US ADVANTAGE \"ZH\" ACC</denominazioneFondoInvestimento>\n" +
                "                <valoreNAV>63.11</valoreNAV>\n" +
                "                <dataNav>2014-11-26</dataNav>\n" +
                "                <numeroQuote>853.663729999999986830516718327999114990234375</numeroQuote>\n" +
                "                <controvaloreQuote>53874.718</controvaloreQuote>\n" +
                "                <isin>LU0360484769</isin>\n" +
                "                <idRepository>0</idRepository>\n" +
                "                <pesoFondo>14.553004</pesoFondo>\n" +
                "                <isETF>false</isETF>\n" +
                "                <isCustom>false</isCustom>\n" +
                "                <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                "                <isFondoProtetto>false</isFondoProtetto>\n" +
                "            </dettaglioComposizioneInvestimentoRamo3>\n" +
                "            <dettaglioComposizioneInvestimentoRamo3>\n" +
                "                <polizzaRiferimento>70011293100</polizzaRiferimento>\n" +
                "                <codiceFondo>MS002</codiceFondo>\n" +
                "                <denominazioneFondoInvestimento>MSS DIVERSIFIED ALPHA PLUS \"Z\" ACC</denominazioneFondoInvestimento>\n" +
                "                <valoreNAV>35.94</valoreNAV>\n" +
                "                <dataNav>2014-11-26</dataNav>\n" +
                "                <numeroQuote>1498.78152000000000043655745685100555419921875</numeroQuote>\n" +
                "                <controvaloreQuote>53866.207829</controvaloreQuote>\n" +
                "                <isin>LU0360491038</isin>\n" +
                "                <idRepository>0</idRepository>\n" +
                "                <pesoFondo>14.550705</pesoFondo>\n" +
                "                <isETF>false</isETF>\n" +
                "                <isCustom>false</isCustom>\n" +
                "                <ctvCommissioniNegoziazioniFondo>0.0</ctvCommissioniNegoziazioniFondo>\n" +
                "                <isFondoProtetto>false</isFondoProtetto>\n" +
                "            </dettaglioComposizioneInvestimentoRamo3>\n" +
                "        </dettagliComposizioneInvestimento>\n" +
                "        <composizionePortafoglioPerAssetClass>\n" +
                "            <statistiche>\n" +
                "                <totale>740393.062074</totale>\n" +
                "                <valore>73375.77286</valore>\n" +
                "                <percentuale>19.820761</percentuale>\n" +
                "                <descrizione>Fondi Azionari</descrizione>\n" +
                "                <codiceColore>#D04242</codiceColore>\n" +
                "            </statistiche>\n" +
                "            <statistiche>\n" +
                "                <totale>1480786.124148</totale>\n" +
                "                <valore>258803.668309</valore>\n" +
                "                <percentuale>69.909801</percentuale>\n" +
                "                <descrizione>Fondi Flessibili</descrizione>\n" +
                "                <codiceColore>#E07806</codiceColore>\n" +
                "            </statistiche>\n" +
                "            <statistiche>\n" +
                "                <totale>370196.531037</totale>\n" +
                "                <valore>38017.089868</valore>\n" +
                "                <percentuale>10.269434</percentuale>\n" +
                "                <descrizione>Fondi Obbligazionari</descrizione>\n" +
                "                <codiceColore>#20729C</codiceColore>\n" +
                "            </statistiche>\n" +
                "        </composizionePortafoglioPerAssetClass>\n" +
                "        <composizionePortafoglioPerFondoOICR>\n" +
                "            <statistiche>\n" +
                "                <totale>370196.531037</totale>\n" +
                "                <valore>53874.718</valore>\n" +
                "                <percentuale>14.553004</percentuale>\n" +
                "                <descrizione>MSS US ADVANTAGE \"ZH\" ACC</descrizione>\n" +
                "                <codiceColore>#4572A7</codiceColore>\n" +
                "            </statistiche>\n" +
                "            <statistiche>\n" +
                "                <totale>370196.531037</totale>\n" +
                "                <valore>53866.207829</valore>\n" +
                "                <percentuale>14.550705</percentuale>\n" +
                "                <descrizione>MSS DIVERSIFIED ALPHA PLUS \"Z\" ACC</descrizione>\n" +
                "                <codiceColore>#AA4643</codiceColore>\n" +
                "            </statistiche>\n" +
                "            <statistiche>\n" +
                "                <totale>370196.531037</totale>\n" +
                "                <valore>38017.089868</valore>\n" +
                "                <percentuale>10.269434</percentuale>\n" +
                "                <descrizione>INVESCO EURO CORPORATE BOND \"C\"</descrizione>\n" +
                "                <codiceColore>#89A54E</codiceColore>\n" +
                "            </statistiche>\n" +
                "            <statistiche>\n" +
                "                <totale>370196.531037</totale>\n" +
                "                <valore>111313.015307</valore>\n" +
                "                <percentuale>30.068627</percentuale>\n" +
                "                <descrizione>FIDEURAM FUND MARSHALL WACE TOPS</descrizione>\n" +
                "                <codiceColore>#80699B</codiceColore>\n" +
                "            </statistiche>\n" +
                "            <statistiche>\n" +
                "                <totale>370196.531037</totale>\n" +
                "                <valore>19501.05486</valore>\n" +
                "                <percentuale>5.267757</percentuale>\n" +
                "                <descrizione>INVESCO PAN EUROPEAN EQ \"C\"</descrizione>\n" +
                "                <codiceColore>#3D96AE</codiceColore>\n" +
                "            </statistiche>\n" +
                "            <statistiche>\n" +
                "                <totale>370196.531037</totale>\n" +
                "                <valore>56570.945382</valore>\n" +
                "                <percentuale>15.281327</percentuale>\n" +
                "                <descrizione>TEMPLETON GLB TOT RETURN \"I\" ACC (EUR H1)</descrizione>\n" +
                "                <codiceColore>#DB843D</codiceColore>\n" +
                "            </statistiche>\n" +
                "            <statistiche>\n" +
                "                <totale>370196.531037</totale>\n" +
                "                <valore>37053.499791</valore>\n" +
                "                <percentuale>10.009142</percentuale>\n" +
                "                <descrizione>FONDITALIA FLEXIBLE ITALY \"T\"</descrizione>\n" +
                "                <codiceColore>#92A8CD</codiceColore>\n" +
                "            </statistiche>\n" +
                "        </composizionePortafoglioPerFondoOICR>\n" +
                "        <lineaInvestimento>Linea Multiselection</lineaInvestimento>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>367500.0</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                "        <totalePremiAnnuiIncassatiConTrasformate>367500.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "        <dataFinePagamentoPremi>2013-03-05</dataFinePagamentoPremi>\n" +
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
                "        <imponibileCongelamento>0.0</imponibileCongelamento>\n" +
                "        <classeCPP>C</classeCPP>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <caricamentiCPP>\n" +
                "            <caricamentoCPPR3>\n" +
                "                <descrizione>Premio Unico</descrizione>\n" +
                "                <tipoTitolo>02</tipoTitolo>\n" +
                "                <percentualeCaricamento>0.0</percentualeCaricamento>\n" +
                "            </caricamentoCPPR3>\n" +
                "            <caricamentoCPPR3>\n" +
                "                <descrizione>Rata estemporanea di prima annualita'</descrizione>\n" +
                "                <tipoTitolo>05</tipoTitolo>\n" +
                "                <percentualeCaricamento>0.0</percentualeCaricamento>\n" +
                "            </caricamentoCPPR3>\n" +
                "        </caricamentiCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>90000.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>false</stato>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "        <pegno>false</pegno>\n" +
                "        <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                "    </altriDati>\n" +
                "    <trasformabile>false</trasformabile>\n" +
                "    <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                "</polizza>";

        return s;
    }
    public static String getXmlTrombotto7519574(){
        return "<polizza>\n" +
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

    }
}
