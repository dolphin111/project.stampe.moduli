package com.fideuram.stampe.bean.simulatori;

/**
 * User: V801068
 * Date: 17/11/15
 * Time: 17.53
 */
public class Simulazione {
    private ValoreAllaData valoreAllaData;

    public ValoreAllaData getValoreAllaData() {
        return valoreAllaData!=null?valoreAllaData:new ValoreAllaData();
    }

    public void setValoreAllaData(ValoreAllaData valoreAllaData) {
        this.valoreAllaData = valoreAllaData;
    }
}
