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
 * Time: 14.54
 */
public class FvInsiemeFacile extends GeneratoreBase {

    public FvInsiemeFacile(String dir) {
        temporaryDirecotry=dir;
    }

    public File generatePartI(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new AllegatoParteIGenerico().generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new AllegatoParteIIGenerico(ProspettoBase.FV_FACILE_PART_II).generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartIII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new AllegatoParteIIIGenerico().generateDocument(doc,temporaryDirecotry);
    }

    public File generateSupplemento(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        doc.setNomeProdotto("Fideuram Vita Insieme Facile");
        doc.getSupplemento().setPremessaParte1(Frasi.getFrase("fv.facile.parte.1"));
        doc.getSupplemento().setPremessaParte1A(Frasi.getFrase("fv.facile.parte.1.A"));
        doc.getSupplemento().setPremessaParte2(Frasi.getFrase("fv.facile.parte.2"));
        doc.getSupplemento().setPremessaParte3(Frasi.getFrase("fv.facile.parte.3"));
        doc.getSupplemento().setPremessaParte3b(Frasi.getFrase( "fv.facile.parte.3b"));
        doc.getSupplemento().setArt(Frasi.getFrase("fv.facile.art"));
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
