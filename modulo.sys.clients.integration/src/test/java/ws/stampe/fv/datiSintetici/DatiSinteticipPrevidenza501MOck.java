package ws.stampe.fv.datiSintetici;

/**
 * Created by 
 * User: logan
 * Date: 23/04/13
 * Time: 12.24
 */
public class DatiSinteticipPrevidenza501MOck {
    public static String getXml(){

        String s="<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza>\n" +
                "    <dataElaborazione>2014-01-24</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>70002993305</numeroPolizza>\n" +
                "        <codiceConferimento>30898990005</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>Migrata IP</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>90</codice>\n" +
                "            <descrizione>Fondo Pensione Fideuram</descrizione>\n" +
                "            <tipoRamoLayout>6</tipoRamoLayout>\n" +
                "            <garantito>true</garantito>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>F60</codice>\n" +
                "            <descrizione>Previdenza</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>6</ramoMinisteriale>\n" +
                "        <tipoPrestazione>R</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>2010-05-05</dataEmissione>\n" +
                "        <dataScadenza>2100-12-31</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "        <tipoSistemaProvenienza>4</tipoSistemaProvenienza>\n" +
                "        <premioDiTariffa>0.0</premioDiTariffa>\n" +
                "        <importoRataBaseIniziale>0.0</importoRataBaseIniziale>\n" +
                "        <pianoVersamentoIniziale>0.0</pianoVersamentoIniziale>\n" +
                "        <durata>0</durata>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>ALEMANNO</cognome>\n" +
                "                <nome>ANNA MARIA</nome>\n" +
                "                <codicefiscale>LMNNMR73R50F205L</codicefiscale>\n" +
                "                <datanascita>1973-10-10</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>ALEMANNO</cognome>\n" +
                "                <nome>ANNA MARIA</nome>\n" +
                "                <codicefiscale>LMNNMR73R50F205L</codicefiscale>\n" +
                "                <datanascita>1973-10-10</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <datoreDiLavoro>\n" +
                "            <personaGiuridica>\n" +
                "                <codiceFiscaleSocieta>PV830004436</codiceFiscaleSocieta>\n" +
                "                <formaSocietaria>Previdenza</formaSocietaria>\n" +
                "                <partitaIva>PV830004436</partitaIva>\n" +
                "                <ragioneSociale>TECNO NET                                                                                                                                                                                                                                                      </ragioneSociale>\n" +
                "            </personaGiuridica>\n" +
                "        </datoreDiLavoro>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>VIA SANDRO PERTINI N.5</indirizzo>\n" +
                "            <cap>20021</cap>\n" +
                "            <comune>BOLLATE</comune>\n" +
                "            <provincia>MI</provincia>\n" +
                "            <regione>LOMBARDIA                     </regione>\n" +
                "            <nazione>ITALIA</nazione>\n" +
                "            <dataAggiornamento>2014-01-08</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>MORETTI</cognome>\n" +
                "                <nome>ROBERTA</nome>\n" +
                "                <codicefiscale>MRTRRT71T61F205Y</codicefiscale>\n" +
                "                <datanascita>1971-12-21</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <agenzia>\n" +
                "                <indirizzoFiliale>PZZA ERCULEA 9</indirizzoFiliale>\n" +
                "                <localita>MILANO</localita>\n" +
                "                <cap>20122</cap>\n" +
                "                <provincia>MI</provincia>\n" +
                "            </agenzia>\n" +
                "            <dataInizio>1996-10-11</dataInizio>\n" +
                "            <stato>Attivo</stato>\n" +
                "            <livello>Private Banker</livello>\n" +
                "            <rete>BFI</rete>\n" +
                "            <strutturaGerarchica>\n" +
                "                <banker>\n" +
                "                    <id>MRTRRT71T61F205Y</id>\n" +
                "                    <cognome>MORETTI</cognome>\n" +
                "                    <nome>ROBERTA</nome>\n" +
                "                    <livello>Private Banker</livello>\n" +
                "                    <superioreID>BCCPPL62R04M109Z</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>BCCPPL62R04M109Z</id>\n" +
                "                    <cognome>BECCARIA</cognome>\n" +
                "                    <nome>PIERPAOLO</nome>\n" +
                "                    <livello>Regional Manager</livello>\n" +
                "                    <superioreID>BSCMRZ57S28F205O</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>BSCMRZ57S28F205O</id>\n" +
                "                    <cognome>BOSCARIOL</cognome>\n" +
                "                    <nome>MAURIZIO</nome>\n" +
                "                    <livello>Divisional Manager</livello>\n" +
                "                    <superioreID>LBRRRT56T09F205E</superioreID>\n" +
                "                </banker>\n" +
                "                <banker>\n" +
                "                    <id>LBRRRT56T09F205E</id>\n" +
                "                    <cognome>ALBERTARIO</cognome>\n" +
                "                    <nome>ROBERTO</nome>\n" +
                "                    <livello>Area Manager</livello>\n" +
                "                </banker>\n" +
                "            </strutturaGerarchica>\n" +
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
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>290.242</quoteTotali>\n" +
                "        <controvaloreTotale>3864.57223</controvaloreTotale>\n" +
                "        <dataRiferimentoNAV>2013-12-31</dataRiferimentoNAV>\n" +
                "        <isETF>false</isETF>\n" +
                "        <isCustom>false</isCustom>\n" +
                "        <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>0.0</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                "        <totalePremiAnnuiIncassatiConTrasformate>0.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
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
                "        <imponibileCongelamento>0.0</imponibileCongelamento>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>false</stato>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "    </altriDati>\n" +
                "    <previdenza>\n" +
                "        <importoContributi>3235.09</importoContributi>\n" +
                "        <importoAnticipazione>0.0</importoAnticipazione>\n" +
                "        <valorePosizioneIndividuale>3864.5722</valorePosizioneIndividuale>\n" +
                "        <contributiNonDedotti>0.0</contributiNonDedotti>\n" +
                "        <dataIngressoSistemaPrevidenziale>2007-06-19</dataIngressoSistemaPrevidenziale>\n" +
                "        <dataAdesioneFondo>2010-05-05</dataAdesioneFondo>\n" +
                "        <movimentiEventiPrevidenza>\n" +
                "            <movimentoPrevidenza>\n" +
                "                <dataOperazione>2013-10-24</dataOperazione>\n" +
                "                <dataQuota>2013-10-31</dataQuota>\n" +
                "                <causale>Contributo</causale>\n" +
                "                <costi>0.0</costi>\n" +
                "                <iscritto>0.0</iscritto>\n" +
                "                <datore>0.0</datore>\n" +
                "                <tfr>125.17</tfr>\n" +
                "                <totale>125.17</totale>\n" +
                "            </movimentoPrevidenza>\n" +
                "            <movimentoPrevidenza>\n" +
                "                <dataOperazione>2013-07-23</dataOperazione>\n" +
                "                <dataQuota>2013-07-31</dataQuota>\n" +
                "                <causale>Contributo</causale>\n" +
                "                <costi>0.0</costi>\n" +
                "                <iscritto>0.0</iscritto>\n" +
                "                <datore>0.0</datore>\n" +
                "                <tfr>143.28</tfr>\n" +
                "                <totale>143.28</totale>\n" +
                "            </movimentoPrevidenza>\n" +
                "            <movimentoPrevidenza>\n" +
                "                <dataOperazione>2013-04-30</dataOperazione>\n" +
                "                <dataQuota>2013-04-30</dataQuota>\n" +
                "                <causale>Contributo</causale>\n" +
                "                <costi>0.0</costi>\n" +
                "                <iscritto>0.0</iscritto>\n" +
                "                <datore>0.0</datore>\n" +
                "                <tfr>147.66</tfr>\n" +
                "                <totale>147.66</totale>\n" +
                "            </movimentoPrevidenza>\n" +
                "            <movimentoPrevidenza>\n" +
                "                <dataOperazione>2013-01-29</dataOperazione>\n" +
                "                <dataQuota>2013-01-31</dataQuota>\n" +
                "                <causale>Contributo</causale>\n" +
                "                <costi>20.0</costi>\n" +
                "                <iscritto>0.0</iscritto>\n" +
                "                <datore>0.0</datore>\n" +
                "                <tfr>389.6</tfr>\n" +
                "                <totale>409.6</totale>\n" +
                "            </movimentoPrevidenza>\n" +
                "        </movimentiEventiPrevidenza>\n" +
                "        <riepilogoPrevidenza>\n" +
                "            <riepilogo>\n" +
                "                <descrizioneComparto>FIDEURAM CRESCITA</descrizioneComparto>\n" +
                "                <importoContributi>3235.09</importoContributi>\n" +
                "                <importoAnticipazione>0.0</importoAnticipazione>\n" +
                "                <importoSwitch>0.0</importoSwitch>\n" +
                "                <numeroQuote>290.242</numeroQuote>\n" +
                "                <valoreQuota>13.315</valoreQuota>\n" +
                "                <valorePosizioneIndividuale>3864.5722</valorePosizioneIndividuale>\n" +
                "            </riepilogo>\n" +
                "        </riepilogoPrevidenza>\n" +
                "    </previdenza>\n" +
                "    <trasformabile>false</trasformabile>\n" +
                "</polizza>";
        return s;
    }
}
