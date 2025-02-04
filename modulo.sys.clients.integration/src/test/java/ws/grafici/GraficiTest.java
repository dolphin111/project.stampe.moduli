package ws.grafici;

import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.graficiservice.ConfigurationGraph;
import com.fideuram.graficiservice.GraficiPortWs;
import com.fideuram.graficiservice.GraficiWsException;
import com.fideuram.graficiservice.Risposta;
import com.fideuram.utils.LoggingUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import ws.grafici.mock.BARRA;
import ws.grafici.mock.LINEA;

/**
 * Created by
 * User: logan
 * Date: 06/03/13
 * Time: 9.08
 */
public class GraficiTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(GraficiTest.class );
    }

    public void testProxy() {
        GraficiPortWs graficiPortWs= null;
        try {
            graficiPortWs = ClientWsFactory.getInstance().getGraficiClient();
        } catch (WebServiceClientException e) {
            assert false;
        }
        assertTrue(graficiPortWs != null);
    }

    public void testLinea()  {

        Risposta r = null;
        try {
            GraficiPortWs graficiPortWs= ClientWsFactory.getInstance().getGraficiClient();
            r = graficiPortWs.getGraficoLinea(LINEA.getMockCarellaPremium(), new ConfigurationGraph());
            LoggingUtils.info("Stream base 64: >>>> "+r.getStreamBase64().length());
            assertTrue(r != null);
            assertEquals(r.getStreamType(), "png");
            //assertTrue(r.getStreamBase64().length()==19288);
            //assertTrue(r.getStreamBase64().contains("iVBORw0KGgoAAAANSUhEUgAAAfQAAAEsCAYAAAA1u0HIAAA21UlEQVR42u2diVtUV56/f38aw+Aw"));
            assertTrue(r.isEsito());
        } catch (GraficiWsException e) {
            assert false;
        } catch (WebServiceClientException e) {
            assert false;
        }


    }

    public void testBarra() {

        Risposta r= null;
        try {
            GraficiPortWs graficiPortWs= ClientWsFactory.getInstance().getGraficiClient();
            r = graficiPortWs.getIstogramma(BARRA.getMock(),new ConfigurationGraph());
            assertTrue(r != null);
            assertEquals(r.getStreamType(), "png");
            assertTrue(r.isEsito());
        } catch (GraficiWsException e) {
            assert false;
        } catch (WebServiceClientException e) {
            assert false;
        }

    }
    

}
