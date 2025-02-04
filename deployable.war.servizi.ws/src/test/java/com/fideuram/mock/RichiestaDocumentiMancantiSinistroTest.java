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
public class RichiestaDocumentiMancantiSinistroTest {
    public static void main(String args[]) throws Exception {
        Stampe s=new Stampe();

        byte[]   b  =   s.getPdfFromXml(getXml(),"1024");
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "RichiestaDocumentiMancantiSinistro.pdf");
        System.out.println("Fine");
    }

    public static String getXmlErrore(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><RichiestaDocumentiMancantiSinistro><dataRichiesta>2017-03-27T11:05:18.500+02:00</dataRichiesta><polizza><numeroID>70000397511</numeroID><assicurato><titolo>Gentile Signora</titolo><cognome>LEGATO                        </cognome><nome>ROSARIA                       </nome><cf>LGTRSR62E48L219B</cf><indirizzo><via>VIA CURTATONE 4</via><cap>10099</cap><comune>SAN MAURO TORINESE</comune><provincia>TO</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1962-05-08T00:00:00+01:00</dataNascita><sesso>F</sesso></assicurato><pb><titolo>Spett.le</titolo></pb></polizza><docIntgrativa><ID>L3</ID><descrizione>Dichiarazione sostitutiva di notorietà (prodotta secondo le modalita' sotto riportate)                                                                                                                  </descrizione></docIntgrativa><isDSN>false</isDSN></RichiestaDocumentiMancantiSinistro>";
        }


    public static String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<RichiestaDocumentiMancantiSinistro>\n" +
                "    <dataRichiesta>2014-05-21T16:20:40.088+02:00</dataRichiesta> \n" +
                "    <polizza>\n" +
                "        <numeroID>12434534</numeroID>\n" +
                "        <assicurato>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>Cruijff</cognome>\n" +
                "            <nome>Joahn</nome>\n" +
                "            <indirizzo>\n" +
                "                <via>Via della navicella 85</via>\n" +
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
                "                <via>Via della navicella 95</via>\n" +
                "                <cap>00100</cap>\n" +
                "                <comune>Roma</comune>\n" +
                "                <provincia>RM</provincia>\n" +
                "            </indirizzo>\n" +
                "        </pb>\n" +
                "    </polizza>\n" +
                "    <docIntgrativa><ID>101</ID><descrizione>Riga Esempio 11</descrizione></docIntgrativa>\n" +
                "    <docIntgrativa><ID>102</ID><descrizione>Riga Esempio 12</descrizione></docIntgrativa>\n" +
                "    <docIntgrativa><ID>103</ID><descrizione>Riga Esempio 12</descrizione></docIntgrativa>\n" +
//                "    <docIntgrativa><ID>L3</ID><descrizione>Dichiarazione sostitutiva di notorietà (prodotta secondo le modalita' sotto riportate)</descrizione></docIntgrativa>\n" +
                "</RichiestaDocumentiMancantiSinistro>";
    }

    public static String getXml1()
    {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><RichiestaDocumentiMancantiSinistro><dataRichiesta>2016-11-04T16:24:49.020+01:00</dataRichiesta><sollecito>false</sollecito><polizza><numeroID>70020991802</numeroID><contraente><titolo>Gentile Signora</titolo><cognome>LUCA</cognome><nome>MONICA VERONICA LOREDANA</nome><cf>LCUMCV65A65H501Q</cf><indirizzo><via>VIA TRIPOLI 115</via><cap>95021</cap><comune>ACI CASTELLO</comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1965-01-25T00:00:00+01:00</dataNascita><sesso>F</sesso></contraente><assicurato><titolo>Gentile Signora</titolo><cognome>LUCA</cognome><nome>MONICA VERONICA LOREDANA</nome><cf>LCUMCV65A65H501Q</cf><indirizzo><via>VIA TRIPOLI 115</via><cap>95021</cap><comune>ACI CASTELLO</comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1965-01-25T00:00:00+01:00</dataNascita><sesso>F</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>SCORNAVACCA</cognome><nome>PAOLO DOMENICO</nome><cf>SCRPDM66D03C351B</cf><indirizzo><via>CSO ITALIA 218 </via><cap>95129</cap><comune>CATANIA </comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1966-04-03T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa>Modulo Variazione Beneficiario (Mod. 001702)</docIntgrativa><docIntgrativa>Codice fiscale del beneficiario designato</docIntgrativa><docIntgrativa>Documento identità del beneficiario designato</docIntgrativa></RichiestaDocumentiMancantiSinistro>";
    }
}
