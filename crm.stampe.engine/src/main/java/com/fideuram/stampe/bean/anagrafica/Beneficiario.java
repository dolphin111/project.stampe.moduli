package com.fideuram.stampe.bean.anagrafica;

/**
 * Created by V801068 on 05/05/14.
 */
public class Beneficiario {
    private String anagraficaID;
    private String beneficiario;
    private String iban;

    public String getAnagraficaID() { return anagraficaID; }
    public String getBeneficiario() {
        return beneficiario;
    }
    public String getIban() {return iban!=null?iban:"";}

    public void setAnagraficaID(String anagraficaID) {
        this.anagraficaID = anagraficaID;
    }
    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }
    public void setIban(String ibanBeneficiario) {this.iban = ibanBeneficiario;}

    @Override
    public String toString() {
        return beneficiario;
    }
}
