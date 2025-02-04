package com.fideuram.modello.tbd;

import java.io.Serializable;

/**
 * Created by 
 * User: logan
 * Date: 28/06/12
 * Time: 10.15
 */
public class ClasseBonus implements Serializable {
    private String  classe;                          //"C" || "D"
    private Integer anniAlTermine;                   //5, 10 ....
    private Float   percentualeBonusAttribuito;      //20,85%

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Integer getAnniAlTermine() {
        return anniAlTermine;
    }

    public void setAnniAlTermine(Integer anniAlTermine) {
        this.anniAlTermine = anniAlTermine;
    }

    public Float getPercentualeBonusAttribuito() {
        return percentualeBonusAttribuito;
    }

    public void setPercentualeBonusAttribuito(Float percentualeBonusAttribuito) {
        this.percentualeBonusAttribuito = percentualeBonusAttribuito;
    }

    public ClasseBonus(String classe, Integer anniAlTermine, Float percentualeBonusAttribuito) {
        this.classe = classe;
        this.anniAlTermine = anniAlTermine;
        this.percentualeBonusAttribuito = percentualeBonusAttribuito;
    }
}
