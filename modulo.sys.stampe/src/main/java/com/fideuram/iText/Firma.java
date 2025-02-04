package com.fideuram.iText;

import com.fideuram.factory.ImageLoader;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;

import java.io.IOException;

/**
 * User: V801068
 * Date: 25/06/15
 * Time: 12.16
 */
public class Firma {
    private static Image firma;

    public void addToDocument(Document document) throws DocumentException, IOException {
        if(null==firma);
        //piedino = Image.getInstance(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+"piedino.jpg");
        firma = ImageLoader.getFirmaFrancini();
        //firma.scalePercent(28f, 30f);
        //firma.setAbsolutePosition(25f, 15f);    //Posizione intermedia piedino
        document.add(firma);
    }

    public Image getFirma() throws IOException, BadElementException {
        return firma!=null?firma:ImageLoader.getFirmaFrancini();
    }
}
