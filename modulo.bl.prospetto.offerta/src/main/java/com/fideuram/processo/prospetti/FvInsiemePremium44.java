package com.fideuram.processo.prospetti;

import com.fideuram.costanti.Frasi;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.generico.*;

import java.io.File;

/**
 * Created by
 * User: logan
 * Date: 13/03/13
 * Time: 15.02
 */
public class FvInsiemePremium44 extends GeneratoreBase {
    public FvInsiemePremium44(String dir) {
        temporaryDirecotry=dir;
    }

    public File generatePartI(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new AllegatoParteIGenerico().generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new AllegatoParteIIGenerico(ProspettoBase.FV_PREMIUN44_PART_II).generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartIII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new AllegatoParteIIIGenerico().generateDocument(doc,temporaryDirecotry);
    }

    public File generateSupplemento(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        doc.setNomeProdotto("Fideuram Vita Insieme Premium 4+4");
        doc.getSupplemento().setPremessaParte1(Frasi.getFrase("fv.premium44.parte.1"));
        doc.getSupplemento().setPremessaParte1A(Frasi.getFrase("fv.premium44.parte.1.A"));
        doc.getSupplemento().setPremessaParte2(Frasi.getFrase( "fv.premium44.parte.2"));
        doc.getSupplemento().setPremessaParte3(Frasi.getFrase( "fv.premium44.parte.3"));
        doc.getSupplemento().setPremessaParte3b(Frasi.getFrase( "fv.premium44.parte.3b"));
        doc.getSupplemento().setPremessaParte3c(Frasi.getFrase("fv.premium44.parte.3c"));
        doc.getSupplemento().setAggiornamento(Frasi.getFrase("fv.premium44.aggiornamento"));
        doc.getSupplemento().setArt(Frasi.getFrase("fv.premium44.art"));
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
