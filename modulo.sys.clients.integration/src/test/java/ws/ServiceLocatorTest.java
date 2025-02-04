package ws;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.iside.facade.IsideManagerDelegate;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 14/06/11
 * Time: 22.49
 */
public class ServiceLocatorTest extends TestCase{
   /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ServiceLocatorTest.class );
    }

    /**
     *
     */

   public void testIsideClient() {
       ServiceLocator sl = new ServiceLocator();
       IsideManagerDelegate isideCLient  = null;
        try {
            isideCLient = sl.getIsideClient();
            assertTrue(isideCLient != null);
            LoggingUtils.info("isideCLient" +isideCLient.toString());
        } catch (WebServiceClientException e) {
            assert false;
            LoggingUtils.error(e);
        }

    }


    /**
     *
     */

     public void testPucClient() {
        ServiceLocator sl = new ServiceLocator();
        StampeServiceImpl pucClient  = null;
        try {
            pucClient = sl.getPucClient();
            assertTrue(pucClient != null);
            LoggingUtils.info("pucClient" +pucClient.toString());
        } catch (WebServiceClientException e) {
            e.printStackTrace();
        }

    }

}
