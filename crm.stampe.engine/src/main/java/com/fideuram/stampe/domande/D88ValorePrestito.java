package com.fideuram.stampe.domande;

import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PucDao;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 09/12/13
 * Time: 15.10
 *
 * TRIPLETTA B51
 */
public class D88ValorePrestito  extends DomandaBase implements IDomanda{
    public D88ValorePrestito(int comID) {
        super(comID);
    }

    @Override
    public void configuraPolizza(Polizza p) throws DaoException {
        try {
            p.setValorePrestito(new PucDao(comID).getPresstitoByPolizza(Long.decode(p.getNumero())));
        } catch (WebServiceClientException e) {
            throw new DaoException(e);
        } catch (PucException e) {
            throw new DaoException(e);
        }
    }
}
