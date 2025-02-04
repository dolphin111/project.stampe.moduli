package com.fideuram.mock;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.controller.OdtRequest;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;

import java.io.FileOutputStream;

/**
 * User: V801068
 * Date: 01/12/14
 * Time: 10.46
 */
public class SimulatoreFPAServiziFVtest {
    public static void main(String args[]) throws Exception {
        Stampe s=new Stampe();

//        byte[]   b  =   s.getOdtFromXml(getXmlCalcoloEta(),"simulatoriFPA");
//        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "SimulatoreFPA.odt");
//
//        byte[]   b  =   s.getOdtFromXml(getXmlMulticomparto(),"simulatoriMulticompartoFPA");
//        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "SimulatoreFPA.odt");

      byte[]   b  =   s.getOdtFromXml(getXmlSimulazioniFPA(),"simulatoriFPA");
      StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "SimulatoreFPA.odt"); 
    
    }


    public static String getXmlCalcoloEta(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?> <dettaglioCoefficienteRenditaFrazionataPVO><fondoPensione>FIDEURAM VALORE</fondoPensione><prospettoLiquidativo>Prestazione pensionistica nella misura del 100%</prospettoLiquidativo><numeroPosizione>70014474302</numeroPosizione><aderente>STORARI ROSSANA</aderente><tipologiaAderente>Nuovo iscritto</tipologiaAderente><dataPrimaIscrizioneFormePensionisticheComplementari>2008-03-04T00:00:00+01:00</dataPrimaIscrizioneFormePensionisticheComplementari><dataAdesioneFondo>2013-11-26T00:00:00+01:00</dataAdesioneFondo><totaleContributiVersatiNettiFondoGenerale>21729.61</totaleContributiVersatiNettiFondoGenerale><numeroQuote>1440.809</numeroQuote><valoreQuota>18.113</valoreQuota><controvalore>26097.37</controvalore><valoreLordoPrestazionePensionistica100>26097.37</valoreLordoPrestazionePensionistica100><valoreLordoPrestazionePensionistica50>13048.68</valoreLordoPrestazionePensionistica50><renditaImmediata100>    <ammontarePosizioneIndividualeMaturata>26097.37</ammontarePosizioneIndividualeMaturata>    <coefficienteRenditaFrazionata>21.2137</coefficienteRenditaFrazionata>    <rateazioneAnnua>1230.21</rateazioneAnnua>    <rateazioneMensile>1227.26</rateazioneMensile>    <rateazioneSemestrale>1229.23</rateazioneSemestrale>    <rateazioneTrimestrale>1228.24</rateazioneTrimestrale></renditaImmediata100><renditaImmediata50>    <ammontarePosizioneIndividualeMaturata>13048.68</ammontarePosizioneIndividualeMaturata>    <coefficienteRenditaFrazionata>21.2137</coefficienteRenditaFrazionata>    <rateazioneAnnua>615.11</rateazioneAnnua>    <rateazioneMensile>613.63</rateazioneMensile>    <rateazioneSemestrale>614.61</rateazioneSemestrale>    <rateazioneTrimestrale>614.12</rateazioneTrimestrale></renditaImmediata50><renditaGarantita5Anni>    <ammontarePosizioneIndividualeMaturata>26097.37</ammontarePosizioneIndividualeMaturata>    <coefficienteRenditaFrazionata>21.328854</coefficienteRenditaFrazionata>    <rateazioneAnnua>1223.57</rateazioneAnnua>    <rateazioneMensile>1220.65</rateazioneMensile>    <rateazioneSemestrale>1222.6</rateazioneSemestrale>    <rateazioneTrimestrale>1221.62</rateazioneTrimestrale></renditaGarantita5Anni><renditaGarantita10Anni>    <ammontarePosizioneIndividualeMaturata>26097.37</ammontarePosizioneIndividualeMaturata>    <coefficienteRenditaFrazionata>21.73949</coefficienteRenditaFrazionata>    <rateazioneAnnua>1200.46</rateazioneAnnua>    <rateazioneMensile>1197.65</rateazioneMensile>    <rateazioneSemestrale>1199.52</rateazioneSemestrale>    <rateazioneTrimestrale>1198.58</rateazioneTrimestrale></renditaGarantita10Anni><renditaImmediata85Anni>    <ammontarePosizioneIndividualeMaturata>26097.37</ammontarePosizioneIndividualeMaturata>    <coefficienteRenditaFrazionata>0.0</coefficienteRenditaFrazionata>    <rateazioneAnnua>1251.04</rateazioneAnnua>    <rateazioneMensile>1204.22</rateazioneMensile>    <rateazioneSemestrale>1225.06</rateazioneSemestrale>    <rateazioneTrimestrale>1212.47</rateazioneTrimestrale></renditaImmediata85Anni><ammontarePosizioneIndividualeMaturata>26097.37</ammontarePosizioneIndividualeMaturata><riscattabilita100>true</riscattabilita100><tabellaDemografica>A62_0</tabellaDemografica><dataNavRiferimento>2019-08-31T00:00:00+02:00</dataNavRiferimento><dataElaborazione>2019-09-11T12:13:17.359+02:00</dataElaborazione><premioAggiuntivoRaggiungimento>63115.32865714286</premioAggiuntivoRaggiungimento><renditaAnnuaPostVersamentoPremioAggiuntivo>4205.428504086645</renditaAnnuaPostVersamentoPremioAggiuntivo><etaCalcolo>69</etaCalcolo> </dettaglioCoefficienteRenditaFrazionataPVO>";
    }


    
    public static String getXmlMulticomparto(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><dettaglioCoefficienteRenditaFrazionataPVO>    <fondoPensione>FIDEURAM MULTICOMPARTO</fondoPensione>    <prospettoLiquidativo>Prestazione pensionistica nella misura del 100%</prospettoLiquidativo>    <numeroPosizione>70002142201</numeroPosizione>    <aderente>NEGRO GIOVANNA</aderente>    <tipologiaAderente>Nuovo iscritto</tipologiaAderente>    <dataPrimaIscrizioneFormePensionisticheComplementari>2008-07-31T00:00:00+02:00</dataPrimaIscrizioneFormePensionisticheComplementari>    <dataAdesioneFondo>2008-07-31T00:00:00+02:00</dataAdesioneFondo>    <totaleContributiVersatiNettiFondoGenerale>54528.48</totaleContributiVersatiNettiFondoGenerale>    <numeroQuote>4500.329</numeroQuote>    <controvalore>67381.0</controvalore>    <valoreLordoPrestazionePensionistica100>67381.0</valoreLordoPrestazionePensionistica100>    <valoreLordoPrestazionePensionistica50>33690.5</valoreLordoPrestazionePensionistica50>    <renditaImmediata100>        <ammontarePosizioneIndividualeMaturata>67381.0</ammontarePosizioneIndividualeMaturata>        <coefficienteRenditaFrazionata>20.9848</coefficienteRenditaFrazionata>        <rateazioneAnnua>3210.94</rateazioneAnnua>        <rateazioneMensile>3168.67</rateazioneMensile>        <rateazioneSemestrale>3173.75</rateazioneSemestrale>        <rateazioneTrimestrale>3171.21</rateazioneTrimestrale>    </renditaImmediata100>    <renditaImmediata50>        <ammontarePosizioneIndividualeMaturata>33690.5</ammontarePosizioneIndividualeMaturata>        <coefficienteRenditaFrazionata>20.9848</coefficienteRenditaFrazionata>        <rateazioneAnnua>1605.47</rateazioneAnnua>        <rateazioneMensile>1584.34</rateazioneMensile>        <rateazioneSemestrale>1586.87</rateazioneSemestrale>        <rateazioneTrimestrale>1585.6</rateazioneTrimestrale>    </renditaImmediata50>    <renditaGarantita5Anni>        <ammontarePosizioneIndividualeMaturata>67381.0</ammontarePosizioneIndividualeMaturata>        <coefficienteRenditaFrazionata>21.328854</coefficienteRenditaFrazionata>        <rateazioneAnnua>3159.15</rateazioneAnnua>        <rateazioneMensile>3151.61</rateazioneMensile>        <rateazioneSemestrale>3156.63</rateazioneSemestrale>        <rateazioneTrimestrale>3154.12</rateazioneTrimestrale>    </renditaGarantita5Anni>    <renditaGarantita10Anni>        <ammontarePosizioneIndividualeMaturata>67381.0</ammontarePosizioneIndividualeMaturata>        <coefficienteRenditaFrazionata>21.73949</coefficienteRenditaFrazionata>        <rateazioneAnnua>3099.47</rateazioneAnnua>        <rateazioneMensile>3092.22</rateazioneMensile>        <rateazioneSemestrale>3097.05</rateazioneSemestrale>        <rateazioneTrimestrale>3094.63</rateazioneTrimestrale>    </renditaGarantita10Anni>    <ammontarePosizioneIndividualeMaturata>67381.0</ammontarePosizioneIndividualeMaturata>    <riscattabilita100>true</riscattabilita100>    <listaComparti>        <controvalore>35190.72</controvalore>        <dataNav>2019-04-30T00:00:00+02:00</dataNav>        <descrizioneComparto>FIDEURAM VALORE</descrizioneComparto>        <numeroQuote>1970.69600</numeroQuote>        <valoreNav>17.85700</valoreNav>    </listaComparti>    <listaComparti>        <controvalore>31529.35</controvalore>        <dataNav>2019-04-30T00:00:00+02:00</dataNav>        <descrizioneComparto>FIDEURAM GARANZIA</descrizioneComparto>        <numeroQuote>2529.63300</numeroQuote>        <valoreNav>12.46400</valoreNav>    </listaComparti>    <tabellaDemografica>A62_0</tabellaDemografica>    <dataNavRiferimento>2019-04-30T00:00:00+02:00</dataNavRiferimento>    <dataElaborazione>2019-10-11T09:59:29.162+02:00</dataElaborazione>    <premioAggiuntivoRaggiungimento>20869.077485714286</premioAggiuntivoRaggiungimento>    <renditaAnnuaPostVersamentoPremioAggiuntivo>4205.428571428572</renditaAnnuaPostVersamentoPremioAggiuntivo>    <etaCalcolo>70</etaCalcolo></dettaglioCoefficienteRenditaFrazionataPVO>";
    }
    
    public static String getXmlSimulazioniFPA(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<<dettaglioCoefficienteRenditaFrazionataPVO>\n" +
                "    <fondoPensione>FIDEURAM VALORE</fondoPensione>\n" +
                "    <prospettoLiquidativo>Prestazione pensionistica nella misura del 100%</prospettoLiquidativo>\n" +
                "    <numeroPosizione>70014334610</numeroPosizione>\n" +
                "    <aderente>CARLONE ALFONSO</aderente>\n" +
                "    <tipologiaAderente>Nuovo iscritto</tipologiaAderente>\n" +
                "    <dataPrimaIscrizioneFormePensionisticheComplementari>2002-01-01T00:00:00+01:00</dataPrimaIscrizioneFormePensionisticheComplementari>\n" +
                "    <dataAdesioneFondo>2013-11-05T00:00:00+01:00</dataAdesioneFondo>\n" +
                "    <totaleContributiVersatiNettiFondoGenerale>56138.53</totaleContributiVersatiNettiFondoGenerale>\n" +
                "    <numeroQuote>3564.521</numeroQuote>\n" +
                "    <valoreQuota>17.857</valoreQuota>\n" +
                "    <controvalore>63651.65</controvalore>\n" +
                "    <valoreLordoPrestazionePensionistica100>63651.65</valoreLordoPrestazionePensionistica100>\n" +
                "    <valoreLordoPrestazionePensionistica50>31825.82</valoreLordoPrestazionePensionistica50>\n" +
                "    <renditaImmediata100>\n" +
                "        <ammontarePosizioneIndividualeMaturata>63651.65</ammontarePosizioneIndividualeMaturata>\n" +
                "        <coefficienteRenditaFrazionata>18.0511</coefficienteRenditaFrazionata>\n" +
                "        <rateazioneAnnua>3526.19</rateazioneAnnua>\n" +
                "        <rateazioneMensile>3432.37</rateazioneMensile>\n" +
                "        <rateazioneSemestrale>3438.68</rateazioneSemestrale>\n" +
                "        <rateazioneTrimestrale>3435.52</rateazioneTrimestrale>\n" +
                "    </renditaImmediata100>\n" +
                "    <renditaImmediata50>\n" +
                "        <ammontarePosizioneIndividualeMaturata>31825.82</ammontarePosizioneIndividualeMaturata>\n" +
                "        <coefficienteRenditaFrazionata>18.0511</coefficienteRenditaFrazionata>\n" +
                "        <rateazioneAnnua>1763.1</rateazioneAnnua>\n" +
                "        <rateazioneMensile>1716.19</rateazioneMensile>\n" +
                "        <rateazioneSemestrale>1719.34</rateazioneSemestrale>\n" +
                "        <rateazioneTrimestrale>1717.76</rateazioneTrimestrale>\n" +
                "    </renditaImmediata50>\n" +
                "    <renditaGarantita5Anni>\n" +
                "        <ammontarePosizioneIndividualeMaturata>63651.65</ammontarePosizioneIndividualeMaturata>\n" +
                "        <coefficienteRenditaFrazionata>18.657991</coefficienteRenditaFrazionata>\n" +
                "        <rateazioneAnnua>3411.5</rateazioneAnnua>\n" +
                "        <rateazioneMensile>3402.2</rateazioneMensile>\n" +
                "        <rateazioneSemestrale>3408.39</rateazioneSemestrale>\n" +
                "        <rateazioneTrimestrale>3405.29</rateazioneTrimestrale>\n" +
                "    </renditaGarantita5Anni>\n" +
                "    <renditaGarantita10Anni>\n" +
                "        <ammontarePosizioneIndividualeMaturata>63651.65</ammontarePosizioneIndividualeMaturata>\n" +
                "        <coefficienteRenditaFrazionata>19.255974</coefficienteRenditaFrazionata>\n" +
                "        <rateazioneAnnua>3305.55</rateazioneAnnua>\n" +
                "        <rateazioneMensile>3296.82</rateazioneMensile>\n" +
                "        <rateazioneSemestrale>3302.64</rateazioneSemestrale>\n" +
                "        <rateazioneTrimestrale>3299.73</rateazioneTrimestrale>\n" +
                "    </renditaGarantita10Anni>\n" +
                "    <ammontarePosizioneIndividualeMaturata>63651.65</ammontarePosizioneIndividualeMaturata>\n" +
                "    <riscattabilita100>true</riscattabilita100>\n" +
                "    <tabellaDemografica>A62_0</tabellaDemografica>\n" +
                "    <dataNavRiferimento>2019-04-30T00:00:00+02:00</dataNavRiferimento>\n" +
                "    <dataElaborazione>2019-11-07T17:21:17.031+01:00</dataElaborazione>\n" +
                "    <premioAggiuntivoRaggiungimento>12260.95454285715</premioAggiuntivoRaggiungimento>\n" +
                "    <renditaAnnuaPostVersamentoPremioAggiuntivo>4205.428175726529</renditaAnnuaPostVersamentoPremioAggiuntivo>\n" +
                "    <etaCalcolo>73</etaCalcolo>\n" +
                "</dettaglioCoefficienteRenditaFrazionataPVO>";
    }


    
    
    
    
    
    
    public static String getXmlErrore(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><VariazioneBeneficiario><dataRichiesta>2016-09-13T10:29:22.902+02:00</dataRichiesta><sollecito>false</sollecito><polizza><numeroID>70008233803</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>REBUSCO</cognome><nome>STEFANO</nome><cf>RBSSFN36S12H717I</cf><indirizzo><via>VIA DEGLI ALPINI 9</via><cap>25080</cap><comune>MANERBA DEL GARDA</comune><provincia>BS</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1936-11-12T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>REBUSCO</cognome><nome>STEFANO</nome><cf>RBSSFN36S12H717I</cf><indirizzo><via>VIA DEGLI ALPINI 9</via><cap>25080</cap><comune>MANERBA DEL GARDA</comune><provincia>BS</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1936-11-12T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>GOFFI</cognome><nome>DAMIANO</nome><cf>GFFDMN71L14C618G</cf><indirizzo><via>VIA SAN ZENO 99 </via><cap>25124</cap><comune>BRESCIA </comune><provincia>BS</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1971-07-14T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa>Modulo Variazione Beneficiario (Mod. 001702)</docIntgrativa><docIntgrativa>Tipo relazione che intercorre tra contraente e beneficiario designato</docIntgrativa><docIntgrativa>Documento identità del beneficiario designato</docIntgrativa></VariazioneBeneficiario>";
        }


    public static String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><dettaglioCoefficienteRenditaFrazionataPVO> <fondoPensione>FIDEURAM MULTICOMPARTO</fondoPensione> <prospettoLiquidativo>Prestazione pensionistica nella misura del 100%</prospettoLiquidativo> <numeroPosizione>70002044712</numeroPosizione> <aderente>ZANIBONI ANDREA</aderente> <tipologiaAderente>Nuovo iscritto</tipologiaAderente> <dataPrimaIscrizioneFormePensionisticheComplementari>2008-05-13T00:00:00+02:00</dataPrimaIscrizioneFormePensionisticheComplementari> <dataAdesioneFondo>2008-05-13T00:00:00+02:00</dataAdesioneFondo> <totaleContributiVersatiNettiFondoGenerale>41385.99</totaleContributiVersatiNettiFondoGenerale> <numeroQuote>3333.16</numeroQuote> <controvalore>53256.48</controvalore> <valoreLordoPrestazionePensionistica100>53256.48</valoreLordoPrestazionePensionistica100> <valoreLordoPrestazionePensionistica50>26628.24</valoreLordoPrestazionePensionistica50> <renditaImmediata100> <ammontarePosizioneIndividualeMaturata>53256.48</ammontarePosizioneIndividualeMaturata> <coefficienteRenditaFrazionata>33.6395</coefficienteRenditaFrazionata> <rateazioneAnnua>1583.15</rateazioneAnnua> <rateazioneMensile>1561.87</rateazioneMensile> <rateazioneSemestrale>1571.47</rateazioneSemestrale> <rateazioneTrimestrale>1565.7</rateazioneTrimestrale> </renditaImmediata100> <renditaImmediata50> <ammontarePosizioneIndividualeMaturata>26628.24</ammontarePosizioneIndividualeMaturata> <coefficienteRenditaFrazionata>33.6395</coefficienteRenditaFrazionata> <rateazioneAnnua>791.58</rateazioneAnnua> <rateazioneMensile>780.94</rateazioneMensile> <rateazioneSemestrale>785.74</rateazioneSemestrale> <rateazioneTrimestrale>782.85</rateazioneTrimestrale> </renditaImmediata50> <renditaGarantita5Anni> <ammontarePosizioneIndividualeMaturata>53256.48</ammontarePosizioneIndividualeMaturata> <coefficienteRenditaFrazionata>0.0</coefficienteRenditaFrazionata> <rateazioneAnnua>1581.53</rateazioneAnnua> <rateazioneMensile>1559.49</rateazioneMensile> <rateazioneSemestrale>1569.43</rateazioneSemestrale> <rateazioneTrimestrale>1563.45</rateazioneTrimestrale> </renditaGarantita5Anni> <renditaGarantita10Anni> <ammontarePosizioneIndividualeMaturata>53256.48</ammontarePosizioneIndividualeMaturata> <coefficienteRenditaFrazionata>0.0</coefficienteRenditaFrazionata> <rateazioneAnnua>1576.15</rateazioneAnnua> <rateazioneMensile>1554.66</rateazioneMensile> <rateazioneSemestrale>1564.36</rateazioneSemestrale> <rateazioneTrimestrale>1558.52</rateazioneTrimestrale> </renditaGarantita10Anni> <ammontarePosizioneIndividualeMaturata>53256.48</ammontarePosizioneIndividualeMaturata> <riscattabilita100>true</riscattabilita100> <listaComparti> <controvalore>472.69</controvalore> <dataNav>2016-04-30T00:00:00+02:00</dataNav> <descrizioneComparto>FIDEURAM CRESCITA</descrizioneComparto> <numeroQuote>32.81900</numeroQuote> <valoreNav>14.40300</valoreNav> </listaComparti> <listaComparti> <controvalore>52543.38</controvalore> <dataNav>2016-04-30T00:00:00+02:00</dataNav> <descrizioneComparto>FIDEURAM VALORE</descrizioneComparto> <numeroQuote>3287.45400</numeroQuote> <valoreNav>15.98300</valoreNav> </listaComparti> <listaComparti> <controvalore>240.41</controvalore> <dataNav>2016-04-30T00:00:00+02:00</dataNav> <descrizioneComparto>FIDEURAM EQUILIBRIO</descrizioneComparto> <numeroQuote>12.88700</numeroQuote> <valoreNav>18.65500</valoreNav> </listaComparti> </dettaglioCoefficienteRenditaFrazionataPVO>";
    }

    public static String getXmlAnomalo()
    {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><VariazioneBeneficiario><dataRichiesta>2016-11-04T16:24:49.020+01:00</dataRichiesta><sollecito>false</sollecito><polizza><numeroID>70020991802</numeroID><contraente><titolo>Gentile Signora</titolo><cognome>LUCA</cognome><nome>MONICA VERONICA LOREDANA</nome><cf>LCUMCV65A65H501Q</cf><indirizzo><via>VIA TRIPOLI 115</via><cap>95021</cap><comune>ACI CASTELLO</comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1965-01-25T00:00:00+01:00</dataNascita><sesso>F</sesso></contraente><assicurato><titolo>Gentile Signora</titolo><cognome>LUCA</cognome><nome>MONICA VERONICA LOREDANA</nome><cf>LCUMCV65A65H501Q</cf><indirizzo><via>VIA TRIPOLI 115</via><cap>95021</cap><comune>ACI CASTELLO</comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1965-01-25T00:00:00+01:00</dataNascita><sesso>F</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>SCORNAVACCA</cognome><nome>PAOLO DOMENICO</nome><cf>SCRPDM66D03C351B</cf><indirizzo><via>CSO ITALIA 218 </via><cap>95129</cap><comune>CATANIA </comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1966-04-03T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa>Modulo Variazione Beneficiario (Mod. 001702)</docIntgrativa><docIntgrativa>Codice fiscale del beneficiario designato</docIntgrativa><docIntgrativa>Documento identità del beneficiario designato</docIntgrativa></VariazioneBeneficiario>";
    }
}
