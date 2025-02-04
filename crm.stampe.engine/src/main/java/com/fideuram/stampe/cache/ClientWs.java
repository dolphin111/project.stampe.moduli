package com.fideuram.stampe.cache;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.utils.LoggingUtils;

import java.util.Hashtable;

/**
 * User: v801068
 * Date: 17/10/14
 * Time: 9.51
 */
public class ClientWs {
    private static Hashtable casche;
    private static int CRM=1;
    private static int PUC=2;
    private static int UNI=3;
    private static int SIM=4;

    public ClientWs() {
        if(casche==null)
            casche=new Hashtable();
    }

    public Object getUniClient(int comID) throws WebServiceClientException {
        return getObject(UNI+"-"+comID);
    }

    public Object getCrmClient(int comID) throws WebServiceClientException {
        return getObject(CRM+"-"+comID);
    }

    public Object getPucClient(int comID) throws WebServiceClientException {
        return getObject(PUC+"-"+comID);
    }

    public Object getSimulatoreClient(int comID) throws WebServiceClientException {
        return getObject(SIM+"-"+comID);
    }

    
    
    
    private Object getObject(String key) throws WebServiceClientException {
        if(!casche.containsKey(key))
            loadClient(key);
        return casche.get(key);
    }

    private void loadClient(String key) throws WebServiceClientException {
        LoggingUtils.info("CREO : " + key);
        ClientWsFactory wsFactory = ClientWsFactory.getInstance();
        int client = Integer.decode(key.substring(0,1));
        switch (client){
            case 1:
                casche.put(key, wsFactory.getCrmClient());
                break;
            case 2:
                casche.put(key,wsFactory.getPucClient());
                break;
            case 3:
                casche.put(key,wsFactory.getUniversoClient());
                break;
            case 4:
                casche.put(key,wsFactory.getSimulatoreClient());
                break;
        }
    }

    public static void unloadClients(int comID){
        LoggingUtils.info("Cache Size: "+casche.size());
        LoggingUtils.info("Rimozione wsS" + comID);
        if (casche.containsKey(CRM+"-"+comID))
            casche.remove(CRM+"-"+comID);
        if (casche.containsKey(PUC+"-"+comID))
            casche.remove(PUC+"-"+comID);
        if (casche.containsKey(UNI+"-"+comID))
            casche.remove(UNI+"-"+comID);
        if (casche.containsKey(SIM+"-"+comID))
            casche.remove(SIM+"-"+comID);
        LoggingUtils.info("Cache Size: "+casche.size());

    }


}
