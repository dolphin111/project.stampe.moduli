package com.fideuram.controllers;

import com.fideuram.attori.bo.IPersona;
import com.fideuram.attori.bo.impl.Contraente;
import com.fideuram.attori.bo.impl.Indirizzo;
import com.fideuram.crm.service.Exception_Exception;
import com.fideuram.exception.crm.DestinatariException;
import com.fideuram.exception.ws.CrmException;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.puc.service.impl.DettaglioAnagraficaVO;
import com.fideuram.puc.service.impl.InfoPolizzaVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.puc.service.impl.StampeServiceImpl;

import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 11/10/11
 * Time: 9.30
 */
public class DaoDestinatariLettera {

    protected StampeServiceImpl pucS;

    public DaoDestinatariLettera(StampeServiceImpl pucS) {
        this.pucS = pucS;
    }

    public IPersona getContranteCollettiva(String numeroCollettiva) throws DestinatariException {
        try {
            DettaglioAnagraficaVO anagraficaVO =pucS.getContraenteByCollettivaID(numeroCollettiva);
            IPersona p = new Contraente();
            p.setDenominazione(anagraficaVO.getRagioneSociale(),"");
            p.setIndirizzo(anagraficaVO.getIndirizzo(),anagraficaVO.getComune(),anagraficaVO.getCap(),anagraficaVO.getProvincia());
            return p;
        } catch (ServiceException_Exception e) {
            throw new DestinatariException("Errore dal PUC-WS in getContraenteByCollettivaID(" + numeroCollettiva + ")", e);
        }
    }


    public InfoPolizzaVO getPolizzaVO(String numeroPolizza) throws DestinatariException{
        try {
            return pucS.getDatiPolizzaByPolizza(new Long(numeroPolizza));
        } catch (ServiceException_Exception e) {
            throw new DestinatariException("Errore dal PUC-WS in getDatiPolizzaByPolizza(" + numeroPolizza + ")", e);
        }
    }

    public List<DettaglioAnagraficaVO> getAnagrafichePolizza(String numeroPolizza) throws DestinatariException{
        try {
            return pucS.listAnagraficheByPolizza(new Long(numeroPolizza));
        } catch (ServiceException_Exception e) {
            throw new DestinatariException("Errore dal PUC-WS in getAnagrafichePolizza(" + numeroPolizza + ")", e);
        }
    }

    public DettaglioAnagraficaVO getAnagraficaByCF(String cf) throws DestinatariException{
        if((cf!=null)&&(!cf.trim().equalsIgnoreCase(""))){
            try {
                return pucS.getAnagraficaByIdentificativoFiscale(cf);
            } catch (ServiceException_Exception e) {
               throw new  DestinatariException("Errore dal PUC in ricerca del seguente CF : "+cf);
            }
        }else{
            throw new  DestinatariException("DaoDestinatariLettera.getAnagraficaByCF - cf non valido");
        }
    }






}
