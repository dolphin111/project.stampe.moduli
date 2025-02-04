package com.fideuram.crm.stampe.engine.dataLoader;


import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.puc.service.impl.*;
import com.fideuram.utils.LoggingUtils;

import java.util.HashMap;
import java.util.List;


/**
 * Created
 * User: logan
 * Date: 23/06/11
 * Time: 10.46
 */
public class InfoPolizza {
    private StampeServiceImpl pucS           = null;
    private ClientWsFactory   wsFactory = null;
    private PolizzaVO         polizzaVO      = null;

    public InfoPolizza() throws DocGeneratorException {
           wsFactory = ClientWsFactory.getInstance();
        try {
            pucS =  wsFactory.getPucClient();
        } catch (WebServiceClientException e) {
            LoggingUtils.debug("Costruttore - InfoPolizza  " + e.getCause());
            new DocGeneratorException("Eccezione nella connessione col PUC" + e.getMessage(), e);
        }
    }

    public InfoPolizzaVO getPolizzaByPolizza(Long numeroPolizza) throws DocGeneratorException {        
        InfoPolizzaVO polizzaVo;
        try {
            polizzaVo = pucS.getDatiPolizzaByPolizza(numeroPolizza);
        } catch (ServiceException_Exception e) {
            throw new DocGeneratorException("Eccezione proveniente dal Puc" + e.getMessage(), e);
        }
        return polizzaVo;
    }

    /**
     * @param numeroPolizza
     * @return List<DettaglioAnagraficaVO>
     * @throws DocGeneratorException
     */
    public List<DettaglioAnagraficaVO> getListAnagraficheByPolizza(Long numeroPolizza) throws DocGeneratorException {
        List<DettaglioAnagraficaVO> anagrafiche;
        try {
            anagrafiche = pucS.listAnagraficheByPolizza(numeroPolizza);
        } catch (ServiceException_Exception e) {
            throw new DocGeneratorException("Eccezione proveniente dal Puc" + e.getMessage(), e);
        }
        return anagrafiche;
    }

    /**
     * Questo metodo restituisce:
     * <br> U se la polizza è a Premio Unico</br>
     * <br> G se la polizza è a Premio Unico Aggiuntivo</br>
     * <br> A se la polizza è a Premio Unico Ricorrente</br>
     * <br> R se la polizza è a Premio Unico Ricorrente</br>
     *
     * @param numeroPolizza
     * @return HashMap
     * @throws ServiceException_Exception
     */
    public String tipoPremio(String numeroPolizza) throws DocGeneratorException {
        if ((polizzaVO == null) || (!polizzaVO.getPolizza().toString().equals(numeroPolizza)))
            try {
                polizzaVO = pucS.getDatiPolizzaByPolizza(new Long(numeroPolizza));
            } catch (ServiceException_Exception e) {
                throw new DocGeneratorException("Errore proveniente dal PUC, invocando: getDatiPolizzaByPolizza(" + numeroPolizza + ")", e);
            }

        return polizzaVO.getCodicePremio();
    }
    
    public AvvisidiScadenzaRamoIIIVO opzioniAvvisi(String numeroPolizza) throws DocGeneratorException {
    	AvvisidiScadenzaRamoIIIVO vo;
    	try {
           	vo = pucS.getAvvisiScadenzaRamoIIIByNumeroPolizza(new Long(numeroPolizza));
        } catch (ServiceException_Exception e) {
            throw new DocGeneratorException("Errore proveniente dal PUC, invocando: opzioniAvvisi(" + numeroPolizza + ")", e);
        }
        return vo;
    }
            
    public String getXmlDisplayPolizza(HashMap<String, String> stampe, String numeroPolizza, String processo) throws DocGeneratorException{
    	String xml;
    	try{
    		polizzaVO = pucS.getDatiPolizzaByPolizza(new Long(numeroPolizza));
    	}catch(ServiceException_Exception e){
    		throw new DocGeneratorException("Errore proveniente dal PUC, invocando: getXmlDisplayPolizza(" + numeroPolizza + ")", e);
    	}
    	return null;
    }
    
    public String getXmlPuc(ElaboraProcessoInputVO input) throws DocGeneratorException{
    	String xml;
    	try{
    		xml = pucS.elaboraProcesso(input);
    	}catch(ServiceException_Exception e){
    		throw new DocGeneratorException("Errore proveniente dal PUC, invocando: getXml", e);
    	}
    	return xml;
    }
}
