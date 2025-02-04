package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Modello;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.stampe.dao.DaoException;

public class LetteraRiscattoTermine extends LetteraEngine{

    public LetteraRiscattoTermine(int comID) throws WebServiceClientException {
        super(comID);
    }

    public  void completaPolizza(Polizza dest, Modello m, ComunicazioneVO com, DomandaVO dom, boolean root)
            throws WebServiceClientException, StampeInfoException, PucException, DaoException {

     	// ------------ ACLS (75, 80, 85) ----------------
    	TabellaPrestazioniAssicurate.impostaRigaPrestazioniACLS(dest);

		// ------------ RIFERIMENTO COMPLEMENTARE ------------
    	TabellaPrestazioniAssicurate.impostaRigaPrestazioniComplementari(dest);

		// ------------ RIFERIMENTO MASSIMALE ------------
		TabellaPrestazioniAssicurate.impostaRigaPrestazioniMassimali(dest);
	   

        //-----------  PRESTAZIONI ASSICURATE -------------------
        new TabellaValoreRiscattoTermine(comID).impostaTabellaValoreRiscatto(dest);

        //-----------  VINCOLO/PEGNO -------------------
        DescrizioniComuni.impostaVincoloPegno(dest);
        
        //  utilizzare sempre i tronconi di RiscattoTermine !!!
        //  i template di riscatto a termine con ipotesi hanno la doppia tabella RISCATTO 
        //  quindi richiamare RiscattoTermine.odt
        dest.addAttributo("labelTabellaValutazioneIpotesi", "");
        dest.addAttributo("labelIpotesiRiscatto", "");
        
        String tripletta = dom.getDescrizioneDomanda().getVecchioliv1() +
                           dom.getDescrizioneDomanda().getVecchioliv2() +
                           dom.getDescrizioneDomanda().getVecchioliv3();
        if (Costanti.CODICE_RISCATTO_TERMINE.equalsIgnoreCase(tripletta)) {
            dest.addAttributo("labelTabellaValutazioneIpotesi", dest.getTroncone("DescrValutTermineFineDiff"));
        } else if (Costanti.CODICE_RISCATTO_TERMINE_PU_AGG.equalsIgnoreCase(tripletta)) {
            dest.addAttributo("labelTabellaValutazioneIpotesi", dest.getTroncone("DescrValutTermineFineDiffPUAgg"));
            dest.addAttributo("labelIpotesiRiscatto", dest.getTroncone("DescrRiscTermHPPUAgg"));
        } else if (Costanti.CODICE_RISCATTO_TERMINE_AMPLIAMENTO.equalsIgnoreCase(tripletta)) {
            dest.addAttributo("labelTabellaValutazioneIpotesi", dest.getTroncone("DescrValutTermineFineDiffAmpl"));
            dest.addAttributo("labelIpotesiRiscatto",  dest.getTroncone("DescrRiscTermHPAmpl"));
        } else if (Costanti.CODICE_RISCATTO_TERMINE_RIATTIVAZIONE.equalsIgnoreCase(tripletta)) {
            dest.addAttributo("labelTabellaValutazioneIpotesi", dest.getTroncone("DescrValutTermineFineDiffRiatt"));
            dest.addAttributo("labelIpotesiRiscatto",  dest.getTroncone("DescrRiscTermHPRiatt"));
        }
        
        //-----------  CHIAMATA MOTORE UNIVERSO-------------------
        Integer indicatoreTipoRisc = new Integer(1);
        String dataValutazione = dest.getAttributo("dataValutazione");
        new DescrizioniComuni(comID).impostaDatiRiscatto(dest,dataValutazione,indicatoreTipoRisc);
        //Nel caso in cui si verificasse la condizione seguente, nel template verrà aggiunta una frase in testa
        if("FAP".equals(dest.getDescrizioneFondoSintetica()) 
        		&& "R".equals(dest.getTipoPrestazione())){            	
        	dest.setFAP_R(true);
        }
    }
}
