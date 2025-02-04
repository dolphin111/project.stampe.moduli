package com.fideuram.printer.stampa2019.sintetico;

import java.util.List;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2019.Cud2019;
import com.fideuram.stampe.modello.redditi.d2019.datiPrevidenziali.DatiPrevidenziali;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;


/**
 * User: V801068
 * Date: 18/01/16
 * Time: 12.12
 */
public class Pag6 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2019 cud, int pag) throws DocumentException {
        canvas = stamper.getOverContent(pag);
        
        int anno = 2019;
        
        System.out.println("***************pagina modello cud: " + pag);
        
        if(cud.isRettifica())
        { 
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }
        
        propagaCF(cud,pag);
        DatiPrevidenziali dp=cud.getDatiPrevidenziali();
        List<String> annotazioni = dp.getAnnotazioni();

        String stringone="";

        for(int i=0;i<annotazioni.size();i++){
            stringone=stringone+annotazioni.get(i)+"\n\n";
        }

        stampaNota(stringone);
    }


    public void stampaNota(String s) throws DocumentException {
        int riga=770;
        float gap =126;
        ColumnText ct = new ColumnText(canvas);
        //ct.setSimpleColumn(getPhrase(s,7), gap, 0, gap + 420, riga, 8, Element.ALIGN_LEFT);
        //esAGERAto ct.setSimpleColumn(getPhrase(s,7), gap, 0, gap + 420, riga, 8, Element.ALIGN_JUSTIFIED_ALL);
        ct.setSimpleColumn(getPhrase(s,7), gap, 0, gap + 420, riga, 8, Element.ALIGN_JUSTIFIED);
        ct.go();
    }
}