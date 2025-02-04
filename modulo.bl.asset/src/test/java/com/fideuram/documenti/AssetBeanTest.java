package com.fideuram.documenti;


import com.fideuram.exception.AssetException;
import com.fideuram.facade.AssetFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.config.CrmProperties;
import com.fideuram.iside.IsideResponce;
import com.fideuram.mock.AssetBeanMock;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.net.URISyntaxException;

/**
 * Created with
 * User: logan
 * Date: 05/07/13
 * Time: 15.23
 */
public class AssetBeanTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AssetBeanTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {
            IsideResponce documento= new AssetFacade().elaboraOdt(AssetBeanMock.getMock(), 0);
            assertNotNull(documento);
            assertTrue(documento.getMimetype().equalsIgnoreCase("pdf"));
            //StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "Asset.odt");
        } catch (AssetException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
