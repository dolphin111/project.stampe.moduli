package com.fideuram.stampe.dao;

import com.fideuram.crm.service.CrmServiceWSImpl;
import com.fideuram.crm.service.Exception_Exception;
import com.fideuram.exception.ws.CrmException;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.stampe.cache.ClientWs;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

import java.util.List;

/**
 * Created with
 * User: v801068
 * Date: 27/11/13
 * Time: 15.44
 */
public class CrmDao {
	CrmServiceWSImpl crmS = null;


    public CrmDao(int coumincazione) throws WebServiceClientException {
        crmS= (CrmServiceWSImpl) new ClientWs().getCrmClient(coumincazione);
    }


   /*
   public CrmDao() throws WebServiceClientException {
        ClientWsFactory wsFactory = ClientWsFactory.getInstance();
        crmS=wsFactory.getCrmClient();
    }*/

    /**
     * Reperisce i dati della comunicazione registrata dal CRM
     * @param idComunicazione
     * @return
     * @throws CrmStampeException
     */
    public ComunicazioneVO getComunicazioneById(Integer idComunicazione) throws CrmException {
        try {
            ComunicazioneVO comunicazioneVO=  crmS.getComunicazioneById(idComunicazione);
            if (comunicazioneVO == null) {
                LoggingUtils.error("Comunicazione NULLA - ID " + idComunicazione);
                throw new CrmException("Comunicazione NULLA: " + idComunicazione);
            }
            return comunicazioneVO;
        } catch (Exception_Exception e) {
            throw new CrmException(e);
        }
    }

    public void salvaRisposta(Integer comunicazione,List<DomandaVO> listaDomande ,byte[] documentoFinale) throws CrmException {
        try {
            crmS.salvaRisposta(comunicazione, listaDomande, documentoFinale);
        } catch (Exception_Exception e) {
            throw new CrmException(e);
        }
    }

    public void salvaErrore(int idComunicazione, Throwable thr, String messagePrefix){
        LoggingUtils.error(messagePrefix + thr);
        try {
            if (!"true".equals(CrmProperties.getProperty(Costanti.CRM_STAMPE_TEST)))
                crmS.salvaErrore(idComunicazione, messagePrefix + thr.getMessage());
        } catch (Exception_Exception e1) {
            LoggingUtils.error(e1, e1);
        }
    }

    public byte[] getTemplateAccompagnamento() throws CrmException {
        try {
            return crmS.getTemplateAccompagnamento();
        } catch (Exception_Exception e) {
            throw new CrmException(e);
        }
    }
}
