package com.fideuram.stampe.dao.tronconi;

import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.TronconeVO;
import com.fideuram.stampe.modello.comunicazionecrm.TronconiCrm;
import com.fideuram.utils.LoggingUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: V801068
 * Date: 01/09/14
 * Time: 15.36
 */
public class TronconiManagaer {

    public TronconiCrm getTronconi(List<TronconeVO> tronconeVOs){
        TronconiCrm t=new TronconiCrm();

        for(int i=0;i<tronconeVOs.size();i++) {
             TronconeVO vo= tronconeVOs.get(i);
             t.addTroncone(vo.getID(),vo.getFrase());
        }
        return t;
    }

    public Map<String, String>  getMapTronconi(String prodotto, List<TronconeVO> tronconeVOs){

        Map<String, String> tronconi = new HashMap<String, String>();
        for (TronconeVO t :tronconeVOs) {
            if(null!=t.getNomeTroncone()&&null!=t.getFrase()){
                tronconi.put(t.getNomeTroncone(), t.getFrase());
            }
        }

        if ("90".equals(prodotto))
            return getMappaProdotto90(tronconi);
        else
            return tronconi;

    }


    /**
     * Creato per feature 40
     * @param tronconi
     * @return
     */
    private Map<String, String> getMappaProdotto90(Map<String, String> tronconi){
        LoggingUtils.info("OKKIO:: Sto mofificando i tronconi per i prodotti 90...>>> feature 40 <<<");
        replace(tronconi,"SituazPremiTotalePremi","lordi","netti");
        replace(tronconi,"SituazPremiTotalePremiDataLiquidazione","lordi","netti");
        replace(tronconi,"SituazPremiTotalePremiPrecedenteTrasformata","lordi","netti");
        replace(tronconi,"SituazPremiTotalePremiTrasformata","lordi","netti");
        replace(tronconi,"SituazPremiTotalePremiDataFineDiff","lordi","netti");

        return tronconi;
    }

    private void replace(Map<String, String> tronconi, String key, String oldCharSeq, String newCharSeq){
        if(tronconi.containsKey(key))
            tronconi.put(key,tronconi.get(key).replace(oldCharSeq,newCharSeq));
    }



}
