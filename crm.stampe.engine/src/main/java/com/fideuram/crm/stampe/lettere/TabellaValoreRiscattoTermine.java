package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PucDao;
import com.fideuram.utils.LoggingUtils;


/*
 * RISCATTO A TERMINE SENZA HP
 * 
*/
public class TabellaValoreRiscattoTermine extends LetteraEngine{

    public TabellaValoreRiscattoTermine(int comID) throws WebServiceClientException {
        super(comID);
    }

    public  void impostaTabellaValoreRiscatto(Polizza dest) throws StampeInfoException, WebServiceClientException, PucException, DaoException {

        dest.addAttributo("labelTabellaValutazione", "");
        dest.addAttributo("labelIpotesiConsiderate", "");
        dest.addAttributo("ipotesiConsiderate", "");
        DescrizioniComuni.impostaDescrizioneIpotesiConsiderate(dest);

        if ("1".equals(dest.getRamoMinisteriale())) {
            if (dest.getDataUltimaRivalutazioneFineDifferimento() != null &&
                    !dest.getDataUltimaRivalutazioneFineDifferimento().isEmpty()) {
                dest.addAttributo("labelDescrizioneRivalutazioni", dest.getTroncone("DescrRivalMaturate")
                        + " " + dest.getDataUltimaRivalutazioneFineDifferimento()
                        + " " + dest.getTroncone("DescrUltimaRicorrenza")
                        + ".");
            }
        }


        if ("V".equalsIgnoreCase(dest.getTipoFormaAssicurazione())) {
            dest.addAttributo("labelTabellaValutazione", dest.getTroncone("DescrValutTermineFineDiff"));


            if ("1".equals(dest.getRamoMinisteriale())) {

                if ((dest.getLiquidazioni() != null && !dest.getLiquidazioni().isEmpty() &&
                        dest.getLiquidazioni().get(0).getImportoPrestito() != null) &&
                        ("0.00".equals(dest.getLiquidazioni().get(0).getImportoPrestito()))) {
                    dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate") + dest.getTroncone("DescrRestituzionePrestito"));
                }

                //DescrCorresponsPremiPattuiti
                if ((!"RD".equals(dest.getCodiceSottostato())) &&
                        (!"AF".equalsIgnoreCase(dest.getCodiceSottostato())) &&
                        (!"U".equalsIgnoreCase(dest.getCodicePremio()))) {
                    dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate") + " " + dest.getTroncone("DescrCorresponsPremiPattuiti"));
                }
            } else {   // ramo 3
                if ("A".equalsIgnoreCase(dest.getCodicePremio())) {
                    dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate") + " " + dest.getTroncone("DescrComplPianoRisParz"));
                } else {
                    dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate") + " " + dest.getTroncone("DescrCorresponsPremiAssenzaRisc"));
                }
            }

            // RIGA PRESTAZIONE VITA
            impostaRigaPrestazioniVita(dest);

        } else {
            //------------ CASO MORTE solo per Vita Intera --------
            dest.addAttributo("labelTabellaValutazione", dest.getTroncone("DescrValutTermineFinePagamPremi"));

            if ((dest.getLiquidazioni() != null && !dest.getLiquidazioni().isEmpty() &&
                    dest.getLiquidazioni().get(0).getImportoPrestito() != null) &&
                    ("0.00".equals(dest.getLiquidazioni().get(0).getImportoPrestito()))) {
                dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate")
                        + dest.getTroncone("DescrRestituzionePrestito"));
            }

            if ("VI".equals(dest.getCodiceGruppo())) {
                String dataPremio = "";
                if (!"RD".equalsIgnoreCase(dest.getCodiceSottostato())) {
                    dataPremio = dest.getDataPremiDaIncassare();
                } else {
                    dataPremio = dest.getDataUltimaRataPagata();
                }
                dest.addAttributo("ipotesiConsiderate", dest.getAttributo("ipotesiConsiderate")
                        + dest.getTroncone("DescrCorresponsPremioScadenza") + " " + dataPremio);
            }

            // RIGA PRESTAZIONE MORTE
            getRigaPrestazioniMorte(dest);
        }

        //------------ VALORE DI RISCATTO ----------------
        getRigaValoreRiscatto(dest);

    }

    public  void impostaRigaPrestazioniVita(Polizza dest) throws DaoException, WebServiceClientException, PucException {

        dest.addAttributo("dataRiferimentoPrestazioniVita", "");
        dest.addAttributo("importoPrestazioniVita", "");
        dest.addAttributo("descrizionePrestazioniVita", "");

        if (dest.getImportoPrestazioniVita() != null && !"".equals(dest.getImportoPrestazioniVita())) {

            //DATA RIFERIMENTO
            if ("R".equalsIgnoreCase(dest.getTipoPrestazione())) {
                dest.addAttributo("dataRiferimentoPrestazioniVita", dest.getDataErogazioneRendita());
            } else {
                dest.addAttributo("dataRiferimentoPrestazioniVita", dest.getDataFineDifferimento());
            }

            //IMPORTO PRESTAZIONE VITA
            dest.addAttributo("importoPrestazioniVita", dest.getImportoPrestazioniVita());

            //DESCRIZIONE
            if ("1".equals(dest.getRamoMinisteriale())) {
                //dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaRenditaAnnuaLordaVitalizia"));

                if (dest.getImportoBonus() != null && !"".equals(dest.getImportoBonus())) {
                    dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaRenditaAnnuaLordaVitaliziaBonus"));
                } else {
                    dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaRenditaAnnuaLordaVitalizia"));
                }

                if ((dest.getClasse() != null && dest.getClasse().equalsIgnoreCase("rd")) &&
                        (dest.getDescrizioneFondoSintetica() != null &&
                                (dest.getDescrizioneFondoSintetica().trim().equalsIgnoreCase("previ")))) {

                 //   if(dest.getSospensioneScadenza()==null)

                        dest.setSospensioneScadenza(new PucDao(comID).getPraticaScadenzaSospesa(dest.getNumero(),dest.getDataScadenza()));

                    if (dest.getSospensioneScadenza().isExistPratica() && dest.getSospensioneScadenza().getPreavvisoInGiorni() > 365) {
                        dest.addAttributo("descrizionePrestazioniVita", dest.getAttributo("descrizionePrestazioniVita")
                                + " " + dest.getTroncone("PrestVitaRinunciaRiscatto")
                                + " " + dest.getSospensioneScadenza().getRichiestaToString());

                    }
                    LoggingUtils.info("importoRiscatto: <<<<<<<<  " + dest.getAttributo("importoRiscatto"));
                    LoggingUtils.info("descrizioneRiscatto: <<<<<<<<  " + dest.getAttributo("descrizioneRiscatto"));
                    /*
                    PucManagerPortWS pucClient = ClientWsFactory.getInstance().getPucClient();
                    ScadenzaSospesaVO scadenzaSospesa = null;
                    try {
                        scadenzaSospesa = pucClient.getPraticaScadenzaSospesaByNumeroPolizza(new Long(dest.getNumero()));
                    } catch (ServiceException_Exception e) {
                        throw new PucException(e);
                    }
                    if (scadenzaSospesa != null && scadenzaSospesa.getDataRichiesta() != null) {
                        long differenzaGiorni;
                        try {
                            String dataRichiesta = DateUtils.formatDate(scadenzaSospesa.getDataRichiesta(), "dd/MM/yyyy");
                            if ((dataRichiesta != null) && (!dataRichiesta.equals(""))) {
                                differenzaGiorni = (long) DateUtils.dateDiff(DateUtils.getDate(dataRichiesta, Costanti.FORMATO_DATA),
                                        DateUtils.getDate(dest.getDataScadenza(), Costanti.FORMATO_DATA),
                                        Calendar.DAY_OF_YEAR);

                                if (differenzaGiorni > 365) {
                                    dest.addAttributo("descrizionePrestazioniVita", dest.getAttributo("descrizionePrestazioniVita")
                                            + " " + dest.getTroncone("PrestVitaRinunciaRiscatto")
                                            + " " + dataRichiesta);

                                }
                            }
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    */
                }

            } else {
                if ("R".equalsIgnoreCase(dest.getTipoPrestazione())) {
                    dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaImportoMinimoGarantito"));
                } else {
                    dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaCapitaleMinimoGarantito"));
                }
            }
        }
    }

    public void getRigaPrestazioniMorte(Polizza dest) {

        dest.addAttributo("dataRiferimentoPrestazioniMorte", "");
        dest.addAttributo("importoPrestazioniMorte", "");
        dest.addAttributo("descrizionePrestazioniMorte", "");

        if (dest.getImportoCasoMorteRivalutato() != null && !"".equals(dest.getImportoCasoMorteRivalutato())) {

            //DATA RIFERIMENTO, IMPORTO PRESTAZIONE e DESCRIZIONE PRESTAZIONE MORTE
            if ("3".equals(dest.getRamoMinisteriale())) {
                dest.addAttributo("dataRiferimentoPrestazioniMorte", dest.getAttributo("dataValutazione"));
            } else {
                dest.addAttributo("dataRiferimentoPrestazioniMorte", dest.getDataUltimaRivalutazioneFineDifferimento());
            }

            dest.addAttributo("importoPrestazioniMorte", dest.getImportoCasoMorteRivalutato());

            //dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteCapitaleMaturato"));
            if (dest.getImportoBonus() != null && !"".equals(dest.getImportoBonus())) {
                dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteCapitaleMaturatoBonus"));
            } else {
                dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteCapitaleMaturato"));
            }

            if (dest.getRenditaGarantita75() != null && !"".equals(dest.getRenditaGarantita75())) {
                dest.addAttributo("descrizionePrestazioniMorte", dest.getAttributo("descrizionePrestazioniMorte")
                        + dest.getTroncone("ACLSPerdita"));
            }

        }
    }

    public void getRigaValoreRiscatto(Polizza dest) throws WebServiceClientException, PucException {

        dest.addAttributo("dataRiferimentoRiscatto", "");
        //dest.addAttributo("importoRiscatto", "");
        dest.addAttributo("descrizioneRiscatto", "");

        // SE POLIZZA DI CAPITALE NON DEVE USCIRE LA RIGA SUL TEMPLATE
        if ("R".equals(dest.getTipoPrestazione()) ||
                ("C".equalsIgnoreCase(dest.getTipoPrestazione()) && "3".equalsIgnoreCase(dest.getRamoMinisteriale()) && "N".equals(dest.getProdottoGarantito()))) {
            dest.addAttributo("dataRiferimentoRiscatto", dest.getDataFineDifferimento());
        }

        if ("VI".equalsIgnoreCase(dest.getClasse())) {
            dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrValoreRiscattoLordo"));

            DescrizioniComuni.impostaDescrizioneInteressiRitardatoPagamento(dest);

        } else {
            if ("R".equalsIgnoreCase(dest.getTipoPrestazione())) {

                if ("3".equals(dest.getRamoMinisteriale())) {
                    dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrRiscattoImportoMinimoGarantitoFineDifferimento"));
                } else {
                    dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrValoreRiscattoLordoFD"));
                }
                try {
                    if ((dest.getClasse() != null && dest.getClasse().equalsIgnoreCase("rd")) &&
                            (dest.getDescrizioneFondoSintetica() != null &&
                                    (dest.getDescrizioneFondoSintetica().trim().equalsIgnoreCase("previ") ||
                                            dest.getDescrizioneFondoSintetica().trim().equalsIgnoreCase("ful")))) {

                        //if(dest.getSospensioneScadenza()==null)
                             dest.setSospensioneScadenza(new PucDao(comID).getPraticaScadenzaSospesa(dest.getNumero(),dest.getDataScadenza()));

                        if (dest.getSospensioneScadenza().isExistPratica() && dest.getSospensioneScadenza().getPreavvisoInGiorni() > 365) {
                            dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
                                    + " " + dest.getTroncone("DescrRichiestaMaggiorazione")
                                    + " " + dest.getSospensioneScadenza().getRichiestaToString());
                        }
                        LoggingUtils.info("importoRiscatto: <<<<<<<<  " + dest.getAttributo("importoRiscatto"));
                        LoggingUtils.info("descrizioneRiscatto: <<<<<<<<  " + dest.getAttributo("descrizioneRiscatto"));
                        /*PucManagerPortWS pucClient = ClientWsFactory.getInstance().getPucClient();
                        ScadenzaSospesaVO scadenzaSospesa = pucClient.getPraticaScadenzaSospesaByNumeroPolizza(new Long(dest.getNumero()));
                        if (scadenzaSospesa != null && scadenzaSospesa.getDataRichiesta() != null) {
                            long differenzaGiorni;
                            try {
                                String dataRichiesta = DateUtils.formatDate(scadenzaSospesa.getDataRichiesta(), "dd/MM/yyyy");
                                if ((dataRichiesta != null) && (!dataRichiesta.equals(""))) {
                                    differenzaGiorni = (long) DateUtils.dateDiff(DateUtils.getDate(dataRichiesta, Costanti.FORMATO_DATA),
                                            DateUtils.getDate(dest.getDataScadenza(), Costanti.FORMATO_DATA),
                                            Calendar.DAY_OF_YEAR);

                                    if (differenzaGiorni > 365) {
                                        dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
                                                + " " + dest.getTroncone("DescrRichiestaMaggiorazione")
                                                + " " + dataRichiesta);

                                    }
                                }
                            } catch (Exception e) {
                                throw new RuntimeException(e);
                            }
                        }*/
                    } else {
                        DescrizioniComuni.impostaDescrizioneRichiesta(dest);

                        if ("1".equals(dest.getRamoMinisteriale())) {
                            DescrizioniComuni.impostaDescrizioneInteressiRitardatoPagamento(dest);
                        }
                    }
                } catch (DaoException e) {
                    throw new PucException(e);
                }
            } else {   // --> se di capitale
                if ("3".equals(dest.getRamoMinisteriale())) {
                    dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrRiscattoRenditaAnnuaLorda") + " " + dest.getDataRiferimentoQuote());
                }
            }
        }
    }
}