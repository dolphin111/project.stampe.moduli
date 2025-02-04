package com.fideuram.iText;

import com.fideuram.factory.ImageLoader;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;

import java.io.IOException;

/**
 * User: V801068
 * Date: 01/02/16
 * Time: 16.51
 */
public class PiedinoColore {
    private static Image piedino;

    public void addToDocument(Document document) throws DocumentException, IOException {
        if(null==piedino);
        piedino = ImageLoader.getPiedinoColore();

        piedino.scalePercent(50);                  //OLDPIEDINO (28f, 30f)
        piedino.setAbsolutePosition(-15f, 45f);    //OLDPIEDINO (25f, 15f) Posizione intermedia piedino

        document.add(piedino);
    }

    public void addToCavas(PdfContentByte canvas) throws DocumentException, IOException {
        LoggingUtils.info("Piedino a Colori: addToCavas");
        if(null==piedino);
        piedino = ImageLoader.getPiedinoColore();

        piedino.scalePercent(50);                  //OLDPIEDINO (28f, 30f)
        piedino.setAbsolutePosition(-15f, 45f);    //OLDPIEDINO (25f, 15f) Posizione intermedia piedino

        canvas.addImage(piedino);
    }

    public void addToCavas(PdfContentByte canvas, int colonna, int riga) throws DocumentException, IOException {
        LoggingUtils.info("Piedino a Colori: addToCavas,colonna,riga");
        if(null==piedino);
        piedino = ImageLoader.getPiedinoColore();

        piedino.scalePercent(50);                       //OLDPIEDINO (28f, 30f)
        piedino.setAbsolutePosition(colonna, riga);    //OLDPIEDINO (25f, 15f) Posizione intermedia piedino

        canvas.addImage(piedino);
    }
}
