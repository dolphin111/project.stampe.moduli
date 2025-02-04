package com.fideuram.crm.stampe.engine.producer;

import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 14/06/11
 * Time: 9.33
 */
public class ProducerBase {
    protected StampeServiceImpl       pucS           = null;
    protected ClientWsFactory        wsFactory      = null;



    public ProducerBase()  {
        //this.serviceLocator = new ServiceLocator();
        this.wsFactory =  ClientWsFactory.getInstance();
        try {
                pucS = wsFactory.getPucClient();
            } catch (WebServiceClientException e) {
                LoggingUtils.debug("Costruttore - ProducerBase  " + e.getCause());
                new DocGeneratorException("Eccezione nella connessione col PUC" + e.getMessage(), e);
            }
    }


}