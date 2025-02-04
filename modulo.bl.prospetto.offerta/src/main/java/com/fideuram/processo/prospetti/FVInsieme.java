package com.fideuram.processo.prospetti;


import com.fideuram.costanti.Frasi;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.generico.*;

import java.io.File;

/**
 * Created by
 * User: logan
 * Date: 04/07/12
 * Time: 11.47
 */
public class FVInsieme extends GeneratoreBase {
    public FVInsieme(String dir) {
        temporaryDirecotry=dir;
    }

    public File generatePartI(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
    	doc.setInsieme(true);
        return new AllegatoParteIGenerico().generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
         return new AllegatoParteIIGenerico(ProspettoBase.FV_INSIEME_PART_II).generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartIII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new AllegatoParteIIIGenerico().generateDocument(doc,temporaryDirecotry);
    }

    @Override
    public File generateSupplemento(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        doc.setNomeProdotto("Fideuram Vita Insieme");
        doc.getSupplemento().setPremium(false);
        doc.getSupplemento().setParte1(true);   //voglio stampare la parte I
    	doc.getSupplemento().setParte2(true);    //voglio stampare la parte II
    	doc.getSupplemento().setParte3(true);     //voglio stampare la parte III
        doc.getSupplemento().setAggiornamento(Frasi.getFrase("fv.insieme.aggiornamento"));
        doc.getSupplemento().setPremessaParte1(Frasi.getFrase("fv.insieme.parte.1"));
        doc.getSupplemento().setPremessaParte1A(Frasi.getFrase("fv.insieme.parte.1.A"));
        doc.getSupplemento().setPremessaParte2(Frasi.getFrase("fv.insieme.parte.2"));
        doc.getSupplemento().setPremessaParte3(Frasi.getFrase("fv.insieme.parte.3"));
        doc.getSupplemento().setPremessaParte3b(Frasi.getFrase( "fv.insieme.parte.3b"));
        doc.getSupplemento().setPremessaParte3c(Frasi.getFrase( "fv.insieme.parte.3c"));
        doc.getSupplemento().setArt(Frasi.getFrase("fv.insieme.art"));
        return new SupplementoProspetti().generateDocument(doc,temporaryDirecotry);
    }

    @Override
    public File generateRendiconto(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return  new RendicontoGenerico().generateDocument(doc, temporaryDirecotry);
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
