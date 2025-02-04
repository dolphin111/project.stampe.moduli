import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.stampeservice.request.TrasportBean;
import com.fideuram.utils.Streamer;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 12/12/13
 * Time: 17.01
 */
public class RiscattoParzialeInTendenzaTest  extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(RiscattoParzialeInTendenzaTest.class );
    }

    public void testWsT() {
        TrasportBean tb = new TrasportBean();
        tb.setXml(getXmlFrocio());
        tb.setAction("14");
        try {
            ServiceLocator sl = new ServiceLocator();
            /*Stampe ws = sl.getStampe();
            com.fideuram.stampeservice.Risposta rs = ws.generatePdf(tb);
            assertTrue(rs.getStreams().size()==1);
            Streamer.saveToFile(rs.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "Frocione.pdf");*/
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }

    public static String getXmlFrocio(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><polizza desc=\"Riscatto Parziale in Tendenza\" order=\"1\"><id desc=\"Numero Polizza\" order=\"1.1\">70004269102</id><reteVendita desc=\"Rete Vendita\">BFI</reteVendita><dettaglio desc=\"Informazioni Generali Polizza\" order=\"1.2\"><datiPolizza order=\"1.2.1\" desc=\"Dati Polizza\"><numeroPolizza desc=\"Polizza n.\" order=\"1.2.1.1\">70004269102</numeroPolizza><codiceConferimento desc=\"Codice Conferimento\" order=\"1.2.1.2\">007399RS002</codiceConferimento><prodotto desc=\"ProdottoCommerciale\" order=\"1.2.1.3\">RS0U1 - Fideuram Vita Insieme</prodotto><tariffa desc=\"Tariffa\" order=\"1.2.1.4\">931 - Vita intera a Premio Unico con  Aggiuntivi</tariffa><stato desc=\"Stato\" order=\"1.2.1.5\">Attiva</stato><dataEmissione desc=\"Data Emissione\" order=\"1.2.1.6\">28/09/2011</dataEmissione><dataScadenza desc=\"Data Scadenza Polizza\" order=\"1.2.1.7\">31/12/2100</dataScadenza><dataRichiesta desc=\"Data Elaborazione\" order=\"1.2.1.8\">12/12/2013</dataRichiesta><premiVersati desc=\"Premi Versati\" order=\"1.2.1.11\">NaN</premiVersati><ramoMinisteriale desc=\"Ramo Ministeriale\" order=\"1.2.1.9\">3</ramoMinisteriale><tipoPrestazione desc=\"TipoPrestazione\" order=\"1.2.1.10\">C</tipoPrestazione></datiPolizza><contraente desc=\"Dati Contraente\" order=\"1.2.2\"><nominativo desc=\"Nominativo\" order=\"1.2.2.1\">MARIA GRAZIA STROCCHIO</nominativo><dataNascita desc=\"Data Nascita\" order=\"1.2.2.2\">12/01/1943</dataNascita><codiceFiscale desc=\"Codice Fiscale\" order=\"1.2.3.3\">STRMGR43A52D388N</codiceFiscale></contraente><primoAssicurato desc=\"Dati Primo Assicurato\" order=\"1.2.3\"><nominativo desc=\"Nominativo\" order=\"1.2.3.1\">MARIA GRAZIA STROCCHIO</nominativo><dataNascita desc=\"Data Nascita\" order=\"1.2.3.2\">12/01/1943</dataNascita><codiceFiscale desc=\"Codice Fiscale\" order=\"1.2.3.3\">STRMGR43A52D388N</codiceFiscale></primoAssicurato></dettaglio><valoreRiscattoParzialeRichiesto desc=\"Valore riscatto parziale richiesto\">1.000,00</valoreRiscattoParzialeRichiesto><isRamo3 desc=\"\">true</isRamo3><dataRiferimentoNav desc=\"Data riferimento NAV\">09/12/2013</dataRiferimentoNav><fondo desc=\"\">true</fondo><fondi><fondoInternoOicr>FONDITALIA EURO CORPORATE BOND \"T\"</fondoInternoOicr><quote>6,74653</quote><valoreQuota>9,64</valoreQuota><controvaloreQuoteLiquidate>65,05</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>FONDITALIA EQUITY EUROPE \"T\"</fondoInternoOicr><quote>3,04584</quote><valoreQuota>11,80</valoreQuota><controvaloreQuoteLiquidate>35,95</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>FONDITALIA BOND GLOBAL EMERGING MARKETS \"T\"</fondoInternoOicr><quote>5,02701</quote><valoreQuota>12,40</valoreQuota><controvaloreQuoteLiquidate>62,35</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>FONDITALIA FLEXIBLE ITALY \"T\"</fondoInternoOicr><quote>4,08844</quote><valoreQuota>12,71</valoreQuota><controvaloreQuoteLiquidate>51,96</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>FIDEURAM FUND MARSHALL WACE TOPS</fondoInternoOicr><quote>9,17703</quote><valoreQuota>11,09</valoreQuota><controvaloreQuoteLiquidate>101,81</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>INTERFUND EQUITY JAPAN \"H\"</fondoInternoOicr><quote>6,36069</quote><valoreQuota>3,08</valoreQuota><controvaloreQuoteLiquidate>19,61</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>FIDELITY EMG EUR MID EAST AFRI \"Y\" (USD)</fondoInternoOicr><quote>4,37727</quote><valoreQuota>9,48</valoreQuota><controvaloreQuoteLiquidate>41,50</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>TEMPLETON ASIAN GROWTH \"I\"</fondoInternoOicr><quote>1,28560</quote><valoreQuota>24,37</valoreQuota><controvaloreQuoteLiquidate>31,33</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>TEMPLETON GLB TOT RETURN \"I\" ACC (EUR H1)</fondoInternoOicr><quote>5,40957</quote><valoreQuota>19,02</valoreQuota><controvaloreQuoteLiquidate>102,89</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>MSS DIVERSIFIED ALPHA PLUS \"Z\" ACC</fondoInternoOicr><quote>2,48992</quote><valoreQuota>35,21</valoreQuota><controvaloreQuoteLiquidate>87,67</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>MSS GLOBAL BRANDS \"ZH\" ACC</fondoInternoOicr><quote>0,70358</quote><valoreQuota>49,76</valoreQuota><controvaloreQuoteLiquidate>35,01</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>MSS US ADVANTAGE \"ZH\" ACC</fondoInternoOicr><quote>0,54872</quote><valoreQuota>55,73</valoreQuota><controvaloreQuoteLiquidate>30,58</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>PIMCO GLB HIGH YIELD BOND \"I\" (EUR HDG)</fondoInternoOicr><quote>4,94939</quote><valoreQuota>18,97</valoreQuota><controvaloreQuoteLiquidate>93,89</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>INVESCO BALANCED RISK ALLOCATION \"C\"</fondoInternoOicr><quote>5,70416</quote><valoreQuota>14,67</valoreQuota><controvaloreQuoteLiquidate>83,68</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>FRANKLIN EUROPEAN GROWTH \"I\" ACC (EUR)</fondoInternoOicr><quote>1,55823</quote><valoreQuota>27,39</valoreQuota><controvaloreQuoteLiquidate>42,68</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>PICTET EUR SHORT TERM HIGH YIELD \"I\" (EUR)</fondoInternoOicr><quote>0,45447</quote><valoreQuota>115,63</valoreQuota><controvaloreQuoteLiquidate>52,55</controvaloreQuoteLiquidate></fondi><fondi><fondoInternoOicr>FONDITALIA FLEXIBLE BOND \"T\"</fondoInternoOicr><quote>7,11607</quote><valoreQuota>8,64</valoreQuota><controvaloreQuoteLiquidate>61,49</controvaloreQuoteLiquidate></fondi><totaleQuoteLiquidate desc=\"Totale Quote Liquidate\">69,04252</totaleQuoteLiquidate><totaleControvaloreQuoteLiquidate desc=\"Totale Controvalore Quote Liquidate\">1.000,00</totaleControvaloreQuoteLiquidate></polizza>";
    }
}
