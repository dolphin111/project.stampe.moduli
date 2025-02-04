package com.fideuram.stampe.modello.richiestaFacta;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.fideuram.stampe.modello.attori.Individuo;

/**
 * Created by V801068 on 14/05/14.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Documento {

    private String        numeroID;
    private Individuo     assicurato;
    private Individuo     pb;
    

	public String getNumeroID() {
        return numeroID;
    }


    public Individuo getAssicurato() {
    	 return assicurato!=null?assicurato:new Individuo();
    }

    public Individuo getPb() {
        return pb;
    }

    public boolean hasPb(){
        if(null==pb)
          return false;
        else if(null==pb.getCognome()||pb.getCognome().trim().equals(""))
          return false;
        else
          return true;
    }

    public void setNumeroID(String numeroID) {
        this.numeroID = numeroID;
    }


    public void setAssicurato(Individuo assicurato) {
        this.assicurato = assicurato;
    }


    public void setPb(Individuo pb) {
        this.pb = pb;
    }

}
