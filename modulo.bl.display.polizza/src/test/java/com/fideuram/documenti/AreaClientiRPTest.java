package com.fideuram.documenti;

import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.mock.areaClienti.AreaClientiMock;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 02/10/13
 * Time: 10.09
 * To change this template use File | Settings | File Templates.
 */
public class AreaClientiRPTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AreaClientiRPTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(AreaClientiMock.getXml(), 17);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "AreaClientiRP.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
