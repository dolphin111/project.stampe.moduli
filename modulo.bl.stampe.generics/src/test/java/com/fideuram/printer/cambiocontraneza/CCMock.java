package com.fideuram.printer.cambiocontraneza;

import com.fideuram.jaxb.Converter;
import com.fideuram.printer.mock.ContrattoMock;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.contraenza.CambioContraenza;
import com.fideuram.stampe.modello.contraenza.CausaleCC;
import com.fideuram.stampe.modello.contraenza.Contratto;
import com.fideuram.stampe.modello.contraenza.SollecitoCC;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Date;

/**
 * Created by V801068 on 14/05/14.
 */
public class CCMock {


    public static SollecitoCC getBeanSollecitoMock(){
        SollecitoCC cc = new SollecitoCC();
        cc.setCausale(getCausale());
        cc.setDataRichiesta(new Date());
        cc.setDataSollecito(new Date());
        cc.setPolizza(ContrattoMock.getContratto());
        cc.addDocIntegrativa("Riga Esempio 1");
        cc.addDocIntegrativa("Riga Esempio 2");
        cc.addDocIntegrativa("Riga Esempio 3");
        cc.addDocIntegrativa("Riga Esempio 4");
        cc.addDocIntegrativa("Riga Esempio 5");
        cc.addDocIntegrativa("Riga Esempio 6");
        cc.addDocIntegrativa("Riga Esempio 7");
        cc.addDocIntegrativa("Riga Esempio 8");
        cc.addDocIntegrativa("Riga Esempio 9");
        //cc.addDocIntegrativa("Riga Esempio 10");
        //cc.addDocIntegrativa("Riga Esempio 11");
        return cc;
    }
    public static String getXmlSollecitoMock() throws JAXBException, IOException {
        SollecitoCC cc= CCMock.getBeanSollecitoMock();
        return Converter.objectToXml(cc);
    }

    public static CambioContraenza getBeanMock(){
        CambioContraenza cc = new CambioContraenza();
        cc.setCausale(getCausale());
        cc.setDataRichiesta(new Date());
        cc.setPolizza(ContrattoMock.getContratto());
        cc.setPassaggioAutomaticoContraenza(false);
        cc.addDocIntegrativa("Riga Esempio 11");
        cc.addDocIntegrativa("Riga Esempio 12");
        cc.addDocIntegrativa("Riga Esempio 13");
        cc.addDocIntegrativa("Riga Esempio 14");
        cc.addDocIntegrativa("Riga Esempio 15");
        cc.addDocIntegrativa("Riga Esempio 16");
        cc.addDocIntegrativa("Riga Esempio 17");
        cc.addDocIntegrativa("Riga Esempio 18");
        cc.addDocIntegrativa("Riga Esempio 19");
        cc.addDocIntegrativa("Riga Esempio 20");
        cc.addDocIntegrativa("Riga Esempio 21");
        return cc;
    }

    public static String getXmlMock() throws JAXBException, IOException {
       CambioContraenza cc= CCMock.getBeanMock();
       return Converter.objectToXml(cc);
    }

    private static CausaleCC getCausale(){
        CausaleCC causaleCC = new CausaleCC();
        causaleCC.setCausale(CausaleCC.CAMBIO_CONTRAENZA_PER_SURVIAL);
        return causaleCC;
    }

    public static String xmlAnomalo(){
        //return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2015-05-20T16:24:31.586+02:00</dataRichiesta><sollecito>false</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7520043</numeroID><contraente><titolo>Gentile Signora</titolo><cognome>RUSSO</cognome><nome>ANTONIA</nome><cf>RSSNTN34D66A064D</cf><indirizzo><via>VIA GARIGLIANO 5</via><cap>80016</cap><comune>MARANO DI NAPOLI</comune><provincia>NA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1934-04-26T00:00:00+01:00</dataNascita><sesso>F</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>RUSSO</cognome><nome>MATTEO</nome><cf>RSSMTT00S09F839J</cf><indirizzo><via>VIA GARIGLIANO 5</via><cap>80016</cap><comune>MARANO DI NAPOLI</comune><provincia>NA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>2000-11-09T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>MARUCCIA</cognome><nome>ANTONIO</nome><cf>MRCNTN67B15F839I</cf><indirizzo><via>VIA G M BOSCO ANG VIA ROSSELLI                    </via><cap>81100</cap><comune>CASERTA                  </comune><provincia>CE</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1967-02-15T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa>Modulo Cambio Contraenza</docIntgrativa><docIntgrativa>Adeg.Verifica mod.022086/200717-12.2014 ֠PF</docIntgrativa><docIntgrativa>Adeg.Verifica mod. mod.022092/200718-12.2014  - PG </docIntgrativa><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>true</assicuratoMinorenne></CambioContraenza>";
      //  return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2015-09-16T16:21:02.429+02:00</dataRichiesta><sollecito>false</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7469937</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>SCATTOLIN</cognome><nome>RINO</nome><cf>SCTRNI23D16F269L</cf><indirizzo><via>VIA MAMELI</via><cap>31021</cap><comune>MOGLIANO VENETO</comune><provincia>TV</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1923-04-16T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>SCATTOLIN</cognome><nome>SANDRO</nome><cf>SCTSDR73A03L407F</cf><indirizzo><via>VIA MAMELI</via><cap>31021</cap><comune>MOGLIANO VENETO</comune><provincia>TV</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1973-01-03T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Spett.le</titolo></pb></polizza><docIntgrativa> Modulo Cambio Contraenza</docIntgrativa><docIntgrativa>Integrazione dati di  Adeguata Verifica mod.022090/200720-12.2014 – Persona Fisica (mini qav)</docIntgrativa><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></CambioContraenza>";
        //return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2015-10-29T17:09:33.656+01:00</dataRichiesta><sollecito>false</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7469937</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>SCATTOLIN</cognome><nome>RINO</nome><cf>SCTRNI23D16F269L</cf><indirizzo><via>VIA MAMELI</via><cap>31021</cap><comune>MOGLIANO VENETO</comune><provincia>TV</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1923-04-16T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>SCATTOLIN</cognome><nome>SANDRO</nome><cf>SCTSDR73A03L407F</cf><indirizzo><via>VIA MAMELI</via><cap>31021</cap><comune>MOGLIANO VENETO</comune><provincia>TV</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1973-01-03T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Spett.le</titolo></pb></polizza><docIntgrativa> Modulo Cambio Contraenza</docIntgrativa><docIntgrativa>Integrazione dati di Adeguata Verifica mod.022090/200720-12.2014 relativa al contraente in entrata – Persona Fisica (mini qav)</docIntgrativa><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></CambioContraenza>";
        //return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2015-12-10T16:16:42.622+01:00</dataRichiesta><sollecito>false</sollecito><causale><causale>0</causale></causale><polizza><numeroID>70008737712</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>TAIOLI</cognome><nome>GIOVANNI</nome><cf>TLAGNN63H19C573V</cf><indirizzo><via>VIA CURIEL 6</via><cap>47023</cap><comune>CESENA</comune><provincia>FC</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1963-06-19T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signora</titolo><cognome>TAIOLI</cognome><nome>GIULIA</nome><cf>TLAGLI90D43C573I</cf><indirizzo><via>VIA CURIEL 6</via><cap>47023</cap><comune>CESENA</comune><provincia>FC</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1990-04-03T00:00:00+02:00</dataNascita><sesso>F</sesso></assicurato><pb><titolo>Gentile Signor</titolo><cognome>TAIOLI</cognome><nome>GIOVANNI</nome><cf>TLAGNN63H19C573V</cf><indirizzo><via>VLE VITTORIO VENETO 9                             </via><cap>47122</cap><comune>FORLI'                   </comune><provincia>FC</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1963-06-19T00:00:00+01:00</dataNascita><sesso>M</sesso></pb></polizza><docIntgrativa>Integrazione dati di  Adeguata Verifica mod.022090/200720-12.2014 relativa al contraente in entrata – Persona Fisica (mini qav)</docIntgrativa><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></CambioContraenza>";
        //return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><SollecitoCC><dataRichiesta>2016-03-03T13:00:00+01:00</dataRichiesta><sollecito>true</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7444305</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>ANGIULLI</cognome><nome>ALFREDO</nome><cf>NGLLRD41D21E995O</cf><indirizzo><via>VIA C.BATTISTI 56</via><cap>70026</cap><comune>MODUGNO</comune><provincia>BA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1941-04-21T00:00:00+02:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>ANGIULLI</cognome><nome>MASSIMO</nome><cf>NGLMSM67R26A662J</cf><indirizzo><via>VIA LATINA 1</via><cap>70026</cap><comune>MODUGNO</comune><provincia>BA</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1967-10-26T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Spett.le</titolo></pb></polizza><docIntgrativa> Modulo Cambio Contraenza</docIntgrativa><docIntgrativa>Integrazione dati di  Adeguata Verifica mod.022090/200720-12.2014 relativa al contraente in entrata – Persona Fisica (mini qav)</docIntgrativa><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></SollecitoCC>";
        //return  "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2016-10-03T16:56:14.287+02:00</dataRichiesta><sollecito>false</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7041958</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>MOLINARO</cognome><nome>ANTONIO</nome><cf>MLNNTN27B17L435Z</cf><indirizzo><via>VIA ALFREDO POGGIOLINI 9</via><cap>19125</cap><comune>LA SPEZIA</comune><provincia>SP</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1927-02-17T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signor</titolo><cognome>MOLINARO</cognome><nome>ANDREA</nome><cf>MLNNDR65P14E463P</cf><indirizzo><via>VIA ALFREDO POGGIOLINI 9</via><cap>19125</cap><comune>LA SPEZIA</comune><provincia>SP</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1965-09-14T00:00:00+01:00</dataNascita><sesso>M</sesso></assicurato><pb><titolo>Spett.le</titolo></pb></polizza><docIntgrativa> Modulo Cambio Contraenza</docIntgrativa><docIntgrativa> Atto notorio con elenco degli eredi e loro generalità</docIntgrativa><docIntgrativa> Designazione nuovo contraente da parte degli eredi e copia documento d’identità nuovo contraente</docIntgrativa><docIntgrativa> Modulo di Autocertificazione FATCA </docIntgrativa><docIntgrativa> Documento d’identità nuovo contraente</docIntgrativa><docIntgrativa>Integrazione dati di Adeguata Verifica mod.022090/200720-12.2014 relativa al contraente in entrata – Persona Fisica (mini qav)</docIntgrativa><passaggioAutomaticoContraenza>true</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></CambioContraenza>";
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><CambioContraenza><dataRichiesta>2016-11-03T16:53:26.029+01:00</dataRichiesta><sollecito>false</sollecito><causale><causale>1</causale></causale><polizza><numeroID>7745493</numeroID><contraente><titolo>Gentile Signor</titolo><cognome>SBARDELLA</cognome><nome>PASQUALE</nome><cf>SBRPQL24D10C479G</cf><indirizzo><via>VIA CARAGNO 19</via><cap>03024</cap><comune>CEPRANO</comune><provincia>FR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1924-04-10T00:00:00+01:00</dataNascita><sesso>M</sesso></contraente><assicurato><titolo>Gentile Signora</titolo><cognome>CARLINI</cognome><nome>ASSUNTA</nome><cf>CRLSNT34M53C479H</cf><indirizzo><via>VIA CARAGNO 19      </via><cap>03024</cap><comune>CEPRANO        </comune><provincia>FR</provincia><tel_fax></tel_fax><eMail></eMail></indirizzo><dataNascita>1934-08-13T00:00:00+01:00</dataNascita><sesso>F</sesso></assicurato><pb><titolo>Spett.le</titolo></pb></polizza><docIntgrativa> Modulo Cambio Contraenza</docIntgrativa><docIntgrativa>Integrazione dati di  Adeguata Verifica mod.022090/200720-12.2014 relativa al contraente in entrata – Persona Fisica (mini qav)</docIntgrativa><passaggioAutomaticoContraenza>false</passaggioAutomaticoContraenza><assicuratoMinorenne>false</assicuratoMinorenne></CambioContraenza>";
    }
}
