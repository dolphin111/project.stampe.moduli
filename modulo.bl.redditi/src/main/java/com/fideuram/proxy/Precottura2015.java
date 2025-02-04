package com.fideuram.proxy;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.Cu2015Exception;
import com.fideuram.factory.ImageLoader;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.file.manipolation.pdf.PdfMerge;
import com.fideuram.printer.Cud;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.redditi.anagrafica.SostitutoImposta;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 21/11/14
 * Time: 15.17
 */
public class Precottura2015 extends Cud {
    Cud2015 cud;
    String outputfile;
    PdfReader reader;
    PdfStamper stamper;
    boolean rettificacud;

    public Precottura2015(boolean rettificacud) throws Cu2015Exception {
        try {
            this.rettificacud=rettificacud;
            setDatiStatici();
            this.outputfile =CrmProperties.getProperty("cud.output")+"cud2015.pdf";
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("1202"));
            reader.selectPages("3-6,8-9");
            PdfReader.unethicalreading = true;
            stamper = new PdfStamper(reader, new FileOutputStream(outputfile));
        } catch (DocumentException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("DocumentException",e);
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("IOException",e);
        }
    }

    public void generaPdfTemplate() throws Cu2015Exception {
        LoggingUtils.info("...PRECOTTURA...");
        try {
            //riepilogoCU(); Riepilogo CU
            //quadroCT(); Sarebbe il Quadro CT che però non dobbiamo compilarlo
            pagina1();
            pagina5();
            if(rettificacud){rettifica();}
            stamper.close();
            reader.close();
            PdfMerge.doCopy(outputfile, CrmProperties.getProperty("cud.output")+"CUD2015_precottoparziale.pdf");
            List<InputStream> pdfs = new ArrayList();
            FileInputStream lettera= new  FileInputStream(new File(TemplateFactory.getPathNomeTemplate(!rettificacud?"12020":"120201")));
            //FileInputStream parziale = new  FileInputStream(new File(CrmProperties.getProperty("cud.output")+"cud2015.pdf"));
            FileInputStream parziale = new  FileInputStream(new File(CrmProperties.getProperty("cud.output")+"CUD2015_precottoparziale.pdf"));
            pdfs.add(lettera);
            pdfs.add(parziale);
            if(rettificacud)
                PdfMerge.doMerge(pdfs,new FileOutputStream(new File(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+("CUD2015_rettifica.pdf"))));
            else
                PdfMerge.doMerge(pdfs,new FileOutputStream(new File(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+("CUD2015.pdf"))));
        } catch (DocumentException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("DocumentException",e);
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("IOException",e);
        } catch (com.lowagie.text.DocumentException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("DocumentException",e);
        }

    }



    private void rettifica(){
        for (int i=1; i<6; i++){
            PdfContentByte canvas = stamper.getOverContent(i);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE",12),                        378, 824, 0);
        }
    }


    private void riepilogoCU()throws DocumentException, IOException {
        PdfContentByte canvas = stamper.getOverContent(1);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getCf()),                         120, 656, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getRagioneSociale()),             120, 618, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getTel_fax()),     120, 582, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().geteMail()),       248, 582, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("CBLFBA64L07F205A"),                                    120, 548, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("01"),                                                  338, 548, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("CUBELLI"),                                             120, 512, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("FABIO"),                                               356, 512, 0);
    }

    private void quadroCT()throws DocumentException, IOException {
        PdfContentByte canvas = stamper.getOverContent(2);
        char[] c= cud.getDatoreLavoro().getCf().toCharArray();
        int colonna=105;
        for(int i=0;i<c.length;i++){
            if(i<=6)
                colonna=colonna+14;
            else if(i>6&&i<12)
                colonna=colonna+15;
            else if(i>=12)
                colonna=colonna+14;
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(c[i]+""), colonna, 679, 0);
        }
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getTel_fax()),     120, 642, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().geteMail()),       275, 642, 0);
    }

    private void pagina1()throws DocumentException, IOException {
        PdfContentByte canvas = stamper.getOverContent(1);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getAnnoFiscale()),                                  482, 762, 0);
        //ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("2014"),                                              478, 764, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getProgressivoCertificazione()),                    488, 744, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getCf()),                         122, 691, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getRagioneSociale()),             268, 691, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getComune()),      122, 667, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getProvincia()),   318, 667, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getCap()),         348, 667, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getVia()),         393, 667, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getTel_fax()),     122, 643, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().geteMail()),       268, 643, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getCodAttivita()),                470, 643, 0);

        //Image firma = ImageLoader.getFirmaFrancini();
        //firma.scalePercent(70f, 33f);             //Dimensione firma

        Image firma = ImageLoader.getFirmaCubelli();
        firma.scalePercent(18f, 7f);              //Dimensione firma
        firma.setAbsolutePosition(340f, 363f);    //Posizione  firma
        canvas.addImage(firma);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("28      02     2015"),                                 130, 365, 0);
    }

    private void pagina5(){
        PdfContentByte canvas = stamper.getOverContent(5); //ex Pagina 8
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getCf()),                         122, 681, 0);
    }

    private void setDatiStatici(){
        cud=new Cud2015();
        Recapito r= new Recapito();
        r.setTel_fax("+390635711/+390635714509");
        //r.setTel_fax("+39 0635711");
        r.seteMail("relazioniclienti@fideuramvita.it");
        r.setVia(" VIA ENNIO QUIRINO VISCONTI 80");
        r.setCap("00193");
        r.setComune("ROMA");
        r.setProvincia("RM");
        SostitutoImposta dl = new SostitutoImposta();
        dl.setRagioneSociale("FIDEURAM VITA SPA");
        dl.setCf("10830461009");
        dl.setIndirizzo(r);
        dl.setCodAttivita("651100");
        cud.setDatoreLavoro(dl);

    }

    public static void main(String args[]) throws Cu2015Exception, IOException, DocumentException {
        Precottura2015 precottura2015 = new Precottura2015(false);
        precottura2015.generaPdfTemplate();
        Precottura2015 rettifica2015= new Precottura2015(true);
        rettifica2015.generaPdfTemplate();
    }


}
