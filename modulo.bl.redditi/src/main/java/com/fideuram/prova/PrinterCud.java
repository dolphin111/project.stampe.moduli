package com.fideuram.prova;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.Familiare;
import com.fideuram.stampe.modello.redditi.anagrafica.familiari.FamiliariACarico;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import fr.opensagres.xdocreport.core.XDocReportException;

import java.io.*;
import java.util.Date;

/**
 * User: v801068
 * Date: 27/10/14
 * Time: 12.56
 */
@Deprecated
public class PrinterCud {

    public void printPdf(Cud2015 cud) throws IOException, DocumentException {
        Font f1=FontFactory.getFont(FontFactory.TIMES_ROMAN,10);

        PdfReader reader = new PdfReader(TemplateFactory.getPathNomeTemplate("1202"));
        PdfReader.unethicalreading = true;
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(CrmProperties.getProperty("crm.services.temp.path")+cud+"_"+new Date().getTime()+".pdf"));
        PdfContentByte canvas = stamper.getOverContent(1); //Pagina 1

        stampaSostitutoImposta(canvas,cud);
        stampaPercettoreSomme(canvas, cud);

        canvas = stamper.getOverContent(2); //Pagina 2

        stamper.close();
        //reader.close();
    }

    private Phrase getPhrase(Integer i){
         return this.getPhrase(i+"");
    }

    private Phrase getPhrase(String s){
        Font f1=FontFactory.getFont(FontFactory.TIMES_ROMAN,9);
        return new Phrase(s,f1);
    }



    private void stampaSostitutoImposta(PdfContentByte canvas,Cud2015 cud){
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getAnnoFiscale()), 478, 764, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getProgressivoCertificazione()), 488, 744, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getCf()), 122, 716, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getRagioneSociale()), 270, 716, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getComune()), 122, 692, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getProvincia()), 318, 692, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getCap()), 348, 692, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getVia()), 392, 692, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().getTel_fax()), 122, 668, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getIndirizzo().geteMail()), 270, 668, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getDatoreLavoro().getCodAttivita()), 470, 668, 0);
    }

    private void stampaPercettoreSomme(PdfContentByte canvas,Cud2015 cud){
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getCf()),                                       122, 642, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getCognome()),                                  270, 642, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getNome()),                                     450, 642, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getSesso()),                                    122, 605, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getDataNascita()),                              152, 605, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getComuneNascita()),                            230, 605, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getProvinciaNascita()),                         360, 605, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getCategorieParticolari()),                     515, 605, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getEventiEccezionali()),                        545, 605, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getComune()),             122, 570, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getProvincia()),          475, 570, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getCodiceComune()),       525, 570, 0);

        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getDfAttuale().getComune()),                    122, 535, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getDfAttuale().getProvincia()),                 475, 535, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getDfAttuale().getCodiceComune()),              525, 535, 0);

        if(null!=cud.getPercettoreSomme().getRappresentante())
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getRappresentante().getCf().toUpperCase()),     122, 510, 0);
        if(null!=cud.getPercettoreSomme().getFamiliariACarico())
            stampaFamiliariACarico(canvas,cud.getPercettoreSomme().getFamiliariACarico());
    }

    private void stampaFamiliariACarico(PdfContentByte canvas,FamiliariACarico familiariACarico){
        if(null!=familiariACarico.getConiuge()){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getConiuge().getCf().toUpperCase()),           255, 473, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getConiuge().getNumeroMesiACarico()),          435, 473, 0);
        } if (null!=familiariACarico.getPrimoFiglio()){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getCf().toUpperCase()),       255, 460, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getNumeroMesiACarico()),      435, 460, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getMinoreAnni3()),            470, 460, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getDetrazPercSpettante()),    505, 460, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(familiariACarico.getPrimoFiglio().getDetrazTotaleAffidamento()),540, 460, 0);
        }
        int riga=447;
        for(int i=0;i<familiariACarico.getAltri().size();i++){
            Familiare f= familiariACarico.getAltri().get(i);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.isFiglio()),                  126, riga, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.isAltroFamiliare()),          163, riga, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.isDisabile()),                202, riga, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.getCf().toUpperCase()),       255, riga, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.getNumeroMesiACarico()),      435, riga, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.getMinoreAnni3()),            470, riga, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.getDetrazPercSpettante()),    505, riga, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(f.getDetrazTotaleAffidamento()),540, riga, 0);
            riga=riga-12;
        }
    }

    public static void main(String args[]) throws TemplateLoaderExcepion, XDocReportException, IOException, DocumentException {
        new PrinterCud().printPdf(Cud2015Mock.getMock());
    }
}
