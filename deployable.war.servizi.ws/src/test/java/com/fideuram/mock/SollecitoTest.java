package com.fideuram.mock;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;

/**
 * Created by V801068 on 15/05/14.
 */
public class SollecitoTest extends TestCase {

    public static Test suite() {
        return new TestSuite(SollecitoTest.class );
    }

    public void testGenerazioneDocumento()  throws Exception  {
        Stampe s=new Stampe();

        byte[]   b  =   s.getPdfFromXml(getMock(),"1021");
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "SollecitoVariazioneBeneficiario.pdf");
    }

    private String getMock(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<SollecitoVB>\n" +
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
                "            <nome>Contraente</nome>\n" +
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
                "            <nome>Assicurato</nome>\n" +
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
                "            <nome>PB</nome>\n" +
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
                "    <dataSollecito>2014-05-15T12:20:08.011+02:00</dataSollecito>\n" +
                "</SollecitoVB>";
    }


}
