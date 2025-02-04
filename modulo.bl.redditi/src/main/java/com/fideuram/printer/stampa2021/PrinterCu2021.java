package com.fideuram.printer.stampa2021;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.printer.Cud;
import com.fideuram.stampe.modello.redditi.d2021.Cud2021;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PrinterCu2021  extends Cud 
{
    protected Cud2021 cud;
    protected PdfReader reader;
    protected PdfStamper stamper;
    
    static String dataFileOutput;

    public PrinterCu2021(Cud2021 cud) throws IOException, DocumentException {
    	
    	/*
    	 * 	GIO::: 
    	 *  per i FIP ho introdotto la variabile 'dataFileOutput' che 
    	 *  		aggiunta al nome file, lo rende univoco
    	 *  
    	 * */
    	String pattern = "dd/MM/yyyy HH:mm:ss.SSS"; // 27/05/2019 16:52:41
		String pattternDataFile = "yyyyMMddHHmmss.SSS";
    	
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		SimpleDateFormat pattternDataFileDateFormat = new SimpleDateFormat(pattternDataFile);

		dataFileOutput = pattternDataFileDateFormat.format(new Date());
    	/*
    	 * 
    	 * */
		
        String fs= CrmProperties.getProperty("cud.output")+"\\2021\\";

        this.cud=cud;
        if(cud.isPrimaDichiarazione())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("120165"));
        else if(cud.isRettifica())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("120166"));

        LoggingUtils.info("Mi preparo alla stampa di " + fs + cud.getPercettoreSomme().getCf() + ".pdf");

        stamper = new PdfStamper(reader, new FileOutputStream(fs+cud.getPercettoreSomme().getCf() + ".pdf"));
    }
}