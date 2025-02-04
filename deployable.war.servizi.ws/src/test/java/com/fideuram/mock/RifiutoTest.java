package com.fideuram.mock;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * User: V801068
 * Date: 21/05/15
 * Time: 17.58
 */
public class RifiutoTest extends TestCase {

    public static Test suite() {
        return new TestSuite(RifiutoTest.class );
    }

    public void testGenerazioneDocumento()  throws Exception  {
        Stampe s=new Stampe();

        byte[]   b  =   s.getPdfFromXml(getXml(),"1023");
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "RifiutoVariazioneBeneficiario.pdf");
    }

    private String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<RifiutoVB>" +
                "<dataRichiesta>2015-05-21T15:57:14.628+02:00</dataRichiesta>" +
                "<vincolo>true</vincolo>" +
                "<codiceMotivoVincolo>02</codiceMotivoVincolo>" +
                "<pegno>true</pegno>" +
                "<bancaVincolataria>Banca Fideuram S.p.A. Filiale Capozona di Napoli</bancaVincolataria>" +
                "<fip80>false</fip80>" +
                "<polizzaScaduta>false</polizzaScaduta>" +
                "<beneficiarioAssicurato>false</beneficiarioAssicurato>" +
                "<conflittoInteressi>false</conflittoInteressi>" +
                "<prodottoNuovo>false</prodottoNuovo>" +
                "<dataVincolo>2015-05-21T15:57:14.628+02:00</dataVincolo>" +
                "<polizza>" +
                "<numeroID>7520043</numeroID>" +
                "<decorrenza>2001-04-05T00:00:00+02:00</decorrenza>" +
                "<contraente>" +
                    "<titolo>Gentile Signora</titolo>" +
                    "<cognome>RUSSO</cognome>" +
                    "<nome>ANTONIA</nome>" +
                    "<cf>RSSNTN34D66A064D</cf>" +
                    "<indirizzo><via>VIA GARIGLIANO 5</via><cap>80016</cap><comune>MARANO DI NAPOLI</comune><provincia>NA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1934-04-26T00:00:00+01:00</dataNascita><sesso>F</sesso></contraente>" +
                "<assicurato><titolo>Gentile Signor</titolo><cognome>RUSSO</cognome><nome>MATTEO</nome><cf>RSSMTT00S09F839J</cf><indirizzo><via>VIA GARIGLIANO 5</via><cap>80016</cap><comune>MARANO DI NAPOLI</comune><provincia>NA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>2000-11-09T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato>" +
                "<pb><titolo>Gentile Signor</titolo><cognome>MARUCCIA</cognome><nome>ANTONIO</nome><cf>MRCNTN67B15F839I</cf><indirizzo><via>VIA G M BOSCO ANG VIA ROSSELLI                    </via><cap>81100</cap><comune>CASERTA                  </comune><provincia>CE</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1967-02-15T00:00:00+01:00</dataNascita><sesso>M</sesso></pb>" +
                "</polizza>" +
                "<dataEffettoVB>2015-05-21T00:00:00+02:00</dataEffettoVB>" +
                "</RifiutoVB>";
    }
}


