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
public class SollecitoDocumentiRipensamentoRenditaTest {
    public static void main(String args[]) throws Exception {

    	System.out.println(System.currentTimeMillis());
        Stampe s=new Stampe();

        byte[]   b  =   s.getPdfFromXml(getXml(),"sollecitoDocumentiRipensamentoRendita");
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "SollecitoRR.pdf");
        System.out.println("Fine");
    }


    public static String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<SollecitoDocumentiRipensamentoRendita>\n" +
                "    <dataLettera>03/09/2019</dataLettera>\n" +
                "    <numeroPolizza>12345678901</numeroPolizza>\n" +
                "    <dataRichiesta>31/08/2019</dataRichiesta>\n" +
                "    <intestazione>Gentile Cliente</intestazione>\n" +
                "    <cognome>ROSSI</cognome>\n" +
                "    <nome>MARIO</nome>\n" +
                "    <via>VIA MILANO 18</via>\n" +
                "    <cap>00193</cap>\n" +
                "    <comune>ROMA</comune>\n" +
                "    <provincia>RM</provincia>\n" +
                "    <docSollecitato>Fotocopia del codice fiscale e di un documento d’identità in corso di validità del Contraente/Beneficiario</docSollecitato>\n" +
                "    <docSollecitato>Modulo di Richiesta di Riscatto/Opzione in Capitale</docSollecitato>\n" +
                "    <docSollecitato>Modulo Aggiornamento dati per l’adeguata verifica della clientela</docSollecitato>\n" +
                "    <docSollecitato>Certificato di esistenza in vita del Contraente/Beneficiario della Rendita</docSollecitato>\n" +
                "    <allegato1A>SI</allegato1A>\n" +
                "    <allegato2A>SI</allegato2A>\n" +
                "    <nota></nota>\n" +
                "</SollecitoDocumentiRipensamentoRendita>";

    }

    public static String getXml1()
    {
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><RichiestaDocumentiMancantiSinistro><dataRichiesta>2016-11-04T16:24:49.020+01:00</dataRichiesta><sollecito>false</sollecito><polizza><numeroID>70020991802</numeroID><contraente><titolo>Gentile Signora</titolo><cognome>LUCA</cognome><nome>MONICA VERONICA LOREDANA</nome><cf>LCUMCV65A65H501Q</cf><indirizzo><via>VIA TRIPOLI 115</via><cap>95021</cap><comune>ACI CASTELLO</comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1965-01-25T00:00:00+01:00</dataNascita><sesso>F</sesso></contraente><assicurato><titolo>Gentile Signora</titolo><cognome>LUCA</cognome><nome>MONICA VERONICA LOREDANA</nome><cf>LCUMCV65A65H501Q</cf><indirizzo><via>VIA TRIPOLI 115</via><cap>95021</cap><comune>ACI CASTELLO</comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1965-01-25T00:00:00+01:00</dataNascita><sesso>F</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>SCORNAVACCA</cognome><nome>PAOLO DOMENICO</nome><cf>SCRPDM66D03C351B</cf><indirizzo><via>CSO ITALIA 218 </via><cap>95129</cap><comune>CATANIA </comune><provincia>CT</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1966-04-03T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa>Modulo Variazione Beneficiario (Mod. 001702)</docIntgrativa><docIntgrativa>Codice fiscale del beneficiario designato</docIntgrativa><docIntgrativa>Documento identità del beneficiario designato</docIntgrativa></RichiestaDocumentiMancantiSinistro>";
    }
}
