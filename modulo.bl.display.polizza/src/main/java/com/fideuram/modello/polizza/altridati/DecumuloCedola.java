package com.fideuram.modello.polizza.altridati;

import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 16/04/13
 * Time: 16.12
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class DecumuloCedola {
    private Boolean attivo;
    private DettagliDecumolo dettagliDecumolo;
    public Boolean getAttivo() {
        return attivo;
    }

    public DettagliDecumolo getDettagli() {
        return dettagliDecumolo!=null?dettagliDecumolo:new DettagliDecumolo();
    }

    @Override
    public String toString() {
        LoggingUtils.info("Rel 2.0 di DecumuloCedola");
        if(null==dettagliDecumolo)  //Se null==dettagli non interessa che  attivo==true. Potrebbe trattarsi del fatto che universo non invia o non possiede i dettagli
            return "NO";
        if(attivo)
            return "SI";
        else
            return "NO";


    }

    public boolean isCedola(){
        return dettagliDecumolo!=null?true:false;
    }
}
