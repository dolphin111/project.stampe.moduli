package com.fideuram.stampe.domande;

import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.stampe.bean.riscatto.RiscattoTotale;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PucDao;

/**
 * Created by V801068 on 02/05/14.
 */
public class D915RiscattoTotale extends DomandaBase implements IDomanda{
    public D915RiscattoTotale(int comID) {
        super(comID);
    }

    @Override
    public void configuraPolizza(Polizza p) throws DaoException {
        try {
            p.setRiscattoTotale((RiscattoTotale) new PucDao(comID).getRiscattoByPolizza(Long.decode(p.getNumero()), true));
        } catch (WebServiceClientException e) {
            throw new DaoException(e);
        } catch (PucException e) {
            throw new DaoException(e);
        }
    }
}
