package ws.proxy.puc;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.puc.service.impl.DettaglioValoreAllaDataVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.utils.LoggingUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import java.util.GregorianCalendar;

/**
 * User: V801068
 * Date: 23/11/15
 * Time: 16.36
 */
public class Puc_SimulazioneAllaData_Test extends TestCase {

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(Puc_SimulazioneAllaData_Test.class );
    }

    public void testWarningTrace()  {
        StampeServiceImpl pucManagerPortWS= null;
        try {
            pucManagerPortWS = ClientWsFactory.getInstance().getPucClient();
            GregorianCalendar g=new GregorianCalendar();
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(g);
            DettaglioValoreAllaDataVO _vo=pucManagerPortWS.getValoreAllaDataByPolizzaData("700035771", xmlGregorianCalendar);
            assertTrue(_vo.getWarningTrace().size()>0);
        } catch (WebServiceClientException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        } catch (ServiceException_Exception e) {
            e.printStackTrace();
        }
    }
}
