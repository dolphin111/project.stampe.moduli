package com.fideuram.stampe.domande;

import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.GenericsException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PucDao;
import com.fideuram.utils.LoggingUtils;


/**
 * PREVENTIVO CONVERIONE RENDITA
 * <br>Questo controller a differenza degli altri non deve configurare una polizza
 * <br>in quanto trattandosi di un preventivo  la polizza ancora non esiste
 * User: V801068
 * Date: 21/07/14
 * Time: 12.05
 */
public class D950PreventivoCR extends DomandaBase{


    public D950PreventivoCR(int comID) {
        super(comID);
    }
    /**
     * GENERA IL DOCUMENTO BASATO SUL TEMPLATE
     * PreventivoConversioneRendita.odt
     * @param comunicazioneVO
     * @param domandaVO
     * @return
     * @throws DomandaException
     */
    public byte[] generaDocumento(ComunicazioneVO comunicazioneVO, DomandaVO domandaVO) throws DomandaException{

        try {
            String xml = new PucDao(comID).getPreventivoConversioneRendita(comunicazioneVO,domandaVO);
            return (byte[]) new ControllerActionsGenerics().elaboraProcesso(xml, domandaVO.getDescrizioneDomandaOriginaleId());
        } catch (WebServiceClientException e) {
            LoggingUtils.error(e);
            throw new DomandaException(e);
        } catch (PucException e) {
            LoggingUtils.error(e);
            throw new DomandaException(e);
        } catch (DaoException e) {
            LoggingUtils.error(e);
            throw new DomandaException(e);
        } catch (GenericsException e) {
            LoggingUtils.error(e);
            throw new DomandaException(e);
        }
    }




}
