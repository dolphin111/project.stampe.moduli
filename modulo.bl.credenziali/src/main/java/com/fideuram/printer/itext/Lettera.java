package com.fideuram.printer.itext;

import com.fideuram.iText.PiedinoColore;
import com.fideuram.stampe.modello.sicurezza.AreaRiservata;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.IOException;

/**
 * User: V801068
 * Date: 01/02/16
 * Time: 12.36
 */
public class Lettera extends PaginaBase{
    public void stampa(PdfStamper stamper, AreaRiservata credenziali) throws DocumentException {
        PdfContentByte canvas = stamper.getOverContent(1);
        int riga=730;
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(credenziali.getIndividuo().getTitolo(), 11), 332, riga, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(credenziali.getIndividuo().toString(), 11), 332, riga=riga-15, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(credenziali.getIndividuo().getIndirizzo().getVia().trim(), 11), 332, riga = riga - 15, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(credenziali.getIndividuo().getIndirizzo().getCapLocalProv().trim(),11), 332, riga=riga-15, 0);

        Phrase userid = getPhrase();
        userid.add(getChunk("codice cliente: ",11,true));
        userid.add(getChunk(credenziali.getUserId(),11,false));
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, userid, 300, riga=riga-412, 0);

        Phrase passwd= getPhrase();
        passwd.add(getChunk("password: ",11,true));
        passwd.add(getChunk(credenziali.getPasswd(),11,false));
        ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, passwd, 300, riga=riga-24, 0);
        LoggingUtils.info("OK...DOCUMENTO STAMPATO ORA AZZECCO IL PIEDINO");
        try {
            new PiedinoColore().addToCavas(canvas,0,25);
        } catch (BadElementException e) {
            throw new DocumentException(e);
        } catch (IOException e) {
            throw new DocumentException(e);
        } catch (DocumentException e) {
            throw new DocumentException(e);
        }
    }
}
