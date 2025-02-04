package com.fideuram.crm.stampe.lettere;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.ValoreInputVO;
import com.fideuram.costanti.Costanti;
import com.fideuram.utils.DateUtils;

/**
 * @author Giuseppe Luciani
 * @author Giorgio Desideri
 *
 * Classe statica incaricata della gestione degli input.
 */
public class Inputs {

	/**
	 * Restituisce la data di valutazione della domanda
	 * 
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static Date getDataValutazione(DomandaVO domanda) {
		return getCampoData(domanda, Costanti.INPUT_DATA_VALUTAZIONE);
	}

	/**
	 * Restituisce la data di nascita del (richiedente ??) della domanda.
	 * 
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static Date getDataNascita(DomandaVO domanda) {
		return getCampoData(domanda, Costanti.INPUT_DATA_NASCITA);
	}

	/**
	 * Restituisce la data di nascita di proroga della domanda.
	 * 
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static Date getDataProroga(DomandaVO domanda) {
		return getCampoData(domanda, Costanti.INPUT_DATA_PROROGA);
	}

	/**
	 * @param domanda
	 * @param tipi
	 * @return
	 */
	private static Date getCampoData(DomandaVO domanda, int[] tipi) {
		Date rv = null;
		
		for (ValoreInputVO v : domanda.getValoriInput()) {
			
			for (int tipo : tipi) {
				
				if (tipo == v.getDatoInput().getId()) {
					String val = v.getValore();
			
					if (val != null && !"".equals(val.trim())) {
						val = val.trim();
					
						try {
							rv = DateUtils.getCrmDate(val);
							break;
						} catch (ParseException e) {
							throw new RuntimeException(e);
						}
						
					}
				}
			}
		}
		
		return rv;
	}

	/**
	 * Restituisce il valore di opzione anticipata
	 * 
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static String getAnticipata(DomandaVO domanda) {
		return getCampoSiNo(domanda, Costanti.INPUT_ANTICIPATA);
	}

	/**
	 * Restituisce il valore booleano di riscatto.
	 * 
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static String getValoreRiscatto(DomandaVO domanda) {
		return getCampoSiNo(domanda, Costanti.INPUT_VALORE_RISCATTO);
	}

	/**
	 * Restituisce il valore booleano di rendita anticipata
	 * 
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static String getRenditaAnticipata(DomandaVO domanda) {
		return getCampoSiNo(domanda, Costanti.INPUT_RENDITA_ANTICIPATA);
	}

	/**
	 * Restituisce il valore booleano.
	 * 
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	private static String getCampoSiNo(DomandaVO domanda, int[] tipi) {
		String rv = null;
		for (ValoreInputVO v : domanda.getValoriInput()) {
			
			for (int tipo : tipi) {
				
				if (tipo == v.getDatoInput().getId()) {
					
					String val = v.getValore();
					
					if (val != null && !"".equals(val.trim())) {
						val = val.trim();
						if (Costanti.INPUT_VALORE_SI.equalsIgnoreCase(val)
								|| Costanti.INPUT_VALORE_NO.equalsIgnoreCase(val)) {
							rv = val;
							break;
						}
					}
				}
			}
		}
		return rv;
	}

	/**
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static Integer getAnniProroga(DomandaVO domanda) {
		return getCampoInteger(domanda, Costanti.INPUT_ANNI_PROROGA);
	}

	/**
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static Integer getMesiProroga(DomandaVO domanda) {
		return getCampoInteger(domanda, Costanti.INPUT_MESI_PROROGA);
	}

	/**
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static Integer getAnniAnticipazione(DomandaVO domanda) {
		return getCampoInteger(domanda, Costanti.INPUT_ANNI_ANTICIPAZIONE);
	}

	/**
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
    public static Integer getRenditaCerta(DomandaVO domanda) {
        return getCampoInteger(domanda, Costanti.INPUT_RENDITA_CERTA_ANNI);
    }



    public static String getRenditaCerta85(DomandaVO domanda) {
        return getCampoSiNo(domanda, Costanti.INPUT_RENDITA_CERTA_ANNI85);
    }
    
    public static Integer getEtaCalcolo(DomandaVO domanda) {
        return getCampoInteger(domanda, Costanti.INPUT_ETA_CALCOLO);
    }

	/**
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	private static Integer getCampoInteger(DomandaVO domanda, int[] tipi) {
		Integer rv = null;
		for (ValoreInputVO v : domanda.getValoriInput()) {
			for (int tipo : tipi) {
				if (tipo == v.getDatoInput().getId()) {
					String val = v.getValore();
					if (val != null && !"".equals(val.trim())) {
						val = val.trim();
						try {
							rv = Integer.parseInt(val);
							break;
						} catch (NumberFormatException e) {
							throw new RuntimeException(e);
						}
					}
				}
			}
		}
		return rv;
	}

	/**
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static String getFrazionamento(DomandaVO domanda) {
		return getCampoStringa(domanda, Costanti.INPUT_FRAZIONAMENTO);
	}
	
	/**
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static String getSesso(DomandaVO domanda) {
		String s = getCampoStringa(domanda, Costanti.INPUT_SESSO);
		if ("m".equalsIgnoreCase(s) || "f".equalsIgnoreCase(s))
			return s;
		return null;
	}
	
	/**
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static String getPolizza(DomandaVO domanda) {
		return getCampoStringa(domanda, Costanti.INPUT_POLIZZA_PROROGA);
	}

	public static String getNumeroPratica(DomandaVO domanda) {
		return getCampoStringa(domanda, Costanti.SPIEGAZIONI_CONTEGGI_PREVIDENZA);
	}
	
	/**
	 * @param domanda
	 * @param tipi
	 * @return
	 */
	private static String getCampoStringa(DomandaVO domanda, int[] tipi) {
		String rv = null;
		for (ValoreInputVO v : domanda.getValoriInput()) {
			for (int tipo : tipi) {
				if (tipo == v.getDatoInput().getId()) {
					String val = v.getValore();
					if (val != null && !"".equals(val.trim())) {
						rv = val.trim();
						break;
					}
				}
			}
		}
		return rv;
	}

	/**
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static List<String> getPraticheLiquidazione(DomandaVO domanda) {
		return getCampoLista(domanda, Costanti.INPUT_PRATICHE_LIQUIDAZIONE);
	}

	/**
	 * @param domanda
	 * @param tipi
	 * @return
	 */
	private static List<String> getCampoLista(DomandaVO domanda, int[] tipi) {
		List<String> rv = null;
		
		for (ValoreInputVO v : domanda.getValoriInput()) {
			for (int tipo : tipi) {
				if (tipo == v.getDatoInput().getId()) {
					String val = v.getValore();

					if (val != null && !"".equals(val.trim())) {
						val = val.trim();
						rv = new ArrayList<String>();

						StringTokenizer tokenizer = new StringTokenizer(val,
								"|");

						while (tokenizer.hasMoreTokens()) {
							rv.add(tokenizer.nextToken());
						}

						break;
					}
				}
			}
		}
		return rv;
	}

	/**
	 * @param domanda		domanda
	 * 
	 * @return	{@link java.util.Date}
	 */
	public static Float getReversibilita(DomandaVO domanda) {
		Integer i = getCampoInteger(domanda, Costanti.INPUT_REVERSIBILITA);

		if (i != null)
			return new Float(i.intValue());
		else
			return new Float("0");
	}
	
	/**
	 * @param domanda		domanda
	 * 
	 * @return
	 */
	public static List<String> getListaPratiche(DomandaVO domanda) {
		ArrayList<String> pratiche = new ArrayList<String>();

		String result = getCampoStringa(domanda, Costanti.INPUT_PRATICHE_LIQUIDAZIONE);

		if(result != null) {
			StringTokenizer tokenizer = new StringTokenizer(result, ",");

			while (tokenizer.hasMoreTokens()) {
				pratiche.add(tokenizer.nextToken().trim());
			}
		}

		return pratiche;
	}
	
	public static List<String> getListaPratiche(DomandaVO domanda, int[] tipo) {
		ArrayList<String> pratiche = new ArrayList<String>();

		String result = getCampoStringa(domanda, tipo);

		if(result != null) {
			StringTokenizer tokenizer = new StringTokenizer(result, ",");

			while (tokenizer.hasMoreTokens()) {
				pratiche.add(tokenizer.nextToken().trim());
			}
		}

		return pratiche;
	}

}
