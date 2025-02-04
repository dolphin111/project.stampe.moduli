package com.fideuram.documenti.avvisi;

import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.mock.avvisi.ScadenzaRamo1;
import com.fideuram.mock.avvisi.ScadenzaRamo3_C;
import com.fideuram.mock.avvisi.ScadenzaRamo3_R;
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
 * Date: 10/09/13
 * Time: 10.52
 */
public class ScadenzaPATest  extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ScadenzaPATest.class );
    }

    public void testGenerazioneDocumento()  {
        try {

            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(ScadenzaRamo1.getXml(), 13);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "AvvisiScadenzaPARamo1.odt");

            byte[] documento2= new DisplayPolizzaFacade().elaboraOdt(ScadenzaRamo3_R.getXml(), 13);
            assertNotNull(documento2);
            assertTrue(documento2.length>1000);
            StreamerFactory.saveFile(documento2, CrmProperties.getProperty("crm.services.temp.path"), "AvvisiScadenzaPARamo3_R.odt");

            byte[] documento3= new DisplayPolizzaFacade().elaboraOdt(ScadenzaRamo3_C.getXml(), 13);
            assertNotNull(documento3);
            assertTrue(documento3.length>1000);
            StreamerFactory.saveFile(documento3, CrmProperties.getProperty("crm.services.temp.path"), "AvvisiScadenzaPARamo3_C.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
