package ws.stampe.cambiocontraenza;

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
 * Created by V801068 on 21/05/14.
 */
public class CambioContraenzaTest extends TestCase {

    public static Test suite() {
        return new TestSuite(CambioContraenzaTest.class );
    }



    public void testDestinatarioContraente()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("1010");
        trasportBean.setXml(getDestinatarioContraente());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "CC1010DestinatarioContraente.pdf");
        } catch (Exception e) {
            LoggingUtils.error(e);
            assert false;
        }
    }

    public void testDestinatarioAssicurato()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("1010");
        trasportBean.setXml(getDestinatarioAssicurato());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "CC1010DestinatarioAssicurato.pdf");
        } catch (Exception e) {
            LoggingUtils.error(e);
            assert false;
        }
    }

    public void testSollecito()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("1011");
        trasportBean.setXml(getTestErrore());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "CC1011SollecitoAlina.pdf");
        } catch (Exception e) {
            LoggingUtils.error(e);
            assert false;
        }
    }

    public void testErrore()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("1010");
        trasportBean.setXml(getTestErrore());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "CambioContraenza.pdf");
        } catch (Exception e) {
            LoggingUtils.error(e);
            assert false;
        }
    }

    private String getDestinatarioAssicurato(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2016-02-04T13:09:16.929+01:00</dataRichiesta><sollecito>false</sollecito><causale><causale>1</causale></causale><polizza><numeroID>70010868900</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>UGOLINI</cognome><nome>EROS</nome><cf>GLNRSE33S16I259A</cf><indirizzo><via>VIA PROVOLO 26</via><cap>37123</cap><comune>VERONA</comune><provincia>VR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1933-11-16T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>UGOLINI</cognome><nome>SAVERIO</nome><cf>GLNSVR60L23L781Z</cf><indirizzo><via>VIA PROVOLO 26</via><cap>37123</cap><comune>VERONA</comune><provincia>VR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1960-07-23T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>BONOMINI</cognome><nome>SERGIO</nome><cf>BNMSRG61L31B296M</cf><indirizzo><via>VCLO VOLTO CITTADELLA 1/A                         </via><cap>37122</cap><comune>VERONA                   </comune><provincia>VR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1970-01-01T06:26:50.730+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa>Aggiornamento Adeguata Verifica mod.022088/200719-12.2014 – Persona Fisica</docIntgrativa><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></CambioContraenza>";
    }

    private String getTestAlina(){
        //return  "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SollecitoCC><dataRichiesta>2016-02-03T16:20:38.943+01:00</dataRichiesta><sollecito>true</sollecito><causale><causale>1</causale></causale><polizza><numeroID>70010868900</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>UGOLINI</cognome><nome>EROS</nome><cf>GLNRSE33S16I259A</cf><indirizzo><via>VIA PROVOLO 26</via><cap>37123</cap><comune>VERONA</comune><provincia>VR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1933-11-16T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>UGOLINI</cognome><nome>SAVERIO</nome><cf>GLNSVR60L23L781Z</cf><indirizzo><via>Via cavour 45</via><cap>00100</cap><comune>Roma</comune><provincia>RM</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1960-07-23T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>BONOMINI</cognome><nome>SERGIO</nome><cf>BNMSRG61L31B296M</cf><indirizzo><via>VCLO VOLTO CITTADELLA 1/A                         </via><cap>37122</cap><comune>VERONA                   </comune><provincia>VR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1970-01-01T06:26:50.730+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa> Adeguata Verifica mod.022092/200718-12.2014  - Persona Giuridica</docIntgrativa><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></SollecitoCC>";
        return  "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2016-02-05T15:01:21.269+01:00</dataRichiesta><sollecito>false</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7041140</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>LANDRISCINA</cognome><nome>GIUSEPPE</nome><cf>LNDGPP58L05L219U</cf><indirizzo><via>VIA BALDI 3/E</via><cap>10098</cap><comune>RIVOLI</comune><provincia>TO</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1958-07-05T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>LANDRISCINA</cognome><nome>GIUSEPPE</nome><cf>LNDGPP58L05L219U</cf><indirizzo><via>VIA BALDI 3/E</via><cap>10098</cap><comune>RIVOLI</comune><provincia>TO</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1958-07-05T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>TREVISIOL</cognome><nome>TEDDI</nome><cf>TRVTDD55A05L219K</cf><indirizzo><via>CSO STATI UNITI 29 PAL LA MARMORA                 </via><cap>10129</cap><comune>TORINO                   </comune><provincia>TO</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1955-01-05T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa> Modulo di Autocertificazione FATCA </docIntgrativa><passaggioAutomaticoContraenza>true</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></CambioContraenza>";
    }

    private String getTestErrore(){
        //return  "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SollecitoCC><dataRichiesta>2016-03-03T13:00:00+01:00</dataRichiesta><sollecito>true</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7444305</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>ANGIULLI</cognome><nome>ALFREDO</nome><cf>NGLLRD41D21E995O</cf><indirizzo><via>VIA C.BATTISTI 56</via><cap>70026</cap><comune>MODUGNO</comune><provincia>BA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1941-04-21T00:00:00+02:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>ANGIULLI</cognome><nome>MASSIMO</nome><cf>NGLMSM67R26A662J</cf><indirizzo><via>VIA LATINA 1</via><cap>70026</cap><comune>MODUGNO</comune><provincia>BA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1967-10-26T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Spett.le</titolo></pb></polizza><docIntgrativa> Modulo Cambio Contraenza</docIntgrativa><docIntgrativa>Integrazione dati di  Adeguata Verifica mod.022090/200720-12.2014 relativa al contraente in entrata – Persona Fisica (mini qav)</docIntgrativa><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></SollecitoCC>";
        //return  "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2016-02-05T15:01:21.269+01:00</dataRichiesta><sollecito>false</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7041140</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>LANDRISCINA</cognome><nome>GIUSEPPE</nome><cf>LNDGPP58L05L219U</cf><indirizzo><via>VIA BALDI 3/E</via><cap>10098</cap><comune>RIVOLI</comune><provincia>TO</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1958-07-05T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>LANDRISCINA</cognome><nome>GIUSEPPE</nome><cf>LNDGPP58L05L219U</cf><indirizzo><via>VIA BALDI 3/E</via><cap>10098</cap><comune>RIVOLI</comune><provincia>TO</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1958-07-05T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>TREVISIOL</cognome><nome>TEDDI</nome><cf>TRVTDD55A05L219K</cf><indirizzo><via>CSO STATI UNITI 29 PAL LA MARMORA                 </via><cap>10129</cap><comune>TORINO                   </comune><provincia>TO</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1955-01-05T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa> Modulo di Autocertificazione FATCA </docIntgrativa><passaggioAutomaticoContraenza>true</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></CambioContraenza>";
        return  "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2016-10-03T16:56:14.287+02:00</dataRichiesta><sollecito>false</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7041958</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>MOLINARO</cognome><nome>ANTONIO</nome><cf>MLNNTN27B17L435Z</cf><indirizzo><via>VIA ALFREDO POGGIOLINI 9</via><cap>19125</cap><comune>LA SPEZIA</comune><provincia>SP</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1927-02-17T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>MOLINARO</cognome><nome>ANDREA</nome><cf>MLNNDR65P14E463P</cf><indirizzo><via>VIA ALFREDO POGGIOLINI 9</via><cap>19125</cap><comune>LA SPEZIA</comune><provincia>SP</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1965-09-14T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Spett.le</titolo></pb></polizza><docIntgrativa> Modulo Cambio Contraenza</docIntgrativa><docIntgrativa> Atto notorio con elenco degli eredi e loro generalità</docIntgrativa><docIntgrativa> Designazione nuovo contraente da parte degli eredi e copia documento d’identità nuovo contraente</docIntgrativa><docIntgrativa> Modulo di Autocertificazione FATCA </docIntgrativa><docIntgrativa> Documento d’identità nuovo contraente</docIntgrativa><docIntgrativa>Integrazione dati di Adeguata Verifica mod.022090/200720-12.2014 relativa al contraente in entrata – Persona Fisica (mini qav)</docIntgrativa><passaggioAutomaticoContraenza>true</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></CambioContraenza>";
    }

    private String getDestinatarioContraente(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<CambioContraenza>\n" +
                "    <dataRichiesta>2014-05-21T16:20:40.088+02:00</dataRichiesta>\n" +
                "    <sollecito>false</sollecito>\n" +
                "    <causale>\n" +
                "        <causale>0</causale>\n" +
                "    </causale>\n" +
                "    <polizza>\n" +
                "        <numeroID>12434534</numeroID>\n" +
                "        <contraente>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>Cruijff</cognome>\n" +
                "            <nome>Joahn</nome>\n" +
                "            <indirizzo>\n" +
                "                <via>Via della navicella 32</via>\n" +
                "                <cap>00100</cap>\n" +
                "                <comune>Roma</comune>\n" +
                "                <provincia>RM</provincia>\n" +
                "            </indirizzo>\n" +
                "        </contraente>\n" +
                "        <assicurato>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>Cruijff</cognome>\n" +
                "            <nome>Joahn</nome>\n" +
                "            <indirizzo>\n" +
                "                <via>Via della navicella 32</via>\n" +
                "                <cap>00100</cap>\n" +
                "                <comune>Roma</comune>\n" +
                "                <provincia>RM</provincia>\n" +
                "            </indirizzo>\n" +
                "        </assicurato>\n" +
                "        <pb>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>Neckens</cognome>\n" +
                "            <nome>Joahn</nome>\n" +
                "            <indirizzo>\n" +
                "                <via>Via della navicella 32</via>\n" +
                "                <cap>00100</cap>\n" +
                "                <comune>Roma</comune>\n" +
                "                <provincia>RM</provincia>\n" +
                "            </indirizzo>\n" +
                "        </pb>\n" +
                "    </polizza>\n" +
                "    <docIntgrativa>Riga Esempio 11</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 12</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 13</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 14</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 15</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 16</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 17</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 18</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 19</docIntgrativa>\n" +
                "</CambioContraenza>";
    }
}
