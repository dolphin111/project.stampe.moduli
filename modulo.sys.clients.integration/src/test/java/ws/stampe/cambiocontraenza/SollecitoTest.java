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
 * Created by V801068 on 15/05/14.
 */
public class SollecitoTest  extends TestCase {

    public static Test suite() {
        return new TestSuite(SollecitoTest.class );
    }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("1011");
        trasportBean.setXml(getMock());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "SollecitoCambioContraenza.pdf");
        } catch (Exception e) {
            LoggingUtils.error(e);
            assert false;
        }
    }
    private String getMock(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<SollecitoCC>\n" +
                "    <dataRichiesta>2014-05-15T12:20:08.011+02:00</dataRichiesta>\n" +
                "    <sollecito>true</sollecito>\n" +
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
                "    <docIntgrativa>Riga Esempio 1</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 2</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 3</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 4</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 5</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 6</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 7</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 8</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 9</docIntgrativa>\n" +
                "    <dataSollecito>2014-05-15T12:20:08.011+02:00</dataSollecito>\n" +
                "</SollecitoCC>";
    }


}
