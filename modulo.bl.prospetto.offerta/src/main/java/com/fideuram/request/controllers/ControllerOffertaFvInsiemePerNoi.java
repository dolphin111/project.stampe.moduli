package com.fideuram.request.controllers;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.*;

import java.util.ArrayList;
import java.util.List;

/**
 * User: v801068
 * Date: 05/11/14
 * Time: 15.26
 */
public class ControllerOffertaFvInsiemePerNoi extends AbstractSintetico {
    /**
     * Genera il prospetto completo
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */



    public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException, WebServiceClientException {
        return this.avviaProcesso(new FvInsiemePerNoi(dir),19);
    }

    /**
     * Genera solo il supplemento del prospetto
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcessoSupplemento() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(190);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        GeneratoreBase generatoreFVInsieme= new FvInsiemePerNoi(dir);

        byte[] supplemento = stampaParteX(p, 4, generatoreFVInsieme);
        supplemento = addPiedino(supplemento,"FVInsiemePerNoi-SUPPLEMENTO-Sintetico.pdf", false);
        pdfs.add(supplemento);//SUPPLEMENTO

        sendPDFListToPuc(pdfs, 190);
        clearTempDirectory(dir);
        return pdfs;
    }
}
