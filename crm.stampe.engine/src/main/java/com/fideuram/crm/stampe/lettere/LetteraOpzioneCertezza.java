package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.serviceclient.bi.WSOpzioniBean;
import com.fideuram.utils.NumberUtils;

/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 */
public class LetteraOpzioneCertezza extends LetteraEngine{

    public LetteraOpzioneCertezza(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param dest
	 * @param dom
	 * @param root
	 * @throws CrmStampeException
	 */
	public void completaPolizza(Polizza dest, DomandaVO dom, boolean root) throws  WebServiceClientException {

		//-----------  PRESTAZIONI ASSICURATE -------------------
		TabellaPrestazioniAssicurate.impostaTabellaPrestazioniAssicurate(dest);

		//-----------  CHIAMATA MOTORE OPZIONI -------------------
		WSOpzioniBean input = impostaWSinput(dom);

		String polizza = dest.getNumero();
		String frazionamento = input.getFrazionamento();
		String anticipata = input.getAnticipata();
		String anniRendita = input.getAnniRendita();

        WSOpzioniBean output = null;
        try {
            output =uniS.getOpzCertezza(polizza, frazionamento, anniRendita, anticipata);
        } catch (UniversoException e) {
           throw new WebServiceClientException(e);
        }

        dest.addAttributo("anticipata", anticipata);
		dest.addAttributo("anniRendita", anniRendita);       

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
			dest.addAttributo("importoOpzione", output.getTotaleRenditaDiOpzioneComplessiva());

			//nella colonna descrizioni
			dest.addAttributo("importoRataRenditaFrazionata", output.getImportoRataRenditaFrazionata());
			dest.addAttributo("rataRenditaAnnuaVitaliziaAl75Anno", output.getRataRenditaAnnuaVitaliziaAl75Anno());
			dest.addAttributo("rataRenditaAnnuaVitaliziaAl80Anno", output.getRataRenditaAnnuaVitaliziaAl80Anno());
			dest.addAttributo("rataRenditaAnnuaVitaliziaAl85Anno", output.getRataRenditaAnnuaVitaliziaAl85Anno());
			dest.addAttributo("rataRenditaReversibilitaMorteAssic", output.getRataRenditaReversibilitaMorteAssic());
			dest.addAttributo("dataFineDiffReversibilitaMorteAssic", output.getDataFineDiffReversibilitaMorteAssic());
			dest.addAttributo("differimento", output.getDifferimento());
			dest.addAttributo("durataCerta", output.getDurataCerta());

			dest.addAttributo("descrizioneVincoloPegno", "");

			if (dest.isVincoloPegno()) {
				dest.addAttributo("descrizioneVincoloPegno", dest.getTroncone("VincoloPegno"));
			}
			
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

		Integer rc = Inputs.getRenditaCerta(dom);
		if (rc != null)
			bean.setAnniRendita(NumberUtils.format(rc.intValue(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI,
					0));

		return bean;
	}

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaTabellaOpzioni(Polizza dest, WSOpzioniBean output) {

		//------------ DESCRIZIONE IPOTESI ------------
		impostaIpotesiOpzioneCertezza(dest,output);

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
	private static void impostaIpotesiOpzioneCertezza(Polizza dest, WSOpzioniBean output) {

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

		// Ramo 3
		else {
			if ("A".equalsIgnoreCase(dest.getCodicePremio())) {
				dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate")
						+ dest.getTroncone("DescrComplPiano") );
			} 
			else {

				if ("C".equalsIgnoreCase(dest.getTipoPrestazione())) {
					if ((dest.getAttributo("durataCerta") != null && !dest.getAttributo("durataCerta").isEmpty()) &&	
							("85".equalsIgnoreCase(dest.getAttributo("differimento")))) {
						dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate")
								+ dest.getTroncone("DescrIpotConversione85"));
					}

					if ((dest.getAttributo("durataCerta") == null) ||
							((dest.getAttributo("durataCerta") != null && !dest.getAttributo("durataCerta").isEmpty()) && 	 
									(!"85".equalsIgnoreCase(dest.getAttributo("differimento"))))) {
						dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate")
								+ dest.getTroncone("DescrIpotConversioneAnni")
								+ " " + dest.getAttributo("anniRendita")
								+ dest.getTroncone("DescrIpotConversioneAnni2"));
					}

				}
			}
		}

		if ((dest.getAttributo("anniRendita") != null)) {

			if (!"950".equals(dest.getCodiceTariffa()))  {
				dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
						+ dest.getTroncone("DescrIpotCertezza")
						+ " " + dest.getAttributo("anniRendita")
						+ dest.getTroncone("DescrIpotCertezza2"));
			}
			/*
			if (("900".equals(dest.getCodiceTariffa())) ||
					("910".equals(dest.getCodiceTariffa())))  {
				dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
						+ dest.getTroncone("DescrIpotCertezzaCondGenerali"));

			}*/
		}

		dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
				+ dest.getTroncone("DescrIpotFrazionamento")
				+ " " + output.getFrazionamentoPlurale());

		if ("si".equalsIgnoreCase(dest.getAttributo("anticipata"))) {
			dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
					+ " anticipate.");
		} else {
			dest.addAttributo("ipotesiOpzione", dest.getAttributo("ipotesiOpzione")
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
			}
		} 

		// Rinuncia Riscatto 
		//dest.addAttributo("ipotesiOpzione","");
		LetteraOpzioneReversibilita.impostaIpotesiOpzioneRinunciaRiscatto(dest, output);

	}	

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaRigaPrestazioniVita(Polizza dest, WSOpzioniBean output) {

		if (("3".equals(dest.getRamoMinisteriale()))   && 
				("C".equalsIgnoreCase(dest.getTipoPrestazione())) &&
				(dest.getAttributo("durataCerta") != null && !dest.getAttributo("durataCerta").isEmpty()) &&	
				("85".equalsIgnoreCase(dest.getAttributo("differimento")))) {
			dest.addAttributo("descrizioneOpzionePrestazioniVita",
					dest.getTroncone("PrestVitaRenditaAnnuaCerta85"));
		} else {
			dest.addAttributo("descrizioneOpzionePrestazioniVita",
					dest.getTroncone("PrestVitaRenditaAnnuaCertaAnni")
					+ dest.getAttributo("anniRendita")
					+ dest.getTroncone("PrestVitaRenditaAnnuaCertaAnni2"));
		}

		if ("U".equalsIgnoreCase(dest.getCodicePremio())){
			dest.addAttributo("descrizioneOpzionePrestazioniVita", 
					dest.getAttributo("descrizioneOpzionePrestazioniVita")
					+ " e finchè l'Assicurato è in vita,");
		}

		dest.addAttributo("descrizioneOpzionePrestazioniVita",
				dest.getAttributo("descrizioneOpzionePrestazioniVita")
				+ " in rate "
				+ " " + output.getFrazionamentoPlurale());

		if ("si".equalsIgnoreCase(dest.getAttributo("anticipata"))) {
			dest.addAttributo("descrizioneOpzionePrestazioniVita", dest.getAttributo("descrizioneOpzionePrestazioniVita")
					+ " anticipate, ciascuna di € ");
		} else {
			dest.addAttributo("descrizioneOpzionePrestazioniVita", dest.getAttributo("descrizioneOpzionePrestazioniVita")
					+ " posticipate, ciascuna di € ");
		}
		dest.addAttributo("descrizioneOpzionePrestazioniVita", dest.getAttributo("descrizioneOpzionePrestazioniVita")
				+ " " + dest.getAttributo("importoRataRenditaFrazionata")
				+ ".");
	}

	/**
	 * @param dest
	 * @param output
	 */
	private static void impostaRigaPrestazioniACLS(Polizza dest, WSOpzioniBean output) {

		dest.addAttributo("descrizioneOpzioneACLS", "");

		if (dest.getRenditaGarantita75() != null && !"".equals(dest.getRenditaGarantita75())) {
			dest.addAttributo("descrizioneOpzioneACLS", dest.getTroncone("PrestVitaRenditaAnnuaCertaAnni")
					+ dest.getAttributo("anniRendita")
					+ dest.getTroncone("PrestVitaRenditaAnnuaCertaACLS2")
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

		if (("3".equals(dest.getRamoMinisteriale()))   &&
				("C".equalsIgnoreCase(dest.getTipoPrestazione())) &&
				(dest.getAttributo("durataCerta") != null && !dest.getAttributo("durataCerta").isEmpty()) &&
				("85".equalsIgnoreCase(dest.getAttributo("differimento")))) {
			dest.addAttributo("descrizioneOpzione",dest.getTroncone("PrestMorteRenditaCerta85"));

		}
		else {
			dest.addAttributo("descrizioneOpzione",dest.getTroncone("PrestMorteRenditaCertaAnni")
					+ output.getDataFineDiffReversibilitaMorteAssic()
					+ ") in rate "
					+ " " + output.getFrazionamentoPlurale());


			if ("si".equalsIgnoreCase(dest.getAttributo("anticipata"))) {
				dest.addAttributo("descrizioneOpzione", dest.getAttributo("descrizioneOpzione")
						+ " anticipate");
			} else {
				dest.addAttributo("descrizioneOpzione", dest.getAttributo("descrizioneOpzione")
						+ " posticipate");
			}

			dest.addAttributo("descrizioneOpzione", dest.getAttributo("descrizioneOpzione")
					+ dest.getTroncone("PrestMorteRenditaCerta2")
					+ output.getFrazionamentoSingolare()
					+ " " + dest.getTroncone("PrestMorteRenditaCerta3")
					+ " " + output.getImportoRataRenditaFrazionata()
					+ dest.getTroncone("PrestMorteRenditaCerta4")
					+ " " + output.getFrazionamentoSingolare()
					+ " scadente il " + output.getDataFineDiffReversibilitaMorteAssic()
					+ ".");
		}
	}
}
