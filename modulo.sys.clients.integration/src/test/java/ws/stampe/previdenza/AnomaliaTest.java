package ws.stampe.previdenza;

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
 * Date: 04/03/15
 * Time: 12.10
 */
public class AnomaliaTest  extends TestCase{

        /**
         * @return the suite of tests being tested
         */
    public static Test suite() {
        return new TestSuite(AnomaliaTest.class );
    }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("1116");
        trasportBean.setXml(anomalia());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            //StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "TestPrevidenza4.A_Anticipazione.pdf");
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "bo.pdf");
        } catch (Exception e) {
            LoggingUtils.error(e);
            assert false;
        }
    }

    private static String  anomalia(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<Previdenza>\n" +
                " <polizza>\n" +
                " <fondoPensione>\n" +
                " <dataCostituzione>1998-12-23T00:00:00+01:00</dataCostituzione>\n" +
                " <IBAN>IT66L0316301696100000047038</IBAN>\n" +
                " <cfPiva>10830461009</cfPiva>\n" +
                " <denominazione>Fondo Pensione Fideuram - Fondo Pensione Aperto</denominazione>\n" +
                " <iscrizioneAlbo>7</iscrizioneAlbo>\n" +
                " <gestioneAmmVa>FIDEURAM VITA SPA \n" +
                "VIA ENNIO QUIRINO VISCONTI 80 \n" +
                "00198 ROMA</gestioneAmmVa>\n" +
                " <tipologia>Fondo di tipo Finanziario</tipologia>\n" +
                " </fondoPensione>\n" +
                " <compagniaDiProvenienza>\n" +
                " <titolo>Spett.le</titolo>\n" +
                " <ragioneSociale>FONDOPOSTE</ragioneSociale>\n" +
                " <indirizzo>\n" +
                " <via>Viale Europa 190</via>\n" +
                " <cap>00144</cap>\n" +
                " <comune>ROMA</comune>\n" +
                " <provincia>RM</provincia>\n" +
                " <tel_fax></tel_fax>\n" +
                " <eMail></eMail>\n" +
                " </indirizzo>\n" +
                " </compagniaDiProvenienza>\n" +
                " <aderente>\n" +
                " <titolo>Spett.le</titolo>\n" +
                " <cognome>TARANTINO</cognome>\n" +
                " <nome>CRISTINA</nome>\n" +
                " <cf>TRNCST73C54I549N</cf>\n" +
                " </aderente>\n" +
                " </polizza>\n" +
                " <liquidazione>\n" +
                " <tipoLiquidazione>0</tipoLiquidazione>\n" +
                " <dataRichiesta>2015-12-20T00:00:00+01:00</dataRichiesta>\n" +
                " </liquidazione>\n" +
                " <documentazione>\n" +
                " <sollecito>true</sollecito>\n" +
                " </documentazione>\n" +
                "</Previdenza>";
    }

    public static String s1116(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<PrevidenzaTrasferimentoInput>\n" +
                " <richiesta>\n" +
                " <data>2013-05-11T00:00:00+02:00</data>\n" +
                " </richiesta>\n" +
                " <compagniaDiProvenienza>\n" +
                " <titolo>Spett.le</titolo>\n" +
                " <ragioneSociale>FONDO PENSIONE APERTO MILANO ASSICURAZIONI</ragioneSociale>\n" +
                " <indirizzo>\n" +
                " <via>Via Stalingrado 45</via>\n" +
                " <cap>40128</cap>\n" +
                " <comune>BOLOGNA</comune>\n" +
                " <provincia>BO</provincia>\n" +
                " <tel_fax></tel_fax>\n" +
                " <eMail></eMail>\n" +
                " </indirizzo>\n" +
                " </compagniaDiProvenienza>\n" +
                " <aderente>\n" +
                " <titolo>Spett.le</titolo>\n" +
                " <cognome>ZARPELLON</cognome>\n" +
                " <nome>MARIA PIA</nome>\n" +
                " <cf>ZRPMRP61E45A703O</cf>\n" +
                " </aderente>\n" +
                " <valuta>\n" +
                " <dataValuta>2014-11-11T00:00:00+01:00</dataValuta>\n" +
                " <valore>188.44</valore>\n" +
                " <valuta>â‚¬</valuta>\n" +
                " </valuta>\n" +
                "</PrevidenzaTrasferimentoInput>";
    }

    public static String getXmlMockBeneficiario(){
        return  "<CambioBenficiario>\n" +
                "    <sollecito>false</sollecito>\n" +
                "    <polizza>\n" +
                "        <numeroID>90008819301</numeroID>\n" +
                "        <aderente>\n" +
                "            <titolo>Gentile Signor</titolo>\n" +
                "            <cognome>MARCHESE</cognome>\n" +
                "            <nome>PAOLO</nome>\n" +
                "            <cf>MRCPLA48H29B006D</cf>\n" +
                "            <indirizzo>\n" +
                "                <via>VLE CITTA' DI PRATO 15</via>\n" +
                "                <cap>38051</cap>\n" +
                "                <comune>BORGO VALSUGANA</comune>\n" +
                "                <provincia>TN</provincia>\n" +
                "                <tel_fax></tel_fax>\n" +
                "                <eMail></eMail>\n" +
                "            </indirizzo>\n" +
                "            <dataNascita>1948-06-29T00:00:00+02:00</dataNascita>\n" +
                "            <sesso>M</sesso>\n" +
                "        </aderente>\n" +
                "        <pb>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>FIORITO</cognome>\n" +
                "            <nome>LUCA</nome>\n" +
                "            <cf>FRTLCU62D19L378O</cf>\n" +
                "            <indirizzo>\n" +
                "                <via>VIA AMBROSI 1                                     </via>\n" +
                "                <cap>38100</cap>\n" +
                "                <comune>TRENTO                   </comune>\n" +
                "                <provincia>TN</provincia>\n" +
                "                <tel_fax></tel_fax>\n" +
                "                <eMail>LFIORITO@bancafideuram.it</eMail>\n" +
                "            </indirizzo>\n" +
                "        </pb>\n" +
                "    </polizza>\n" +
                "    <dataDecorrenza>2015-06-22T00:00:00+02:00</dataDecorrenza>\n" +
                "    <nuoviBeneficiari>\n" +
                "        <titolo>Gentile Signor</titolo>\n" +
                "        <cognome>BIANCHI</cognome>\n" +
                "        <nome>PAOLO</nome>\n" +
                "        <cf>BCHPLO54D52A501B</cf>\n" +
                "        <dataNascita>1965-10-06T00:00:00+01:00</dataNascita>\n" +
                "        <sesso>M</sesso>\n" +
                "    </nuoviBeneficiari>\n" +
                "    <nuoviBeneficiari>\n" +
                "        <titolo>Gentile Signor</titolo>\n" +
                "        <cognome>BIANCHI</cognome>\n" +
                "        <nome>EMILIO</nome>\n" +
                "        <cf>BCHMLI74D51S501H</cf>\n" +
                "        <dataNascita>1965-10-06T00:00:00+01:00</dataNascita>\n" +
                "        <sesso>M</sesso>\n" +
                "    </nuoviBeneficiari>\n" +
                "</CambioBenficiario>\n";
    }

    public static String getXml(){
        return "<Previdenza>\n" +
                "    <polizza>\n" +
                "        <fondoPensione>\n" +
                "            <dataCostituzione>1998-12-23T00:00:00+01:00</dataCostituzione>\n" +
                "            <IBAN>IT66L0316301696100000047038</IBAN>\n" +
                "            <cfPiva>10830461009</cfPiva>\n" +
                "            <denominazione>Fondo Pensione Fideuram - Fondo Pensione Aperto</denominazione>\n" +
                "            <iscrizioneAlbo>7</iscrizioneAlbo>\n" +
                "            <gestioneAmmVa>FIDEURAM VITA SPA \n" +
                "VIA ENNIO QUIRINO VISCONTI 80 \n" +
                "00198 ROMA</gestioneAmmVa>\n" +
                "            <tipologia>Fondo di tipo Finanziario</tipologia>\n" +
                "        </fondoPensione>\n" +
                "        <compagniaDiProvenienza>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <ragioneSociale>FONDO PENSIONE APERTO IL MIO DOMANI</ragioneSociale>\n" +
                "            <indirizzo>\n" +
                "                <via>Viale Stelvio 55/57</via>\n" +
                "                <cap>20159</cap>\n" +
                "                <comune>MILANO</comune>\n" +
                "                <provincia>MI</provincia>\n" +
                "                <tel_fax></tel_fax>\n" +
                "                <eMail></eMail>\n" +
                "            </indirizzo>\n" +
                "        </compagniaDiProvenienza>\n" +
                "        <aderente>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>PICCININI</cognome>\n" +
                "            <nome>CHIARA JOLANDA</nome>\n" +
                "            <cf>PCCCRJ89S45Z604F</cf>\n" +
                "        </aderente>\n" +
                "    </polizza>\n" +
                "</Previdenza>";
    }
}
