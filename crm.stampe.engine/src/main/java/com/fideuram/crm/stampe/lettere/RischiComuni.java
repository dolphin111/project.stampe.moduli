package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.BeneficiariLiquidazione;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiscattoPolizzeChiuseBean;
import com.fideuram.puc.service.impl.BeneficiarioLiquidazioneVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

import java.util.ArrayList;

/**
 * @author Giorgio Desideri
 *
 */
public class RischiComuni extends LetteraEngine{

    public RischiComuni(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
     * @param target
     * @param root
     */
    public void completaPolizza(Polizza target, boolean root) throws WebServiceClientException, UniversoException, PucException {
        if (root) {
            if ("SP".equalsIgnoreCase(target.getCodiceGruppo())) {
                	//-----------  CHIAMATA MOTORE UNIVERSO-------------------
                String polizza = target.getNumero();
                String dataValutazione = target.getAttributo("dataValutazione");
                WSRiscattoPolizzeChiuseBean bean = null;

                //bean = universoClient.getRiscattoPolizzeChiuse(polizza,dataValutazione );
                bean = uniS.getRiscattoPolizzeChiuse(polizza,dataValutazione );

                target.addAttributo("dataRiferimentoRiscatto", dataValutazione);
                target.addAttributo("descrizioneRiscatto", target.getTroncone("DescrRiscattoValoreLiquidabileRiscAnt"));
                target.addAttributo("importoRiscatto", bean.getValoreDiRiscattoTotaleLordo());
                LoggingUtils.debug("Stima Riscatto PA  - ValoreDiRiscattoTotaleLordo: " + bean.getValoreDiRiscattoTotaleLordo());
            } else if ("RE".equalsIgnoreCase(target.getCodiceSottostato())) {
                //-----------  PRESTAZIONI ASSICURATE -------------------
                target.addAttributo("riscattoEccedente","!SP+AT+RE");
                LetteraEccedenza.impostaRigaEccedenza(target);
            } else {
                target.addAttributo("riscattoEccedente","!SP+AT!RE");
                TabellaPrestazioniAssicurate.impostaTabellaPrestazioniAssicurate(target);
            }

            //-----------  VINCOLO/PEGNO -------------------
            DescrizioniComuni.impostaVincoloPegno(target);
            
            ArrayList<BeneficiarioLiquidazioneVO> listaBeneficiari = getlistBeneficiariLiquidazioneByPolizzaPratica(target.getNumero());
            if(listaBeneficiari != null && listaBeneficiari.size()>0){
            	//inizializzo la lista dei beneficiari
            	target.setListBeneficiari(new ArrayList<BeneficiariLiquidazione>());
            	BeneficiariLiquidazione beneficiari = null;
            	for(int i=0;i<listaBeneficiari.size();i++){
            		beneficiari = new BeneficiariLiquidazione();
            		beneficiari.setBeneficiario(listaBeneficiari.get(i).getCognome()+" "+listaBeneficiari.get(i).getNome());
            		beneficiari.setPercentualeLiquidazione(""+listaBeneficiari.get(i).getPercentualeLiquidazione()+"%");
            		beneficiari.setLiquidazioneSpettante(NumberUtils.getNullSefeCurrency(listaBeneficiari.get(i).getLiquidazioneSpettante()));
            		//aggiungo l'elemento alla lista precedentemente inizializzata
            		target.getListBeneficiari().add(beneficiari);
            	}            	
            }
        }
    }

    private  ArrayList<BeneficiarioLiquidazioneVO> getlistBeneficiariLiquidazioneByPolizzaPratica(String numeroPolizza) throws WebServiceClientException, PucException {
		ArrayList<BeneficiarioLiquidazioneVO> listaBeneficiari = null;
		try {
			listaBeneficiari = (ArrayList<BeneficiarioLiquidazioneVO>)pucS.listBeneficiariLiquidazioneByPolizza(new Long(numeroPolizza));
		} catch (ServiceException_Exception e) {
            throw new PucException(e);
		}
		return listaBeneficiari;
	}    
}