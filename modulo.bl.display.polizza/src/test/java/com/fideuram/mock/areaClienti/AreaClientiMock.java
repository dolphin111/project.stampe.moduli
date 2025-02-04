package com.fideuram.mock.areaClienti;



public class AreaClientiMock {
    public static String getXml(){
        String s="<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<polizza>\n" +
                "    <dataElaborazione>2013-05-06</dataElaborazione>\n" +
                "    <datiTecnici>\n" +
                "        <numeroPolizza>70012148011</numeroPolizza>\n" +
                "    </datiTecnici>\n" +
                "    <figureContrattuali>\n" +
                "        <contraente>\n" +
                "            <personaFisica>\n" +
                "                <cognome>NIZZOLI</cognome>\n" +
                "                <nome>GIAMPAOLO</nome>\n" +
                "                <codicefiscale>NZZGPL42A04D704I</codicefiscale>\n" +
                "                <datanascita>1942-01-04</datanascita>\n" +
                "                <sesso>M</sesso>\n" +
                "                <vip>false</vip>\n" +
                "            </personaFisica>\n" +
                "        </contraente>\n" +
                "        <indirizzoContratto>\n" +
                "            <tipoIndirizzo>POSTALE</tipoIndirizzo>\n" +
                "            <indirizzo>VIA PALLADIO, 31/1</indirizzo>\n" +
                "            <cap>47122</cap>\n" +
                "            <comune>FORLI'</comune>\n" +
                "            <provincia>FC</provincia>\n" +
                "            <regione>Manca</regione>\n" +
                "            <nazione>Italia</nazione>\n" +
                "            <dataAggiornamento>2012-07-31</dataAggiornamento>\n" +
                "        </indirizzoContratto>\n" +
                "    </figureContrattuali>\n" +
                "</polizza>";
        return s;
    }



}
