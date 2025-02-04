package com.fideuram.printer.stampa2020;



import java.io.IOException;
import java.net.MalformedURLException;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.anagrafica.ResidenzaEstero;
import com.fideuram.stampe.modello.redditi.d2020.Cud2020;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;
import com.lowagie.text.BadElementException;
//import com.lowagie.text.Image;

/**
 * User: V801068
 * Date: 08/01/16
 * Time: 10.50
 */
public class Pag1 extends PaginaBase {
	
    public void stampa(PdfStamper stamper,Cud2020 cud,int pag){
    	
        canvas = stamper.getOverContent(pag); //Pagina 1
        
        int anno = 2020;
        
        System.out.println("***************pagina modello cud (anno "+anno+"): " + pag);
        
        if(cud.isRettifica())
        { 
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }
        //ANNO IMPOSTA
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(anno-1), 									485, 763, 0);
        //DATORE LAVORO / SOSTITUTO IMPOSTA
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("10830461009"), 							122, 690, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("FIDEURAM VITA SPA"), 						268, 690, 0);
        
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ROMA"), 						  			122, 665, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("RM"), 						  			317, 665, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("00193"), 						  			347, 665, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("VIA ENNIO QUIRINO VISCONTI 80"), 			397, 665, 0);
        
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("+390635711/+390635714509"), 				122, 641, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("relazioniclienti@fideuramvita.it"), 		268, 641, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("651100"), 								467, 641, 0);        
        
        //PERCETTORE SOMME - CF
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getCf()), 									  122, 617, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCognome()),                                  268, 617, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getNome()),                                     442, 617, 0);
        //PERCETTORE SOMME - SESSO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getSesso()),                                    122, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDataNascita()),                              152, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getComuneNascita()),                            230, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getProvinciaNascita()),                         360, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCategorieParticolari()),                     440, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getEventiEccezionali()),                        483, 580, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCasiEsclusione()),                           526, 580, 0);
        //PERCETTORE SOMME - DOM. FISC. ANNO PREC
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getComune()),             122, 545, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getProvincia()),          432, 545, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getCodiceComune()),       471, 545, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getFusioneComuni()),      525, 545, 0);
        //PERCETTORE SOMME - DOM. FISC. ANNO ATTUALE
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getComune()),                    122, 510, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getProvincia()),                 432, 510, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getCodiceComune()),              471, 510, 0);
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getFusioneComuni()),             525, 510, 0);
        
        //DATA ULTIMA RIGA
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getDataEleaborazione(),11), 							134, 363, 0);//DATA ULTIMA RIGA
        //FIRMA
        //ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, getPhrase("firma"), 												234, 363, 0);//DATA ULTIMA RIGA
        
        
        //###	INSERT SIGN - START
        String imageUrl = "C:\\Scheduler\\batch\\cu\\firma\\2020\\firma.png";
        try {
			Image firma;
			try {
				firma = Image.getInstance(imageUrl);
				firma.setAbsolutePosition(364f, 354f);
				firma.scalePercent(17);
				try {
					canvas.addImage(firma);
				} catch (DocumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (com.itextpdf.text.BadElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //###	INSERT SIGN - END
        
        
        if(null!=cud.getPercettoreSomme().getRappresentante())
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getRappresentante().getCf().toUpperCase()),     122, 475, 0);
        if(null!=cud.getPercettoreSomme().getResidenzaEstero())
            stampaRiferimentoEstro(canvas, cud.getPercettoreSomme().getResidenzaEstero());
    }

    private void stampaRiferimentoEstro(PdfContentByte canvas,ResidenzaEstero re){
        if(null!=re){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getCfEstero().toUpperCase()),           122, 438, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getLocalita().toUpperCase()),           259, 438, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getViaenumero().toUpperCase()),         122, 403, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getShumacker().toUpperCase()),          465, 403, 0);
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getCodiceStatoEstero().toUpperCase()),  525, 403, 0);
        }
        
    }
    
    
}