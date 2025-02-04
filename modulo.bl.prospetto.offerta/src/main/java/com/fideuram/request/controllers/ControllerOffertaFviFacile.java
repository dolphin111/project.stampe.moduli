package com.fideuram.request.controllers;

import java.util.ArrayList;
import java.util.List;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.modello.selection.Fundhouse;
import com.fideuram.modello.selection.Isin;
import com.fideuram.modello.selection.SelectionFund;
import com.fideuram.processo.prospetti.FvInsiemeFacile;
import com.fideuram.processo.prospetti.GeneratoreBase;

/**
 * Created by
 * User: logan
 * Date: 13/03/13
 * Time: 15.05
 */
public class ControllerOffertaFviFacile extends ControllerOffertaBase {
    /**
     * Genera il prospetto completo
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException {
        PubblicazioneConsob p = loadDati(55);
        setFlagProdottoFacile(p);
        List<byte[]> pdfs = new ArrayList<byte[]>();
        GeneratoreBase generatore = new FvInsiemeFacile(dir);

        byte[] parte2 = stampaParteX(p, 2, generatore);
        parte2 = addPiedino(parte2, "FvInsiemeFacile-PARTE-II.pdf", false);
        pdfs.add(parte2);//PARTE 2

        int posProposteInvestimento = 0;
        for(int i = 0 ;i < p.getSelectionFunds().size() ; i++){
        	if(p.getSelectionFunds().get(i).isPropostaInvestimento()){
        		posProposteInvestimento = i;
        	}
        }
        p.getSelectionFunds().remove(posProposteInvestimento);//tolgo le proposte di investimento perchè su parte I e III non devono essere stampate
        //p.getSelectionFunds().remove(0);

        byte[] parte1 = stampaParteX(p, 1, generatore);
        parte1 = addPiedino(parte1, "FvInsiemeFacile-PARTE-I.pdf", false);
        pdfs.add(parte1);//PARTE 1

        byte[] parte3 = stampaParteX(p, 3, generatore);
        parte3 = addPiedino(parte3, "FvInsiemeFacile-PARTE-III.pdf", false);
        pdfs.add(parte3);//PARTE 3

        sendPDFListToPuc(pdfs, 55);
        clearTempDirectory(dir);
        return pdfs;
    }



    /**
     * Genera solo il supplemento del prospetto
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcessoSupplemento() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(550);
        setFlagProdottoFacile(p);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        GeneratoreBase generatore= new FvInsiemeFacile(dir);
        p.getSelectionFunds().remove(2);
        p.getSelectionFunds().remove(0);
      
        byte[] supplemento = stampaParteX(p, 4, generatore);
        supplemento = addPiedino(supplemento,"FV-Facile-SUPPLEMENTO.pdf", false);
        pdfs.add(supplemento);//SUPPLEMENTO
        sendPDFListToPuc(pdfs, 550);
        clearTempDirectory(dir);
        return pdfs;
    }

    public List<byte[]> avviaProcessoRendiconto() throws ProspettoDiOffertaException {
        PubblicazioneConsob p = loadDati(551);
        setFlagProdottoFacile(p);
        p.setNomeProdotto("Fideuram Vita Insieme Facile");
        List<byte[]> pdfs = new ArrayList<byte[]>();
        GeneratoreBase generatore = new FvInsiemeFacile(dir);

        p.getSelectionFunds().remove(p.getSelectionFunds().size() -1); //tolgo le proposte di investimento
        byte[] rendiconto = stampaParteX(p, 5, generatore);
        rendiconto = addPiedino(rendiconto, "FvInsiemeFacile-RENDICONTO.pdf", false);
        pdfs.add(rendiconto);

        clearTempDirectory(dir);
        return pdfs;
    }
    
    private void setFlagProdottoFacile(PubblicazioneConsob p) {
		List<SelectionFund> selectionFunds = p.getSelectionFunds();
        for(SelectionFund fund :selectionFunds){
        	for(Fundhouse fundHouse : fund.getFundhouses()){
        		for(Isin isin:fundHouse.getIsins()){
        			if(isin.isPropostaInvestimento())//modifica del 12/06/2018
        				isin.setFacile(true);
        		}
        	}
        	
        }
	}


    public static void main(String args[]){
        try {
            new ControllerOffertaFviFacile().avviaProcesso();
            //new ControllerOffertaFviFacile().avviaProcessoSupplemento();
        } catch (ProspettoDiOffertaException e) {
            e.printStackTrace();
        }
    }
}
