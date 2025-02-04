package ws.stampe.sicurezza;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Risposta;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.TrasportBean;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Created by V801068 on 07/05/14.
 */
public class AreaClientiTest extends TestCase {

    public static Test suite() {
        return new TestSuite(AreaClientiTest.class );
    }




    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        trasportBean.setAction("17");
        //trasportBean.setXml(getDatiLetteraPinVO());
        trasportBean.setXml(getAnomaliaMeli());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            Risposta r =Stampe.generatePdf(trasportBean);
            assertNotNull(r.getStreams());
            assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "EsitoAreaClienti.pdf");
        } catch (Exception e) {
            assert false;
        }
    }


    private String getDatiLetteraPinVO(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016459005</polizza>\n" +
                "    <user>EAABA4AE10</user>\n" +
                "    <password>Rqdxpwvv1!</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>FILOMENA</nome>\n" +
                "    <cognome>SACCOMANNO</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>NA</provincia>\n" +
                "    <regione>Campania</regione>\n" +
                "    <cap>80133</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA AGOSTINO DEPRETIS 19</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>NAPOLI</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }



    private static String getAnomaliaMeli(){
        return  "<DatiLetteraPinPVO>\n" +
                "    <nome>STEFANO</nome>\n" +
                "    <cognome>PIANTA</cognome>\n" +
                "    <sesso>M</sesso>\n" +
                "    <indirizzo>VIA DON GIOVANNI VERITA' 7</indirizzo>\n" +
                "    <nazione>Italia</nazione>\n" +
                "    <comune>MILANO</comune>\n" +
                "    <provincia>MI</provincia>\n" +
                "    <cap>20158</cap>\n" +
                "    <user>EAABA4AE10</user>\n" +
                "    <password>Rqdxpwvv1!</password>\n" +
                "</DatiLetteraPinPVO>";
    }
  /*  public void testScriptino()  {
        byte[] pdf=null;
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO1(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "1_70016404208.pdf");


            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO2(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "2_70016451804.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO3(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "3_70016451607.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO4(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "4_70016451506.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO5(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "5_70016439909.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO6(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "6_70016474211.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO7(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "7_70016420706.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO8(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "8_70016446905.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO9(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "9_70016484307.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO10(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "10_70016447011.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO11(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "11_70016447112.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO12(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "12_70016495409.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO13(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "13_70016410112.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO14(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "14_70016451410.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO15(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "15_70016459005.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO16(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "16_70016495308.pdf");

            pdf=Stampe.getPdfFromXml(AreaClientiTest.getVO17(),""+16);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "17_70016440006.pdf");
        } catch (Exception e) {
            LoggingUtils.error(e);
            assert false;
        }
    }
    private static String getVO1(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016404208</polizza>\n" +
                "    <user>E776A84DBA</user>\n" +
                "    <password>Ukfhrppw6!</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>BIAGIO</nome>\n" +
                "    <cognome>BIAGIARELLI</cognome>\n" +
                "    <sesso>M</sesso>\n" +
                "    <provincia>VT</provincia>\n" +
                "    <regione>Lazio</regione>\n" +
                "    <cap>01030</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA A.RICCIARDI, 21</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>VALLERANO</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO2(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016451804</polizza>\n" +
                "    <user>E42F871FDF</user>\n" +
                "    <password>Qkvixvfp7$</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>DANIELA</nome>\n" +
                "    <cognome>UBALDI</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>VT</provincia>\n" +
                "    <regione>Lazio</regione>\n" +
                "    <cap>01100</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA VICENZA 46</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>VITERBO</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO3(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016451607</polizza>\n" +
                "    <user>E62089B0EC</user>\n" +
                "    <password>Lkdmshyo8#</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>GAIA</nome>\n" +
                "    <cognome>BRANDANI</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>LI</provincia>\n" +
                "    <regione>Toscana</regione>\n" +
                "    <cap>57125</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>V. DELLE SIEPI, 9</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>LIVORNO</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO4(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016451506</polizza>\n" +
                "    <user>E4D0A1C44D</user>\n" +
                "    <password>Nvwgabku4!</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>EMMA</nome>\n" +
                "    <cognome>BRANDANI</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>LI</provincia>\n" +
                "    <regione>Toscana</regione>\n" +
                "    <cap>57100</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA DELLE SIEPI</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>LIVORNO</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO5(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016439909</polizza>\n" +
                "    <user>E3BF3AD5D2</user>\n" +
                "    <password>Dycoerma9!</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>MARIA SILVA</nome>\n" +
                "    <cognome>BRUNO FRANCO</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>CN</provincia>\n" +
                "    <regione>Piemonte</regione>\n" +
                "    <cap>12031</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA SANT' ANNA 27</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>BAGNOLO PIEMONTE</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO6(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016474211</polizza>\n" +
                "    <user>ECA2F9C199</user>\n" +
                "    <password>Pffadbvz2$</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>ROSANNA</nome>\n" +
                "    <cognome>DE BERNARDI</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>BI</provincia>\n" +
                "    <regione>Piemonte</regione>\n" +
                "    <cap>13811</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA LORENZO PEROSI, 36</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>ANDORNO MICCA</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO7(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016420706</polizza>\n" +
                "    <user>EB3510E98A</user>\n" +
                "    <password>Eiwxacnl6$</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>GERARDO</nome>\n" +
                "    <cognome>DE CARO</cognome>\n" +
                "    <sesso>M</sesso>\n" +
                "    <provincia>SA</provincia>\n" +
                "    <regione>Campania</regione>\n" +
                "    <cap>84085</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA NOCELLETO FRAZ.CIORANI, 18</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>MERCATO SAN SEVERINO</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO8(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016446905</polizza>\n" +
                "    <user>EEAB40C5D5</user>\n" +
                "    <password>Oesvxrfa6!</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>FRANCESCO</nome>\n" +
                "    <cognome>FIORILLO</cognome>\n" +
                "    <sesso>M</sesso>\n" +
                "    <provincia>NA</provincia>\n" +
                "    <regione>Campania</regione>\n" +
                "    <cap>80129</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA LUCA GIORDANO 69 SCA</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>NAPOLI</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO9(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016484307</polizza>\n" +
                "    <user>EAF34B6B11</user>\n" +
                "    <password>Zeqvvjnq1#</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>NADIA</nome>\n" +
                "    <cognome>FUSILLI</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>MI</provincia>\n" +
                "    <regione>Lombardia</regione>\n" +
                "    <cap>20080</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA ADAMELLO 20</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>ZIBIDO SAN GIACOMO</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO10(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016447011</polizza>\n" +
                "    <user>E24B10EBBA</user>\n" +
                "    <password>Vvjmaafo9!</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>VALERIO</nome>\n" +
                "    <cognome>GRECO</cognome>\n" +
                "    <sesso>M</sesso>\n" +
                "    <provincia>NA</provincia>\n" +
                "    <regione>Campania</regione>\n" +
                "    <cap>80127</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA GIOVANNI MERLIANI 31</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>NAPOLI</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO11(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016447112</polizza>\n" +
                "    <user>E03C7FFC4F</user>\n" +
                "    <password>Nilwqsyx3$</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>LIVIA</nome>\n" +
                "    <cognome>MONTANARO</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>NA</provincia>\n" +
                "    <regione>Campania</regione>\n" +
                "    <cap>80121</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VLE CESARE AUGUSTO 118 SC C /14</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>NAPOLI</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO12(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016495409</polizza>\n" +
                "    <user>EC8AB1DB07</user>\n" +
                "    <password>Jjeryykf4@</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>TOMASO</nome>\n" +
                "    <cognome>MARAZZA</cognome>\n" +
                "    <sesso>M</sesso>\n" +
                "    <provincia>MI</provincia>\n" +
                "    <regione>Lombardia</regione>\n" +
                "    <cap>20080</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA ADAMELLO 20</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>ZIBIDO SAN GIACOMO</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>\n";
    }
    private static String getVO13(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016410112</polizza>\n" +
                "    <user>EC1BF00237</user>\n" +
                "    <password>Nhpnzbmz6$</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>EVIS</nome>\n" +
                "    <cognome>MARZI</cognome>\n" +
                "    <sesso>M</sesso>\n" +
                "    <provincia>FI</provincia>\n" +
                "    <regione>Toscana</regione>\n" +
                "    <cap>50053</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA PO, 11</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>EMPOLI</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO14(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016451410</polizza>\n" +
                "    <user>E1ED087029</user>\n" +
                "    <password>Ofymbjga8$</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>LAURA</nome>\n" +
                "    <cognome>RAZZANO</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>RM</provincia>\n" +
                "    <regione>Lazio</regione>\n" +
                "    <cap>00138</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>SAL DI CASTEL GIUBILEO 155</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>ROMA</citta>\n" +
                "    <isMail>false</isMail>"+
                "</DatiLetteraPinPVO>";
    }
    private static String getVO15(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016459005</polizza>\n" +
                "    <user>EAABA4AE10</user>\n" +
                "    <password>Rqdxpwvv1!</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>FILOMENA</nome>\n" +
                "    <cognome>SACCOMANNO</cognome>\n" +
                "    <sesso>F</sesso>\n" +
                "    <provincia>NA</provincia>\n" +
                "    <regione>Campania</regione>\n" +
                "    <cap>80133</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA AGOSTINO DEPRETIS 19</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>NAPOLI</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO16(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016495308</polizza>\n" +
                "    <user>EEA8DF8351</user>\n" +
                "    <password>Ojjkequc2$</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>ENRICO</nome>\n" +
                "    <cognome>MALDOTTI</cognome>\n" +
                "    <sesso>M</sesso>\n" +
                "    <provincia>MI</provincia>\n" +
                "    <regione>Lombardia</regione>\n" +
                "    <cap>20089</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA DEI GLADIOLI 5</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>ROZZANO</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }
    private static String getVO17(){
        return "<DatiLetteraPinPVO>\n" +
                "    <polizza>70016440006</polizza>\n" +
                "    <user>E8A5C898CC</user>\n" +
                "    <password>Xjeeyclx4!</password>\n" +
                "    <daInviare>S</daInviare>\n" +
                "    <nome>LUCA STEFANO</nome>\n" +
                "    <cognome>MERLI</cognome>\n" +
                "    <sesso>M</sesso>\n" +
                "    <provincia>MI</provincia>\n" +
                "    <regione>Lombardia</regione>\n" +
                "    <cap>20090</cap>\n" +
                "    <nazione>Italia                                            </nazione>\n" +
                "    <indirizzo>VIA F.LLI ROSSELLI 11</indirizzo>\n" +
                "    <discriminator>PF</discriminator>\n" +
                "    <citta>PIEVE EMANUELE</citta>\n" +
                "    <isMail>false</isMail>\n" +
                "</DatiLetteraPinPVO>";
    }*/
}
