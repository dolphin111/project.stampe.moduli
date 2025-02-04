package com.fideuram.crm.stampe.engine.dataLoader;

import com.fideuram.crm.stampe.engine.modello.bean.Polizza;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.puc.service.impl.DettaglioAnagraficaVO;
import com.fideuram.puc.service.impl.InfoPolizzaVO;
import com.fideuram.utils.LoggingUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 28/07/11
 * Time: 10.53
 */
public class AnagraficaLoader {

    /**
     * Questo metodo aggiunge al HashMap base i dati anagrafici relativi alla polizza  già caricata.
     * Prerequisito: il map in ingresso deve già contenere una Polizza valida
     * @param map
     * @return HashMap
     * @throws DocGeneratorException
     */
    public HashMap recuperaAnagrafica(HashMap map) throws DocGeneratorException {
        
    	Polizza polizza = (Polizza) map.get("polizza");
        InfoPolizza localizzatore = new InfoPolizza();
        InfoPolizzaVO _polizzaVo = localizzatore.getPolizzaByPolizza(new Long(polizza.getId()));

        polizza = Inseminatore.mashUpPolizza(polizza, _polizzaVo);

        List<DettaglioAnagraficaVO> anagrafiche = _polizzaVo.getAnagrafiche();//localizzatore.getListAnagraficheByPolizza(new Long(polizza.getId()));
        try {
            polizza = Inseminatore.mashUpPersona(anagrafiche, polizza);
        } catch (InvocationTargetException e) {
            LoggingUtils.error(e);
            //todo lancia DicGenerator
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            //todo lancia DicGenerator
        }
        map.put("polizza", polizza);
        
        return map;
    }
}
