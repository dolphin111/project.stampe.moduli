package com.fideuram.documenti;

import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.mock.BonusMock;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by
 * User: logan
 * Date: 23/04/13
 * Time: 11.21
 */
public class BonusTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(BonusTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(BonusMock.getXml(), 510);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "ProiezioneBonus.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
