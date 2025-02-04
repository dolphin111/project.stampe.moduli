package com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento;

import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * User: v801068
 * Date: 04/11/14
 * Time: 15.24
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Performance {
    private AndamentoGrafico andamentoGrafico;
    private ReportTemporale rendimentoAnnuo;
    private ReportTemporale volatilitaAnnua;
    private Double modifiedDuration;



    public void setAndamentoGrafico(AndamentoGrafico andamentoGrafico) {
        this.andamentoGrafico = andamentoGrafico;
    }

    public void setRendimentoAnnuo(ReportTemporale rendimentoAnnuo) {
        this.rendimentoAnnuo = rendimentoAnnuo;
    }

    public void setVolatilitaAnnua(ReportTemporale volatilitaAnnua) {
        this.volatilitaAnnua = volatilitaAnnua;
    }

    public void setModifiedDuration(Double modifiedDuration) {
        this.modifiedDuration = modifiedDuration;
    }

    public AndamentoGrafico getAndamentoGrafico() {
        return andamentoGrafico;
    }

    public ReportTemporale getVolatilitaAnnua() {
        return volatilitaAnnua;
    }

    public ReportTemporale getRendimentoAnnuo() {
        return rendimentoAnnuo;
    }

    public String getModifiedDuration() {
        return FormattatorePerc.percentualeStandardNDnoZero(modifiedDuration, true);
    }
}
