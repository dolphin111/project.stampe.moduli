package com.fideuram.iText;

import com.fideuram.factory.ImageLoader;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 03/06/15
 * Time: 14.43
 */
public class PiedinoBn {
    private static Image piedino;

    public void addToDocument(Document document) throws DocumentException, IOException {
        if(null==piedino);
            piedino = ImageLoader.getPiedinoBiancoNero();

        piedino.scalePercent(50);                  //OLDPIEDINO (28f, 30f)
        piedino.setAbsolutePosition(-15f, 45f);    //OLDPIEDINO (25f, 15f) Posizione intermedia piedino

        document.add(piedino);
    }
}
