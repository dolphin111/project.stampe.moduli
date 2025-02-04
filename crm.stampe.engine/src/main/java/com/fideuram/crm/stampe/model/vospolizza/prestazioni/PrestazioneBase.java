package com.fideuram.crm.stampe.model.vospolizza.prestazioni;

import com.fideuram.costanti.Costanti;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by
 * User: logan
 * Date: 23/12/11
 * Time: 10.47
 */
public abstract class PrestazioneBase implements IPrestazioni{
    private String dataRiferimentoNav           ="";
    private String numeroQuote                  ="";
    private String controvaloreQuote            ="";
    private String ipotesiValRiscattoScadenza   ="";
    private String catenaccio                   ="";
    private Long   differimento                 =new Long(0);



    public void setDataRiferimentoNav(XMLGregorianCalendar dataRiferimentoNav) {
        this.dataRiferimentoNav = ((dataRiferimentoNav!=null)?
                        DateUtils.formatDate(dataRiferimentoNav, Costanti.FORMATO_DATA):"");
    }

    public void setNumeroQuote(Double numeroQuote) {
        this.numeroQuote =  ((numeroQuote!=null)? NumberUtils.formatCurrency(numeroQuote,Costanti.SEPARATORE_MIGLIAIA,Costanti.SEPARATORE_DECIMALI):"");
    }

    public void setControvaloreQuote(Double controvaloreQuote) {
        this.controvaloreQuote =  ((controvaloreQuote!=null)?
                        NumberUtils.formatCurrency(controvaloreQuote,Costanti.SEPARATORE_MIGLIAIA,Costanti.SEPARATORE_DECIMALI):"");
    }

    public void setIpotesiValRiscattoScadenza(Double ipotesiValRiscattoScadenza) {
        this.ipotesiValRiscattoScadenza =  ((ipotesiValRiscattoScadenza!=null)?
                        NumberUtils.formatCurrency(ipotesiValRiscattoScadenza, Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI):"");
    }

    public String getDataRiferimentoNav() {
        return dataRiferimentoNav!=null?dataRiferimentoNav:"";
    }

    public String getIpotesiValRiscattoScadenza() {
        return ipotesiValRiscattoScadenza;
    }

     public String getNumeroQuote() {
        return numeroQuote;
    }

    public String getControvaloreQuote() {
        return controvaloreQuote;
    }

    public String getCatenaccio() {
        return catenaccio;
    }

    public void setCatenaccio(String catenaccio) {
        this.catenaccio = catenaccio;
    }

    public Long getDifferimento() {
        return differimento;
    }

    public void setDifferimento(Long differimento) {
        this.differimento = differimento;
    }

    public abstract String getTipoPrestazione();

    public abstract String getDescrizionePrestazione();

}
