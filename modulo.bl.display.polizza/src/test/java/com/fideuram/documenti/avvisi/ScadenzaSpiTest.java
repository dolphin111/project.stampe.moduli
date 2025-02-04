package com.fideuram.documenti.avvisi;

import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.mock.avvisi.*;
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
 * Date: 11/10/13
 * Time: 15.35
 */
public class ScadenzaSpiTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ScadenzaSpiTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {

            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(ScadenzaSPIMock.getXml(), 7);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "AvvisiScadenzaSPI.odt");

            byte[] docAvvisiSpiNoEuro= new DisplayPolizzaFacade().elaboraOdt(ScadenzaSPIMock_NoEuro.getXml(), 7);
            assertNotNull(docAvvisiSpiNoEuro);
            assertTrue(docAvvisiSpiNoEuro.length>1000);
            StreamerFactory.saveFile(docAvvisiSpiNoEuro, CrmProperties.getProperty("crm.services.temp.path"), "AvvisiScadenzaSPI_NoEuro.odt");

        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
