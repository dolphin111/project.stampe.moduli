package com.fideuram.stampe.modello.variazioneBeneficiario;

import com.fideuram.stampe.modello.contraenza.AppendiceCC;

/**
 * Created by V801068 on 20/05/14.
 */
public class CopiaAppendiceVB {
    private AppendiceVB appendiceVB;
    private String descrizioneCopia;

    public CopiaAppendiceVB(AppendiceVB appendiceVB, String descrizioneCopia) {
        this.appendiceVB = appendiceVB;
        this.descrizioneCopia = descrizioneCopia;
    }

    public AppendiceVB getAppendiceVB() {
        return appendiceVB;
    }

    public String getDescrizioneCopia() {
        return descrizioneCopia;
    }
}
