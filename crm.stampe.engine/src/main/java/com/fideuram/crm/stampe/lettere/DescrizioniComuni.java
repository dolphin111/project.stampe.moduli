package com.fideuram.crm.stampe.lettere;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.generatori.DescrizioniAssemblate;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.Liquidazione;
import com.fideuram.crm.stampe.model.Modello;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiscattoBean;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiscattoPolizzeChiuseBean;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PucDao;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;
import com.fideuram.wsclient.simulatori.ValoreSaldoPolizzaApertaRamoTerzo;

public class DescrizioniComuni extends LetteraEngine{
    public DescrizioniComuni(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param dest
	 * @param m
	 * @param com
	 */
	public void completaIntestazione(Polizza dest, Modello m, ComunicazioneVO com, DomandaVO dom) {
		// Definizione Banca
		if ("BFI".equals(m.getPolizze().get(0).getReteVendita()) || "SPI".equals(m.getPolizze().get(0).getReteVendita())) {
			m.getLettera().setReteVendita("Fideuram - Intesa Sanpaolo Private Banking");
			m.getLettera().setCitta("Roma");
		} else if ("ISPB".equals(m.getPolizze().get(0).getReteVendita())) {
			m.getLettera().setReteVendita("Intesa Sanpaolo Private Banking S.p.A.");
			m.getLettera().setCitta("Milano");
		} else if ("IWB".equals(m.getPolizze().get(0).getReteVendita())) {
			m.getLettera().setReteVendita("IW SIM S.p.A.");
			m.getLettera().setCitta("Milano");
		}
		
	    m.getLettera().setTipoProponente(DescrizioniAssemblate.getCapolettera(m.getProponente()));

		// Data scadenza
		if ("CD".equals(dest.getClasse()) || "RD".equals(dest.getClasse())) {
			dest.setLabelDataScadenza("Data di fine differimento:");

		} else if ("TE".equals(dest.getClasse()) || ("VI".equals(dest.getClasse()) && "A".equals(dest.getCodicePremio()))) {
			dest.setLabelDataScadenza("Data di scadenza del periodo pagamento premi:");

		} else if (!"CD".equals(dest.getClasse()) && !"RD".equals(dest.getClasse()) && !"VI".equals(dest.getClasse())) {
			dest.setLabelDataScadenza("Data di scadenza della durata contrattuale:");

		} else {
			dest.setLabelDataScadenza("");
		}

        if(m.getPolizze()!=null && m.getPolizze().size()>0 && m.getPolizze().get(0).isCollettiva()){

            m.getLettera().setOggetto(getOggettoCollettiva(m, com));
            m.getLettera().setTestoLettera(getCorpoLetteraCollettiva());
        }else{
		    m.getLettera().setOggetto(getOggetto(m));
            m.getLettera().setTestoLettera(getCorpoLettera());
        }

		m.getLettera().setTestoIndirizzoLettera(getCorpoIndirizzoLettera(com, dest));

		if ("1".equals(com.getTipo().getCodice())) {
			m.getLettera().setTipoComunicazione("I");

		} else if ("2".equals(com.getTipo().getCodice())) {
			m.getLettera().setTipoComunicazione("R");
		}

		//-----------  SITUAZIONE PREMI/QUOTE -------------------
		try {
			new TabellaSituazionePremi(com.getID()).impostaTabellaSituazionePremi(dest, true);
		} catch (WebServiceClientException e) {
            //Per le descrizioni comuni non si deve arrestare il processo di stampa
            LoggingUtils.error(e);
		} catch (PucException e) {
            //Per le descrizioni comuni non si deve arrestare il processo di stampa
            LoggingUtils.error(e);
        }

        if( (dest.getPolizzeProvenienza() != null)
				&& (!dest.getPolizzeProvenienza().isEmpty()))
		{
			for (Polizza pp : dest.getPolizzeProvenienza()) {
				try {
					new TabellaSituazionePremi(com.getID()).impostaTabellaSituazionePremi(pp, false);
				} catch (WebServiceClientException e) {
                    //Per le descrizioni comuni non si deve arrestare il processo di stampa
                    LoggingUtils.error(e);
				} catch (PucException e) {
                    //Per le descrizioni comuni non si deve arrestare il processo di stampa
                    LoggingUtils.error(e);
                }
            }
		}

	}

	public static String getOggettoCollettiva(Modello m, ComunicazioneVO com) {
         //return "Situazione dei pagamenti della polizza collettiva n. " + m.getPolizze().get(0).getNumero() + " al "+ m.getPolizze().get(0).getAttributo("dataRiferimento");
         //TOD0 FINISCI ST'AGONIA

         //IComunicazioneDatiInputManager inputs = FactoryManagers.getComunicazioneInputManager();
         //Map map= inputs.getValoriDiInputFromDomanda((DomandaVO) com.getDomande().get(0));
         //com.getDomande().get(0).getValoriInput().get(0).getDatoInput().getId()
         String data=  com.getDomande().get(0).getValoriInput().get(0).getValore()!=null?com.getDomande().get(0).getValoriInput().get(0).getValore():"";
         Date date=null;
         try {
              date = DateUtils.getCrmDate(data);
         } catch (ParseException e) {
             LoggingUtils.error(e);
         }
        return "Situazione dei pagamenti della polizza collettiva n. " + m.getPolizze().get(0).getNumero() + " al "+ FormatterFactory.getStandardDate(date);
    }

	public static String getOggetto(Modello m) {
		StringBuffer rv = new StringBuffer();

		if(m.getPolizze().get(0)!=null && m.getPolizze().get(0).getProdotto().endsWith("XP0U1")){
			rv.append("Polizza ").append(m.getPolizze().get(0)!=null ? m.getPolizze().get(0).getDescrizioneCommerciale().trim() :"").
			append(" - ").
			append(m.getPolizze().get(0)!=null ? m.getPolizze().get(0).getTipoLineaInvestimento(): "").
			append(" n. :").append(m.getPolizze().get(0).getNumero());
		}else{
			rv.append("Polizza ").append(m.getPolizze().get(0)!=null ? m.getPolizze().get(0).getDescrizioneCommerciale().trim() :"").
			append(" n. :").append(m.getPolizze().get(0).getNumero());
		}
		if (m.getPolizze().get(0).getPolizzeProvenienza() != null) {
			if (m.getPolizze().get(0).getPolizzeProvenienza().size() > 1) {
				//if (m.getPolizze().get(0).getPolizzeProvenienza() != null && m.getPolizze().get(0).getPolizzeProvenienza().size() > 1) {
				rv.append(" - derivante da sostituzione pol. ");
				boolean primo = true;

				for (Polizza p : m.getPolizze().get(0).getPolizzeProvenienza()) {
					rv.append((primo ? "" : ", ")).append(p.getNumero());
					primo = false;
				}
			} else {
				rv.append(" - derivante da sostituzione di polizza ");
			}
		}



		return rv.toString();
	}


    public static String getCorpoLetteraCollettiva() {
        StringBuffer rv = new StringBuffer();
        rv.append("facciamo seguito alla Sua richiesta per rimetterLe in allegato la situazione dei pagamenti effettuati sulla collettiva indicata in oggetto.");
        return rv.toString();
    }

	public static String getCorpoLettera() {
		StringBuffer rv = new StringBuffer();
		rv.append("     con la presente diamo riscontro alla sua comunicazione ");
		rv.append("e, con riferimento alla polizza in oggetto, trasmettiamo in allegato quanto da lei richiesto.");
		return rv.toString();
	}

    /**
     *
     * @param com
     * @param dest
     * @return
     */
    public static String getCorpoIndirizzoLettera(ComunicazioneVO com, Polizza dest ) {
        //todo
        StringBuffer indirizzo = new StringBuffer();

        if( (com.getIndirizzoLettera() != null)
                && (com.getIndirizzoLettera().isIndirizzoModificato() != null)
                && (com.getIndirizzoLettera().isIndirizzoModificato()) ) {
            if(dest.getNumero().startsWith("57")){
            	indirizzo.append(dest.getTroncone("IndirizzoModificatoSPI"));     
            }else{
            	indirizzo.append(dest.getTroncone("IndirizzoModificato"));
            }
        }

        return indirizzo.toString();
    }

	public static void impostaVincoloPegno(Polizza dest) {

		dest.addAttributo("descrizioneVincoloPegno", "");

		if (dest.isVincoloPegno()) {
			dest.addAttributo("descrizioneVincoloPegno", dest.getTroncone("VincoloPegno"));
		}

	}

	public static void impostaDescrizioneIpotesiConsiderate(Polizza dest) {
		dest.addAttributo("labelIpotesiConsiderate", "IPOTESI CONSIDERATE:");

	}

	public static void impostaDescrizioneInteressiRitardatoPagamento(Polizza dest) {


		if( (dest.getLiquidazioni() != null) && (!dest.getLiquidazioni().isEmpty()) ) {
			Vector<Liquidazione> lista = new Vector<Liquidazione>(dest.getLiquidazioni());

			Liquidazione last = lista.lastElement();

			if( (last.getIntRitPag() != null) && ("0.00".equals(last.getIntRitPag()))) {
				dest.addAttributo("descrizioneRiscatto",
						dest.getAttributo("descrizioneRiscatto")
						+ dest.getTroncone("InteressiRitPag1")
						+ " " + last.getIntRitPag()
						+ dest.getTroncone("InteressiRitPag2"));
			}

		}

	}


	public static void impostaDescrizioneRichiesta(Polizza dest) {

		long differenzaGiorni;
		try {
			differenzaGiorni = (long) DateUtils.dateDiff(
					DateUtils.getDate(dest.getDataFineDifferimento(), Costanti.FORMATO_DATA),
					new Date(), Calendar.DAY_OF_YEAR
			);

			if ("R".equalsIgnoreCase(dest.getTipoPrestazione())) {

				if ("VIVA".equalsIgnoreCase(dest.getCodiceFondo().trim())) {
					if ((differenzaGiorni < 90)) {
						dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
								+ dest.getTroncone("DescrRichiestaTempestiva"));
					} else {
						dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
								+ dest.getTroncone("DescrRichiesta3mesi"));

					}
				}
			} else {
				if ("PREVI".equalsIgnoreCase(dest.getCodiceFondo().trim())) {

					if ((differenzaGiorni < 30)) {
						dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
								+ dest.getTroncone("DescrRichiestaTempestiva"));
					} else {
						dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
								+ dest.getTroncone("DescrRichiesta1mese"));
					}
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static void impostaDescrizioneRichiestaOpzione(Polizza dest) {

		dest.addAttributo("descrizioneRichiestaOpzione", dest.getTroncone("DescrRichiesta3mesi"));

		long differenzaGiorni;
		try {
			differenzaGiorni = (long) DateUtils.dateDiff(
					DateUtils.getDate(dest.getDataFineDifferimento(), Costanti.FORMATO_DATA),
					new Date(), Calendar.DAY_OF_YEAR);

			if ((differenzaGiorni < 90)) {
				dest.addAttributo("descrizioneRichiestaOpzione", dest.getTroncone("DescrRichiestaTempestiva"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	public void impostaDatiRiscatto(Polizza dest, String dataValutazione, int indicatoreTipoRisc) throws WebServiceClientException, DaoException, PucException {
		LoggingUtils.debug("impostaDatiRiscatto");
		String polizza = dest.getNumero();

		//   RISCATTO ANTICIPATO PER POLIZZA CHIUSA
		if (("C".equalsIgnoreCase(dest.getTipo())) && (indicatoreTipoRisc == 2)) {
            WSRiscattoPolizzeChiuseBean bean = null;
            try {
                bean = uniS.getRiscattoPolizzeChiuse(polizza, dataValutazione);
            } catch (UniversoException e) {
               throw new WebServiceClientException(e);
            }

            dest.addAttributo("importoRiscatto", bean.getValoreDiRiscattoTotaleLordo());
			LoggingUtils.debug("Stima Riscatto PA  - ValoreDiRiscattoTotaleLordo: " + bean.getValoreDiRiscattoTotaleLordo());

		} else {
            WSRiscattoBean bean = null;
            Boolean isSimulatoreProdotto = false;
            try {
            	//chiamata al metodo che controlla se il tipo prodotto della polizza è presente
            	//nella tabella SimulatoriRiscatto, se presente viene chiamato il nuovo WS
            	isSimulatoreProdotto = new PucDao(comID).checkSimulatoreProdotto(polizza);
            	if(isSimulatoreProdotto) {
            		SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
            		Date convertedCurrentDate = convertStringToDate(dataValutazione,"dd/MM/yyyy");
        			String dataValutazioneFormatted = fmt.format(convertedCurrentDate);
        			      			
        			ValoreSaldoPolizzaApertaRamoTerzo resp = getSimulatoreClient(comID).calcolaValoreSaldoPolizzaApertaRamoTerzo(polizza, dataValutazioneFormatted); 
            		bean = new WSRiscattoBean();
            		DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        			decimalFormatSymbols.setDecimalSeparator(',');
        			decimalFormatSymbols.setGroupingSeparator('.');
        			
            		bean.setValoreDiRiscattoTotaleLordo(new DecimalFormat("#,##0.00", decimalFormatSymbols).format(resp.getValoreSaldo()));
            	}else {
            		bean = uniS.getRiscattoPolizzeAperte(polizza, dataValutazione, indicatoreTipoRisc);
            	}
                
            } catch (UniversoException e) {
                throw new WebServiceClientException(e);
            }
            if(!isSimulatoreProdotto) {
            	if ("1".equals(dest.getRamoMinisteriale())) {
    				// verificare se l'importo delle PrestazioniVita sono uguali a renditaIniziale restituito dal motore.
    				dest.addAttributo("importoPrestazioniVita", bean.getRenditaRivalutata());
    				dest.addAttributo("importoPrestazioniMorte", bean.getCapitaleCasoMorte());

    				LoggingUtils.debug("Stima Riscatto PA  - importoPrestazioniVita: " + bean.getRenditaRivalutata());
    				LoggingUtils.debug("Stima Riscatto PA  - importoPrestazioniMorte: " + bean.getCapitaleCasoMorte());
    			} else {
    				dest.addAttributo("importoPrestazioniVita", bean.getRenditaIniziale());
    				dest.addAttributo("importoPrestazioniMorte", bean.getCapitaleCasoMorteUnit());

    				LoggingUtils.debug("Stima Riscatto PA  - importoPrestazioniVita: " + bean.getRenditaIniziale());
    				LoggingUtils.debug("Stima Riscatto PA  - importoPrestazioniMorte: " + bean.getCapitaleCasoMorteUnit());
    			}
            }
				
			//valorizzazione del campo importoRiscatto
			if((indicatoreTipoRisc == 1) && (dest.getCodiceTariffa().equals("900") || dest.getCodiceTariffa().equals("910"))){
					String renditaIniziale = dest.getAttributo("importoPrestazioniVita");
					if(renditaIniziale != null && !renditaIniziale.trim().equals("")){
						renditaIniziale = renditaIniziale.replace(".", "");
						renditaIniziale = renditaIniziale.replace(",", ".");
						BigDecimal renditaInizialeD = new BigDecimal(renditaIniziale);
                        /*
						CalcoloRiscattoTermineVO voInput = new CalcoloRiscattoTermineVO();
						voInput.setNumeroPolizza(dest.getNumero());
						BigDecimal coefficiente = pucClient.getCoefficenteRiscattoFulByNumeroPolizza(voInput);		        							
						*/
                        BigDecimal coefficiente = new PucDao(comID).getCoefficienteRiscattoFul(dest.getSospensioneScadenza());
						double calcolato = arrotonda(renditaInizialeD.doubleValue() * coefficiente.doubleValue(),2);
						String importoRiscatto = NumberUtils.formatCurrency(
								calcolato,
	                            Costanti.SEPARATORE_MIGLIAIA,
	                            Costanti.SEPARATORE_DECIMALI);
						dest.addAttributo("importoRiscatto",importoRiscatto);
					}

            }else{
            	dest.addAttributo("importoRiscatto", bean.getValoreDiRiscattoTotaleLordo());	
			}
			if(!isSimulatoreProdotto) {
				dest.addAttributo("importoDisponibilita", bean.getRiservaMatematica());
				dest.addAttributo("totalePremiRivalutatiIpotizzati", bean.getTotalePremiRivalutatiIpotizzati());
				dest.addAttributo("interessiRitardatoPagamento", bean.getInteressiRitardatoPagamento());
				dest.addAttributo("appendice", bean.getAppendice());
				dest.addAttributo("tassoIsvap", bean.getTassoIsvap());
				dest.addAttributo("importoEccedenza", bean.getEccedenza());
			}

			LoggingUtils.debug("Stima Riscatto PA  - ValoreDiRiscattoTotaleLordo: " + bean.getValoreDiRiscattoTotaleLordo());
		}

	}
	
	private static double arrotonda(double number, int decimal) {
		double p = (double)Math.pow(10,decimal);
		number = number * p;
		double tmp = Math.round(number);
		return (double)tmp/p;
	}

	public static void decodificaSottostato(Polizza dest) {
		if ("AF".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("AFFRANCATA DA PREMI");

		} else if ("AP".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("ATTESA PERFEZIONAMENTO");

		} else if ("AR".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("IN ARRETRATO");

		} else if ("AT".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("ATTIVA");

		} else if ("FD".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("FINE DIFFERIMENTO");

		} else if ("GD".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("IN GODIMENTO");

		} else if ("GR".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("IN GODIMENTO RENDITA");

		} else if ("MP".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("MANCATO PERFEZIONAMENTO");

		} else if ("NC".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("NON IN COPERTURA");

		} else if ("PR".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("PROROGATA");

		} else if ("RD".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("RIDOTTA");

		} else if ("RE".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("RISCATTATA CON ECCEDENZA");

		} else if ("SC".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("SCADUTA");

		} else if ("ST".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("STORNATA");

		} else if ("TP".equalsIgnoreCase(dest.getCodiceSottostato())) {
			dest.setSottostato("ATTIVA");
		}
	}
	
	private Date convertStringToDate(String data, String format) {
		try {
			Date date;
			DateFormat formatter = new SimpleDateFormat(format);
			date = (Date) formatter.parse(data);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			return cal.getTime();
		} catch (Exception e) {
			return null;
		}

	}

}
