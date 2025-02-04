package com.fideuram.request.controllers;

import java.util.ArrayList;
import java.util.List;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.FvInsiemePrivate;
import com.fideuram.processo.prospetti.GeneratoreBase;

/**
 * Created by
 * User: logan
 * Date: 13/03/13
 * Time: 10.08
 */
public class ControllerOffertaFviPrivate extends ControllerOffertaBase {
    public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException, WebServiceClientException {
       PubblicazioneConsob p = loadDati(53);
       //p.setNomeProdotto("Fideuram Vita Insieme Private");
       List<byte[]> pdfs=new ArrayList<byte[]>();
       GeneratoreBase generatore= new FvInsiemePrivate(dir);

       byte[] pdf = stampaParteX(p, 1,generatore);
       pdf = addPiedino(pdf,"FvPrivate.pdf", false);
       pdfs.add(pdf);//PARTE 1

       sendPDFListToPuc(pdfs, 53);
       clearTempDirectory(dir);
       return pdfs;
    }


    /**
     * Genera solo il supplemento del prospetto
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcessoSupplemento() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(530);
        p.setNotaIvass();
        List<byte[]> pdfs=new ArrayList<byte[]>();
        GeneratoreBase generatore= new FvInsiemePrivate(dir);
        byte[] supplemento = stampaParteX(p, 4, generatore);
        supplemento = addPiedino(supplemento,"FV-Private-SUPPLEMENTO-Sintetico.pdf", false);
        pdfs.add(supplemento);//SUPPLEMENTO
        sendPDFListToPuc(pdfs, 530);
        clearTempDirectory(dir);
        return pdfs;
    }

    public static void main(String args[]){
        try {
            //new  ControllerOffertaFviPrivate().avviaProcesso();
            new ControllerOffertaFviPrivate().avviaProcessoSupplemento();
        } catch (ProspettoDiOffertaException e) {
            e.printStackTrace();
        }
    }

}


