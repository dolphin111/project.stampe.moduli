package com.fideuram.documenti.andamenti;

import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.mock.andamenti.AndamentiERisultatiMock;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created with
 * User: logan
 * Date: 10/07/13
 * Time: 11.56
 */
public class AndamentoRisultatiTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AndamentoRisultatiTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {
           // byte[] documento= null;//new DisplayPolizzaFacade().elaboraOdt(AndamentoAnomaloMock.getMock(), 11);
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(AndamentiERisultatiMock.getXml(), 11);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "AndamentiRisultati.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
