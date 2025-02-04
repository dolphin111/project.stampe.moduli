package com.fideuram.processo.prospetti;

import java.io.File;

import com.fideuram.costanti.Frasi;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.sintetico.AddendumGemini;
import com.fideuram.processo.prospetti.sintetico.AddendumSintonia;
import com.fideuram.processo.prospetti.sintetico.NotaInformativaGemini;
import com.fideuram.processo.prospetti.sintetico.NotaInformativaSintonia;
import com.fideuram.processo.prospetti.sintetico.ProspettoSinteticoGemini;
import com.fideuram.processo.prospetti.sintetico.ProspettoSinteticoSintonia;
import com.fideuram.processo.prospetti.sintetico.RendicontoGemini;
import com.fideuram.processo.prospetti.sintetico.RendicontoSintonia;

public class FVInsiemeSintonia extends GeneratoreBase{
	
	public FVInsiemeSintonia(String dir) {
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
		return new RendicontoSintonia().generateDocument(doc, temporaryDirecotry);
	}
	
	
	public File generateSchedaSintesi(PubblicazioneConsob doc) throws ProspettoDiOffertaException{
		return new ProspettoSinteticoSintonia().generateDocument(doc,temporaryDirecotry);
	}
	
	public File generateNotaInformativa(PubblicazioneConsob doc) throws ProspettoDiOffertaException{
		return new NotaInformativaSintonia().generateDocument(doc,temporaryDirecotry);
	}

	@Override
	public File generateAddendum(PubblicazioneConsob doc)
			throws ProspettoDiOffertaException {
		doc.getAddendum().setPremessaParte1(Frasi.getFrase("fv.sintonia.premessaParte1"));
		doc.getAddendum().setPremessaParte2(Frasi.getFrase("fv.sintonia.premessaParte2"));
		doc.getAddendum().setPremessaNotaInformativa1(Frasi.getFrase("fv.sintonia.premessaNotaInformativa1"));
		doc.getAddendum().setPremessaNotaInformativa2(Frasi.getFrase("fv.sintonia.premessaNotaInformativa2"));
		doc.getAddendum().setPremessaNotaInformativa3(Frasi.getFrase("fv.sintonia.premessaNotaInformativa3"));
		return new AddendumSintonia().generateDocument(doc,temporaryDirecotry);
	}
		
}
