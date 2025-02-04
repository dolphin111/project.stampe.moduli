package com.fideuram.mock;

/**
 * Created by
 * User: logan
 * Date: 17/04/13
 * Time: 10.43
 */
public class PremiIncassatiMock {
    public static String getXml(){
        String s="<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<polizza>\n" +
                "    <dataElaborazione>2013-04-18</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>7003841</numeroPolizza>\n" +
                "        <codiceConferimento>00686636276</codiceConferimento>\n" +
                "        <stato>Rendita</stato>\n" +
                "        <sottostato>IN GODIMENTO RENDITA</sottostato>\n" +
                "        <prodotto>\n" +
                "            <codice>36000</codice>\n" +
                "            <descrizione>Piano Pensione Fideuram - Viva</descrizione>\n" +
                "        </prodotto>\n" +
                "        <tariffa>\n" +
                "            <codice>048</codice>\n" +
                "            <descrizione>Rendita vitalizia differita con controassicurazione a premio annuo</descrizione>\n" +
                "        </tariffa>\n" +
                "        <ramoMinisteriale>1</ramoMinisteriale>\n" +
                "        <tipoPrestazione>R</tipoPrestazione>\n" +
                "        <tipoPolizza>A</tipoPolizza>\n" +
                "        <dataEmissione>1984-12-28</dataEmissione>\n" +
                "        <dataScadenza>1999-12-28</dataScadenza>\n" +
                "        <reteVendita>BFI</reteVendita>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>ZAFALON</cognome>\n" +
                "                <nome>GIANFRANCO</nome>\n" +
                "                <codicefiscale>ZFLGFR29L20L736F</codicefiscale>\n" +
                "                <datanascita>1929-07-20</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <primoAssicurato>\n" +
                "            <personaFisica>\n" +
                "                <cognome>ZAFALON</cognome>\n" +
                "                <nome>GIANFRANCO</nome>\n" +
                "                <codicefiscale>ZFLGFR29L20L736F</codicefiscale>\n" +
                "                <datanascita>1929-07-20</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </primoAssicurato>\n" +
                "        <secondoAssicurato/>\n" +
                "        <beneficiarioVita>L' Assicurato</beneficiarioVita>\n" +
                "        <beneficiarioMorte>Il coniuge dell' Assicurato</beneficiarioMorte>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>Postale</tipoIndirizzo>\n" +
                "            <indirizzo>SEST DI SANTA CROCE 1073/5</indirizzo>\n" +
                "            <cap>30135</cap>\n" +
                "            <comune>VENEZIA</comune>\n" +
                "            <provincia>VE</provincia>\n" +
                "            <regione>Manca</regione>\n" +
                "            <nazione>Italia</nazione>\n" +
                "            <dataAggiornamento>2007-04-21</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "        <rol>\n" +
                "            <codiceStato>0</codiceStato>\n" +
                "        </rol>\n" +
                "        <banker>\n" +
                "            <privateBanker>\n" +
                "                <cognome>GASTALDON</cognome>\n" +
                "                <nome>RENZO</nome>\n" +
                "                <codicefiscale>GSTRNZ40B17L736A</codicefiscale>\n" +
                "                <datanascita>1970-01-01</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <professione></professione>\n" +
                "                <titolo></titolo>\n" +
                "                <vip>true</vip>\n" +
                "            </privateBanker>\n" +
                "            <dataInizio>1987-12-30</dataInizio>\n" +
                "            <dataFine>2100-12-31</dataFine>\n" +
                "            <stato>Terminato</stato>\n" +
                "        </banker>\n" +
                "    </figureContrattuali>\n" +
                "    <prestazioni>\n" +
                "        <prestazioneGarantitaUltimaRivalutazione>0.0</prestazioneGarantitaUltimaRivalutazione>\n" +
                "        <importoBonusFvInsieme>0.0</importoBonusFvInsieme>\n" +
                "        <valoreRiscattoScadenzaGarantito>0.0</valoreRiscattoScadenzaGarantito>\n" +
                "        <ipotesiValoreRiscattoScadenza>0.0</ipotesiValoreRiscattoScadenza>\n" +
                "        <valoreRiscattoAnticipato>0.0</valoreRiscattoAnticipato>\n" +
                "        <eccedenza>0.0</eccedenza>\n" +
                "        <opzioni xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>\n" +
                "    </prestazioni>\n" +
                "    <finanziario>\n" +
                "        <quoteTotali>0.0</quoteTotali>\n" +
                "        <controvaloreTotale>0.0</controvaloreTotale>\n" +
                "        <tipoRiallocazioneGuidata>\n" +
                "            <codice>RMX001</codice>\n" +
                "            <descrizione>Descrizione Rmx01</descrizione>\n" +
                "            <tipoRiallocazione>1</tipoRiallocazione>\n" +
                "            <dataInizioValiditaFV>2013-04-18</dataInizioValiditaFV>\n" +
                "        </tipoRiallocazioneGuidata>\n" +
                "    </finanziario>\n" +
                "    <contabile>\n" +
                "        <totalePremiAnnuiIncassati>0.0</totalePremiAnnuiIncassati>\n" +
                "        <totalePremiAggiuntiviOggi>0.0</totalePremiAggiuntiviOggi>\n" +
                "        <sommaPremiResiduiDaVersare>0.0</sommaPremiResiduiDaVersare>\n" +
                "        <PremiIncassati>\n" +
                "            <dataRiferimento>2013-02-01</dataRiferimento>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>1</progressivoTitolo>\n" +
                "                <dataEffetto>1984-12-28</dataEffetto>\n" +
                "                <dataValuta>1984-12-31</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>619.75</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Prima rata di prima annualità</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>2</progressivoTitolo>\n" +
                "                <dataEffetto>1985-12-28</dataEffetto>\n" +
                "                <dataValuta>1986-12-27</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>619.75</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>3</progressivoTitolo>\n" +
                "                <dataEffetto>1986-12-28</dataEffetto>\n" +
                "                <dataValuta>1987-12-28</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>619.75</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>4</progressivoTitolo>\n" +
                "                <dataEffetto>1987-12-28</dataEffetto>\n" +
                "                <dataValuta>1988-12-29</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.79</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>5</progressivoTitolo>\n" +
                "                <dataEffetto>1988-12-28</dataEffetto>\n" +
                "                <dataValuta>1989-12-27</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>6</progressivoTitolo>\n" +
                "                <dataEffetto>1989-12-28</dataEffetto>\n" +
                "                <dataValuta>1990-02-13</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>7</progressivoTitolo>\n" +
                "                <dataEffetto>1990-12-28</dataEffetto>\n" +
                "                <dataValuta>1990-12-28</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>8</progressivoTitolo>\n" +
                "                <dataEffetto>1991-12-28</dataEffetto>\n" +
                "                <dataValuta>1991-12-27</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>9</progressivoTitolo>\n" +
                "                <dataEffetto>1992-12-28</dataEffetto>\n" +
                "                <dataValuta>1992-12-28</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>10</progressivoTitolo>\n" +
                "                <dataEffetto>1993-12-28</dataEffetto>\n" +
                "                <dataValuta>1993-12-28</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>11</progressivoTitolo>\n" +
                "                <dataEffetto>1994-12-28</dataEffetto>\n" +
                "                <dataValuta>1994-12-20</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>12</progressivoTitolo>\n" +
                "                <dataEffetto>1995-12-28</dataEffetto>\n" +
                "                <dataValuta>1995-12-21</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>13</progressivoTitolo>\n" +
                "                <dataEffetto>1996-12-28</dataEffetto>\n" +
                "                <dataValuta>1996-12-20</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>14</progressivoTitolo>\n" +
                "                <dataEffetto>1997-12-28</dataEffetto>\n" +
                "                <dataValuta>1998-01-22</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <listaPremiIncassati>\n" +
                "                <progressivoTitolo>15</progressivoTitolo>\n" +
                "                <dataEffetto>1998-12-28</dataEffetto>\n" +
                "                <dataValuta>1998-12-28</dataValuta>\n" +
                "                <divisa>EUR</divisa>\n" +
                "                <importoLordo>622.64</importoLordo>\n" +
                "                <descrizioneTipoTitolo>Rata di annualità successive</descrizioneTipoTitolo>\n" +
                "            </listaPremiIncassati>\n" +
                "            <totaleImporti>9331.080000000002</totaleImporti>\n" +
                "        </PremiIncassati>\n" +
                "    </contabile>\n" +
                "    <altriDati>\n" +
                "        <vincolo>\n" +
                "            <attivo>false</attivo>\n" +
                "        </vincolo>\n" +
                "        <decumuloCedola>\n" +
                "            <attivo>false</attivo>\n" +
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
                "</polizza>";
        return s;
    }
}
