package com.fideuram.stampe.bean.simulatori;

import com.fideuram.factory.FormatterFactory;

import java.util.Date;

/**
 * Date: 17/11/15
 * Time: 17.55
 */
public class ValoreAllaData {

    private Date   dataRiferimento;
    private Double valore;

    public ValoreAllaData(Date dataRiferimento, Double valore) {
        this.dataRiferimento = dataRiferimento;
        this.valore = valore;
    }

    public ValoreAllaData() {}

    public String getDataRiferimento() {
        return dataRiferimento!=null?FormatterFactory.getStandardDate(dataRiferimento):"";
    }

    public String getValore() {
        return valore!=null?FormatterFactory.getStandardImporto(valore):"";
    }
}
