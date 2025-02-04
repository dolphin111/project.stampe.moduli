package com.fideuram.printer.itext;

import com.fideuram.factory.TemplateFactory;
import com.fideuram.file.TempDir;
import com.fideuram.stampe.modello.sicurezza.AreaRiservata;
import com.fideuram.utils.Streamer;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * User: V801068
 * Date: 01/02/16
 * Time: 12.28
 */
public class PrinterCredenziali{
    AreaRiservata credenziali;
    PdfReader reader;
    PdfStamper stamper;
    String percorsoOut;

    public PrinterCredenziali(AreaRiservata credenziali,int azione) throws IOException, DocumentException {
        super();  //carico il percorso temporaneo
        percorsoOut= TempDir.getTmpDir();
        this.credenziali=credenziali;
        reader = new PdfReader(TemplateFactory.getPathNomeTemplate(""+azione));
        stamper = new PdfStamper(reader, new FileOutputStream(percorsoOut+credenziali.getIndividuo()+".pdf"));
    }

    public byte[] start() throws IOException, DocumentException {
        new Lettera().stampa(stamper, credenziali);
        stamper.close();
        reader.close();
        return Streamer.getFile(percorsoOut+credenziali.getIndividuo()+".pdf");

    }
}
