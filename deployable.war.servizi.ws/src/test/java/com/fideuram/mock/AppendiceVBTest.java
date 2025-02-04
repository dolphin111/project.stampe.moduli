package com.fideuram.mock;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;

/**
 * User: V801068
 * Date: 21/05/15
 * Time: 17.58
 */
public class AppendiceVBTest extends TestCase {

    public static Test suite() {
        return new TestSuite(AppendiceVBTest.class );
    }

    public void testGenerazioneDocumento()  throws Exception  {
        Stampe s=new Stampe();

        //byte[]   b  =   s.getPdfFromXml(getXml(),"1022");
        //StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "AppendiceVariazioneBeneficiario.pdf");
        
        byte[]   b  =   s.getOdtFromXml(getXml(),"1022");
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "AppendiceVariazioneBeneficiario.odt");
        
        System.out.println("fine");
    }

    private String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<AppendiceVB>" +
                "<dataRichiesta>2015-05-21T15:57:14.628+02:00</dataRichiesta>" +
                "<sollecito>false</sollecito>" +
                "<tipoOperazione>VBBA</tipoOperazione>" +
                "<causale>" +
                "<causale>0</causale>" +
                "</causale>" +
                "<polizza>" +
                "<numeroID>7520043</numeroID>" +
                "<decorrenza>2001-04-05T00:00:00+02:00</decorrenza>" +
                "<emissione>2001-04-04T00:00:00+02:00</emissione>" +
                "<contraente>" +
                    "<titolo>Gentile Signora</titolo>" +
                    "<cognome>RUSSO</cognome>" +
                    "<nome>ANTONIA</nome>" +
                    "<cf>RSSNTN34D66A064D</cf>" +
                    "<indirizzo><via>VIA GARIGLIANO 5</via><cap>80016</cap><comune>MARANO DI NAPOLI</comune><provincia>NA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1934-04-26T00:00:00+01:00</dataNascita>"
                    + "<sesso>F</sesso>"
                    + "</contraente>" +
                "<assicurato><titolo>Gentile Signor</titolo><cognome>RUSSO</cognome><nome>MATTEO</nome><cf>RSSMTT00S09F839J</cf><indirizzo><via>VIA GARIGLIANO 5</via><cap>80016</cap><comune>MARANO DI NAPOLI</comune><provincia>NA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>2000-11-09T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato>" +
                "<pb><titolo>Gentile Signor</titolo><cognome>MARUCCIA</cognome><nome>ANTONIO</nome><cf>MRCNTN67B15F839I</cf><indirizzo><via>VIA G M BOSCO ANG VIA ROSSELLI                    </via><cap>81100</cap><comune>CASERTA                  </comune><provincia>CE</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1967-02-15T00:00:00+01:00</dataNascita><sesso>M</sesso></pb>" +
                "</polizza>" +
                "<beneficiari>" +
                    "<isGenericoCV>false</isGenericoCV>" +
                    "<descrizioneCV>eredi legittimi</descrizioneCV>" +
                    "<isGenericoCM>false</isGenericoCM>" +
                    "<descrizioneCM>eredi legittimi</descrizioneCM>" +
                    "<beneficiarioVita>" +
                    	"<cognome>BRUNI</cognome>" +
                    	"<nome>ALESSANDRO</nome>" +
                    	"<cf>RSSNTN34D66A064D</cf>" +
                    	"<percentualeBeneficiario>50</percentualeBeneficiario>" +
                    "</beneficiarioVita>" +
                    "<beneficiarioVita>" +
                        "<cognome>BRUNI 2</cognome>" +
                        "<nome>ALESSANDRO 2</nome>" +
                        "<cf>RSSNTN34D66A064D-1</cf>" +
                        "<percentualeBeneficiario>52</percentualeBeneficiario>" +
                    "</beneficiarioVita>" +
	                "<beneficiarioMorte>" +
	                    "<cognome>BRUNI</cognome>" +
	                    "<nome>ALESSANDRO</nome>" +
	                    "<cf>RSSNTN34D66A064D</cf>" +
	                    "<percentualeBeneficiario>50</percentualeBeneficiario>" +
	                "</beneficiarioMorte>" +
                    "<beneficiarioMorte>" +
                        "<cognome>BRUNI 4</cognome>" +
                        "<nome>ALESSANDRO 4 </nome>" +
                        "<cf>RSSNTN34D66A064D-4</cf>" +
                        "<percentualeBeneficiario>54</percentualeBeneficiario>" +
                    "</beneficiarioMorte>" +
                "</beneficiari>" +
                "<dataEffettoVB>2015-05-21T00:00:00+02:00</dataEffettoVB>" +
                "</AppendiceVB>";
    }
}


