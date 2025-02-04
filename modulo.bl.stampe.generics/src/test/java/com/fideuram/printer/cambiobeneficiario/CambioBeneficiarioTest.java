package com.fideuram.printer.cambiobeneficiario;


import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.contraenza.CambioBenficiario;
import com.fideuram.stampe.modello.contraenza.Contratto;
import java.util.Date;

/**
 * User: V801068
 * Date: 18/06/15
 * Time: 14.11
 */
public class CambioBeneficiarioTest {

    public  static void main(String args[]) throws Exception {
        //CambioBenficiario cambioBenficiario = getMock();
        //String xml = Converter.objectToXml(cambioBenficiario);
        //LoggingUtils.info(xml);
        //byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(xml,1002);
        byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(getXmlMockAnomalo(),1002);
        StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "CambioBeneficiario.odt");
    }

    public static String getXmlMockAnomalo(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<CambioBenficiario>\n" +
                "    <sollecito>false</sollecito>\n" +
                "    <polizza>\n" +
                "        <numeroID>90008819301</numeroID>\n" +
                "        <aderente>\n" +
                "            <titolo>Gentile Signor</titolo>\n" +
                "            <cognome>MARCHESE</cognome>\n" +
                "            <nome>PAOLO</nome>\n" +
                "            <cf>MRCPLA48H29B006D</cf>\n" +
                "            <indirizzo>\n" +
                "                <via>VLE CITTA' DI PRATO 15</via>\n" +
                "                <cap>38051</cap>\n" +
                "                <comune>BORGO VALSUGANA</comune>\n" +
                "                <provincia>TN</provincia>\n" +
                "                <tel_fax></tel_fax>\n" +
                "                <eMail></eMail>\n" +
                "            </indirizzo>\n" +
                "            <dataNascita>1948-06-29T00:00:00+02:00</dataNascita>\n" +
                "            <sesso>M</sesso>\n" +
                "        </aderente>\n" +
                "        <pb>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>FIORITO</cognome>\n" +
                "            <nome>LUCA</nome>\n" +
                "            <cf>FRTLCU62D19L378O</cf>\n" +
                "            <indirizzo>\n" +
                "                <via>VIA AMBROSI 1                                     </via>\n" +
                "                <cap>38100</cap>\n" +
                "                <comune>TRENTO                   </comune>\n" +
                "                <provincia>TN</provincia>\n" +
                "                <tel_fax></tel_fax>\n" +
                "                <eMail>LFIORITO@bancafideuram.it</eMail>\n" +
                "            </indirizzo>\n" +
                "        </pb>\n" +
                "    </polizza>\n" +
                "    <dataDecorrenza>2015-06-22T00:00:00+02:00</dataDecorrenza>\n" +
                "    <nuoviBeneficiari>\n" +
                "        <titolo>Gentile Signor</titolo>\n" +
                "        <cognome>BIANCHI</cognome>\n" +
                "        <nome>PAOLO</nome>\n" +
                "        <cf>BCHPLO54D52A501B</cf>\n" +
                "        <dataNascita>1965-10-06T00:00:00+01:00</dataNascita>\n" +
                "        <sesso>M</sesso>\n" +
                "    </nuoviBeneficiari>\n" +
                "    <nuoviBeneficiari>\n" +
                "        <titolo>Gentile Signor</titolo>\n" +
                "        <cognome>BIANCHI</cognome>\n" +
                "        <nome>EMILIO</nome>\n" +
                "        <cf>BCHMLI74D51S501H</cf>\n" +
                "        <dataNascita>1965-10-06T00:00:00+01:00</dataNascita>\n" +
                "        <sesso>M</sesso>\n" +
                "    </nuoviBeneficiari>\n" +
                "</CambioBenficiario>\n";
    }
    public static String getXmlMock(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<CambioBenficiario>\n" +
                "    <sollecito>false</sollecito>\n" +
                "    <polizza>\n" +
                "        <numeroID>7355263</numeroID>\n" +
                "        <aderente>\n" +
                "            <titolo>Gentile Signor</titolo>\n" +
                "            <cognome>PEDA</cognome>\n" +
                "            <nome>GIANFRANCESCO</nome>\n" +
                "            <cf>PDEGFR60D10I156Z</cf>\n" +
                "            <indirizzo>\n" +
                "                <via>V. ATTILIO FRIGGERI 55</via>\n" +
                "                <cap>00136</cap>\n" +
                "                <comune>ROMA</comune>\n" +
                "                <provincia>RM</provincia>\n" +
                "                <tel_fax>null/null</tel_fax>\n" +
                "            </indirizzo>\n" +
                "            <dataNascita>1960-04-10T00:00:00+01:00</dataNascita>\n" +
                "            <sesso>M</sesso>\n" +
                "        </aderente>\n" +
                "        <pb>\n" +
                "            <titolo>Spett.le</titolo>\n" +
                "            <cognome>ABBATE</cognome>\n" +
                "            <nome>DANIELE</nome>\n" +
                "            <cf>BBTDNL76M21H501I</cf>\n" +
                "            <indirizzo>\n" +
                "                <via>VIA FRANCESCO MARIA TORRIGIO 21</via>\n" +
                "                <cap>00168</cap>\n" +
                "                <comune>ROMA</comune>\n" +
                "                <provincia>RM</provincia>\n" +
                "                <tel_fax>null/null</tel_fax>\n" +
                "            </indirizzo>\n" +
                "        </pb>\n" +
                "    </polizza>\n" +
                "    <nuoviBeneficiari>\n" +
                "        <titolo>Gentile Signora</titolo>\n" +
                "        <cognome>SANTORI</cognome>\n" +
                "        <nome>DELIA MARIA</nome>\n" +
                "        <cf>SNTDMR69A43E715S</cf>\n" +
                "        <sesso>F</sesso>\n" +
                "    </nuoviBeneficiari>\n" +
                "    <nuoviBeneficiari>\n" +
                "        <titolo>Gentile Signora</titolo>\n" +
                "        <cognome>SANTORI</cognome>\n" +
                "        <nome>MARINA</nome>\n" +
                "        <cf>SNTMRN70M53E715Y</cf>\n" +
                "        <sesso>F</sesso>\n" +
                "    </nuoviBeneficiari>\n" +
                "</CambioBenficiario>\n" +
                "\n";
    }

    public static CambioBenficiario getMock(){
            //PREPARAZIONE DEL BEAN DI CAMBIO BENEFICIARIO
            CambioBenficiario cambioBenficiario = new CambioBenficiario();
            cambioBenficiario.setDataDecorrenza(new Date());

            //ANAGRAFICA DEL NUOVO BENEFICIARIO
            Individuo nuovoBeneficiario=new Individuo();
            nuovoBeneficiario.setCognome("Caledonia");
            nuovoBeneficiario.setNome("Nuova Maria");
            nuovoBeneficiario.setCf("cccfiscalex501c");
            cambioBenficiario.addNuovoBeneficiario(nuovoBeneficiario);

            //RECAPITO DEL CONTRAENTE E PER COMODITà PURE DEL PB
            Recapito recapito= new Recapito();
            recapito.setCap("00100");
            recapito.setProvincia("RM");
            recapito.setComune("Roma");
            recapito.setVia("Via della navicella 32");
            nuovoBeneficiario.setIndirizzo(recapito);

            Contratto contratto = new Contratto();
            contratto.setNumeroID("4327");
            cambioBenficiario.setPolizza(contratto);

            //ANAGRAFICA ADERENTE CONTRAENTE
            Individuo aderente=new Individuo();
            aderente.setCognome("Amanda");
            aderente.setNome("Rosa Maria");
            aderente.setCf("cccfiscalex501c");
            aderente.setIndirizzo(recapito);
            aderente.setSesso("F");
            aderente.setDataNascita(new Date());
            contratto.setAderente(aderente);

            //ANAGRAFICA PB
            Individuo pb=new Individuo();
            pb.setCognome("NeSckens");
            pb.setNome("Joahn");
            pb.setIndirizzo(recapito);
            contratto.setPb(pb);

            cambioBenficiario.setPolizza(contratto);
        return cambioBenficiario;
    }
}
