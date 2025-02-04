package com.fideuram.request.controllers;

import java.util.ArrayList;
import java.util.List;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.modello.selection.Fundhouse;
import com.fideuram.modello.selection.Isin;
import com.fideuram.modello.selection.SelectionFund;
import com.fideuram.processo.prospetti.FvInsiemeFacile;
import com.fideuram.processo.prospetti.FvInsiemePremium;
import com.fideuram.processo.prospetti.GeneratoreBase;

/**
 * Created by
 * User: logan
 * Date: 13/02/13
 * Time: 18.08
 */
public class ControllerOffertaFviPremium extends ControllerOffertaBase {

    /**
     * Genera il prospetto completo
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
        public List<byte[]> avviaProcesso() throws ProspettoDiOffertaException, WebServiceClientException {
            PubblicazioneConsob p = loadDati(51);
            List<SelectionFund> selectionFunds = p.getSelectionFunds();
            for(SelectionFund selFund : selectionFunds){
        		for(Fundhouse fund : selFund.getFundhouses()){
        			for(Isin isin :fund.getIsins()){
        				if(isin.isPropostaInvestimento()){
        					isin.setHeaderFondo(isin.getCodiceIsin());
        				}
	            	}
        		}
            }
            //p.setNomeProdotto("Fideuram Vita Insieme Premium");
            /*   List<byte[]> pdfs=new ArrayList<byte[]>();
            GeneratoreBase generatore= new FvInsiemePremium(dir);

            byte[] pdf = stampaParteX(p, 1,generatore);
            pdf = addPiedino(pdf,"FvPremium.pdf");
            pdfs.add(pdf);//PARTE 1

            sendPDFListToPuc(pdfs, 51);
            clearTempDirectory(dir);
            return pdfs;
           PubblicazioneConsob p = loadDati(51,false);*/
            p.setNomeProdotto("Fideuram Vita Insieme Premium");
            List<byte[]> pdfs=new ArrayList<byte[]>();
            GeneratoreBase generatoreFvPremium= new FvInsiemePremium(dir);
            byte[] parte2 = stampaParteX(p, 2, generatoreFvPremium);
            parte2 = addPiedino(parte2, "FvInsiemePremium-PARTE-II.pdf", false);
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
            parte1 = addPiedino(parte1, "FvInsiemePremium-PARTE-I.pdf", false);
            pdfs.add(parte1);//PARTE 1

            byte[] parte3 = stampaParteX(p, 3, generatoreFvPremium);
            parte3 = addPiedino(parte3, "FvInsiemePremium-PARTE-III.pdf", false);
            pdfs.add(parte3);//PARTE 3

            sendPDFListToPuc(pdfs, 51);
            clearTempDirectory(dir);
            return pdfs;

    }


    /**
     * Genera solo il supplemento del prospetto
     * @return
     * @throws com.fideuram.exception.ProspettoDiOffertaException
     */
    public List<byte[]> avviaProcessoSupplemento() throws ProspettoDiOffertaException{
            PubblicazioneConsob p = loadDati(510);
            p.setNotaIvass();
            List<byte[]> pdfs=new ArrayList<byte[]>();
            GeneratoreBase generatoreFVInsieme= new FvInsiemePremium(dir);
            p.getSelectionFunds().remove(3);//tolgo le proposte di investimento perchè su parte I e III non devono essere stampate
            p.getSelectionFunds().remove(0);
            byte[] supplemento = stampaParteX(p, 4, generatoreFVInsieme);
            supplemento = addPiedino(supplemento,"FV-Premium-SUPPLEMENTO.pdf", false);
            pdfs.add(supplemento);//SUPPLEMENTO
            sendPDFListToPuc(pdfs, 510);
            clearTempDirectory(dir);
            return pdfs;
    }


    public List<byte[]> avviaProcessoRendiconto() throws ProspettoDiOffertaException {
        PubblicazioneConsob p = loadDati(511);
        p.setNomeProdotto("Fideuram Vita Insieme Premium");
        List<byte[]> pdfs = new ArrayList<byte[]>();
        GeneratoreBase generatore = new FvInsiemeFacile(dir);

        p.getSelectionFunds().remove(p.getSelectionFunds().size() -1);
        byte[] rendiconto = stampaParteX(p, 5, generatore);
        rendiconto = addPiedino(rendiconto, "FvPremium-RENDICONTO.pdf", false);
        pdfs.add(rendiconto);


        //sendPDFListToPuc(pdfs, 55);
        clearTempDirectory(dir);
        return pdfs;
    }

    public static void main(String args[]){
        try {
           //new  ControllerOffertaFviPremium().avviaProcesso();
           new ControllerOffertaFviPremium().avviaProcessoSupplemento();
        } catch (ProspettoDiOffertaException e) {
            e.printStackTrace();
        }
    }
}
