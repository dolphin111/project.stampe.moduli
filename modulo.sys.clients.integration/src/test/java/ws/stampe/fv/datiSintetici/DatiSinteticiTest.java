package ws.stampe.fv.datiSintetici;

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
 * User: v801068
 * Date: 14/02/14
 * Time: 10.16
 */
public class DatiSinteticiTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(DatiSinteticiTest.class );
    }


    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("5");
        //trasportBean.setXml(DatiSintetici5Mock.getXmlAnomalia());
        trasportBean.setXml(getXmlAnomalia());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "EsitoTestDatiSintetici.pdf");
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }

    private static String getAnomalia3(){
        return "<polizza>\n" +
                " <dataElaborazione>2015-12-03</dataElaborazione>\n" +
                " <datiTecnici>\n" +
                " <numeroPolizza>70014840002</numeroPolizza>\n" +
                " <codiceConferimento>013340RP002</codiceConferimento>\n" +
                " <stato>Attiva</stato>\n" +
                " <sottostato>ATTIVA</sottostato>\n" +
                " <prodotto>\n" +
                " <codice>RP </codice>\n" +
                " <descrizione>Fideuram Vita - Garanzia e Valore</descrizione>\n" +
                " <tipoRamoLayout>1</tipoRamoLayout>\n" +
                " <garantito>true</garantito>\n" +
                " <macroFamigliaID>2</macroFamigliaID>\n" +
                " <descrizioneMacroFamiglia>Garanzia e Valore</descrizioneMacroFamiglia>\n" +
                " </prodotto>\n" +
                " <tariffa>\n" +
                " <codice>FV1U1</codice>\n" +
                " <descrizione>Vita intera a premio unico con cedola rmg 1,8</descrizione>\n" +
                " </tariffa>\n" +
                " <ramoMinisteriale>1</ramoMinisteriale>\n" +
                " <tipoPrestazione>C</tipoPrestazione>\n" +
                " <tipoPolizza>C</tipoPolizza>\n" +
                " <dataEmissione>2013-12-19</dataEmissione>\n" +
                " <dataScadenza>2050-12-31</dataScadenza>\n" +
                " <reteVendita>BFI</reteVendita>\n" +
                " <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                " <divisa>EUR</divisa>\n" +
                " <premioDiTariffa>0.0</premioDiTariffa>\n" +
                " <importoRataBaseIniziale>0.0</importoRataBaseIniziale>\n" +
                " <pianoVersamentoIniziale>0.0</pianoVersamentoIniziale>\n" +
                " <durata>37</durata>\n" +
                " </datiTecnici>\n" +
                " <figureContrattuali>\n" +
                " <contraente>\n" +
                " <personaFisica>\n" +
                " <cognome>CALTAGIRONE</cognome>\n" +
                " <nome>FRANCESCO</nome>\n" +
                " <codicefiscale>CLTFNC48P08A089W</codicefiscale>\n" +
                " <datanascita>1948-09-08</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </contraente>\n" +
                " <primoAssicurato>\n" +
                " <personaFisica>\n" +
                " <cognome>CALTAGIRONE</cognome>\n" +
                " <nome>FRANCESCO</nome>\n" +
                " <codicefiscale>CLTFNC48P08A089W</codicefiscale>\n" +
                " <datanascita>1948-09-08</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <vip>false</vip>\n" +
                " </personaFisica>\n" +
                " </primoAssicurato>\n" +
                " <secondoAssicurato/>\n" +
                " <datoreDiLavoro/>\n" +
                " <beneficiarioVita>Il Contraente</beneficiarioVita>\n" +
                " <beneficiarioMorte>POMARELLI LUCIA 100,00%</beneficiarioMorte>\n" +
                " <indirizzoContratto>\n" +
                " <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                " <indirizzo>VIA F SUBACCHI 6</indirizzo>\n" +
                " <cap>29020</cap>\n" +
                " <comune>GOSSOLENGO</comune>\n" +
                " <provincia>PC</provincia>\n" +
                " <regione>Emilia Romagna</regione>\n" +
                " <nazione>Italia </nazione>\n" +
                " <dataAggiornamento>2013-12-23</dataAggiornamento>\n" +
                " </indirizzoContratto>\n" +
                " <rol>\n" +
                " <codiceStato>0</codiceStato>\n" +
                " </rol>\n" +
                " <banker>\n" +
                " <privateBanker>\n" +
                " <cognome>GHITTONI</cognome>\n" +
                " <nome>GIUSEPPE</nome>\n" +
                " <codicefiscale>GHTGPP74C30C261Z</codicefiscale>\n" +
                " <datanascita>1974-03-30</datanascita>\n" +
                " <sesso>M</sesso>\n" +
                " <professione>LAVORATORI AUTONOMI E LIBERI PROFESSIONISTI</professione>\n" +
                " <vip>false</vip>\n" +
                " </privateBanker>\n" +
                " <agenzia>\n" +
                " <indirizzoFiliale>VIA GIUSEPPE MANFREDI 105/107</indirizzoFiliale>\n" +
                " <localita>PIACENZA</localita>\n" +
                " <cap>29122</cap>\n" +
                " <provincia>PC</provincia>\n" +
                " </agenzia>\n" +
                " <dataInizio>2008-03-05</dataInizio>\n" +
                " <stato>Attivo</stato>\n" +
                " <livello>Superiore Banker</livello>\n" +
                " <rete>BFI</rete>\n" +
                " <strutturaGerarchica>\n" +
                " <banker>\n" +
                " <id>GHTGPP74C30C261Z</id>\n" +
                " <cognome>GHITTONI</cognome>\n" +
                " <nome>GIUSEPPE</nome>\n" +
                " <livello>Superiore Banker</livello>\n" +
                " <superioreID>SCRLGU61R11A944X</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>SCRLGU61R11A944X</id>\n" +
                " <cognome>SCARPA</cognome>\n" +
                " <nome>LUIGI</nome>\n" +
                " <livello>Regional Manager</livello>\n" +
                " <superioreID>PLMRRT61D22A944K</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>PLMRRT61D22A944K</id>\n" +
                " <cognome>PALMIERI</cognome>\n" +
                " <nome>ROBERTO</nome>\n" +
                " <livello>Divisional Manager</livello>\n" +
                " <superioreID>VNTLRS62P30G972H</superioreID>\n" +
                " </banker>\n" +
                " <banker>\n" +
                " <id>VNTLRS62P30G972H</id>\n" +
                " <cognome>VENTURA</cognome>\n" +
                " <nome>LORIS</nome>\n" +
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
                " <opzioni xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
                " <renditaACLS75Anno>0.0</renditaACLS75Anno>\n" +
                " <renditaACLS80Anno>0.0</renditaACLS80Anno>\n" +
                " <renditaACLS85Anno>0.0</renditaACLS85Anno>\n" +
                " <totalePrestazioniCV>19000.0</totalePrestazioniCV>\n" +
                " <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                " <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                " <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                " <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                " <prestazioneGarantita>19000.0</prestazioneGarantita>\n" +
                " <totalePrestazioniBase>0.0</totalePrestazioniBase>\n" +
                " </prestazioni>\n" +
                " <finanziario>\n" +
                " <quoteTotali>0.0</quoteTotali>\n" +
                " <controvaloreTotale>0.0</controvaloreTotale>\n" +
                " <isETF>false</isETF>\n" +
                " <isCustom>false</isCustom>\n" +
                " </finanziario>\n" +
                " <contabile>\n" +
                " <totalePremiAnnuiIncassati>19000.0</totalePremiAnnuiIncassati>\n" +
                " <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                " <totalePremiAnnuiIncassatiConTrasformate>19000.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
                " <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                " <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                " <dataFinePagamentoPremi>2013-12-19</dataFinePagamentoPremi>\n" +
                " <premiTrasferimentoDaAltriFondi>0.0</premiTrasferimentoDaAltriFondi>\n" +
                " </contabile>\n" +
                " <altriDati>\n" +
                " <vincolo>\n" +
                " <attivo>false</attivo>\n" +
                " </vincolo>\n" +
                " <decumuloCedola>\n" +
                " <attivo>true</attivo>\n" +
                " </decumuloCedola>\n" +
                " <imponibileCongelamento>0.0</imponibileCongelamento>\n" +
                " <classeCPP>C</classeCPP>\n" +
                " <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
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

   private String getAnomaliaXml(){
         return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza>\n" +
                 "    <dataElaborazione>2015-09-04</dataElaborazione>\n" +
                 "    <datiTecnici>\n" +
                 "        <numeroPolizza>7693266</numeroPolizza>\n" +
                 "        <codiceConferimento>03489518508</codiceConferimento>\n" +
                 "        <stato>Liquidata</stato>\n" +
                 "        <sottostato>STORNATA</sottostato>\n" +
                 "        <prodotto>\n" +
                 "            <codice>18003</codice>\n" +
                 "            <descrizione>Financial Age Protection 2</descrizione>\n" +
                 "            <tipoRamoLayout>3</tipoRamoLayout>\n" +
                 "            <garantito>true</garantito>\n" +
                 "            <macroFamigliaID>6</macroFamigliaID>\n" +
                 "            <descrizioneMacroFamiglia>FAP</descrizioneMacroFamiglia>\n" +
                 "        </prodotto>\n" +
                 "        <tariffa>\n" +
                 "            <codice>959</codice>\n" +
                 "            <descrizione>Capitale differito con controassicurazione a premio ricorrente di tipo Unit Linked</descrizione>\n" +
                 "        </tariffa>\n" +
                 "        <ramoMinisteriale>3</ramoMinisteriale>\n" +
                 "        <tipoPrestazione>C</tipoPrestazione>\n" +
                 "        <tipoPolizza>A</tipoPolizza>\n" +
                 "        <dataEmissione>2004-09-15</dataEmissione>\n" +
                 "        <dataScadenza>2016-12-31</dataScadenza>\n" +
                 "        <reteVendita>SPI</reteVendita>\n" +
                 "        <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                 "        <divisa>EUR</divisa>\n" +
                 "        <premioDiTariffa>2000.0</premioDiTariffa>\n" +
                 "        <importoRataBaseIniziale>2000.0</importoRataBaseIniziale>\n" +
                 "        <pianoVersamentoIniziale>2000.0</pianoVersamentoIniziale>\n" +
                 "        <durata>12</durata>\n" +
                 "    </datiTecnici>\n" +
                 "    <figureContrattuali>\n" +
                 "        <contraente>\n" +
                 "            <personaFisica>\n" +
                 "                <cognome>ZECCA</cognome>\n" +
                 "                <nome>VINCENZA</nome>\n" +
                 "                <codicefiscale>ZCCVCN53A63I887V</codicefiscale>\n" +
                 "                <datanascita>1953-01-23</datanascita>\n" +
                 "                <sesso>F</sesso>\n" +
                 "                <vip>false</vip>\n" +
                 "            </personaFisica>\n" +
                 "        </contraente>\n" +
                 "        <primoAssicurato>\n" +
                 "            <personaFisica>\n" +
                 "                <cognome>ZECCA</cognome>\n" +
                 "                <nome>VINCENZA</nome>\n" +
                 "                <codicefiscale>ZCCVCN53A63I887V</codicefiscale>\n" +
                 "                <datanascita>1953-01-23</datanascita>\n" +
                 "                <sesso>F</sesso>\n" +
                 "                <vip>false</vip>\n" +
                 "            </personaFisica>\n" +
                 "        </primoAssicurato>\n" +
                 "        <secondoAssicurato/>\n" +
                 "        <datoreDiLavoro/>\n" +
                 "        <beneficiarioVita>L' Assicurato</beneficiarioVita>\n" +
                 "        <beneficiarioMorte>Eredi testamentari o legittimi dell' Assicurato</beneficiarioMorte>\n" +
                 "        <indirizzoContratto>\n" +
                 "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                 "            <indirizzo>VIA POZZUOLO, 115</indirizzo>\n" +
                 "            <cap>73100</cap>\n" +
                 "            <comune>LECCE</comune>\n" +
                 "            <provincia>LE</provincia>\n" +
                 "            <regione>Puglia</regione>\n" +
                 "            <nazione>Italia</nazione>\n" +
                 "            <dataAggiornamento>2004-09-15</dataAggiornamento>\n" +
                 "        </indirizzoContratto>\n" +
                 "        <rol>\n" +
                 "            <codiceStato>0</codiceStato>\n" +
                 "        </rol>\n" +
                 "        <banker>\n" +
                 "            <privateBanker>\n" +
                 "                <cognome>MURRONE</cognome>\n" +
                 "                <nome>GIAMPIO</nome>\n" +
                 "                <codicefiscale>MRRGMP65A09E506A</codicefiscale>\n" +
                 "                <datanascita>1965-01-09</datanascita>\n" +
                 "                <sesso>M</sesso>\n" +
                 "                <vip>false</vip>\n" +
                 "            </privateBanker>\n" +
                 "            <agenzia>\n" +
                 "                <indirizzoFiliale>PTTA CASTROMEDIANO, 5</indirizzoFiliale>\n" +
                 "                <localita>LECCE</localita>\n" +
                 "                <cap>73100</cap>\n" +
                 "                <provincia>LE</provincia>\n" +
                 "            </agenzia>\n" +
                 "            <dataInizio>1995-09-01</dataInizio>\n" +
                 "            <stato>Attivo</stato>\n" +
                 "            <livello>Private Banker</livello>\n" +
                 "            <rete>SPI</rete>\n" +
                 "            <strutturaGerarchica>\n" +
                 "                <banker>\n" +
                 "                    <id>MRRGMP65A09E506A</id>\n" +
                 "                    <cognome>MURRONE</cognome>\n" +
                 "                    <nome>GIAMPIO</nome>\n" +
                 "                    <livello>Private Banker</livello>\n" +
                 "                    <superioreID>RCCLRD71D24F280O</superioreID>\n" +
                 "                </banker>\n" +
                 "                <banker>\n" +
                 "                    <id>RCCLRD71D24F280O</id>\n" +
                 "                    <cognome>RECCHIA</cognome>\n" +
                 "                    <nome>LEONARDO</nome>\n" +
                 "                    <livello>Regional Manager</livello>\n" +
                 "                    <superioreID>DMTGPP59T23L117B</superioreID>\n" +
                 "                </banker>\n" +
                 "                <banker>\n" +
                 "                    <id>DMTGPP59T23L117B</id>\n" +
                 "                    <cognome>D'AMATO</cognome>\n" +
                 "                    <nome>GIUSEPPE</nome>\n" +
                 "                    <livello>Divisional Manager</livello>\n" +
                 "                    <superioreID>VRNDNC48A31I046R</superioreID>\n" +
                 "                </banker>\n" +
                 "                <banker>\n" +
                 "                    <id>VRNDNC48A31I046R</id>\n" +
                 "                    <cognome>VARANESE</cognome>\n" +
                 "                    <nome>DOMENICO</nome>\n" +
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
                 "        <totalePrestazioniCV>645503.77</totalePrestazioniCV>\n" +
                 "        <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                 "        <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                 "        <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                 "        <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                 "        <prestazioneGarantita>0.0</prestazioneGarantita>\n" +
                 "        <totalePrestazioniBase>0.0</totalePrestazioniBase>\n" +
                 "    </prestazioni>\n" +
                 "    <finanziario>\n" +
                 "        <quoteTotali>0.0</quoteTotali>\n" +
                 "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                 "        <isETF>false</isETF>\n" +
                 "        <isCustom>false</isCustom>\n" +
                 "    </finanziario>\n" +
                 "    <contabile>\n" +
                 "        <totalePremiAnnuiIncassati>124000.0</totalePremiAnnuiIncassati>\n" +
                 "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                 "        <totalePremiAnnuiIncassatiConTrasformate>124000.0</totalePremiAnnuiIncassatiConTrasformate>\n" +
                 "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                 "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                 "        <dataFinePagamentoPremi>2016-12-31</dataFinePagamentoPremi>\n" +
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
                 "        <classeCPP>F</classeCPP>\n" +
                 "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                 "        <caricamentiCPP>\n" +
                 "            <caricamentoCPPR3>\n" +
                 "                <descrizione>Prima rata di prima annualita'</descrizione>\n" +
                 "                <tipoTitolo>01</tipoTitolo>\n" +
                 "                <percentualeCaricamento>2.2</percentualeCaricamento>\n" +
                 "            </caricamentoCPPR3>\n" +
                 "            <caricamentoCPPR3>\n" +
                 "                <descrizione>Rata di prima annualita'</descrizione>\n" +
                 "                <tipoTitolo>03</tipoTitolo>\n" +
                 "                <percentualeCaricamento>2.2</percentualeCaricamento>\n" +
                 "            </caricamentoCPPR3>\n" +
                 "            <caricamentoCPPR3>\n" +
                 "                <descrizione>Rata di annualita' successive</descrizione>\n" +
                 "                <tipoTitolo>04</tipoTitolo>\n" +
                 "                <percentualeCaricamento>1.9</percentualeCaricamento>\n" +
                 "            </caricamentoCPPR3>\n" +
                 "        </caricamentiCPP>\n" +
                 "        <importoPianoProgrammatoVersamenti>360000.0</importoPianoProgrammatoVersamenti>\n" +
                 "        <detraibilitaFiscale>\n" +
                 "            <stato>false</stato>\n" +
                 "            <dataFineBeneficioFiscale>2016-12-31</dataFineBeneficioFiscale>\n" +
                 "        </detraibilitaFiscale>\n" +
                 "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                 "        <polizzaScudata>false</polizzaScudata>\n" +
                 "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                 "        <pegno>false</pegno>\n" +
                 "        <isVariazioneContrattuale>false</isVariazioneContrattuale>\n" +
                 "        <tipoClasseBonus/>\n" +
                 "        <isRiallocazioneGuidata>false</isRiallocazioneGuidata>\n" +
                 "    </altriDati>\n" +
                 "    <trasformabile>false</trasformabile>\n" +
                 "    <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                 "    <isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo>\n" +
                 "</polizza>";
   }

    public static String getXmlAnomalia(){
        String s = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza><dataElaborazione>2017-01-24</dataElaborazione><datiTecnici><numeroPolizza>7357195</numeroPolizza><codiceConferimento>06760035404</codiceConferimento><stato>Liquidata</stato><sottostato>STORNATA</sottostato><prodotto><codice>35008</codice><descrizione>Financial Age Protection</descrizione><tipoRamoLayout>3</tipoRamoLayout><garantito>true</garantito><macroFamigliaID>6</macroFamigliaID><descrizioneMacroFamiglia>FAP</descrizioneMacroFamiglia></prodotto><tariffa><codice>950</codice><descrizione>Capitale differito con controassicurazione a premio ricorrente di tipo Unit Linked</descrizione></tariffa><ramoMinisteriale>3</ramoMinisteriale><tipoPrestazione>C</tipoPrestazione><tipoPolizza>A</tipoPolizza><dataEmissione>2003-12-18</dataEmissione><dataScadenza>2016-12-31</dataScadenza><reteVendita>BFI</reteVendita><tipoSistemaProvenienza>1</tipoSistemaProvenienza><divisa>EUR</divisa><premioDiTariffa>0.0</premioDiTariffa><importoRataBaseIniziale>2582.29</importoRataBaseIniziale><pianoVersamentoIniziale>2582.29</pianoVersamentoIniziale><durata>13</durata></datiTecnici><figureContrattuali><contraente><personaFisica><cognome>TROIANI</cognome><nome>VITO</nome><codicefiscale>TRNVTI58A31D612N</codicefiscale><datanascita>1958-01-31</datanascita><sesso>M</sesso><vip>false</vip></personaFisica></contraente><primoAssicurato><personaFisica><cognome>TROIANI</cognome><nome>VITO</nome><codicefiscale>TRNVTI58A31D612N</codicefiscale><datanascita>1958-01-31</datanascita><sesso>M</sesso><vip>false</vip></personaFisica></primoAssicurato><secondoAssicurato/><datoreDiLavoro/><beneficiarioVita>Il Contraente</beneficiarioVita><beneficiarioMorte>Eredi testamentari o legittimi dell' Assicurato</beneficiarioMorte><indirizzoContratto><tipoIndirizzo>POSTALE</tipoIndirizzo><indirizzo>VIA TORCICODA 9</indirizzo><cap>50142</cap><comune>FIRENZE</comune><provincia>FI</provincia><regione>Toscana</regione><nazione>Italia</nazione><dataAggiornamento>1996-12-02</dataAggiornamento></indirizzoContratto><rol><codiceStato>0</codiceStato></rol><banker><privateBanker><cognome>TANGANELLI</cognome><nome>FULVIO</nome><codicefiscale>TNGFLV50H17D612O</codicefiscale><datanascita>1950-06-17</datanascita><sesso>M</sesso><professione>LAVORATORI AUTONOMI E LIBERI PROFESSIONISTI</professione><vip>false</vip></privateBanker><agenzia><indirizzoFiliale>PZA G LA PIRA 10</indirizzoFiliale><localita>POGGIBONSI</localita><cap>53036</cap><provincia>SI</provincia></agenzia><dataInizio>1987-12-30</dataInizio><stato>Attivo</stato><livello>Private Banker</livello><rete>BFI</rete><strutturaGerarchica><banker><id>TNGFLV50H17D612O</id><cognome>TANGANELLI</cognome><nome>FULVIO</nome><livello>Private Banker</livello><superioreID>015063BFI080XXXX</superioreID></banker><banker><id>015063BFI080XXXX</id><cognome>BF UNO</cognome><nome>BANCA FIDEURAM</nome><livello>Area Manager</livello></banker></strutturaGerarchica></banker><isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita><isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte><legaleRappresentante/></figureContrattuali><prestazioni><prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione><importoBonus>0.0</importoBonus><valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito><ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza><valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato><valorePrestazioniControvalore>0.0</valorePrestazioniControvalore><eccedenza>0.0</eccedenza><opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/><renditaACLS75Anno>0.0</renditaACLS75Anno><renditaACLS80Anno>0.0</renditaACLS80Anno><renditaACLS85Anno>0.0</renditaACLS85Anno><totalePrestazioniCV>202964.02</totalePrestazioniCV><capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss><capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss><capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss><capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss><prestazioneGarantita>0.0</prestazioneGarantita><totalePrestazioniBase>0.0</totalePrestazioniBase></prestazioni><finanziario><quoteTotali>0.0</quoteTotali><controvaloreTotale>0.0</controvaloreTotale><isETF>false</isETF><isCustom>false</isCustom></finanziario><contabile><totalePremiAnnuiIncassati>20658.32</totalePremiAnnuiIncassati><totalePremiDaTrasformazioni>72304.02</totalePremiDaTrasformazioni><totalePremiAnnuiIncassatiConTrasformate>92962.34</totalePremiAnnuiIncassatiConTrasformate><totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi><sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare><dataFinePagamentoPremi>2016-12-31</dataFinePagamentoPremi><premiTrasferimentoDaAltriFondi>0.0</premiTrasferimentoDaAltriFondi></contabile><altriDati><vincolo><attivo>false</attivo></vincolo><decumuloCedola><attivo>false</attivo><dettagli><imponibile>0.0</imponibile><importoPagato>0.0</importoPagato><cvn>0.0</cvn><percentuale>0.0</percentuale><importoRata>0.0</importoRata></dettagli></decumuloCedola><imponibileCongelamento>0.0</imponibileCongelamento><classeCPP>H</classeCPP><percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP><caricamentiCPP><caricamentoCPPR3><descrizione>Rata di annualita' successive</descrizione><tipoTitolo>04</tipoTitolo><percentualeCaricamento>0.0</percentualeCaricamento></caricamentoCPPR3></caricamentiCPP><importoPianoProgrammatoVersamenti>134279.08</importoPianoProgrammatoVersamenti><detraibilitaFiscale><stato>false</stato></detraibilitaFiscale><polizzaDerivanteDaTrasformazione>true</polizzaDerivanteDaTrasformazione><polizzaScudata>false</polizzaScudata><impostaBolloMaturata>0.0</impostaBolloMaturata><pegno>false</pegno><isVariazioneContrattuale>false</isVariazioneContrattuale><tipoClasseBonus/><isRiallocazioneGuidata>false</isRiallocazioneGuidata><isNoteBloccanti>false</isNoteBloccanti></altriDati><trasformabile>false</trasformabile><trasformazioneDiFatto>false</trasformazioneDiFatto><isOperazioneFinanzInVolo>false</isOperazioneFinanzInVolo></polizza>"  ;

        return s;
    }
}
