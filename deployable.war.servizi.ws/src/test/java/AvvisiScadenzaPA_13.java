import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.StampeWsException;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 09/10/14
 * Time: 14.45
 * To change this template use File | Settings | File Templates.
 */
public class AvvisiScadenzaPA_13 {
    public  static void main(String args[]) throws DocGeneratorException, StampeWsException {

        new Stampe().getOdtFromXml(getXml(),"13");

    }


    private static String getXml(){
        return  "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizza>\n" +
                "    <dataElaborazione>2014-10-09</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>7292988</numeroPolizza>\n" +
                "        <codiceConferimento>53612236002</codiceConferimento>\n" +
                "        <stato>Rendita</stato>\n" +
                "        <sottostato>IN GODIMENTO RENDITA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>36002</codice>\n" +
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
                "        <dataEmissione>1994-11-18</dataEmissione>\n" +
                "        <dataScadenza>2014-10-19</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "        <tipoSistemaProvenienza>1</tipoSistemaProvenienza>\n" +
                "        <divisa>EUR</divisa>\n" +
                "        <premioDiTariffa>0.0</premioDiTariffa>\n" +
                "        <importoRataBaseIniziale>1549.37</importoRataBaseIniziale>\n" +
                "        <pianoVersamentoIniziale>1549.37</pianoVersamentoIniziale>\n" +
                "        <durata>19</durata>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>FILOSI</cognome>\n" +
                "                <nome>IDA</nome>\n" +
                "                <codicefiscale>FLSDIA44A49G989X</codicefiscale>\n" +
                "                <datanascita>1944-01-09</datanascita>\n" +
                "                <sesso>F</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>LEONE</cognome>\n" +
                "                <nome>ALESSIA</nome>\n" +
                "                <codicefiscale>LNELSS80R65L219V</codicefiscale>\n" +
                "                <datanascita>1980-10-25</datanascita>\n" +
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
                "            <indirizzo>CSO ORBASSANO 235</indirizzo>\n" +
                "            <cap>10137</cap>\n" +
                "            <comune>TORINO</comune>\n" +
                "            <provincia>TO</provincia>\n" +
                "            <regione>Piemonte</regione>\n" +
                "            <nazione>Italia</nazione>\n" +
                "            <dataAggiornamento>1994-10-19</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>GASCO</cognome>\n" +
                "                <nome>ENZO</nome>\n" +
                "                <codicefiscale>GSCNZE36L05H501Y</codicefiscale>\n" +
                "                <datanascita>1936-07-05</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <professione>LAVORATORI AUTONOMI E LIBERI PROFESSIONISTI</professione>\n" +
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
                "        <totalePrestazioniCV>2290.92</totalePrestazioniCV>\n" +
                "        <capitaleComplementareIncidentePrimoAss>0.0</capitaleComplementareIncidentePrimoAss>\n" +
                "        <capitaleComplementareInfortunioPrimoAss>0.0</capitaleComplementareInfortunioPrimoAss>\n" +
                "        <capitaleComplementareMalattiaPrimoAss>0.0</capitaleComplementareMalattiaPrimoAss>\n" +
                "        <capitaleComplementareDecessoSecondoAss>0.0</capitaleComplementareDecessoSecondoAss>\n" +
                "        <prestazioneGarantita>0.0</prestazioneGarantita>\n" +
                "        <totalePrestazioniBase>2274.71</totalePrestazioniBase>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "        <isETF>false</isETF>\n" +
                "       <isCustom>false</isCustom>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>39854.48</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiDaTrasformazioni>0.0</totalePremiDaTrasformazioni>\n" +
                "        <totalePremiAnnuiIncassatiConTrasformate>39854.48</totalePremiAnnuiIncassatiConTrasformate>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "        <dataFinePagamentoPremi>2013-10-19</dataFinePagamentoPremi>\n" +
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
                "        <imponibileCongelamento>6387.05</imponibileCongelamento>\n" +
                "        <classeCPP>1</classeCPP>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>0.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>true</stato>\n" +
                "            <dataFineBeneficioFiscale>2014-10-19</dataFineBeneficioFiscale>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "        <pegno>false</pegno>\n" +
                "    </altriDati>\n" +
                "    <stimeScadenza>\n" +
                "        <polizzaID>7292988</polizzaID>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <renditaAnnuavitaliziaMinimaGarantita>0.0</renditaAnnuavitaliziaMinimaGarantita>\n" +
                "        <valoreRiscattoScadenzaGarantito>48910.51</valoreRiscattoScadenzaGarantito>\n" +
                "        <ipotesiRenditaAnnuaPosticipataScadenzaCVT>1129.0874</ipotesiRenditaAnnuaPosticipataScadenzaCVT>\n" +
                "        <ipotesiValoreriScattoScadenzaCVT>48910.51</ipotesiValoreriScattoScadenzaCVT>\n" +
                "        <totalerenditaFrazionataAnnualePosticipata>1129.0874</totalerenditaFrazionataAnnualePosticipata>\n" +
                "        <totalerenditaFrazionataSemestralePosticipata>1123.47</totalerenditaFrazionataSemestralePosticipata>\n" +
                "        <totalerenditaFrazionataTrimestralePosticipata>558.52</totalerenditaFrazionataTrimestralePosticipata>\n" +
                "        <totalerenditaFrazionataMensilePosticipata>185.46</totalerenditaFrazionataMensilePosticipata>\n" +
                "        <anniCertezza1>5</anniCertezza1>\n" +
                "        <totaleRenditaCerta1AnnualePosticipata>2272.41</totaleRenditaCerta1AnnualePosticipata>\n" +
                "        <totaleRenditaCerta1SemestralePosticipata>1123.17</totaleRenditaCerta1SemestralePosticipata>\n" +
                "        <totaleRenditaCerta1TrimestralePosticipata>558.38</totaleRenditaCerta1TrimestralePosticipata>\n" +
                "        <totaleRenditaCerta1MensilePosticipata>185.42</totaleRenditaCerta1MensilePosticipata>\n" +
                "        <anniCertezza2>10</anniCertezza2>\n" +
                "        <totaleRenditaCerta2AnnualePosticipata>2270.56</totaleRenditaCerta2AnnualePosticipata>\n" +
                "        <totaleRenditaCerta2Semestraleposticipata>1122.32</totaleRenditaCerta2Semestraleposticipata>\n" +
                "        <totaleRenditaCerta2TrimestralePosticipata>557.96</totaleRenditaCerta2TrimestralePosticipata>\n" +
                "        <totaleRenditaCerta2MensilePosticipata>185.29</totaleRenditaCerta2MensilePosticipata>\n" +
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
                "        <timestamp>2014-07-19</timestamp>\n" +
                "        <dataScadenza>2014-10-19</dataScadenza>\n" +
                "        <dataCalcolo>2014-07-19</dataCalcolo>\n" +
                "        <importoNettoRiscattoTermine>47818.12</importoNettoRiscattoTermine>\n" +
                "        <isACLSLungaSopravvivenza>false</isACLSLungaSopravvivenza>\n" +
                "        <renditaVitaliziaAnnuaPosticipata>2273.13</renditaVitaliziaAnnuaPosticipata>\n" +
                "    </stimeScadenza>\n" +
                "    <trasformabile>false</trasformabile>\n" +
                "    <trasformazioneDiFatto>false</trasformazioneDiFatto>\n" +
                "</polizza>\n";
    }
}
