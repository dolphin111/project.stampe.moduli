package ws.stampe.variazionebeneficiario;

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

 * User: V801068
 * Date: 07/08/15
 * Time: 11.59
 */
public class VariazioneBeneficiarioTest extends TestCase {

    public static Test suite() {
        return new TestSuite(VariazioneBeneficiarioTest.class );
    }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("1020");
        trasportBean.setXml(getXml());
        try {
        	Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1002);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "RichiestaVariazioneBeneficiario.pdf");
        } catch (Exception e) {
            LoggingUtils.error(e);
            assert false;
        }
    }

    private String getXml(){
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
