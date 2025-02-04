package com.fideuram.request.controllers;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.FVInsieme;
import com.fideuram.processo.prospetti.FvFacilePerNoi;
import com.fideuram.processo.prospetti.GeneratoreBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: v801068
 * Date: 05/11/14
 * Time: 15.27
 */
public class ControllerOffertaFvFacilePerNoi extends AbstractSintetico {
    /**
     * Genera il prospetto completo
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
   /* public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException {
        PubblicazioneConsob p = loadDati(57);

        List<byte[]> pdfs=new ArrayList<byte[]>();
        GeneratoreBase generatoreFVInsieme= new FvFacilePerNoi(dir);

        byte[] parte1 = stampaParteX(p, 1,generatoreFVInsieme);
        parte1 = addPiedino(parte1,"FvFacilePerNoi-SINTETICO.pdf");
        pdfs.add(parte1);


        sendPDFListToPuc(pdfs, 57);
        clearTempDirectory(dir);
        return pdfs;
    }*/

    public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException, WebServiceClientException {
        return this.avviaProcesso(new FvFacilePerNoi(dir),57);
    }

    /**
     * Genera solo il supplemento del prospetto
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcessoSupplemento() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(570);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        //GeneratoreBase generatoreFVInsieme= new FvFacilePerNoi(dir);
        GeneratoreBase generatoreFVInsieme= new FvFacilePerNoi(dir);

        byte[] supplemento = stampaParteX(p, 4, generatoreFVInsieme);
        supplemento = addPiedino(supplemento,"FVFacilePerNoi-SUPPLEMENTO-Sintetico.pdf", false);
        pdfs.add(supplemento);//SUPPLEMENTO

        sendPDFListToPuc(pdfs, 570);
        clearTempDirectory(dir);
        return pdfs;
    }
}
