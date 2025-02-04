package com.fideuram.request.controllers;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.modello.selection.SelectionFund;
import com.fideuram.processo.prospetti.FVInsieme;
import com.fideuram.processo.prospetti.FvInsiemeFacile;
import com.fideuram.processo.prospetti.GeneratoreBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 02/10/12
 * Time: 14.32
 */
public class ControllerOffertaFVInsieme extends ControllerOffertaBase {

    /**
     * Genera il prospetto completo
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(18);
        p.setInsieme(true);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        GeneratoreBase generatoreFVInsieme= new FVInsieme(dir);

        int posProposteInvestimento = 0;
        boolean isProposte = false;
        for(int i = 0 ;i < p.getSelectionFunds().size() ; i++){
        	if(p.getSelectionFunds().get(i).isPropostaInvestimento()){
        		posProposteInvestimento = i;
        		isProposte = true;
        	}
        	if(p.getSelectionFunds().get(i).getNome().contains("ETF")){
        		p.getSelectionFunds().get(i).setEtfFvInsieme(true);
        	}
        }
        
        
        byte[] parte2 = stampaParteX(p, 2,generatoreFVInsieme);
        parte2 = addPiedino(parte2,"FVInsieme-PARTE-II.pdf", false);
        pdfs.add(parte2);//PARTE 2

        
        if(isProposte)
        	p.getSelectionFunds().remove(posProposteInvestimento);//tolgo le proposte di investimento perchè su parte I e III non devono essere stampate
        //p.getSelectionFunds().remove(0);

        byte[] parte1 = stampaParteX(p, 1,generatoreFVInsieme);
        parte1 = addPiedino(parte1,"FVInsieme-PARTE-I.pdf",false);
        pdfs.add(parte1);//PARTE 1

        byte[] parte3 = stampaParteX(p, 3,generatoreFVInsieme);
        parte3 = addPiedino(parte3,"FVInsieme-PARTE-III.pdf", false);
        pdfs.add(parte3);//PARTE 3

        sendPDFListToPuc(pdfs, 18);
        clearTempDirectory(dir);
        return pdfs;
    }

    /**
     * Genera solo il supplemento del prospetto
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcessoSupplemento() throws ProspettoDiOffertaException{
        PubblicazioneConsob p = loadDati(180);
        p.getSupplemento().setPremium(false);
        List<byte[]> pdfs=new ArrayList<byte[]>();
        GeneratoreBase generatoreFVInsieme= new FVInsieme(dir);
        p.getSelectionFunds().remove(3);//tolgo le proposte di investimento perchè su parte I e III non devono essere stampate
        p.getSelectionFunds().remove(0);
        byte[] supplemento = stampaParteX(p, 4, generatoreFVInsieme);
        supplemento = addPiedino(supplemento,"FVInsieme-SUPPLEMENTO.pdf", false);
        pdfs.add(supplemento);//SUPPLEMENTO

        sendPDFListToPuc(pdfs, 180);
        clearTempDirectory(dir);
        return pdfs;
    }

    public List<byte[]> avviaProcessoRendiconto() throws ProspettoDiOffertaException {
        PubblicazioneConsob p = loadDati(181);
        p = setFlagPrimoFondoEsterno(p);
        p.setNomeProdotto("Fideuram Vita Insieme");
        List<byte[]> pdfs = new ArrayList<byte[]>();
        GeneratoreBase generatore = new FvInsiemeFacile(dir);
        p.getSelectionFunds().remove(p.getSelectionFunds().size() -1); //tolgo le proposte di investimento

        byte[] rendiconto = stampaParteX(p, 5, generatore);
        rendiconto = addPiedino(rendiconto, "FvInsieme-RENDICONTO.pdf", false);
        pdfs.add(rendiconto);


        //sendPDFListToPuc(pdfs, 55);
        clearTempDirectory(dir);
        return pdfs;
    }
    
    private PubblicazioneConsob setFlagPrimoFondoEsterno(PubblicazioneConsob p){
    	List<SelectionFund> selectionFunds = p.getSelectionFunds();
    	int i = 0;
    	boolean isPrimoEsterno = false;
    	for(SelectionFund selection : selectionFunds){
    		if(!selection.getFondoInterno()&&!selection.isPropostaInvestimento() && !isPrimoEsterno/*&&i==2*/){
    			selection.setPrimoFondoEsterno(true);
            isPrimoEsterno = true;
    		}
    	}
    	return p;
    }


    public static void main(String args[]){
        try {
            //new ControllerOffertaFVInsieme().avviaProcesso();
            new  ControllerOffertaFVInsieme().avviaProcessoSupplemento();

        } catch (ProspettoDiOffertaException e) {
            e.printStackTrace();
        }
    }
}
