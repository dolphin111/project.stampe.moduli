package com.fideuram.stampe.modello.rendiconti;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created
 * User: V801068
 * Date: 08/01/14
 * Time: 14.28
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Ter {
    private Integer anno;
    private Double  ter;
    private Double  commGestione;
    private Double  terOicrSottostanti;
    private Double  speseRevisioneCertificataFondo;
    private Double  spesePubblicazioneQuota;
    private Double  costoGaranziaCasoMorte;
    private Double  speseAmministrazione;
    private Double  speseLegali;
    private Double  altriOneri;
    private Double  totale;
    private Double  percCompravendita;

    public String getAnno() {
        if(null==anno)
            return "---";
        return anno.toString();
    }

    public String getPercCompravendita() {
        if(null==percCompravendita)
            return "---";
        return FormattatorePerc.percentualeNonStandard(percCompravendita, ".", ",", 3, true);
    }

    public String getTer() {
        if(null==ter)
            return "---";
        return FormattatorePerc.percentualeNonStandard(ter, ".", ",",3,true);
    }

    public String getCommGestione() {
        if(null==commGestione)
            return "---";
        return FormattatorePerc.percentualeNonStandard(commGestione, ".", ",",3,true);
    }

    public String getTerOicrSottostanti() {
        if(null==terOicrSottostanti)
            return "---";
        return FormattatorePerc.percentualeNonStandard(terOicrSottostanti, ".", ",",3,true);
    }

    public String getSpeseAmministrazione() {
        if(null==speseAmministrazione)
            return "---";
        return FormattatorePerc.percentualeNonStandard(speseAmministrazione, ".", ",",3,true);
    }

    public String getTotale() {
        if(null==totale)
            return "---";
        return FormattatorePerc.percentualeNonStandard(totale, ".", ",",3,true);
    }

    public String getSpeseLegali() {
        if(null==speseLegali)
            return "---";
        return FormattatorePerc.percentualeNonStandard(speseLegali, ".", ",",3,true);
    }

    public String getSpeseRevisioneCertificataFondo() {
        if(null==speseRevisioneCertificataFondo)
            return "---";
        return FormattatorePerc.percentualeNonStandard(speseRevisioneCertificataFondo, ".", ",",3,true);
    }

    public String getSpesePubblicazioneQuota() {
        if(null==spesePubblicazioneQuota)
            return "---";
        return FormattatorePerc.percentualeNonStandard(spesePubblicazioneQuota, ".", ",",3,true);
    }

    public String getCostoGaranziaCasoMorte() {
        if(null==costoGaranziaCasoMorte)
            return "---";
        return FormattatorePerc.percentualeNonStandard(costoGaranziaCasoMorte, ".", ",",3,true);
    }

    public String getAltriOneri() {
        if(null==altriOneri)
            return "---";
        return FormattatorePerc.percentualeNonStandard(altriOneri, ".", ",",3,true);
    }

    public void setAnno(Integer anno) {
        this.anno = anno;
    }

    public void setTer(Double ter) {
        this.ter = ter;
    }

    public void setCommGestione(Double commGestione) {
        this.commGestione = commGestione;
    }

    public void setTerOicrSottostanti(Double terOicrSottostanti) {
        this.terOicrSottostanti = terOicrSottostanti;
    }

    public void setSpeseRevisioneCertificataFondo(Double speseRevisioneCertificataFondo) {
        this.speseRevisioneCertificataFondo = speseRevisioneCertificataFondo;
    }

    public void setSpesePubblicazioneQuota(Double spesePubblicazioneQuota) {
        this.spesePubblicazioneQuota = spesePubblicazioneQuota;
    }

    public void setCostoGaranziaCasoMorte(Double costoGaranziaCasoMorte) {
        this.costoGaranziaCasoMorte = costoGaranziaCasoMorte;
    }

    public void setSpeseAmministrazione(Double speseAmministrazione) {
        this.speseAmministrazione = speseAmministrazione;
    }

    public void setSpeseLegali(Double speseLegali) {
        this.speseLegali = speseLegali;
    }

    public void setTotale(Double totale) {
        this.totale = totale;
    }

    public void setPercCompravendita(Double percCompravendita) {
        this.percCompravendita = percCompravendita;
    }

    public void setAltriOneri(Double altriOneri) {
        this.altriOneri = altriOneri;
    }
}
