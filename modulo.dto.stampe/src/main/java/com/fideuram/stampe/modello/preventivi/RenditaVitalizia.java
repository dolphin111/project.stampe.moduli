package com.fideuram.stampe.modello.preventivi;

import com.fideuram.stampe.modello.comunicazionecrm.TronconiCrm;
import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatoreDate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 17/07/14
 * Time: 14.53
 */
@XmlRootElement(name="", namespace="")
@XmlAccessorType(XmlAccessType.FIELD)
public class RenditaVitalizia {
    private Date dataRiferimento;
    private Double renditaAnnua;
    private Double importoRendita;
    private TronconiCrm tronconiCrm;

    public String getDataRiferimento() {
        return FormattatoreDate.formatDate(dataRiferimento, FormattatoreDate.FORMATO_DATA_ITALIANA_CON_SLASH);
    }

    public String getRenditaAnnua() {
        //return renditaAnnua;
        return FormattatoreCifre.formatImporto(renditaAnnua, ".", ",");
    }



    public String getImportoRendita() {
        return FormattatoreCifre.formatImporto(importoRendita, ".", ",");
    }



    public String getDescrizioneRenditaAnnua(int famiglia, boolean isInputPremio){
        //se in input hanno inserito il premio annuo allora vogliono calcolare la rendita
        //se in input hanno inserito la rendita allora vogliono calcolare il premio da versare
        switch (famiglia){
            case 1:
                //return testoRenditaAnnua("55 e 85");
                return isInputPremio?tronconiCrm.getTronconeById(1937).getFrase():tronconiCrm.getTronconeById(1939).getFrase();
            case 2:
                //return testoRenditaAnnua("55 e 90");
                return isInputPremio?tronconiCrm.getTronconeById(1936).getFrase():tronconiCrm.getTronconeById(1938).getFrase();
            default:
                return "";
        }
    }


    public void setTronconiCrm(TronconiCrm tronconiCrm) {
        this.tronconiCrm = tronconiCrm;
    }

    public void setDataRiferimento(Date dataRiferimento) {
        this.dataRiferimento = dataRiferimento;
    }

    public void setRenditaAnnua(Double renditaAnnua) {
        this.renditaAnnua = renditaAnnua;
    }

    public void setImportoRendita(String importoRendita) {
        this.importoRendita = Double.valueOf(importoRendita);
    }

    public void setImportoRendita(Double importoRendita) {
        this.importoRendita = importoRendita;
    }

   /* public boolean hasRendita(){
        if(importoRendita!=null&&importoRendita>0)
            return true;
        return false;
    }*/

    public boolean hasRenditaAnnua(){
        if(renditaAnnua!=null&&renditaAnnua>0)
            return true;
        return false;
    }

    /**
     * tck 853
     * @return
     */
    public String isConcedibile(){
        if (hasRenditaAnnua() && renditaAnnua <3000.00)
            return "(IN QUESTO CASO NON CONCEDIBILE)";
        else
            return "";
    }
}
