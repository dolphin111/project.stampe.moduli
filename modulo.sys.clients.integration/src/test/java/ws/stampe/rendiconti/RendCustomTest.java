package ws.stampe.rendiconti;

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

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 14/01/15
 * Time: 9.29
 */
public class RendCustomTest extends TestCase {

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(RendCustomTest.class );
    }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("6016");
        trasportBean.setXml(getXml());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            //Risposta r =Stampe.generatePdf(trasportBean);
            Risposta r =Stampe.generateOdt(trasportBean);
            //assertNotNull(r.getStreams());
            //assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "TestRendicontoCustom.odt");
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }



    public static String getXml(){

        return  "<FondoPersonalizzato>\n" +
                "    <dataRiferimento>2014-12-31T00:00:00+01:00</dataRiferimento>\n" +
                "    <hasUltimoAnnoElement>false</hasUltimoAnnoElement>\n" +
                "    <hasBiennioElemnt>false</hasBiennioElemnt>\n" +
                "    <hasTriennioElemnt>false</hasTriennioElemnt>\n" +
                "    <hasQuinquennioElemnt>false</hasQuinquennioElemnt>\n" +
                "    <hasDecennioElemnt>false</hasDecennioElemnt>\n" +
                "    <nomeProdotto>FVI AZZURRA</nomeProdotto>\n" +
                "    <tipoProdotto>Fondo Interno Assicurativo</tipoProdotto>\n" +
                "    <dataPartenza>2014-03-28T00:00:00+01:00</dataPartenza>\n" +
                "    <volatilita>\n" +
                "        <percVolatilitaMaxAttesa>10%</percVolatilitaMaxAttesa>\n" +
                "        <percVolatilitaProspettica>---</percVolatilitaProspettica>\n" +
                "        <rischio>\n" +
                "            <profilo>Medio - alto</profilo>\n" +
                "        </rischio>\n" +
                "    </volatilita>\n" +
                "    <nav>10.559</nav>\n" +
                "    <dataNav>2014-12-30T00:00:00+01:00</dataNav>\n" +
                "    <patrimonio>1.237945312E7</patrimonio>\n" +
                "    <gestione>\n" +
                "        <stile>Flessibile</stile>\n" +
                "        <obiettivo>Il Fondo si propone di conseguire il più elevato incremento del valore dell'investimento finanziario, mantenendo la volatilità annua attesa del valore unitario delle quote entro il 10%</obiettivo>\n" +
                "    </gestione>\n" +
                "    <benchmark>\n" +
                "        <previsto>Non previsto</previsto>\n" +
                "    </benchmark>\n" +
                "    <macroAsset>\n" +
                "        <percentuali>\n" +
                "            <key>Liquidita'</key>\n" +
                "            <value>1.77</value>\n" +
                "            <codiceColore>#929084</codiceColore>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Obbligazionario</key>\n" +
                "            <value>98.23</value>\n" +
                "            <codiceColore>#a7a59b</codiceColore>\n" +
                "        </percentuali>\n" +
                "        <nd>false</nd>\n" +
                "    </macroAsset>\n" +
                "    <scompGeo>\n" +
                "        <percentuali>\n" +
                "            <key>N/D</key>\n" +
                "            <value>0.0</value>\n" +
                "        </percentuali>\n" +
                "        <nd>false</nd>\n" +
                "    </scompGeo>\n" +
                "    <compoObblg>\n" +
                "        <percentuali>\n" +
                "            <key>Obbligazionario Corporate Euro</key>\n" +
                "            <value>32.34</value>\n" +
                "            <codiceColore>#929084</codiceColore>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Obbligazionario High Yield</key>\n" +
                "            <value>6.6</value>\n" +
                "            <codiceColore>#a7a59b</codiceColore>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Inflation Linked</key>\n" +
                "            <value>3.3</value>\n" +
                "            <codiceColore>#bdbbb3</codiceColore>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Governativo  Euro 1-3</key>\n" +
                "            <value>17.05</value>\n" +
                "            <codiceColore>#d3d1cc</codiceColore>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Governativo Euro 3-5</key>\n" +
                "            <value>16.22</value>\n" +
                "            <codiceColore>#eae8e5</codiceColore>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Governativo Euro 5-10</key>\n" +
                "            <value>11.19</value>\n" +
                "            <codiceColore>#1a1a1a</codiceColore>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Governativo Euro 10+</key>\n" +
                "            <value>1.56</value>\n" +
                "            <codiceColore>#333333</codiceColore>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Governativo ex Euro</key>\n" +
                "            <value>9.97</value>\n" +
                "            <codiceColore>#4d4d4d</codiceColore>\n" +
                "        </percentuali>\n" +
                "        <nd>false</nd>\n" +
                "    </compoObblg>\n" +
                "    <performance>\n" +
                "        <andamentoGrafico>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-04-30T00:00:00+02:00</data>\n" +
                "                <value>9.989</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-05-30T00:00:00+02:00</data>\n" +
                "                <value>10.073</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-06-30T00:00:00+02:00</data>\n" +
                "                <value>10.122</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-07-31T00:00:00+02:00</data>\n" +
                "                <value>10.182</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-08-29T00:00:00+02:00</data>\n" +
                "                <value>10.287</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-09-30T00:00:00+02:00</data>\n" +
                "                <value>10.391</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-10-31T00:00:00+01:00</data>\n" +
                "                <value>10.406</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-11-28T00:00:00+01:00</data>\n" +
                "                <value>10.49</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-12-30T00:00:00+01:00</data>\n" +
                "                <value>10.559</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2015-01-30T00:00:00+01:00</data>\n" +
                "                <value>10.898</value>\n" +
                "            </andamento>\n" +
                "        </andamentoGrafico>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <mese1>0.6556154416171849</mese1>\n" +
                "            <mese3>-1.5846074218093116</mese3>\n" +
                "            <mese6>4.197096383177504</mese6>\n" +
                "            <mese12>0.0</mese12>\n" +
                "            <daInizioFondo>5.4793563851671685</daInizioFondo>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <volatilitaAnnua>\n" +
                "            <mese1>2.7307214921928296</mese1>\n" +
                "            <mese3>2.792020658569619</mese3>\n" +
                "            <mese6>2.352532159992178</mese6>\n" +
                "            <mese12>0.0</mese12>\n" +
                "            <daInizioFondo>2.28813722508686</daInizioFondo>\n" +
                "        </volatilitaAnnua>\n" +
                "        <modifiedDuration>0.0</modifiedDuration>\n" +
                "    </performance>\n" +
                "    <composizione>\n" +
                "        <dataRiferimento>2014-12-31T00:00:00+01:00</dataRiferimento>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0074298786</isin>\n" +
                "            <descrizioneTitolo>INTERFUND-EUR CORPORATE BOND (INTREBR LX)</descrizioneTitolo>\n" +
                "            <peso>15.36</peso>\n" +
                "            <prezzoStorico>6.02</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>6.06</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0250744751</isin>\n" +
                "            <descrizioneTitolo>INTERFUND-EURO BND SHT T 3-5 (INTEBND LX)</descrizioneTitolo>\n" +
                "            <peso>15.32</peso>\n" +
                "            <prezzoStorico>13.46</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>13.5</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>XS0638878461</isin>\n" +
                "            <descrizioneTitolo>AUSTRIA REP OF 1,75 06/17/16</descrizioneTitolo>\n" +
                "            <peso>10.38</peso>\n" +
                "            <prezzoStorico>102.61</prezzoStorico>\n" +
                "            <cambioStorico>1.39</cambioStorico>\n" +
                "            <prezzoMercato>101.77</prezzoMercato>\n" +
                "            <cambioMercato>1.22</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>USD</nome>\n" +
                "                <simbolo>$</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0074297200</isin>\n" +
                "            <descrizioneTitolo>INTERFUND-EURO BOND MED TERM (INTREMT LX)</descrizioneTitolo>\n" +
                "            <peso>10.32</peso>\n" +
                "            <prezzoStorico>10.73</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>10.92</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>US912828A263</isin>\n" +
                "            <descrizioneTitolo>US TREASURY N/B 0,25 11/30/15</descrizioneTitolo>\n" +
                "            <peso>10.2</peso>\n" +
                "            <prezzoStorico>99.99</prezzoStorico>\n" +
                "            <cambioStorico>1.38</cambioStorico>\n" +
                "            <prezzoMercato>100.02</prezzoMercato>\n" +
                "            <cambioMercato>1.22</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>USD</nome>\n" +
                "                <simbolo>$</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>US2515A14E85</isin>\n" +
                "            <descrizioneTitolo>DEUTSCHE BK LOND 3,25 01/11/16</descrizioneTitolo>\n" +
                "            <peso>9.75</peso>\n" +
                "            <prezzoStorico>104.17</prezzoStorico>\n" +
                "            <cambioStorico>1.38</cambioStorico>\n" +
                "            <prezzoMercato>102.46</prezzoMercato>\n" +
                "            <cambioMercato>1.22</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>USD</nome>\n" +
                "                <simbolo>$</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>IT0005044976</isin>\n" +
                "            <descrizioneTitolo>CTZS 0 08/30/16</descrizioneTitolo>\n" +
                "            <peso>4.1000000000000005</peso>\n" +
                "            <prezzoStorico>99.1</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>99.13</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>IT0005058919</isin>\n" +
                "            <descrizioneTitolo>BTPS I/L 1.25 10/27/20</descrizioneTitolo>\n" +
                "            <peso>3.36</peso>\n" +
                "            <prezzoStorico>100.27</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>101.97</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>IT0005020778</isin>\n" +
                "            <descrizioneTitolo>CTZS 0 04/29/16</descrizioneTitolo>\n" +
                "            <peso>2.88</peso>\n" +
                "            <prezzoStorico>98.41</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>99.41</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>XS0995102695</isin>\n" +
                "            <descrizioneTitolo>ING BANK NV 3,5 11/21/23</descrizioneTitolo>\n" +
                "            <peso>2.63</peso>\n" +
                "            <prezzoStorico>103.0</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>106.04</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>XS1072613380</isin>\n" +
                "            <descrizioneTitolo>POSTE VITA 2,875 05/30/19</descrizioneTitolo>\n" +
                "            <peso>2.59</peso>\n" +
                "            <prezzoStorico>100.13</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>104.43</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>XS1057487875</isin>\n" +
                "            <descrizioneTitolo>FGA CAPITAL IRE 2,625 04/17/19</descrizioneTitolo>\n" +
                "            <peso>2.5700000000000003</peso>\n" +
                "            <prezzoStorico>100.35</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>103.81</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>XS0999654873</isin>\n" +
                "            <descrizioneTitolo>FINMEC FNCE SA 4,5 01/19/21</descrizioneTitolo>\n" +
                "            <peso>2.2399999999999998</peso>\n" +
                "            <prezzoStorico>105.05</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>108.29</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>XS0868458653</isin>\n" +
                "            <descrizioneTitolo>TELECOM ITALIA 4 01/21/20</descrizioneTitolo>\n" +
                "            <peso>2.21</peso>\n" +
                "            <prezzoStorico>104.65</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>106.82</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>XS1046851025</isin>\n" +
                "            <descrizioneTitolo>CNH IND FIN 2,75 03/18/19</descrizioneTitolo>\n" +
                "            <peso>2.1</peso>\n" +
                "            <prezzoStorico>101.12</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>101.48</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>LU0074297978</isin>\n" +
                "            <descrizioneTitolo>INTERFUND-EURO BOND LNG TERM (INTRELT LX)</descrizioneTitolo>\n" +
                "            <peso>1.6</peso>\n" +
                "            <prezzoStorico>12.03</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>12.64</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>IT0005030504</isin>\n" +
                "            <descrizioneTitolo>BTPS 1,5 08/01/19</descrizioneTitolo>\n" +
                "            <peso>1.27</peso>\n" +
                "            <prezzoStorico>102.37</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>102.56</prezzoMercato>\n" +
                "            <cambioMercato>1.0</cambioMercato>\n" +
                "            <div>\n" +
                "                <nome>EUR</nome>\n" +
                "                <simbolo>€</simbolo>\n" +
                "            </div>\n" +
                "        </posizioni>\n" +
                "        <posizioni>\n" +
                "            <isin>IT0005028003</isin>\n" +
                "            <descrizioneTitolo>BTPS 2.15 12/15/21</descrizioneTitolo>\n" +
                "            <peso>1.13</peso>\n" +
                "            <prezzoStorico>100.11</prezzoStorico>\n" +
                "            <cambioStorico>1.0</cambioStorico>\n" +
                "            <prezzoMercato>104.99</prezzoMercato>\n" +
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
                "</FondoPersonalizzato>";
    }

   /* public static String getXml(){

        return  "<FondoPersonalizzato>\n" +
                "    <dataRiferimento>2014-12-08T14:55:24.791+01:00</dataRiferimento>"+
                "    <hasUltimoAnnoElement>false</hasUltimoAnnoElement>\n" +
                "    <hasBiennioElemnt>false</hasBiennioElemnt>\n" +
                "    <hasTriennioElemnt>false</hasTriennioElemnt>\n" +
                "    <hasQuinquennioElemnt>false</hasQuinquennioElemnt>\n" +
                "    <hasDecennioElemnt>false</hasDecennioElemnt>\n" +
                "    <nomeProdotto>GB FUND CRESCITA</nomeProdotto>\n" +
                "    <tipoProdotto>Fondo Interno Assicurativo</tipoProdotto>\n" +
                "    <dataPartenza>2014-08-11T00:00:00+02:00</dataPartenza>\n" +
                "    <volatilita>\n" +
                "        <percVolatilitaMaxAttesa>6.0</percVolatilitaMaxAttesa>\n" +
                "        <percVolatilitaProspettica>---</percVolatilitaProspettica>\n" +
                "        <rischio>\n" +
                "            <profilo>Medio Alto</profilo>\n" +
                "        </rischio>\n" +
                "    </volatilita>\n" +
                "    <nav>10546464.092</nav>\n" +
                "    <dataNav>2014-11-28T00:00:00+01:00</dataNav>\n" +
                "    <gestione>\n" +
                "        <stile>Flessibile</stile>\n" +
                "        <obiettivo>Obiettivo........</obiettivo>\n" +
                "    </gestione>\n" +
                "    <macroAsset>\n" +
                "        <percentuali>\n" +
                "            <key>Liquidita'</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Bilanciati</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Obbligazionario</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Azionario</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Monetario</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Convertibles</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Flessibili</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "    </macroAsset>\n" +
                "    <scompGeo>\n" +
                "        <percentuali>\n" +
                "            <key>Nord America</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Europa</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Giappone</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Pacifico ex Giappone</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>EM\tEmerging Market</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "    </scompGeo>\n" +
                "    <compoObblg>\n" +
                "        <percentuali>\n" +
                "            <key>Monetario Euro</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Obbligazionario Mercati Emergenti</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Obbligazionario Corporate Euro</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Monetario Altro</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Obbligazionario High Yield</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Inflation Linked</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Governativo  Euro 1-3</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Governativo Euro 3-5</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Governativo Euro 5-10</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Governativo Euro 10+</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "        <percentuali>\n" +
                "            <key>Altro</key>\n" +
                "            <value>0.00</value>\n" +
                "        </percentuali>\n" +
                "    </compoObblg>\n" +
                "    <performance>\n" +
                "        <andamentoGrafico>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-08-29T00:00:00+02:00</data>\n" +
                "                <value>10.05</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-09-30T00:00:00+02:00</data>\n" +
                "                <value>10.038</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-10-31T00:00:00+01:00</data>\n" +
                "                <value>9.929</value>\n" +
                "            </andamento>\n" +
                "            <andamento>\n" +
                "                <linea>Prezzo netto quote</linea>\n" +
                "                <data>2014-11-28T00:00:00+01:00</data>\n" +
                "                <value>10.092</value>\n" +
                "            </andamento>\n" +
                "        </andamentoGrafico>\n" +
                "        <rendimentoAnnuo>\n" +
                "            <mese1>-0.11947432723430347</mese1>\n" +
                "            <mese3>0.0</mese3>\n" +
                "            <mese6>0.0</mese6>\n" +
                "            <mese12>0.0</mese12>\n" +
                "            <daInizioFondo>0.3792798238695945</daInizioFondo>\n" +
                "        </rendimentoAnnuo>\n" +
                "        <volatilitaAnnua>\n" +
                "            <mese1>0.0</mese1>\n" +
                "            <mese3>0.0</mese3>\n" +
                "            <mese6>0.0</mese6>\n" +
                "            <mese12>0.0</mese12>\n" +
                "            <daInizioFondo>2.0803876514484743</daInizioFondo>\n" +
                "        </volatilitaAnnua>\n" +
                "        <modifiedDuration>0.0</modifiedDuration>\n" +
                "    </performance>\n" +
                "    <composizione>\n" +
                "        <dataRiferimento>2014-11-30T00:00:00+01:00</dataRiferimento>\n" +
                "    </composizione>\n" +
                "    <informazioniGenerali>\n" +
                "        <commentoaimercati>Nel corso del mese di Ottobre 2014 i  mercati azionari sono stati caratterizzati nella prima parte del mese da una forte volatilità che  ha portato alla formazione di un minimo profondo attorno alla metà del mese.  Successivamente la reazione rialzista dai minimi di metà mese è stata maggiore per gli indici americani cinesi e giapponesi, che hanno in gran parte recuperato le perdite mensili, mentre gli indici europei ed emergenti hanno recuperato parzialmente le perdite.\n" +
                "Per quanto riguarda i dati macro L’Europa ha registrato dati ancora deboli, in particolare in Germania,  dove i dati di produzione industriale e di fiducia delle imprese sono stati deludenti. In Cina  i dati economici delineano un quadro di crescita ancora buono ma in prospettiva indirizzato verso un percorso più moderato. In questo paese infatti  molti analisti hanno ridimensionato  le stime di crescita del PIL per tenere conto dell’effetto delle  riforme strutturali in corso e alla debolezza del mercato immobiliare, pur sottolineando che la crescita rimane all'interno di un range ragionevole. Negli Stati Uniti si dati macro positivi segnalano un progressivo rafforzamento dell’economia, con il PIL del terzo trimestre ancora sopra le attese degli analisti. Sul fronte della politica monetaria   la BCE ha  avviato  il programma di acquisto di obbligazioni  bancarie garantite  da immobili mentre sono stati resi noti i risultati dei test sulla solidità dei bilanci bancari europei, senza significative sorprese negative.   Alla fine del mese si è anche avuta la riunione della FED che, oltre a confermare come da attese la fine del QE, ha variato la propria comunicazione sui prossimi rialzi dei tassi in senso maggiormente restrittivo. Allo stesso tempo  il comitato ha  minimizzato i rischi di inflazione al di sotto del target e ha sottolineato che la capacità produttiva inutilizzata è in graduale diminuzione, suggerendo che i dati  macro restano il principale driver per le variazioni di politica monetaria. A sorpresa, in Giappone  la Banca Centrale ha deciso di ampliare in anticipo  la politica monetaria espansiva già in essere  con l’obiettivo di  reflazionare l’economia prima della possibile introduzione di nuovi incrementi sull’imposta del valore aggiunto.\n" +
                "....\n" +
                "</commentoaimercati>\n" +
                "        <assetallocartion>Nel corso del mese non sono state effettuate operazioni di portafoglio.</assetallocartion>\n" +
                "        <operazionidelmese>Non sono state eseguite operazioni di Fund selection nel corso del mese.</operazionidelmese>\n" +
                "    </informazioniGenerali>\n" +
                "</FondoPersonalizzato>";
    }*/
}
