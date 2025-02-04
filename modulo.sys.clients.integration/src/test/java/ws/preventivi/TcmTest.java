package ws.preventivi;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.StampeWsException;
import com.fideuram.utils.LoggingUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with
 * User: v801068
 * Date: 23/01/14
 * Time: 16.09
 */
public class TcmTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TcmTest.class );
    }

    public void testBozza(){
        try {
            Stampe Stampe=new ServiceLocator().getStampe();
           // byte[] odt=Stampe.stampaPreventivo(PreventivoTcmBozzaMock.getMock(),"111");
            byte[] odt=Stampe.stampaPreventivo(null,"111");
            StreamerFactory.saveFile(odt, CrmProperties.getProperty("crm.services.temp.path"), "EsitoTestBozzaPreventivo.pdf");
        } catch (StampeWsException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (WebServiceClientException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }


}
