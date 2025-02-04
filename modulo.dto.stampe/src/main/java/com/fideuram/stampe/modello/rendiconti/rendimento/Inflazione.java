package com.fideuram.stampe.modello.rendiconti.rendimento;

import com.fideuram.stampe.modello.utils.FormattatoreCifre;
import com.fideuram.stampe.modello.utils.FormattatorePerc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created
 * User: v801068
 * Date: 29/01/14
 * Time: 11.48
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Inflazione {
    private Double mediaInflazioneUlt3anni;
    private Double mediaInflazioneUlt5anni;
    private Double mediaInflazioneUlt10anni;

    public String getMediaInflazioneUlt3anni() {
        return  FormattatorePerc.percentualeStandard(mediaInflazioneUlt3anni, true);
    }

    public String getMediaInflazioneUlt5anni() {
        return  FormattatorePerc.percentualeStandard(mediaInflazioneUlt5anni, true);
    }

    public String getMediaInflazioneUlt10anni() {
        return  FormattatorePerc.percentualeStandard(mediaInflazioneUlt10anni,true);
    }



    public void setMediaInflazioneUlt3anni(Double mediaInflazioneUlt3anni) {
        this.mediaInflazioneUlt3anni = mediaInflazioneUlt3anni;
    }

    public void setMediaInflazioneUlt5anni(Double mediaInflazioneUlt5anni) {
        this.mediaInflazioneUlt5anni = mediaInflazioneUlt5anni;
    }

    public void setMediaInflazioneUlt10anni(Double mediaInflazioneUlt10anni) {
        this.mediaInflazioneUlt10anni = mediaInflazioneUlt10anni;
    }
}
