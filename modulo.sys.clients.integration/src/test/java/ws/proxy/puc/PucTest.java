package ws.proxy.puc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 24/05/11
 * Time: 9.19
 *  URL DISPONIBILI:
 *  DARIO-->http://10.13.64.212:7001/crm.web/StampeService?WSDL
 *  BETATEST-->http://10.13.65.247:7001/crm.web/StampeService?WSDL
 */
public class PucTest extends TestCase {

   /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(PucTest.class );
    }

    public void testProxy()  {
        StampeServiceImpl pucManagerPortWS= null;
        try {
            pucManagerPortWS = ClientWsFactory.getInstance().getPucClient();
            assertTrue(pucManagerPortWS != null);
        } catch (WebServiceClientException e) {
            assert false;
            LoggingUtils.error(e);
        }
    }

    /**
     *
     */
   /* public void testLiquidazioniSpiByNumeroPolizza() {
        StampeServiceImpl pucClient  = null;
        try {
           //   pucClient = new PucStampeServiceClient(new URL("http://fvasowl01c.fidevita.bancafideuram.it/crm.web/StampeService?WSDL")).getPort();
              pucClient = new PucStampeServiceClient(new URL(CrmProperties.getProperty("puc.services.stampe.url"))).getPort();
            try {
                LiquidazionePolizzaVO vo = pucClient.getLiquidazioniSPIByNumeroPolizza(new Long("57208055"));
            } catch (ServiceException_Exception e) {
                e.printStackTrace();
            }
            assertTrue(pucClient != null);
            System.out.println("pucClient" +pucClient.toString());
        } catch (MalformedURLException e) {
              e.printStackTrace();
        }

    }*/
}
