package com.fideuram.request.controllers;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.FvPrivatePerNoi;
import com.fideuram.processo.prospetti.FviPrivateMixPerNoi;
import com.fideuram.processo.prospetti.GeneratoreBase;

import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 25/03/15
 * Time: 14.57
 */
public class ControllerOffertaPrivateMixPerNoi  extends AbstractSintetico{
	
    public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException, WebServiceClientException {
        return this.avviaProcesso(new FviPrivateMixPerNoi(dir),59);
    }
    
    public List<byte[]> avviaProcessoSupplemento() throws ProspettoDiOffertaException, WebServiceClientException {
    	PubblicazioneConsob p = loadDati(590);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        GeneratoreBase generatoreFVPrivate= new FviPrivateMixPerNoi(dir);

        byte[] supplemento = stampaParteX(p, 4, generatoreFVPrivate);
        supplemento = addPiedino(supplemento,"FVPrivateMix-SUPPLEMENTO-Sintetico.pdf", false);
        pdfs.add(supplemento);//SUPPLEMENTO

        sendPDFListToPuc(pdfs, 59);
        clearTempDirectory(dir);
        return pdfs;
    }
    
}
