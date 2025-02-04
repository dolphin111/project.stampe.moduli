package com.fideuram.stampe.modello.redditi.d2016;

import com.fideuram.stampe.modello.redditi.CudBase;
import com.fideuram.stampe.modello.redditi.d2016.annotazioni.Annotazioni;
import com.fideuram.stampe.modello.redditi.d2016.datiprevidenziali.DatiPrevidenziali;
import com.fideuram.stampe.modello.redditi.d2016.datifiscali.DatiFiscali;
import com.fideuram.stampe.modello.redditi.d2016.redditidiversi.GestioneSeparata;
import com.fideuram.stampe.modello.rendiconti.Gestione;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 04/01/16
 * Time: 17.50
 */
@XmlRootElement(name="CUD2016")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cud2016 extends CudBase {
    private String progressivoCertificazione;
    private DatiFiscali datiFiscali;
    private DatiPrevidenziali datiPrevidenziali;
    private GestioneSeparata gestioneSeparata;
    private Annotazioni annotazioni;

    public Cud2016() {
        this.annoFiscale="2015";
    }

    public String getProgressivoCertificazione() {
        return progressivoCertificazione;
    }

    public void setProgressivoCertificazione(String progressivoCertificazione) {
        this.progressivoCertificazione = progressivoCertificazione;
    }

    public DatiFiscali getDatiFiscali() {
        return datiFiscali;
    }

    public void setDatiFiscali(DatiFiscali datiFiscali) {
        this.datiFiscali = datiFiscali;
    }

    public DatiPrevidenziali getDatiPrevidenziali() {
        return datiPrevidenziali;
    }

    public void setDatiPrevidenziali(DatiPrevidenziali datiPrevidenziali) {
        this.datiPrevidenziali = datiPrevidenziali;
    }

    public GestioneSeparata getGestioneSeparata() {
        return gestioneSeparata;
    }

    public void setGestioneSeparata(GestioneSeparata gestioneSeparata) {
        this.gestioneSeparata = gestioneSeparata;
    }

    public Annotazioni getAnnotazioni() {
        return annotazioni!=null?annotazioni:new Annotazioni();
    }

    public void setAnnotazioni(Annotazioni annotazioni) {
        this.annotazioni = annotazioni;
    }
}
