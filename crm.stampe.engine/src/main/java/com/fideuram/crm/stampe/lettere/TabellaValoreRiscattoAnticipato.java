package com.fideuram.crm.stampe.lettere;

import java.util.Calendar;
import java.util.Date;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.utils.DateUtils;

public class TabellaValoreRiscattoAnticipato extends LetteraEngine {

    public TabellaValoreRiscattoAnticipato(int comID) throws WebServiceClientException {
		super(comID);
	}

	public void impostaTabellaValoreRiscatto(Polizza dest) throws PucException {

        //------------ CASO VITA ------------
        if( (!"C".equalsIgnoreCase(dest.getTipoPrestazione()))&&(!("1".equals(dest.getRamoMinisteriale()))) ){
             impostaRigaPrestazioniVita(dest);
        }


        //------------ CASO MORTE ------------
        impostaRigaPrestazioniMorte(dest);

        //------------ VALORE DI RISCATTO ----------------
        impostaRigaValoreRiscatto(dest);

        //------------ ECCEDENZA ------------
        if ("1".equals(dest.getRamoMinisteriale())) {
            impostaRigaEccedenza(dest);
        }

    }

    public static void impostaRigaPrestazioniVita(Polizza dest) {

        dest.addAttributo("dataRiferimentoPrestazioniVita", "");
        dest.addAttributo("importoPrestazioniVita", "");
        dest.addAttributo("descrizionePrestazioniVita", "");

        if (dest.getImportoPrestazioniVita() != null && !"".equals(dest.getImportoPrestazioniVita())) {

	        //DATA RIFERIMENTO
        	if ("R".equals(dest.getTipoPrestazione())) {
        		dest.addAttributo("dataRiferimentoPrestazioniVita", dest.getDataErogazioneRendita());
                   //IMPORTO PRESTAZIONE VITA
	                dest.addAttributo("importoPrestazioniVita", dest.getImportoPrestazioniVita());
        	} else {
        		if ("3".equals(dest.getRamoMinisteriale()))	{
        	        dest.addAttributo("dataRiferimentoPrestazioniVita", dest.getDataFineDifferimento());
                    //IMPORTO PRESTAZIONE VITA
	                dest.addAttributo("importoPrestazioniVita", dest.getImportoPrestazioniVita());
        		}
        	} 


	        if ("FAO".equalsIgnoreCase(dest.getDescrizioneFondoSintetica().trim()) || "PORTF".equalsIgnoreCase(dest.getDescrizioneFondoSintetica().trim()) ||
	                "FULAS".equalsIgnoreCase(dest.getDescrizioneFondoSintetica().trim())) {
	            dest.addAttributo("importoPrestazioniVita", "(*)");
	            dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaDescrizioneFAO"));
	     
	        } else if ("R".equalsIgnoreCase(dest.getTipoPrestazione())) {
	
	            if ("1".equals(dest.getRamoMinisteriale())) {
	            	if (dest.getImportoBonus() != null && !"".equals(dest.getImportoBonus())) {
	                    dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaRenditaVitaliziaDifferitaBonus")
	                   	+ " " + dest.getDataUltimaRivalutazioneFineDifferimento());
	                } else {
	                    dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaRenditaVitaliziaDifferita"));
	                }
	                
	                dest.addAttributo("descrizionePrestazioniVita", dest.getAttributo("descrizionePrestazioniVita")
	                        + " " + dest.getDataUltimaRivalutazioneFineDifferimento()
	                        + dest.getTroncone("PrestVitaRenditaVitaliziaDifferita2"));
	
	            } else {    //  ramo 3
	                if ("FUL".equalsIgnoreCase(dest.getCodiceFondo().trim())) {
	                    dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaRenditaAnnuaVitaliziaDifferita"));
	                } else {
	                    dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaRenditaVitaliziaMinimaDifferita"));
	                }
	            }
	
	        } else if ("C".equalsIgnoreCase(dest.getTipoPrestazione())) {
	
	            if ("1".equals(dest.getRamoMinisteriale())) {
	                dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaCapitaleDifferitoMinimo"));
	            } else {
	                dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaCapitaleMinimoGarantito"));
	            }
	        }
        }
    }


    public static void impostaRigaPrestazioniMorte(Polizza dest) {

        dest.addAttributo("dataRiferimentoPrestazioniMorte", "");
        //dest.addAttributo("importoPrestazioniMorte", "");
        dest.addAttributo("descrizionePrestazioniMorte", "");

        //DATA RIFERIMENTO, IMPORTO PRESTAZIONE e DESCRIZIONE PRESTAZIONE MORTE
        if (dest.getImportoCasoMorteRivalutato() != null && !"".equals(dest.getImportoCasoMorteRivalutato())) {

            //dest.addAttributo("importoPrestazioniMorte", dest.getImportoCasoMorteRivalutato());

            if ("1".equals(dest.getRamoMinisteriale())) {

                dest.addAttributo("dataRiferimentoPrestazioniMorte", dest.getDataUltimaRivalutazioneFineDifferimento());

                if (dest.getImportoBonus() != null && !"".equals(dest.getImportoBonus())) {
                    dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteDecessoBonus"));
                } else {
                    dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteDecesso"));
                }
            } else {  //ramo 3
                dest.addAttributo("dataRiferimentoPrestazioniMorte", dest.getAttributo("dataValutazione"));
                dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteDecesso"));
            }
        }
    }


    private void impostaRigaValoreRiscatto(Polizza dest) throws PucException {

        dest.addAttributo("dataRiferimentoRiscatto", "");
        //dest.addAttributo("importoRiscatto", "");
        dest.addAttributo("descrizioneRiscatto", "");

        //DATA RIFERIMENTO E IMPORTO RISCATTO
        if ("C".equalsIgnoreCase(dest.getTipoPrestazione())
                || dest.isControassicurazione()
                || !"GD".equalsIgnoreCase(dest.getCodiceSottostato())
                || !"VIVA".equalsIgnoreCase(dest.getCodiceFondo().trim())
                || ("3".equals(dest.getRamoMinisteriale()))) {

            dest.addAttributo("dataRiferimentoRiscatto", dest.getAttributo("dataValutazione"));
            
           // dest.addAttributo("importoRiscatto", "";   //motore WS

        }

        if ("3".equals(dest.getRamoMinisteriale())) {
        	//chiamata al metodo che controlla se il tipo prodotto della polizza è presente
        	//nella tabella SimulatoriRiscatto, se presente viene impostato il nuovo troncone
        	boolean isSimulatoreProdotto = false;
        	try {
				isSimulatoreProdotto = pucS.checkSimulatoreProdotto(dest.getNumero());
			} catch (ServiceException_Exception e) {
				e.printStackTrace();
				throw new PucException(e);
			}
        	if(!isSimulatoreProdotto) {
        		dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrRiscattoValoreLiquidabileRiscAntNAV"));
        	}else {
        		dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrValoreRiscattoLordoMR"));
        	}
        } else {    //ramo 1

            // DESCRIZIONE RISCATTO
            if ("SP".equalsIgnoreCase(dest.getCodiceGruppo()) || "GV".equalsIgnoreCase(dest.getCodiceGruppo())) {

                if ("AF".equalsIgnoreCase(dest.getCodiceSottostato())) {
                    dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrRiscattoValoreLiquidabileRiscAnt"));
                } else {
                    dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrRiscattoValoreLiquidabileRisc1"));
               }

            } else if ("C".equalsIgnoreCase(dest.getTipoPrestazione())
                    || dest.isControassicurazione()
                    || !"GD".equalsIgnoreCase(dest.getCodiceSottostato())
                    || !"VIVA".equalsIgnoreCase(dest.getCodiceFondo().trim())) {
         
                    if (dest.getLiquidazioni() == null || dest.getLiquidazioni().isEmpty() ||
                	    dest.getAttributo("appendice")== null) {

                	if ("AF".equalsIgnoreCase(dest.getCodiceSottostato())) {
                        dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrRiscattoValoreLiquidabileRiscAntPremi"));
                        	//+ " " + dest.getDataUltimaRataPagata()
                            //+ " compresa.");
                	} else {
                        dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrRiscatto"));
                        	//+ " " + dest.getDataUltimaRataPagata()
                            //+ " compresa.");
                   	}
                } else {   //riscatto parziale
                    dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrRiscattoValoreLordoAppendice1") +
                    " " + dest.getAttributo("appendice"));
             
                	if ("AF".equalsIgnoreCase(dest.getCodiceSottostato())) {
                		dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
                            + dest.getTroncone("DescrRiscattoValoreLordoAppendiceAnt2"));
                	} else {
                		dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
                            + dest.getTroncone("DescrRiscattoValoreLordoAppendice2"));
                	}
                }
            }

            if (!"".equals(dest.getAttributo("totalePremiRivalutatiIpotizzati"))) {
                dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
                        + dest.getTroncone("DescrRiscattorivalutazioniFuture")
                        + " " + dest.getCodiceFondo() + " pari al "
                        + dest.getAttributo("tassoIsvap") + ".");
            }

            //todo    TCK828
             if(dest.getValorePrestito().hasPrestitiErogati()){
                 dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
                         + dest.getTroncone("Prestito"));
             }

            if ((dest.getEccedenza()) != null && !"".equals(dest.getEccedenza())) {
         		dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
                + dest.getTroncone("EccedenzaGaranziadiCapitale") + " " + dest.getDataFineDifferimento() + " come di seguito indicato.");
            }

            DescrizioniComuni.impostaDescrizioneInteressiRitardatoPagamento(dest);
            

            //impostazione campo "Qualora"
            impostaDescrizioneQualora(dest);
        }
    }

    private static void impostaRigaEccedenza(Polizza dest) {

        dest.addAttributo("dataRiferimentoEccedenza", "");
        dest.addAttributo("descrizioneEccedenza", "");

        //DESCRIZIONE ECCEDENZA
        if ((dest.getAttributo("importoEccedenza")) != null && !"".equals(dest.getAttributo("importoEccedenza"))) {
            dest.addAttributo("dataRiferimentoEccedenza", dest.getDataScadenza());
            //dest.addAttributo("importoEccedenza", dest.getEccedenza());
            dest.addAttributo("descrizioneEccedenza", dest.getTroncone("EccedenzaCapitalerichiestaRiscAnt")
            		+ " " + dest.getAttributo("dataValutazione")
            		+ ".");

            if (dest.getRenditaGarantita75() != null && !"".equals(dest.getRenditaGarantita75())) {
                if ("VIVA".equalsIgnoreCase(dest.getCodiceFondo().trim())) {
                    dest.addAttributo("descrizioneEccedenza", dest.getAttributo("descrizioneEccedenza") +
                            dest.getTroncone("EccedenzaImportoDifferenzaCapitalizzata"));
                } else {
                    dest.addAttributo("descrizioneEccedenza", dest.getAttributo("descrizioneEccedenza") +
                            dest.getTroncone("EccedenzaImportoDifferenza"));
                }
            }
        } else {
            if (dest.getRenditaGarantita75() != null && !"".equals(dest.getRenditaGarantita75())) {
                dest.addAttributo("descrizioneEccedenza", dest.getAttributo("descrizioneEccedenza") +
                        dest.getTroncone("EccedenzaComplementare"));
            }
        }
    }
    
    public static void impostaDescrizioneQualora(Polizza dest) {
    	
    	if ((dest.getDataUltimaRataPagata()!= null) && (!dest.getDataUltimaRataPagata().isEmpty())) {
            long differenzaGiorni;
            
            try {
                differenzaGiorni = (long)DateUtils.dateDiff(
                        new Date(),
                        DateUtils.getDate(dest.getDataUltimaRataPagata().toString(), Costanti.FORMATO_DATA),
                        Calendar.DAY_OF_YEAR);

                if ((differenzaGiorni >= -30) && (differenzaGiorni <= +30)) {
                	dest.addAttributo("descrizioneRiscatto", 
                			dest.getAttributo("descrizioneRiscatto") 
                			+ dest.getTroncone("Qualora"));
                 }  

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

}
