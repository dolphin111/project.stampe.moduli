package com.fideuram.stampe.domande;

import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.stampe.bean.anagrafica.Beneficiario;
import com.fideuram.stampe.bean.riscatto.Riscatto;
import com.fideuram.stampe.bean.riscatto.RiscattoParziale;
import com.fideuram.stampe.bean.riscatto.RiscattoTotale;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PucDao;
import com.fideuram.stampe.exception.ValidationException;

/**
 * Created by V801068 on 02/05/14.
 */
public class D916RiscattoParziale extends DomandaBase implements IDomanda {

    public D916RiscattoParziale(int comID) {
        super(comID);
    }

    @Override
    public void configuraPolizza(Polizza p) throws DaoException {
        try {
            p.setRiscattoParziale((RiscattoParziale) new PucDao(comID).getRiscattoByPolizza(Long.decode(p.getNumero()), false));
            testValidazione(p.getRiscattoParziale().getBeneficiario());
        } catch (WebServiceClientException e) {
            throw new DaoException(e);
        } catch (PucException e) {
            throw new DaoException(e);
        } catch (ValidationException e) {
            throw new DaoException(e);
        }
    }

    private void testValidazione(Beneficiario beneficiario) throws ValidationException{
        String messaggio="Validazione Beneficiario non superata: \n";
        boolean eccezioneDirompente=false;
        if(beneficiario.getBeneficiario()==null){
            eccezioneDirompente=true;
            messaggio=messaggio+" - Il nome beneficiario non può essere null \n";
        }
        if(beneficiario.getIban()==null){
            eccezioneDirompente=true;
            messaggio=messaggio+" - Iban non può essere null \n";
        }
        if (eccezioneDirompente)
            throw new ValidationException(messaggio);

    }

}
