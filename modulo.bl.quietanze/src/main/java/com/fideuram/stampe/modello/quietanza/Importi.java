package com.fideuram.stampe.modello.quietanza;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by
 * User: logan
 * Date: 14/02/13
 * Time: 17.30
 */
public class Importi {
    private String valoreLordoRendita;
    private String interessiMoratori;
    private String lordo;
    private String imponibileLordoIrpef;
    private String detrazioniReddito;
    private String detrazioniCarichiFamiliari;
    private String impostaIrpef;
    private String addizionaleRegionale;
    private String addizionaleComunaleSaldo;
    private String addizionaleAnticipoComunale;
    private String addizionaleAnniPrecedenti;
    private String imponibileImpostaSostitutiva;
    private String impostaSostitutiva;
    private String imponibileRitenutaImposta;
    private String ritenutaImposta;
    private String nettoCorrisposto;

    public String getValoreLordoRendita() {
        return valoreLordoRendita.trim();
    }

    @XmlElement(name = "VALORELORDORENDITA")
    public void setValoreLordoRendita(String valoreLordoRendita) {
        this.valoreLordoRendita = valoreLordoRendita;
    }

    public String getInteressiMoratori() {
        return interessiMoratori.trim();
    }

    @XmlElement(name = "INTERESSIMORATORI")
    public void setInteressiMoratori(String interessiMoratori) {
        this.interessiMoratori = interessiMoratori;
    }

    public String getLordo() {
        return lordo.trim();
    }

    @XmlElement(name = "LORDO")
    public void setLordo(String lordo) {
        this.lordo = lordo;
    }

    public String getImponibileLordoIrpef() {
        return imponibileLordoIrpef.trim();
    }

    @XmlElement(name = "IMPONIBILELORDOIRPEF")
    public void setImponibileLordoIrpef(String imponibileLordoIrpef) {
        this.imponibileLordoIrpef = imponibileLordoIrpef;
    }

    public String getDetrazioniReddito() {
        return detrazioniReddito.trim();
    }

    @XmlElement(name = "DETRAZIONEREDDITO")
    public void setDetrazioniReddito(String detrazioniReddito) {
        this.detrazioniReddito = detrazioniReddito;
    }

    public String getDetrazioniCarichiFamiliari() {
        return detrazioniCarichiFamiliari.trim();
    }

    @XmlElement(name = "DETRAZIONICARICHIFAMILIARI")
    public void setDetrazioniCarichiFamiliari(String detrazioniCarichiFamiliari) {
        this.detrazioniCarichiFamiliari = detrazioniCarichiFamiliari;
    }

    public String getImpostaIrpef() {
        return impostaIrpef.trim();
    }

    @XmlElement(name = "IMPOSTAIRPEF")
    public void setImpostaIrpef(String impostaIrpef) {
        this.impostaIrpef = impostaIrpef;
    }

    public String getAddizionaleRegionale() {
        return addizionaleRegionale.trim();
    }

    @XmlElement(name = "ADDIZIONALEREGIONALE")
    public void setAddizionaleRegionale(String addizionaleRegionale) {
        this.addizionaleRegionale = addizionaleRegionale;
    }

    public String getAddizionaleComunaleSaldo() {
        return addizionaleComunaleSaldo.trim();
    }

    @XmlElement(name = "ADDIZIONALECOMUNALESALDO")
    public void setAddizionaleComunaleSaldo(String addizionaleComunaleSaldo) {
        this.addizionaleComunaleSaldo = addizionaleComunaleSaldo;
    }

    public String getAddizionaleAnticipoComunale() {
        return addizionaleAnticipoComunale.trim();
    }

    @XmlElement(name = "ADDIZIONALEANTICIPOCOMUNALE")
    public void setAddizionaleAnticipoComunale(String addizionaleAnticipoComunale) {
        this.addizionaleAnticipoComunale = addizionaleAnticipoComunale;
    }

    public String getAddizionaleAnniPrecedenti() {
        return addizionaleAnniPrecedenti.trim();
    }

    @XmlElement(name = "ADDIZIONALEANNIPRECEDENTI")
    public void setAddizionaleAnniPrecedenti(String addizionaleAnniPrecedenti) {
        this.addizionaleAnniPrecedenti = addizionaleAnniPrecedenti;
    }

    public String getImponibileImpostaSostitutiva() {
        return imponibileImpostaSostitutiva.trim();
    }

    @XmlElement(name = "IMPONIBILEIMPOSTASOSTITUTIVA")
    public void setImponibileImpostaSostitutiva(String imponibileImpostaSostitutiva) {
        this.imponibileImpostaSostitutiva = imponibileImpostaSostitutiva;
    }

    public String getImpostaSostitutiva() {
        return impostaSostitutiva.trim();
    }

    @XmlElement(name = "IMPOSTASOSTITUTIVA")
    public void setImpostaSostitutiva(String impostaSostitutiva) {
        this.impostaSostitutiva = impostaSostitutiva;
    }

    public String getImponibileRitenutaImposta() {
        return imponibileRitenutaImposta.trim();
    }

    @XmlElement(name = "IMPONIBILERITENUTAIMPOSTA")
    public void setImponibileRitenutaImposta(String imponibileRitenutaImposta) {
        this.imponibileRitenutaImposta = imponibileRitenutaImposta;
    }

    public String getRitenutaImposta() {
        return ritenutaImposta.trim();
    }

    @XmlElement(name = "RITENUTAIMPOSTA")
    public void setRitenutaImposta(String ritenutaImposta) {
        this.ritenutaImposta = ritenutaImposta;
    }

    public String getNettoCorrisposto() {
        return nettoCorrisposto.trim();
    }

    @XmlElement(name = "NETTOCORRISPOSTO")
    public void setNettoCorrisposto(String nettoCorrisposto) {
        this.nettoCorrisposto = nettoCorrisposto;
    }
}
