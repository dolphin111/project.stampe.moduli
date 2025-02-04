package com.fideuram.crm.stampe.lettere;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.Titolo;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.ValoreInputVO;
import com.fideuram.puc.service.impl.PremiIncassatiVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.stampe.dao.PucDao;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;
import com.fideuram.utils.StringUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author Giorgio Desideri
 *
 */
public class LetteraPremiPagati extends LetteraEngine{

    public LetteraPremiPagati(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param polizza
	 * @throws StampeInfoException, WebServiceClientException, PucException
	 */
	public void completaPolizza(Polizza polizza, DomandaVO domanda) throws StampeInfoException, WebServiceClientException, PucException {
        try {
			Date dataValutazione = null;
			for (ValoreInputVO v : domanda.getValoriInput()) {
	            for (int tipo : Costanti.INPUT_DATA_VALUTA) {
	                if (tipo == v.getDatoInput().getId()) {
	                    try {
	                        dataValutazione = DateUtils.getCrmDate(v.getValore());
	                    } catch (ParseException e) {
	                        throw new RuntimeException(e);
	                    }
	                    break;
	                }
	            }
	        }
			
			if(dataValutazione == null)
				dataValutazione = new Date();
			
			GregorianCalendar gregorianCreazione = (GregorianCalendar) GregorianCalendar.getInstance();
			gregorianCreazione.setTime(dataValutazione);


            if (polizza.isCollettiva()){
                polizza.setEstrattoConto(new PucDao(comID).getEstrattoConto(polizza.getNumero()));
            } else {
                List<PremiIncassatiVO> listaPremi = null;
                try {
                    listaPremi = pucS.listPremiIncassatiByPolizzaDataValuta(new Long(polizza.getNumero()),DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCreazione));
                } catch (DatatypeConfigurationException e) {
                    LoggingUtils.error(e);
                }

                // lista premi da caricare nel modello
                ArrayList<Titolo> listaPremiModello = new ArrayList<Titolo>();
                polizza.setListaTitoli(listaPremiModello);

                Titolo titolo = null;
                double totaleImportoLordo = 0;

                for(PremiIncassatiVO premio : listaPremi) {
                    titolo = new Titolo();

                    String dataEffettoPremio = null;
                    if(premio.getDataEffetto() != null) {
                        dataEffettoPremio =
                                DateUtils.formatDate(
                                        premio.getDataEffetto().toGregorianCalendar(),
                                        Costanti.FORMATO_DATA);
                    }

                    String dataPagamento = null;
                    if(premio.getDataValuta() != null) {
                        dataPagamento =
                                DateUtils.formatDate(
                                        premio.getDataValuta().toGregorianCalendar(),
                                        Costanti.FORMATO_DATA);
                    }

                    titolo.setDataEffetto(StringUtils.blankString(dataEffettoPremio));
                    titolo.setDataPagamento(StringUtils.blankString(dataPagamento));
                    titolo.setDescrizione(StringUtils.blankString(premio.getDescrizioneTipoTitolo()));

                    if(premio.getProgressivoTitolo() != null )
                        titolo.setNumero(String.valueOf(premio.getProgressivoTitolo().intValue()));
                    else
                        titolo.setNumero("");

                    if(premio.getImportoLordo() != null ) {
                        double importo = premio.getImportoLordo();
                        String divisa = premio.getDivisa();

                        if (divisa != null && (divisa.equalsIgnoreCase("euro")||divisa.equalsIgnoreCase("EUR"))) {
                            titolo.setDivisa(StringUtils.blankString(premio.getDivisa()));
                        }
                        else {
                            importo = NumberUtils.conversioneLireEuro(
                                    String.valueOf(importo));

                            titolo.setDivisa("euro");
                        }

                        titolo.setPremioPagato(
                                NumberUtils.formatCurrency(
                                        importo,
                                        Costanti.SEPARATORE_MIGLIAIA,
                                        Costanti.SEPARATORE_DECIMALI));

                        totaleImportoLordo += importo;
                    }
                    else
                        titolo.setPremioPagato("");

                    // Aggiungo titolo alla lista
                    listaPremiModello.add(titolo);
                }

                polizza.addAttributo(
                        "totaleImportoLordo",
                        NumberUtils.formatCurrency(
                                totaleImportoLordo,
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


            }
            polizza.addAttributo(
                    "dataRiferimento",
                    DateUtils.formatDate(
                            dataValutazione,
                            Costanti.FORMATO_DATA));
		} catch (NumberFormatException e) {
			throw new StampeInfoException(e.getMessage());
		} catch (ServiceException_Exception e) {
			throw new PucException(e.getMessage());
		}
	}

}
