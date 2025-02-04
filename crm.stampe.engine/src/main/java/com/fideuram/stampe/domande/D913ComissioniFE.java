package com.fideuram.stampe.domande;

import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PucDao;

/**
 * Created
 * User: v801068
 * Date: 27/11/13
 * Time: 15.17
 *
 * TRIPLETTA F15
 */
public class D913ComissioniFE extends DomandaBase implements IDomanda{

    public D913ComissioniFE(int comID) {
        super(comID);
    }

    public void configuraPolizza(Polizza p) throws DaoException {
        try {
            p.setCommissioniFondiEsterni(new PucDao(comID).getCommissioniFondiEsperniByPolizza(Long.decode(p.getNumero())));
        } catch (WebServiceClientException e) {
            throw new DaoException(e);
        } catch (PucException e) {
            throw new DaoException(e);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
