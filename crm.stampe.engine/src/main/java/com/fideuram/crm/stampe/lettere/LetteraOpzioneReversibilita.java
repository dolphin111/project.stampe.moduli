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
public class LetteraOpzioneReversibilita extends LetteraEngine{

    public LetteraOpzioneReversibilita(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param dest
	 * @param dom
	 * 
	 * @throws CrmStampeException
	 */
	public void completaPolizza(Polizza dest, DomandaVO dom) throws  WebServiceClientException {

		//-----------  PRESTAZIONI ASSICURATE -------------------
		TabellaPrestazioniAssicurate.impostaTabellaPrestazioniAssicurate(dest);

		//-----------  CHIAMATA MOTORE OPZIONI -------------------
		WSOpzioniBean input = impostaWSinput(dom);

		String polizza = dest.getNumero();
		String frazionamento = input.getFrazionamento();
		String anticipata = input.getAnticipata();
		String reversibilita = input.getReversibilita();
		String dataNascita = input.getDataNascita();
		String sesso = input.getSesso();

        WSOpzioniBean output =null;
        try {
            output = uniS.getOpzReversibilita(
                    polizza, frazionamento,
                    reversibilita, dataNascita,
                    sesso, anticipata);
        } catch (UniversoException e) {
           throw new WebServiceClientException(e);
        }

        dest.addAttributo("reversibilita", reversibilita);
		dest.addAttributo("dataNascita", dataNascita);
		dest.addAttributo("anticipata", anticipata);
		dest.addAttributo("sessoInput", sesso);

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

			dest.addAttributo("dataOpzione", output.getDataRataRenditaReversibilitaMorteAssic());
			dest.addAttributo("importoOpzione", output.getRenditaReversibilitaMorteAssic());

			//nella colonna descrizioni
			dest.addAttributo("importoRataRenditaFrazionata", output.getImportoRataRenditaFrazionata());
			dest.addAttributo("rataRenditaAnnuaVitaliziaAl75Anno", output.getRataRenditaAnnuaVitaliziaAl75Anno());
			dest.addAttributo("rataRenditaAnnuaVitaliziaAl80Anno", output.getRataRenditaAnnuaVitaliziaAl80Anno());
			dest.addAttributo("rataRenditaAnnuaVitaliziaAl85Anno", output.getRataRenditaAnnuaVitaliziaAl85Anno());
			dest.addAttributo("rataRenditaReversibilitaMorteAssic", output.getRataRenditaReversibilitaMorteAssic());

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
		bean.setFrazionamento(Inputs.getFrazionamento(dom));
		bean.setAnticipata(Inputs.getAnticipata(dom));
		bean.setSesso(Inputs.getSesso(dom));

		Float f = Inputs.getReversibilita(dom);

		if( (f != null) && ( f.floatValue() > 0 ) ) 
			bean.setReversibilita(
					NumberUtils.format(
							f.floatValue(), 
							Costanti.SEPARATORE_MIGLIAIA, 
							Costanti.SEPARATORE_DECIMALI, 
							0));

		Date d = Inputs.getDataNascita(dom);
		if (d != null) 
			bean.setDataNascita(DateUtils.formatDate(d, Costanti.FORMATO_DATA));

		return bean;
	}

	/**
	 * @param dest
	 * @param output
	 * @return
	 */
	private static void impostaTabellaOpzioni(Polizza dest, WSOpzioniBean output) {

		//------------ DESCRIZIONE IPOTESI ------------
		impostaIpotesiOpzioneGenerica(dest);
		impostaIpotesiOpzioneReversibilita(dest,output);

		//------------ CASO VITA ------------
		impostaRigaPrestazioniVita(dest,output);

		//------------ ACLS (75, 80, 85) --------------
		impostaRigaPrestazioniACLS(dest,output);

		//------------ TOTALE OPZIONE  ------------
		impostaRigaOpzione(dest,output);

		//------------ RICHIESTA OPZIONE  ------------
		DescrizioniComuni.impostaDescrizioneRichiestaOpzione(dest);
	}


	/**
	 * @param dest
	 */
	public static void impostaIpotesiOpzioneGenerica(Polizza dest) {

		DescrizioniComuni.impostaDescrizioneIpotesiConsiderate(dest);

		if ("1".equals(dest.getRamoMinisteriale())) {
			
			if (dest.getLiquidazioni() != null 
					&& !dest.getLiquidazioni().isEmpty() 
					&& dest.getLiquidazioni().get(0).getImportoPrestito() != null) {
				dest.addAttributo(
						"ipotesiConsiderate", 
						dest.getAttributo("ipotesiConsiderate")
						+ dest.getTroncone("DescrRestituzionePrestito"));		        
			}

			if ((!"RD".equals(dest.getCodiceSottostato())) &&
					(!"AF".equalsIgnoreCase(dest.getCodiceSottostato())) &&
					(!"U".equalsIgnoreCase(dest.getCodicePremio()))) {
				dest.addAttributo(
						"ipotesiConsiderate", 
						dest.getAttributo("ipotesiConsiderate")
						+ dest.getTroncone("DescrCorresponsPremiPattuiti"));

			}
			
			if (dest.getDataUltimaRivalutazioneFineDifferimento()!= null 
					&& !dest.getDataUltimaRivalutazioneFineDifferimento().isEmpty())  {
				
				dest.addAttributo("ipotesiConsiderate", 
						dest.getAttributo("ipotesiConsiderate") 
						+  dest.getTroncone("DescrRivalMaturate")
						+ " " + dest.getDataUltimaRivalutazioneFineDifferimento()
						+ " " + dest.getTroncone("DescrUltimaRicorrenza")
						+ ".");
			}
		} 

		// Ramo 3
		else {
			if ("A".equalsIgnoreCase(dest.getCodicePremio())) {
				dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate")
						+ dest.getTroncone("DescrComplPiano") );
				
			} else {
				if ("C".equalsIgnoreCase(dest.getTipoPrestazione())) {
					dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate")
							+ dest.getTroncone("DescrIpotconvCapitale"));
				}
			}
		}
	}

	
	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaIpotesiOpzioneReversibilita(Polizza dest, WSOpzioniBean output) {

		dest.addAttributo("ipotesiOpzione", dest.getTroncone("DescrIpotReversibilita"));

		if ("M".equalsIgnoreCase(dest.getAttributo("sessoInput"))) {
			dest.addAttributo("ipotesiOpzione", 
					dest.getAttributo("ipotesiOpzione")
					+ " " + dest.getAttributo("reversibilita")
					+ "%, su testa maschile nata il "); 
		} else {
			dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
					+ " " + dest.getAttributo("reversibilita")
					+ "%, su testa femminile nata il "); 
		}
		
		dest.addAttributo("ipotesiOpzione", 
				dest.getAttributo("ipotesiOpzione")
				+ dest.getAttributo("dataNascita")
				+ ".");

		dest.addAttributo("ipotesiOpzione", 
				dest.getAttributo("ipotesiOpzione")
				+ dest.getTroncone("DescrIpotFrazionamento")
				+ " " + output.getFrazionamentoPlurale());

		
		if ("si".equalsIgnoreCase(dest.getAttributo("anticipata"))) {
			dest.addAttributo("ipotesiOpzione", 
					dest.getAttributo("ipotesiOpzione")
					+ " anticipate.");
		} else {
			dest.addAttributo("ipotesiOpzione", 
					dest.getAttributo("ipotesiOpzione")
					+ " posticipate.");
		}

		
		if ("3".equals(dest.getRamoMinisteriale())) {
			if ("C".equalsIgnoreCase(dest.getTipoPrestazione())) {
				dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
						+ dest.getTroncone("DescrIpotCorresponsione")
						+ " " + output.getFrazionamentoPlurale());

				if ("si".equalsIgnoreCase(dest.getAttributo("anticipata"))) {
					dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
							+ " anticipate.");
				} else {
					dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
							+ " posticipate.");
				}
				dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
						+ dest.getTroncone("DescrIpotCoefficienti"));
			}
		} 

		// Rinuncia Riscatto
		impostaIpotesiOpzioneRinunciaRiscatto(dest,output);
	}

	/**
	 * @param dest
	 * @param output
	 */
	public static void impostaIpotesiOpzioneRinunciaRiscatto(Polizza dest, WSOpzioniBean output) {

		if (!"3".equals(dest.getRamoMinisteriale()) &&
				(!"R".equals(dest.getTipoPrestazione()))) {
			if (dest.getLiquidazioni() != null && !dest.getLiquidazioni().isEmpty() &&
					dest.getLiquidazioni().get(0).isPraticaScadenza()) {
				dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
						+ ";" + dest.getTroncone("PrestVitaRinunciaRiscattoOpzione")
						+ " " + dest.getLiquidazioni().get(0).getDataPraticaScadenza()
						+ ".");
			} 

		}
	}

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaRigaPrestazioniVita(Polizza dest, WSOpzioniBean output) {

		dest.addAttributo("descrizioneOpzionePrestazioniVita", 
				dest.getTroncone("PrestVitaRenditaAnnuaReversibile")
				+ " " + output.getFrazionamentoPlurale());

		if ("si".equalsIgnoreCase(dest.getAttributo("anticipata"))) {
			dest.addAttributo("descrizioneOpzionePrestazioniVita", dest.getAttributo("descrizioneOpzionePrestazioniVita")
					+ " anticipate, ciascuna di € ");
		} else {
			dest.addAttributo("descrizioneOpzionePrestazioniVita", dest.getAttributo("descrizioneOpzionePrestazioniVita")
					+ " posticipate, ciascuna di € ");
		}
		dest.addAttributo("descrizioneOpzionePrestazioniVita", dest.getAttributo("descrizioneOpzionePrestazioniVita")
				+ output.getImportoRataRenditaFrazionata()
				+ ".");
	}

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaRigaPrestazioniACLS(Polizza dest, WSOpzioniBean output) {
		dest.addAttributo("descrizioneOpzioneACLS", "");
		
		if (dest.getRenditaGarantita75() != null && !"".equals(dest.getRenditaGarantita75())) {
			dest.addAttributo("descrizioneOpzioneACLS", dest.getTroncone("PrestVitaRenditaAnnuaReversibileACLS")
					+ " " + output.getFrazionamentoPlurale());

			if ("si".equalsIgnoreCase(dest.getAttributo("anticipata"))) {
				dest.addAttributo("descrizioneOpzioneACLS", dest.getAttributo("descrizioneOpzioneACLS")
						+ " anticipate, ciascuna rispettivamente di € ");
			} else {
				dest.addAttributo("descrizioneOpzioneACLS", dest.getAttributo("descrizioneOpzioneACLS")
						+ " posticipate, ciascuna rispettivamente di € ");
			}	
			dest.addAttributo("descrizioneOpzioneACLS", dest.getAttributo("descrizioneOpzioneACLS")
					+ output.getRataRenditaAnnuaVitaliziaAl75Anno()
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

		dest.addAttributo("descrizioneOpzione", dest.getTroncone("PrestMorteRenditaAnnuaReversibile")
				+ " " + output.getFrazionamentoPlurale());

		if ("si".equalsIgnoreCase(dest.getAttributo("anticipata"))) {
			dest.addAttributo("descrizioneOpzione", dest.getAttributo("descrizioneOpzione")
					+ " anticipate, ciascuna di € ");
		} else {
			dest.addAttributo("descrizioneOpzione", dest.getAttributo("descrizioneOpzione")
					+ " posticipate, ciascuna di € ");
		}
		dest.addAttributo("descrizioneOpzione", dest.getAttributo("descrizioneOpzione")
				+ dest.getAttributo("rataRenditaReversibilitaMorteAssic")
				+ ", a partire dalla ricorrenza "
				+ output.getFrazionamentoSingolare()
				+ " " + dest.getTroncone("PrestMorteRenditaAnnuaReversibile2"));
	}
}
