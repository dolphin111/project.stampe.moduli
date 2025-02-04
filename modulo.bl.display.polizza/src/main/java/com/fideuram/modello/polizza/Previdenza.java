package com.fideuram.modello.polizza;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.polizza.previdenza.BeneficiariMorte;
import com.fideuram.modello.polizza.previdenza.MovimentiEventiPrevidenza;
import com.fideuram.modello.polizza.previdenza.RiepilogoPrevidenza;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 09/04/13
 * Time: 18.46
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Previdenza {
    private Double                      importoContributi;
    private Double                      importoAnticipazione;
    private Double                      valorePosizioneIndividuale;
    private Double                      contributiNonDedotti;
    private Date                        dataIngressoSistemaPrevidenziale;
    private Date                        dataAdesioneFondo;
    private Date                        dataUltimoSwitch;
    private RiepilogoPrevidenza         riepilogoPrevidenza;
    private MovimentiEventiPrevidenza   movimentiEventiPrevidenza;
    private String                      beneficiarioVita="";
    private BeneficiariMorte            beneficiariMorte;

    public BeneficiariMorte getBeneficiariMorte() {
        return beneficiariMorte!=null?beneficiariMorte:new BeneficiariMorte();
    }

    public String getBeneficiarioVita() {
        return beneficiarioVita;
    }

    public RiepilogoPrevidenza getRiepilogoPrevidenza() {
        return riepilogoPrevidenza;
    }

    public MovimentiEventiPrevidenza getMovimentiEventiPrevidenza() {
        return movimentiEventiPrevidenza;
    }

    public String getImportoContributi() {
        return FormatterFactory.getStandardImporto(importoContributi);
    }

    public String getImportoAnticipazione() {
        return FormatterFactory.getStandardImporto(importoAnticipazione);
    }

    public String getValorePosizioneIndividuale() {
        return FormatterFactory.getStandardImporto(valorePosizioneIndividuale);
    }

    public String getContributiNonDedotti() {
        return FormatterFactory.getStandardImporto(contributiNonDedotti);
    }

    public String getDataIngressoSistemaPrevidenziale() {
        if(null==dataIngressoSistemaPrevidenziale)
            return "";
        else
            return FormatterFactory.getStandardDate(dataIngressoSistemaPrevidenziale);
    }

    public String getDataAdesioneFondo() {
        return FormatterFactory.getStandardDate(dataAdesioneFondo);
    }

    public String getDataUltimoSwitch() {
        if(null==dataUltimoSwitch)
            return "";
        else
            return FormatterFactory.getStandardDate(dataUltimoSwitch);
    }


}
