package com.fideuram.stampe.modello.previdenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by V801068 on 04/06/14.
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class Documentazione {
    private boolean sollecito;
    private boolean ultimoSollecito;
    private List<String> docIntegrativa;
    private List<String> docIntegrativaAderente;

    public List<String> getDocIntgrativa() {
        return docIntegrativa!=null?docIntegrativa:new ArrayList<String>();
    }

    public List<String> getDocIntegrativaAderente() {
        return docIntegrativaAderente!=null?docIntegrativaAderente:new ArrayList<String>();
    }

    public boolean isSollecito() {
        return sollecito;
    }

    public void setSollecito(boolean sollecito) {
        this.sollecito = sollecito;
    }

    public boolean isUltimoSollecito() {
        return ultimoSollecito;
    }

    public void setUltimoSollecito(boolean ultimoSollecito) {
        this.ultimoSollecito = ultimoSollecito;
    }

    public void addDocIntegrativa(String doc){
        if(null==docIntegrativa)
            docIntegrativa=new ArrayList<String>();
        docIntegrativa.add(doc);
    }

    public void addDocIntegrativaAderente(String doc){
        if(null==docIntegrativaAderente)
            docIntegrativaAderente=new ArrayList<String>();
        docIntegrativaAderente.add(doc);
    }



    public void setDocIntgrativa(List<String> docIntgrativa) {
        this.docIntegrativa = docIntgrativa;
    }

    public void setDocIntegrativaAderente(List<String> docIntegrativaAderente) {
        this.docIntegrativaAderente = docIntegrativaAderente;
    }
}
