package com.fideuram.soa.sync.asset.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Created by
 * User: logan
 * Date: 29/03/12
 * Time: 14.42
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class CompartoAzioni implements Serializable {

    private String tipo;                //Azionario || Obbligazionario || ....
    private String comparto;            // EQ.GLOBAL E MKTS ||...
    private String percentuale;
    private String valore;              //DI COSA???
    private String fondoInvestimento;   //Fap  2012-2013
    private String subTotalePerc="-1";
    private String subTotaleVal ="-1";

    public boolean hasSubTotale(){
        if(!subTotalePerc.equalsIgnoreCase("-1")||!subTotaleVal.equalsIgnoreCase("-1"))
            return true;
        return false;
    }

    public boolean isValoreNotZero(){
        if(!valore.equals("0"))
            return true;
        return false;
    }

    public boolean isSubTotaleValNotZero(){
        if(!subTotaleVal.equals("0,00"))
            return true;
        return false;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;

    }

    public String getComparto() {
        return comparto;
    }

    public void setComparto(String comparto) {
        this.comparto = comparto;
    }

    public String getPercentuale() {
        return percentuale;
    }

    public void setPercentuale(String percentuale) {
        this.percentuale = percentuale;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public String getFondoInvestimento() {
        return fondoInvestimento;
    }

    public void setFondoInvestimento(String fondoInvestimento) {
        this.fondoInvestimento = fondoInvestimento;
    }

    public String getSubTotalePerc() {
        return subTotalePerc;
    }

    public void setSubTotalePerc(String subTotalePerc) {
        this.subTotalePerc = subTotalePerc;
    }

    public String getSubTotaleVal() {
        return subTotaleVal;
    }

    public void setSubTotaleVal(String subTotaleVal) {
        this.subTotaleVal = subTotaleVal;
    }
}
