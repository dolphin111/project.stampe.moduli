package com.fideuram.documenti;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.AssetException;
import com.fideuram.facade.AssetFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.iside.IsideResponce;
import com.fideuram.mock.AssetBeanMock;
import com.fideuram.mock.AssetXmlMock;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.net.URISyntaxException;

/**
 * Created with
 * User: v801068
 * Date: 05/12/13
 * Time: 14.52
 */
public class AssetXmlTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AssetXmlTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {
            //byte[] documento= new AssetFacade().elaboraOdt(AssetXmlMock.getXml() , 0);
            IsideResponce documento= new AssetFacade().elaboraOdt(AssetXmlMock.getXml() , 0);
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
