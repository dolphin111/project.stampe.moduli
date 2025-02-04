package com.fideuram.stampe.domande;

import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.stampe.dao.DaoException;

/**
 * User: V801068
 * Date: 22/07/14
 * Time: 15.03
 */
public class ControllerDiPolizza {
    private int comID;
    public ControllerDiPolizza(int comID) {
        this.comID = comID;
    }

    //public void configuraDomanda(int domanda, Polizza polizza) throws DomandaException {
    public void configuraDomanda(DomandaVO domanda, Polizza polizza) throws DomandaException {
        try{
            switch (domanda.getDescrizioneDomandaOriginaleId()){
                case(88):  //nuova tripletta 88  - Valore Prestito            - id template 305
                    new D88ValorePrestito(comID).configuraPolizza(polizza);
                    break;
                case(958):
                    break;
                case(913): //nuova tripletta 913 - Commissioni Fondi Esterni  - id template 304
                    new D913ComissioniFE(comID).configuraPolizza(polizza);
                    break;
                case(915): //Riscatto Totale
                    new D915RiscattoTotale(comID).configuraPolizza(polizza);
                    break;
                case(916): //Riscatto Parziale
                    new D916RiscattoParziale(comID).configuraPolizza(polizza);
                    break;
                case(951): //Scadenza
                    new D951Scadenza(comID).configuraPolizza(polizza);
                    break;
                case(952): //Scadenza periodica
                    new D952ScadenzaPeriodica(comID).configuraPolizza(polizza);
                    break;
                case(953): //Sinistro a Scadenza
                    new D953SinistroAScadenza(comID).configuraPolizza(polizza);
                    break;
                case(1010):
                    new D1010ValorePolizzaAllaData(comID).configuraPolizza(polizza,domanda);
                    break;
                default:
                    throw new DomandaException();
            }
        }catch (DaoException e){
            throw new DomandaException(e);
        }
    }
}
