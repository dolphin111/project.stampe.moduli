package ws.stampe.trasformazioni;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.stampeservice.Risposta;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.TrasportBean;
import com.fideuram.utils.LoggingUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 31/03/15
 * Time: 16.34
 */
public class TrasformazioneTest   extends TestCase    {

        /**
         * @return the suite of tests being tested
         */
        public static Test suite() {
        return new TestSuite(TrasformazioneTest.class );
    }

    public void testGenerazioneDocumento()  {
        TrasportBean trasportBean=new TrasportBean();
        //trasportBean.setAction("6016");
        trasportBean.setAction("801");
        trasportBean.setXml(getXml());
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
            //Risposta r =Stampe.generatePdf(trasportBean);
            Risposta r =Stampe.generateOdt(trasportBean);
            //assertNotNull(r.getStreams());
            //assertTrue(r.getStreams().get(0).length > 1000);
            StreamerFactory.saveFile(r.getStreams().get(0), CrmProperties.getProperty("crm.services.temp.path"), "TestTrasformate.odt");
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }

    private static String getXml(){
        return "<polizzaTrasformabile>\n" +
                "    <canale>0</canale>\n" +
                "    <polizza>\n" +
                "        <numero>7720546</numero>\n" +
                "        <nomeCommercialeProdotto>Financial Age Protection 2</nomeCommercialeProdotto>\n" +
                "        <tipoPremio>U</tipoPremio>\n" +
                "        <privateBanker>\n" +
                "            <cognome>ANFOSSO</cognome>\n" +
                "            <nome>EUGENIO</nome>\n" +
                "            <rete>SPI</rete>\n" +
                "        </privateBanker>\n" +
                "        <contraente>\n" +
                "            <cognome>TIMOSSI</cognome>\n" +
                "            <nome>ANGELO</nome>\n" +
                "        </contraente>\n" +
                "        <assicurato>\n" +
                "            <cognome>TIMOSSI</cognome>\n" +
                "            <nome>ANGELO</nome>\n" +
                "            <livello>0</livello>\n" +
                "        </assicurato>\n" +
                "    </polizza>\n" +
                "    <nomeCommercialeProdottoDestinazione>Fideuram Vita Insieme Facile</nomeCommercialeProdottoDestinazione>\n" +
                "    <decorrenza>29/06/2005</decorrenza>\n" +
                "    <scadenza>31/12/2015</scadenza>\n" +
                "    <durata>10 anni e 6 mesi</durata>\n" +
                "    <dataProposta>18/03/2015</dataProposta>\n" +
                "    <origine/>\n" +
                "</polizzaTrasformabile>";
    }
}
