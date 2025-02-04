package com.fideuram.stampe.modello.previdenza.versamenti;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 15.44
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class DatoreLavoro {
    private int    totaleDipendenti;
    private Contributi contributiTotali;
    private List<Lavoratore> lavoratori;

    public int getTotaleDipendenti() {
        return totaleDipendenti;
    }

    public void setTotaleDipendenti(int totaleDipendenti) {
        this.totaleDipendenti = totaleDipendenti;
    }

    public Contributi getContributiTotali() {
        return contributiTotali!=null?contributiTotali:new Contributi();
    }

    public void setContributiTotali(Contributi contributiTotali) {
        this.contributiTotali = contributiTotali;
    }

    public List<Lavoratore> getLavoratori() {
        return lavoratori!=null?lavoratori:new ArrayList<Lavoratore>();
    }

    public void setLavoratori(List<Lavoratore> lavoratori) {
        this.lavoratori = lavoratori;
    }

    public void addLavoratore(Lavoratore l){
        if(lavoratori==null)
            lavoratori=new ArrayList<Lavoratore>();
        lavoratori.add(l);
    }
}
