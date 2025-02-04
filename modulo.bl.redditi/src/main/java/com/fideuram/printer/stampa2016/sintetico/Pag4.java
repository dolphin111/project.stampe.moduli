package com.fideuram.printer.stampa2016.sintetico;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.fideuram.stampe.modello.redditi.d2016.datiprevidenziali.DatiPrevidenziali;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfStamper;

/**
 * User: V801068
 * Date: 14/01/16
 * Time: 12.05
 */
public class Pag4 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2016 cud, int pag) {
        canvas = stamper.getOverContent(pag);
        propagaCF(cud,pag);
        DatiPrevidenziali dp=cud.getDatiPrevidenziali();
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC1()), 124, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC2()), 223, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC3()), 266, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC4()), 298, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC5()), 400, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ19().getC6()), 486, 760, 0);
        if (dp.getQ19().isT()){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 370, 726, 0);
        }else{
            stMesi(dp.getQ19().getC8(),726);
        }

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC9()),  126, 699, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC10()), 242, 699, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC11()), 358, 699, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ20().getC12()), 474, 699, 0);
        if (dp.getQ20().isT()){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 370, 664, 0);
        }else{
            stMesi(dp.getQ20().getC14(),654);
        }

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC15()),  128, 626, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC16()),  244, 626, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC17()),  334, 626, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC18()),  406, 626, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC19()),  422, 626, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC20()),  464, 626, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC21()),  480, 626, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC22()),  516, 626, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC23()),  128, 604, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC24()),  222, 604, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC25()),  312, 604, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC26()),  398, 604, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC27()),  488, 604, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC28()),  128, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC29()),  222, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC30()),  312, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC31()),  398, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ21().getC32()),  488, 580, 0);
        if (dp.getQ21().isT()){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 370, 544, 0);
        }else{
            stMesi(dp.getQ21().getC34(),544);
        }

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC49()),  128, 520, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC50()),  264, 520, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC51()),  128, 496, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC52()),  178, 496, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC53()),  278, 496, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC54()),  340, 496, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC55()),  440, 496, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC56()),  128, 472, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC57()),  228, 472, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC58()),  332, 472, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC59()),  390, 472, 0);






        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ23().getC71()),  124, 438, 0);

        char c72[]=dp.getQ23().getC72().toCharArray();
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>0?c72[0]+"":""),    164, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>1?c72[1]+"":""),    176, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>2?c72[2]+"":""),    190, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>3?c72[3]+"":""),    204, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>4?c72[4]+"":""),    220, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>5?c72[5]+"":""),    234, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>6?c72[6]+"":""),    248, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>7?c72[7]+"":""),    262, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>8?c72[8]+"":""),    278, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>9?c72[9]+"":""),    292, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c72.length>10?c72[10]+"":""),  306, 438, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ23().getC73()),  336, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ23().getC74()),  408, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ23().getC75()),  476, 438, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ23().getC76()),  545, 438, 0);
    }


    private void stMesi(char[] c, int riga){
        int colonna=393;
        for(int i=0;i<c.length;i++){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c[i]+""), colonna, riga, 0);
            colonna=colonna+14;
        }
    }
}
