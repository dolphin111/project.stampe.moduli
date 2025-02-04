package com.fideuram.printer.conguaglio;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.d2015.Cud2015;
import com.fideuram.stampe.modello.rendita.Prestazione;
import com.fideuram.stampe.modello.utils.FormattatoreDate;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

import java.util.Date;


public class LetteraCredito extends PaginaBase {
    @Override
    public void stampa(PdfStamper stamper, Prestazione prestazione, int pag) {
        PdfContentByte canvas = stamper.getOverContent(pag);
        int riga=670;

        String  dataLettera="Roma, " + FormattatoreDate.formatDate(new Date(), FormattatoreDate.FORMATO_DATA_ITALIANA);

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(dataLettera,11), 380, riga, 0);

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(UppercaseFirstLetters(prestazione.getIntestazione().trim()),11), 380, riga=riga-40, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(UppercaseFirstLetters(prestazione.getNominativo().trim()),11), 380, riga=riga-12, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(UppercaseFirstLetters(prestazione.getIndirizzo().trim()),11), 380, riga=riga-11, 0);

        String localitaCompleta=prestazione.getCap().trim() + " " + prestazione.getLocalita().trim() + " " + prestazione.getProvincia().trim();
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(UppercaseFirstLetters(localitaCompleta),11), 380, riga=riga-11, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,  getPhraseBold(prestazione.getNumeroPolizze(), 11), 285, riga=riga-51, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,  getPhraseBold(prestazione.getBeneficiario(), 11), 155, riga=riga-13, 0);

        //Dati del Pagamento
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,  getPhraseBold(prestazione.getDataVersamento(), 11),191, riga=riga-126, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,  getPhraseBold(prestazione.getCodiceIban(), 11),135, riga=riga-26, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,  getPhraseBold(prestazione.getPagamentoIntestato().toUpperCase(), 11), 135, riga=riga-12, 0);


        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(prestazione.getImportoDiConguaglio()+ " a titolo di rimborso ritenute di acconto non dovuto.",11), 114, riga=riga-38, 0);
    }



}
