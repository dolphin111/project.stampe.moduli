package com.fideuram.request.controllers;


import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.FvInsiemePerNoi;
import com.fideuram.processo.prospetti.FvInsiemePrivate;
import com.fideuram.processo.prospetti.FvPrivatePerNoi;
import com.fideuram.processo.prospetti.GeneratoreBase;

import java.util.ArrayList;
import java.util.List;

/**
 * User: v801068
 * Date: 05/11/14
 * Time: 15.27
 */
public class ControllerOffertaFvPrivatePerNoi extends AbstractSintetico {
    /*public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException, WebServiceClientException {
        PubblicazioneConsob p = loadDati(54);
        //p.setNomeProdotto("Fideuram Vita Insieme Private");
        List<byte[]> pdfs=new ArrayList<byte[]>();
        GeneratoreBase generatore= new FvPrivatePerNoi(dir);

        byte[] pdf = stampaParteX(p, 1,generatore);
        pdf = addPiedino(pdf,"FvPrivatePerNoi-SINTETICO.pdf");
        pdfs.add(pdf);//PARTE 1

        sendPDFListToPuc(pdfs, 54);
        clearTempDirectory(dir);
        return pdfs;
    }*/


    public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException, WebServiceClientException {
        return this.avviaProcesso(new FvPrivatePerNoi(dir),54);
    }

    /**
     * Genera solo il supplemento del prospetto
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcessoSupplemento() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(540);
        p.setNotaIvass();
        List<byte[]> pdfs=new ArrayList<byte[]>();
        GeneratoreBase generatoreFVPrivate= new FvPrivatePerNoi(dir);

        byte[] supplemento = stampaParteX(p, 4, generatoreFVPrivate);
        supplemento = addPiedino(supplemento,"FVPrivatePerNoi-SUPPLEMENTO-Sintetico.pdf", false);
        pdfs.add(supplemento);//SUPPLEMENTO

        sendPDFListToPuc(pdfs, 540);
        clearTempDirectory(dir);
        return pdfs;
    }
}
