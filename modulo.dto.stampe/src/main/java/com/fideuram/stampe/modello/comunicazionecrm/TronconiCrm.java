package com.fideuram.stampe.modello.comunicazionecrm;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 01/09/14
 * Time: 15.04
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class TronconiCrm {
    private List<TronconeCrm> tronconi;


    public void addTroncone(int id, String frase){
          isListaInizializzata();
          tronconi.add(new TronconeCrm(id,frase));
    }

    /**
     * Restituisce il Troncone ricercato se esiste altrimenti null
     * @param id
     * @return
     */
    public TronconeCrm getTronconeById(int id){
        isListaInizializzata();
        for(int i=0; i<tronconi.size();i++){
            TronconeCrm t=tronconi.get(i);
            if(t.getId()==id)
                return t;
        }
        return null;
    }

    private void isListaInizializzata(){
        if(null==tronconi)
            tronconi=new ArrayList<TronconeCrm>();
    }



}
