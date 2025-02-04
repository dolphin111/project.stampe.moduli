package com.fideuram.proxy;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.Cu2015Exception;
import com.fideuram.factory.ImageLoader;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.file.manipolation.pdf.PdfMerge;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.redditi.anagrafica.SostitutoImposta;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
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
 * Date: 02/03/16
 * Time: 18.46
 */
public class PrecotturaSintetico2016 extends Precottura {
    Cud2016 cud;

    public PrecotturaSintetico2016(boolean rettificacud) throws Cu2015Exception {
        try {
            this.rettificacud=rettificacud;
            setDatiStatici();
            this.outputfile = CrmProperties.getProperty("cud.output")+"cud2016Sintetico.pdf";
            reader = new PdfReader(TemplateFactory.getPathNomeTemplate("12016S"));
            reader.selectPages("1-7");
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

    private void setDatiStatici(){
        cud=new Cud2016();
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

    public void generaPdfTemplate() throws Cu2015Exception {
        LoggingUtils.info("...PRECOTTURA...");
        try {

            pagina1();
            //pagina5();     Ex pagina 5%1000 che al momento della bozza non c'è
            if(rettificacud){rettifica();}
            stamper.close();
            reader.close();
            PdfMerge.doCopy(outputfile, CrmProperties.getProperty("cud.output") + "CUD2016_precottoparziale.pdf");
            List<InputStream> pdfs = new ArrayList();
            FileInputStream lettera= new  FileInputStream(new File(TemplateFactory.getPathNomeTemplate(!rettificacud?"120160":"1201601")));
            //FileInputStream parziale = new  FileInputStream(new File(CrmProperties.getProperty("cud.output")+"cud2015.pdf"));
            FileInputStream parziale = new  FileInputStream(new File(CrmProperties.getProperty("cud.output")+"CUD2016_precottoparziale.pdf"));
            pdfs.add(lettera);
            pdfs.add(parziale);
            if(rettificacud)
                PdfMerge.doMerge(pdfs,new FileOutputStream(new File(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+("cud2016/CUD2016_rettifica_Sintetico.pdf"))));
            else
                PdfMerge.doMerge(pdfs,new FileOutputStream(new File(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+("cud2016/CUD2016_Sintetico.pdf"))));
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
            ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 378, 824, 0);
        }
    }

    private void pagina1()throws DocumentException, IOException {
        PdfContentByte canvas = stamper.getOverContent(1);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getAnnoFiscale()), 482, 762, 0);
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
        Image firma = ImageLoader.getFirmaCubelli();
        firma.scalePercent(18f, 7f);              //Dimensione firma
        firma.setAbsolutePosition(340f, 363f);    //Posizione  firma
        canvas.addImage(firma);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("28      02     2016"),                                 130, 365, 0);
    }

    /*private void pagina5(){
        PdfContentByte canvas = stamper.getOverContent(5); //ex Pagina 8
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getCf()),                         122, 681, 0);
    }*/

    public static void main(String args[]) throws Cu2015Exception, IOException, DocumentException {
        PrecotturaSintetico2016 precottura2016 = new PrecotturaSintetico2016(false);
        precottura2016.generaPdfTemplate();
        PrecotturaSintetico2016 rettifica2016= new PrecotturaSintetico2016(true);
        rettifica2016.generaPdfTemplate();
    }
}
