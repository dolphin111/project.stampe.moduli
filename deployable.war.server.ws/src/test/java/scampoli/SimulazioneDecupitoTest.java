package scampoli;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;

/**
 * User: V801068
 * Date: 07/10/15
 * Time: 15.24
 */
public class SimulazioneDecupitoTest {
    public  static void main(String args[]) throws Exception {
        byte[]   prova  = new Stampe().getOdtFromXml(getXml(),"simulazioneDecumulo");
        StreamerFactory.saveFile(prova, CrmProperties.getProperty("crm.services.temp.path"), "SimulazioneDecupito.odt");
    }


    public static String getXml(){
        return "<simulazioneDecumuloPVO><importoCVN desc=\"Cumulo Versamenti Netti al\">40.000,00</importoCVN><percentuale desc=\"Percentuale del decumulo\">1,00</percentuale><frazionamento desc=\"Frazionamento\">Annuale</frazionamento><importoDecumulo desc=\"Importo del decumulo\">400,00</importoDecumulo><dataCVN desc=\"DataCVN\">18/06/2013</dataCVN></simulazioneDecumuloPVO>";
    }
}
