package com.fideuram.request.controllers;

import java.util.ArrayList;
import java.util.List;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.FvInsiemeFacile;
import com.fideuram.processo.prospetti.FvInsiemePremium44;
import com.fideuram.processo.prospetti.GeneratoreBase;

/**
 * Created by
 * User: logan
 * Date: 13/03/13
 * Time: 15.06
 */
public class ControllerOffertaFviPremium44 extends ControllerOffertaBase {

    public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException {
        PubblicazioneConsob p = loadDati(56);
        //p.setNomeProdotto("Fideuram Vita Insieme Premium 4+4");
        List<byte[]> pdfs = new ArrayList<byte[]>();
        GeneratoreBase generatoreFvPremium = new FvInsiemePremium44(dir);

        byte[] parte2 = stampaParteX(p, 2, generatoreFvPremium);
        parte2 = addPiedino(parte2, "FvInsiemePremium44-PARTE-II.pdf", false);
        pdfs.add(parte2);//PARTE 2

        int posProposteInvestimento = 0;
        for(int i = 0 ;i < p.getSelectionFunds().size() ; i++){
        	if(p.getSelectionFunds().get(i).isPropostaInvestimento()){
        		posProposteInvestimento = i;
        	}
        }
        p.getSelectionFunds().remove(posProposteInvestimento);//tolgo le proposte di investimento perchè su parte I e III non devono essere stampate
        //p.getSelectionFunds().remove(0);
        
        byte[] parte1 = stampaParteX(p, 1, generatoreFvPremium);
        parte1 = addPiedino(parte1, "FvInsiemePremium44-PARTE-I.pdf", false);
        pdfs.add(parte1);//PARTE 1

        byte[] parte3 = stampaParteX(p, 3, generatoreFvPremium);
        parte3 = addPiedino(parte3, "FvInsiemePremium44-PARTE-III.pdf", false);
        pdfs.add(parte3);//PARTE 3

        sendPDFListToPuc(pdfs, 56);
        clearTempDirectory(dir);
        return pdfs;
    }

    /**
     * Genera solo il supplemento del prospetto
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcessoSupplemento() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(560);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        GeneratoreBase generatore= new FvInsiemePremium44(dir);
        p.getSelectionFunds().remove(3);
        p.getSelectionFunds().remove(0);
        byte[] supplemento = stampaParteX(p, 4, generatore);
        supplemento = addPiedino(supplemento,"FV-Premium44-SUPPLEMENTO.pdf", false);
        pdfs.add(supplemento);//SUPPLEMENTO
        sendPDFListToPuc(pdfs, 560);
        clearTempDirectory(dir);
        return pdfs;
    }

    public List<byte[]> avviaProcessoRendiconto() throws ProspettoDiOffertaException {
        PubblicazioneConsob p = loadDati(561);
        p.setNomeProdotto("Fideuram Vita Insieme Premium 4+4");
        List<byte[]> pdfs = new ArrayList<byte[]>();
        GeneratoreBase generatore = new FvInsiemeFacile(dir);
        p.getSelectionFunds().remove(p.getSelectionFunds().size() -1); //tolgo le proposte di investimento
        byte[] rendiconto = stampaParteX(p, 5, generatore);
        rendiconto = addPiedino(rendiconto, "FvPremium44-RENDICONTO.pdf", false);
        pdfs.add(rendiconto);

        //sendPDFListToPuc(pdfs, 55);
        clearTempDirectory(dir);
        return pdfs;
    }

    public static void main(String args[]){
        try {
            new  ControllerOffertaFviPremium44().avviaProcesso();
            //new ControllerOffertaFviPremium44().avviaProcessoSupplemento();
        } catch (ProspettoDiOffertaException e) {
            e.printStackTrace();
        }
    }
}
