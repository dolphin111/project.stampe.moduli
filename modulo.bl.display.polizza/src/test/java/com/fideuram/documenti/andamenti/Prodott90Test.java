package com.fideuram.documenti.andamenti;

import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.mock.andamenti.AndamentoProdotto90Mock;
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
 * Date: 03/10/13
 * Time: 12.05
 */
public class Prodott90Test extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AndamentoRisultatiTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(AndamentoProdotto90Mock.getXml(), 11);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "AndamentiRisultatiProdotto90.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
