package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.serviceclient.bi.WSOpzioniBean;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

import java.util.Date;

/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraOpzioneProroga extends LetteraEngine{

    public LetteraOpzioneProroga(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param dest
	 * @param dom
	 * @throws CrmStampeException
	 */
	public void completaPolizza(Polizza dest, DomandaVO dom) throws  WebServiceClientException {
		
		//-----------  PRESTAZIONI ASSICURATE -------------------
        TabellaPrestazioniAssicurate.impostaTabellaPrestazioniAssicurate(dest);
    
        //-----------  CHIAMATA MOTORE OPZIONI -------------------
        WSOpzioniBean input = impostaWSinput(dom);
    	
		String polizza = dest.getNumero();
		String anniProroga = input.getAnniProroga();
		String mesiProroga = input.getMesiProroga();
		String dataProroga = input.getDataProroga();
		String polizzaProroga = input.getPolizzaProroga();
		String valoreRiscatto = input.getValoreRiscatto();
		
		if(anniProroga == null){
			anniProroga = "0";
		}
		if(anniProroga.equals("")){
			anniProroga = "0";
		}

        if(mesiProroga == null){
        	mesiProroga = "";
        }
        if(mesiProroga.equals("")){
        	mesiProroga = "0";
        }
        
        if(dataProroga == null){
        	dataProroga = "";
        }
        if(dataProroga.equals("0")){
        	dataProroga = "";
        }
        
        if(polizzaProroga == null){
        	polizzaProroga = "0";
        }
        if(polizzaProroga.equals("")){
        	polizzaProroga = "0";
        }
        

        WSOpzioniBean output;
        try {
            output = uniS.getOpzProroga(
                    polizza,
                    anniProroga,
                    mesiProroga,
                    dataProroga,
                    polizzaProroga);
        } catch (UniversoException e) {
                throw new WebServiceClientException(e);
        }

        dest.addAttributo("anniProroga", anniProroga);
	    dest.addAttributo("mesiProroga", mesiProroga);
	    dest.addAttributo("dataProroga", dataProroga);
	    dest.addAttributo("polizzaProroga", polizzaProroga);
	    dest.addAttributo("valoreRiscatto", valoreRiscatto);
	    
		if (output != null) {
	     	dest.addAttributo("dataScadenzaPrimaRataRendita", output.getDataScadenzaPrimaRataRendita());
		    dest.addAttributo("importoOpzionePrestazioniVita", output.getTotaleRenditaDiOpzioneComplessiva());
		    if (dest.getRenditaGarantita75() != null && !"".equals(dest.getRenditaGarantita75())) {
		    	dest.addAttributo("dataOpzioneRicorrenza75", output.getRicorrenzaRenditaAl75Anno());
		    	dest.addAttributo("dataOpzioneRicorrenza80", output.getRicorrenzaRenditaAl80Anno());
		    	dest.addAttributo("dataOpzioneRicorrenza85", output.getRicorrenzaRenditaAl85Anno());
		    	dest.addAttributo("renditaOpzioneGarantita75", output.getRenditaAnnuaVitaliziaAl75Anno());
		    	dest.addAttributo("renditaOpzioneGarantita80", output.getRenditaAnnuaVitaliziaAl80Anno());
		    	dest.addAttributo("renditaOpzioneGarantita85", output.getRenditaAnnuaVitaliziaAl85Anno());
		    }	
	        //nella colonna descrizioni
	        dest.addAttributo("importoRataRenditaFrazionata", output.getImportoRataRenditaFrazionata());
	        dest.addAttributo("rataRenditaAnnuaVitaliziaAl75Anno", output.getRataRenditaAnnuaVitaliziaAl75Anno());
	        dest.addAttributo("rataRenditaAnnuaVitaliziaAl80Anno", output.getRataRenditaAnnuaVitaliziaAl80Anno());
	        dest.addAttributo("rataRenditaAnnuaVitaliziaAl85Anno", output.getRataRenditaAnnuaVitaliziaAl85Anno());
	        dest.addAttributo("rataRenditaReversibilitaMorteAssic", output.getRataRenditaReversibilitaMorteAssic());
	        dest.addAttributo("dataFineDiffReversibilitaMorteAssic", output.getDataFineDiffReversibilitaMorteAssic());
	        
	        //-----------  TABELLA OPZIONI -------------------
	        impostaTabellaOpzioni(dest, output);
	    }
		
       
    }
	
	/**
	 * @param dom
	 * @return
	 */
	private static WSOpzioniBean impostaWSinput(DomandaVO dom) {
		WSOpzioniBean bean = new WSOpzioniBean();

		Integer ap = Inputs.getAnniProroga(dom);
		if (ap != null)
			bean.setAnniProroga(NumberUtils.format(ap.intValue(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI,
					0));

		Integer mp = Inputs.getMesiProroga(dom);
		if (mp != null)
			bean.setMesiProroga(NumberUtils.format(mp.intValue(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI,
					0));

		Date dp = Inputs.getDataProroga(dom);
		if (dp != null)
			bean.setDataProroga(DateUtils.formatDate(dp, Costanti.FORMATO_DATA));
		
		bean.setPolizzaProroga(Inputs.getPolizza(dom));
		bean.setValoreRiscatto(Inputs.getValoreRiscatto(dom));
		
		return bean;

	}
	
	
	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaTabellaOpzioni(Polizza dest, WSOpzioniBean output) {

		//------------ DESCRIZIONE IPOTESI ------------
	    impostaIpotesiOpzione(dest,output);
	 
	    //------------ CASO VITA ------------
	    impostaRigaPrestazioniVita(dest,output);

	    //------------ ACLS (75, 80, 85) ----------------
	    impostaRigaPrestazioniACLS(dest,output);

	    //------------ TOTALE OPZIONE  ------------
	    impostaRigaOpzione(dest,output);

	    //------------ RICHIESTA OPZIONE  ------------
	    DescrizioniComuni.impostaDescrizioneRichiestaOpzione(dest);
	}

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaIpotesiOpzione(Polizza dest, WSOpzioniBean output) {
		int anni = new Integer(dest.getAttributo("anniProroga"));
		int mesi = new Integer(dest.getAttributo("mesiProroga"));
		int polizzaProroga = new Integer(dest.getAttributo("polizzaProroga"));
		
		DescrizioniComuni.impostaDescrizioneIpotesiConsiderate(dest);
	  	
		if ("1".equals(dest.getRamoMinisteriale())) {
			if (dest.getLiquidazioni() != null && !dest.getLiquidazioni().isEmpty() &&
		        dest.getLiquidazioni().get(0).getImportoPrestito() != null) {
		        dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate")
		                + dest.getTroncone("DescrRestituzionePrestito"));
		    }
			if ((!"RD".equals(dest.getCodiceSottostato())) &&
		        (!"AF".equalsIgnoreCase(dest.getCodiceSottostato())) &&
		        (!"U".equalsIgnoreCase(dest.getCodicePremio()))) {
		       	dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate")
		                + dest.getTroncone("DescrCorresponsPremiPattuiti"));
		    }
			
			if (dest.getDataUltimaRivalutazioneFineDifferimento()!= null && 
			   !dest.getDataUltimaRivalutazioneFineDifferimento().isEmpty())  {
			    dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate")
			    		+ dest.getTroncone("DescrRivalMaturate")
			            + " " + dest.getDataUltimaRivalutazioneFineDifferimento()
			            + " " + dest.getTroncone("DescrUltimaRicorrenza")
			            + ".");
			}
	  	} 	
		
		dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
	               + dest.getTroncone("DescrIpotProroga"));
	  
		if (anni > 0 && mesi > 0) {
			 dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
	               + " di " + dest.getAttributo("anniProroga")
	               + " anni e di " + dest.getAttributo("mesiProroga")
	               + " mesi (al " + output.getDataFineDiffReversibilitaMorteAssic()
	               + ");");
		}
		
		if (anni > 0 && mesi == 0) {
			 dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
		           + " di " + dest.getAttributo("anniProroga")
		           + " anni (al " + output.getDataFineDiffReversibilitaMorteAssic()
		           + ");");
		}
		
		if (anni == 0 && mesi > 0) {
			 dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
			       + " di " + dest.getAttributo("mesiProroga")
			       + " mesi (al " + output.getDataFineDiffReversibilitaMorteAssic()
			       + ");");
		}
		
		if (dest.getAttributo("dataProroga") != null && !dest.getAttributo("dataProroga").isEmpty()) {
				 dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
				       + " al " + dest.getAttributo("dataProroga")
				       + ";");
		}
		
		if (polizzaProroga > 0) {
			 dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
			       + " al " + output.getDataFineDiffReversibilitaMorteAssic()
			       + " " + dest.getAttributo("DescrIpotPolizzaProrogata")
			       + " " + dest.getAttributo("polizzaProroga")
			       + ";");
		}
		
		dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
			       + dest.getAttributo("DescrCorresponsRateAnnPost"));
	}
	
	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaRigaPrestazioniVita(Polizza dest, WSOpzioniBean output) {

		dest.addAttributo("descrizioneOpzionePrestazioniVita", dest.getTroncone("PrestVitaRenditaAnnuaProrogata")
        	   + " € " + dest.getAttributo("importoRataRenditaFrazionata")
        	   + ".");
	}

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaRigaPrestazioniACLS(Polizza dest, WSOpzioniBean output) {

	    dest.addAttributo("descrizioneOpzioneACLS", "");
	    
	    if (dest.getRenditaGarantita75() != null && !"".equals(dest.getRenditaGarantita75())) {
	        dest.addAttributo("descrizioneOpzioneACLS", dest.getTroncone("PrestVitaRenditaAnnuaProrogataACLS")
	        		+ " "    + output.getRataRenditaAnnuaVitaliziaAl75Anno()
       				+ ", € " + output.getRataRenditaAnnuaVitaliziaAl80Anno()
       				+ " ed € " + output.getRataRenditaAnnuaVitaliziaAl85Anno()
       				+ ".");
	    }
	}

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaRigaOpzione(Polizza dest, WSOpzioniBean output) {

		if ("si".equalsIgnoreCase(dest.getAttributo("valoreRiscatto"))) {
			 dest.addAttributo("dataRiscatto", output.getDataFineDiffReversibilitaMorteAssic());
			 dest.addAttributo("descrizioneRiscatto", dest.getTroncone("RiscattoTermineDifferimento"));
		}
	}
}
