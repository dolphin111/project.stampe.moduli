package com.fideuram.stampe.dao;

import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.puc.service.impl.DatiProdottoVO;

/**
 * User: V801068
 * Date: 23/09/14
 * Time: 15.15
 */
public class PolizzaQuery {
    public static int FIDEURAM_VITA_INSIEME=1;
    public static int GARANZIA_E_VALORE=2;

    /**
     * <br>Questo metodo restituisce true se la macrofamiglia della polizza
     * <br>corrisponde alla tipologia richiesta
     * <br>ES di uso:
     *       isMacroFamigliaMatch(polizza, PolizzaQuery.GARANZIA_E_VALORE)
     * @param polizza
     * @param famiglia
     * @return
     */
    public static boolean isMacroFamigliaMatch(Polizza polizza, long famiglia){
        return polizza.getMacroFamiglia()==famiglia?true:false;
    }

}
