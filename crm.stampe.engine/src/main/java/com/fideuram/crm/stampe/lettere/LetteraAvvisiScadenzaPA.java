package com.fideuram.crm.stampe.lettere;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.vospolizza.rendita.Certezza;
import com.fideuram.crm.stampe.model.vospolizza.rendita.Frazionamento;
import com.fideuram.crm.stampe.model.vospolizza.rendita.IpotesiRendita;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.puc.service.impl.AvvisidiScadenzaVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

public class LetteraAvvisiScadenzaPA extends LetteraEngine{
    public LetteraAvvisiScadenzaPA(int comID) throws WebServiceClientException {
        super(comID);
    }

    public  void completaPolizza(Polizza polizza) throws WebServiceClientException, PucException {
		avvisiScadenza(polizza);		
	}
	
	private  void avvisiScadenza(Polizza polizza) throws WebServiceClientException, PucException {
		try {
			AvvisidiScadenzaVO avvisi = pucS.getAvvisiScadenzabyNumeroPolizza(new Long(polizza.getNumero()));
			
			boolean controlloCertezza = false;
			if(avvisi != null){
				if(avvisi.getRenditaAnnuavitaliziaMinimaGarantita() != null){
					polizza.setRenditaAnnuaVitMinimaGar(NumberUtils.formatCurrency(
							avvisi.getRenditaAnnuavitaliziaMinimaGarantita(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				}else {
					polizza.setRenditaAnnuaVitMinimaGar("");
				}

				if(avvisi.getValoreRiscattoScadenzaGarantito() != null){
					polizza.setValoreRiscattoScadGarantito(NumberUtils.formatCurrency(
							avvisi.getValoreRiscattoScadenzaGarantito(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setValoreRiscattoScadGarantito("");
				}
				
				if(avvisi.getRenditaVitaliziaAnnuaPosticipata() != null){
					polizza.setRenditaVitaliziaAnnuaPosticipata(NumberUtils.formatCurrency(
							avvisi.getRenditaVitaliziaAnnuaPosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setRenditaVitaliziaAnnuaPosticipata("");
				}
				System.out.println(polizza.getRenditaVitaliziaAnnuaPosticipata());

				if(avvisi.getIpotesiRenditaAnnuaPosticipataScadenzaCVT() != null){
					polizza.setIpotesiRenditaAnnuaPosticipataScadenzaCTV(NumberUtils.formatCurrency(
							avvisi.getIpotesiRenditaAnnuaPosticipataScadenzaCVT(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setIpotesiRenditaAnnuaPosticipataScadenzaCTV("");
				}

				if(avvisi.getIpotesiValoreriScattoScadenzaCVT() != null){
					polizza.setIpotesiValoreRiscattoScadenzaCTV(NumberUtils.formatCurrency(
							avvisi.getIpotesiValoreriScattoScadenzaCVT(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setIpotesiValoreRiscattoScadenzaCTV("");
				}

                //FRAZIONAMENTO
				/*if(avvisi.getTotalerenditaFrazionataAnnualePosticipata() != null){
					polizza.setTotaleRenditaFrazionataAnnualePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotalerenditaFrazionataAnnualePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setTotaleRenditaFrazionataAnnualePosticipata("");
				}

				if(avvisi.getTotalerenditaFrazionataSemestralePosticipata() != null){
					polizza.setTotaleRenditaFrazionataSemestralePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotalerenditaFrazionataSemestralePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setTotaleRenditaFrazionataSemestralePosticipata("");
				}

				if(avvisi.getTotalerenditaFrazionataTrimestralePosticipata() != null){
					polizza.setTotaleRenditaFrazionataTrimestralePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotalerenditaFrazionataTrimestralePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setTotaleRenditaFrazionataTrimestralePosticipata("");
				}

				if(avvisi.getTotalerenditaFrazionataMensilePosticipata() != null){
					polizza.setTotaleRenditaFrazionataMensilePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotalerenditaFrazionataMensilePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setTotaleRenditaFrazionataMensilePosticipata("");
				}*/


                IpotesiRendita ipotesiRendita=new IpotesiRendita();
                ipotesiRendita.setFrazionamento(new Frazionamento(avvisi));  //OPZIONE FRAZIONAMENTO
                ipotesiRendita.setCertezza(new Certezza(avvisi,polizza));    //OPZIONE CERTEZZA
                polizza.setRendita(ipotesiRendita);



                /*
                if(avvisi.getAnniCertezza1() != null){
                    polizza.setAnniCertezza(String.valueOf(avvisi.getAnniCertezza1()));
                }else{
                    polizza.setAnniCertezza("");
                }


                if(avvisi.getAnniCertezza2() != null){
                    polizza.setAnniCertezza2(String.valueOf(avvisi.getAnniCertezza2()));
                }else{
                    polizza.setAnniCertezza2("");
                }

				if(avvisi.getTotaleRenditaCerta1AnnualePosticipata() != null && avvisi.getTotaleRenditaCerta1AnnualePosticipata() > 0){
					polizza.setTotaleRenditaCerta1AnnualePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta1AnnualePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta1AnnualePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta2AnnualePosticipata() != null && avvisi.getTotaleRenditaCerta2AnnualePosticipata() > 0){
					polizza.setTotaleRenditaCerta2AnnualePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta2AnnualePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta2AnnualePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta3AnnualePosticipata() != null && avvisi.getTotaleRenditaCerta3AnnualePosticipata() >0){
					polizza.setTotaleRenditaCerta3AnnualePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta3AnnualePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta3AnnualePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta4AnnualePosticipata() != null && avvisi.getTotaleRenditaCerta4AnnualePosticipata() > 0){
					polizza.setTotaleRenditaCerta4AnnualePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta4AnnualePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta4AnnualePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta1SemestralePosticipata() != null && avvisi.getTotaleRenditaCerta1SemestralePosticipata() > 0){
					polizza.setTotaleRenditaCerta1SemestralePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta1SemestralePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta1SemestralePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta2Semestraleposticipata() != null && avvisi.getTotaleRenditaCerta2Semestraleposticipata() > 0){
					polizza.setTotaleRenditaCerta2SemestralePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta2Semestraleposticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta2SemestralePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta3SemestralePosticipata() != null && avvisi.getTotaleRenditaCerta3SemestralePosticipata() > 0){
					polizza.setTotaleRenditaCerta3SemestralePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta3SemestralePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta3SemestralePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta4SemestralePosticipata() != null && avvisi.getTotaleRenditaCerta4SemestralePosticipata() > 0){
					polizza.setTotaleRenditaCerta4SemestralePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta4SemestralePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta4SemestralePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta1TrimestralePosticipata() != null && avvisi.getTotaleRenditaCerta1TrimestralePosticipata() > 0){
					polizza.setTotaleRenditaCerta1TrimestralePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta1TrimestralePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta1TrimestralePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta2TrimestralePosticipata() != null && avvisi.getTotaleRenditaCerta2TrimestralePosticipata() > 0){
					polizza.setTotaleRenditaCerta2TrimestralePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta2TrimestralePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta2TrimestralePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta3TrimestralePosticipata() != null && avvisi.getTotaleRenditaCerta3TrimestralePosticipata() > 0){
					polizza.setTotaleRenditaCerta3TrimestralePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta3TrimestralePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta3TrimestralePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta4TrimestralePosticipata() != null && avvisi.getTotaleRenditaCerta4TrimestralePosticipata() > 0){
					polizza.setTotaleRenditaCerta4TrimestralePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta4TrimestralePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta4TrimestralePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta1MensilePosticipata() != null && avvisi.getTotaleRenditaCerta1MensilePosticipata() > 0){
					polizza.setTotaleRenditaCerta1MensilePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta1MensilePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta1MensilePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta2MensilePosticipata() != null && avvisi.getTotaleRenditaCerta2MensilePosticipata() > 0){
					polizza.setTotaleRenditaCerta2MensilePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta2MensilePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta2MensilePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta3MensilePosticipata() != null && avvisi.getTotaleRenditaCerta3MensilePosticipata() > 0){
					polizza.setTotaleRenditaCerta3MensilePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta3MensilePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta3MensilePosticipata("");
				}

				if(avvisi.getTotaleRenditaCerta4MensilePosticipata() != null && avvisi.getTotaleRenditaCerta4MensilePosticipata() > 0){
					polizza.setTotaleRenditaCerta4MensilePosticipata(NumberUtils.formatCurrency(
							avvisi.getTotaleRenditaCerta4MensilePosticipata(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
					controlloCertezza = true;
				} else {
					polizza.setTotaleRenditaCerta4MensilePosticipata("");
				}

				*/
				if(avvisi.getDataRiferimentoNav() != null){
					polizza.setDataRiferimentoNav(DateUtils.formatDate(avvisi.getDataRiferimentoNav().toGregorianCalendar(), Costanti.FORMATO_DATA));
				} else {
					polizza.setDataRiferimentoNav("");
				}

				if(avvisi.getNumeroQuote() != null){
					polizza.setNumeroQuote(NumberUtils.formatCurrency(
							avvisi.getNumeroQuote(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setNumeroQuote("");
				}

				if(avvisi.getControValoreQuote() != null){
					polizza.setControvaloreQuote(NumberUtils.formatCurrency(
							avvisi.getControValoreQuote(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setControvaloreQuote("");
				}
				
				if(avvisi.getImportoNettoRiscattoTermine() != null){
					polizza.setValoreRiscattoNetto(NumberUtils.formatCurrency(
							avvisi.getImportoNettoRiscattoTermine(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
				} else {
					polizza.setValoreRiscattoNetto("0,00");
				}
				

				
				polizza.setIsACLSLungaSopravvivenza(avvisi.isIsACLSLungaSopravvivenza());				
				
				//polizza.setControlloCertezza(controlloCertezza);


                LoggingUtils.info("AVVISI SCADENZA PA N°:" + polizza.getNumero());
                LoggingUtils.info("--------------------");
                LoggingUtils.info("RAMO MINISTERIALE: "+polizza.getRamoMinisteriale());
                LoggingUtils.info("1a Col ANNI CERTEZZA  : "+polizza.getRendita().getCertezza().getOpzioneAnni1());
                LoggingUtils.info("2a Col ANNI CERTEZZA  : "+polizza.getRendita().getCertezza().getOpzioneAnni2());

                LoggingUtils.info("IS TABELLA CON 1 ANNALISA COLONNA: "+polizza.getRendita().getCertezza().isUnaCertezza());
                LoggingUtils.info("IS TABELLA CON 2 SORELLE  COLONNA: "+polizza.getRendita().getCertezza().isDueCertezze());
                LoggingUtils.info("--------------------");
			}
		} catch (ServiceException_Exception e) {
			throw new PucException(e.getMessage());
		}	
		
	}
}