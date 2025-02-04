package com.fideuram.file.manipolation.pdf;

import com.fideuram.utils.Streamer;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfEncryptor;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.Properties;
/**
 * Created by
 *
 * User: logan
 * Date: 06/07/12
 * Time: 14.04
 */
public class PdfPasswords {
	

    private static String USER_PASS;

    private static String OWNER_PASS;


    public static void main(String[] args) {
        try {
            new   PdfPasswords().setPass("/tmp/prova.pdf");



        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    public byte[] setPass(String fileInput) throws IOException, DocumentException, KeyStoreException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {
    	Properties prop = new Properties();
    	ClassLoader loader =  PdfPasswords.class.getClassLoader();           
    	InputStream stream = loader.getResourceAsStream("externalized.properties");
    	prop.load(stream);
    	USER_PASS = prop.getProperty("userPass");
    	OWNER_PASS = prop.getProperty("ownerPass");
        PdfReader reader = new PdfReader(fileInput);
        PdfEncryptor.encrypt(reader,new FileOutputStream(fileInput+"_locked.pdf"),USER_PASS.getBytes(),OWNER_PASS.getBytes(),PdfWriter.AllowAssembly | PdfWriter.AllowCopy
                | PdfWriter.AllowDegradedPrinting | PdfWriter.AllowFillIn
                | PdfWriter.AllowModifyAnnotations | PdfWriter.AllowModifyContents
                | PdfWriter.AllowPrinting | PdfWriter.AllowScreenReaders, false);
        return  Streamer.getFile(fileInput+"_locked.pdf");
    }


    public void newPassNewPdf() throws Exception {
    	
    	Properties prop = new Properties();
    	ClassLoader loader =  PdfPasswords.class.getClassLoader();           
    	InputStream stream = loader.getResourceAsStream("externalized.properties");
    	prop.load(stream);    	
//        OutputStream file = new FileOutputStream(new File("/tmp/Test.pdf"));
    	OutputStream file = new FileOutputStream(prop.getProperty("fileTestPdf"));
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, file);
        writer.setEncryption(USER_PASS.getBytes(), OWNER_PASS.getBytes(),
                PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
        document.open();
        document.add(new Paragraph("Passord Azzeccata, "));
        document.add(new Paragraph(new Date().toString()));
        document.close();
        file.close();
    }
    
    
    public void unlock() throws Exception{
    	
    	Properties prop = new Properties();
    	ClassLoader loader =  PdfPasswords.class.getClassLoader();           
    	InputStream stream = loader.getResourceAsStream("externalized.properties");
    	prop.load(stream);    	

    	
        String lockedFile = prop.getProperty("lockedFile");        // Locked pdf filename
        String lockedpassword = prop.getProperty("lockedpassword");           // Locked pdf password
        String unlockedFile = prop.getProperty("unlockedFile");     // Filename of the new unlocked pdf
        
        PdfReader reader = new PdfReader(lockedFile, lockedpassword.getBytes());
        System.out.println("Unlocking...");

        PdfEncryptor.encrypt(reader, new FileOutputStream("unlocked.pdf"), null,
                null, PdfWriter.AllowAssembly | PdfWriter.AllowCopy
                | PdfWriter.AllowDegradedPrinting | PdfWriter.AllowFillIn
                | PdfWriter.AllowModifyAnnotations | PdfWriter.AllowModifyContents
                | PdfWriter.AllowPrinting | PdfWriter.AllowScreenReaders, false);

        System.out.println("PDF Unlocked!"); 
    }
}
