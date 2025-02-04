package com.fideuram.processo;


import com.fideuram.exception.Cu2015Exception;
import com.fideuram.jaxb.Converter;
import com.fideuram.printer.stampa2015.PrinterCu2015;
import com.fideuram.prova.Cud2015Mock;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * User: V801068
 * Date: 21/11/14
 * Time: 12.04
 */
public class FacadeCu2015 {

    public void generaCu2015(String datiInXml) throws Cu2015Exception {

        try {
            Cud2015 c = parseXml2Bean(datiInXml);
           /* if(c.isAnnulla())
                new PrinterCu2015(c).annullaCud2015();
            else*/
                new PrinterCu2015(c).generateCud2015();
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (DocumentException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        }
    }

    private Cud2015 parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
       Cud2015 cud2015 = new Cud2015();
       cud2015= (Cud2015) Converter.xml2Object(cud2015, datiInXml);
       return cud2015;
    }

    public static void main(String args[]) throws JAXBException, IOException, Cu2015Exception {
        LoggingUtils.info("START");
        LoggingUtils.info(getXml());
        for(int i=0;i<1;i++){
            //new FacadeCu2015().generaCu2015(Cud2015Mock.getXmlMock());
            new FacadeCu2015().generaCu2015(getXml());
        }
        LoggingUtils.info("FINE");
    }

    private static  String getXml(){
        return "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n" +
                "<CUD2015>\n" +
                "    <tipodichiarazione>1</tipodichiarazione>\n" +
                "    <dataEleaborazione>2015-02-28T00:00:00+01:00</dataEleaborazione>\n" +
                "    <annoFiscale>2014</annoFiscale>\n" +
                "    <datoreLavoro>\n" +
                "        <titolo>Spett.le</titolo>\n" +
                "        <cognome>FIDEURAM VITA SPA</cognome>\n" +
                "        <nome></nome>\n" +
                "        <cf>10830461009</cf>\n" +
                "        <comuneNascita>ROMA</comuneNascita>\n" +
                "        <provinciaNascita>RM</provinciaNascita>\n" +
                "        <codAttivita>651100</codAttivita>\n" +
                "    </datoreLavoro>\n" +
                "    <percettoreSomme>\n" +
                "        <titolo>Gentile Signor</titolo>\n" +
                "        <cognome>BRUSTOLON</cognome>\n" +
                "        <nome>DARIO</nome>\n" +
                "        <cf>BRSDRA47S21D726D</cf>\n" +
                "        <indirizzo>\n" +
                "            <via>VIA CERCENA' 2</via>\n" +
                "            <cap>32012</cap>\n" +
                "            <comune>FORNO DI ZOLDO</comune>\n" +
                "            <provincia>BL</provincia>\n" +
                "            <tel_fax></tel_fax>\n" +
                "            <eMail></eMail>\n" +
                "        </indirizzo>\n" +
                "        <dataNascita>1947-11-21T00:00:00+01:00</dataNascita>\n" +
                "        <comuneNascita>FORNO DI ZOLDO</comuneNascita>\n" +
                "        <provinciaNascita>BL</provinciaNascita>\n" +
                "        <sesso>M</sesso>\n" +
                "        <categorieParticolari>U</categorieParticolari>\n" +
                "        <eventiEccezionali></eventiEccezionali>\n" +
                "        <casiEsclusione>1</casiEsclusione>\n" +
                "        <dfAttuale>\n" +
                "            <via></via>\n" +
                "            <cap></cap>\n" +
                "            <comune>FORNO DI ZOLDO</comune>\n" +
                "            <provincia>BL</provincia>\n" +
                "            <tel_fax></tel_fax>\n" +
                "            <eMail></eMail>\n" +
                "            <codiceComune>D726</codiceComune>\n" +
                "        </dfAttuale>\n" +
                "        <dfAnnoPrecedente>\n" +
                "            <via></via>\n" +
                "            <cap></cap>\n" +
                "            <comune>FORNO DI ZOLDO</comune>\n" +
                "            <provincia>BL</provincia>\n" +
                "            <tel_fax></tel_fax>\n" +
                "            <eMail></eMail>\n" +
                "            <codiceComune>D726</codiceComune>\n" +
                "        </dfAnnoPrecedente>\n" +
                "    </percettoreSomme>\n" +
                "    <indirizzoLettera>\n" +
                "        <via>VIA CERCENA' 2</via>\n" +
                "        <cap>32012</cap>\n" +
                "        <comune>FORNO DI ZOLDO</comune>\n" +
                "        <provincia>BL</provincia>\n" +
                "        <tel_fax></tel_fax>\n" +
                "        <eMail></eMail>\n" +
                "    </indirizzoLettera>\n" +
                "    <datiFiscali>\n" +
                "        <q5>\n" +
                "            <c1>0.0</c1>\n" +
                "            <c4>4864.6</c4>\n" +
                "            <c5>0.0</c5>\n" +
                "            <c7>0.0</c7>\n" +
                "            <c8>2014-01-01T00:00:00+01:00</c8>\n" +
                "            <c9>2014-12-31T00:00:00+01:00</c9>\n" +
                "        </q5>\n" +
                "        <q6>\n" +
                "            <c11>16.29</c11>\n" +
                "            <c12>0.0</c12>\n" +
                "            <c16>0.0</c16>\n" +
                "            <c17>0.0</c17>\n" +
                "            <c19>0.0</c19>\n" +
                "            <c20>0.0</c20>\n" +
                "            <c21>0.0</c21>\n" +
                "            <c23>0.0</c23>\n" +
                "            <c24>0.0</c24>\n" +
                "        </q6>\n" +
                "        <q7>\n" +
                "            <c31>0.0</c31>\n" +
                "            <c32>0.0</c32>\n" +
                "            <c33>0.0</c33>\n" +
                "            <c34>0.0</c34>\n" +
                "            <c35>0.0</c35>\n" +
                "            <c36>0.0</c36>\n" +
                "            <c37>0.0</c37>\n" +
                "            <c38>0.0</c38>\n" +
                "        </q7>\n" +
                "        <q8>\n" +
                "            <c51>0.0</c51>\n" +
                "            <c52>0.0</c52>\n" +
                "            <c53>0.0</c53>\n" +
                "            <c54>0.0</c54>\n" +
                "            <c55>0.0</c55>\n" +
                "            <c56>0.0</c56>\n" +
                "            <c57>0.0</c57>\n" +
                "            <c58>0.0</c58>\n" +
                "        </q8>\n" +
                "        <q9>\n" +
                "            <c61>0.0</c61>\n" +
                "            <c62>0.0</c62>\n" +
                "            <c63>0.0</c63>\n" +
                "            <c64>0.0</c64>\n" +
                "        </q9>\n" +
                "        <q10>\n" +
                "            <c65>0.0</c65>\n" +
                "            <c66>0.0</c66>\n" +
                "            <c67>0.0</c67>\n" +
                "            <c68>0.0</c68>\n" +
                "        </q10>\n" +
                "        <q12>\n" +
                "            <c101>1118.85</c101>\n" +
                "            <c102>16.29</c102>\n" +
                "            <c103>0.0</c103>\n" +
                "            <c104>0.0</c104>\n" +
                "            <c105>0.0</c105>\n" +
                "            <c106>0.0</c106>\n" +
                "            <c107>1102.56</c107>\n" +
                "            <c108>0.0</c108>\n" +
                "            <c109>0.0</c109>\n" +
                "            <c110>0.0</c110>\n" +
                "            <c111>0.0</c111>\n" +
                "            <c112>0.0</c112>\n" +
                "            <c113>1118.85</c113>\n" +
                "            <c114>0.0</c114>\n" +
                "            <c115>0.0</c115>\n" +
                "            <c116>0.0</c116>\n" +
                "            <c117>0.0</c117>\n" +
                "            <c118>0.0</c118>\n" +
                "        </q12>\n" +
                "        <q15>\n" +
                "            <c184>0.0</c184>\n" +
                "            <c186>0.0</c186>\n" +
                "            <c191>0.0</c191>\n" +
                "        </q15>\n" +
                "        <q17>\n" +
                "            <c221>0.0</c221>\n" +
                "            <c222>0.0</c222>\n" +
                "            <c223>0.0</c223>\n" +
                "        </q17>\n" +
                "        <q20>\n" +
                "            <c401>0.0</c401>\n" +
                "            <c402>0.0</c402>\n" +
                "            <c404>0.0</c404>\n" +
                "            <c405>0.0</c405>\n" +
                "            <c406>0.0</c406>\n" +
                "            <c407>0.0</c407>\n" +
                "            <c408>0.0</c408>\n" +
                "        </q20>\n" +
                "    </datiFiscali>\n" +
                "    <datiPrevidenziali>\n" +
                "        <annotazioni>1</annotazioni>\n" +
                "    </datiPrevidenziali>\n" +
                "</CUD2015>\n" +
                "\n";
    }
}

