package com.fideuram.printer.previdenza;

/**
 * Created by V801068 on 05/06/14.
 */
public class Modello10Test extends ModelloTest{

    public static void main(String args[]){
        new ModelloTest().test(1110,Modello10Mock.getPrevidenzaMock());
    }


    public static String getXmlAnomalo(){
        return "<Previdenza>\n" +
                "   <primaIscrizione>2014-08-12T14:14:38.533+02:00</primaIscrizione>\n" +
                "   <primaLiquidabilita>2014-08-12T14:14:38.533+02:00</primaLiquidabilita>\n" +
                "   <polizza>\n" +
                "       <numeroID>7007486</numeroID>\n" +
                "       <contraente>\n" +
                "           <titolo>Gentile Signor</titolo>\n" +
                "           <cognome>GUERMANI</cognome>\n" +
                "           <nome>MASSIMO</nome>\n" +
                "           <indirizzo>\n" +
                "           <via>VIA GIUSEPPE SPADA 16</via>\n" +
                "           <cap>00179</cap>\n" +
                "           <comune>ROMA</comune>\n" +
                "           <provincia>RM</provincia>\n" +
                "           </indirizzo>\n" +
                "               <dataNascita>1959-03-03T00:00:00+01:00</dataNascita>\n" +
                "           <sesso>M</sesso>\n" +
                "       </contraente>\n" +
                "       <assicurato>\n" +
                "           <titolo>Gentile Signor</titolo>\n" +
                "           <cognome>GUERMANI</cognome>\n" +
                "           <nome>MASSIMO</nome>\n" +
                "           <indirizzo><via>VIA GIUSEPPE SPADA 16</via><cap>00179</cap><comune>ROMA</comune><provincia>RM</provincia></indirizzo>\n" +
                "           <dataNascita>1959-03-03T00:00:00+01:00</dataNascita>\n" +
                "           <sesso>M</sesso>\n" +
                "       </assicurato>\n" +
                "       <pb>\n" +
                "           <titolo>Gentile Signor</titolo>\n" +
                "           <cognome>DI GIUSEPPE</cognome>\n" +
                "           <nome>PIERCAMILLO</nome>\n" +
                "           <indirizzo><via>PZZA TUSCOLO 7/10                                 </via><cap>00183</cap><comune>ROMA                     </comune><provincia>RM</provincia></indirizzo>\n" +
                "           <dataNascita>1946-05-28T00:00:00+02:00</dataNascita>\n" +
                "           <sesso>M</sesso>\n" +
                "       </pb>\n" +
                "   </polizza>\n" +
                "   <convenzione>\n" +
                "       <titolo>Fondo Pensione Fideuram</titolo>\n" +
                "   </convenzione>\n" +
                "   <liquidazione>\n" +
                "       <dataRichiesta>2014-08-12T14:14:42.807+02:00</dataRichiesta>\n" +
                "   </liquidazione>\n" +
                "   <documentazione/>\n" +
                "</Previdenza>";
    }
}
