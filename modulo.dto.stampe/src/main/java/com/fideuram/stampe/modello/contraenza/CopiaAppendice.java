package com.fideuram.stampe.modello.contraenza;

/**
 * Created by V801068 on 20/05/14.
 */
public class CopiaAppendice {
    private AppendiceCC appendiceCC;
    private String descrizioneCopia;

    public CopiaAppendice(AppendiceCC appendiceCC, String descrizioneCopia) {
        this.appendiceCC = appendiceCC;
        this.descrizioneCopia = descrizioneCopia;
    }

    public AppendiceCC getAppendiceCC() {
        return appendiceCC;
    }

    public String getDescrizioneCopia() {
        return descrizioneCopia;
    }
}
