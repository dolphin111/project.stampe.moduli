package com.fideuram.utils.pdf;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.ImageLoader;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.Streamer;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

/**
 * Created with
 * User: logan
 * Date: 12/06/13
 * Time: 14.57
 */
public class ImageAppender {
    public static byte[] apppendPiedinoToLastPage(byte[] pdf,String path, String titolo, boolean isColor)throws IOException, DocumentException{
        PdfReader pdfReader= new PdfReader(pdf);

        String nome;
        if(null==titolo)
             nome="prospetto.pdf";
        else
             nome=titolo;

        LoggingUtils.info("APPEND TO :"+path+nome);
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(path+nome));
        PdfContentByte content = pdfStamper.getUnderContent(pdfReader.getNumberOfPages());
        //Image piedino = Image.getInstance(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+"piedino.jpg");
        Image piedino =isColor ? ImageLoader.getPiedinoColore() : ImageLoader.getPiedinoBiancoNero();
        //piedino.scalePercent(28f, 40f);
        //--piedino.scalePercent(42f, 40f);
        piedino.scalePercent(50);
        //piedino.setAbsolutePosition(50f, 70f);    //posizione originale
        //piedino.setAbsolutePosition(25f, 45f);    //Posizione intermedia piedino
        //piedino.setAbsolutePosition(25f, 30f);    //Posizionamento del piedino molto in basso -  si sovrappone al numero pagina
        piedino.setAbsolutePosition(-15f, 45f);    //Posizione intermedia piedino

        content.addImage(piedino);
        pdfStamper.close();
        return Streamer.getFile(path+nome);
    }



    public static byte[] apppendPiedinoToLastPage(byte[] pdf)throws IOException, DocumentException{
        String path= CrmProperties.getProperty("crm.services.temp.path");
        return ImageAppender.apppendPiedinoToLastPage(pdf,path,null, false);
    }

    public static byte[] apppendPiedinoToLastPage(String pdf, String jpg)throws IOException, DocumentException{
        String path=CrmProperties.getProperty("crm.services.temp.path");
        String nome=new Date().toString()+".pdf";
        PdfReader pdfReader = new PdfReader("pdf");
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(path+nome));
        Image image = Image.getInstance("jpg");
        PdfContentByte content = pdfStamper.getUnderContent(pdfReader.getNumberOfPages());
        image.setAbsolutePosition(100f, 100f);
        content.addImage(image);
        pdfStamper.close();
        pdfStamper.close();
        return Streamer.getFile(path+nome);
    }

    public byte[] apppendImmageToEveryPage(String pdf, String jpg)throws IOException, DocumentException{
        String path=CrmProperties.getProperty("crm.services.temp.path");
        String nome=new Date().toString()+".pdf";

        PdfReader pdfReader = new PdfReader("pdf");
        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(path+nome));

        Image image = Image.getInstance("jpg");
        for(int i=1; i<= pdfReader.getNumberOfPages(); i++){
            PdfContentByte content = pdfStamper.getUnderContent(i);
            image.setAbsolutePosition(100f, 700f);
            content.addImage(image);
        }
        pdfStamper.close();
        return Streamer.getFile(path+nome);
    }



    public static void main(String args[]) throws IOException, DocumentException {
        PdfReader pdfReader = new PdfReader("/tmp/prova.pdf");

        PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("/tmp/Stamped.pdf"));



        PdfContentByte content = pdfStamper.getUnderContent(pdfReader.getNumberOfPages());
        //image.scalePercent(80f);

        //image.scalePercent(62f);
        Image piedino = Image.getInstance("/tmp/piedino.png");
        piedino.scaleToFit(600f, 600f);
        piedino.setAbsolutePosition(5f, 50f);
        content.addImage(piedino);

        Image sfondo = Image.getInstance("/tmp/riempimento.png");
        sfondo.setAbsolutePosition(50f, 150f);
        content.addImage(sfondo);

        pdfStamper.close();


    }
}
