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
 * Time: 16.45
 */
public class Head {
    public static Image header;
    public void addToDocument(Document document) throws DocumentException, IOException {
        if(null==header);
             header = ImageLoader.getHead();
        header.scalePercent(32,32);                 // 2014  (25,23)
        header.setAbsolutePosition(-10f, 770f);
        document.add(header);
    }
}
