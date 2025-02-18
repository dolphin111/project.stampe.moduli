package com.fideuram.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Created by
 * User: dconte
 * Date: 05/12/12
 * Time: 11.44
 */
public class PdfMerge {

	 public static void main(String[] args) {
	        List<InputStream> list = new ArrayList<InputStream>();
	        try {
	            // Source pdfs
	            list.add(new FileInputStream(new File("f:/1.pdf")));
	            list.add(new FileInputStream(new File("f:/2.pdf")));

	            // Resulting pdf
	            OutputStream out = new FileOutputStream(new File("f:/result.pdf"));

	            doMerge(list, out);

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (DocumentException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    /**
	     * Merge multiple pdf into one pdf
	     * 
	     * @param list
	     *            of pdf input stream
	     * @param outputStream
	     *            output file output stream
	     * @throws DocumentException
	     * @throws IOException
	     */
	    public static void doMerge(List<InputStream> list, OutputStream outputStream)
	            throws DocumentException, IOException {
	        Document document = new Document();
	        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
	        document.open();
	        PdfContentByte cb = writer.getDirectContent();
	        
	        for (InputStream in : list) {
	            PdfReader reader = new PdfReader(in);
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
}
