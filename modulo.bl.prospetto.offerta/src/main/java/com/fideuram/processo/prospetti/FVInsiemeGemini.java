package com.fideuram.processo.prospetti;

import java.io.File;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.sintetico.AddendumGemini;
import com.fideuram.processo.prospetti.sintetico.NotaInformativaGemini;
import com.fideuram.processo.prospetti.sintetico.ProspettoSinteticoGemini;
import com.fideuram.processo.prospetti.sintetico.RendicontoGemini;

public class FVInsiemeGemini extends GeneratoreBase{
	
	public FVInsiemeGemini(String dir) {
        temporaryDirecotry=dir;
   }

	@Override
	public File generatePartI(PubblicazioneConsob doc)
			throws ProspettoDiOffertaException {
		return null;
	}

	@Override
	public File generatePartII(PubblicazioneConsob doc)
			throws ProspettoDiOffertaException {
		return null;
	}

	@Override
	public File generatePartIII(PubblicazioneConsob doc)
			throws ProspettoDiOffertaException {
		return null;
	}

	@Override
	public File generateSupplemento(PubblicazioneConsob doc)
			throws ProspettoDiOffertaException {
		return null;
	}

	@Override
	public File generateRendiconto(PubblicazioneConsob doc)
			throws ProspettoDiOffertaException {
		return new RendicontoGemini().generateDocument(doc, temporaryDirecotry);
	}
	
	public File generateSchedaSintesi(PubblicazioneConsob doc) throws ProspettoDiOffertaException{
		return new ProspettoSinteticoGemini().generateDocument(doc,temporaryDirecotry);
	}
	
	public File generateNotaInformativa(PubblicazioneConsob doc) throws ProspettoDiOffertaException{
		return new NotaInformativaGemini().generateDocument(doc,temporaryDirecotry);
	}

	@Override
	public File generateAddendum(PubblicazioneConsob doc)throws ProspettoDiOffertaException {
		return new AddendumGemini().generateDocument(doc,temporaryDirecotry);
	}
		
}
