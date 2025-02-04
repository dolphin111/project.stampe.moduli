package com.fideuram.documenti;

import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.mock.*;
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
 * Date: 16/04/13
 * Time: 19.21
 */
public class RiscattoAnticipatoTest  extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(RiscattoAnticipatoTest.class );
    }

    public void testPolizzaApertaR1Rendita(){
        try {
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(RiscattoAnticipatoPolizzaApertaRamo1RenditaMock.getXml(), 4538);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "RiscattoAnticipatoPARamo1R.odt.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }

    public void testPolizzaApertaR3Rendita(){
        try {
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(RiscattoanticipatoPolizzaApertaRamo3RenditaMock.getXml(), 9);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "RiscattoAnticipatoPARamo3R.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }

    public void testPolizzaApertaR1Capitale(){
        try {
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(RiscattoAnticipatoPolizzaApertaRamo1CapitaleMock.getXml(),4538);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "RiscattoAnticipatoPARamo1C.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }

    public void testPolizzaApertaR3Capitale(){
        try {
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(RiscattoAnticipatoPolizzaApertaRamo3CapitaleMock.getXml(), 9);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "RiscattoAnticipatoPARamo3C.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }

    public void testPolizzaChiusa(){
        try {
            byte[] documento= new DisplayPolizzaFacade().elaboraOdt(RiscattoAnticipatoPolizzaChiusaMock.getXml(), 4538);
            assertNotNull(documento);
            assertTrue(documento.length>1000);
            StreamerFactory.saveFile(documento, CrmProperties.getProperty("crm.services.temp.path"), "RiscattoAnticipatoPC.odt");
        } catch (DisplayPolizzaException e) {
            assert false;
            LoggingUtils.error(e);
        } catch (Exception e) {
            assert false;
            LoggingUtils.error(e);
        }
    }


}
