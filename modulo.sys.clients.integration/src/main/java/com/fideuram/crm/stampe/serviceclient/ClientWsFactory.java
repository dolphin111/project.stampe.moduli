/**
 * 
 */
package com.fideuram.crm.stampe.serviceclient;

import com.fideuram.crm.service.CrmServiceWSImpl;
import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.universo.ClientUniverso;
import com.fideuram.crm.stampe.serviceclient.universo.NuovoUniversoClientWS;
//import com.fideuram.document.services.DocumentConverterDelegate;
import com.fideuram.graficiservice.GraficiPortWs;
import com.fideuram.iside.facade.IsideManagerDelegate;
import com.fideuram.puc.service.impl.ProspettoServiceImpl;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.wsclient.simulatori.ValoreSaldoWsService;

/**
 * @author Piripicchio
 *
 */
public class ClientWsFactory {
    private static ClientWsFactory      instance = null;
    private ServiceLocator              serviceLocator;


    private ClientWsFactory(){
        serviceLocator = new ServiceLocator();
    }

	
	/**
	 * @return
	 * @throws Exception
	 */
	public static synchronized ClientWsFactory getInstance() {
		if(instance == null) {
			instance = new ClientWsFactory();
		}
		return instance;
	}



    /**
     * Restiruisce il web service client per il CRM
     * @return CrmStampeService
     * @throws WebServiceClientException
     */
    public CrmServiceWSImpl getCrmClient() throws  WebServiceClientException {
       return  (CrmServiceWSImpl) serviceLocator.getCrmClient();
    }

    /**
     * Restiruisce il web service client per il PUC
     * @return PucManagerPortWS
     * @throws WebServiceClientException
     */
    public StampeServiceImpl getPucClient() throws WebServiceClientException {
        return (StampeServiceImpl) serviceLocator.getPucClient();
    }

    /**
     * Restiruisce il web service client per il PUC relativamente ai PROSPETTI DI OFFERTA
     * @return PucProspettiManagerPortWS
     * @throws WebServiceClientException
     */
    public ProspettoServiceImpl getPucProspettoClient() throws WebServiceClientException {
        return (ProspettoServiceImpl) serviceLocator.getPucProspettiClient();
    }

    /**
     * Restiruisce il web service client per UNIVERSO <BR>
     * OWNER: CRISTANTE
     * @return the universoClient
     */
    public NuovoUniversoClientWS getUniversoClient() throws WebServiceClientException {
        return (NuovoUniversoClientWS) serviceLocator.getUniversoClient();
    }

    /**
     * Restiruisce il web service client per UNIVERSO <BR>
     * OWNER: BSOLUTION
     * @return the universoClient
     */
    @Deprecated
    public ClientUniverso getUniversoOldClient() throws WebServiceClientException {
        return (ClientUniverso) serviceLocator.getUniversoClient();
    }

    /**
     * Restiruisce il web service client per i servizi di archiviazione su ISIDE
     * @return StampeServiceImpl
     * @throws WebServiceClientException
     */
    public IsideManagerDelegate getIsideClient() throws WebServiceClientException {
        return (IsideManagerDelegate) serviceLocator.getIsideClient();
    }

    /**
     * Restituisce il web service client per i grafici<BR>
     * Owner del service: STAMPE
     * @return GraficiPortWs
     * @throws WebServiceClientException
     */
    public GraficiPortWs getGraficiClient() throws  WebServiceClientException {
        return  (GraficiPortWs) serviceLocator.getGraficiClient();
    }

    /**
     * @return the pdfConverterClient
     */
    public com.fideuram.pdfconverter.Converter getPdfConverterClient() throws WebServiceClientException {
        return (com.fideuram.pdfconverter.Converter) serviceLocator.getPdfConverterClient();
    }
    
    /**
     * @return the batchPdfConverterClient
     */
    public com.fideuram.batch.pdfconverter.Converter getBatchPdfConverterClient() throws WebServiceClientException {
        return (com.fideuram.batch.pdfconverter.Converter) serviceLocator.getBatchPdfConverterClient();
    }

    /**
     *
     * @return Stampe
     * @throws WebServiceClientException
     */
    public Stampe getStampe() throws WebServiceClientException {
        return (Stampe) serviceLocator.getStampe();
    }



    public ValoreSaldoWsService getSimulatoreClient() throws WebServiceClientException {
    	 return (ValoreSaldoWsService) serviceLocator.getSimulatoreClient();
    }




}
