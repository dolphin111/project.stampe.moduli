package com.fideuram.printer.stampa2015;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.fideuram.stampe.modello.redditi.d2015.datiprevidenziali.DatiPrevidenziali;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

import java.util.List;

/**
 * User: V801068
 * Date: 26/01/15
 * Time: 17.28
 */
public class Pag4 extends PaginaBase {
    public void stampa(PdfStamper stamper, Cud2015 cud, int pag) throws DocumentException {
        canvas = stamper.getOverContent(pag);
        propagaCF(cud,pag);
        DatiPrevidenziali dp=cud.getDatiPrevidenziali();
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC1()), 124, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC2()), 223, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC3()), 260, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC4()), 296, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC5()), 396, 760, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ22().getC6()), 483, 760, 0);
        if (dp.getQ23().isT()){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 370, 726, 0);
        }else{
            stMesi(dp.getQ23().getC8(),726);
        }

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ24().getC9()),  124, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ24().getC10()), 232, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ24().getC11()), 338, 688, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ24().getC12()), 446, 688, 0);
        if (dp.getQ24().isT()){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 370, 654, 0);
        }else{
            stMesi(dp.getQ24().getC14(),654);
        }

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC15()),  124, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC16()),  244, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC17()),  344, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC18()),  412, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC19()),  428, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC20()),  470, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC21()),  486, 616, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC22()),  514, 616, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC23()),  124, 582, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC24()),  214, 582, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC25()),  302, 582, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC26()),  394, 582, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC27()),  484, 582, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC28()),  124, 546, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC29()),  214, 546, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC30()),  302, 546, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC31()),  394, 546, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ25().getC32()),  484, 546, 0);
        if (dp.getQ25().isT()){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("X"), 370, 510, 0);
        }else{
            stMesi(dp.getQ25().getC34(),510);
        }

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ26().getC35()),  124, 474, 0);

        char c36[]=dp.getQ26().getC36().toCharArray();
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>0?c36[0]+"":""),    164, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>1?c36[1]+"":""),    176, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>2?c36[2]+"":""),    190, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>3?c36[3]+"":""),    204, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>4?c36[4]+"":""),    220, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>5?c36[5]+"":""),    234, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>6?c36[6]+"":""),    248, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>7?c36[7]+"":""),    262, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>8?c36[8]+"":""),    278, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>9?c36[9]+"":""),    292, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c36.length>10?c36[10]+"":""),  306, 474, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ26().getC37()),  336, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ26().getC38()),  408, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ26().getC39()),  474, 474, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(dp.getQ26().getC40()),  545, 474, 0);
        List<String> annotazioni = dp.getAnnotazioni();

        String stringone="";

        for(int i=0;i<annotazioni.size();i++){
            stringone=stringone+annotazioni.get(i)+"\n\n";
        }

        stampaNota(stringone);


      /*  int riga=444;
        for(int i=0;i<annotazioni.size();i++){
            String annotazione=annotazioni.get(i);
            if(annotazione.length()<120){
                ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(annotazione,7),   124, riga, 0);
            }else{
                String[] ss=splitNota(annotazione);
                for(int y=0;y<ss.length;y++){
                    ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(ss[y],7),   124, riga, 0);
                    riga=riga-8;
                }
            }

            riga=riga-8;
        }
*/

    }

    private void stMesi(char[] c, int riga){
        int colonna=393;
        for(int i=0;i<c.length;i++){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(c[i]+""), colonna, riga, 0);
            colonna=colonna+14;
        }
    }

    /*public String[]  splitNota(String nota){
         int element= nota.length()/120+1;
         String s[]=new String [element];
         int da=0;
         int a=120 ;
         for(int i=0;i<element;i++){
             if(i>0){
                 da=a;
                 a= da+120;
             }
             s[i]=nota.substring(da,a<=nota.length()?a:nota.length());
             if(i<element&&s[i].substring(s[i].length()-1).matches("[a-zA-Z]")){
                 s[i]=s[i]+"-";
             }

         }
         return s;
    }*/


    public void stampaNota(String s) throws DocumentException {
        int riga=460;
        float gap =126;
        ColumnText ct = new ColumnText(canvas);
        //ct.setSimpleColumn(getPhrase(s,7), gap, 0, gap + 420, riga, 8, Element.ALIGN_LEFT);
        //esAGERAto ct.setSimpleColumn(getPhrase(s,7), gap, 0, gap + 420, riga, 8, Element.ALIGN_JUSTIFIED_ALL);
        ct.setSimpleColumn(getPhrase(s,7), gap, 0, gap + 420, riga, 8, Element.ALIGN_JUSTIFIED);
        ct.go();
    }
}
