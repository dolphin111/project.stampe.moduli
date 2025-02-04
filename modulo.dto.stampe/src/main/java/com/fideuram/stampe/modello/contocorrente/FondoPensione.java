package com.fideuram.stampe.modello.contocorrente;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 23/06/14
 * Time: 10.47
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class FondoPensione extends ContoCorrente{
    private String denominazione;
    private String iscrizioneAlbo;
    private String gestioneAmmVa;
    private String tipologia;
    private String causaleBonificoInEntrata;

    public String getDenominazione() {
        return denominazione;
    }

    public String getIscrizioneAlbo() {
        return iscrizioneAlbo;
    }

    public String getGestioneAmmVa() {
        return gestioneAmmVa;
    }

    public String getTipologia() {
        return tipologia;
    }

    public String getCausaleBonificoInEntrata() {
        return causaleBonificoInEntrata;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public void setGestioneAmmVa(String gestioneAmmVa) {
        this.gestioneAmmVa = gestioneAmmVa;
    }

    public void setIscrizioneAlbo(String iscrizioneAlbo) {
        this.iscrizioneAlbo = iscrizioneAlbo;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public void setCausaleBonificoInEntrata(String causaleBonificoInEntrata) {
        this.causaleBonificoInEntrata = causaleBonificoInEntrata;
    }
}
