package com.fideuram.printer.previdenza;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.printer.mock.ContraenteMock;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.stampe.modello.comunicazionecrm.Comunicazione;
import com.fideuram.stampe.modello.contraenza.Valuta;
import com.fideuram.stampe.modello.previdenza.PrevidenzaTrasferimentoInput;
import com.fideuram.utils.LoggingUtils;

import java.util.Date;

/**
 * User: V801068
 * Date: 01/07/15
 * Time: 15.42
 */
public class TrasferimentoInIngressoTest {
    public static void main(String args[]) throws Exception {
        //String xml= Converter.objectToXml(getMock());
        //LoggingUtils.info(xml);
        //byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(xml,1003);
        //byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(getXmlMock(),1004);
        byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(anomalia(),1004);
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "PrevidenzaTrasferimentoIngresso1004.odt");
    }

    private static String  anomalia(){
        return "<PrevidenzaTrasferimentoInput>\n" +
                "    <richiesta>\n" +
                "        <data>2014-10-03T00:00:00+02:00</data>\n" +
                "    </richiesta>\n" +
                "    <compagniaDiProvenienza>\n" +
                "        <titolo>Spett.le</titolo>\n" +
                "        <ragioneSociale>FONDO PENSIONE DEI DIRIGENTI DIPENDENTI DA INTESA SANPAOLO S.P.A. E DALLE SUE SOCIETA' CONTROLLATE</ragioneSociale>\n" +
                "        <indirizzo>\n" +
                "            <via>Piazza P. Ferrari 10</via>\n" +
                "            <cap>20121</cap>\n" +
                "            <comune>MILANO</comune>\n" +
                "            <provincia>MI</provincia>\n" +
                "            <tel_fax></tel_fax>\n" +
                "            <eMail></eMail>\n" +
                "        </indirizzo>\n" +
                "    </compagniaDiProvenienza>\n" +
                "    <aderente>\n" +
                "        <titolo>Spett.le</titolo>\n" +
                "        <cognome>DEL PRETE</cognome>\n" +
                "        <nome>ANNACHIARA</nome>\n" +
                "        <cf>DLPNCH78R68B715G</cf>\n" +
                "    </aderente>\n" +
                "    <valuta>\n" +
                "        <dataValuta>2014-11-07T00:00:00+01:00</dataValuta>\n" +
                "        <valore>36519.48</valore>\n" +
                "        <valuta>â‚¬</valuta>\n" +
                "    </valuta>\n" +
                "</PrevidenzaTrasferimentoInput>";
    }
    private static String getXmlMock(){
        return "<PrevidenzaTrasferimentoInput>\n" +
                "    <richiesta>\n" +
                "        <data>2013-05-11T00:00:00+02:00</data>\n" +
                "    </richiesta>\n" +
                "    <compagniaDiProvenienza>\n" +
                "        <titolo>Spett.le</titolo>\n" +
                "        <ragioneSociale>FONDO PENSIONE APERTO MILANO ASSICURAZIONI</ragioneSociale>\n" +
                "        <indirizzo>\n" +
                "            <via>Via Stalingrado 45</via>\n" +
                "            <cap>40128</cap>\n" +
                "            <comune>BOLOGNA</comune>\n" +
                "            <provincia>BO</provincia>\n" +
                "            <tel_fax></tel_fax>\n" +
                "            <eMail></eMail>\n" +
                "        </indirizzo>\n" +
                "    </compagniaDiProvenienza>\n" +
                "    <aderente>\n" +
                "        <titolo>Spett.le</titolo>\n" +
                "        <cognome>ZARPELLON</cognome>\n" +
                "        <nome>MARIA PIA</nome>\n" +
                "        <cf>ZRPMRP61E45A703O</cf>\n" +
                "    </aderente>\n" +
                "    <valuta>\n" +
                "        <dataValuta>2014-11-11T00:00:00+01:00</dataValuta>\n" +
                "        <valore>188.44</valore>\n" +
                "        <valuta>â‚¬</valuta>\n" +
                "    </valuta>\n" +
                "</PrevidenzaTrasferimentoInput>";
    }


    private static PrevidenzaTrasferimentoInput getMock(){
        Comunicazione c=new Comunicazione();
        c.setData(new Date());
        Valuta valuta = new Valuta();
        valuta.setValore(1200.00);
        valuta.setDataValuta(new Date());

        PrevidenzaTrasferimentoInput p=new PrevidenzaTrasferimentoInput();
        p.setCompagniaDiProvenienza(ContraenteMock.getCompagniaProvenienza());
        p.setAderente(ContraenteMock.getAderente());
        p.setRichiesta(c);
        p.setValuta(valuta);
        return p;
    }
}
