package com.fideuram.documenti.prototipo;

import com.fideuram.config.CrmProperties;
import com.fideuram.documenti.AreaClientiTest;
import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.mock.prototipo.PrototipoMock;
import com.fideuram.utils.LoggingUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.net.URISyntaxException;

/**
 * Created with
 * User: logan
 * Date: 17/10/13
 * Time: 9.35
 */
public class PrototipoTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AreaClientiTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(PrototipoMock.getXml(), 10001);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento,  CrmProperties.getProperty("crm.services.temp.path"), "Prototipo.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }

}
