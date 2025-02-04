package com.fideuram.stampe.modello.rendiconti.mock.personalizzato;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 23/02/15
 * Time: 11.50
 */
public class AnomaliaRendicontoMock {
    public static String getXml(){
        return "<FondoPersonalizzato>\n" +
                "    <dataRiferimento>2014-12-31T00:00:00+01:00</dataRiferimento>\n" +
                "    <hasUltimoAnnoElement>false</hasUltimoAnnoElement>\n" +
                "    <hasBiennioElemnt>false</hasBiennioElemnt>\n" +
                "    <hasTriennioElemnt>false</hasTriennioElemnt>\n" +
                "    <hasQuinquennioElemnt>false</hasQuinquennioElemnt>\n" +
                "    <hasDecennioElemnt>false</hasDecennioElemnt>\n" +
                "    <nomeProdotto>FVI BRASIL</nomeProdotto>\n" +
                "    <tipoProdotto>Fondo Interno Assicurativo</tipoProdotto>\n" +
                "    <dataPartenza>2014-07-28T00:00:00+02:00</dataPartenza>\n" +
                "    <volatilita>\n" +
                "        <percVolatilitaMaxAttesa>10.0%</percVolatilitaMaxAttesa>\n" +
                "        <percVolatilitaProspettica>---</percVolatilitaProspettica>\n" +
                "        <rischio>\n" +
                "            <profilo>Medio - alto</profilo>\n" +
                "        </rischio>\n" +
                "    </volatilita>\n" +
                "    <nav>10.37</nav>\n" +
                "    <dataNav>2015-01-31T00:00:00+01:00</dataNav>\n" +
                "    <patrimonio>9128772.08</patrimonio>\n" +
                "    <gestione>\n" +
                "        <stile>Flessibile</stile>\n" +
                "        <obiettivo>Il Fondo si propone di conseguire il più elevato incremento del valore dell'investimento finanziario, mantenendo la volatilità annua attesa del valore unitario delle quote entro il 10%</obiettivo>\n" +
                "    </gestione>\n" +
                "    <benchmark>\n" +
                "        <previsto>Non previsto</previsto>\n" +
                "    </benchmark>\n" +
                "    <performance>\n" +
                "        <andamentoGrafico>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-08-29T00:00:00+02:00</data>\n" +
                "                <value>10.082</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-09-30T00:00:00+02:00</data>\n" +
                "                <value>10.026</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-10-31T00:00:00+01:00</data>\n" +
                "                <value>9.891</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-11-28T00:00:00+01:00</data>\n" +
                "                <value>9.987</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-12-30T00:00:00+01:00</data>\n" +
                "                <value>10.015</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2015-01-30T00:00:00+01:00</data>\n" +
                "                <value>10.369</value>\n" +
                "            </andamento>\n" +
                "        </andamentoGrafico>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <mese1>3.8977955911823514</mese1>\n" +
                "            <mese3>5.258349406151686</mese3>\n" +
                "            <mese6>0.0</mese6>\n" +
                "            <mese12>0.0</mese12>\n" +
                "            <daInizioFondo>3.6899999999999045</daInizioFondo>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <volatilitaAnnua>\n" +
                "            <mese1>5.617599965931522</mese1>\n" +
                "            <mese3>4.957736668078735</mese3>\n" +
                "            <mese6>0.0</mese6>\n" +
                "            <mese12>0.0</mese12>\n" +
                "            <daInizioFondo>4.347147621397234</daInizioFondo>\n" +
                "        </volatilitaAnnua>\n" +
                "        <modifiedDuration>0.0</modifiedDuration>\n" +
                "    </performance>\n" +
                "    <composizione>\n" +
                "        <dataRiferimento>2014-12-31T00:00:00+01:00</dataRiferimento>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0289214545</isin>\n" +
                "            <descrizioneTitolo>JPM EUROP EQ PLUS-C PERF AEU (JPMEECA LX)</descrizioneTitolo>\n" +
                "            <peso>6.13</peso>\n" +
                "            <prezzoStorico>172.49</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>183.35</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0074297978</isin>\n" +
                "            <descrizioneTitolo>INTERFUND-EURO BOND LNG TERM (INTRELT LX)</descrizioneTitolo>\n" +
                "            <peso>5.35</peso>\n" +
                "            <prezzoStorico>12.05</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>13.37</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0915179146</isin>\n" +
                "            <descrizioneTitolo>JB-JAPAN STOCK-CH EUR HEDGED (JBJPECH LX)</descrizioneTitolo>\n" +
                "            <peso>4.43</peso>\n" +
                "            <prezzoStorico>111.93</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>115.01</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0074298273</isin>\n" +
                "            <descrizioneTitolo>INTERFUND-BOND USA PLUS (INTRBUS LX)</descrizioneTitolo>\n" +
                "            <peso>4.2700000000000005</peso>\n" +
                "            <prezzoStorico>8.63</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>10.03</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>IT0005069395</isin>\n" +
                "            <descrizioneTitolo>BTPS 1.05 12/01/19</descrizioneTitolo>\n" +
                "            <peso>4.21</peso>\n" +
                "            <prezzoStorico>101.04</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>100.9</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>DE0001135275</isin>\n" +
                "            <descrizioneTitolo>DEUTSCHLAND REP 4 01/04/37</descrizioneTitolo>\n" +
                "            <peso>4.09</peso>\n" +
                "            <prezzoStorico>143.6</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>164.63</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0325075066</isin>\n" +
                "            <descrizioneTitolo>JPM HGH USSTEEP-C PERF ACCEH (JHUCEHA LX)</descrizioneTitolo>\n" +
                "            <peso>3.8899999999999997</peso>\n" +
                "            <prezzoStorico>109.17</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>109.85</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>IT0005044976</isin>\n" +
                "            <descrizioneTitolo>CTZS 0 08/30/16</descrizioneTitolo>\n" +
                "            <peso>3.88</peso>\n" +
                "            <prezzoStorico>99.35</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>99.43</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>IT0004938186</isin>\n" +
                "            <descrizioneTitolo>CTZS 0 06/30/15</descrizioneTitolo>\n" +
                "            <peso>3.8699999999999997</peso>\n" +
                "            <prezzoStorico>99.7</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>99.94</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>ES00000126C0</isin>\n" +
                "            <descrizioneTitolo>SPANISH GOV'T 1.4 01/31/20</descrizioneTitolo>\n" +
                "            <peso>3.63</peso>\n" +
                "            <prezzoStorico>102.48</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>102.8</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0243958047</isin>\n" +
                "            <descrizioneTitolo>INVESCO EURO CORP BOND-C (INVECBC LX)</descrizioneTitolo>\n" +
                "            <peso>3.51</peso>\n" +
                "            <prezzoStorico>17.44</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>18.11</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0325074846</isin>\n" +
                "            <descrizioneTitolo>JPM HGH USSTEEP-C PERF ACCUA (JPHIUCA LX)</descrizioneTitolo>\n" +
                "            <peso>3.49</peso>\n" +
                "            <prezzoStorico>29.56</prezzoStorico>\n" +
                "            <cambioStorico>1.23</cambioStorico>\n" +
                "            <prezzoMercato>28.46</prezzoMercato>\n" +
                "            <cambioMercato>1.13</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>USD</nome>\n" +
                "                <simbolo>$</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0360483100</isin>\n" +
                "            <descrizioneTitolo>MORGAN ST-EURO CORP BD-Z (MSECBDZ LX)</descrizioneTitolo>\n" +
                "            <peso>3.4799999999999995</peso>\n" +
                "            <prezzoStorico>39.31</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>40.44</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0628638032</isin>\n" +
                "            <descrizioneTitolo>BNY ME-EUR CRED SH DUR-A (WMECSDA LX)</descrizioneTitolo>\n" +
                "            <peso>3.4099999999999997</peso>\n" +
                "            <prezzoStorico>11.52</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>11.6</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>IT0004978208</isin>\n" +
                "            <descrizioneTitolo>CTZS 0 12/31/15</descrizioneTitolo>\n" +
                "            <peso>3.19</peso>\n" +
                "            <prezzoStorico>99.52</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>99.79</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>DE0001135085</isin>\n" +
                "            <descrizioneTitolo>DEUTSCHLAND REP 4,75 07/04/28</descrizioneTitolo>\n" +
                "            <peso>3.17</peso>\n" +
                "            <prezzoStorico>144.6</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>155.73</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0074299750</isin>\n" +
                "            <descrizioneTitolo>INTERFUND-EQ PAC EX JAPAN-A (INTREMA LX)</descrizioneTitolo>\n" +
                "            <peso>3.0</peso>\n" +
                "            <prezzoStorico>6.79</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>7.12</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>FR0011993179</isin>\n" +
                "            <descrizioneTitolo>FRANCE O.A.T. 0,5 11/25/19</descrizioneTitolo>\n" +
                "            <peso>3.0</peso>\n" +
                "            <prezzoStorico>101.05</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>102.19</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0316492775</isin>\n" +
                "            <descrizioneTitolo>FRANK TEMP GLB BD-I-AC-H-1€ (TEGBIAH LX)</descrizioneTitolo>\n" +
                "            <peso>2.8400000000000003</peso>\n" +
                "            <prezzoStorico>17.86</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>17.5</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0267734829</isin>\n" +
                "            <descrizioneTitolo>INTERFUND-EQUITY USA-H (INTRUSH LX)</descrizioneTitolo>\n" +
                "            <peso>2.75</peso>\n" +
                "            <prezzoStorico>8.95</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>8.64</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0594300500</isin>\n" +
                "            <descrizioneTitolo>FIDELITY-CHINA CONSUMR-YAUSD (FIDCYAU LX)</descrizioneTitolo>\n" +
                "            <peso>2.73</peso>\n" +
                "            <prezzoStorico>14.37</prezzoStorico>\n" +
                "            <cambioStorico>1.25</cambioStorico>\n" +
                "            <prezzoMercato>14.68</prezzoMercato>\n" +
                "            <cambioMercato>1.13</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>USD</nome>\n" +
                "                <simbolo>$</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>DE0008490962</isin>\n" +
                "            <descrizioneTitolo>DWS DEUTSCHLAND (DWSDCHL GR)</descrizioneTitolo>\n" +
                "            <peso>2.65</peso>\n" +
                "            <prezzoStorico>167.65</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>187.29</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>DE0002635299</isin>\n" +
                "            <descrizioneTitolo>ISHR EUROPE SEL DIV 30 DE (SD3PEX IM)</descrizioneTitolo>\n" +
                "            <peso>2.6100000000000003</peso>\n" +
                "            <prezzoStorico>15.75</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>17.14</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0074298604</isin>\n" +
                "            <descrizioneTitolo>INTERFUND-EQUITY ITALY (INTREIT LX)</descrizioneTitolo>\n" +
                "            <peso>2.5700000000000003</peso>\n" +
                "            <prezzoStorico>10.72</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>11.39</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>SI0002103396</isin>\n" +
                "            <descrizioneTitolo>REP OF SLOVENIA 1,75 10/09/17</descrizioneTitolo>\n" +
                "            <peso>2.2800000000000002</peso>\n" +
                "            <prezzoStorico>103.66</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>103.83</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0099405374</isin>\n" +
                "            <descrizioneTitolo>JB JAPAN STOCK FUND-C JPY (JBSJAPC LX)</descrizioneTitolo>\n" +
                "            <peso>2.13</peso>\n" +
                "            <prezzoStorico>17144.0</prezzoStorico>\n" +
                "            <cambioStorico>138.2</cambioStorico>\n" +
                "            <prezzoMercato>18002.0</prezzoMercato>\n" +
                "            <cambioMercato>133.08</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>JPY</nome>\n" +
                "                <simbolo>¥</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0388706961</isin>\n" +
                "            <descrizioneTitolo>FONDITALIA-FLEXIBLE EM MRK-T (FONDYNT LX)</descrizioneTitolo>\n" +
                "            <peso>1.94</peso>\n" +
                "            <prezzoStorico>2.79</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>2.77</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0523287489</isin>\n" +
                "            <descrizioneTitolo>RWC FD-EUR ABSOLUTE ALPHA-B (RWCEABE LX)</descrizioneTitolo>\n" +
                "            <peso>1.91</peso>\n" +
                "            <prezzoStorico>133.08</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>137.17</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0360491038</isin>\n" +
                "            <descrizioneTitolo>MORGAN ST DIV ALPHA PLUS-Z (MSTDIVZ LX)</descrizioneTitolo>\n" +
                "            <peso>1.91</peso>\n" +
                "            <prezzoStorico>36.8</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>36.21</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>IT0004518715</isin>\n" +
                "            <descrizioneTitolo>CCTS 0 07/01/16</descrizioneTitolo>\n" +
                "            <peso>1.7999999999999998</peso>\n" +
                "            <prezzoStorico>100.26</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>100.23</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "    </composizione>\n" +
                "    <informazioniGenerali>\n" +
                "        <commentoaimercati>Nel corso del mese di Agosto 2014 i mercati azionari internazionali hanno registrato un iniziale incremento della volatilità, con un ribasso veloce e profondo seguito da un recupero dei corsi che ha permesso ai mercati sviluppati di chiudere invariati rispetto ad inizio mese  e risultati positivi per quanto riguarda i mercati emergenti. I dati macro  mostrano una situazione non  omogenea nelle diverse aree geografiche, con gli Stati Uniti  avviati su un percorso di crescita stabile ma non elevata mentre l’Europa ha mostrato segnali di debolezza evidenti nel settore manifatturiero. Divergenze sono emerse in tal senso in occasione del simposio internazionale tenutosi a Jackson Hole in cui i presidenti delle diverse Banche centrali si sono riuniti.  La FED  ha confermato i progressi al di sopra delle aspettative del mercato del lavoro e dell’economia, ma evidenzia allo stesso tempo elementi di fragilità come il basso tasso di crescita dei salari  e aree di disoccupazione di lunga durata, elementi che non avvicinano per ora un incremento dei tassi nella prima parte del 2015. La BCE invece ha mostrato una piena disponibilità ad intervenire per sostenere la fragile crescita economica ed impedire che il fenomeno della deflazione danneggi  la congiuntura economica. Da questa situazione interlocutoria, la componente obbligazionaria europea ed americana ha visto un’ulteriore riduzione degli spread e dei rendimenti, in particolare  sulle scadenze più lunghe. Sul fronte delle commodity l’oro ha mostrato una certa stabilità mentre il petrolio ha continuato la dinamica discendente dei prezzi in corso già da due mesi riflettendo le incertezze relative alle prospettive di crescita globale. Discorso a parte il gas che, a fronte delle costanti incertezze geopolitiche tra Russia ed UE, ha visto i propri corsi subire un rialzo.</commentoaimercati>\n" +
                "        <assetallocartion>La prima metà del mese ha visto un incremento della duration all'interno della componente obbligazionaria EMU, riducendo il monetario, e un incremento dell'azionario Europa. Nella seconda parte del mese si è incrementato l'azionario globale in coincidenza con la fase di debolezza sui mercati, e rafforzata la posizione sul dollaro USA tramite obbligazionario EM in hard currency</assetallocartion>\n" +
                "        <operazionidelmese>Non sono state eseguite operazioni di Fund selection nel corso del mese.</operazionidelmese>\n" +
                "    </informazioniGenerali>\n" +
                "    <movimentiUltimoMese>\n" +
                "        <isin>LU0128497707</isin>\n" +
                "        <descrizioneTitolo>PICTET-SHRT TRM MMKT USD-I (PIPUSDI LX)</descrizioneTitolo>\n" +
                "        <divisa>\n" +
                "            <nome>USD</nome>\n" +
                "            <simbolo>$</simbolo>\n" +
                "        </divisa>\n" +
                "        <operazione>Vendita  a contanti</operazione>\n" +
                "        <dataOperazione>2015-01-19T00:00:00+01:00</dataOperazione>\n" +
                "        <dataValuta>2015-01-21T00:00:00+01:00</dataValuta>\n" +
                "        <valoreNominale>3322.0</valoreNominale>\n" +
                "        <prezzoOperazione>134.8</prezzoOperazione>\n" +
                "        <valoreOperazione>385872.99</valoreOperazione>\n" +
                "        <pmRealizzo>57.25</pmRealizzo>\n" +
                "        <cambio>1.16</cambio>\n" +
                "        <pmCambio>17032.97</pmCambio>\n" +
                "        <scartoEmissioni>0.0</scartoEmissioni>\n" +
                "    </movimentiUltimoMese>\n" +
                "    <movimentiUltimoMese>\n" +
                "        <isin>SI0002103065</isin>\n" +
                "        <descrizioneTitolo>REP OF SLOVENIA 2,75 03/17/15</descrizioneTitolo>\n" +
                "        <divisa>\n" +
                "            <nome>EUR</nome>\n" +
                "            <simbolo>€</simbolo>\n" +
                "        </divisa>\n" +
                "        <operazione>Vendita  a contanti</operazione>\n" +
                "        <dataOperazione>2015-01-19T00:00:00+01:00</dataOperazione>\n" +
                "        <dataValuta>2015-01-21T00:00:00+01:00</dataValuta>\n" +
                "        <valoreNominale>176000.0</valoreNominale>\n" +
                "        <prezzoOperazione>100.38</prezzoOperazione>\n" +
                "        <valoreOperazione>176668.8</valoreOperazione>\n" +
                "        <pmRealizzo>-334.4</pmRealizzo>\n" +
                "        <cambio>1.0</cambio>\n" +
                "        <pmCambio>0.0</pmCambio>\n" +
                "        <scartoEmissioni>0.0</scartoEmissioni>\n" +
                "    </movimentiUltimoMese>\n" +
                "    <movimentiUltimoMese>\n" +
                "        <isin>SI0002103396</isin>\n" +
                "        <descrizioneTitolo>REP OF SLOVENIA 1,75 10/09/17</descrizioneTitolo>\n" +
                "        <divisa>\n" +
                "            <nome>EUR</nome>\n" +
                "            <simbolo>€</simbolo>\n" +
                "        </divisa>\n" +
                "        <operazione>Acquisto a contanti</operazione>\n" +
                "        <dataOperazione>2015-01-19T00:00:00+01:00</dataOperazione>\n" +
                "        <dataValuta>2015-01-21T00:00:00+01:00</dataValuta>\n" +
                "        <valoreNominale>200000.0</valoreNominale>\n" +
                "        <prezzoOperazione>103.66</prezzoOperazione>\n" +
                "        <valoreOperazione>207316.0</valoreOperazione>\n" +
                "        <pmRealizzo>0.0</pmRealizzo>\n" +
                "        <cambio>1.0</cambio>\n" +
                "        <pmCambio>0.0</pmCambio>\n" +
                "        <scartoEmissioni>0.0</scartoEmissioni>\n" +
                "    </movimentiUltimoMese>\n" +
                "    <movimentiUltimoMese>\n" +
                "        <isin>IT0005069395</isin>\n" +
                "        <descrizioneTitolo>BTPS 1.05 12/01/19</descrizioneTitolo>\n" +
                "        <divisa>\n" +
                "            <nome>EUR</nome>\n" +
                "            <simbolo>€</simbolo>\n" +
                "        </divisa>\n" +
                "        <operazione>Acquisto a contanti</operazione>\n" +
                "        <dataOperazione>2015-01-19T00:00:00+01:00</dataOperazione>\n" +
                "        <dataValuta>2015-01-21T00:00:00+01:00</dataValuta>\n" +
                "        <valoreNominale>380000.0</valoreNominale>\n" +
                "        <prezzoOperazione>101.04</prezzoOperazione>\n" +
                "        <valoreOperazione>383952.0</valoreOperazione>\n" +
                "        <pmRealizzo>0.0</pmRealizzo>\n" +
                "        <cambio>1.0</cambio>\n" +
                "        <pmCambio>0.0</pmCambio>\n" +
                "        <scartoEmissioni>0.0</scartoEmissioni>\n" +
                "    </movimentiUltimoMese>\n" +
                "    <movimentiUltimoMese>\n" +
                "        <isin>LU0074298943</isin>\n" +
                "        <descrizioneTitolo>INTERFUND-EQUITY USA-A (INTRUSB LX)</descrizioneTitolo>\n" +
                "        <divisa>\n" +
                "            <nome>EUR</nome>\n" +
                "            <simbolo>€</simbolo>\n" +
                "        </divisa>\n" +
                "        <operazione>Vendita  a contanti</operazione>\n" +
                "        <dataOperazione>2015-01-20T00:00:00+01:00</dataOperazione>\n" +
                "        <dataValuta>2015-01-23T00:00:00+01:00</dataValuta>\n" +
                "        <valoreNominale>31549.76</valoreNominale>\n" +
                "        <prezzoOperazione>10.68</prezzoOperazione>\n" +
                "        <valoreOperazione>336825.17</valoreOperazione>\n" +
                "        <pmRealizzo>4795.55</pmRealizzo>\n" +
                "        <cambio>1.0</cambio>\n" +
                "        <pmCambio>0.0</pmCambio>\n" +
                "        <scartoEmissioni>0.0</scartoEmissioni>\n" +
                "    </movimentiUltimoMese>\n" +
                "    <movimentiUltimoMese>\n" +
                "        <isin>LU0289214545</isin>\n" +
                "        <descrizioneTitolo>JPM EUROP EQ PLUS-C PERF AEU (JPMEECA LX)</descrizioneTitolo>\n" +
                "        <divisa>\n" +
                "            <nome>EUR</nome>\n" +
                "            <simbolo>€</simbolo>\n" +
                "        </divisa>\n" +
                "        <operazione>Acquisto a contanti</operazione>\n" +
                "        <dataOperazione>2015-01-19T00:00:00+01:00</dataOperazione>\n" +
                "        <dataValuta>2015-01-23T00:00:00+01:00</dataValuta>\n" +
                "        <valoreNominale>978.22</valoreNominale>\n" +
                "        <prezzoOperazione>176.05</prezzoOperazione>\n" +
                "        <valoreOperazione>172215.98</valoreOperazione>\n" +
                "        <pmRealizzo>0.0</pmRealizzo>\n" +
                "        <cambio>1.0</cambio>\n" +
                "        <pmCambio>0.0</pmCambio>\n" +
                "        <scartoEmissioni>0.0</scartoEmissioni>\n" +
                "    </movimentiUltimoMese>\n" +
                "    <movimentiUltimoMese>\n" +
                "        <isin>LU0325075066</isin>\n" +
                "        <descrizioneTitolo>JPM HGH USSTEEP-C PERF ACCEH (JHUCEHA LX)</descrizioneTitolo>\n" +
                "        <divisa>\n" +
                "            <nome>EUR</nome>\n" +
                "            <simbolo>€</simbolo>\n" +
                "        </divisa>\n" +
                "        <operazione>Acquisto a contanti</operazione>\n" +
                "        <dataOperazione>2015-01-19T00:00:00+01:00</dataOperazione>\n" +
                "        <dataValuta>2015-01-23T00:00:00+01:00</dataValuta>\n" +
                "        <valoreNominale>3220.02</valoreNominale>\n" +
                "        <prezzoOperazione>109.17</prezzoOperazione>\n" +
                "        <valoreOperazione>351529.37</valoreOperazione>\n" +
                "        <pmRealizzo>0.0</pmRealizzo>\n" +
                "        <cambio>1.0</cambio>\n" +
                "        <pmCambio>0.0</pmCambio>\n" +
                "        <scartoEmissioni>0.0</scartoEmissioni>\n" +
                "    </movimentiUltimoMese>\n" +
                "    <movimentiUltimoMese>\n" +
                "        <isin>LU0915179146</isin>\n" +
                "        <descrizioneTitolo>JB-JAPAN STOCK-CH EUR HEDGED (JBJPECH LX)</descrizioneTitolo>\n" +
                "        <divisa>\n" +
                "            <nome>EUR</nome>\n" +
                "            <simbolo>€</simbolo>\n" +
                "        </divisa>\n" +
                "        <operazione>Acquisto a contanti</operazione>\n" +
                "        <dataOperazione>2015-01-20T00:00:00+01:00</dataOperazione>\n" +
                "        <dataValuta>2015-01-26T00:00:00+01:00</dataValuta>\n" +
                "        <valoreNominale>1137.52</valoreNominale>\n" +
                "        <prezzoOperazione>113.41</prezzoOperazione>\n" +
                "        <valoreOperazione>129005.69</valoreOperazione>\n" +
                "        <pmRealizzo>0.0</pmRealizzo>\n" +
                "        <cambio>1.0</cambio>\n" +
                "        <pmCambio>0.0</pmCambio>\n" +
                "        <scartoEmissioni>0.0</scartoEmissioni>\n" +
                "    </movimentiUltimoMese>\n" +
                "    <movimentiUltimoMese>\n" +
                "        <isin>LU0328685093</isin>\n" +
                "        <descrizioneTitolo>PICTET-PAC XJPN-ISUSD (PFLXJIS LX)</descrizioneTitolo>\n" +
                "        <divisa>\n" +
                "            <nome>USD</nome>\n" +
                "            <simbolo>$</simbolo>\n" +
                "        </divisa>\n" +
                "        <operazione>Vendita  a contanti</operazione>\n" +
                "        <dataOperazione>2015-01-19T00:00:00+01:00</dataOperazione>\n" +
                "        <dataValuta>2015-01-26T00:00:00+01:00</dataValuta>\n" +
                "        <valoreNominale>1010.0</valoreNominale>\n" +
                "        <prezzoOperazione>363.03</prezzoOperazione>\n" +
                "        <valoreOperazione>315950.28</valoreOperazione>\n" +
                "        <pmRealizzo>8.71</pmRealizzo>\n" +
                "        <cambio>1.16</cambio>\n" +
                "        <pmCambio>13948.17</pmCambio>\n" +
                "        <scartoEmissioni>0.0</scartoEmissioni>\n" +
                "    </movimentiUltimoMese>\n" +
                "</FondoPersonalizzato>\n";
    }
}
