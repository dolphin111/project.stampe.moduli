package com.fideuram.anomalia;

import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


import java.net.URISyntaxException;


/**
 * Created by
 * User: logan
 * Date: 23/04/13
 * Time: 12.30
 */
public class AnomaliaTest  extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(AnomaliaTest.class );
    }


    public void testAnomalia(){
        try {
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(MockOccasionale.getXml(), 12);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "Anomalia.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }
}
