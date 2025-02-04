package com.fideuram.stampe.dao.valoriinputs;

/**
 * User: V801068
 * Date: 01/09/14
 * Time: 17.31
 */
public class InputsBean {
    private String dataRiferimento="";    //usata da: Simulazione alla Data
    private String durataMinima="";
    private String premio = "";
    private String sesso = "";
    private String decumulo = "";
    private String prodotto = "";
    private String dataDecorrenza = "";
    private String renditaAnnua = "";
    private String dataNascita = "";

    public String getDataRiferimento() {
        return dataRiferimento;
    }

    public String getDurataMinima() {
        return !durataMinima.equals("")||durataMinima==null?durataMinima:"10";
    }

    public String getPremio() {
        return premio;
    }

    public String getSesso() {
        return sesso;
    }

    public String getDecumulo() {
        return !decumulo.equals("")||decumulo==null?durataMinima:"0";
    }

    public String getProdotto() {
        return prodotto;
    }

    public String getDataDecorrenza() {
        return dataDecorrenza;
    }

    public String getRenditaAnnua() {
        return !renditaAnnua.equals("")||renditaAnnua==null?renditaAnnua:"0";
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataRiferimento(String dataRiferimento) {
        this.dataRiferimento = dataRiferimento;
    }

    public void setDurataMinima(String durataMinima) {
        this.durataMinima = durataMinima;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public void setDecumulo(String decumulo) {
        this.decumulo = decumulo;
    }

    public void setProdotto(String prodotto) {
        this.prodotto = prodotto;
    }

    public void setDataDecorrenza(String dataDecorrenza) {
        this.dataDecorrenza = dataDecorrenza;
    }

    public void setRenditaAnnua(String renditaAnnua) {
        this.renditaAnnua = renditaAnnua;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }
}
