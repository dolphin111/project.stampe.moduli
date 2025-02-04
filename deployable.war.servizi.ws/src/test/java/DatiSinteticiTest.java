import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 20/03/15
 * Time: 18.10
 */
public class DatiSinteticiTest {
    public static void main(String args[]) throws Exception {
        Stampe s=new Stampe();

        byte[]   b  =   s.getPdfFromXml(getXmlAnomalia(),"5");
       // byte[]   b  =   s.getOdtFromXml(getXml(),"5");
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "DatiSintetici.pdf");
        
        System.out.println("Fine");
    }

    public static String getXml()
    {
        String s="<polizza>\n" +
                "    <dataElaborazione>2015-07-23</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>70011722300</numeroPolizza>\n" +
                "        <codiceConferimento>149539RS000</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>ATTIVA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>RS0U2</codice>\n" +
                "            <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                "            <tipoRamoLayout>3</tipoRamoLayout>\n" +
                "            <garantito>false</garantito>\n" +
                "            <macroFamigliaID>1</macroFamigliaID>\n" +
                "            <descrizioneMacroFamiglia>Fideuram Vita Insieme</descrizioneMacroFamiglia>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>933</codice>\n" +
                "            <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                "       </tariffa>\n" +
                "        <ramoMinisteriale>3</ramoMinisteriale>\n" +
                "        <tipoPrestazione>C</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>2013-03-26</dataEmissione>\n" +
                "        <dataScadenza>2050-12-31</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
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
                "                <cognome>BERTOLINO                     </cognome>\n" +
                "                <nome>OFELIA                        </nome>\n" +
                "                <codicefiscale>BRTFLO46M48A282Y</codicefiscale>\n" +
                "                <datanascita>1946-08-08</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>BERTOLINO                     </cognome>\n" +
                "                <nome>OFELIA                        </nome>\n" +
                "                <codicefiscale>BRTFLO46M48A282Y</codicefiscale>\n" +
                "                <datanascita>1946-08-08</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <datoreDiLavoro/>\n" +
                "        <beneficiarioMorte>Il coniuge dell'assicurato al momento del decesso o, in mancanza, i figli dell'assicurato, nati e nascituri in parti uguali</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>FRAZ.MONTESTRUTTO, 75</indirizzo>\n" +
                "            <cap>10010</cap>\n" +
                "            <comune>SETTIMO VITTONE</comune>\n" +
                "            <provincia>TO</provincia>\n" +
                "            <regione>Piemonte</regione>\n" +
                "            <nazione>Italia                                            </nazione>\n" +
                "            <dataAggiornamento>2003-09-24</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>1</codiceStato>\n" +
                "            <dataAttivazione>2014-01-28</dataAttivazione>\n" +
                "            <descrizioneTipoFruitore>Banca Fideuram</descrizioneTipoFruitore>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>GIGLIO TOS</cognome>\n" +
                "                <nome>SAMUELE</nome>\n" +
                "                <codicefiscale>GGLSML55R19E379D</codicefiscale>\n" +
                "                <datanascita>1955-10-19</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <agenzia>\n" +
                "                <indirizzoFiliale>CSO NIGRA 64</indirizzoFiliale>\n" +
                "                <localita>IVREA</localita>\n" +
                "                <cap>10015</cap>\n" +
                "                <provincia>TO</provincia>\n" +
                "            </agenzia>\n" +
                "            <dataInizio>2013-04-03</dataInizio>\n" +
                "            <stato>Attivo</stato>\n" +
                "            <livello>Superiore Banker</livello>\n" +
                "            <rete>BFI</rete>\n" +
                "            <strutturaGerarchica>\n" +
                "                <banker>\n" +
                "                    <id>GGLSML55R19E379D</id>\n" +
                "                    <cognome>GIGLIO TOS</cognome>\n" +
                "                    <nome>SAMUELE</nome>\n" +
                "                    <livello>Superiore Banker</livello>\n" +
                "                    <superioreID>GRMSBN65M14L219L</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>GRMSBN65M14L219L</id>\n" +
                "                    <cognome>GERMINARIO</cognome>\n" +
                "                    <nome>SABINO</nome>\n" +
                "                    <livello>Regional Manager</livello>\n" +
                "                    <superioreID>BRTVTR64T13L219G</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>BRTVTR64T13L219G</id>\n" +
                "                    <cognome>BERTI</cognome>\n" +
                "                    <nome>VALTER</nome>\n" +
                "                    <livello>Divisional Manager</livello>\n" +
                "                    <superioreID>GRNNTN55B07I158D</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>GRNNTN55B07I158D</id>\n" +
                "                    <cognome>GRANDI</cognome>\n" +
                "                    <nome>ANTONIO</nome>\n" +
                "                    <livello>Area Manager</livello>\n" +
                "                </banker>\n" +
                "            </strutturaGerarchica>\n" +
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
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>16174.91875</quoteTotali>\n" +
                "        <controvaloreTotale>240166.648365</controvaloreTotale>\n" +
                "        <dataRiferimentoNAV>2015-07-21</dataRiferimentoNAV>\n" +
                "        <isETF>false</isETF>\n" +
                "        <isCustom>false</isCustom>\n" +
                "        <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
                "        <tipoRiallocazioneGuidata>\n" +
                "            <codice>Q06  </codice>\n" +
                "            <descrizione>Q06</descrizione>\n" +
                "            <tipoRiallocazione>1</tipoRiallocazione>\n" +
                "            <descrizioneTipoRiallocazione>Portafoglio Consigliato</descrizioneTipoRiallocazione>\n" +
                "            <dataInizioValiditaFV>2015-05-07</dataInizioValiditaFV>\n" +
                "        </tipoRiallocazioneGuidata>\n" +
                "        <lineaInvestimento>Multilinea FV Insieme</lineaInvestimento>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>214000.0</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                "        <totalePremiAnnuiIncassatiConTrasformate>214000.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "        <dataFinePagamentoPremi>2013-03-26</dataFinePagamentoPremi>\n" +
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
                "        <classeCPP>G</classeCPP>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <caricamentiCPP>\n" +
                "            <caricamentoCPPR3>\n" +
                "                <descrizione>Premio Unico</descrizione>\n" +
                "                <tipoTitolo>02</tipoTitolo>\n" +
                "                <percentualeCaricamento>0.0</percentualeCaricamento>\n" +
                "            </caricamentoCPPR3>\n" +
                "            <caricamentoCPPR3>\n" +
                "                <descrizione>Rata estemporanea di annualita' successiva</descrizione>\n" +
                "                <tipoTitolo>06</tipoTitolo>\n" +
                "                <percentualeCaricamento>0.0</percentualeCaricamento>\n" +
                "            </caricamentoCPPR3>\n" +
                "        </caricamentiCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>204000.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>false</stato>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "        <pegno>false</pegno>\n" +
                "        <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                "        <tipoClasseBonus>0</tipoClasseBonus>\n" +
                "        <isRiallocazioneGuidata>false</isRiallocazioneGuidata>\n" +
                "    </altriDati>\n" +
                "    <trasformabile>false</trasformabile>\n" +
                "    <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                "    <isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>\n" +
                "    <dettaglioLinea>\n" +
                "        <codiceLinea>MX</codiceLinea>\n" +
                "        <descrizioneLinea>Linea MIX50</descrizioneLinea>\n" +
                "        <isProtetta>NO</isProtetta>\n" +
                "        <controValoreNav>199830.3452</controValoreNav>\n" +
                "        <controvaloreProtetto>0.0</controvaloreProtetto>\n" +
                "        <percentualeMonetari>0.0</percentualeMonetari>\n" +
                "        <controvaloreMonetari>0.0</controvaloreMonetari>\n" +
                "        <percentualeFondiSelezionatiCliente>0.0</percentualeFondiSelezionatiCliente>\n" +
                "        <controvaloreFondiSelezionatiCliente>0.0</controvaloreFondiSelezionatiCliente>\n" +
                "        <dataRiferimentoNav>2015-07-20</dataRiferimentoNav>\n" +
                "        <controvaloreInProtezione>0.0</controvaloreInProtezione>\n"+
                "    </dettaglioLinea>\n" +
                "    <dettaglioLinea>\n" +
                "        <codiceLinea>C8</codiceLinea>\n" +
                "        <descrizioneLinea>Linea My White Protection 80</descrizioneLinea>\n" +
                "        <isProtetta>SI</isProtetta>\n" +
                "        <controValoreNav>59792.7126</controValoreNav>\n" +
                "        <controvaloreProtetto>47844.89</controvaloreProtetto>\n" +
                "        <percentualeMonetari>8.1326</percentualeMonetari>\n" +
                "        <controvaloreMonetari>4862.6881</controvaloreMonetari>\n" +
                "        <percentualeFondiSelezionatiCliente>91.8674</percentualeFondiSelezionatiCliente>\n" +
                "        <controvaloreFondiSelezionatiCliente>54930.0245</controvaloreFondiSelezionatiCliente>\n" +
                "        <dataRiferimentoNav>2015-07-20</dataRiferimentoNav>\n" +
                "    </dettaglioLinea>\n" +
                "    <dettaglioLinea>\n" +
                "        <codiceLinea>S8</codiceLinea>\n" +
                "        <descrizioneLinea>Linea My Blue Protection 80</descrizioneLinea>\n" +
                "        <isProtetta>SI</isProtetta>\n" +
                "        <controValoreNav>59871.815</controValoreNav>\n" +
                "        <controvaloreProtetto>47905.33</controvaloreProtetto>\n" +
                "        <percentualeMonetari>11.4706</percentualeMonetari>\n" +
                "        <controvaloreMonetari>6867.6314</controvaloreMonetari>\n" +
                "        <percentualeFondiSelezionatiCliente>88.5294</percentualeFondiSelezionatiCliente>\n" +
                "        <controvaloreFondiSelezionatiCliente>53004.1836</controvaloreFondiSelezionatiCliente>\n" +
                "        <dataRiferimentoNav>2015-07-20</dataRiferimentoNav>\n" +
                "    </dettaglioLinea>\n" +
                "    <dettaglioLinea>\n" +
                "        <codiceLinea>GS</codiceLinea>\n" +
                "        <descrizioneLinea>Linea Total Core</descrizioneLinea>\n" +
                "        <isProtetta>NO</isProtetta>\n" +
                "        <controValoreNav>220713.2053</controValoreNav>\n" +
                "        <controvaloreProtetto>0.0</controvaloreProtetto>\n" +
                "        <percentualeMonetari>0.0</percentualeMonetari>\n" +
                "        <controvaloreMonetari>0.0</controvaloreMonetari>\n" +
                "        <percentualeFondiSelezionatiCliente>0.0</percentualeFondiSelezionatiCliente>\n" +
                "        <controvaloreFondiSelezionatiCliente>0.0</controvaloreFondiSelezionatiCliente>\n" +
                "        <dataRiferimentoNav>2015-07-20</dataRiferimentoNav>\n" +
                "    </dettaglioLinea>\n" +
                "    <dettaglioLinea>\n" +
                "        <codiceLinea>MK</codiceLinea>\n" +
                "        <descrizioneLinea>Linea Mix</descrizioneLinea>\n" +
                "        <isProtetta>NO</isProtetta>\n" +
                "        <controValoreNav>2367.1536</controValoreNav>\n" +
                "        <controvaloreProtetto>0.0</controvaloreProtetto>\n" +
                "        <percentualeMonetari>0.0</percentualeMonetari>\n" +
                "        <controvaloreMonetari>0.0</controvaloreMonetari>\n" +
                "        <percentualeFondiSelezionatiCliente>0.0</percentualeFondiSelezionatiCliente>\n" +
                "        <controvaloreFondiSelezionatiCliente>0.0</controvaloreFondiSelezionatiCliente>\n" +
                "        <dataRiferimentoNav>2015-07-20</dataRiferimentoNav>\n" +
                "    </dettaglioLinea>\n" +
                "</polizza>\n";

        return s;
    }

    public static String getXmlAnomalia(){
        //String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza><dataElaborazione>2017-01-24</dataElaborazione><datiTecnici><numeroPolizza>7357195</numeroPolizza><codiceConferimento>06760035404</codiceConferimento><stato>Liquidata</stato><sottostato>STORNATA</sottostato><prodotto><codice>35008</codice><descrizione>Financial Age Protection</descrizione><tipoRamoLayout>3</tipoRamoLayout><garantito>true</garantito><macroFamigliaID>6</macroFamigliaID><descrizioneMacroFamiglia>FAP</descrizioneMacroFamiglia></prodotto><tariffa><codice>950</codice><descrizione>Capitale differito con controassicurazione a premio ricorrente di tipo Unit Linked</descrizione></tariffa><ramoMinisteriale>3</ramoMinisteriale><tipoPrestazione>C</tipoPrestazione><tipoPolizza>A</tipoPolizza><dataEmissione>2003-12-18</dataEmissione><dataScadenza>2016-12-31</dataScadenza><reteVendita>BFI</reteVendita><tipoSistemaProvenienza>1</tipoSistemaProvenienza><divisa>EUR</divisa><premioDiTariffa>0.0</premioDiTariffa><importoRataBaseIniziale>2582.29</importoRataBaseIniziale><pianoVersamentoIniziale>2582.29</pianoVersamentoIniziale><durata>13</durata></datiTecnici><figureContrattuali><contraente><personaFisica><cognome>TROIANI</cognome><nome>VITO</nome><codicefiscale>TRNVTI58A31D612N</codicefiscale><datanascita>1958-01-31</datanascita><sesso>M</sesso><vip>false</vip></personaFisica></contraente><primoAssicurato><personaFisica><cognome>TROIANI</cognome><nome>VITO</nome><codicefiscale>TRNVTI58A31D612N</codicefiscale><datanascita>1958-01-31</datanascita><sesso>M</sesso><vip>false</vip></personaFisica></primoAssicurato><secondoAssicurato/><datoreDiLavoro/><beneficiarioVita>Il Contraente</beneficiarioVita><beneficiarioMorte>Eredi testamentari o legittimi dell' Assicurato</beneficiarioMorte><indirizzoContratto><tipoIndirizzo>POSTALE</tipoIndirizzo><indirizzo>VIA TORCICODA 9</indirizzo><cap>50142</cap><comune>FIRENZE</comune><provincia>FI</provincia><regione>Toscana</regione><nazione>Italia</nazione><dataAggiornamento>1996-12-02</dataAggiornamento></indirizzoContratto><rol><codiceStato>0</codiceStato></rol><banker><privateBanker><cognome>TANGANELLI</cognome><nome>FULVIO</nome><codicefiscale>TNGFLV50H17D612O</codicefiscale><datanascita>1950-06-17</datanascita><sesso>M</sesso><professione>LAVORATORI AUTONOMI E LIBERI PROFESSIONISTI</professione><vip>false</vip></privateBanker><agenzia><indirizzoFiliale>PZA G LA PIRA 10</indirizzoFiliale><localita>POGGIBONSI</localita><cap>53036</cap><provincia>SI</provincia></agenzia><dataInizio>1987-12-30</dataInizio><stato>Attivo</stato><livello>Private Banker</livello><rete>BFI</rete><strutturaGerarchica><banker><id>TNGFLV50H17D612O</id><cognome>TANGANELLI</cognome><nome>FULVIO</nome><livello>Private Banker</livello><superioreID>015063BFI080XXXX</superioreID></banker><banker><id>015063BFI080XXXX</id><cognome>BF UNO</cognome><nome>BANCA FIDEURAM</nome><livello>Area Manager</livello></banker></strutturaGerarchica></banker><isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita><isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte><legaleRappresentante/></figureContrattuali><prestazioni><prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione><importoBonus>0.0</importoBonus><valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito><ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza><valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato><valorePrestazioniControvalore>0.0</valorePrestazioniControvalore><eccedenza>0.0</eccedenza><opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/><renditaACLS75Anno>0.0</renditaACLS75Anno><renditaACLS80Anno>0.0</renditaACLS80Anno><renditaACLS85Anno>0.0</renditaACLS85Anno><totalePrestazioniCV>202964.02</totalePrestazioniCV><capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss><capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss><capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss><capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss><prestazioneGarantita>0.0</prestazioneGarantita><totalePrestazioniBase>0.0</totalePrestazioniBase></prestazioni><finanziario><quoteTotali>0.0</quoteTotali><controvaloreTotale>0.0</controvaloreTotale><isETF>false</isETF><isCustom>false</isCustom></finanziario><contabile><totalePremiAnnuiIncassati>20658.32</totalePremiAnnuiIncassati><totalePremiDaTrasformazioni>72304.02</totalePremiDaTrasformazioni><totalePremiAnnuiIncassatiConTrasformate>92962.34</totalePremiAnnuiIncassatiConTrasformate><totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi><sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare><dataFinePagamentoPremi>2016-12-31</dataFinePagamentoPremi><premiTrasferimentoDaAltriFondi>0.0</premiTrasferimentoDaAltriFondi></contabile><altriDati><vincolo><attivo>false</attivo></vincolo><decumuloCedola><attivo>false</attivo><dettagli><imponibile>0.0</imponibile><importoPagato>0.0</importoPagato><cvn>0.0</cvn><percentuale>0.0</percentuale><importoRata>0.0</importoRata></dettagli></decumuloCedola><imponibileCongelamento>0.0</imponibileCongelamento><classeCPP>H</classeCPP><percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP><caricamentiCPP><caricamentoCPPR3><descrizione>Rata di annualita' successive</descrizione><tipoTitolo>04</tipoTitolo><percentualeCaricamento>0.0</percentualeCaricamento></caricamentoCPPR3></caricamentiCPP><importoPianoProgrammatoVersamenti>134279.08</importoPianoProgrammatoVersamenti><detraibilitaFiscale><stato>false</stato></detraibilitaFiscale><polizzaDerivanteDaTrasformazione>true</polizzaDerivanteDaTrasformazione><polizzaScudata>false</polizzaScudata><impostaBolloMaturata>0.0</impostaBolloMaturata><pegno>false</pegno><isVariazioneContrattuale>false</isVariazioneContrattuale><tipoClasseBonus/><isRiallocazioneGuidata>false</isRiallocazioneGuidata><isNoteBloccanti>false</isNoteBloccanti></altriDati><trasformabile>false</trasformabile><trasformazioneDiFatto>false</trasformazioneDiFatto><isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo></polizza>"  ;
    	String s = "<polizza><dataElaborazione>2017-04-05</dataElaborazione><datiTecnici><numeroPolizza>70012660001</numeroPolizza><codiceConferimento>053842RS501</codiceConferimento><stato>Attiva</stato><sottostato>ATTIVA</sottostato><prodotto><codice>RS0U2</codice><descrizione>Fideuram Vita Insieme</descrizione><tipoRamoLayout>3</tipoRamoLayout><garantito>false</garantito><macroFamigliaID>1</macroFamigliaID><descrizioneMacroFamiglia>Fideuram Vita Insieme</descrizioneMacroFamiglia></prodotto><tariffa><codice>933</codice><descrizione>Fideuram Vita Insieme</descrizione></tariffa><ramoMinisteriale>3</ramoMinisteriale><tipoPrestazione>C</tipoPrestazione><tipoPolizza>A</tipoPolizza><dataEmissione>2013-05-16</dataEmissione><dataScadenza>2050-12-31</dataScadenza><reteVendita>SPI</reteVendita><tipoSistemaProvenienza>1</tipoSistemaProvenienza><divisa>EUR</divisa><premioDiTariffa>115803.11</premioDiTariffa><importoRataBaseIniziale>115803.11</importoRataBaseIniziale><pianoVersamentoIniziale>115803.11</pianoVersamentoIniziale><durata>37</durata><numeroProposta>0</numeroProposta></datiTecnici><figureContrattuali><contraente><personaFisica><cognome>BIAGI</cognome><nome>SERGIO</nome><codicefiscale>BGISRG33R15L719J</codicefiscale><datanascita>1933-10-15</datanascita><sesso>M</sesso><vip>false</vip></personaFisica></contraente><primoAssicurato><personaFisica><cognome>BIAGI</cognome><nome>SERGIO</nome><codicefiscale>BGISRG33R15L719J</codicefiscale><datanascita>1933-10-15</datanascita><sesso>M</sesso><vip>false</vip></personaFisica></primoAssicurato><secondoAssicurato/><datoreDiLavoro/><beneficiarioMorte>Il coniuge dell'assicurato al momento del decesso o, in mancanza, i figli dell'assicurato, nati e nascituri in parti uguali</beneficiarioMorte><indirizzoContratto/><rol><codiceStato>0</codiceStato><dataAttivazione>2013-05-16</dataAttivazione><descrizioneTipoFruitore>Banca Fideuram</descrizioneTipoFruitore></rol><banker><privateBanker><cognome>FRACASSI </cognome><nome>FABIO </nome><codicefiscale>FRCFBA64H28A515U</codicefiscale><datanascita>1964-06-28</datanascita><sesso>M</sesso><professione>LAVORATORI AUTONOMI E LIBERI PROFESSIONISTI</professione><vip>false</vip></privateBanker><agenzia><indirizzoFiliale>VLE J F KENNEDY, 6</indirizzoFiliale><localita>GROTTAFERRATA</localita><cap>00046</cap><provincia>RM</provincia></agenzia><dataInizio>2011-12-12</dataInizio><stato>Attivo</stato><livello>Private Banker</livello><rete>SPI</rete><strutturaGerarchica><banker><id>FRCFBA64H28A515U</id><cognome>FRACASSI </cognome><nome>FABIO </nome><livello>Private Banker</livello><superioreID>FNTLCU63B01I573Z</superioreID></banker><banker><id>FNTLCU63B01I573Z</id><cognome>FONTANA</cognome><nome>LUCA</nome><livello>Superiore Banker</livello><superioreID>BLCCRL60R19H501Y</superioreID></banker><banker><id>BLCCRL60R19H501Y</id><cognome>BALICE</cognome><nome>CARLO</nome><livello>Regional Manager</livello><superioreID>NTLCLD64D27F419D</superioreID></banker><banker><id>NTLCLD64D27F419D</id><cognome>NATALI</cognome><nome>CLAUDIO</nome><livello>Divisional Manager</livello><superioreID>CSTLNG58L28F404N</superioreID></banker><banker><id>CSTLNG58L28F404N</id><cognome>CASTELVERO</cognome><nome>LUCIANO EGIDIO</nome><livello>Area Manager</livello></banker></strutturaGerarchica></banker><isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita><isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte><legaleRappresentante/></figureContrattuali><prestazioni><prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione><importoBonus>0.0</importoBonus><valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito><ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza><valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato><valorePrestazioniControvalore>0.0</valorePrestazioniControvalore><eccedenza>0.0</eccedenza><opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/><renditaACLS75Anno>0.0</renditaACLS75Anno><renditaACLS80Anno>0.0</renditaACLS80Anno><renditaACLS85Anno>0.0</renditaACLS85Anno><totalePrestazioniCV>0.0</totalePrestazioniCV><capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss><capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss><capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss><capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss><prestazioneGarantita>0.0</prestazioneGarantita><totalePrestazioniBase>0.0</totalePrestazioniBase></prestazioni><finanziario><quoteTotali>10340.32021</quoteTotali><controvaloreTotale>114477.685</controvaloreTotale><dataRiferimentoNAV>2017-04-03</dataRiferimentoNAV><isETF>false</isETF><isCustom>false</isCustom><ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni><lineaInvestimento>Multilinea FV Insieme</lineaInvestimento></finanziario><contabile><totalePremiAnnuiIncassati>115803.11</totalePremiAnnuiIncassati><totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni><totalePremiAnnuiIncassatiConTrasformate>115803.11</totalePremiAnnuiIncassatiConTrasformate><totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi><sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare><dataFinePagamentoPremi>2013-05-16</dataFinePagamentoPremi><premiTrasferimentoDaAltriFondi>0.0</premiTrasferimentoDaAltriFondi><isPremioPerDecumulo>false</isPremioPerDecumulo></contabile><altriDati><vincolo><attivo>false</attivo></vincolo><decumuloCedola><attivo>false</attivo><dettagli><imponibile>0.0</imponibile><importoPagato>0.0</importoPagato><cvn>0.0</cvn><percentuale>0.0</percentuale><importoRata>0.0</importoRata></dettagli></decumuloCedola><imponibileCongelamento>0.0</imponibileCongelamento><classeCPP>G</classeCPP><percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP><caricamentiCPP><caricamentoCPPR3><descrizione>Premio Unico</descrizione><tipoTitolo>02</tipoTitolo><percentualeCaricamento>0.0</percentualeCaricamento></caricamentoCPPR3></caricamentiCPP><importoPianoProgrammatoVersamenti>115803.11</importoPianoProgrammatoVersamenti><detraibilitaFiscale><stato>false</stato></detraibilitaFiscale><polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione><polizzaScudata>false</polizzaScudata><impostaBolloMaturata>0.0</impostaBolloMaturata><pegno>false</pegno><isVariazioneContrattuale>false</isVariazioneContrattuale><tipoClasseBonus>0</tipoClasseBonus><isRiallocazioneGuidata>false</isRiallocazioneGuidata><isNoteBloccanti>false</isNoteBloccanti></altriDati><trasformabile>false</trasformabile><trasformazioneDiFatto>false</trasformazioneDiFatto><isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo><dettaglioLinea><codiceLinea>MK</codiceLinea><descrizioneLinea>Linea Mix</descrizioneLinea><isProtetta>NO</isProtetta><controValoreNav>114477.685</controValoreNav><controvaloreProtetto>0.0</controvaloreProtetto><percentualeMonetari>0.0</percentualeMonetari><controvaloreMonetari>0.0</controvaloreMonetari><percentualeFondiSelezionatiCliente>0.0</percentualeFondiSelezionatiCliente><controvaloreFondiSelezionatiCliente>0.0</controvaloreFondiSelezionatiCliente><dataRiferimentoNav>2017-04-03</dataRiferimentoNav><versatoNetto>0.0</versatoNetto><controvaloreInProtezione>0.0</controvaloreInProtezione></dettaglioLinea></polizza>"  ;
        return s;
    }

    public static String getXmlBuono() {
        /*return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza>                                                  \n" +
                "    <dataElaborazione>2016-04-14</dataElaborazione>                                                               \n" +
                "    <datiTecnici>                                                                                                 \n" +
                "        <numeroPolizza>71001137846</numeroPolizza> <codiceConferimento>011942RG008</codiceConferimento>                                                               \n" +
                "        <stato>Attiva</stato>                                                                                     \n" +
                "        <sottostato>ATTIVA</sottostato>                                                                           \n" +
                "        <prodotto>                                                                                                \n" +
                "            <codice>MIXT1</codice>                                                                                \n" +
                "            <descrizione>Synthesis</descrizione>                                                                  \n" +
                "            <tipoRamoLayout>X</tipoRamoLayout>                                                                    \n" +
                "            <macroFamigliaID>1</macroFamigliaID>                                                                  \n" +
                "            <descrizioneMacroFamiglia>Fideuram Vita Insieme</descrizioneMacroFamiglia>                            \n" +
                "        </prodotto>                                                                                               \n" +
                "        <tariffa>                                                                                                 \n" +
                "            <codice>32MB1</codice>                                                                                \n" +
                "            <descrizione>Synthesis</descrizione>                                                                  \n" +
                "        </tariffa>                                                                                                \n" +
                "        <ramoMinisteriale>3</ramoMinisteriale>                                                                    \n" +
                "        <tipoPrestazione>C</tipoPrestazione>                                                                      \n" +
                "        <tipoPolizza>C</tipoPolizza>                                                                              \n" +
                "        <dataEmissione>2015-11-23</dataEmissione>                                                                 \n" +
                "        <dataScadenza>2115-11-23</dataScadenza>                                                                   \n" +
                "        <reteVendita>ISPB</reteVendita>                                                                           \n" +
                "        <tipoSistemaProvenienza>8</tipoSistemaProvenienza>                                                        \n" +
                "        <divisa>EUR</divisa>                                                                                      \n" +
                "        <premioDiTariffa>0.0</premioDiTariffa>                                                                    \n" +
                "        <importoRataBaseIniziale>0.0</importoRataBaseIniziale>                                                    \n" +
                "        <pianoVersamentoIniziale>0.0</pianoVersamentoIniziale>                                                    \n" +
                "        <durata>100</durata>                                                                                      \n" +
                "    </datiTecnici>                                                                                                \n" +
                "    <figureContrattuali>                                                                                          \n" +
                "        <contraente>                                                                                              \n" +
                "            <personaFisica>                                                                                       \n" +
                "                <cognome>AIROLDI</cognome>                                                                        \n" +
                "                <nome>ERNESTO</nome>                                                                              \n" +
                "                <codicefiscale>RLDRST27A27F205Z</codicefiscale>                                                   \n" +
                "                <datanascita>1927-01-27</datanascita>                                                             \n" +
                "                <sesso>M</sesso>                                                                                  \n" +
                "                <vip>false</vip>                                                                                  \n" +
                "            </personaFisica>                                                                                      \n" +
                "        </contraente>                                                                                             \n" +
                "        <primoAssicurato>                                                                                         \n" +
                "            <personaFisica>                                                                                       \n" +
                "                <cognome>AIROLDI</cognome>                                                                        \n" +
                "                <nome>ERNESTO</nome>                                                                              \n" +
                "                <codicefiscale>RLDRST27A27F205Z</codicefiscale>                                                   \n" +
                "                <datanascita>1927-01-27</datanascita>                                                             \n" +
                "                <sesso>M</sesso>                                                                                  \n" +
                "                <vip>false</vip>                                                                                  \n" +
                "            </personaFisica>                                                                                      \n" +
                "        </primoAssicurato>                                                                                        \n" +
                "        <secondoAssicurato/>                                                                                      \n" +
                "        <datoreDiLavoro/>                                                                                         \n" +
                "        <indirizzoContratto>                                                                                      \n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>                                                                \n" +
                "            <indirizzo>VIA MARCANTONIO COLONNA,43</indirizzo>                                                     \n" +
                "            <cap>20149</cap>                                                                                      \n" +
                "            <comune>MILANO</comune>                                                                               \n" +
                "            <provincia>MI</provincia>                                                                             \n" +
                "            <regione>Lombardia</regione>                                                                          \n" +
                "            <nazione>Italia                                            </nazione>                                 \n" +
                "            <dataAggiornamento>2015-11-18</dataAggiornamento>                                                     \n" +
                "        </indirizzoContratto>                                                                                     \n" +
                "        <rol>                                                                                                     \n" +
                "            <codiceStato>0</codiceStato>                                                                          \n" +
                "        </rol>                                                                                                    \n" +
                "        <banker>                                                                                                  \n" +
                "            <privateBanker>                                                                                       \n" +
                "                <cognome>Bolzan </cognome>                                                                        \n" +
                "                <nome>Francesco</nome>                                                                            \n" +
                "                <codicefiscale>U302362BANKERISP</codicefiscale>                                                   \n" +
                "                <vip>false</vip>                                                                                  \n" +
                "            </privateBanker>                                                                                      \n" +
                "            <agenzia/>                                                                                            \n" +
                "            <dataInizio>1900-01-01</dataInizio>                                                                   \n" +
                "            <dataFine>2100-01-01</dataFine>                                                                       \n" +
                "            <stato>Attivo</stato>                                                                                 \n" +
                "            <livello>Private Banker</livello>                                                                     \n" +
                "            <strutturaGerarchica>                                                                                 \n" +
                "                <banker>                                                                                          \n" +
                "                    <id>U302362BANKERISP</id>                                                                     \n" +
                "                    <cognome>Bolzan </cognome>                                                                    \n" +
                "                    <nome>Francesco</nome>                                                                        \n" +
                "                    <livello>Private Banker</livello>                                                             \n" +
                "                    <superioreID>BANCAFIDEURAMISPB</superioreID>                                                  \n" +
                "                </banker>                                                                                         \n" +
                "            </strutturaGerarchica>                                                                                \n" +
                "        </banker>                                                                                                 \n" +
                "        <isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita>                                                 \n" +
                "        <isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte>                                               \n" +
                "        <legaleRappresentante/>                                                                                   \n" +
                "    </figureContrattuali>                                                                                         \n" +
                "    <prestazioni>                                                                                                 \n" +
                "        <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>                    \n" +
                "        <importoBonus>0.0</importoBonus>                                                                          \n" +
                "        <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>                                    \n" +
                "        <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>                                        \n" +
                "        <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>                                                  \n" +
                "        <valorePrestazioniControvalore>385165.58400000003</valorePrestazioniControvalore>                         \n" +
                "        <eccedenza>0.0</eccedenza>                                                                                \n" +
                "        <rendita>                                                                                                 \n" +
                "            <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>                                    \n" +
                "            <stimaTotaleRenditaScadenza>0.0</stimaTotaleRenditaScadenza>                                          \n" +
                "            <isPianoCompletato>false</isPianoCompletato>                                                          \n" +
                "            <stimaTotaleRenditaScadenzaPianoCompletatoSPI>0.0</stimaTotaleRenditaScadenzaPianoCompletatoSPI>      \n" +
                "            <renditaAnnuaVitaliziaMinimaGarantita>0.0</renditaAnnuaVitaliziaMinimaGarantita>                      \n" +
                "            <stimaTotaleRenditaScadenzaPianoNonCompletatoSPI>0.0</stimaTotaleRenditaScadenzaPianoNonCompletatoSPI>\n" +
                "            <renditaTotaleAnnuaLordaPosticipataScadenza>0.0</renditaTotaleAnnuaLordaPosticipataScadenza>          \n" +
                "            <totalePrestazioniRendita>180309.35</totalePrestazioniRendita>                                        \n" +
                "        </rendita>                                                                                                \n" +
                "        <opzioni xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>                           \n" +
        "        <renditaACLS75Anno>0.0</renditaACLS75Anno>                                                                \n" +
                "        <renditaACLS80Anno>0.0</renditaACLS80Anno>                                                                \n" +
                "        <renditaACLS85Anno>0.0</renditaACLS85Anno>                                                                \n" +
                "        <totalePrestazioniCV>0.0</totalePrestazioniCV>                                                            \n" +
                "        <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>                      \n" +
                "        <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>                    \n" +
                "        <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>                        \n" +
                "        <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>                      \n" +
                "        <prestazioneGarantita>0.0</prestazioneGarantita>                                                          \n" +
                "        <totalePrestazioniBase>90070.03</totalePrestazioniBase>                                                   \n" +
                "    </prestazioni>                                                                                                \n" +
                "    <finanziario>                                                                                                 \n" +
                "        <quoteTotali>18923.7653</quoteTotali>                                                                     \n" +
                "        <controvaloreTotale>204856.234</controvaloreTotale>                                                       \n" +
                "        <dataRiferimentoNAV>2016-03-30</dataRiferimentoNAV>                                                       \n" +
                "        <isETF>false</isETF>                                                                                      \n" +
                "        <isCustom>false</isCustom>                                                                                \n" +
                "        <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>                                              \n" +
                "    </finanziario>                                                                                                \n" +
                "    <contabile>                                                                                                   \n" +
                "        <totalePremiAnnuiIncassati>300100.0</totalePremiAnnuiIncassati>                                           \n" +
                "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>                                            \n" +
                "        <totalePremiAnnuiIncassatiConTrasformate>300100.0</totalePremiAnnuiIncassatiConTrasformate>               \n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>                                                \n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>                                              \n" +
                "        <dataFinePagamentoPremi>2015-11-23</dataFinePagamentoPremi>                                               \n" +
                "        <premiTrasferimentoDaAltriFondi>0.0</premiTrasferimentoDaAltriFondi>                                      \n" +
                "    </contabile>                                                                                                  \n" +
                "    <altriDati>                                                                                                   \n" +
                "        <vincolo>                                                                                                 \n" +
                "            <attivo>false</attivo>                                                                                \n" +
                "        </vincolo>                                                                                                \n" +
                "        <decumuloCedola>                                                                                          \n" +
                "            <attivo>false</attivo>                                                                                \n" +
                "            <dettagli>                                                                                            \n" +
                "                <imponibile>0.0</imponibile>                                                                      \n" +
                "                <importoPagato>0.0</importoPagato>                                                                \n" +
                "                <cvn>0.0</cvn>                                                                                    \n" +
                "                <percentuale>0.0</percentuale>                                                                    \n" +
                "                <importoRata>0.0</importoRata>                                                                    \n" +
                "            </dettagli>                                                                                           \n" +
                "        </decumuloCedola>                                                                                         \n" +
                "        <imponibileCongelamento>0.0</imponibileCongelamento>                                                      \n" +
                "        <classeCPP>1</classeCPP>                                                                                  \n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>                                                \n" +
                "        <caricamentiCPP>                                                                                          \n" +
                "            <caricamentoCPPR3>                                                                                    \n" +
                "                <descrizione>Premio Unico</descrizione>                                                           \n" +
                "                <tipoTitolo>02</tipoTitolo>                                                                       \n" +
                "                <percentualeCaricamento>0.0</percentualeCaricamento>                                              \n" +
                "            </caricamentoCPPR3>                                                                                   \n" +
                "        </caricamentiCPP>                                                                                         \n" +
                "        <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>                                \n" +
                "        <detraibilitaFiscale>                                                                                     \n" +
                "            <stato>false</stato>                                                                                  \n" +
                "        </detraibilitaFiscale>                                                                                    \n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>                                \n" +
                "        <polizzaScudata>false</polizzaScudata>                                                                    \n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>                                                          \n" +
                "        <pegno>false</pegno>                                                                                      \n" +
                "        <isVariazioneContrattuale>false</isVariazioneContrattuale>                                                \n" +
                "        <tipoClasseBonus>0</tipoClasseBonus>                                                                       \n" +
                "        <isRiallocazioneGuidata>false</isRiallocazioneGuidata>                                                    \n" +
                "        <isNoteBloccanti>false</isNoteBloccanti>                                                                  \n" +
                "    </altriDati>                                                                                                  \n" +
                "    <trasformabile>false</trasformabile>                                                                          \n" +
                "    <trasformazioneDiFatto>false</trasformazioneDiFatto>                                                          \n" +
                "    <isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>                                                    \n" +
                "</polizza>";
    }






    private static String getAnomalia3(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza>\n" +
                " <dataElaborazione>2015-12-30</dataElaborazione>\n" +
                " <datiTecnici>\n" +
                " <numeroPolizza>7136240</numeroPolizza>\n" +
                " <codiceConferimento>04228535400</codiceConferimento>\n" +
                " <stato>Attiva</stato>\n" +
                " <sottostato>PROROGATA</sottostato>\n" +
                " <prodotto>\n" +
                " <codice>35008</codice>\n" +
                " <descrizione>Financial Age Protection</descrizione>\n" +
                " <tipoRamoLayout>3</tipoRamoLayout>\n" +
                " <garantito>false</garantito>\n" +
                " <macroFamigliaID>2</macroFamigliaID>\n" +
                " </prodotto>\n" +
                " <tariffa>\n" +
                " <codice>950</codice>\n" +
                " <descrizione>Capitale differito con controassicurazione a premio ricorrente di tipo Unit Linked</descrizione>\n" +
                " </tariffa>\n" +
                " <ramoMinisteriale>3</ramoMinisteriale>\n" +
                " <tipoPrestazione>C</tipoPrestazione>\n" +
                " <tipoPolizza>A</tipoPolizza>\n" +
                " <dataEmissione>2003-07-17</dataEmissione>\n" +
                " <dataScadenza>2015-12-31</dataScadenza>\n" +
                " <reteVendita>BFI</reteVendita>\n" +
                " <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                " <divisa>EUR</divisa>\n" +
                " <premioDiTariffa>0.0</premioDiTariffa>\n" +
                " <importoRataBaseIniziale>5600.8</importoRataBaseIniziale>\n" +
                " <pianoVersamentoIniziale>5600.8</pianoVersamentoIniziale>\n" +
                " <durata>12</durata>\n" +
                " </datiTecnici>\n" +
                " <figureContrattuali>\n" +
                " <contraente>\n" +
                " <personaFisica>\n" +
                " <cognome>BORDIGNON</cognome>\n" +
                " <nome>FABRIZIO</nome>\n" +
                " <codicefiscale>BRDFRZ70H22H501T</codicefiscale>\n" +
                " <datanascita>1970-06-22</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </contraente>\n" +
                " <primoAssicurato>\n" +
                " <personaFisica>\n" +
                " <cognome>BORDIGNON</cognome>\n" +
                " <nome>FABRIZIO</nome>\n" +
                " <codicefiscale>BRDFRZ70H22H501T</codicefiscale>\n" +
                " <datanascita>1970-06-22</datanascita>\n" +
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
                " <indirizzo>VIA FIORINO FIORINI 16</indirizzo>\n" +
                " <cap>00152</cap>\n" +
                " <comune>ROMA</comune>\n" +
                " <provincia>RM</provincia>\n" +
                " <regione>Lazio</regione>\n" +
                " <nazione>Italia</nazione>\n" +
                " <dataAggiornamento>2007-04-21</dataAggiornamento>\n" +
                " </indirizzoContratto>\n" +
                " <rol>\n" +
                " <codiceStato>0</codiceStato>\n" +
                " </rol>\n" +
                " <banker>\n" +
                " <privateBanker>\n" +
                " <cognome>FALANGOLA</cognome>\n" +
                " <nome>MIRNA</nome>\n" +
                " <codicefiscale>FLNMRN43S45H501I</codicefiscale>\n" +
                " <datanascita>1943-11-05</datanascita>\n" +
                " <sesso>F</sesso>\n" +
                " <professione>Liberi professionisti </professione>\n" +
                " <vip>false</vip>\n" +
                " </privateBanker>\n" +
                " <agenzia>\n" +
                " <indirizzoFiliale>PZLE GIULIO DOUHET 31</indirizzoFiliale>\n" +
                " <localita>ROMA</localita>\n" +
                " <cap>00143</cap>\n" +
                " <provincia>RM</provincia>\n" +
                " </agenzia>\n" +
                " <dataInizio>1987-12-30</dataInizio>\n" +
                " <stato>Attivo</stato>\n" +
                " <livello>Private Banker</livello>\n" +
                " <rete>BFI</rete>\n" +
                " <strutturaGerarchica>\n" +
                " <banker>\n" +
                " <id>FLNMRN43S45H501I</id>\n" +
                " <cognome>FALANGOLA</cognome>\n" +
                " <nome>MIRNA</nome>\n" +
                " <livello>Private Banker</livello>\n" +
                " <superioreID>GCHMRZ64T18H501W</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>GCHMRZ64T18H501W</id>\n" +
                " <cognome>GIACHE'</cognome>\n" +
                " <nome>MAURIZIO</nome>\n" +
                " <livello>Regional Manager</livello>\n" +
                " <superioreID>NTCMRC63P02H501I</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>NTCMRC63P02H501I</id>\n" +
                " <cognome>ANTICOLI</cognome>\n" +
                " <nome>MARCO</nome>\n" +
                " <livello>Divisional Manager</livello>\n" +
                " <superioreID>PTNGRG54D16F205V</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>PTNGRG54D16F205V</id>\n" +
                " <cognome>PIETANESI</cognome>\n" +
                " <nome>GIORGIO</nome>\n" +
                " <livello>Area Manager</livello>\n" +
                " </banker>\n" +
                " </strutturaGerarchica>\n" +
                " </banker>\n" +
                " <isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita>\n" +
                " <isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte>\n" +
                " <legaleRappresentante/>\n" +
                " </figureContrattuali>\n" +
                " <prestazioni>\n" +
                " <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>\n" +
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
                " <totalePrestazioniCV>0.0</totalePrestazioniCV>\n" +
                " <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                " <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                " <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                " <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                " <prestazioneGarantita>0.0</prestazioneGarantita>\n" +
                " <totalePrestazioniBase>141750.23</totalePrestazioniBase>\n" +
                " </prestazioni>\n" +
                " <finanziario>\n" +
                " <quoteTotali>10873.674</quoteTotali>\n" +
                " <controvaloreTotale>113863.8639</controvaloreTotale>\n" +
                " <dataRiferimentoNAV>2013-11-11</dataRiferimentoNAV>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
                " </finanziario>\n" +
                " <contabile>\n" +
                " <totalePremiAnnuiIncassati>21951.6</totalePremiAnnuiIncassati>\n" +
                " <totalePremiDaTrasformazioni>50746.87</totalePremiDaTrasformazioni>\n" +
                " <totalePremiAnnuiIncassatiConTrasformate>72698.47</totalePremiAnnuiIncassatiConTrasformate>\n" +
                " <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                " <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                " <dataFinePagamentoPremi>2015-12-31</dataFinePagamentoPremi>\n" +
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
                " <imponibileCongelamento>30280.45</imponibileCongelamento>\n" +
                " <classeCPP>H</classeCPP>\n" +
                " <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                " <caricamentiCPP>\n" +
                " <caricamentoCPPR3>\n" +
                " <descrizione>Rata di annualita' successive</descrizione>\n" +
                " <tipoTitolo>04</tipoTitolo>\n" +
                " <percentualeCaricamento>0.0</percentualeCaricamento>\n" +
                " </caricamentoCPPR3>\n" +
                " </caricamentiCPP>\n" +
                " <importoPianoProgrammatoVersamenti>56008.0</importoPianoProgrammatoVersamenti>\n" +
                " <detraibilitaFiscale>\n" +
                " <stato>false</stato>\n" +
                " <dataFineBeneficioFiscale>2008-12-07</dataFineBeneficioFiscale>\n" +
                " </detraibilitaFiscale>\n" +
                " <polizzaDerivanteDaTrasformazione>true</polizzaDerivanteDaTrasformazione>\n" +
                " <polizzaScudata>false</polizzaScudata>\n" +
                " <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                " <pegno>false</pegno>\n" +
                " <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                " <tipoClasseBonus/>\n" +
                " <isRiallocazioneGuidata>false</isRiallocazioneGuidata>\n" +
                " <isNoteBloccanti>false</isNoteBloccanti>\n" +
                " </altriDati>\n" +
                " <trasformabile>false</trasformabile>\n" +
                " <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                " <isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>\n" +
                "</polizza>\n";
    }


    public static String getAnomaliaXml2(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza>\n" +
                "    <dataElaborazione>2015-11-24</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>70008549808</numeroPolizza>\n" +
                "        <codiceConferimento>011942RG008</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>ATTIVA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>RG0T1</codice>\n" +
                "            <descrizione>Fideuram Vita - Garanzia e Valore Plus</descrizione>\n" +
                "            <tipoRamoLayout>1</tipoRamoLayout>\n" +
                "            <garantito>true</garantito>\n" +
                "            <macroFamigliaID>2</macroFamigliaID>\n" +
                "            <descrizioneMacroFamiglia>Garanzia e Valore</descrizioneMacroFamiglia>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>FV1U2</codice>\n" +
                "            <descrizione>Vita intera a premio unico con cedola mg 2,5</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <tipoPrestazione>C</tipoPrestazione>\n" +
                "        <tipoPolizza>C</tipoPolizza>\n" +
                "        <dataEmissione>2012-10-05</dataEmissione>\n" +
                "        <dataScadenza>2050-12-31</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "        <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                "        <divisa>EUR</divisa>\n" +
                "        <premioDiTariffa>0.0</premioDiTariffa>\n" +
                "        <importoRataBaseIniziale>0.0</importoRataBaseIniziale>\n" +
                "        <pianoVersamentoIniziale>0.0</pianoVersamentoIniziale>\n" +
                "        <durata>38</durata>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>IMBRIALE</cognome>\n" +
                "                <nome>MAURIZIO</nome>\n" +
                "                <codicefiscale>MBRMRZ59L01H501O</codicefiscale>\n" +
                "                <datanascita>1959-07-01</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>IMBRIALE</cognome>\n" +
                "                <nome>MAURIZIO</nome>\n" +
                "                <codicefiscale>MBRMRZ59L01H501O</codicefiscale>\n" +
                "                <datanascita>1959-07-01</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <datoreDiLavoro/>\n" +
                "        <beneficiarioVita>Il Contraente</beneficiarioVita>\n" +
                "        <beneficiarioMorte>Il coniuge o,in mancanza, gli eredi legittimi in parti uguali</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>VIA CAIO MARIO 19</indirizzo>\n" +
                "            <cap>00192</cap>\n" +
                "            <comune>ROMA</comune>\n" +
                "            <provincia>RM</provincia>\n" +
                "            <regione>Lazio</regione>\n" +
                "            <nazione>Italia                                            </nazione>\n" +
                "            <dataAggiornamento>2012-10-05</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "            <dataAttivazione>2013-01-09</dataAttivazione>\n" +
                "            <descrizioneTipoFruitore>Banca Fideuram</descrizioneTipoFruitore>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>PEZZUTO</cognome>\n" +
                "                <nome>ROBERTA</nome>\n" +
                "                <codicefiscale>PZZRRT69R41I119F</codicefiscale>\n" +
                "                <datanascita>1969-10-01</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <agenzia>\n" +
                "                <indirizzoFiliale>VIA DI VILLA EMILIANI 10</indirizzoFiliale>\n" +
                "                <localita>ROMA</localita>\n" +
                "                <cap>00197</cap>\n" +
                "                <provincia>RM</provincia>\n" +
                "            </agenzia>\n" +
                "            <dataInizio>1996-11-14</dataInizio>\n" +
                "            <stato>Attivo</stato>\n" +
                "            <livello>Private Banker</livello>\n" +
                "            <rete>BFI</rete>\n" +
                "            <strutturaGerarchica>\n" +
                "                <banker>\n" +
                "                    <id>PZZRRT69R41I119F</id>\n" +
                "                    <cognome>PEZZUTO</cognome>\n" +
                "                    <nome>ROBERTA</nome>\n" +
                "                    <livello>Private Banker</livello>\n" +
                "                    <superioreID>DNGRCR64S26H501M</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>DNGRCR64S26H501M</id>\n" +
                "                    <cognome>DE ANGELIS</cognome>\n" +
                "                    <nome>RICCARDO</nome>\n" +
                "                    <livello>Superiore Banker</livello>\n" +
                "                    <superioreID>RMLMSM56R23H501M</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>RMLMSM56R23H501M</id>\n" +
                "                    <cognome>ROMOLI</cognome>\n" +
                "                    <nome>MASSIMO</nome>\n" +
                "                    <livello>Regional Manager</livello>\n" +
                "                    <superioreID>NTCMRC63P02H501I</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>NTCMRC63P02H501I</id>\n" +
                "                    <cognome>ANTICOLI</cognome>\n" +
                "                    <nome>MARCO</nome>\n" +
                "                    <livello>Divisional Manager</livello>\n" +
                "                    <superioreID>PTNGRG54D16F205V</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>PTNGRG54D16F205V</id>\n" +
                "                    <cognome>PIETANESI</cognome>\n" +
                "                    <nome>GIORGIO</nome>\n" +
                "                    <livello>Area Manager</livello>\n" +
                "                </banker>\n" +
                "            </strutturaGerarchica>\n" +
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
                "        <opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/>\n" +
                "        <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                "        <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                "        <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                "        <totalePrestazioniCV>32000.0</totalePrestazioniCV>\n" +
                "        <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                "        <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                "        <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                "        <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                "        <prestazioneGarantita>32000.0</prestazioneGarantita>\n" +
                "        <totalePrestazioniBase>0.0</totalePrestazioniBase>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "        <isETF>false</isETF>\n" +
                "        <isCustom>false</isCustom>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>32000.0</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                "        <totalePremiAnnuiIncassatiConTrasformate>32000.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "        <dataFinePagamentoPremi>2012-10-05</dataFinePagamentoPremi>\n" +
                "        <premiTrasferimentoDaAltriFondi>0.0</premiTrasferimentoDaAltriFondi>\n" +
                "    </contabile>\n" +
                "    <altriDati>\n" +
                "        <vincolo>\n" +
                "            <attivo>false</attivo>\n" +
                "        </vincolo>\n" +
                "        <decumuloCedola>\n" +
                "            <attivo>true</attivo>\n" +
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
                "        <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>false</stato>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "        <pegno>false</pegno>\n" +
                "        <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                "        <tipoClasseBonus/>\n" +
                "        <isRiallocazioneGuidata>false</isRiallocazioneGuidata>\n" +
                "        <isNoteBloccanti>false</isNoteBloccanti>\n" +
                "    </altriDati>\n" +
                "    <trasformabile>false</trasformabile>\n" +
                "    <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                "    <isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>\n" +
                "</polizza>";

    }

    private static String getAnomaliaXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza>\n" +
                " <dataElaborazione>2015-11-05</dataElaborazione>\n" +
                " <datiTecnici>\n" +
                " <numeroPolizza>70003923111</numeroPolizza>\n" +
                " <codiceConferimento>008942RS011</codiceConferimento>\n" +
                " <stato>Attiva</stato>\n" +
                " <sottostato>ATTIVA</sottostato>\n" +
                " <prodotto>\n" +
                " <codice>RS0U1</codice>\n" +
                " <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                " <tipoRamoLayout>3</tipoRamoLayout>\n" +
                " <garantito>false</garantito>\n" +
                " <macroFamigliaID>1</macroFamigliaID>\n" +
                " <descrizioneMacroFamiglia>Fideuram Vita Insieme</descrizioneMacroFamiglia>\n" +
                " </prodotto>\n" +
                " <tariffa>\n" +
                " <codice>931</codice>\n" +
                " <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                " </tariffa>\n" +
                " <ramoMinisteriale>3</ramoMinisteriale>\n" +
                " <tipoPrestazione>C</tipoPrestazione>\n" +
                " <tipoPolizza>A</tipoPolizza>\n" +
                " <dataEmissione>2011-06-30</dataEmissione>\n" +
                " <dataScadenza>2100-12-31</dataScadenza>\n" +
                " <reteVendita>BFI</reteVendita>\n" +
                " <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                " <divisa>EUR</divisa>\n" +
                " <premioDiTariffa>50000.0</premioDiTariffa>\n" +
                " <importoRataBaseIniziale>0.0</importoRataBaseIniziale>\n" +
                " <pianoVersamentoIniziale>0.0</pianoVersamentoIniziale>\n" +
                " <durata>39</durata>\n" +
                " </datiTecnici>\n" +
                " <figureContrattuali>\n" +
                " <contraente>\n" +
                " <personaFisica>\n" +
                " <cognome>SANTAGATI</cognome>\n" +
                " <nome>FEDERICA</nome>\n" +
                " <codicefiscale>SNTFRC68M61C351L</codicefiscale>\n" +
                " <datanascita>1968-08-21</datanascita>\n" +
                " <sesso>F</sesso>\n" +
                " <professione>LAVORATORI DIPENDENTI DEL SETTORE PUBBLICO</professione>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </contraente>\n" +
                " <primoAssicurato>\n" +
                " <personaFisica>\n" +
                " <cognome>SANTAGATI</cognome>\n" +
                " <nome>FEDERICA</nome>\n" +
                " <codicefiscale>SNTFRC68M61C351L</codicefiscale>\n" +
                " <datanascita>1968-08-21</datanascita>\n" +
                " <sesso>F</sesso>\n" +
                " <professione>LAVORATORI DIPENDENTI DEL SETTORE PUBBLICO</professione>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </primoAssicurato>\n" +
                " <secondoAssicurato/>\n" +
                " <datoreDiLavoro/>\n" +
                " <beneficiarioMorte>Gli eredi testamentari dell'Assicurato, o in mancanza gli eredi legittimi, in parti uguali</beneficiarioMorte>\n" +
                " <indirizzoContratto>\n" +
                " <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                " <indirizzo>PZZA SANTA MARIA DI GESU' 16</indirizzo>\n" +
                " <cap>95123</cap>\n" +
                " <comune>CATANIA</comune>\n" +
                " <provincia>CT</provincia>\n" +
                " <regione>Sicilia</regione>\n" +
                " <nazione>Italia </nazione>\n" +
                " <dataAggiornamento>2011-06-30</dataAggiornamento>\n" +
                " </indirizzoContratto>\n" +
                " <rol>\n" +
                " <codiceStato>0</codiceStato>\n" +
                " <dataAttivazione>2012-01-13</dataAttivazione>\n" +
                " <descrizioneTipoFruitore>Banca Fideuram</descrizioneTipoFruitore>\n" +
                " </rol>\n" +
                " <banker>\n" +
                " <privateBanker>\n" +
                " <cognome>COCI</cognome>\n" +
                " <nome>SALVATORE</nome>\n" +
                " <codicefiscale>CCOSVT72T08C351B</codicefiscale>\n" +
                " <datanascita>1972-12-08</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <professione>LAVORATORI AUTONOMI E LIBERI PROFESSIONISTI</professione>\n" +
                " <vip>false</vip>\n" +
                " </privateBanker>\n" +
                " <agenzia>\n" +
                " <indirizzoFiliale>CSO ITALIA 218</indirizzoFiliale>\n" +
                " <localita>CATANIA</localita>\n" +
                " <cap>95129</cap>\n" +
                " <provincia>CT</provincia>\n" +
                " </agenzia>\n" +
                " <dataInizio>2000-07-28</dataInizio>\n" +
                " <stato>Attivo</stato>\n" +
                " <livello>Private Banker</livello>\n" +
                " <rete>BFI</rete>\n" +
                " <strutturaGerarchica>\n" +
                " <banker>\n" +
                " <id>CCOSVT72T08C351B</id>\n" +
                " <cognome>COCI</cognome>\n" +
                " <nome>SALVATORE</nome>\n" +
                " <livello>Private Banker</livello>\n" +
                " <superioreID>RLNSRG63P21F158T</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>RLNSRG63P21F158T</id>\n" +
                " <cognome>ORLANDO</cognome>\n" +
                " <nome>SERGIO</nome>\n" +
                " <livello>Regional Manager</livello>\n" +
                " <superioreID>PRLFNC59B16L331G</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>PRLFNC59B16L331G</id>\n" +
                " <cognome>PIROLO</cognome>\n" +
                " <nome>FRANCESCO</nome>\n" +
                " <livello>Divisional Manager</livello>\n" +
                " <superioreID>PTNGRG54D16F205V</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>PTNGRG54D16F205V</id>\n" +
                " <cognome>PIETANESI</cognome>\n" +
                " <nome>GIORGIO</nome>\n" +
                " <livello>Area Manager</livello>\n" +
                " </banker>\n" +
                " </strutturaGerarchica>\n" +
                " </banker>\n" +
                " <isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita>\n" +
                " <isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte>\n" +
                " <legaleRappresentante/>\n" +
                " </figureContrattuali>\n" +
                " <prestazioni>\n" +
                " <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>\n" +
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
                " <totalePrestazioniCV>0.0</totalePrestazioniCV>\n" +
                " <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                " <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                " <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                " <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                " <prestazioneGarantita>0.0</prestazioneGarantita>\n" +
                " <totalePrestazioniBase>0.0</totalePrestazioniBase>\n" +
                " </prestazioni>\n" +
                " <finanziario>\n" +
                " <quoteTotali>4150.43012</quoteTotali>\n" +
                " <controvaloreTotale>50916.5651</controvaloreTotale>\n" +
                " <dataRiferimentoNAV>2015-11-03</dataRiferimentoNAV>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
                " <lineaInvestimento>Multilinea FV Insieme</lineaInvestimento>\n" +
                " </finanziario>\n" +
                " <contabile>\n" +
                " <totalePremiAnnuiIncassati>50000.0</totalePremiAnnuiIncassati>\n" +
                " <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                " <totalePremiAnnuiIncassatiConTrasformate>50000.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
                " <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                " <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                " <dataFinePagamentoPremi>2011-06-30</dataFinePagamentoPremi>\n" +
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
                " <classeCPP>C</classeCPP>\n" +
                " <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                " <caricamentiCPP>\n" +
                " <caricamentoCPPR3>\n" +
                " <descrizione>Premio Unico</descrizione>\n" +
                " <tipoTitolo>02</tipoTitolo>\n" +
                " <percentualeCaricamento>0.0</percentualeCaricamento>\n" +
                " </caricamentoCPPR3>\n" +
                " </caricamentiCPP>\n" +
                " <importoPianoProgrammatoVersamenti>50000.0</importoPianoProgrammatoVersamenti>\n" +
                " <detraibilitaFiscale>\n" +
                " <stato>false</stato>\n" +
                " </detraibilitaFiscale>\n" +
                " <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                " <polizzaScudata>false</polizzaScudata>\n" +
                " <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                " <pegno>false</pegno>\n" +
                " <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                " <tipoClasseBonus/>\n" +
                " <isRiallocazioneGuidata>false</isRiallocazioneGuidata>\n" +
                " <isNoteBloccanti>false</isNoteBloccanti>\n" +
                " </altriDati>\n" +
                " <trasformabile>false</trasformabile>\n" +
                " <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                " <isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>\n" +
                " <dettaglioLinea>\n" +
                " <codiceLinea>MK</codiceLinea>\n" +
                " <descrizioneLinea>Linea MK</descrizioneLinea>\n" +
                " <isProtetta>NO</isProtetta>\n" +
                " <controValoreNav>50916.5652</controValoreNav>\n" +
                " <controvaloreProtetto>0.0</controvaloreProtetto>\n" +
                " <percentualeMonetari>0.0</percentualeMonetari>\n" +
                " <controvaloreMonetari>0.0</controvaloreMonetari>\n" +
                " <percentualeFondiSelezionatiCliente>0.0</percentualeFondiSelezionatiCliente>\n" +
                " <controvaloreFondiSelezionatiCliente>0.0</controvaloreFondiSelezionatiCliente>\n" +
                " <dataRiferimentoNav>2015-11-03</dataRiferimentoNav>\n" +
                " <versatoNetto>0.0</versatoNetto>\n" +
                " <controvaloreInProtezione>0.0</controvaloreInProtezione>\n" +
                " </dettaglioLinea>\n" +
                "</polizza>";
    }
    //  "                <imponibile>0.0</imponibile>\n" +
    //  "                <importoPagato>0.0</importoPagato>\n" +
    //  "                <cvn>0.0</cvn>\n" +
    //  "                <percentuale>0.0</percentuale>\n" +
    //  "                <importoRata>0.0</importoRata>\n" +





    public static String getXml2(){

        String s="<polizza>\n" +
                "    <dataElaborazione>2015-07-23</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>70011722300</numeroPolizza>\n" +
                "        <codiceConferimento>149539RS000</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>ATTIVA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>RS0U2</codice>\n" +
                "            <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                "            <tipoRamoLayout>3</tipoRamoLayout>\n" +
                "            <garantito>false</garantito>\n" +
                "            <macroFamigliaID>1</macroFamigliaID>\n" +
                "            <descrizioneMacroFamiglia>Fideuram Vita Insieme</descrizioneMacroFamiglia>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>933</codice>\n" +
                "            <descrizione>Fideuram Vita Insieme</descrizione>\n" +
                "       </tariffa>\n" +
                "        <ramoMinisteriale>3</ramoMinisteriale>\n" +
                "        <tipoPrestazione>C</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>2013-03-26</dataEmissione>\n" +
                "        <dataScadenza>2050-12-31</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
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
                "                <cognome>BERTOLINO                     </cognome>\n" +
                "                <nome>OFELIA                        </nome>\n" +
                "                <codicefiscale>BRTFLO46M48A282Y</codicefiscale>\n" +
                "                <datanascita>1946-08-08</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>BERTOLINO                     </cognome>\n" +
                "                <nome>OFELIA                        </nome>\n" +
                "                <codicefiscale>BRTFLO46M48A282Y</codicefiscale>\n" +
                "                <datanascita>1946-08-08</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <datoreDiLavoro/>\n" +
                "        <beneficiarioMorte>Il coniuge dell'assicurato al momento del decesso o, in mancanza, i figli dell'assicurato, nati e nascituri in parti uguali</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>FRAZ.MONTESTRUTTO, 75</indirizzo>\n" +
                "            <cap>10010</cap>\n" +
                "            <comune>SETTIMO VITTONE</comune>\n" +
                "            <provincia>TO</provincia>\n" +
                "            <regione>Piemonte</regione>\n" +
                "            <nazione>Italia                                            </nazione>\n" +
                "            <dataAggiornamento>2003-09-24</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>1</codiceStato>\n" +
                "            <dataAttivazione>2014-01-28</dataAttivazione>\n" +
                "            <descrizioneTipoFruitore>Banca Fideuram</descrizioneTipoFruitore>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>GIGLIO TOS</cognome>\n" +
                "                <nome>SAMUELE</nome>\n" +
                "                <codicefiscale>GGLSML55R19E379D</codicefiscale>\n" +
                "                <datanascita>1955-10-19</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <agenzia>\n" +
                "                <indirizzoFiliale>CSO NIGRA 64</indirizzoFiliale>\n" +
                "                <localita>IVREA</localita>\n" +
                "                <cap>10015</cap>\n" +
                "                <provincia>TO</provincia>\n" +
                "            </agenzia>\n" +
                "            <dataInizio>2013-04-03</dataInizio>\n" +
                "            <stato>Attivo</stato>\n" +
                "            <livello>Superiore Banker</livello>\n" +
                "            <rete>BFI</rete>\n" +
                "            <strutturaGerarchica>\n" +
                "                <banker>\n" +
                "                    <id>GGLSML55R19E379D</id>\n" +
                "                    <cognome>GIGLIO TOS</cognome>\n" +
                "                    <nome>SAMUELE</nome>\n" +
                "                    <livello>Superiore Banker</livello>\n" +
                "                    <superioreID>GRMSBN65M14L219L</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>GRMSBN65M14L219L</id>\n" +
                "                    <cognome>GERMINARIO</cognome>\n" +
                "                    <nome>SABINO</nome>\n" +
                "                    <livello>Regional Manager</livello>\n" +
                "                    <superioreID>BRTVTR64T13L219G</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>BRTVTR64T13L219G</id>\n" +
                "                    <cognome>BERTI</cognome>\n" +
                "                    <nome>VALTER</nome>\n" +
                "                    <livello>Divisional Manager</livello>\n" +
                "                    <superioreID>GRNNTN55B07I158D</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>GRNNTN55B07I158D</id>\n" +
                "                    <cognome>GRANDI</cognome>\n" +
                "                    <nome>ANTONIO</nome>\n" +
                "                    <livello>Area Manager</livello>\n" +
                "                </banker>\n" +
                "            </strutturaGerarchica>\n" +
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
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>16174.91875</quoteTotali>\n" +
                "        <controvaloreTotale>240166.648365</controvaloreTotale>\n" +
                "        <dataRiferimentoNAV>2015-07-21</dataRiferimentoNAV>\n" +
                "        <isETF>false</isETF>\n" +
                "        <isCustom>false</isCustom>\n" +
                "        <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
                "        <tipoRiallocazioneGuidata>\n" +
                "            <codice>Q06  </codice>\n" +
                "            <descrizione>Q06</descrizione>\n" +
                "            <tipoRiallocazione>1</tipoRiallocazione>\n" +
                "            <descrizioneTipoRiallocazione>Portafoglio Consigliato</descrizioneTipoRiallocazione>\n" +
                "            <dataInizioValiditaFV>2015-05-07</dataInizioValiditaFV>\n" +
                "        </tipoRiallocazioneGuidata>\n" +
                "        <lineaInvestimento>Multilinea FV Insieme</lineaInvestimento>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>214000.0</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                "        <totalePremiAnnuiIncassatiConTrasformate>214000.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "        <dataFinePagamentoPremi>2013-03-26</dataFinePagamentoPremi>\n" +
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
                "        <classeCPP>G</classeCPP>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <caricamentiCPP>\n" +
                "            <caricamentoCPPR3>\n" +
                "                <descrizione>Premio Unico</descrizione>\n" +
                "                <tipoTitolo>02</tipoTitolo>\n" +
                "                <percentualeCaricamento>0.0</percentualeCaricamento>\n" +
                "            </caricamentoCPPR3>\n" +
                "            <caricamentoCPPR3>\n" +
                "                <descrizione>Rata estemporanea di annualita' successiva</descrizione>\n" +
                "                <tipoTitolo>06</tipoTitolo>\n" +
                "                <percentualeCaricamento>0.0</percentualeCaricamento>\n" +
                "            </caricamentoCPPR3>\n" +
                "        </caricamentiCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>204000.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>false</stato>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "        <pegno>false</pegno>\n" +
                "        <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                "        <tipoClasseBonus>0</tipoClasseBonus>\n" +
                "        <isRiallocazioneGuidata>false</isRiallocazioneGuidata>\n" +
                "    </altriDati>\n" +
                "    <trasformabile>false</trasformabile>\n" +
                "    <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                "    <isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>\n" +
                "    <dettaglioLinea>\n" +
                "        <codiceLinea>MX</codiceLinea>\n" +
                "        <descrizioneLinea>Linea MIX50</descrizioneLinea>\n" +
                "        <isProtetta>NO</isProtetta>\n" +
                "        <controValoreNav>199830.3452</controValoreNav>\n" +
                "        <controvaloreProtetto>0.0</controvaloreProtetto>\n" +
                "        <percentualeMonetari>0.0</percentualeMonetari>\n" +
                "        <controvaloreMonetari>0.0</controvaloreMonetari>\n" +
                "        <percentualeFondiSelezionatiCliente>0.0</percentualeFondiSelezionatiCliente>\n" +
                "        <controvaloreFondiSelezionatiCliente>0.0</controvaloreFondiSelezionatiCliente>\n" +
                "        <dataRiferimentoNav>2015-07-20</dataRiferimentoNav>\n" +
                "        <controvaloreInProtezione>0.0</controvaloreInProtezione>\n"+
                "    </dettaglioLinea>\n" +
                "    <dettaglioLinea>\n" +
                "        <codiceLinea>C8</codiceLinea>\n" +
                "        <descrizioneLinea>Linea My White Protection 80</descrizioneLinea>\n" +
                "        <isProtetta>SI</isProtetta>\n" +
                "        <controValoreNav>59792.7126</controValoreNav>\n" +
                "        <controvaloreProtetto>47844.89</controvaloreProtetto>\n" +
                "        <percentualeMonetari>8.1326</percentualeMonetari>\n" +
                "        <controvaloreMonetari>4862.6881</controvaloreMonetari>\n" +
                "        <percentualeFondiSelezionatiCliente>91.8674</percentualeFondiSelezionatiCliente>\n" +
                "        <controvaloreFondiSelezionatiCliente>54930.0245</controvaloreFondiSelezionatiCliente>\n" +
                "        <dataRiferimentoNav>2015-07-20</dataRiferimentoNav>\n" +
                "    </dettaglioLinea>\n" +
                "    <dettaglioLinea>\n" +
                "        <codiceLinea>S8</codiceLinea>\n" +
                "        <descrizioneLinea>Linea My Blue Protection 80</descrizioneLinea>\n" +
                "        <isProtetta>SI</isProtetta>\n" +
                "        <controValoreNav>59871.815</controValoreNav>\n" +
                "        <controvaloreProtetto>47905.33</controvaloreProtetto>\n" +
                "        <percentualeMonetari>11.4706</percentualeMonetari>\n" +
                "        <controvaloreMonetari>6867.6314</controvaloreMonetari>\n" +
                "        <percentualeFondiSelezionatiCliente>88.5294</percentualeFondiSelezionatiCliente>\n" +
                "        <controvaloreFondiSelezionatiCliente>53004.1836</controvaloreFondiSelezionatiCliente>\n" +
                "        <dataRiferimentoNav>2015-07-20</dataRiferimentoNav>\n" +
                "    </dettaglioLinea>\n" +
                "    <dettaglioLinea>\n" +
                "        <codiceLinea>GS</codiceLinea>\n" +
                "        <descrizioneLinea>Linea Total Core</descrizioneLinea>\n" +
                "        <isProtetta>NO</isProtetta>\n" +
                "        <controValoreNav>220713.2053</controValoreNav>\n" +
                "        <controvaloreProtetto>0.0</controvaloreProtetto>\n" +
                "        <percentualeMonetari>0.0</percentualeMonetari>\n" +
                "        <controvaloreMonetari>0.0</controvaloreMonetari>\n" +
                "        <percentualeFondiSelezionatiCliente>0.0</percentualeFondiSelezionatiCliente>\n" +
                "        <controvaloreFondiSelezionatiCliente>0.0</controvaloreFondiSelezionatiCliente>\n" +
                "        <dataRiferimentoNav>2015-07-20</dataRiferimentoNav>\n" +
                "    </dettaglioLinea>\n" +
                "    <dettaglioLinea>\n" +
                "        <codiceLinea>MK</codiceLinea>\n" +
                "        <descrizioneLinea>Linea Mix</descrizioneLinea>\n" +
                "        <isProtetta>NO</isProtetta>\n" +
                "        <controValoreNav>2367.1536</controValoreNav>\n" +
                "        <controvaloreProtetto>0.0</controvaloreProtetto>\n" +
                "        <percentualeMonetari>0.0</percentualeMonetari>\n" +
                "        <controvaloreMonetari>0.0</controvaloreMonetari>\n" +
                "        <percentualeFondiSelezionatiCliente>0.0</percentualeFondiSelezionatiCliente>\n" +
                "        <controvaloreFondiSelezionatiCliente>0.0</controvaloreFondiSelezionatiCliente>\n" +
                "        <dataRiferimentoNav>2015-07-20</dataRiferimentoNav>\n" +
                "    </dettaglioLinea>\n" +
                "</polizza>\n";*/
    	
    	String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza><dataElaborazione>2016-12-01</dataElaborazione><datiTecnici><numeroPolizza>2002198</numeroPolizza><codiceConferimento/><stato>Attiva</stato>"
    			+ "<sottostato>ATTIVA</sottostato><prodotto>"
    			+ "<codice>ADESIONE DIPENDENTI (C. VITA ANTE DL 47/2000)</codice><descrizione>Collettiva-ADESIONE DIPENDENTI (C. VITA ANTE DL 47/2000)</descrizione><tipoRamoLayout>1</tipoRamoLayout><garantito>false</garantito><macroFamigliaID>17</macroFamigliaID><descrizioneMacroFamiglia>Collettiva</descrizioneMacroFamiglia></prodotto><tariffa><codice>047</codice><descrizione>RENDITA VITAL. DIFF. CON CONTR. P.UNICO MASCHI</descrizione></tariffa><ramoMinisteriale>1</ramoMinisteriale><tipoPrestazione>R</tipoPrestazione><tipoPolizza>A</tipoPolizza><dataEmissione>2014-12-31</dataEmissione><dataScadenza>1900-01-01</dataScadenza><reteVendita>BFI</reteVendita><tipoSistemaProvenienza>2</tipoSistemaProvenienza><premioDiTariffa>555.29</premioDiTariffa><importoRataBaseIniziale>0.0</importoRataBaseIniziale><pianoVersamentoIniziale>0.0</pianoVersamentoIniziale><durata>-114</durata></datiTecnici><figureContrattuali><contraente><personaGiuridica><codiceFiscaleSocieta/><formaSocietaria>COLLETTIVE</formaSocietaria><partitaIva>12480730154</partitaIva><ragioneSociale>ATRADIUS CREDIT INSURANCE N.V. </ragioneSociale></personaGiuridica></contraente><primoAssicurato><personaFisica><cognome>LIBURDI</cognome><nome>FELICETTO</nome><codicefiscale>LBRFCT54M01C416F</codicefiscale><datanascita>1954-08-01</datanascita><sesso>M</sesso><professione/><titolo/><vip>false</vip></personaFisica></primoAssicurato><secondoAssicurato/><datoreDiLavoro/><indirizzoContratto/><rol><codiceStato>0</codiceStato></rol><banker><privateBanker><cognome>FRATTI</cognome><nome>MARCO</nome><codicefiscale>FRTMRC63P13H501L</codicefiscale><datanascita>1963-09-13</datanascita><sesso>M</sesso><vip>false</vip></privateBanker><agenzia><indirizzoFiliale>VIA DEL SERAFICO 43</indirizzoFiliale><localita>ROMA</localita><cap>00142</cap><provincia>RM</provincia></agenzia><dataInizio>1989-03-01</dataInizio><stato>Attivo</stato><livello>Private Banker</livello><rete>BFI</rete><strutturaGerarchica><banker><id>FRTMRC63P13H501L</id><cognome>FRATTI</cognome><nome>MARCO</nome><livello>Private Banker</livello><superioreID>NNCGLM67L21H501E</superioreID></banker><banker><id>NNCGLM67L21H501E</id><cognome>INNOCENZI</cognome><nome>GEROLAMO</nome><livello>Regional Manager</livello><superioreID>RSSMSM61P28H501E</superioreID></banker><banker><id>RSSMSM61P28H501E</id><cognome>RUSSO</cognome><nome>MASSIMO</nome><livello>Divisional Manager</livello><superioreID>PTNGRG54D16F205V</superioreID></banker><banker><id>PTNGRG54D16F205V</id><cognome>PIETANESI</cognome><nome>GIORGIO</nome><livello>Area Manager</livello></banker></strutturaGerarchica></banker><isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita><isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte><legaleRappresentante/></figureContrattuali><prestazioni><prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione><importoBonus>0.0</importoBonus><valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito><ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza><valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato><valorePrestazioniControvalore>0.0</valorePrestazioniControvalore><eccedenza>0.0</eccedenza><opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/><renditaACLS75Anno>0.0</renditaACLS75Anno><renditaACLS80Anno>0.0</renditaACLS80Anno><renditaACLS85Anno>0.0</renditaACLS85Anno><totalePrestazioniCV>4658.71</totalePrestazioniCV><capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss><capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss><capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss><capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss><prestazioneGarantita>0.0</prestazioneGarantita><totalePrestazioniBase>317.77</totalePrestazioniBase></prestazioni><finanziario><quoteTotali>0.0</quoteTotali><controvaloreTotale>0.0</controvaloreTotale><isETF>false</isETF><isCustom>false</isCustom></finanziario><contabile><totalePremiAnnuiIncassati>0.0</totalePremiAnnuiIncassati><totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni><totalePremiAnnuiIncassatiConTrasformate>0.0</totalePremiAnnuiIncassatiConTrasformate><totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi><sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare><dataFinePagamentoPremi>1900-01-01</dataFinePagamentoPremi><premiTrasferimentoDaAltriFondi>0.0</premiTrasferimentoDaAltriFondi></contabile><altriDati><vincolo><attivo>false</attivo></vincolo><decumuloCedola><attivo>false</attivo><dettagli><imponibile>0.0</imponibile><importoPagato>0.0</importoPagato><cvn>0.0</cvn><percentuale>0.0</percentuale><importoRata>0.0</importoRata></dettagli></decumuloCedola><imponibileCongelamento>0.0</imponibileCongelamento><percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP><importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti><detraibilitaFiscale><stato>false</stato></detraibilitaFiscale><polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione><polizzaScudata>false</polizzaScudata><impostaBolloMaturata>0.0</impostaBolloMaturata><pegno>false</pegno><isVariazioneContrattuale>false</isVariazioneContrattuale><tipoClasseBonus/><isRiallocazioneGuidata>false</isRiallocazioneGuidata><isNoteBloccanti>false</isNoteBloccanti></altriDati><trasformabile>false</trasformabile><trasformazioneDiFatto>false</trasformazioneDiFatto><isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo></polizza>";
    			

        return s;
    }
}
