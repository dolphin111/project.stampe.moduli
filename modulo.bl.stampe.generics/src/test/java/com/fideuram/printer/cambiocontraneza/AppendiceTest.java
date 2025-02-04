package com.fideuram.printer.cambiocontraneza;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.GenericsException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.utils.LoggingUtils;



/**
 * Created by V801068 on 20/05/14.
 */
public class AppendiceTest {
    public static void main(String args[]){
        new AppendiceTest().testeppendice();
    }

    public void testeppendice(){
        try {

            LoggingUtils.info(AppendiceMock.getMock());
            byte[] b= (byte[]) new ControllerActionsGenerics().elaboraProcesso(AppendiceMock.getMock(), 1001);
            try {
                StreamerFactory.saveFile(b, CrmProperties.getProperty("crm.services.temp.path"), "appendicitecc.odt");
            } catch (Exception e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                LoggingUtils.error("Vafammokk",e);
            }

        } catch (GenericsException e) {
            LoggingUtils.error(e);
        }
    }
}
