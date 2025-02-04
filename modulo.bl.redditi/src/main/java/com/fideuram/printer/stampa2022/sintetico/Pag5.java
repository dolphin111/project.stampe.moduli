package com.fideuram.printer.stampa2022.sintetico;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.Familiare;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.FamiliariACarico;
import com.fideuram.stampe.modello.redditi.d2022.Cud2022;
import com.fideuram.stampe.modello.redditi.d2022.datiPrevidenziali.DatiPrevidenziali;
import com.fideuram.stampe.modello.redditi.d2022.redditidiversi.GestioneSeparata;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 14/01/16
 * Time: 12.05
 */
public class Pag5 extends PaginaBase 
{
    public void stampa(PdfStamper stamper, Cud2022 cud, int pag) {
    	
        canvas = stamper.getOverContent(pag);
        
        int anno = 2022;
        
        System.out.println("***************pagina modello cud (anno "+anno+"): " + pag);
        
        if(cud.isRettifica())
        { 
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }
        
        propagaCF(cud,pag);

/*
 * 		COMMENTATO DA GIO IL 19/03/2020
 * 		
        DatiPrevidenziali dp=cud.getDatiPrevidenziali();
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC1()), 124, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC2()), 223, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC3()), 266, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC4()), 298, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC5()), 400, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC6()), 486, 760, 0);
        if (dp.getQ19().isT()){
            //ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 370, 723, 0);
        }else{
            stMesi(dp.getQ19().getC8(),393, 723);
        }

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC9()),  126, 673, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC10()), 242, 673, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC11()), 335, 673, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC12()), 398, 673, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC13()), 416, 673, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC14()), 456, 673, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC15()), 471, 673, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC16()), 485, 673, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC17()), 516, 673, 0);

      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC18()),  128, 639, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC19()),  222, 639, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC20()),  312, 639, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC21()),  398, 639, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC22()),  488, 639, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC23()),  128, 603, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC24()),  222, 603, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC25()),  312, 603, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC26()),  398, 603, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC27()),  488, 603, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC28()),  128, 567, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC29()),  222, 567, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC30()),  312, 567, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC31()),  398, 567, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC32()),  488, 567, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC33()),  128, 531, 0);
      ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC34()),  222, 531, 0);

        
        if (dp.getQ20().isT()){
            //ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 305, 532, 0);
        }else{
            stMesi(dp.getQ20().getC36(),328, 532);
        }
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC37()),  128, 495, 0);
        stMesi(dp.getQ20().getC38(),248, 496);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC39()),  438, 495, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC40()),  128, 460, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC41()),  216, 460, 0);
        stMesi(dp.getQ20().getC42(),328, 460);
        
        //IL 41 DIVENTA 43 FINO AL 50 +2
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC41()),  128, 424, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC42()),  244, 424, 0);
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC43()),  361, 424, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC44()),  476, 424, 0);
        
        if (dp.getQ21().isT()){
           // ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 125, 388, 0);
        }else{
            stMesi(dp.getQ21().getC46(),149, 388);
        }

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC47()),  335, 388, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC48()),  378, 388, 0);
        
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC49()),  128, 350, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC50()),  264, 350, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC52()),  128, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC53()),  233, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC54()),  295, 327, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC55()),  395, 327, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC56()),  128, 303, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC57()),  233, 303, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC58()),  335, 303, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC59()),  395, 303, 0);


        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ23().getC71()),  124, 257, 0);

        char c72[]=dp.getQ23().getC72().toCharArray();
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>0?c72[0]+"":""),    164, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>1?c72[1]+"":""),    176, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>2?c72[2]+"":""),    190, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>3?c72[3]+"":""),    204, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>4?c72[4]+"":""),    220, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>5?c72[5]+"":""),    234, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>6?c72[6]+"":""),    248, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>7?c72[7]+"":""),    262, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>8?c72[8]+"":""),    278, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>9?c72[9]+"":""),    292, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>10?c72[10]+"":""),  306, 257, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ23().getC73()),  336, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ23().getC74()),  408, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ23().getC75()),  476, 257, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ23().getC76()),  545, 257, 0);
 */

        GestioneSeparata g=cud.getGestioneSeparata();
        //prima riga
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC801()), 136, 112, 0);	//2021	-	Indennità, acconti, anticipazioni e somme erogate nell'anno
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC802()), 222, 112, 0);	//2021	-	Acconti ed anticipazioni erogate anni prec.
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC803()), 308, 112, 0);	//2021	-	Detrazione
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC804()), 394, 112, 0);	//2021	-	Ritenuta netta operata nell'anno
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC805()), 480, 112, 0);	//2021	-	Ritenute sspese
        //seconda riga
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC806()), 136, 89, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC807()), 222, 89, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC808()), 308, 89, 0);	//2021	-	Quota spettante per le indennità erogate ai sensi dell'art.2122 c.c.
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC809()), 394, 89, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC810()), 480, 89, 0);
        //terza riga
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC811()), 136, 148, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC812()), 222, 148, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC813()), 308, 148, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(g.getQ24().getC920()), 394, 148, 0);

    }


/*    COMMENTATO DA GIO IL 19/03/2020
 * 
 * private void stMesi(char[] c,  int colonna, int riga){
        
        for(int i=0;c != null && i<c.length;i++){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c[i]+""), colonna, riga, 0);
            colonna=colonna+14;
        }
    }*/
    
}