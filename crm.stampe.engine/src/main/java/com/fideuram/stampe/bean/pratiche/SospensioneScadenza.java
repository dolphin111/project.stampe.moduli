package com.fideuram.stampe.bean.pratiche;

import com.fideuram.costanti.Costanti;
import com.fideuram.utils.DateUtils;

import java.text.ParseException;
import java.util.Calendar;

/**
 * User: V801068
 * Date: 06/10/14
 * Time: 11.09
 */
public class SospensioneScadenza {
    boolean existPratica;
    Long numeroPolizza;
    Calendar richiesta;
    Calendar scadenza;

    public SospensioneScadenza(Long numeroPolizza) {
        this.numeroPolizza = numeroPolizza;
        this.existPratica = false;
    }

    public SospensioneScadenza(String dataRichiesta, String dataScadenza,Long numeroPolizza)throws ParseException  {
        this.numeroPolizza=numeroPolizza;
        this.setRichiesta(dataRichiesta);
        this.setScadenza(dataScadenza);
        this.existPratica = true;
    }

    private void setRichiesta(String dataRichiesta) throws ParseException {
        richiesta = Calendar.getInstance();
        richiesta.setTime(DateUtils.getDate(dataRichiesta, Costanti.FORMATO_DATA));
    }

    private void setScadenza(String dataScadenza) throws ParseException {
        scadenza = Calendar.getInstance();
        scadenza.setTime(DateUtils.getDate(dataScadenza, Costanti.FORMATO_DATA));
    }

    public String getRichiestaToString() {
        return DateUtils.formatDate(richiesta,Costanti.FORMATO_DATA);
    }

    public String getScadenzaToString() {
        return DateUtils.formatDate(scadenza,Costanti.FORMATO_DATA);
    }

    public int getPreavvisoInAnni(){
        return scadenza.get(Calendar.YEAR) - richiesta.get(Calendar.YEAR);
    }

    public double getPreavvisoInGiorni(){
       return DateUtils.dateDiff(richiesta.getTime(),scadenza.getTime(),Calendar.DAY_OF_YEAR);
    }

    public Long getNumeroPolizza() {
        return numeroPolizza;
    }

    public boolean isExistPratica() {
        return existPratica;
    }
}
