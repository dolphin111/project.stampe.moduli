package com.fideuram.stampe.domande;

import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.stampe.bean.simulatori.Simulazione;
import com.fideuram.stampe.dao.PucDao;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 17/11/15
 * Time: 18.27
 */
public class D1010ValorePolizzaAllaData extends DomandaBase{

    public D1010ValorePolizzaAllaData(int comID) {
        super(comID);
    }

    public void configuraPolizza(Polizza polizza,DomandaVO domandaVO) throws DomandaException{
        try {
            Simulazione simulazione=new Simulazione();
            simulazione.setValoreAllaData(new PucDao(comID).getValoreAllaDataByPolizza(polizza.getNumero(), domandaVO));
            polizza.setSimulazione(simulazione);
        } catch (PucException e) {
            throw new DomandaException(e);
        } catch (WebServiceClientException e) {
            throw new DomandaException(e);
        }
    }
}
