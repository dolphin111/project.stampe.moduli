package com.fideuram.graficiservice.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 13/11/12
 * Time: 15.00
 */
public class Risposta implements Serializable {
    private boolean esito;
    private String  transactionID;
    //private byte[]  stream;
    private String  streamBase64;
    private String  streamType;
    private List<byte[]> streams;



    public void setEsito(boolean esito) {
        this.esito = esito;
    }

    public void setStreamType(String streamType) {
        this.streamType = streamType;
    }

    public void setTransactionID(String transactionID) {
        this.transactionID = transactionID;
    }

    public boolean isEsito() {
        return esito;
    }


    public String getStreamType() {
        return streamType;
    }

    public String getTransactionID() {
        return transactionID;
    }

    public String getStreamBase64() {
        return streamBase64;
    }

    public void setStreamBase64(String streamBase64) {
        this.streamBase64 = streamBase64;
    }

    public List<byte[]> getStreams() {
        return streams;
    }

    public void setStreams(List<byte[]> streams) {
        this.streams = streams;
    }
}
