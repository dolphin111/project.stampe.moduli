package com.fideuram.iside;

import java.io.Serializable;

/**
 * Created by
 * User: logan
 * Date: 11/12/12
 * Time: 11.49
 */
public class IsideResponce implements Serializable {
    private String idDocument;
    private String nomeDoc;
    private String mimetype;

    public IsideResponce(){}

    public IsideResponce(String idDocument, String nomeDoc, String mimetype) {
        this.idDocument = idDocument;
        this.nomeDoc = nomeDoc;
        this.mimetype = mimetype;
    }

    public String getIdDocument() {
        return idDocument;
    }

    public String getNomeDoc() {
        return nomeDoc;
    }

    public String getMimetype() {
        return mimetype;
    }
}
