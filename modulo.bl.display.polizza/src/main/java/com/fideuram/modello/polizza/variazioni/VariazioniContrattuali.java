package com.fideuram.modello.polizza.variazioni;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

/**
 * User: V801068
 * Date: 23/02/15
 * Time: 15.56
 */
@XmlType(name="VariazioniContrattuali")
public class VariazioniContrattuali {
    private boolean contrattoVariato;
    private List<Variazione>    variazioni;

    public boolean isContrattoVariato() {
        return contrattoVariato;
    }

    public List<Variazione> getVariazioni() {
        return variazioni;
    }

    public void setVariazioni(List<Variazione> variazioni) {
        if(variazioni.size()>0)
            contrattoVariato=true;
        this.variazioni = variazioni;
    }

    public void addVariazioni(Variazione v) {
        if(v!=null){
            contrattoVariato=true;
            if(variazioni==null){variazioni=new ArrayList<Variazione>();}
            variazioni.add(v);
        }
    }
}
