package com.fideuram.printer.stampa2023;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.printer.Cud;
import com.fideuram.stampe.modello.redditi.d2023.Cud2023;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import com.fideuram.stampe.modello.redditi.CudBase;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PrinterCu2023  extends Cud
{
    protected Cud2023 cud;
    protected PdfReader reader;
    protected PdfStamper stamper;

    static String dataFileOutput;

    public PrinterCu2023(Cud2023 cud) throws IOException, DocumentException {

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

        String fs= CrmProperties.getProperty("cud.output")+"\\2023\\";

        this.cud=cud;
        if(cud.isPrimaDichiarazione())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("120165"));
        else if(cud.isSostituzione())
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("120166"));

		// Aprile 2023 (Engineering)
		else if (cud.isAnnullamento()) {
			reader = new PdfReader(TemplateFactory.getPathNomeTemplate(CudBase.CHIAVE_NOME_FILE_MODELLO_ANNULLAMENTO));
		}

        LoggingUtils.info("Mi preparo alla stampa di " + fs + cud.getPercettoreSomme().getCf() + ".pdf");

        stamper = new PdfStamper(reader, new FileOutputStream(fs+cud.getPercettoreSomme().getCf() + ".pdf"));
    }
}