package com.fideuram.crm.stampe.lettere;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

import java.util.Date;

public class TabellaPrestazioniAssicurate {

	public static void impostaTabellaPrestazioniAssicurate(Polizza dest) {

		// COLONNA GARANZIE COMPLEMENTARI
		impostaLabelgaranziecomplementari(dest);

		// Descrizione Ipotesi Considerate
		DescrizioniComuni.impostaDescrizioneIpotesiConsiderate(dest);

		// ------------ CASO VITA ------------
		impostaRigaPrestazioniVita(dest);

		// ------------ CASO MORTE ------------
		impostaRigaPrestazioniMorte(dest);

		// ------------ ACLS (75, 80, 85) ----------------
		impostaRigaPrestazioniACLS(dest);

		// ------------ RIFERIMENTO COMPLEMENTARE ------------
		impostaRigaPrestazioniComplementari(dest);

		// ------------ RIFERIMENTO MASSIMALE ------------
		impostaRigaPrestazioniMassimali(dest);

	}

	private static void impostaRigaPrestazioniVita(Polizza dest) {

		dest.addAttributo("dataRiferimentoPrestazioniVita", "");
		dest.addAttributo("importoPrestazioniVita", "");
		dest.addAttributo("descrizionePrestazioniVita", "");

		if ("FAO".equalsIgnoreCase(dest.getDescrizioneFondoSintetica().trim())
				|| "PORTF".equalsIgnoreCase(dest.getDescrizioneFondoSintetica().trim())
				|| "FULAS".equalsIgnoreCase(dest.getDescrizioneFondoSintetica().trim())) {
			dest.addAttributo("dataRiferimentoPrestazioniVita",
					dest.getDataFineDifferimento());
			dest.addAttributo("importoPrestazioniVita", "(*)");
			dest.addAttributo("descrizionePrestazioniVita",
					dest.getTroncone("PrestVitaDescrizioneFAO"));

		} else 	if (dest.getImportoPrestazioniVita() != null
				&& !"".equals(dest.getImportoPrestazioniVita())) {

			if ("3".equals(dest.getRamoMinisteriale())) {
				if ("R".equals(dest.getTipoPrestazione())) {
					dest.addAttributo("dataRiferimentoPrestazioniVita",
							dest.getDataErogazioneRendita());

					if ("GR".equalsIgnoreCase(dest.getCodiceSottostato()))	{
						dest.addAttributo(
								"dataRiferimentoPrestazioniVita", "31/12/" + dest.getAttributo("dataValutazione").substring(6,10));
					}
				} else {
					dest.addAttributo("dataRiferimentoPrestazioniVita",
							dest.getDataFineDifferimento());
				}

			} else {
				if  ("GR".equalsIgnoreCase(dest.getCodiceSottostato()) ||
					("GD".equalsIgnoreCase(dest.getCodiceSottostato()))) {
					Date dataRiferimento =
						DateUtils.parseDate(
								dest.getDataUltimaRivalutazioneFineDifferimento(), "dd/MM/yyyy");

					dataRiferimento = DateUtils.addYears(dataRiferimento, 1);

					dest.addAttributo(
							"dataRiferimentoPrestazioniVita",
							DateUtils.formatDate(dataRiferimento, "dd/MM/yyyy")	);

				} else {
					if ("V".equalsIgnoreCase(dest.getTipoFormaAssicurazione())) {
					dest.addAttributo(
							"dataRiferimentoPrestazioniVita",
							dest.getDataErogazioneRendita());
					}
				}
			}

			// IMPORTO PRESTAZIONE VITA
			dest.addAttributo("importoPrestazioniVita",
					dest.getImportoPrestazioniVita());

			if ("R".equalsIgnoreCase(dest.getTipoPrestazione())
					&& "FUL".equalsIgnoreCase(dest.getDescrizioneFondoSintetica().trim()))  {

				dest.addAttributo("descrizionePrestazioniVita",
						dest.getTroncone("PrestVitaRenditaAnnuaVitaliziaDifferita"));

			}
			else if ("R".equalsIgnoreCase(dest.getTipoPrestazione())) {
				if (!"FAP"
						.equalsIgnoreCase(dest.getDescrizioneFondoSintetica().trim())) {

					if (dest.getImportoBonus() != null && !"".equals(dest.getImportoBonus())) {
						dest.addAttributo(
								"descrizionePrestazioniVita",
								dest.getTroncone("PrestVitaRenditaVitaliziaDifferitaBonus")
								);
					} else {
						dest.addAttributo(
								"descrizionePrestazioniVita",
								dest.getTroncone("PrestVitaRenditaVitaliziaDifferita")
								);
					}

					dest.addAttributo(
							"descrizionePrestazioniVita",
							dest.getAttributo("descrizionePrestazioniVita")
									+ " "
									+ dest.getDataUltimaRivalutazioneFineDifferimento()
									+ dest.getTroncone("PrestVitaRenditaVitaliziaDifferita2"));

				} else {
                    dest.addAttributo("descrizionePrestazioniVita",dest.getTroncone("PrestVitaRenditaVitaliziaMinimaDifferita"));
				}

			} else if ("C".equalsIgnoreCase(dest.getTipoPrestazione())) {

				if ("1".equals(dest.getRamoMinisteriale())) {
					dest.addAttributo("descrizionePrestazioniVita",
							dest.getTroncone("PrestVitaCapitaleDifferitoMinimo"));

				} else {
					dest.addAttributo("descrizionePrestazioniVita",
							dest.getTroncone("PrestVitaCapitaleMinimoGarantito"));
				}
			}
		}

		if ("3".equals(dest.getRamoMinisteriale()) && ("GR".equalsIgnoreCase(dest.getCodiceSottostato())))	{
			dest.addAttributo("descrizionePrestazioniVita",
					dest.getTroncone("RiduzioneRenditaVitalizia"));
		}



	}

	public static void impostaLabelgaranziecomplementari(Polizza dest) {

		// LABEL DESCRIZIONE COLONNA TABELLA PER COMPLEMENTARI
		dest.addAttributo("labelGaranzieComplementari", "");

		if (dest.getCapitaleMorteInfortunio() != null  && !"".equals(dest.getCapitaleMorteInfortunio())
			|| dest.getCapitaleMorteInfortunioStradale() != null && !"".equals(dest.getCapitaleMorteInfortunioStradale())
			|| dest.getCapitaleMalattiaGrave() != null && !"".equals(dest.getCapitaleMalattiaGrave())
			|| dest.getCapitaleSecondoDecesso() != null && !"".equals(dest.getCapitaleSecondoDecesso())
			|| dest.getMassimaleInfortunio() != null && !"".equals(dest.getMassimaleInfortunio())
			|| dest.getMassimaleMalattia() != null && !"".equals(dest.getMassimaleMalattia())) {
			dest.addAttributo("labelGaranzieComplementari",
					"GARANZIE COMPLEMENTARI");
		}

	}

	private static void impostaRigaPrestazioniMorte(Polizza dest) {


     //   TO DO
		dest.addAttributo("dataRiferimentoPrestazioniMorte", "");
		dest.addAttributo("importoPrestazioniMorte", "");
		dest.addAttributo("descrizionePrestazioniMorte", "");


		if ((dest.getImportoCasoMorteRivalutato() != null)
            &&(dest.getImportoCasoMorteRivalutato() != "") || (dest.getMacroFamiglia()==2))
        {

			if ("3".equals(dest.getRamoMinisteriale())) {
				dest.addAttributo("dataRiferimentoPrestazioniMorte",
						dest.getAttributo("dataValutazione"));
			} else {
				dest.addAttributo("dataRiferimentoPrestazioniMorte",
						dest.getDataUltimaRivalutazioneFineDifferimento());
			}

			dest.addAttributo("importoPrestazioniMorte",
					dest.getImportoCasoMorteRivalutato());

			if ("3".equals(dest.getRamoMinisteriale())) {
				dest.addAttributo("descrizionePrestazioniMorte",
						dest.getTroncone("PrestMorteDecesso"));
			} else if ("C".equalsIgnoreCase(dest.getTipoPrestazione())
					|| dest.isControassicurazione()
					|| !"GD".equalsIgnoreCase(dest.getCodiceSottostato())) {

				if (dest.getImportoBonus() != null && !"".equals(dest.getImportoBonus())) {
					dest.addAttributo("descrizionePrestazioniMorte",
							dest.getTroncone("PrestMorteGarantitoBonus"));

				} else {
					dest.addAttributo("descrizionePrestazioniMorte",
							dest.getTroncone("PrestMorteGarantito"));
				}
			} else {
				dest.addAttributo("descrizionePrestazioniMorte",
						dest.getTroncone("Descrdatariferimento"));
			}

            if (dest.getMacroFamiglia() ==2)
                dest.addAttributo("importoPrestazioniMorte", NumberUtils.formatCurrency(
                        new Double(dest.getTotalePrestazioniCV()),
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI) );

                dest.addAttributo("dataRiferimentoPrestazioniMorte",
                        DateUtils.formatDate(new Date(), "dd/MM/yyyy")	);

		}
	}

	public static void impostaRigaPrestazioniACLS(Polizza dest) {

		dest.addAttributo("dataRicorrenza75", "");
		dest.addAttributo("renditaGarantita75", "");
		dest.addAttributo("dataRicorrenza80", "");
		dest.addAttributo("renditaGarantita80", "");
		dest.addAttributo("dataRicorrenza85", "");
		dest.addAttributo("renditaGarantita85", "");
		dest.addAttributo("descrizioneACLS", "");

		if (dest.getRenditaGarantita75() != null
				&& !"".equals(dest.getRenditaGarantita75())) {

			dest.addAttributo("dataRicorrenza75", dest.getDataRicorrenza75());

			dest.addAttributo("renditaGarantita75",
					dest.getRenditaGarantita75());

			dest.addAttributo("dataRicorrenza80", dest.getDataRicorrenza80());

			dest.addAttributo("renditaGarantita80",
					dest.getRenditaGarantita80());

			dest.addAttributo("dataRicorrenza85", dest.getDataRicorrenza85());

			dest.addAttributo("renditaGarantita85",
					dest.getRenditaGarantita85());

			dest.addAttributo("descrizioneACLS", dest.getTroncone("ACLS"));
		}
	}

	public static void impostaRigaPrestazioniComplementari(Polizza dest) {

		dest.addAttributo("dataRiferimentoComplementare", "");
		dest.addAttributo("CapitaleMorteInfortunio", "");
		dest.addAttributo("CapitaleMorteInfortunioStradale", "");
		dest.addAttributo("CapitaleMalattiaGrave", "");
		dest.addAttributo("CapitaleSecondoDecesso", "");
		dest.addAttributo("descrizioneComplementareComune", "");
		dest.addAttributo("descrizioneCapitaleMorteInfortunio", "");
		dest.addAttributo("descrizioneCapitaleMorteInfortunioStradale", "");
		dest.addAttributo("descrizioneCapitaleMalattiaGrave", "");
		dest.addAttributo("descrizioneCapitaleSecondoDecesso", "");

      
        if ((dest.getCapitaleMorteInfortunio() != null && !"".equals(dest
				.getCapitaleMorteInfortunio()))
				|| (dest.getCapitaleMorteInfortunioStradale() != null && !""
						.equals(dest.getCapitaleMorteInfortunioStradale()))
				|| (dest.getCapitaleMalattiaGrave() != null && !"".equals(dest
						.getCapitaleMalattiaGrave()))
				|| (dest.getCapitaleSecondoDecesso() != null && !"".equals(dest
						.getCapitaleSecondoDecesso()))) {

			dest.addAttributo("descrizioneComplementareComune",
					dest.getTroncone("ComplComune"));

			if (dest.getCapitaleMorteInfortunio() != null
					&& !"".equals(dest.getCapitaleMorteInfortunio())) {
				dest.addAttributo("CapitaleMorteInfortunio",
						dest.getCapitaleMorteInfortunio());

				dest.addAttributo("descrizioneCapitaleMorteInfortunio",
						dest.getTroncone("ComplMorteInfortunio"));
			}
			if (dest.getCapitaleMorteInfortunioStradale() != null
					&& !"".equals(dest.getCapitaleMorteInfortunioStradale())) {
				dest.addAttributo("CapitaleMorteInfortunioStradale",
						dest.getCapitaleMorteInfortunioStradale());

				dest.addAttributo("descrizioneCapitaleMorteInfortunioStradale",
						dest.getTroncone("ComplMorteInfortunioStradale"));
			}
			if (dest.getCapitaleMalattiaGrave() != null
					&& !"".equals(dest.getCapitaleMalattiaGrave())) {
				dest.addAttributo("CapitaleMalattiaGrave",
						dest.getCapitaleMalattiaGrave());

				dest.addAttributo("descrizioneCapitaleMalattiaGrave",
						dest.getTroncone("ComplMalattiaGrave"));
			}
			if (dest.getCapitaleSecondoDecesso() != null
					&& !"".equals(dest.getCapitaleSecondoDecesso())) {
				dest.addAttributo("CapitaleSecondoDecesso",
						dest.getCapitaleSecondoDecesso());

				dest.addAttributo("descrizioneCapitaleSecondoDecesso",
						dest.getTroncone("ComplSecondoDecesso"));
			}

			dest.addAttributo("dataRiferimentoComplementare",
						dest.getDataUltimaRivalutazioneFineDifferimento());

		}
	}

	public static void impostaRigaPrestazioniMassimali(Polizza dest) {

		dest.addAttributo("dataRiferimentoMassimale", "");
		dest.addAttributo("importoMassimaleInfortunio", "");
		dest.addAttributo("importoMassimaleMalattia", "");
		dest.addAttributo("descrizioneMassimaleComune", "");
		dest.addAttributo("descrizioneMassimaleInfortunio", "");
		dest.addAttributo("descrizioneMassimaleMalattia", "");


		if ((dest.getMassimaleInfortunio() != null && !"".equals(dest
				.getMassimaleInfortunio()))
			|| (dest.getMassimaleMalattia() != null && !"".equals(dest
				.getMassimaleMalattia()))) {
			dest.addAttributo("descrizioneMassimaleComune",
					dest.getTroncone("MassimaliComune"));

			if (dest.getMassimaleInfortunio() != null
					&& !"".equals(dest.getMassimaleInfortunio())) {
				dest.addAttributo("importoMassimaleInfortunio",
						dest.getMassimaleInfortunio());
				dest.addAttributo("descrizioneMassimaleInfortunio",
						dest.getTroncone("MassimaliInfortunio"));
			}
			if (dest.getMassimaleMalattia() != null
					&& !"".equals(dest.getMassimaleMalattia())) {
				dest.addAttributo("importoMassimaleMalattia",
						dest.getMassimaleMalattia());
				dest.addAttributo("descrizioneMassimaleMalattia",
						dest.getTroncone("MassimaliMalattia"));
			}
			dest.addAttributo("dataRiferimentoMassimale",dest.getDataUltimaRivalutazioneFineDifferimento());

		}
	}

}
