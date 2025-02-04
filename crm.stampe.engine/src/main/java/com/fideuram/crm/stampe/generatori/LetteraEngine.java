package com.fideuram.crm.stampe.generatori;

import com.fideuram.crm.service.CrmServiceWSImpl;
import com.fideuram.crm.stampe.serviceclient.universo.NuovoUniversoClientWS;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.stampe.cache.ClientWs;
import com.fideuram.wsclient.simulatori.ValoreSaldoWsService;


/**
 * User: v801068
 * Date: 20/10/14
 * Time: 10.26
 */
public class LetteraEngine extends AbstractLettera{
    public LetteraEngine(int comID) throws WebServiceClientException {
        pucS = getPucWSClient(comID);
        crmS = getCrmWSClient(comID);
        uniS = getUniversoClient(comID);
        this.comID=comID;
    }

    private CrmServiceWSImpl getCrmWSClient(int comunicazione) throws  WebServiceClientException {
        return  (CrmServiceWSImpl) new ClientWs().getCrmClient(comunicazione);
    }

    private StampeServiceImpl getPucWSClient(int comunicazione) throws  WebServiceClientException {
        return  (StampeServiceImpl) new ClientWs().getPucClient(comunicazione);
    }

    private NuovoUniversoClientWS getUniversoClient(int comunicazione) throws  WebServiceClientException {
        return  (NuovoUniversoClientWS) new ClientWs().getUniClient(comunicazione);
    }

    protected ValoreSaldoWsService getSimulatoreClient(int comunicazione) throws  WebServiceClientException {
        return  (ValoreSaldoWsService) new ClientWs().getSimulatoreClient(comunicazione);
    }
}
