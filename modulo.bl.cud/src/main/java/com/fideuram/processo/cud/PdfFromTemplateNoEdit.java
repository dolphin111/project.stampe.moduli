package com.fideuram.processo.cud;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
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
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.lowagie.text.pdf.AcroFields;


public class PdfFromTemplateNoEdit {
	private static final String RESULT = "C:/Fideuram/configCRM/CUD/Cuddariello.pdf";
	static Logger log= Logger.getLogger("cud");
	
	public static void generaPdfNoEdit(CUD cud) throws MalformedURLException, IOException, DocumentException, com.lowagie.text.DocumentException{
		PdfReader reader = new PdfReader(RESULT);
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("C:/Fideuram/configCRM/CUD/temp.pdf"));
		stamper.setRotateContents(false);
		PdfContentByte canvas = stamper.getOverContent(1);
//		Phrase ph = new Phrase("Provola", new Font(FontFamily.HELVETICA, 12));
//		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, ph, 465, 770, 0);
//		ph = new Phrase("Ciccio", new Font(FontFamily.HELVETICA, 12));
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase("2013", new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		
		
		AnagraficaDatoreLavoro anagraficaDatLav = cud.getAnagraficaDatLav();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getCodFis()), new Font(FontFamily.HELVETICA, 8)), 122, 713, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getCognome_denominazione()), new Font(FontFamily.HELVETICA, 8)), 268, 713, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getNome()), new Font(FontFamily.HELVETICA, 8)), 442, 713, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getComune()), new Font(FontFamily.HELVETICA, 8)), 122, 693, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getProvincia()), new Font(FontFamily.HELVETICA, 8)), 320, 693, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getCAP()), new Font(FontFamily.HELVETICA, 8)), 348, 693, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getIndirizzo()), new Font(FontFamily.HELVETICA, 8)), 400, 693, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getTel_fax()), new Font(FontFamily.HELVETICA, 8)), 122, 670, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getEmail()), new Font(FontFamily.HELVETICA, 8)), 267, 670, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getCodAttivita()), new Font(FontFamily.HELVETICA, 8)), 470, 670, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getCodSede()), new Font(FontFamily.HELVETICA, 8)), 520, 670, 0);
		
		
		AnagraficaDipendente anagraficaDip = cud.getAnagraficaDip();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getCodFis()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getCognome()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getNome()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getSesso()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		
		if(anagraficaDip.getDataNascita()!=null){
			String[] dataNascita = anagraficaDip.getDataNascita().split("/");
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(dataNascita[0], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(dataNascita[1], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(dataNascita[2], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		}
		
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getComuneNascita()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getProvinciaNascita()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getPrevidComplem()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

		if(anagraficaDip.getDataIscrFondo()!=null){
			String[] dataFondo = anagraficaDip.getDataIscrFondo().split("/");
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(dataFondo[0], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(dataFondo[1], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(dataFondo[2], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		}
		
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getEventiEcc()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getDomicilioAnnoPrec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getProvDomAnnoPrec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getCodComuneDomAnnoPrec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getDomicilioFineRappLav()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getProvDomFineRappLav()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getDomicilioCorrente()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getProvDomCorrente()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getCodComuneDomCorrente()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);


		DatiFiscali datiFiscali = cud.getDatiFiscali();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getRedditi1234Tuir()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getRedditi5_5bisTuir()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(datiFiscali.getGiorni1234TuirLavDip()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(datiFiscali.getGiorni1234TuirPensione()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getRitenutaIrpef()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAddRegIrpef()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAddComIrpefAccPrec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAddComIrpefSaldoPrec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAddComIrpefAccCorr()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getRitenIrpefSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAddRegIrpefSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAddComIrpefSospAccPrec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAddComIrpefSospSaldoPrec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getPrimAccIrpefTrat()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getSec_unicAccIrpefTrat()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAccIrpefSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAccAddComIrpef()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAccAddComIrpefSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getPrimRataAccCedSec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getAccCedSecSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getCredIrpefNoRimb()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getCredAddRegIrpefNoRimb()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getCredAddComIrpefNoRimb()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getSec_unicRataAccCedSec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiFiscali.getCredCedSecNoRimb()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

  
		AltriDatiFiscali altriDatiFis = cud.getAltriDatiFis();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getImpostaLorda()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getDetrazFamiglia()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getDetrazFamNum()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCredRiconFamNum()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCredNoRicFamNum()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCredFamNumRec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getDetrLavDip_Pens_Redditi()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getDetrOneri()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getDetrCanLoc()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCredRicCanLoc()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCredNoRicCanLoc()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCredCanLocRec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getTotDetrazioni()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCredImpPagEstero()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getContrPrevComplEsclRedditi()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getContrPrevComplNoEsclRedditi()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOVersati()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOEcced()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOTot()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPODiffer()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOAnniRes()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOPrevCompFam()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOTotOneriNORedditi()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOTotOneriNOEsclRedditi()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);  
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOTotOneriDetraz()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOContrAssist()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOAssicSanit()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOApplMagRit()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOCasiPart()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOContrSolid()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(altriDatiFis.getCPCLPOContrSolidSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
 
		
		DatiConguagli datiConguagli = cud.getDatiConguagli();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiConguagli.getIrpefTratSuc28Feb()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiConguagli.getIrpefDaVers()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiConguagli.getTotredCong1()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(datiConguagli.getTotredCong2()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

		
		//-- Pagina 2 --//
		canvas = stamper.getOverContent(2);
		SommeIncrementoProduttivita sommeIncrProd = cud.getSommeIncrProd();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(sommeIncrProd.getTotRedd13()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(sommeIncrProd.getTotRit()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(sommeIncrProd.getRitSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(sommeIncrProd.getIstruzioni()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(sommeIncrProd.getReddNoImp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

		
		RedditiImponibili redditiImponibili = cud.getRedditiImponibili();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(redditiImponibili.getTotRedd()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(redditiImponibili.getTotRitIrpef()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(redditiImponibili.getTotAddRegIrpef()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(redditiImponibili.getTotRitIrpefSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(redditiImponibili.getTotAddRegIrpefSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

		
		CompensiAnniPrecedenti compensiAnniPrec = cud.getCompensiAnniPrec();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(compensiAnniPrec.getTotCompArrDetr()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(compensiAnniPrec.getTotCompArrNoDetr()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(compensiAnniPrec.getTotRitOper()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(compensiAnniPrec.getTotRitSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
 
		
		TFR tfr = cud.getTfr();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getIndAccAntSomAnno()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getAccAntAnniPrec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getDetrazione()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getRitenutaAnno()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getRitenuteSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getRitenAnniPrec()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getRitenAnniPrecSosp()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getIndArt2122()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getTfrNoPrelMatFi00()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getTfrNoPrelMatDa01()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getTfrVersMatFi00()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getTfrVersMat01_06()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(tfr.getTfrVersMatDa07()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

		
		DatiINPS datiINPS = cud.getDatiINPS();
		
		INPSDipSubordinati inpsSub = datiINPS.getInpsSub();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(inpsSub.getMatrAzienda()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(inpsSub.getInps()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(inpsSub.getAltro()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsSub.getImponPrevid()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsSub.getImponIVS()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsSub.getContribLavTratt()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

 
		char[] mesiDenUniemens = inpsSub.getMesiDenUniemens();
		if(mesiDenUniemens[0]=='x'  || mesiDenUniemens[0]=='X'){
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase("X", new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);

		}else{
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[1]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[2]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[3]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[4]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[5]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[6]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[7]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[8]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[9]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[10]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[11]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens[12]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0); 
		}



		INPSCollaboratori inpsColl = datiINPS.getInpsColl();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsColl.getCompensi()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsColl.getContribDovuti()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsColl.getContribTrattenuti()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsColl.getContribVersati()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0); 
 
		
		char[] mesiDenUniemens2 = inpsColl.getMesiDenUniemens();
		if(mesiDenUniemens2[0]=='x' || mesiDenUniemens2[0]=='X'){
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase("X", new Font(FontFamily.HELVETICA, 18)), 465, 770, 0); 
		}else{

			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[1]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[2]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[3]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[4]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[5]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[6]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[7]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[8]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[9]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[10]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[11]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkMonth(mesiDenUniemens2[12]), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);  
		}
		
		INPSDipPubblici inpsPub = datiINPS.getInpsPub();
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(inpsPub.getCodFisAmm()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(inpsPub.getProgAzienda()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(inpsPub.getCodSPT_MEF()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
 
		String pens= FormatterFactory.getStandardImporto(inpsPub.getGestPens());
		String prev=  FormatterFactory.getStandardImporto(inpsPub.getGestPrev());
		String endep= FormatterFactory.getStandardImporto(inpsPub.getGestCredEndep());
		String enam= FormatterFactory.getStandardImporto(inpsPub.getGestCredEnam());

		int blankToEmptyPens = pens.length()+6-(2*pens.length());
		int blankToEmptyPrev = prev.length()+22-(2*prev.length());
		int blankToEmptyEndep = endep.length()+8-(2*endep.length());
		int blankToEmptyEnap = enam.length()+6-(2*enam.length());
		
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(StringUtils.leftPad(pens,blankToEmptyPens)+StringUtils.leftPad(prev,blankToEmptyPrev)+StringUtils.leftPad(endep,blankToEmptyEndep)+StringUtils.leftPad(enam,blankToEmptyEnap), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(inpsPub.getAnnoRif()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(inpsPub.getAnnoRif()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsPub.getTotImpPens()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsPub.getTotContribPens()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsPub.getTotContribTFS()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsPub.getTotImpTFR()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0); 
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsPub.getTotContribTFR()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsPub.getTotImpGestCred()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsPub.getTotContribGestCred()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsPub.getTotImpENPDEP_ENAM()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0); 
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(FormatterFactory.getStandardImporto(inpsPub.getTotContribENPDEP_ENAM()), new Font(FontFamily.HELVETICA, 18)), 465, 770, 0); 
		
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(cud.getAnnotazioni()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

		String[] data = cud.getData().split("/");
		if(data!=null){
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(data[0], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0); // Giorno
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(data[1], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0); // Mese
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(data[2], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0); // Anno
		}
		 
		
		//###	INSERT SIGN - START
		String imageUrl = "C:/Fideuram/configCRM/CUD/firma.png";
		Image firma=Image.getInstance(imageUrl);
		firma.setAbsolutePosition(360f, 220f);
		firma.scalePercent(30);
		PdfContentByte content = stamper.getOverContent(2);
		content.addImage(firma);
		//###	INSERT SIGN - END
				
//		stamper.close();

		//-- Pagina 3 --//
		canvas = stamper.getOverContent(3);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getCodFis()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getCodFis()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getCognome_denominazione()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getNome()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDip.getSesso()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);

		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getComune()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(checkStringNull(anagraficaDatLav.getProvincia()), new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		if(anagraficaDip.getDataNascita()!=null){
			String[] dataNascita = anagraficaDip.getDataNascita().split("/");
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(dataNascita[0], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(dataNascita[1], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
			ColumnText.showTextAligned(canvas,Element.ALIGN_UNDEFINED, new Phrase(dataNascita[2], new Font(FontFamily.HELVETICA, 12)), 465, 770, 0);
		}
		stamper.close();
		
		/**###		ACCOMPAGNAMENTO - BEGIN		###*/
		com.lowagie.text.pdf.PdfReader accompagnamentoReader= new com.lowagie.text.pdf.PdfReader("C:/Fideuram/configCRM/CUD/accompagnamento.pdf");
		FileOutputStream fileOutputStreamAcc = new FileOutputStream("C:/Fideuram/configCRM/CUD/tempAcc.pdf");
		com.lowagie.text.pdf.PdfStamper stamperAcc = new com.lowagie.text.pdf.PdfStamper(accompagnamentoReader, fileOutputStreamAcc);
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
		com.lowagie.text.pdf.PdfReader reader1=new com.lowagie.text.pdf.PdfReader("C:/Fideuram/configCRM/CUD/temp.pdf");
		reader1.selectPages("1-3");
		accompagnamentoReader= new com.lowagie.text.pdf.PdfReader("C:/Fideuram/configCRM/CUD/tempAcc.pdf");
		int n = reader1.getNumberOfPages();
		com.lowagie.text.Document doc= new com.lowagie.text.Document();
		com.lowagie.text.pdf.PdfCopy copy= new com.lowagie.text.pdf.PdfCopy(doc, new FileOutputStream("C:/Fideuram/configCRM/CUD/"+anagraficaDip.getCodFis()+".pdf"));
		doc.open();
		copy.addPage(copy.getImportedPage(accompagnamentoReader, 1));
		for(int j=0; j<2;j++){
			for (int i = 0; i < n; ) {
				copy.addPage(copy.getImportedPage(reader1, ++i));
			}
		}
		doc.close();
		File file= new File("C:/Fideuram/configCRM/CUD/temp.pdf");
		file.delete();
		file= new File("C:/Fideuram/configCRM/CUD/tempacc.pdf");
		file.delete();
		/**	#####	2 COPIE - END		#####*/
		
	}
	
	
	
	private static String checkMonth(char c) {
		if(c=='x' || c=='X'){
			return "X";
		}
		return "";
	}


	private static String checkStringNull(String value) {
		if(value==null)
			return "";
		return value;
	}
}
