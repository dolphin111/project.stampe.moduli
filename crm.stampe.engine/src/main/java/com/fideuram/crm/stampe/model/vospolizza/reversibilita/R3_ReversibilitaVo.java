package com.fideuram.crm.stampe.model.vospolizza.reversibilita;

/**
 * Created by
 * User: logan
 * Date: 07/12/11
 * Time: 10.48
 */
public class R3_ReversibilitaVo {



    public String getTesta() {
        return testa;
    }

    public void setTesta(String testa) {
        this.testa = testa;
        if("M".equalsIgnoreCase(testa)){
            labelNato="nato";
            labelSesso="maschile";
        }else{
            labelNato="nata";
            labelSesso="femminile";
        }
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getPercentualeReversibilita() {
        return percentualeReversibilita;
    }

    public void setPercentualeReversibilita(String percentualeReversibilita) {
        this.percentualeReversibilita = percentualeReversibilita;
    }

    public String getValoreReversibilita() {
        return valoreReversibilita;
    }

    public void setValoreReversibilita(String valoreReversibilita) {
        this.valoreReversibilita = valoreReversibilita;
    }

    public String getDataRiferimento() {
        return dataRiferimento;
    }

    public void setDataRiferimento(String dataRiferimento) {
        this.dataRiferimento = dataRiferimento;
    }

    public String getLabelNato() {
        return labelNato;
    }

     public String getLabelSesso() {
        return labelSesso;
    }

    private String testa                        ="-";
    private String dataNascita                  ="";
    private String percentualeReversibilita     ="-";
    private String valoreReversibilita          ="-";
    private String dataRiferimento              ="";
    private String labelNato                    ="";
    private String labelSesso                   ="";
    private Boolean isSecondaTesta              =false;
}
