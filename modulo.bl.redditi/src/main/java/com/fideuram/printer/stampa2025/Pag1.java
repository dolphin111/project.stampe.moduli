package com.fideuram.printer.stampa2025;

import com.fideuram.printer.PaginaBase;
import com.fideuram.stampe.modello.redditi.anagrafica.ResidenzaEstero;
import com.fideuram.stampe.modello.redditi.d2025.Cud2025;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * User: V801068
 * Date: 08/01/16
 * Time: 10.50
 */
public class Pag1 extends PaginaBase {

    public void stampa(PdfStamper stamper, Cud2025 cud, int pag) {

        canvas = stamper.getOverContent(pag); //Pagina 1

        int anno = 2025;

        System.out.println("***************pagina modello cud (anno "+anno+"): " + pag);

        if(cud.isSostituzione())
        {
        	ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ANNULLA E SOSTITUISCE", 12), 390, 820, 0);
        }
        //ANNO IMPOSTA

		/*
		 * TODO prevedere una qualche configurazione per elaborare temporaneamente l'anno riferimento attuale
		 * (forzatura, ad esempio generazione delle CU 2025 (con anno riferimento 2024) prima del 01/01/2025) anziche'
		 * il precedente (comportamento normale, riprendendo l'esempio di prima: generazione dal 01/01/2025 in poi). Valutare se usare la chiave "isAnnoRiferimentoAttuale"
		 * del progetto com.fideuram.etl:GestioneCU
		 */
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(anno - 1), 									485, 763, 0);
        // ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(anno), 										485, 763, 0);

        //DATORE LAVORO / SOSTITUTO IMPOSTA
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("10830461009"), 							122, 690, 0); // Codice fiscale
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("FIDEURAM VITA SPA"), 						268, 690, 0); // Cognome o Denominazione

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("ROMA"), 						  			122, 665, 0); // Comune
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("RM"), 						  			317, 665, 0); // Prov.
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("00193"), 						  			347, 665, 0); // Cap
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("VIA ENNIO QUIRINO VISCONTI 80"), 			397, 665, 0); // Indirizzo

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("+390635711/+390635714509"), 				122, 641, 0); // Teleofno, fax

		// Indirizzo di posta elettronica
        //ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("relazioniclienti@fideuramvita.it"), 		268, 641, 0);
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("servizioclienti@fideuramvita.it"), 		268, 641, 0);//modifica 05/2023

        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("651100"), 								467, 641, 0); // Codice attivita'

        //PERCETTORE SOMME - CF
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getCf()), 									  122, 617, 0); // Codice fiscale
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCognome()),                                  268, 617, 0); // Cognome o Denominazione
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getNome()),                                     442, 617, 0); // Nome
//        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase("TEST"), 									  122, 617, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),                                  268, 617, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),                                     442, 617, 0);

        //PERCETTORE SOMME - SESSO
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getSesso()),                                    122, 580, 0); // Sesso (M o F)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDataNascita()),                              152, 580, 0); // Data di nascita
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getComuneNascita()),                            230, 580, 0); // Comune (o Stato estero) di nascita
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getProvinciaNascita()),                         360, 580, 0); // Provincia di nascita (sigla)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCategorieParticolari()),                     440, 580, 0); // Categorie particolari
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getEventiEccezionali()),                        483, 580, 0); // Eventi eccezionali
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getCasiEsclusione()),                           526, 580, 0); // Casi di esclusione dalla precompilata
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),                     122, 580, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),                     152, 580, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),                     230, 580, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),                     360, 580, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),                     440, 580, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),                     483, 580, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),                     526, 580, 0);

        //PERCETTORE SOMME - DOM. FISC. ANNO PREC (all' 1/1/2024)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getComune()),             122, 545, 0); // Comune
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getProvincia()),          432, 545, 0); // Provincia (sigla)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getCodiceComune()),       471, 545, 0); // Codice comune
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAnnoPrecedente().getFusioneComuni()),      525, 545, 0); // Fusione comuni
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),      122, 545, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),      432, 545, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),      471, 545, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),      525, 545, 0);

        //PERCETTORE SOMME - DOM. FISC. ANNO ATTUALE (all' 1/1/2025)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getComune()),                    122, 510, 0); // Comune
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getProvincia()),                 432, 510, 0); // Provincia (sigla)
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getCodiceComune()),              471, 510, 0); // Codice comune
        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase(cud.getPercettoreSomme().getDfAttuale().getFusioneComuni()),             525, 510, 0); // Fusione comuni
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),             122, 510, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),             432, 510, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),             471, 510, 0);
//        ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT,  getPhrase("TEST"),             525, 510, 0);

        //DATA ULTIMA RIGA
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT, getPhrase(cud.getDataEleaborazione(),11), 							134, 363, 0);//DATA ULTIMA RIGA
        //FIRMA
        //ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, getPhrase("firma"), 												234, 363, 0);//DATA ULTIMA RIGA


        //###	INSERT SIGN - START
        String imageUrl = "C:\\Scheduler\\batch\\cu\\firma\\2025\\firma.png";
        try {
			Image firma;
			try {
				firma = Image.getInstance(imageUrl);

				// Engineering Maggio 2024 (riposizionamento della firma in quanto modificata, come da e-mail del 10/05/2024)
				// firma.setAbsolutePosition(364f, 354f);
				// firma.scalePercent(17);
				firma.setAbsolutePosition(340f, 353f);
				firma.scalePercent(9);

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
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(cud.getPercettoreSomme().getRappresentante().getCf().toUpperCase()),     122, 475, 0); // Codice fiscale
            // ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TEST"),     122, 475, 0); // Codice fiscale
        if(null!=cud.getPercettoreSomme().getResidenzaEstero())
            stampaRiferimentoEstro(canvas, cud.getPercettoreSomme().getResidenzaEstero());
    }

    private void stampaRiferimentoEstro(PdfContentByte canvas,ResidenzaEstero re){
        if(null!=re){
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getCfEstero().toUpperCase()),           122, 438, 0); // Codice di identificazione fiscale estero
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getLocalita().toUpperCase()),           259, 438, 0); // Localita' di residenza estera
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getViaenumero().toUpperCase()),         122, 403, 0); // Via e numero civico
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getShumacker().toUpperCase()),          420, 403, 0); // Non residenti Schumacker
            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase(re.getCodiceStatoEstero().toUpperCase()),  480, 403, 0); // Codice stato estero
//            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TEST40"),  122, 438, 0); // Codice di identificazione fiscale estero
//            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TEST41"),  259, 438, 0); // Localita' di residenza estera
//            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TEST43"),  122, 403, 0); // Via e numero civico
//            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TEST44"),  420, 403, 0); // Non residenti Schumacker
//            ColumnText.showTextAligned(canvas,Element.ALIGN_LEFT, getPhrase("TEST45"),  480, 403, 0); // Codice stato estero
        }

    }


}