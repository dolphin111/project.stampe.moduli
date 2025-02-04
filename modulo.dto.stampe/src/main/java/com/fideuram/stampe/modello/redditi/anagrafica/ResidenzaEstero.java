package com.fideuram.stampe.modello.redditi.anagrafica;

/**
 * User: V801068
 * Date: 21/01/15
 * Time: 11.06
 */
public class ResidenzaEstero {

    protected String   cfEstero;
    protected String   localita;
    protected String   viaenumero;
    protected String   codiceStatoEstero;
    protected String   shumacker;

    public String getShumacker() {
        return shumacker!=null?shumacker:"";
    }

    public String getCfEstero() {
        return cfEstero!=null?cfEstero:"";
    }

    public void setCfEstero(String cfEstero) {
        this.cfEstero = cfEstero;
    }

    public String getLocalita() {
        return localita!=null?localita:"";
    }

    public void setLocalita(String localita) {
        this.localita = localita;
    }

    public String getViaenumero() {
        return viaenumero!=null?viaenumero:"";
    }

    public void setViaenumero(String viaenumero) {
        this.viaenumero = viaenumero;
    }

    public String getCodiceStatoEstero() {
        return codiceStatoEstero!=null?codiceStatoEstero:"";
    }

    public void setCodiceStatoEstero(String codiceStatoEstero){
        this.codiceStatoEstero = codiceStatoEstero;
    }

    public void setShumacker(String shumacker) {
        this.shumacker = shumacker;
    }
}
