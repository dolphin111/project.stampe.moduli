package com.fideuram.stampe.modello.rendiconti;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created
 * User: v801068
 * Date: 29/01/14
 * Time: 19.46
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class CostiGlobali {
    private Integer anno;
    private Double  caricamento;
    private Double  gestioneDiretta;

    public String getAnno() {
        if(null==anno)
            return "";
        return anno.toString();
    }

    public String getCaricamento() {
        return FormattatorePerc.percentualeStandard(caricamento, true);
    }

    public String getGestioneDiretta() {
        return FormattatorePerc.percentualeStandard(caricamento, true);
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public void setGestioneDiretta(Double gestioneDiretta) {
        this.gestioneDiretta = gestioneDiretta;
    }

    public void setCaricamento(Double caricamento) {
        this.caricamento = caricamento;
    }

}
