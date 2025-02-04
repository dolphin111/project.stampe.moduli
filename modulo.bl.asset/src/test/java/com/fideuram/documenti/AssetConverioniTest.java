package com.fideuram.documenti;

import com.fideuram.mock.AssetBeanMock;
import com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale;
import com.fideuram.xml.XmlAssetConverter;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created with
 * User: v801068
 * Date: 05/12/13
 * Time: 14.24
 */
public class AssetConverioniTest extends TestCase {

    public static Test suite() {
        return new TestSuite(AssetConverioniTest.class );
    }

    public void testGenerazioneDocumento()  {
        try {
            String xml = XmlAssetConverter.getXml(AssetBeanMock.getMock());
            assertNotNull(xml);
            assertTrue(xml.length()>15);

            FondoInvestimentoGlobale fig = XmlAssetConverter.getBeans(xml);
            assertNotNull(fig);
            assertTrue(fig.getNome().equalsIgnoreCase("FAP"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

