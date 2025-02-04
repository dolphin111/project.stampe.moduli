package ws.stampe.fv.riscatti;

/**
 * Created by V801068 on 10/04/14.
 */
public class RiscattoAnticipatoMock {
    public static String getXmlPersonaGiuridica(){

        String s="<polizza>" +
                "    <dataElaborazione>2014-04-09</dataElaborazione>" +
                "    <datiTecnici>" +
                "        <numeroPolizza>7619865</numeroPolizza>" +
                "        <codiceConferimento>63490035006</codiceConferimento>" +
                "        <stato>Attiva</stato>" +
                "        <sottostato>PROROGATA</sottostato>" +
                "        <prodotto>" +
                "            <codice>35007</codice>" +
                "            <descrizione>Financial Age Protection</descrizione>" +
                "            <tipoRamoLayout>3</tipoRamoLayout>" +
                "            <garantito>true</garantito>" +
                "        </prodotto>" +
                "        <tariffa>" +
                "            <codice>951</codice>" +
                "            <descrizione>Capitale differito con controassicurazione a premio unico di tipo Unit Linked</descrizione>" +
                "        </tariffa>" +
                "        <ramoMinisteriale>3</ramoMinisteriale>" +
                "        <tipoPrestazione>C</tipoPrestazione>" +
                "        <tipoPolizza>A</tipoPolizza>" +
                "        <dataEmissione>2003-03-19</dataEmissione>" +
                "        <dataScadenza>2014-12-31</dataScadenza>" +
                "        <reteVendita>BFI</reteVendita>" +
                "        <tipoSistemaProvenienza>1</tipoSistemaProvenienza>" +
                "        <divisa>EUR</divisa>" +
                "        <premioDiTariffa>38961.0</premioDiTariffa>" +
                "        <importoRataBaseIniziale>0.0</importoRataBaseIniziale>" +
                "        <pianoVersamentoIniziale>0.0</pianoVersamentoIniziale>" +
                "        <durata>11</durata>" +
                "    </datiTecnici>" +
                "    <figureContrattuali>" +
                "        <contraente>" +
                "            <personaGiuridica>" +
                "                <codiceFiscaleSocieta>                </codiceFiscaleSocieta>" +
                "                <partitaIva>07573820581</partitaIva>" +
                "                <ragioneSociale>FIDEURAM FIDUCIARIA SPA</ragioneSociale>" +
                "            </personaGiuridica>" +
                "        </contraente>" +
                "        <primoAssicurato>" +
                "            <personaFisica>" +
                "                <cognome>D'ANGELO</cognome>" +
                "                <nome>PAOLA</nome>" +
                "                <codicefiscale>DNGPLA49D54C933W</codicefiscale>" +
                "                <datanascita>1949-04-14</datanascita>" +
                "                <sesso>F</sesso>" +
                "                <vip>false</vip>" +
                "            </personaFisica>" +
                "        </primoAssicurato>" +
                "        <secondoAssicurato/>" +
                "        <datoreDiLavoro/>" +
                "        <beneficiarioVita>L' Assicurato</beneficiarioVita>" +
                "        <beneficiarioMorte>IL FIGLIO DELL' ASSICURATA, SIG. D' ANGELO MARCO.</beneficiarioMorte>" +
                "        <indirizzoContratto>" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>" +
                "            <indirizzo>P.LE GIULIO DOUHET 31 C/O COD. 6188</indirizzo>" +
                "            <cap>00143</cap>" +
                "            <comune>ROMA</comune>" +
                "            <provincia>RM</provincia>" +
                "            <regione>Lazio</regione>" +
                "            <nazione>Italia</nazione>" +
                "            <dataAggiornamento>2010-07-23</dataAggiornamento>" +
                "        </indirizzoContratto>" +
                "        <rol>" +
                "            <codiceStato>0</codiceStato>" +
                "        </rol>" +
                "        <banker>" +
                "            <privateBanker>" +
                "                <cognome>PEZZUTO</cognome>" +
                "                <nome>ROBERTA</nome>" +
                "                <codicefiscale>PZZRRT69R41I119F</codicefiscale>" +
                "                <datanascita>1969-10-01</datanascita>" +
                "                <sesso>F</sesso>" +
                "                <vip>false</vip>" +
                "            </privateBanker>" +
                "            <dataInizio>1996-11-14</dataInizio>" +
                "            <stato>Attivo</stato>" +
                "            <livello>Private Banker</livello>" +
                "        </banker>" +
                "        <isAttivoBeneficiarioVita>true</isAttivoBeneficiarioVita>" +
                "        <isAttivoBeneficiarioMorte>true</isAttivoBeneficiarioMorte>" +
                "    </figureContrattuali>" +
                "    <prestazioni>" +
                "        <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>" +
                "        <importoBonus>0.0</importoBonus>" +
                "        <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>" +
                "        <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>" +
                "        <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>" +
                "        <valorePrestazioniControvalore>0.0</valorePrestazioniControvalore>" +
                "        <eccedenza>0.0</eccedenza>" +
                "        <opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/>" +
                "        <prestazioniMinimoGarantito>" +
                "            <renditaAnnuaVitaliziaMinimaGarantita>0.0</renditaAnnuaVitaliziaMinimaGarantita>" +
                "            <valoreRiscattoLordoScadenza>46609.05</valoreRiscattoLordoScadenza>" +
                "        </prestazioniMinimoGarantito>" +
                "        <prestazioniCalcolateNav>" +
                "            <quote>4565.039</quote>" +
                "            <ipotesiControvaloreQuoteNav>46609.05</ipotesiControvaloreQuoteNav>" +
                "            <premiVersatiNav>38961.0</premiVersatiNav>" +
                "            <valoreRiscattoScadenza>46609.05</valoreRiscattoScadenza>" +
                "            <dataRiferimentoNav>2014-04-07</dataRiferimentoNav>" +
                "        </prestazioniCalcolateNav>" +
                "        <renditaACLS75Anno>0.0</renditaACLS75Anno>" +
                "        <renditaACLS80Anno>0.0</renditaACLS80Anno>" +
                "        <renditaACLS85Anno>0.0</renditaACLS85Anno>" +
                "        <totalePrestazioniCV>0.0</totalePrestazioniCV>" +
                "        <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>" +
                "        <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>" +
                "        <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>" +
                "        <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>" +
                "        <prestazioneGarantita>0.0</prestazioneGarantita>" +
                "        <totalePrestazioniBase>0.0</totalePrestazioniBase>" +
                "    </prestazioni>" +
                "    <finanziario>" +
                "        <quoteTotali>4565.039</quoteTotali>" +
                "        <controvaloreTotale>46609.04819</controvaloreTotale>" +
                "        <dataRiferimentoNAV>2014-04-07</dataRiferimentoNAV>" +
                "        <isETF>false</isETF>" +
                "        <isCustom>false</isCustom>" +
                "        <ctvCommissioniNegoziazioni>0.0</ctvCommissioniNegoziazioni>" +
                "    </finanziario>" +
                "    <contabile>" +
                "        <totalePremiAnnuiIncassati>38961.0</totalePremiAnnuiIncassati>" +
                "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>" +
                "        <totalePremiAnnuiIncassatiConTrasformate>38961.0</totalePremiAnnuiIncassatiConTrasformate>" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>" +
                "        <dataFinePagamentoPremi>2003-03-19</dataFinePagamentoPremi>" +
                "    </contabile>" +
                "    <altriDati>" +
                "        <vincolo>" +
                "            <attivo>false</attivo>" +
                "        </vincolo>" +
                "        <decumuloCedola>" +
                "            <attivo>false</attivo>" +
                "            <dettagli>" +
                "                <imponibile>0.0</imponibile>" +
                "                <importoPagato>0.0</importoPagato>" +
                "                <cvn>0.0</cvn>" +
                "                <percentuale>0.0</percentuale>" +
                "                <importoRata>0.0</importoRata>" +
                "            </dettagli>" +
                "        </decumuloCedola>" +
                "        <imponibileCongelamento>4790.33</imponibileCongelamento>" +
                "        <classeCPP>H</classeCPP>" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>" +
                "        <caricamentiCPP>" +
                "            <caricamentoCPPR3>" +
                "                <descrizione>Premio Unico</descrizione>" +
                "                <tipoTitolo>02</tipoTitolo>" +
                "                <percentualeCaricamento>0.0</percentualeCaricamento>" +
                "            </caricamentoCPPR3>" +
                "        </caricamentiCPP>" +
                "        <importoPianoProgrammatoVersamenti>38961.0</importoPianoProgrammatoVersamenti>" +
                "        <detraibilitaFiscale>" +
                "            <stato>false</stato>" +
                "        </detraibilitaFiscale>" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>" +
                "        <polizzaScudata>false</polizzaScudata>" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>" +
                "    </altriDati>" +
                "    <trasformabile>true</trasformabile>" +
                "    <trasformazioneDiFatto>false</trasformazioneDiFatto>" +
                "</polizza>";

        return s;
    }
}