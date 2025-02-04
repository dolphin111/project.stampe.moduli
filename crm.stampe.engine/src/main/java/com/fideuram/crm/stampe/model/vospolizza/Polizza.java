package com.fideuram.crm.stampe.model.vospolizza;

import com.fideuram.crm.stampe.model.vospolizza.prestazioni.IPrestazioni;
import com.fideuram.crm.stampe.model.vospolizza.rendita.IIpotesiRendita;
import com.fideuram.crm.stampe.model.vospolizza.reversibilita.IReversibilita;

/**
 * Created by
 * User: logan
 * Date: 29/12/11
 * Time: 9.52
 */
public abstract class Polizza {
    private String tipoPolizza;
    private IPrestazioni prestazioni;
    private IReversibilita reversibilita;
    private IIpotesiRendita ipotesiRendita;

    public IPrestazioni getPrestazioni() {
        return prestazioni;
    }

    public void setPrestazioni(IPrestazioni prestazioni) {
        this.prestazioni = prestazioni;
    }

    public IReversibilita getReversibilita() {
        return reversibilita;
    }

    public void setReversibilita(IReversibilita reversibilita) {
        this.reversibilita = reversibilita;
    }

    public IIpotesiRendita getIpotesiRendita() {
        return ipotesiRendita;
    }

    public void setIpotesiRendita(IIpotesiRendita ipotesiRendita) {
        this.ipotesiRendita = ipotesiRendita;
    }

    public abstract  String getTipoPolizza();
}
