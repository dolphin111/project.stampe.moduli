package com.fideuram.printer.cambiocontraneza;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.utils.LoggingUtils;
import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by V801068 on 14/05/14.
 */
public class CCTest {

    public static void main(String args[]){
        //new CCTest().testcc();
        new CCTest().testccAnomalo();
    }

    public void testcc(){
        try {
            String xml1=CCMock.xmlAnomalo();
            LoggingUtils.info(xml1);
            new ControllerActionsGenerics().elaboraProcesso(xml1, 1010);

            String xml2=CCMock.getXmlSollecitoMock();
            LoggingUtils.info(xml2);
            byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(xml2,1011);
            StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "cc.odt");
        } catch (JAXBException e) {
            LoggingUtils.error(e);
        } catch (IOException e) {
            LoggingUtils.error(e);
        } catch (GenericsException e) {
            LoggingUtils.error(e);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void testccAnomalo(){
        try {
            String xml1=CCMock.xmlAnomalo();
            LoggingUtils.info(xml1);
            byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(CCMock.xmlAnomalo(), 1010);
            StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "ccAnomalo.odt");
        } catch (JAXBException e) {
            LoggingUtils.error(e);
        } catch (IOException e) {
            LoggingUtils.error(e);
        } catch (GenericsException e) {
            LoggingUtils.error(e);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
