package com.fideuram.dao;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.modello.polizza.variazioni.Variazione;
import com.fideuram.modello.polizza.variazioni.VariazioniContrattuali;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.puc.service.impl.VariazioniContrattualiVO;

import java.util.List;

/**
 * User: V801068
 * Date: 23/02/15
 * Time: 10.23
 */
public class PucDao {
    StampeServiceImpl puc = null;
    public VariazioniContrattuali getVariazioniContrattuali(String polizza) throws WebServiceClientException, ServiceException_Exception {
         VariazioniContrattuali variazioniContrattuali= new VariazioniContrattuali();

         puc=ClientWsFactory.getInstance().getPucClient();
         List<VariazioniContrattualiVO> vS = puc.listvariazioniContrattualiPendingByPolizza(polizza);
         for(int i=0; i<vS.size();i++){
             VariazioniContrattualiVO v = vS.get(i);
             Variazione variazione=new Variazione();
             variazione.setDataScadenzaInVigore( v.getDateScadenzaInVigore().toGregorianCalendar().getTime());
             variazione.setDataNuovaScadenza(v.getDateScadenzaNew().toGregorianCalendar().getTime());
             variazione.setDataEffetto(v.getDateEffetto().toGregorianCalendar().getTime()) ;
             variazione.setTipoAttivita( v.getTipoAttivita());
             variazione.setTipoDifferimento(v.getTipoDifferimento());
             variazione.setTipoFrazionamentoPremio(v.getTipoFrazionamentoPremio());
             variazioniContrattuali.addVariazioni(variazione);
         }

        return variazioniContrattuali;
    }
}
