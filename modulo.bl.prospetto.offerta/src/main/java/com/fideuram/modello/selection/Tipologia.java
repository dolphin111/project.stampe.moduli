package com.fideuram.modello.selection;

import java.io.Serializable;

/**
 * Created by 
 * User: logan
 * Date: 15/06/12
 * Time: 11.38
 */
public class Tipologia implements Serializable {
    private String disclaimer;
    private String gestione;
    private String obiettivo;
    private String valuta;
    private String qualifica = "---";

    public Tipologia(String gestione, String obiettivo, String valuta, String qualifica, String disclaimer) {
        this.gestione = gestione;
        this.obiettivo = obiettivo;
        this.valuta = valuta;
        this.qualifica = qualifica;
        this.disclaimer= disclaimer;
    }

    public boolean hasDisclaimer(){
        return !disclaimer.trim().equals("")?true:false;
    }

    public String getDisclaimer() {
        return disclaimer;
    }


    public String getGestione() {
        return gestione;
    }

    public String getObiettivo() {
        return obiettivo;
    }

    public String getValuta() {
        return valuta;
    }

    public String getQualifica() {
    	if("".equals(qualifica) || null == qualifica)
    		return "---";
        return qualifica;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public void setGestione(String gestione) {
        this.gestione = gestione;
    }

    public void setObiettivo(String obiettivo) {
        this.obiettivo = obiettivo;
    }
}
