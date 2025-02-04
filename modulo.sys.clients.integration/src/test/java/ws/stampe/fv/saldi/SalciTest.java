package ws.stampe.fv.saldi;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Risposta;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.TrasportBean;
import com.fideuram.utils.LoggingUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 28/11/14
 * Time: 15.33
 */
public class SalciTest  extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SalciTest.class );
    }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("12");
        //trasportBean.setXml(SaldiiMock.getXml());
        trasportBean.setXml(getMockAnomalo());
        //trasportBean.setXml(SaldiiMock.getXmlTrombotto7519574());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generateOdt(trasportBean);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "SaldiAsset.odt");
            //Risposta r =Stampe.generatePdf(trasportBean);
            //StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "SaldiAsset.pdf");
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }


    private String getMockAnomalo(){
        return "<polizza>\n" +
                "    <dataElaborazione>2015-12-01</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>70009333102</numeroPolizza>\n" +
                "        <codiceConferimento>34298190002</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>Migrata IP</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>90</codice>\n" +
                "            <descrizione>Fondo Pensione Fideuram</descrizione>\n" +
                "            <tipoRamoLayout>6</tipoRamoLayout>\n" +
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
}
