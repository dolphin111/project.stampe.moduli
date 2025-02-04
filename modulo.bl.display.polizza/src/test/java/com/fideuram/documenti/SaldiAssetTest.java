package com.fideuram.documenti;

import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.mock.SaldiAssetMock;
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
 * Date: 05/07/13
 * Time: 15.23
 */
public class SaldiAssetTest  extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(SaldiAssetTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {
            //byte[] documento= new DisplayPolizzaFacade().elaboraOdt(SaldiAssetMock.getXml(), 12);
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(SaldiAssetMock.getXmlMX3(), 12);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "SaldiAsset.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
