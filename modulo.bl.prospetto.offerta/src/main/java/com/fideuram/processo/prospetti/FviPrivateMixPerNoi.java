package com.fideuram.processo.prospetti;

import java.io.File;

import com.fideuram.costanti.Frasi;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.sintetico.ProspettoSintetico;
import com.fideuram.processo.prospetti.sintetico.SupplementoProspettoSintetico;

/**
 * User: V801068
 * Date: 25/03/15
 * Time: 14.35
 */
public class FviPrivateMixPerNoi extends GeneratoreBase{
	
	public FviPrivateMixPerNoi(String dir) {
        temporaryDirecotry=dir;
    }

    
    public File generateSupplemento(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        doc.setNomeProdotto("Fideuram Vita Insieme Private Mix");  //TODO verificare se arriva già valorizato
        doc.getSupplemento().setPremessaParte1("");
        doc.getSupplemento().setPrivateMix(true);
        doc.getSupplemento().setPremessaParte1A(Frasi.getFrase("fv.private.mix.parte.1A"));
        doc.getSupplemento().setArt(Frasi.getFrase("fv.private.art"));
        doc.getSupplemento().setAggiornamento(Frasi.getFrase("fv.private.aggiornamento"));
       
        return new SupplementoProspettoSintetico().generateDocument(doc,temporaryDirecotry);
    }


    public File generatePartI(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new ProspettoSintetico().generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        throw new ProspettoDiOffertaException("La PARTE II dei FV PRIVATE MIX non è prevista. I'm quite sorry");
    }

    public File generatePartIII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        throw new ProspettoDiOffertaException("La PARTE III dei FV PRIVATE MIX non è prevista. I'm quite sorry");
    }


	@Override
	public File generateRendiconto(PubblicazioneConsob doc)
			throws ProspettoDiOffertaException {
		// TODO Auto-generated method stub
		return null;
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
