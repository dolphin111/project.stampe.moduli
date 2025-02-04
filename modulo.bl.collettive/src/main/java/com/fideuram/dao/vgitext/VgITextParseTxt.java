package com.fideuram.dao.vgitext;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.manager.vgitext.VGITextManager;
import com.fideuram.modello.vgitext.Collettiva;
import com.fideuram.modello.vgitext.Gruppo;
import com.fideuram.modello.vgitext.Parser;
import com.fideuram.modello.vgitext.Riga;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;

public class VgITextParseTxt {

 
    public static Collettiva getCollettivaIText(String filePathInput) throws CollettiveFileDataReadException, IOException {
        Collettiva collettiva = new Collettiva();
        BufferedReader br = new BufferedReader(new FileReader(filePathInput));
        try{
        String line = "";
        int lineNum = 0;

        Gruppo gruppo = new Gruppo();
        while ((line = br.readLine()) != null) {

            Riga riga = new Riga();
            lineNum++;
            //LoggingUtils.debug("posizione Linea del file #" + line);
            if(line.trim().equals("$$$$$")){
                collettiva.getGruppi().add(gruppo);
                gruppo = new Gruppo();
            }else{
                String linea = line;
                riga.setLinea(linea);
                gruppo.getRighe().add(riga);
            	}

        	}
        	collettiva.getGruppi().add(gruppo);
        }
        catch(Exception e) {
        	LoggingUtils.error("Parse Error: " + e.getMessage());
        	br.close();
       		return null;
        }
        br.close();
        return collettiva;
    }

}
