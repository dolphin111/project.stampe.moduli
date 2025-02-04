package com.fideuram.stampe.modello.redditi.d2015;


import com.fideuram.stampe.modello.redditi.CudBase;
import com.fideuram.stampe.modello.redditi.d2015.datifiscali.DatiFiscali;
import com.fideuram.stampe.modello.redditi.d2015.datiprevidenziali.DatiPrevidenziali;
import com.fideuram.stampe.modello.redditi.d2015.redditidiversi.LavoroAutonomo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: V801068
 * Date: 18/11/14
 * Time: 17.16
 */
@XmlRootElement(name="CUD2015")
@XmlAccessorType(XmlAccessType.FIELD)
public class Cud2015 extends CudBase {
    private String progressivoCertificazione;
    private DatiFiscali         datiFiscali;
    private DatiPrevidenziali   datiPrevidenziali;
    private LavoroAutonomo      lavoroAutonomo;


    public Cud2015() {
        this.annoFiscale="2014";
    }


    public String getProgressivoCertificazione() {
        return progressivoCertificazione;
    }

    public DatiFiscali getDatiFiscali() {
        return datiFiscali!=null?datiFiscali:new DatiFiscali();
    }

    public DatiPrevidenziali getDatiPrevidenziali() {
        return datiPrevidenziali!=null?datiPrevidenziali:new DatiPrevidenziali();
    }

    public LavoroAutonomo getLavoroAutonomo() {
        return lavoroAutonomo!=null?lavoroAutonomo:new LavoroAutonomo();
    }

    public void setProgressivoCertificazione(String progressivoCertificazione) {
        this.progressivoCertificazione = progressivoCertificazione;
    }

    public void setDatiFiscali(DatiFiscali datiFiscali) {
        this.datiFiscali = datiFiscali;
    }

    public void setDatiPrevidenziali(DatiPrevidenziali datiPrevidenziali) {
        this.datiPrevidenziali = datiPrevidenziali;
    }

    public void setLavoroAutonomo(LavoroAutonomo lavoroAutonomo) {
        this.lavoroAutonomo = lavoroAutonomo;
    }

    @Override
    public String toString() {
        return  "cud"+annoFiscale;
    }
}
