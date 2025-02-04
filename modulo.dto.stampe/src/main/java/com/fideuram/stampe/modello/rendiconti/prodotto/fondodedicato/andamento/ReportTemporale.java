package com.fideuram.stampe.modello.rendiconti.prodotto.fondodedicato.andamento;

import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * User: v801068
 * Date: 06/11/14
 * Time: 19.07
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class ReportTemporale {
    private Double mese1;
    private Double mese3;
    private Double mese6;
    private Double mese12;
    private Double daInizioAnno;
    private Double daInizioFondo;
    private Double YTD;
    private Double dataInPtf;

    public String getMese1() {
        return FormattatorePerc.percentualeStandardNDnoZero(mese1, true);
    }

    public String getMese3() {
        return FormattatorePerc.percentualeStandardNDnoZero(mese3, true);
    }

    public String getMese6() {
        return FormattatorePerc.percentualeStandardNDnoZero(mese6, true);
    }

    public String getMese12() {
        return FormattatorePerc.percentualeStandardNDnoZero(mese12, true);
    }

    public String getDaInizioAnno() {
        return FormattatorePerc.percentualeStandardNDnoZero(daInizioAnno, true);
    }

    public String getDaInizioFondo() {
        return FormattatorePerc.percentualeStandardNDnoZero(daInizioFondo, true);
    }

    public String getYTD() {
        return FormattatorePerc.percentualeStandardNDnoZero(YTD, true);
    }

    public String getDataInPtf() {
        return FormattatorePerc.percentualeStandardNDnoZero(dataInPtf, true);
    }

    public void setMese1(Double mese1) {
        this.mese1 = mese1;
    }

    public void setMese3(Double mese3) {
        this.mese3 = mese3;
    }

    public void setMese6(Double mese6) {
        this.mese6 = mese6;
    }

    public void setMese12(Double mese12) {
        this.mese12 = mese12;
    }

    public void setDaInizioAnno(Double daInizioAnno) {
        this.daInizioAnno = daInizioAnno;
    }

    public void setDaInizioFondo(Double daInizioFondo) {
        this.daInizioFondo = daInizioFondo;
    }

    public void setYTD(Double YTD) {
        this.YTD = YTD;
    }

    public void setDataInPtf(Double dataInPtf) {
        this.dataInPtf = dataInPtf;
    }
}
