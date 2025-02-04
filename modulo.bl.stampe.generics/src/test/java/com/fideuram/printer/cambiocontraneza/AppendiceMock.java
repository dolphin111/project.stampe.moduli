package com.fideuram.printer.cambiocontraneza;

/**
 * Created by V801068 on 20/05/14.
 */
public class AppendiceMock{
    public static String getMock(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<AppendiceCC>\n" +
                "    <sollecito>false</sollecito>\n" +
                "    <polizza>\n" +
                "        <numeroID>12434534</numeroID>\n"+
                "        <descrizioneProdotto>Piano Pensione Fideuram - Viva</descrizioneProdotto>\n" +
                "        <decorrenza>1986-04-08T00:00:00+02:00</decorrenza>\n" +
                "        <adesione>1986-04-08T00:00:00+02:00</adesione>\n" +
                "        <contraente>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>ANDREINA</cognome>\n" +
                "            <nome>PETTITI PAGLIARI</nome>\n" +
                "        </contraente>\n" +
                "        <pb>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>RENZO</cognome>\n" +
                "            <nome>TROMBOTTO</nome>\n" +
                "            <indirizzo>\n" +
                "                <via>CSO GALILEO FERRARIS 51                           </via>\n" +
                "                <cap>10128</cap>\n" +
                "                <comune>TORINO                   </comune>\n" +
                "                <provincia>TO</provincia>\n" +
                "            </indirizzo>\n" +
                "        </pb>\n" +
                "    </polizza>\n" +
                "    <dataEmissioneAppendice>2014-05-20T15:23:05.906+02:00</dataEmissioneAppendice>\n" +
                "    <nuovoContraente>\n" +
                "        <titolo>Spett.le</titolo>\n" +
                "        <cognome>Mauro</cognome>\n" +
                "        <nome>Carosi</nome>\n" +
                "            <indirizzo>\n" +
                "                <via>CSO GALILEO FERRARIS 51                           </via>\n" +
                "                <cap>10128</cap>\n" +
                "                <comune>TORINO                   </comune>\n" +
                "                <provincia>TO</provincia>\n" +
                "            </indirizzo>\n" +
                "    </nuovoContraente>\n" +
                "    <dataEffettoCC>2014-06-02T00:00:00+02:00</dataEffettoCC>\n" +
                "</AppendiceCC>\n";
    }

}
