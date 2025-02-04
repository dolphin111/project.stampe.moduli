package com.fideuram.stampe.bean.riscatto;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.stampe.bean.anagrafica.Beneficiario;

import java.util.Date;

/**
 * Created by V801068 on 30/04/14.
 */
public abstract class Riscatto {
    private   Beneficiario beneficiario;
    private   String       numeroPratica;
    protected Double       importoLiquidazioneNetta;
    protected Double       controvaloreRiscattato;
    protected Date         dataRiferimentoNAV;
    protected Date         dataPresuntoPagamento;
    protected Date         dataValutaLiquidazione;

    public    String       getNumeroPratica() {return numeroPratica;}
    public    Beneficiario getBeneficiario() {
      return beneficiario;
    }

    public String       getDataRiferimentoNAV() {
        return dataRiferimentoNAV!=null?FormatterFactory.getStandardDate(dataRiferimentoNAV):" DA RIEMPIRE ";
    }

    public String       getImportoLiquidazioneNetta() {
        return importoLiquidazioneNetta!=null?FormatterFactory.getStandardImporto(importoLiquidazioneNetta):"";
    }

    public String       getDataPresuntoPagamento() {
        return dataPresuntoPagamento!=null?FormatterFactory.getStandardDate(dataPresuntoPagamento):"";
    }

    public String       getDataValutaLiquidazione() {
        return dataValutaLiquidazione!=null?FormatterFactory.getStandardDate(dataValutaLiquidazione):"";
    }

    public String       getControvaloreRiscattato() {
        return controvaloreRiscattato!=null?FormatterFactory.getStandardImporto(controvaloreRiscattato):"";
    }

    public abstract boolean soCosaTiDevoEQuando();

    public void setBeneficiario(Beneficiario beneficiario) {this.beneficiario = beneficiario;}
    public void setDataRiferimentoNAV(Date dataRiferimentoNAV) {this.dataRiferimentoNAV = dataRiferimentoNAV;}
    public void setNumeroPratica(String numeroPratica) {this.numeroPratica = numeroPratica;}
    public void setImportoLiquidazioneNetta(Double importoLiquidazioneNetta) { this.importoLiquidazioneNetta = importoLiquidazioneNetta;}
    public void setDataPresuntoPagamento(Date dataPresuntoPagamento) {this.dataPresuntoPagamento = dataPresuntoPagamento;}
    public void setControvaloreRiscattato(Double controvaloreRiscattato) {this.controvaloreRiscattato = controvaloreRiscattato;}
    public void setDataValutaLiquidazione(Date dataValutaLiquidazione) {
        this.dataValutaLiquidazione = dataValutaLiquidazione;
    }

    public abstract String getDescrizioneTipoRiscatto();


}
