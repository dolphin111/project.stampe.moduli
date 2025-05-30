package com.fideuram.mock;

/**
 * Created by
 * User: logan
 * Date: 23/04/13
 * Time: 11.21
 */
public class BonusMock {
    public static String getXml(){
        String s="<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza>\n" +
                "    <dataElaborazione>2013-05-06</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>70012148011</numeroPolizza>\n" +
                "        <codiceConferimento>024503RB011</codiceConferimento>\n" +
                "        <stato>Attiva</stato>\n" +
                "        <sottostato>ATTIVA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>RB0U2</codice>\n" +
                "            <descrizione>Fideuram Vita Insieme Premium 4 + 4</descrizione>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>934</codice>\n" +
                "            <descrizione>Vita intera a premio unico con aggiuntivi</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>3</ramoMinisteriale>\n" +
                "        <tipoPrestazione>C</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>2013-04-17</dataEmissione>\n" +
                "        <dataScadenza>2100-12-31</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>NIZZOLI</cognome>\n" +
                "                <nome>GIAMPAOLO</nome>\n" +
                "                <codicefiscale>NZZGPL42A04D704I</codicefiscale>\n" +
                "                <datanascita>1942-01-04</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>NIZZOLI</cognome>\n" +
                "                <nome>GIAMPAOLO</nome>\n" +
                "                <codicefiscale>NZZGPL42A04D704I</codicefiscale>\n" +
                "                <datanascita>1942-01-04</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <beneficiarioMorte>MAGNANI  ANGELA                         -MGNNGL43S47D704B-100,00-</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>VIA GIUSEPPE SANTARELLI 22</indirizzo>\n" +
                "            <cap>47122</cap>\n" +
                "            <comune>FORLI'</comune>\n" +
                "            <provincia>FC</provincia>\n" +
                "            <regione>Manca</regione>\n" +
                "            <nazione>Italia</nazione>\n" +
                "            <dataAggiornamento>2012-07-31</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>ROSETTI</cognome>\n" +
                "                <nome>ANDREA</nome>\n" +
                "                <codicefiscale>RSTNDR66R24D704Q</codicefiscale>\n" +
                "                <datanascita>1966-10-24</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </privateBanker>\n" +
                "            <dataInizio>2000-10-25</dataInizio>\n" +
                "            <stato>Attivo</stato>\n" +
                "            <livello>Superiore Banker</livello>\n" +
                "        </banker>\n" +
                "    </figureContrattuali>\n" +
                "    <prestazioni>\n" +
                "        <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>\n" +
                "        <importoBonusFvInsieme>0.0</importoBonusFvInsieme>\n" +
                "        <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>\n" +
                "        <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                "        <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>\n" +
                "        <eccedenza>0.0</eccedenza>\n" +
                "        <opzioni xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:nil=\"true\"/>\n" +
                "        <Bonus>\n" +
                "            <BonusPremium4X4>\n" +
                "                <BonusMaturatoGiornaliero>\n" +
                "                    <Valore>41.62</Valore>\n" +
                "                    <dataRiferimento>2013-05-06</dataRiferimento>\n" +
                "                </BonusMaturatoGiornaliero>\n" +
                "                <BonusIQuinquennio>\n" +
                "                    <Valore>4000.0</Valore>\n" +
                "                    <dataRiferimento>2018-04-17</dataRiferimento>\n" +
                "                </BonusIQuinquennio>\n" +
                "                <BonusIIQuinquennio>\n" +
                "                    <Valore>4000.0</Valore>\n" +
                "                    <dataRiferimento>2023-04-17</dataRiferimento>\n" +
                "                </BonusIIQuinquennio>\n" +
                "                <ProiezioneQuinquenni>\n" +
                "                    <dettaglioProiezione>\n" +
                "                        <valore>800.0</valore>\n" +
                "                        <dataRiferimento>2014-04-30</dataRiferimento>\n" +
                "                        <totale>800.0</totale>\n" +
                "                        <baseCalcolo>100000.0</baseCalcolo>\n" +
                "                    </dettaglioProiezione>\n" +
                "                    <dettaglioProiezione>\n" +
                "                        <valore>800.0</valore>\n" +
                "                        <dataRiferimento>2015-04-30</dataRiferimento>\n" +
                "                        <totale>1600.0</totale>\n" +
                "                        <baseCalcolo>100000.0</baseCalcolo>\n" +
                "                    </dettaglioProiezione>\n" +
                "                    <dettaglioProiezione>\n" +
                "                        <valore>800.0</valore>\n" +
                "                        <dataRiferimento>2016-04-30</dataRiferimento>\n" +
                "                        <totale>2400.0</totale>\n" +
                "                        <baseCalcolo>100000.0</baseCalcolo>\n" +
                "                    </dettaglioProiezione>\n" +
                "                    <dettaglioProiezione>\n" +
                "                        <valore>800.0</valore>\n" +
                "                        <dataRiferimento>2017-04-30</dataRiferimento>\n" +
                "                        <totale>3200.0</totale>\n" +
                "                        <baseCalcolo>100000.0</baseCalcolo>\n" +
                "                    </dettaglioProiezione>\n" +
                "                    <dettaglioProiezione>\n" +
                "                        <valore>800.0</valore>\n" +
                "                        <dataRiferimento>2018-04-30</dataRiferimento>\n" +
                "                        <totale>4000.0</totale>\n" +
                "                        <baseCalcolo>100000.0</baseCalcolo>\n" +
                "                    </dettaglioProiezione>\n" +
                "                    <dettaglioProiezione>\n" +
                "                        <valore>800.0</valore>\n" +
                "                        <dataRiferimento>2019-04-30</dataRiferimento>\n" +
                "                        <totale>4800.0</totale>\n" +
                "                        <baseCalcolo>100000.0</baseCalcolo>\n" +
                "                    </dettaglioProiezione>\n" +
                "                    <dettaglioProiezione>\n" +
                "                        <valore>800.0</valore>\n" +
                "                        <dataRiferimento>2020-04-30</dataRiferimento>\n" +
                "                        <totale>5600.0</totale>\n" +
                "                        <baseCalcolo>100000.0</baseCalcolo>\n" +
                "                    </dettaglioProiezione>\n" +
                "                    <dettaglioProiezione>\n" +
                "                        <valore>800.0</valore>\n" +
                "                        <dataRiferimento>2021-04-30</dataRiferimento>\n" +
                "                        <totale>6400.0</totale>\n" +
                "                        <baseCalcolo>100000.0</baseCalcolo>\n" +
                "                    </dettaglioProiezione>\n" +
                "                    <dettaglioProiezione>\n" +
                "                        <valore>800.0</valore>\n" +
                "                        <dataRiferimento>2022-04-30</dataRiferimento>\n" +
                "                        <totale>7200.0</totale>\n" +
                "                        <baseCalcolo>100000.0</baseCalcolo>\n" +
                "                    </dettaglioProiezione>\n" +
                "                    <dettaglioProiezione>\n" +
                "                        <valore>800.0</valore>\n" +
                "                        <dataRiferimento>2023-04-30</dataRiferimento>\n" +
                "                        <totale>8000.0</totale>\n" +
                "                        <baseCalcolo>100000.0</baseCalcolo>\n" +
                "                    </dettaglioProiezione>\n" +
                "                </ProiezioneQuinquenni>\n" +
                "            </BonusPremium4X4>\n" +
                "        </Bonus>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>0.0</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "    </contabile>\n" +
                "    <altriDati>\n" +
                "        <vincolo>\n" +
                "            <attivo>false</attivo>\n" +
                "        </vincolo>\n" +
                "        <decumuloCedola>\n" +
                "            <attivo>false</attivo>\n" +
                "        </decumuloCedola>\n" +
                "        <imponibileCongelamento>0.0</imponibileCongelamento>\n" +
                "        <classeCPP>0</classeCPP>\n" +
                "        <percentualeCaricamentoCPP>0.0</percentualeCaricamentoCPP>\n" +
                "        <caricamentiCPP>\n" +
                "            <caricamentoCPPR3>\n" +
                "                <descrizione>Premio Unico</descrizione>\n" +
                "                <tipo_titolo>02</tipo_titolo>\n" +
                "                <percentualeCaricamento>0.0</percentualeCaricamento>\n" +
                "            </caricamentoCPPR3>\n" +
                "        </caricamentiCPP>\n" +
                "        <importoPianoProgrammatoVersamenti>100000.0</importoPianoProgrammatoVersamenti>\n" +
                "        <detraibilitaFiscale>\n" +
                "            <stato>false</stato>\n" +
                "        </detraibilitaFiscale>\n" +
                "        <polizzaDerivanteDaTrasformazione>false</polizzaDerivanteDaTrasformazione>\n" +
                "        <polizzaScudata>false</polizzaScudata>\n" +
                "        <impostaBolloMaturata>0.0</impostaBolloMaturata>\n" +
                "    </altriDati>\n" +
                "</polizza>";
        return s;
    }
}
