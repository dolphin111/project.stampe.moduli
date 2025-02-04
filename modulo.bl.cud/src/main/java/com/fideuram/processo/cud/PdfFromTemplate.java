package com.fideuram.processo.cud;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.fideuram.factory.FormatterFactory;
import com.fideuram.stampe.modello.cud.AltriDatiFiscali;
import com.fideuram.stampe.modello.cud.AnagraficaDatoreLavoro;
import com.fideuram.stampe.modello.cud.AnagraficaDipendente;
import com.fideuram.stampe.modello.cud.CUD;
import com.fideuram.stampe.modello.cud.CompensiAnniPrecedenti;
import com.fideuram.stampe.modello.cud.DatiConguagli;
import com.fideuram.stampe.modello.cud.DatiFiscali;
import com.fideuram.stampe.modello.cud.DatiINPS;
import com.fideuram.stampe.modello.cud.INPSCollaboratori;
import com.fideuram.stampe.modello.cud.INPSDipPubblici;
import com.fideuram.stampe.modello.cud.INPSDipSubordinati;
import com.fideuram.stampe.modello.cud.RedditiImponibili;
import com.fideuram.stampe.modello.cud.SommeIncrementoProduttivita;
import com.fideuram.stampe.modello.cud.TFR;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;

public class PdfFromTemplate {
	static Logger log= Logger.getLogger("cud");

	@SuppressWarnings("rawtypes")
	public static void generateAshwinFriends(CUD cud) throws IOException,	FileNotFoundException, DocumentException {
		
		
		PdfReader pdfTemplate = new PdfReader("C:/Fideuram/configCRM/CUD/CUD_2014.pdf");
		FileOutputStream fileOutputStream = new FileOutputStream("C:/Fideuram/configCRM/CUD/temp.pdf");
		PdfStamper stamper = new PdfStamper(pdfTemplate, fileOutputStream);
		AcroFields form = stamper.getAcroFields();
		HashMap fields = form.getFields();
		Set chiavi = fields.keySet();
		for (Object object : chiavi) {
//			log.debug(object);
			System.out.println("object: "+object);
		}
		
		form.setField("T.0.0", "2013"); 
		AnagraficaDatoreLavoro anagraficaDatLav = cud.getAnagraficaDatLav();

		form.setField("T.0.0", "2013");  
		form.setField("T1.1", checkStringNull(anagraficaDatLav.getCodFis()));  
		form.setField("T1.2", checkStringNull(anagraficaDatLav.getCognome_denominazione()));  
		form.setField("T1.3", checkStringNull(anagraficaDatLav.getNome()));  
		form.setField("T1.4", checkStringNull(anagraficaDatLav.getComune()));  
		form.setField("T1.5", checkStringNull(anagraficaDatLav.getProvincia()));  
		form.setField("T1.6", checkStringNull(anagraficaDatLav.getCAP()));  
		form.setField("T1.7", checkStringNull(anagraficaDatLav.getIndirizzo()));  
		form.setField("T1.8", checkStringNull(anagraficaDatLav.getTel_fax()));  
		form.setField("T1.9", checkStringNull(anagraficaDatLav.getEmail()));
		form.setField("T1.10", checkStringNull(anagraficaDatLav.getCodAttivita()));  
		form.setField("T1.11", checkStringNull(anagraficaDatLav.getCodSede()));  
  
		
		AnagraficaDipendente anagraficaDip = cud.getAnagraficaDip();
		form.setField("T2.1", checkStringNull(anagraficaDip.getCodFis()));  
		form.setField("T2.2", checkStringNull(anagraficaDip.getCognome()));  
		form.setField("T2.3", checkStringNull(anagraficaDip.getNome()));  
		form.setField("T2.4", checkStringNull(anagraficaDip.getSesso())); 
		if(anagraficaDip.getDataNascita()!=null){
			String[] dataNascita = anagraficaDip.getDataNascita().split("/");
			form.setField("T2.5", dataNascita[0]);  
			form.setField("T2.6", dataNascita[1]);  
			form.setField("T2.7", dataNascita[2]);  
		}
		form.setField("T2.8", checkStringNull(anagraficaDip.getComuneNascita()));  
		form.setField("T2.9", checkStringNull(anagraficaDip.getProvinciaNascita()));
		form.setField("T2.10", checkStringNull(anagraficaDip.getPrevidComplem()));  
		if(anagraficaDip.getDataIscrFondo()!=null){
			String[] dataFondo = anagraficaDip.getDataIscrFondo().split("/");
			form.setField("T2.11", dataFondo[0]);  
			form.setField("T2.12", dataFondo[1]);  
			form.setField("T2.13", dataFondo[2]);  
		}
		form.setField("T2.14", checkStringNull(anagraficaDip.getEventiEcc()));  
		form.setField("T2.15", checkStringNull(anagraficaDip.getDomicilioAnnoPrec()));  
		form.setField("T2.16", checkStringNull(anagraficaDip.getProvDomAnnoPrec()));  
		form.setField("T2.17", checkStringNull(anagraficaDip.getCodComuneDomAnnoPrec()));  
		form.setField("T2.18", checkStringNull(anagraficaDip.getDomicilioFineRappLav()));  
		form.setField("T2.19", checkStringNull(anagraficaDip.getProvDomFineRappLav()));  
		form.setField("T2.20", checkStringNull(anagraficaDip.getDomicilioCorrente()));  
		form.setField("T2.21", checkStringNull(anagraficaDip.getProvDomCorrente()));  
		form.setField("T2.22", checkStringNull(anagraficaDip.getCodComuneDomCorrente()));  

		DatiFiscali datiFiscali = cud.getDatiFiscali();
		form.setField("T3.1", FormatterFactory.getStandardImporto(datiFiscali.getRedditi1234Tuir()));  
		form.setField("T3.2", FormatterFactory.getStandardImporto(datiFiscali.getRedditi5_5bisTuir())); 
		form.setField("T3.3", checkStringNull(datiFiscali.getGiorni1234TuirLavDip()));
		form.setField("T3.4", checkStringNull(datiFiscali.getGiorni1234TuirPensione())); 
		form.setField("T3.5", FormatterFactory.getStandardImporto(datiFiscali.getRitenutaIrpef()));  
		form.setField("T3.6", FormatterFactory.getStandardImporto(datiFiscali.getAddRegIrpef())); 
		form.setField("T3.10", FormatterFactory.getStandardImporto(datiFiscali.getAddComIrpefAccPrec()));  
		form.setField("T3.11", FormatterFactory.getStandardImporto(datiFiscali.getAddComIrpefSaldoPrec()));  
		form.setField("T3.13", FormatterFactory.getStandardImporto(datiFiscali.getAddComIrpefAccCorr())); 
		form.setField("T3.14", FormatterFactory.getStandardImporto(datiFiscali.getRitenIrpefSosp()));  
		form.setField("T3.15", FormatterFactory.getStandardImporto(datiFiscali.getAddRegIrpefSosp()));  
		form.setField("T3.17", FormatterFactory.getStandardImporto(datiFiscali.getAddComIrpefSospAccPrec()));  
		form.setField("T3.18", FormatterFactory.getStandardImporto(datiFiscali.getAddComIrpefSospSaldoPrec()));  
		form.setField("T3.21", FormatterFactory.getStandardImporto(datiFiscali.getPrimAccIrpefTrat()));  
		form.setField("T3.22", FormatterFactory.getStandardImporto(datiFiscali.getSec_unicAccIrpefTrat()));  
		form.setField("T3.23", FormatterFactory.getStandardImporto(datiFiscali.getAccIrpefSosp()));  
		form.setField("T3.24", FormatterFactory.getStandardImporto(datiFiscali.getAccAddComIrpef()));  
		form.setField("T3.25", FormatterFactory.getStandardImporto(datiFiscali.getAccAddComIrpefSosp()));  
		form.setField("T3.26", FormatterFactory.getStandardImporto(datiFiscali.getPrimRataAccCedSec()));  
		form.setField("T3.27", FormatterFactory.getStandardImporto(datiFiscali.getSec_unicAccIrpefTrat()));  
		form.setField("T3.28", FormatterFactory.getStandardImporto(datiFiscali.getAccCedSecSosp()));  
		form.setField("T3.36", FormatterFactory.getStandardImporto(datiFiscali.getCredIrpefNoRimb()));  
		form.setField("T3.37", FormatterFactory.getStandardImporto(datiFiscali.getCredAddRegIrpefNoRimb()));  
		form.setField("T3.38", FormatterFactory.getStandardImporto(datiFiscali.getCredAddComIrpefNoRimb()));  
		form.setField("T3.39", FormatterFactory.getStandardImporto(datiFiscali.getCredCedSecNoRimb())); 
		
		AltriDatiFiscali altriDatiFis = cud.getAltriDatiFis();
		form.setField("T3.101", FormatterFactory.getStandardImporto(altriDatiFis.getImpostaLorda()));  
		form.setField("T3.102", FormatterFactory.getStandardImporto(altriDatiFis.getDetrazFamiglia()));  
		form.setField("T3.103", FormatterFactory.getStandardImporto(altriDatiFis.getDetrazFamNum()));  
		form.setField("T3.104", FormatterFactory.getStandardImporto(altriDatiFis.getCredRiconFamNum()));  
		form.setField("T3.105", FormatterFactory.getStandardImporto(altriDatiFis.getCredNoRicFamNum()));  
		form.setField("T3.106", FormatterFactory.getStandardImporto(altriDatiFis.getCredFamNumRec()));  
		form.setField("T3.107", FormatterFactory.getStandardImporto(altriDatiFis.getDetrLavDip_Pens_Redditi()));  
		form.setField("T3.108", FormatterFactory.getStandardImporto(altriDatiFis.getDetrOneri()));  
		form.setField("T3.109", FormatterFactory.getStandardImporto(altriDatiFis.getDetrCanLoc()));  
		form.setField("T3.110", FormatterFactory.getStandardImporto(altriDatiFis.getCredRicCanLoc()));  
		form.setField("T3.111", FormatterFactory.getStandardImporto(altriDatiFis.getCredNoRicCanLoc()));  
		form.setField("T3.112", FormatterFactory.getStandardImporto(altriDatiFis.getCredCanLocRec()));  
		form.setField("T3.113", FormatterFactory.getStandardImporto(altriDatiFis.getTotDetrazioni()));  
		form.setField("T3.114", FormatterFactory.getStandardImporto(altriDatiFis.getCredImpPagEstero()));  
		form.setField("T3.119", FormatterFactory.getStandardImporto(altriDatiFis.getContrPrevComplEsclRedditi()));  
		form.setField("T3.120", FormatterFactory.getStandardImporto(altriDatiFis.getContrPrevComplNoEsclRedditi()));  
		form.setField("T3.122", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOVersati()));  
		form.setField("T3.123", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOEcced()));  
		form.setField("T3.124", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOTot()));  
		form.setField("T3.125", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPODiffer()));  
		form.setField("T3.126", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOAnniRes()));  
		form.setField("T3.127", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOPrevCompFam()));  
		form.setField("T3.129", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOTotOneriNORedditi()));  
		form.setField("T3.130", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOTotOneriNOEsclRedditi()));  
		form.setField("T3.131", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOTotOneriDetraz()));  
		form.setField("T3.134", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOContrAssist()));  
		form.setField("T3.135", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOAssicSanit()));  
		form.setField("T3.136", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOApplMagRit()));  
		form.setField("T3.137", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOCasiPart()));  
		form.setField("T3.138", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOContrSolid()));  
		form.setField("T3.139", FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOContrSolidSosp()));  
		
		DatiConguagli datiConguagli = cud.getDatiConguagli();
		form.setField("T3.201", FormatterFactory.getStandardImporto(datiConguagli.getIrpefTratSuc28Feb()));  
		form.setField("T3.203", FormatterFactory.getStandardImporto(datiConguagli.getIrpefDaVers()));  
		form.setField("T3.204", FormatterFactory.getStandardImporto(datiConguagli.getTotredCong1()));  
		form.setField("T3.205", FormatterFactory.getStandardImporto(datiConguagli.getTotredCong2())); 
		
		SommeIncrementoProduttivita sommeIncrProd = cud.getSommeIncrProd();
		form.setField("T3.251", FormatterFactory.getStandardImporto(sommeIncrProd.getTotRedd13()));  
		form.setField("T3.252", FormatterFactory.getStandardImporto(sommeIncrProd.getTotRit()));  
		form.setField("T3.253", FormatterFactory.getStandardImporto(sommeIncrProd.getRitSosp()));  
		form.setField("T3.254", checkStringNull(sommeIncrProd.getIstruzioni()));  
		form.setField("T3.255", FormatterFactory.getStandardImporto(sommeIncrProd.getReddNoImp()));  
		
		RedditiImponibili redditiImponibili = cud.getRedditiImponibili();
		form.setField("T3.301", FormatterFactory.getStandardImporto(redditiImponibili.getTotRedd()));  
		form.setField("T3.302", FormatterFactory.getStandardImporto(redditiImponibili.getTotRitIrpef()));  
		form.setField("T3.303", FormatterFactory.getStandardImporto(redditiImponibili.getTotAddRegIrpef()));  
		form.setField("T3.304", FormatterFactory.getStandardImporto(redditiImponibili.getTotRitIrpefSosp()));  
		form.setField("T3.305", FormatterFactory.getStandardImporto(redditiImponibili.getTotAddRegIrpefSosp())); 
		
		CompensiAnniPrecedenti compensiAnniPrec = cud.getCompensiAnniPrec();
		form.setField("T3.351", FormatterFactory.getStandardImporto(compensiAnniPrec.getTotCompArrDetr()));  
		form.setField("T3.352", FormatterFactory.getStandardImporto(compensiAnniPrec.getTotCompArrNoDetr()));  
		form.setField("T3.353", FormatterFactory.getStandardImporto(compensiAnniPrec.getTotRitOper()));  
		form.setField("T3.354", FormatterFactory.getStandardImporto(compensiAnniPrec.getTotRitSosp()));  
		
		TFR tfr = cud.getTfr();
		form.setField("T3.401", FormatterFactory.getStandardImporto(tfr.getIndAccAntSomAnno()));  
		form.setField("T3.402", FormatterFactory.getStandardImporto(tfr.getAccAntAnniPrec()));  
		form.setField("T3.403", FormatterFactory.getStandardImporto(tfr.getDetrazione()));  
		form.setField("T3.404", FormatterFactory.getStandardImporto(tfr.getRitenutaAnno()));  
		form.setField("T3.405", FormatterFactory.getStandardImporto(tfr.getRitenuteSosp()));  
		form.setField("T3.406", FormatterFactory.getStandardImporto(tfr.getRitenAnniPrec()));  
		form.setField("T3.407", FormatterFactory.getStandardImporto(tfr.getRitenAnniPrecSosp()));  
		form.setField("T3.408", FormatterFactory.getStandardImporto(tfr.getIndArt2122()));  
		form.setField("T3.409", FormatterFactory.getStandardImporto(tfr.getTfrNoPrelMatFi00()));  
		form.setField("T3.410", FormatterFactory.getStandardImporto(tfr.getTfrNoPrelMatDa01()));  
		form.setField("T3.411", FormatterFactory.getStandardImporto(tfr.getTfrVersMatFi00()));  
		form.setField("T3.412", FormatterFactory.getStandardImporto(tfr.getTfrVersMat01_06()));  
		form.setField("T3.413", FormatterFactory.getStandardImporto(tfr.getTfrVersMatDa07()));  
		
		DatiINPS datiINPS = cud.getDatiINPS();
		
		INPSDipSubordinati inpsSub = datiINPS.getInpsSub();
		form.setField("T4.1", checkStringNull(inpsSub.getMatrAzienda())); 
		form.setField("T4.2", checkStringNull(inpsSub.getInps())); 
		form.setField("T4.3", checkStringNull(inpsSub.getAltro())); 
		form.setField("T4.4", FormatterFactory.getStandardImporto(inpsSub.getImponPrevid()));  
		form.setField("T4.5", FormatterFactory.getStandardImporto(inpsSub.getImponIVS()));  
		form.setField("T4.6", FormatterFactory.getStandardImporto(inpsSub.getContribLavTratt()));  
		char[] mesiDenUniemens = inpsSub.getMesiDenUniemens();
		if(mesiDenUniemens[0]=='x'){
			setSizeFontField(form,"T4.7", 18);
			form.setField("T4.7", "/"); 
		}else{
			setSizeFontField(form,"T4.8.0", 18);
			setSizeFontField(form,"T4.8.1", 18);
			setSizeFontField(form,"T4.8.2", 18);
			setSizeFontField(form,"T4.8.3", 18);
			setSizeFontField(form,"T4.8.4", 18);
			setSizeFontField(form,"T4.8.5", 18);
			setSizeFontField(form,"T4.8.6", 18);
			setSizeFontField(form,"T4.8.7", 18);
			setSizeFontField(form,"T4.8.8", 18);
			setSizeFontField(form,"T4.8.9", 18);
			setSizeFontField(form,"T4.8.10", 18);
			setSizeFontField(form,"T4.8.11", 18);
			form.setField("T4.8.0", checkMonth(mesiDenUniemens[1]));  
			form.setField("T4.8.1", checkMonth(mesiDenUniemens[2]));  
			form.setField("T4.8.2", checkMonth(mesiDenUniemens[3]));  
			form.setField("T4.8.3", checkMonth(mesiDenUniemens[4]));  
			form.setField("T4.8.4", checkMonth(mesiDenUniemens[5]));  
			form.setField("T4.8.5", checkMonth(mesiDenUniemens[6]));  
			form.setField("T4.8.6", checkMonth(mesiDenUniemens[7]));  
			form.setField("T4.8.7", checkMonth(mesiDenUniemens[8]));  
			form.setField("T4.8.8", checkMonth(mesiDenUniemens[9]));  
			form.setField("T4.8.9", checkMonth(mesiDenUniemens[10]));  
			form.setField("T4.8.10", checkMonth(mesiDenUniemens[11]));  
			form.setField("T4.8.11", checkMonth(mesiDenUniemens[12]));  
		}



		INPSCollaboratori inpsColl = datiINPS.getInpsColl();
		form.setField("T4.9", FormatterFactory.getStandardImporto(inpsColl.getCompensi())); 
		form.setField("T4.10", FormatterFactory.getStandardImporto(inpsColl.getContribDovuti()));  
		form.setField("T4.11", FormatterFactory.getStandardImporto(inpsColl.getContribTrattenuti()));  
		form.setField("T4.12", FormatterFactory.getStandardImporto(inpsColl.getContribVersati()));  
		
		char[] mesiDenUniemens2 = inpsColl.getMesiDenUniemens();
		if(mesiDenUniemens2[0]=='x'){
			setSizeFontField(form,"T4.13", 18);
			form.setField("T4.13", "/"); 
		}else{
			setSizeFontField(form,"T4.14.0", 18);
			setSizeFontField(form,"T4.14.1", 18);
			setSizeFontField(form,"T4.14.2", 18);
			setSizeFontField(form,"T4.14.3", 18);
			setSizeFontField(form,"T4.14.4", 18);
			setSizeFontField(form,"T4.14.5", 18);
			setSizeFontField(form,"T4.14.6", 18);
			setSizeFontField(form,"T4.14.7", 18);
			setSizeFontField(form,"T4.14.8", 18);
			setSizeFontField(form,"T4.14.9", 18);
			setSizeFontField(form,"T4.14.10", 18);
			setSizeFontField(form,"T4.14.11", 18);
			form.setField("T4.14.0", checkMonth(mesiDenUniemens2[1]));
			form.setField("T4.14.1", checkMonth(mesiDenUniemens2[2]));  
			form.setField("T4.14.2", checkMonth(mesiDenUniemens2[3]));  
			form.setField("T4.14.3", checkMonth(mesiDenUniemens2[4]));  
			form.setField("T4.14.4", checkMonth(mesiDenUniemens2[5]));  
			form.setField("T4.14.5", checkMonth(mesiDenUniemens2[6]));  
			form.setField("T4.14.6", checkMonth(mesiDenUniemens2[7]));  
			form.setField("T4.14.7", checkMonth(mesiDenUniemens2[8]));  
			form.setField("T4.14.8", checkMonth(mesiDenUniemens2[9]));  
			form.setField("T4.14.9", checkMonth(mesiDenUniemens2[10])); 
			form.setField("T4.14.10", checkMonth(mesiDenUniemens2[11]));  
			form.setField("T4.14.11", checkMonth(mesiDenUniemens2[12]));  
		}
		
		INPSDipPubblici inpsPub = datiINPS.getInpsPub();
		form.setField("T4.15", checkStringNull(inpsPub.getCodFisAmm()));  
		form.setField("T4.16", checkStringNull(inpsPub.getProgAzienda()));  
		form.setField("T4.17", checkStringNull(inpsPub.getCodSPT_MEF()));  
		String pens= FormatterFactory.getStandardImporto(inpsPub.getGestPens());
		String prev=  FormatterFactory.getStandardImporto(inpsPub.getGestPrev());
		String endep= FormatterFactory.getStandardImporto(inpsPub.getGestCredEndep());
		String enam= FormatterFactory.getStandardImporto(inpsPub.getGestCredEnam());
		
		
		
		int blankToEmptyPens = pens.length()+6-(2*pens.length());
		int blankToEmptyPrev = prev.length()+22-(2*prev.length());
		int blankToEmptyEndep = endep.length()+8-(2*endep.length());
		int blankToEmptyEnap = enam.length()+6-(2*enam.length());
		form.setField("T4.18", StringUtils.leftPad(pens,blankToEmptyPens)+StringUtils.leftPad(prev,blankToEmptyPrev)+StringUtils.leftPad(endep,blankToEmptyEndep)+StringUtils.leftPad(enam,blankToEmptyEnap));  
		form.setField("T4.22", checkStringNull(inpsPub.getAnnoRif()));  
		form.setField("T4.23", FormatterFactory.getStandardImporto(inpsPub.getTotImpPens()));  
		form.setField("T4.24", FormatterFactory.getStandardImporto(inpsPub.getTotContribPens()));  
		form.setField("T4.25", FormatterFactory.getStandardImporto(inpsPub.getTotImpPens()));  
		form.setField("T4.26", FormatterFactory.getStandardImporto(inpsPub.getTotContribTFS()));  
		form.setField("T4.27", FormatterFactory.getStandardImporto(inpsPub.getTotImpTFR()));  
		form.setField("T4.28", FormatterFactory.getStandardImporto(inpsPub.getTotContribTFR()));  
		form.setField("T4.29", FormatterFactory.getStandardImporto(inpsPub.getTotImpGestCred()));  
		form.setField("T4.30", FormatterFactory.getStandardImporto(inpsPub.getTotContribGestCred()));  
		form.setField("T4.31", FormatterFactory.getStandardImporto(inpsPub.getTotImpENPDEP_ENAM()));  
		form.setField("T4.32", FormatterFactory.getStandardImporto(inpsPub.getTotContribENPDEP_ENAM()));  
 

 
		form.setField("T4.A", checkStringNull(cud.getAnnotazioni()));
		String[] data = cud.getData().split("/");
		if(data!=null){
			form.setField("T4.aa", data[2]);  
			form.setField("T4.gg", data[0]);  
			form.setField("T4.mm", data[1]); 
		}
		
//		stamper.getAcroFields().setField("T6.1", );  
//		stamper.getAcroFields().setField("T6.2", );  
//		stamper.getAcroFields().setField("T6.3", );  
//		stamper.getAcroFields().setField("T6.4", );  
//		stamper.getAcroFields().setField("T6.5", );  
		
		//###	INSERT SIGN - START
		String imageUrl = "C:/Fideuram/configCRM/CUD/firma.png";
		Image firma=Image.getInstance(imageUrl);
		firma.setAbsolutePosition(360f, 230f);
		firma.scalePercent(30);
		PdfContentByte content = stamper.getOverContent(2);
		content.addImage(firma);
		//###	INSERT SIGN - END
				
		stamper.close();
		pdfTemplate.close();
		
		
		
		/**###		ACCOMPAGNAMENTO - BEGIN		###*/
		PdfReader accompagnamentoReader= new PdfReader("C:/Fideuram/configCRM/CUD/accompagnamento.pdf");
		FileOutputStream fileOutputStreamAcc = new FileOutputStream("C:/Fideuram/configCRM/CUD/tempAcc.pdf");
		PdfStamper stamperAcc = new PdfStamper(accompagnamentoReader, fileOutputStreamAcc);
		stamperAcc.setFormFlattening(true);
		AcroFields formAcc = stamperAcc.getAcroFields();
		HashMap fieldsAcc = formAcc.getFields();
		Set chiaviAcc = fieldsAcc.keySet();
		for (Object object : chiaviAcc) {
			log.debug(object);
		}
		formAcc.setField("Campo#20di#20testo#202", anagraficaDip.getIndirizzoDip());
		formAcc.setField("Campo#20di#20testo#201", anagraficaDip.getCognome()+" "+anagraficaDip.getNome() );
		formAcc.setField("Campo#20di#20testo#204", data[0]+" / "+data[1]+" /"+data[2]);
		formAcc.setField("Campo#20di#20testo#203", anagraficaDip.getCap()+", "+anagraficaDip.getDomicilioCorrente().trim()+" "+anagraficaDip.getProvDomCorrente().trim());
		stamperAcc.close();
		accompagnamentoReader.close();
		/**###		ACCOMPAGNAMENTO - END		###*/
		
		
		/**	#####	2 COPIE - START		#####*/
		PdfReader reader=new PdfReader("C:/Fideuram/configCRM/CUD/temp.pdf");
		reader.selectPages("1-3");
		accompagnamentoReader= new PdfReader("C:/Fideuram/configCRM/CUD/tempAcc.pdf");
		int n = reader.getNumberOfPages();
		Document doc= new Document();
		PdfCopy copy= new PdfCopy(doc, new FileOutputStream("C:/Fideuram/configCRM/CUD/"+anagraficaDip.getCodFis()+".pdf"));
		doc.open();
		copy.addPage(copy.getImportedPage(accompagnamentoReader, 1));
		for(int j=0; j<2;j++){
			for (int i = 0; i < n; ) {
				copy.addPage(copy.getImportedPage(reader, ++i));
			}
		}
		doc.close();
		File file= new File("C:/Fideuram/configCRM/CUD/temp.pdf");
		file.delete();
		file= new File("C:/Fideuram/configCRM/CUD/tempacc.pdf");
		file.delete();
		/**	#####	2 COPIE - END		#####*/
}


	private static void setSizeFontField(AcroFields form, String fieldName, int fontSize) {
		form.setFieldProperty(fieldName, "textsize", new Float(fontSize), null);
		
	}


	private static String checkMonth(char c) {
		if(c=='x'){
			return "/";
		}
		return "";
	}


	private static String checkStringNull(String value) {
		if(value==null)
			return "";
		return value;
	}
	
	
//	public static void main(String[] args) {
//		PdfFromTemplate pdf = new PdfFromTemplate();
//		
//		try {
//			pdf.generateAshwinFriends();
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
