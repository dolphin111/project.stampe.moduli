package com.fideuram.printer.stampa2016.ordinario;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.fideuram.stampe.modello.redditi.d2016.annotazioni.Annotazioni;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 21/01/16
 * Time: 12.06
 */
public class Pag9 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2016 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        propagaCF(cud,pag);
        Annotazioni annotazioni=cud.getAnnotazioni();
        if (annotazioni.hasAnnotazioni()){
            stNote(annotazioni.getAnnotazioni(),774);
        }
    }


    private void stNote(String[] c, int riga){
        int colonna=148;
        for(int i=0;i<19;i++){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c[i]+"",8), colonna, riga, 0);
            if(i==5||i==10||i==15)
                colonna=colonna+3;
            colonna=colonna+21;
        }
        riga=750;
        colonna=128;
        for(int i=19;i<39;i++){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c[i]+"",8), colonna, riga, 0);
            if(i==25||i==30||i==35)
                colonna=colonna+3;
            colonna=colonna+21;
        }
        riga=726;
        colonna=128;
        for(int i=39;i<43;i++){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c[i]+"",8), colonna, riga, 0);
            colonna=colonna+21;
        }
    }
}
