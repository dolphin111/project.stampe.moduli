package com.fideuram.request.controllers;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.GeneratoreBase;

import java.util.ArrayList;
import java.util.List;

/**
 * User: v801068
 * Date: 05/11/14
 * Time: 17.21
 */
public abstract class AbstractSintetico extends ControllerOffertaBase{

    protected List<byte[]> avviaProcesso(GeneratoreBase generatore, int processo) throws ProspettoDiOffertaException {
        PubblicazioneConsob p = loadDati(processo);
        List<byte[]> pdfs=new ArrayList<byte[]>();

        byte[] pdf = stampaParteX(p, 1,generatore);
        pdf = addPiedino(pdf,generatore.getClass().getSimpleName()+"-SINTETICO.pdf", false);
        pdfs.add(pdf);//PARTE 1

        sendPDFListToPuc(pdfs, processo);
        clearTempDirectory(dir);
        return pdfs;
    }
}
