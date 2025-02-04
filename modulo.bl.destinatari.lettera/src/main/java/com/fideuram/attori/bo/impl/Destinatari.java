package com.fideuram.attori.bo.impl;

import com.fideuram.attori.bo.IPersona;
import com.fideuram.exception.crm.DestinatariException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 06/10/11
 * Time: 10.22
 */
public class Destinatari {
    private IPersona proponente;
    private IPersona richiedente;
    private boolean  isReclamante;
    private List<IPersona> perConoscenza;

    public IPersona getProponente() {
        return proponente;
    }

    public void setProponente(IPersona proponente) {
        this.proponente = proponente;
    }

    public IPersona getRichiedente() {
        return richiedente;
    }



    public void setRichiedente(IPersona richiedente) throws DestinatariException {
        if(proponente!=null){
         if(!richiedente.getDenominazione().equalsIgnoreCase(proponente.getDenominazione())){
           this.richiedente = richiedente;
         }
        } else{
          throw new DestinatariException("Il Proponente deve già essere valorizzato");
        }
        return;
    }

    public boolean isReclamante() {
        return isReclamante;
    }


    public List<IPersona> getPerConoscenza() {
        return perConoscenza;
    }

    public void setPerConoscenza(List<IPersona> perConoscenza) {
        this.perConoscenza = perConoscenza;
    }

    public void addPerConoscenza(IPersona perConoscenza) {
        if(this.perConoscenza==null){
            this.perConoscenza= new ArrayList();
        }
        this.perConoscenza.add(perConoscenza);
    }
}
