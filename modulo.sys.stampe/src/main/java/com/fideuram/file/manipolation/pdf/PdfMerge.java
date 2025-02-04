package com.fideuram.file.manipolation.pdf;


import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfWriter;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 21/01/15
 * Time: 18.24
 * To change this template use File | Settings | File Templates.
 */
public class PdfMerge {


    public static void doCopy(String origine, String destinazione) throws IOException, DocumentException {
        List<InputStream> list = new ArrayList<InputStream>();
        FileInputStream is1 = new  FileInputStream(new File(origine));
        FileInputStream is2 = new  FileInputStream(new File(origine));
        OutputStream out = new FileOutputStream(new File(destinazione));
        list.add(is1);
        list.add(is2);
        doMerge(list,out);
    }

    public static void doMerge(List<InputStream> list, OutputStream outputStream)
            throws DocumentException, IOException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
        document.open();
        PdfContentByte cb = writer.getDirectContent();

        for (InputStream in : list) {
            PdfReader reader = new PdfReader(in);
            
            // ticket CRM 15544983: fix errore "PdfReader not opened with owner password"
            try {
            	if(reader.isEncrypted()) {
            		Field f = reader.getClass().getDeclaredField("encrypted");
    				f.setAccessible(true);
    				f.set(reader, false);
            	}
			} catch (NoSuchFieldException e) {
				throw new DocumentException(e);
			} catch (IllegalAccessException e) {
				throw new DocumentException(e);
			}
            
            for (int i = 1; i <= reader.getNumberOfPages(); i++) {
                document.newPage();
                //import the page from source pdf
                PdfImportedPage page = writer.getImportedPage(reader, i);
                //add the page to the destination pdf
                cb.addTemplate(page, 0, 0);
            }
        }

        outputStream.flush();
        document.close();
        outputStream.close();
    }

    public static void main(String args[]) throws IOException, DocumentException {
        PdfMerge.doCopy("C:\\Users\\v801068\\Dropbox\\Public\\Fideuram\\TEMP\\Cud\\Output\\cud2015.pdf","C:\\Users\\v801068\\Dropbox\\Public\\Fideuram\\TEMP\\Cud\\Output\\CNNMLG41P15B910H.pdf");
    }
}


