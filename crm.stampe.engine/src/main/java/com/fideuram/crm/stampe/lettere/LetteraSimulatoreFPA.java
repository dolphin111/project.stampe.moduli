package com.fideuram.crm.stampe.lettere;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.DettaglioLiquidazionePrestazionePensionistica;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.Rateazione;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.puc.service.impl.DettaglioCompartoPrevidenzaVO;
import com.fideuram.puc.service.impl.DettaglioLiquidazionePrestazionePensionisticaMulticompartoVO;
import com.fideuram.puc.service.impl.DettaglioLiquidazionePrestazionePensionisticaVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.stampe.modello.fpa.DettaglioComparto;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

/**
 * Created with IntelliJ IDEA. User: v801092 Date: 11/05/15 Time: 15.53
 */
public class LetteraSimulatoreFPA extends LetteraEngine {

	public LetteraSimulatoreFPA(int comID) throws WebServiceClientException {
		super(comID);
	}

	/**
	 * @param dest
	 * @param dom
	 *
	 * @throws com.fideuram.exception.ws.CrmStampeException
	 */
	public void completaPolizza(Polizza dest, DomandaVO dom)
			throws WebServiceClientException, StampeInfoException, PucException {

        DettaglioLiquidazionePrestazionePensionisticaMulticompartoVO vo = null;

       //Passo anche un booleano che serve per mostrare i valori relativi a
       try {
           //Parte  non obbligatoria abiliata dal flag del front-end
           String valore= Inputs.getRenditaCerta85(dom);
           Boolean controllo=Boolean.FALSE;
           if (valore !=null && valore.equalsIgnoreCase("SI"))
               controllo=Boolean.TRUE;

           Integer etaCalcolo = (Inputs.getEtaCalcolo(dom) == null)?67:Inputs.getEtaCalcolo(dom);
           
           vo = pucS.getSimulatoriMulticompartoFPANew(dest.getNumero(),controllo, etaCalcolo);
           if(vo.getWarningTrace().size()>0){
               String message=vo.getWarningTrace().get(0).getTrace();
               throw new PucException(message);
           }

       } catch (ServiceException_Exception e) {
           throw new PucException(e);
       }
       DettaglioLiquidazionePrestazionePensionistica beanPrestazione=new DettaglioLiquidazionePrestazionePensionistica();

		if (vo != null) {
			if (vo.getAderente() != null && (!"".equalsIgnoreCase(vo.getAderente())))
				beanPrestazione.setAderente(vo.getAderente());

			beanPrestazione.setAmmontarePosizioneIndividualeMaturata(
					NumberUtils.formatCurrency(vo.getAmmontarePosizioneIndividualeMaturata(),
							Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));

			beanPrestazione.setControvalore(NumberUtils.formatCurrency(vo.getControvalore(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
			if (vo.getControvaloreGarantito() != null) {
				beanPrestazione.setControvaloreGarantito(NumberUtils
						.formatCurrency(vo.getControvaloreGarantito(),
								Costanti.SEPARATORE_MIGLIAIA,
								Costanti.SEPARATORE_DECIMALI));
			}
			if (vo.getControvaloreReale() != null) {
				beanPrestazione.setControvaloreReale(NumberUtils
						.formatCurrency(vo.getControvaloreReale(),
								Costanti.SEPARATORE_MIGLIAIA,
								Costanti.SEPARATORE_DECIMALI));
			}
			
			beanPrestazione.setNumeroPosizione(String.valueOf(vo.getNumeroPosizione()));

			beanPrestazione.setProspettoLiquidativo(vo.getProspettoLiquidativo());

			beanPrestazione.setFondoPensione(vo.getFondoPensione());
			beanPrestazione.setTipologiaAderente(vo.getTipologiaAderente());

			beanPrestazione.setDataPreventivo(DateUtils.formatDate(new GregorianCalendar(), Costanti.FORMATO_DATA));

			beanPrestazione.setDataAdesioneFondo(
					DateUtils.formatDate(vo.getDataAdesioneFondo().toGregorianCalendar(), Costanti.FORMATO_DATA));

			beanPrestazione.setDataPrimaIscrizioneFormePensionisticheComplementare(DateUtils.formatDate(
					vo.getDataPrimaIscrizioneFormePensionisticheComplementari().toGregorianCalendar(),
					Costanti.FORMATO_DATA));

			beanPrestazione.setTotaleContributiVersatiNettiFondoGenerale(
					NumberUtils.formatCurrency(vo.getTotaleContributiVersatiNettiFondoGenerale(),
							Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));

			beanPrestazione.setNumeroQuote(NumberUtils.format(vo.getNumeroQuote(), Costanti.SEPARATORE_MIGLIAIA,
					Costanti.SEPARATORE_DECIMALI, 3));

			if (vo.getValoreQuota() != null) {
				beanPrestazione.setValoreQuota(NumberUtils.format(vo.getValoreQuota(), Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI, 3));
			}
			else {
				beanPrestazione.setValoreQuota("---");
			}

			List<DettaglioComparto> listaComparti = new ArrayList<DettaglioComparto>();
			DettaglioComparto comparto;
			for (DettaglioCompartoPrevidenzaVO dett : vo.getListaComparti()) {
				comparto = new DettaglioComparto();
				comparto.setControvalore(NumberUtils.format(dett.getControvalore().doubleValue(), Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI, 3));
				if (dett.getControvaloreGarantito() != null) {
					comparto.setControvaloreGarantito(NumberUtils.format(dett
							.getControvaloreGarantito().doubleValue(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI, 3));
				}			
				comparto.setValoreNav(NumberUtils.format(dett.getValoreNav().doubleValue(), Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI, 3));
				comparto.setNumeroQuote(NumberUtils.format(dett.getNumeroQuote().doubleValue(), Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI, 3));
				comparto.setDescrizioneComparto(dett.getDescrizioneComparto().trim());
				listaComparti.add(comparto);
			}
			beanPrestazione.setListaComparti(listaComparti);
			
			
			if (vo.getRenditaImmediata100() != null) {
				Rateazione rateo = new Rateazione();
				rateo.setRateoAnnuo(NumberUtils.formatCurrency(vo.getRenditaImmediata100().getRateazioneAnnua(),
						Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setRateoMensile(NumberUtils.formatCurrency(vo.getRenditaImmediata100().getRateazioneMensile(),
						Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setRateoTrimestrale(
						NumberUtils.formatCurrency(vo.getRenditaImmediata100().getRateazioneTrimestrale(),
								Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setRateoSemestrale(
						NumberUtils.formatCurrency(vo.getRenditaImmediata100().getRateazioneSemestrale(),
								Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setAmmontare(NumberUtils.formatCurrency(
						vo.getRenditaImmediata100().getAmmontarePosizioneIndividualeMaturata(),
						Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));

				beanPrestazione.setRenditaImmediata100(rateo);
				beanPrestazione.setValorizzaRendita10(Boolean.TRUE);
			} else
				beanPrestazione.setValorizzaRendita10(Boolean.FALSE);

			Rateazione rateo = new Rateazione();
			rateo.setRateoAnnuo(NumberUtils.formatCurrency(vo.getRenditaImmediata50().getRateazioneAnnua(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
			rateo.setRateoMensile(NumberUtils.formatCurrency(vo.getRenditaImmediata50().getRateazioneMensile(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
			rateo.setRateoTrimestrale(NumberUtils.formatCurrency(vo.getRenditaImmediata50().getRateazioneTrimestrale(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
			rateo.setRateoSemestrale(NumberUtils.formatCurrency(vo.getRenditaImmediata50().getRateazioneSemestrale(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
			rateo.setAmmontare(
					NumberUtils.formatCurrency(vo.getRenditaImmediata50().getAmmontarePosizioneIndividualeMaturata(),
							Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));

			beanPrestazione.setRenditaImmediata50(rateo);

			rateo = new Rateazione();
			rateo.setRateoAnnuo(NumberUtils.formatCurrency(vo.getRenditaGarantita5Anni().getRateazioneAnnua(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
			rateo.setRateoMensile(NumberUtils.formatCurrency(vo.getRenditaGarantita5Anni().getRateazioneMensile(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
			rateo.setRateoTrimestrale(
					NumberUtils.formatCurrency(vo.getRenditaGarantita5Anni().getRateazioneTrimestrale(),
							Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
			rateo.setRateoSemestrale(NumberUtils.formatCurrency(vo.getRenditaGarantita5Anni().getRateazioneSemestrale(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
			rateo.setAmmontare(
					NumberUtils.formatCurrency(vo.getRenditaGarantita5Anni().getAmmontarePosizioneIndividualeMaturata(),
							Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));

			beanPrestazione.setRenditaGarantita50(rateo);

			if (vo.getRenditaGarantita10Anni() != null) {
				rateo = new Rateazione();
				rateo.setRateoAnnuo(NumberUtils.formatCurrency(vo.getRenditaGarantita10Anni().getRateazioneAnnua(),
						Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setRateoMensile(NumberUtils.formatCurrency(vo.getRenditaGarantita10Anni().getRateazioneMensile(),
						Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setRateoTrimestrale(
						NumberUtils.formatCurrency(vo.getRenditaGarantita10Anni().getRateazioneTrimestrale(),
								Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setRateoSemestrale(
						NumberUtils.formatCurrency(vo.getRenditaGarantita10Anni().getRateazioneSemestrale(),
								Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));

				rateo.setAmmontare(NumberUtils.formatCurrency(
						vo.getRenditaGarantita10Anni().getAmmontarePosizioneIndividualeMaturata(),
						Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));

				beanPrestazione.setRenditaGarantita100(rateo);
				beanPrestazione.setValorizzaRenditaGarantita10Anni(Boolean.TRUE);

			} else
				beanPrestazione.setValorizzaRenditaGarantita10Anni(Boolean.FALSE);

			beanPrestazione.setValoreLordoPrestazionePensionistica100(
					NumberUtils.formatCurrency(vo.getValoreLordoPrestazionePensionistica100(),
							Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));

			beanPrestazione.setValoreLordoPrestazionePensionistica50(
					NumberUtils.formatCurrency(vo.getValoreLordoPrestazionePensionistica50(),
							Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));

			// Parte non obbligatoria abiliata dal flag del front-end
			String valore = Inputs.getRenditaCerta85(dom);
			if (valore.equalsIgnoreCase("SI")) {

				rateo = new Rateazione();
				rateo.setRateoAnnuo(NumberUtils.formatCurrency(vo.getRenditaImmediata85Anni().getRateazioneAnnua(),
						Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setRateoMensile(NumberUtils.formatCurrency(vo.getRenditaImmediata85Anni().getRateazioneMensile(),
						Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setRateoTrimestrale(
						NumberUtils.formatCurrency(vo.getRenditaImmediata85Anni().getRateazioneTrimestrale(),
								Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setRateoSemestrale(
						NumberUtils.formatCurrency(vo.getRenditaImmediata85Anni().getRateazioneSemestrale(),
								Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
				rateo.setAmmontare(NumberUtils.formatCurrency(
						vo.getRenditaImmediata85Anni().getAmmontarePosizioneIndividualeMaturata(),
						Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));

				beanPrestazione.setRenditaImmediata85Anni(rateo);
				beanPrestazione.setValorizza85(Boolean.TRUE);
			} else
				beanPrestazione.setValorizza85(Boolean.FALSE);

			// Setto la parte relativa all'assegno sociale
			// modifica fatta il 22/04/2016, il controllo non serve piu' perche'
			// e' stato modificato il controllo lato puc
			// if (vo.isRiscattabilita100() )
			beanPrestazione.setValorizzaAssegnoSociale(vo.isRiscattabilita100());
			// else
			// beanPrestazione.setValorizzaAssegnoSociale(Boolean.TRUE);

			beanPrestazione.setAssegnoSociale(NumberUtils.formatCurrency(vo.getAmmontarePosizioneIndividualeMaturata(),
					Costanti.SEPARATORE_MIGLIAIA, Costanti.SEPARATORE_DECIMALI));
			
            beanPrestazione.setEtaCalcolo(vo.getEtaCalcolo());
            beanPrestazione.setEtaCalcoloEffettiva(vo.getEtaCalcoloEffettiva());
            
			dest.setDettaglioLiquidazionePrestazionePensionistica(beanPrestazione);

		}

	}

}
