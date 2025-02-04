package com.fideuram.stampe.modello.variazioneBeneficiario;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by V801068 on 14/05/14.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class CausaleVB {
    public static int VARIAZIONE_BENEFICIARIO_PER_SURVIAL=0;
    public static int VARIAZIONE_BENEFICIARIO_PER_DECESSO=1;


    private int causale=0;

    public int getCausale() {
        return causale;
    }

    public String getDescrizioneCausale() {
        switch (causale){
            case 1:
                return "per decesso";
            default:
                return "";
        }
    }
    public String getAppellattivoCausale() {
        switch (causale){
            case 1:
                return "EREDI DI";
            default:
                return "GENTILE CLIENTE";
        }
    }

    public String getDescrizioneRichiesta() {
        switch (causale){
            case 1:
                return "di decesso del contraente";
            default:
                return "richiesta di variazione di contraenza";
        }
    }
    /**
     * Indicare la causale del cambio di contraenza.
     * Es: setCaudale(CausaleCC.CAMBIO_CONTRAENZA_PER_DECESSO)
     * @param causale
     */
    public void setCausale(int causale) {
        this.causale = causale;
    }

    public boolean isDecesso(){
        if (causale==1)
            return true;
        return false;
    }
}
