package com.fideuram.stampe.domande;

import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.stampe.dao.DaoException;

/**
 * Created with
 * User: v801068
 * Date: 09/12/13
 * Time: 15.25
 */
public interface IDomanda {
    public void configuraPolizza(Polizza p) throws DaoException;
}
