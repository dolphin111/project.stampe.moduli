package com.fideuram.processo.prospetti;

import java.io.File;

import com.fideuram.costanti.Frasi;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.sintetico.ProspettoSintetico;
import com.fideuram.processo.prospetti.sintetico.SupplementoProspettoSintetico;

/**
 * Created by
 * User: logan
 * Date: 13/03/13
 * Time: 14.17
 */
public class FvInsiemePrivate extends GeneratoreBase {
        public FvInsiemePrivate(String dir) {
            temporaryDirecotry=dir;
        }

    public File generatePartI(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        return new ProspettoSintetico().generateDocument(doc,temporaryDirecotry);
    }

    public File generatePartII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        throw new ProspettoDiOffertaException("La PARTE II dei FV PRIVATE non è prevista. I'm quite sorry");
    }

    public File generatePartIII(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        throw new ProspettoDiOffertaException("La PARTE III dei FV PRIVATE non è prevista. I'm quite sorry");
    }

    public File generateSupplemento(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        doc.setNomeProdotto("Fideuram Vita Insieme Private");  //TODO verificare se arriva già valorizato
        doc.getSupplemento().setPremessaParte1("");
        doc.getSupplemento().setPremessaParte1A(Frasi.getFrase("fv.private.parte.1.A"));
        doc.getSupplemento().setArt(Frasi.getFrase("fv.private.art"));
        doc.getSupplemento().setAggiornamento(Frasi.getFrase("fv.private.aggiornamento"));
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
        return new SupplementoProspettoSintetico().generateDocument(doc,temporaryDirecotry);
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
