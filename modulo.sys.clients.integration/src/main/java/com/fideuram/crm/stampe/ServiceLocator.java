package com.fideuram.crm.stampe;

import com.fideuram.exception.ws.UniversoException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.service.CrmServiceWS;
import com.fideuram.crm.service.CrmServiceWSImpl;
import com.fideuram.crm.stampe.serviceclient.bi.ClientWSUniverso;
import com.fideuram.crm.stampe.serviceclient.universo.NuovoUniversoClientWS;
import com.fideuram.graficiservice.GraficiPortWs;
import com.fideuram.graficiservice.GraficiService;
import com.fideuram.iside.facade.IsideManagerDelegate;
import com.fideuram.iside.facade.IsideManagerService;
import com.fideuram.puc.service.impl.ProspettoService;
import com.fideuram.puc.service.impl.ProspettoServiceImpl;
import com.fideuram.puc.service.impl.StampeService;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.costanti.Systems;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;
import com.fideuram.utils.Streamer;
import com.fideuram.wsclient.simulatori.ValoreSaldoWsService;
import com.fideuram.wsclient.simulatori.ValoreSaldoWsServiceService;

import javax.xml.namespace.QName;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 20/03/12
 * Time: 9.07
 */
public class ServiceLocator {

    private String                      pucUrl          = null;
    private String                      pucProspettiUrl = null;
    private String                      crmUrl          = null;
    private String                      isideUrl        = null;
  //private String                      converterUrl    = null;
    private String                      pdfConverterUrl = null;
    private String                      batchPdfConverterUrl = null;
    private String                      ssUrl           = null;
    private String                      graficiUrl      = null;
    private String                      universoUrl     = null;
    private String                      simulatoreUrl     = null;
    

    public GraficiPortWs getGraficiClient() throws WebServiceClientException {
        if(graficiUrl==null)
            setup();
        try {
            return new GraficiService(new URL(graficiUrl), new QName("http://graficiservice.fideuram.com/", "GraficiService")).getGraficiPort();
        } catch (MalformedURLException e) {
            throw new WebServiceClientException(this.getClass().toString()+" graficiClient " + e.getMessage(), e);
        }

    }

    /**
     * Questo metodo fornisce il client ws_client del PUCService.
     * Questo metodo crea la prima istanza e la riusa fin
     * quando rimane aperta la sessione
     * @return
     * @throws  WebServiceClientException
     */
    public StampeServiceImpl getPucClient() throws WebServiceClientException {
        if(pucUrl==null)
            setup();
        try {
           return new StampeService(new URL(pucUrl), new QName("http://impl.service.puc.fideuram.com/", "StampeService")).getStampeServiceImplPort();
        } catch (MalformedURLException e) {
            LoggingUtils.error(e);
            throw new WebServiceClientException(this.getClass().toString()+" getPucClient " + e.getMessage(), e);
        }
    }

    /**
     * Questo metodo fornisce il client ws_client del PUCService.
     * Questo metodo crea la prima istanza e la riusa fin
     * quando rimane aperta la sessione
     * @return
     * @throws WebServiceClientException
     */
    public ProspettoServiceImpl getPucProspettiClient() throws WebServiceClientException {
        if(pucProspettiUrl==null)
            setup();
        try {
            return new ProspettoService(new URL(pucProspettiUrl), new QName("http://impl.service.puc.fideuram.com/", "ProspettoService")).getProspettoServiceImplPort();
        } catch (MalformedURLException e) {
            throw new WebServiceClientException(this.getClass().toString()+" getPucProspettoClient " + e.getMessage(), e);
        }
    }

    /**
     * Questo metodo fornisce il client ws_client del CRMService.
     * Questo metodo crea la prima istanza e la riusa fin
     * quando rimane aperta la sessione
     * @return
     * @throws WebServiceClientException
     */
    public  CrmServiceWSImpl getCrmClient() throws WebServiceClientException {
        if(crmUrl==null)
            setup();
        try {
            return new CrmServiceWS(new URL(crmUrl), new QName("http://service.crm.fideuram.com/", "CrmServiceWS")).getCrmServiceWSImplPort();
        } catch (MalformedURLException e) {
            throw new WebServiceClientException(this.getClass().toString()+" getCrmClient " + e.getMessage(), e);
        }

    }



    public com.fideuram.pdfconverter.Converter getPdfConverterClient() throws WebServiceClientException {
        if(pdfConverterUrl==null)
            setup();
        try {
            return new com.fideuram.pdfconverter.ConverterService(new URL(pdfConverterUrl), new QName("http://pdfconverter.fideuram.com/", "ConverterService")).getConverterPort();
        } catch (MalformedURLException e) {
            throw new WebServiceClientException(this.getClass().toString()+" getPdfConverterClient " + e.getMessage(), e);
        }

    }
    
    public com.fideuram.batch.pdfconverter.Converter getBatchPdfConverterClient() throws WebServiceClientException {
        if(batchPdfConverterUrl==null)
            setup();
        try {
            return new com.fideuram.batch.pdfconverter.ConverterService(new URL(batchPdfConverterUrl), new QName("http://pdfconverter.fideuram.com/", "ConverterService")).getConverterPort();
        } catch (MalformedURLException e) {
            throw new WebServiceClientException(this.getClass().toString()+" getBatchPdfConverterClient " + e.getMessage(), e);
        }

    }


    public IsideManagerDelegate getIsideClient() throws WebServiceClientException {
        if(isideUrl==null)
            setup();
        try {
            return (IsideManagerDelegate) new IsideManagerService(new URL(isideUrl), new QName("http://facade.iside.fideuram.com/", "IsideManagerService")).getIsideManagerPort();
        } catch (MalformedURLException e) {
            throw new WebServiceClientException(this.getClass().toString()+" getIsideClient " + e.getMessage(), e);
        }
    }

    public Stampe getStampe() throws WebServiceClientException {
        if(ssUrl==null)
            setup();
        try {
            return new com.fideuram.stampeservice.StampeService(new URL(ssUrl), new QName("http://stampeservice.fideuram.com/", "StampeService")).getStampePort();
        } catch (MalformedURLException e) {
            throw new WebServiceClientException(this.getClass().toString()+" getStampeClient " + e.getMessage(), e);
        }catch (Exception e) {
            e.printStackTrace();
            throw new WebServiceClientException(this.getClass().toString()+" getStampeClient " + e.getMessage(), e);
        }
    }

    /**
     *
     * @return
     */
    public  NuovoUniversoClientWS getUniversoClient() throws WebServiceClientException {
            if(universoUrl==null)
                 setup();
            try {
                //return  new NuovoUniversoClientWS();
                return  new NuovoUniversoClientWS(universoUrl);
            } catch (UniversoException e) {
                throw new WebServiceClientException(this.getClass().toString()+" getUniversoClient " + e.getMessage(), e);
            }
    }

    /**
     * @return
     * @throws  WebServiceClientException
     */
    public ValoreSaldoWsService getSimulatoreClient() throws WebServiceClientException {
        if(simulatoreUrl==null)
            setup();
        try {
           return new ValoreSaldoWsServiceService(new URL(simulatoreUrl), new QName("http://com.fidevita.bancafideuram.it", "ValoreSaldoWsServiceService")).getValoreSaldoWsServicePort();
        } catch (MalformedURLException e) {
            LoggingUtils.error(e);
            throw new WebServiceClientException(this.getClass().toString()+" getSimulatoreClient " + e.getMessage(), e);
        }
    }


    /**
     *
     * @return
     */
    @Deprecated
    public ClientWSUniverso getOldUniversoClient() throws WebServiceClientException {
            return  new ClientWSUniverso();
    }

    private void setup() {
        LoggingUtils.info("Rel 1.1.."+this.getClass() + "-" + new Date() );
        pucUrl          = CrmProperties.getProperty(Systems.PUC_SERVICES_STAMPE_URL);
        pucProspettiUrl = CrmProperties.getProperty(Systems.PUC_PROSPETTI_SERVICES_STAMPE_URL);
        crmUrl          = CrmProperties.getProperty(Systems.CRM_SERVICES_STAMPE_URL);
        isideUrl        = CrmProperties.getProperty(Systems.ISIDE_SERVICES_STAMPE_URL);
        //converterUrl    = CrmProperties.getProperty(Systems.CONVERTER_SERVICES_STAMPE_URL);
        pdfConverterUrl = CrmProperties.getProperty(Systems.CONVERTER_PDF_URL);
        batchPdfConverterUrl = CrmProperties.getProperty(Systems.BATCH_CONVERTER_PDF_URL);
        ssUrl           = CrmProperties.getProperty(Systems.STAMPE_URL);
        graficiUrl      = CrmProperties.getProperty(Systems.GRAFICI_URL);
        universoUrl     = CrmProperties.getProperty(Systems.UNIVERSO_URL);
        simulatoreUrl   = CrmProperties.getProperty(Systems.SIMULATORE_URL);
        LoggingUtils.info("pucUrl " + pucUrl);
        LoggingUtils.info("pucProspettoUrl " + pucProspettiUrl);
        LoggingUtils.info("crmUrl " + crmUrl);
        LoggingUtils.info("isideUrl " + isideUrl);
        LoggingUtils.info("pdfConverterUrl " + pdfConverterUrl);
        LoggingUtils.info("ssUrl " + ssUrl);
        LoggingUtils.info("graficiUrl " + graficiUrl);
        LoggingUtils.info("universoUrl " + universoUrl);
        LoggingUtils.info("simulatoreUrl " + simulatoreUrl);
    }



}
