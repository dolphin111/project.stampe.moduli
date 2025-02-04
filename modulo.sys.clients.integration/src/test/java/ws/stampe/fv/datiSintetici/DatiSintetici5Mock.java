package ws.stampe.fv.datiSintetici;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 14/02/14
 * Time: 10.14
 */
public class DatiSintetici5Mock {

    public static String getXml(){

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
}
