package com.fideuram.stampe.domande;

import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.GenericsException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.stampe.dao.PucDao;

/**
 * Created by V801068 on 21/05/14.
 */
public class D1000AppendiceCC extends DomandaBase{


    public D1000AppendiceCC(int comID) {
        super(comID);
    }

    public byte[] generaDocumento(DomandaVO domandaVO, Long richiestaBpm) throws DomandaException{
        try {
            String xml = new PucDao(comID).getAppendiceCambioContraenza(richiestaBpm);
            return (byte[]) new ControllerActionsGenerics().elaboraProcesso(xml, domandaVO.getDescrizioneDomandaOriginaleId());
        } catch (PucException e) {
            throw new DomandaException(e);
        } catch (WebServiceClientException e) {
            throw new DomandaException(e);
        } catch (GenericsException e) {
            throw new DomandaException(e);
        }
    }
}
