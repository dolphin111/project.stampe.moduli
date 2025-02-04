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
public class VariazioneBeneficiarioTest {
    public static void main(String args[]) throws Exception {
        Stampe s=new Stampe();

        byte[]   b  =   s.getPdfFromXml(getXmlAnomalo(),"1020");
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "VariazioneBeneficiario.pdf");
    }

    public static String getXmlErrore(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><VariazioneBeneficiario><dataRichiesta>2016-09-13T10:29:22.902+02:00</dataRichiesta><sollecito>false</sollecito><polizza><numeroID>70008233803</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>REBUSCO</cognome><nome>STEFANO</nome><cf>RBSSFN36S12H717I</cf><indirizzo><via>VIA DEGLI ALPINI 9</via><cap>25080</cap><comune>MANERBA DEL GARDA</comune><provincia>BS</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1936-11-12T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>REBUSCO</cognome><nome>STEFANO</nome><cf>RBSSFN36S12H717I</cf><indirizzo><via>VIA DEGLI ALPINI 9</via><cap>25080</cap><comune>MANERBA DEL GARDA</comune><provincia>BS</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1936-11-12T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>GOFFI</cognome><nome>DAMIANO</nome><cf>GFFDMN71L14C618G</cf><indirizzo><via>VIA SAN ZENO 99 </via><cap>25124</cap><comune>BRESCIA </comune><provincia>BS</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1971-07-14T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa>Modulo Variazione Beneficiario (Mod. 001702)</docIntgrativa><docIntgrativa>Tipo relazione che intercorre tra contraente e beneficiario designato</docIntgrativa><docIntgrativa>Documento identità del beneficiario designato</docIntgrativa></VariazioneBeneficiario>";
        }

    public static String getXml2(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +
                "<VariazioneBeneficiario>" +
                "   <dataRichiesta>2016-08-11T09:17:32.109+02:00</dataRichiesta>" +
                "   <sollecito>false</sollecito>" +
                "   <polizza>" +
                "   <numeroID>70016396111</numeroID>" +
                "   <contraente>" +
                "       <titolo>Gentile Signor</titolo>" +
                "       <cognome>TORCIANTI</cognome><nome>MARZIO</nome><cf>TRCMRZ53C04A271T</cf><indirizzo><via>VIA ABBADIA 154</via><cap>60027</cap><comune>OSIMO STAZIONE - OSIMO</comune><provincia>AN</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1953-03-04T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>TORCIANTI</cognome><nome>MARZIO</nome><cf>TRCMRZ53C04A271T</cf><indirizzo><via>VIA ABBADIA 154</via><cap>60027</cap><comune>OSIMO STAZIONE - OSIMO</comune><provincia>AN</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1953-03-04T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>GAGGI</cognome><nome>LUIGI</nome><cf>GGGLGU67B27D488G</cf><indirizzo><via>PZLE DEGLI INNOCENTI 15                           </via><cap>61121</cap><comune>PESARO                   </comune><provincia>PU</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1967-02-27T00:00:00+01:00</dataNascita><sesso>M</sesso></pb>" +
                "   </polizza>" +
                "   <docIntgrativa>Tipo relazione del beneficiario</docIntgrativa>" +
                "</VariazioneBeneficiario>";
    }

    public static String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<VariazioneBeneficiario>\n" +
                "    <dataRichiesta>2014-05-21T16:20:40.088+02:00</dataRichiesta> \n" +
                "    <sollecito>false</sollecito>\n" +
                "    <causale>\n" +
                "        <causale>0</causale>\n" +
                "    </causale>\n" +
                "    <polizza>\n" +
                "        <numeroID>12434534</numeroID>\n" +
                "        <contraente>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>Cruijff VB</cognome>\n" +
                "            <nome>Joahn</nome>\n" +
                "            <indirizzo>\n" +
                "                <via>Via della navicella 75</via>\n" +
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
                "    <docIntgrativa>Riga Esempio 11</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 12</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 13</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 14</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 15</docIntgrativa>\n" +
                "    <docIntgrativa>Riga Esempio 16</docIntgrativa>\n" +
                "</VariazioneBeneficiario>";
    }

    public static String getXmlAnomalo()
    {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><VariazioneBeneficiario><dataRichiesta>2016-11-04T16:24:49.020+01:00</dataRichiesta><sollecito>false</sollecito><polizza><numeroID>70020991802</numeroID><contraente><titolo>Gentile Signora</titolo><cognome>LUCA</cognome><nome>MONICA VERONICA LOREDANA</nome><cf>LCUMCV65A65H501Q</cf><indirizzo><via>VIA TRIPOLI 115</via><cap>95021</cap><comune>ACI CASTELLO</comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1965-01-25T00:00:00+01:00</dataNascita><sesso>F</sesso></contraente><assicurato><titolo>Gentile Signora</titolo><cognome>LUCA</cognome><nome>MONICA VERONICA LOREDANA</nome><cf>LCUMCV65A65H501Q</cf><indirizzo><via>VIA TRIPOLI 115</via><cap>95021</cap><comune>ACI CASTELLO</comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1965-01-25T00:00:00+01:00</dataNascita><sesso>F</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>SCORNAVACCA</cognome><nome>PAOLO DOMENICO</nome><cf>SCRPDM66D03C351B</cf><indirizzo><via>CSO ITALIA 218 </via><cap>95129</cap><comune>CATANIA </comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1966-04-03T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa>Modulo Variazione Beneficiario (Mod. 001702)</docIntgrativa><docIntgrativa>Codice fiscale del beneficiario designato</docIntgrativa><docIntgrativa>Documento identità del beneficiario designato</docIntgrativa></VariazioneBeneficiario>";
    }
}
