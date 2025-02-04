package com.fideuram.processo.prospetti;

import com.fideuram.costanti.Frasi;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.generico.*;
import com.fideuram.processo.prospetti.sintetico.ProspettoSintetico;
import com.fideuram.processo.prospetti.sintetico.SupplementoProspettoSintetico;

import java.io.File;

/**
 * Created by
 * User: logan
 * Date: 12/02/13
 * Time: 12.05
 */
public class FvInsiemePremium extends GeneratoreBase {

    public FvInsiemePremium(String dir) {
         temporaryDirecotry=dir;
    }
    

    public File generatePartI(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new AllegatoParteIGenerico().generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new AllegatoParteIIGenerico(ProspettoBase.FV_PREMIUN_PART_II).generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartIII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new AllegatoParteIIIGenerico().generateDocument(doc,temporaryDirecotry);
    }
    
    

//    public File generatePartI(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
//        return new ProspettoSintetico().generateDocument(doc,temporaryDirecotry);
//    }
//
//    public File generatePartII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
//        throw new ProspettoDiOffertaException("La PARTE II dei FV PRIVATE non è prevista. I'm quite sorry");
//    }
//
//    public File generatePartIII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
//        throw new ProspettoDiOffertaException("La PARTE III dei FV PRIVATE non è prevista. I'm quite sorry");
//    }


    @Override
    public File generateSupplemento(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
    	doc.getSupplemento().setPremium(true);
    	doc.getSupplemento().setParte1(true);   //voglio stampare la parte I
    	doc.getSupplemento().setParte2(true);    //voglio stampare la parte II
    	doc.getSupplemento().setParte3(true);     //voglio stampare la parte III
    	doc.getSupplemento().setPremessaParte1(Frasi.getFrase("fv.premium.parte.1"));
    	doc.getSupplemento().setPremessaParte1A(Frasi.getFrase("fv.premium.parte.1.A"));
    	doc.getSupplemento().setAggiornamento(Frasi.getFrase("fv.premium.aggiornamento"));
    	doc.getSupplemento().setPremessaParte3c(Frasi.getFrase( "fv.insieme.parte.3c"));
    	doc.getSupplemento().setPremessaParte3(Frasi.getFrase("fv.premium.parte.3"));
        doc.getSupplemento().setPremessaParte3b(Frasi.getFrase("fv.premium.parte.3b"));
//          doc.getSupplemento().setPremessaParte2(Frasi.getFrase("fv.premium.parte.2"));
//          doc.getSupplemento().setArt(Frasi.getFrase("fv.premium.art"));
         
    	
    	
        doc.setNomeProdotto("Fideuram Vita Insieme Premium"); //TODO VERIFICARE SE GIà INSERITO
        doc.getSupplemento().setPremessaParte1(Frasi.getFrase("fv.premium.parte.1"));
        doc.getSupplemento().setPremessaParte1A(Frasi.getFrase("fv.premium.parte.1.A"));
        doc.getSupplemento().setArt(Frasi.getFrase("fv.premium.art"));
        //solo per i supplementi il puntatoe dei fondi interni deve valere ""

        for (int i=0; i<doc.getSelectionFunds().size(); i++){
            switch (i){
                case 0:
                    doc.getSelectionFunds().get(0).setPuntatore("A)");
                    break;
                case 1:
                    doc.getSelectionFunds().get(1).setPuntatore("B)");
                    break;
                case 2:
                    doc.getSelectionFunds().get(2).setPuntatore("C)");
                    break;
                case 3:
                    doc.getSelectionFunds().get(3).setPuntatore("D)");
                    break;
                case 4:
                    doc.getSelectionFunds().get(4).setPuntatore("E)");
                    break;
                case 5:
                    doc.getSelectionFunds().get(4).setPuntatore("F)");
                    break;
            }
        }
//        return new SupplementoProspettoSintetico().generateDocument(doc,temporaryDirecotry);
        return new SupplementoProspetti().generateDocument(doc,temporaryDirecotry);
    }

    @Override
    public File generateRendiconto(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        throw new ProspettoDiOffertaException("PER LE OFFERTE PRIVATE IL rendiconto non è previsto. I'm quite sorry");
    }


	@Override
	public File generateSchedaSintesi(PubblicazioneConsob doc)
			throws ProspettoDiOffertaException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public File generateNotaInformativa(PubblicazioneConsob doc)
			throws ProspettoDiOffertaException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public File generateAddendum(PubblicazioneConsob doc)
			throws ProspettoDiOffertaException {
		// TODO Auto-generated method stub
		return null;
	}


}
