package com.fideuram.xdocreport;

import com.fideuram.config.CrmProperties;
import com.fideuram.utils.LoggingUtils;
import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
import org.odftoolkit.odfdom.doc.OdfTextDocument;
//import org.odftoolkit.odfdom.converter.pdf.PdfConverter;
//import org.odftoolkit.odfdom.converter.pdf.PdfOptions;
//import org.odftoolkit.odfdom.doc.OdfTextDocument;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 28/02/14
 * Time: 10.02
 */
public class Odt2PdfConverter {
    public static void stampaPdf(String odt, String pdf){
        LoggingUtils.info("pdf start");
        try {
            InputStream in= new FileInputStream(new File(odt));
            OdfTextDocument document = OdfTextDocument.loadDocument(in);
            // 2) Prepare Pdf options
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File(pdf));
            PdfConverter.getInstance().convert(document, out, options);
            LoggingUtils.info("end");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stampaPdf(byte[] odt, String pdf){
        LoggingUtils.info("pdf start");
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(odt);
            OdfTextDocument document = OdfTextDocument.loadDocument(in);
            PdfOptions options = PdfOptions.create();
            OutputStream out = new FileOutputStream(new File(pdf));
            PdfConverter.getInstance().convert(document, out, options);
            LoggingUtils.info("end");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws FileNotFoundException {
        InputStream in= new FileInputStream(new File("C:\\Stampe\\out\\tmp\\Test.odt"));
    }
}
