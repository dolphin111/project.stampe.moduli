package com.fideuram.factory;

import com.fideuram.config.CrmProperties;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Image;

import java.io.IOException;

/**
 * User: V801068
 * Date: 22/01/15
 * Time: 15.35
 */
public class ImageLoader {
    public static Image getHead() throws BadElementException, IOException {
        return Image.getInstance(CrmProperties.getProperty("stampe.fs.images")+"head.gif");
    }

    public static Image getPiedinoBiancoNero() throws BadElementException, IOException {
        //return Image.getInstance(CrmProperties.getProperty("stampe.fs.images")+"piedino2014.gif");
        //return Image.getInstance(CrmProperties.getProperty("stampe.fs.images")+"piedino2015.jpg");
        return Image.getInstance(CrmProperties.getProperty("stampe.fs.images")+"piedino.png");
    }

    public static Image getPiedinoColore() throws BadElementException, IOException {
        return Image.getInstance(CrmProperties.getProperty("stampe.fs.images")+"piedino.colore.png");
    }


    public static Image getFirmaFrancini() throws BadElementException, IOException {
        return Image.getInstance(CrmProperties.getProperty("stampe.fs.images")+"firmafrance.png");
    }

    public static Image getFirmaCubelli() throws BadElementException, IOException {
        return Image.getInstance(CrmProperties.getProperty("stampe.fs.images")+"cube.gif");
    }
}
