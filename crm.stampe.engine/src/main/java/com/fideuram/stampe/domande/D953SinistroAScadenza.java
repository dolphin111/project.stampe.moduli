package com.fideuram.stampe.domande;

import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.stampe.bean.riscatto.Scadenza;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PucDao;

/**
 * Created by V801098 on 20/09/16.
 */
public class D953SinistroAScadenza extends DomandaBase implements IDomanda{
    public D953SinistroAScadenza(int comID) {
        super(comID);
    }

    @Override
    public void configuraPolizza(Polizza p) throws DaoException {
        try {
            p.setScadenza((Scadenza) new PucDao(comID).getSinistroAScadenza(Long.decode(p.getNumero())));
        } catch (WebServiceClientException e) {
            throw new DaoException(e);
        } catch (PucException e) {
            throw new DaoException(e);
        }
    }
}
