package com.fideuram.crm.stampe.lettere;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.xml.datatype.XMLGregorianCalendar;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.LiquidazionePratica;
import com.fideuram.crm.stampe.model.Modello;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.puc.service.impl.LiquidazionePraticaVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.utils.NumberUtils;

public class LetteraDettaglioPratiche extends LetteraEngine{
   
    public LetteraDettaglioPratiche(int comID) throws WebServiceClientException {
        super(comID);
    }

    public void completaPolizza(Polizza polizza,DomandaVO domanda, Modello modello) throws WebServiceClientException, StampeInfoException, PucException {
        
		try {
			// Lista delle pratiche
			String numPratica = Inputs.getNumeroPratica(domanda);
				LiquidazionePratica liquidazione = new LiquidazionePratica();
				LiquidazionePraticaVO liquidazioneByNumPratica = pucS.getLiquidazioneByNumPratica(Long.parseLong(numPratica));
				liquidazione.setTipoIscritto(isNull(liquidazioneByNumPratica.getTIPOISCRITTO()));
				liquidazione.setTipoLavoratore(isNull(liquidazioneByNumPratica.getTIPOLAVORATORE()));
				liquidazione.setDtAdesionePrevidenza(isNull(convertGregorianCalendarToString(liquidazioneByNumPratica.getDATAADESIONE())));
				liquidazione.setDtIscrizionePrevidenza(isNull(convertGregorianCalendarToString(liquidazioneByNumPratica.getDATAISCRIZIONE())));
				liquidazione.setTipoLiquidazione(isNull(liquidazioneByNumPratica.getTIPOLIQUIDAZIONE()));
//				liquidazione.setImportoRichiesto(liquidazioneByNumPratica.get);??????
				liquidazione.setNumeroPratica(isNull(numPratica));
				liquidazione.setAnzianita2000(isNull(liquidazioneByNumPratica.getANZIANITA2000()));
				liquidazione.setAnzianita2006(isNull(liquidazioneByNumPratica.getANZIANITA2006()));
				liquidazione.setAnzianita2007(isNull(liquidazioneByNumPratica.getANZIANITA2007()));
				liquidazione.setAnzianitaContributivaTotale(isNull(liquidazioneByNumPratica.getANZIANITATOTALE()));
				String conAzienda2000 = liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2000() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2000().doubleValue(), 2): arrotonda(BigDecimal.ZERO.doubleValue(),2);
				String conAzienda2006 = liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2006() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2006().doubleValue(), 2): arrotonda(BigDecimal.ZERO.doubleValue(),2);
				String conAzienda2007 = liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2007() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2007().doubleValue(), 2): arrotonda(BigDecimal.ZERO.doubleValue(),2);
				
				double conAzienda2000D = liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2000() != null ? liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2000().doubleValue(): BigDecimal.ZERO.doubleValue();
				double conAzienda2006D = liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2006() != null ? liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2006().doubleValue(): BigDecimal.ZERO.doubleValue();
				double conAzienda2007D = liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2007() != null ? liquidazioneByNumPratica.getCONTRIBUTIAZIENDA2007().doubleValue(): BigDecimal.ZERO.doubleValue();
				double totaleAzienda = conAzienda2000D + conAzienda2006D + conAzienda2007D;
				
				liquidazione.setContributiAzienda2000(isNull(conAzienda2000));
				liquidazione.setContributiAzienda2006(isNull(conAzienda2006));
				liquidazione.setContributiAzienda2007(isNull(conAzienda2007));
				liquidazione.setContributiAziendaTotale(arrotonda(totaleAzienda,2));
				String con2000 = liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2000() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2000().doubleValue(), 2): arrotonda(BigDecimal.ZERO.doubleValue(),2);
				String con2006 = liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2006() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2006().doubleValue(), 2): arrotonda(BigDecimal.ZERO.doubleValue(),2);
				String con2007 = liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2007() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2007().doubleValue(), 2): arrotonda(BigDecimal.ZERO.doubleValue(),2);
				double con2000D = liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2000() != null ? liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2000().doubleValue(): BigDecimal.ZERO.doubleValue();
				double con2006D = liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2006() != null ? liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2006().doubleValue(): BigDecimal.ZERO.doubleValue();
				double con2007D = liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2007() != null ? liquidazioneByNumPratica.getCONTRIBUTILAVORATORE2007().doubleValue(): BigDecimal.ZERO.doubleValue();
				double conTotale = con2000D + con2006D + con2007D;
				liquidazione.setContributiLavoratore2000(con2000);
				liquidazione.setContributiLavoratore2006(con2006);
				liquidazione.setContributiLavoratore2007(con2007);
				liquidazione.setContributiLavoratoreTotale(arrotonda(conTotale,2));
				String tfr2000 = liquidazioneByNumPratica.getCONTRIBUTITFR2000() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTITFR2000().doubleValue(),2) : arrotonda(BigDecimal.ZERO.doubleValue(), 2);
				String tfr2006 = liquidazioneByNumPratica.getCONTRIBUTITFR2006() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTITFR2006().doubleValue(),2) : arrotonda(BigDecimal.ZERO.doubleValue(), 2);
				String tfr2007 = liquidazioneByNumPratica.getCONTRIBUTITFR2007() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTITFR2007().doubleValue(),2) : arrotonda(BigDecimal.ZERO.doubleValue(), 2);
				
				double tfr2000D = liquidazioneByNumPratica.getCONTRIBUTITFR2000() != null ? liquidazioneByNumPratica.getCONTRIBUTITFR2000().doubleValue() : BigDecimal.ZERO.doubleValue();
				double tfr2006D = liquidazioneByNumPratica.getCONTRIBUTITFR2006() != null ? liquidazioneByNumPratica.getCONTRIBUTITFR2006().doubleValue() : BigDecimal.ZERO.doubleValue();
				double tfr2007D = liquidazioneByNumPratica.getCONTRIBUTITFR2007() != null ? liquidazioneByNumPratica.getCONTRIBUTITFR2007().doubleValue() : BigDecimal.ZERO.doubleValue();
				double tfrTotale = tfr2000D + tfr2006D + tfr2007D;
				liquidazione.setQuoteTFR2000(tfr2000);
				liquidazione.setQuoteTFR2006(tfr2006);
				liquidazione.setQuoteTFR2007(tfr2007);
				liquidazione.setQuoteTFRTotale(arrotonda(tfrTotale,2));
				double totale2000 = con2000D + conAzienda2000D + tfr2000D;
				double totale2006 =con2006D + conAzienda2006D + tfr2006D;
				double totale2007 = con2007D + conAzienda2007D + tfr2007D;
				double totale = conTotale + totaleAzienda + tfrTotale;
				liquidazione.setTotale(arrotonda(totale,2));
				liquidazione.setTotale2000(arrotonda(totale2000, 2));
				liquidazione.setTotale2006(arrotonda(totale2006, 2));
				liquidazione.setTotale2007(arrotonda(totale2007,2));
				liquidazione.setValorePosizioneIndividuale2000(liquidazioneByNumPratica.getMONTANTE2000() != null ? arrotonda(liquidazioneByNumPratica.getMONTANTE2000().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setValorePosizioneIndividuale2006(liquidazioneByNumPratica.getMONTANTE2006() != null ? arrotonda(liquidazioneByNumPratica.getMONTANTE2006().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setValorePosizioneIndividuale2007(liquidazioneByNumPratica.getMONTANTE2007() != null ? arrotonda(liquidazioneByNumPratica.getMONTANTE2007().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setAnticipazioniPregresse2000(liquidazioneByNumPratica.getANTICIPAZIONI2000() != null ? arrotonda(liquidazioneByNumPratica.getANTICIPAZIONI2000().doubleValue(), 2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setAnticipazioniPregresse2006(liquidazioneByNumPratica.getANTICIPAZIONI2006() != null ? arrotonda(liquidazioneByNumPratica.getANTICIPAZIONI2006().doubleValue(), 2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setAnticipazioniPregresse2007(liquidazioneByNumPratica.getANTICIPAZIONI2007() != null ? arrotonda(liquidazioneByNumPratica.getANTICIPAZIONI2007().doubleValue(), 2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setImposteAnticipatePregresse2000(liquidazioneByNumPratica.getIMPOSTEANTICIPAZIONE2000() != null? arrotonda(liquidazioneByNumPratica.getIMPOSTEANTICIPAZIONE2000().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setImposteAnticipatePregresse2006(liquidazioneByNumPratica.getIMPOSTEANTICIPAZIONE2006() != null? arrotonda(liquidazioneByNumPratica.getIMPOSTEANTICIPAZIONE2006().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setImposteAnticipatePregresse2007(liquidazioneByNumPratica.getIMPOSTEANTICIPAZIONE2007() != null? arrotonda(liquidazioneByNumPratica.getIMPOSTEANTICIPAZIONE2007().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setRiscattoParzialePregresso2000(liquidazioneByNumPratica.getRISPARZIALE2000() != null ? arrotonda(liquidazioneByNumPratica.getRISPARZIALE2000().doubleValue(),2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "" );
				liquidazione.setRiscattoParzialePregresso2006(liquidazioneByNumPratica.getRISPARZIALE2001() != null ? arrotonda(liquidazioneByNumPratica.getRISPARZIALE2001().doubleValue(), 2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setRiscattoParzialePregresso2007(liquidazioneByNumPratica.getRISPARZIALE2007() != null ?arrotonda(liquidazioneByNumPratica.getRISPARZIALE2007().doubleValue(), 2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setImposteRiscattoParziale2000(liquidazioneByNumPratica.getIMPOSTERISPARZIALE2000() != null ? arrotonda(liquidazioneByNumPratica.getIMPOSTERISPARZIALE2000().doubleValue(),2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "" );
				liquidazione.setImposteRiscattoParziale2006(liquidazioneByNumPratica.getIMPOSTERISPARZIALE2006() != null ? 	arrotonda(liquidazioneByNumPratica.getIMPOSTERISPARZIALE2006().doubleValue(), 2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setImposteRiscattoParziale2007(liquidazioneByNumPratica.getIMPOSTERISPARZIALE2007() != null ?arrotonda(liquidazioneByNumPratica.getIMPOSTERISPARZIALE2007().doubleValue(), 2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				double lordo2000 = liquidazioneByNumPratica.getLORDO2000() != null ? liquidazioneByNumPratica.getLORDO2000().doubleValue() : BigDecimal.ZERO.doubleValue();
				double lordo2006 = liquidazioneByNumPratica.getLORDO2006() != null ? liquidazioneByNumPratica.getLORDO2006().doubleValue() : BigDecimal.ZERO.doubleValue();
				double lordo2007 = liquidazioneByNumPratica.getLORDO2007() != null ? liquidazioneByNumPratica.getLORDO2007().doubleValue() : BigDecimal.ZERO.doubleValue();
				liquidazione.setLordoInLiquidazione2000(arrotonda(lordo2000, 2));
				liquidazione.setLordoInLiquidazione2006(arrotonda(lordo2006, 2));
				liquidazione.setLordoInLiquidazione2007(arrotonda(lordo2007, 2));
				liquidazione.setContributiEsentiIRPEF2000(liquidazioneByNumPratica.getCONTRIBUTITFR2000() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTITFR2000().doubleValue(),2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setContributiEsentiIRPEF2006(liquidazioneByNumPratica.getCONTRIBUTITFR2006() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTITFR2006().doubleValue(),2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setContributiEsentiIRPEF2007(liquidazioneByNumPratica.getCONTRIBUTITFR2007() != null ? arrotonda(liquidazioneByNumPratica.getCONTRIBUTITFR2007().doubleValue(),2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setFranchigiaTFR2000(liquidazioneByNumPratica.getFRANCHIGIATFR() != null ? arrotonda(liquidazioneByNumPratica.getFRANCHIGIATFR().doubleValue(), 2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setFranchigiaTFR2006(liquidazioneByNumPratica.getFRANCHIGIATFR() != null ? arrotonda(liquidazioneByNumPratica.getFRANCHIGIATFR().doubleValue(), 2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setFranchigiaTFR2007(liquidazioneByNumPratica.getFRANCHIGIATFR() != null ? arrotonda(liquidazioneByNumPratica.getFRANCHIGIATFR().doubleValue(), 2) + "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setRendimenti2000(liquidazioneByNumPratica.getRENDIMENTO2000() != null ? arrotonda(liquidazioneByNumPratica.getRENDIMENTO2000().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setRendimenti2006(liquidazioneByNumPratica.getRENDIMENTO2006() != null ? arrotonda(liquidazioneByNumPratica.getRENDIMENTO2006().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setRendimenti2007(liquidazioneByNumPratica.getRENDIMENTO2007() != null ? arrotonda(liquidazioneByNumPratica.getRENDIMENTO2007().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setContributiNonDedotti2006(liquidazioneByNumPratica.getNONDEDOTTI2006() != null ? arrotonda(liquidazioneByNumPratica.getNONDEDOTTI2006().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setContributiNonDedotti2007(liquidazioneByNumPratica.getNONDEDOTTI2007() != null ? arrotonda(liquidazioneByNumPratica.getNONDEDOTTI2007().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setTotFisc2000(liquidazioneByNumPratica.getTOTALECONTRIBUTI2000() != null ? arrotonda(liquidazioneByNumPratica.getTOTALECONTRIBUTI2000().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setTotFisc2006(liquidazioneByNumPratica.getTOTALECONTRIBUTI2006() != null ? arrotonda(liquidazioneByNumPratica.getTOTALECONTRIBUTI2006().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setTotFisc2007(liquidazioneByNumPratica.getTOTALECONTRIBUTI2007() != null ? arrotonda(liquidazioneByNumPratica.getTOTALECONTRIBUTI2007().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setAliquotaTassazioneSeparata2000(liquidazioneByNumPratica.getALIQTASSEP2000() != null ? arrotonda(liquidazioneByNumPratica.getALIQTASSEP2000().doubleValue(), 2)+ "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setAliquotaTassazioneSeparata2006(liquidazioneByNumPratica.getALIQTASSEP2006() != null ? arrotonda(liquidazioneByNumPratica.getALIQTASSEP2006().doubleValue(), 2)+ "" : arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setAliquotaIRPEF20(liquidazioneByNumPratica.getALIQIRPEF() != null ? arrotonda(liquidazioneByNumPratica.getALIQIRPEF().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setAliquotaTFR(liquidazioneByNumPratica.getALIQTFR() != null ? arrotonda(liquidazioneByNumPratica.getALIQTFR().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2) + "");
				liquidazione.setAliquotaDefinitiva(liquidazioneByNumPratica.getALIQTASSDEF() != null ? arrotonda(liquidazioneByNumPratica.getALIQTASSDEF().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+ "");
				liquidazione.setAliquotaIRPEFTO(liquidazioneByNumPratica.getALIQTASSPROGRESSIVA() != null ? arrotonda(liquidazioneByNumPratica.getALIQTASSPROGRESSIVA().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(), 2)+"");
				liquidazione.setAddizionaleComunale(liquidazioneByNumPratica.getADDIZIONALECOMUNALE() != null ? arrotonda(liquidazioneByNumPratica.getADDIZIONALECOMUNALE().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(),	 2)+"");
				liquidazione.setAddizionaleRegionale(liquidazioneByNumPratica.getADDIZIONALEREGIONALE() != null ? arrotonda(liquidazioneByNumPratica.getADDIZIONALEREGIONALE().doubleValue(), 2)+ "": arrotonda(BigDecimal.ZERO.doubleValue(),	 2)+"");
				liquidazione.setImposta2000(liquidazioneByNumPratica.getIMPONIBILE2000() != null ? arrotonda(liquidazioneByNumPratica.getIMPOSTA2000().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(),	 2)+"");
				liquidazione.setImposta2006(liquidazioneByNumPratica.getIMPONIBILE2006() != null ? arrotonda(liquidazioneByNumPratica.getIMPOSTA2006().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(),	 2)+"");
				liquidazione.setImposta2007(liquidazioneByNumPratica.getIMPONIBILE2007() != null ? arrotonda(liquidazioneByNumPratica.getIMPOSTA2007().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(),	 2)+"");
				liquidazione.setImpostaComunale(liquidazioneByNumPratica.getIMPOSTACOMUNALE()!= null ? arrotonda(liquidazioneByNumPratica.getIMPOSTACOMUNALE().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(),	 2)+"");
				liquidazione.setImpostaRegionale(liquidazioneByNumPratica.getIMPOSTAREGIONALE()!= null ? arrotonda(liquidazioneByNumPratica.getIMPOSTAREGIONALE().doubleValue(), 2) + "": arrotonda(BigDecimal.ZERO.doubleValue(),	 2)+"");
				double netto2000 = liquidazioneByNumPratica.getNETTO2000()!= null ? liquidazioneByNumPratica.getNETTO2000().doubleValue(): BigDecimal.ZERO.doubleValue();
				double netto2006 = liquidazioneByNumPratica.getNETTO2006()!= null ? liquidazioneByNumPratica.getNETTO2006().doubleValue(): BigDecimal.ZERO.doubleValue();
				double netto2007 = liquidazioneByNumPratica.getNETTO2007()!= null ? liquidazioneByNumPratica.getNETTO2007().doubleValue(): BigDecimal.ZERO.doubleValue();
				double totaleNetto = netto2000 + netto2006 + netto2007;
				liquidazione.setNettoLiquidazione2000(arrotonda(netto2000, 2));
				liquidazione.setNettoLiquidazione2006(arrotonda(netto2006, 2));
				liquidazione.setNettoLiquidazione2007(arrotonda(netto2007, 2));
				liquidazione.setTotaleNetto(arrotonda(totaleNetto,2));
				double lordoTotale = lordo2000 + lordo2006 + lordo2007;
				liquidazione.setLordoTotale(arrotonda(lordoTotale,2));
				modello.setLiquidazionePratica(liquidazione);

		} catch (ServiceException_Exception e) {
			throw new PucException(e.getMessage());
		}
	}

    private String convertGregorianCalendarToString(XMLGregorianCalendar xmlGregorianCalendar){
    	if(xmlGregorianCalendar != null){
	    	Calendar calendar = xmlGregorianCalendar.toGregorianCalendar();
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    	formatter.setTimeZone(calendar.getTimeZone());
	    	return formatter.format(calendar.getTime());
    	}
    	return null;
    }
   
    private String isNull(String value){
    	if(value == null){
    		return "";
    	}else
    		return value;
    }
    
    private String arrotonda(double number, int decimal) {
		double p = (double)Math.pow(10,decimal);
		number = number * p;
		double tmp = Math.round(number);
		double result = (double)tmp/p;
		return  NumberUtils.formatCurrency(
                result,
                Costanti.SEPARATORE_MIGLIAIA,
                Costanti.SEPARATORE_DECIMALI);
	}
}
