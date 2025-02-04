package com.fideuram.manager.vgitext;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.fideuram.dao.vgitext.VgITextDao;
import com.fideuram.modello.vgitext.Collettiva;
import com.fideuram.modello.vgitext.Gruppo;
import com.fideuram.modello.vgitext.Riga;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class VGITextManager {

	    private static Font FONT = new Font(Font.FontFamily.COURIER  , 8, Font.NORMAL);
	    //private static Font FONT_714 = new Font(Font.FontFamily.COURIER  , 9, Font.NORMAL);
	    private static boolean ROTATE_A3 = false;
	    
	 public static Document print(File fileInput) {
	    	Document document = null;
	    	VgITextDao dao = new VgITextDao();
	        try {
		            Collettiva collettiva =  dao.getCollettivaIText(fileInput);
		            
		            String resultOutputPath = getSelectedFolderByFile(fileInput);
		           
		            getSelectedRotatePage(fileInput);
		            
		            if(ROTATE_A3)
		            	document = new Document(PageSize.A3.rotate());
		            else	
		            	document = new Document(PageSize.A4.rotate());
	
		            PdfWriter.getInstance(document, new FileOutputStream(resultOutputPath));
		            document.open();
	
		            for(int i=0; i<collettiva.getGruppi().size();i++){
		                Gruppo gruppo = collettiva.getGruppi().get(i);
		                document.add(addParagraf(gruppo, fileInput));
		                document.newPage();
		            }
		            document.close();
	        	
	        	
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
	        return document;
	    }


	    private static void getSelectedRotatePage(File fileInput) {
	    	if(fileInput.getName().contains("DATI"))
	    		ROTATE_A3 = true;
	    	else 
	    		ROTATE_A3 = false;
	    }
	    
//	    private static void getSelectedFONT(File fileInput) {
//	    	if(fileInput.getName().contains("VG714_STATLIQ"))
//	    		FONT = new Font(Font.FontFamily.COURIER  , 8, Font.BOLD);
//		    }


		private static Paragraph addParagraf(Gruppo gruppo, File fileInput){
	        Paragraph paragraph = new Paragraph();
	        paragraph.setFont(FONT);
	        if(fileInput.getName().contains("VG714_STATLIQ"))
	        	paragraph.setLeading(8);
	        Phrase frase  = new Phrase();
	        for (int y=0; y<gruppo.getRighe().size();y++){
	            Riga riga = gruppo.getRighe().get(y);
	            frase.add(riga.getLinea()+"\n");
	        }
	        paragraph.add(frase);
	        return paragraph;
	    }
		
	    private static String getSelectedFolderByFile(File file) throws IOException {
	        String fileNameSelected = file.getName().substring(0, 5);
	        String filePdfName = file.getName().toUpperCase().replace(".TXT", ".PDF");
	        String outputResult = "";
	        if(file.getName().contains("VUL01")){
	            outputResult = CrmProperties.getProperty("path.collettive.vgitext.vul01")+fileNameSelected+"/StoricoOutput/"+filePdfName;
	    	}
	        else
	        	outputResult = CrmProperties.getProperty("path.collettive.vgitext")+fileNameSelected+"/StoricoOutput/"+filePdfName;
	        
	        LoggingUtils.info("path VGIText output: "+outputResult);
	        return outputResult;
	    }
}
