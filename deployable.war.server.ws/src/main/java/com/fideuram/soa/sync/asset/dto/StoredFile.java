package com.fideuram.soa.sync.asset.dto;

import com.fideuram.iside.IsideResponce;

import java.io.Serializable;

/**
 * Created by
 * User: logan
 * Date: 30/03/12
 * Time: 12.32
 */
@Deprecated
public class StoredFile implements Serializable {
    private String idDocument;
    private String nomeDoc;
    private String mimetype;

    public StoredFile(String idDocument, String nomeDoc, String mimetype) {
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
