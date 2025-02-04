package com.fideuram.processo;

import com.fideuram.exception.TrasformazioneException;
import com.fideuram.jaxb.Converter;
import com.fideuram.modello.ContrattoOrigineFactory;
import com.fideuram.modello.PolizzaTrasformabile;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.Streamer;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

/**
 * Created by
 * User: logan
 * Date: 25/02/13
 * Time: 18.11
 */
public class FacadeTrasformazioni {

    /**
     * Questo metodo passa  il bean polizzaTrasformabile in generazione stampa.
     * <br>
     *    ...Presuppone che il sia già stato caricato il contratto di origine
     * @param polizzaTrasformabile
     * @param destinazione         801(FvInsieme) - 802(FvFacile)
     * @return
     * @throws TrasformazioneException
     */
    public byte[] elaboraTrasformazioneCanaleFV(PolizzaTrasformabile polizzaTrasformabile, int destinazione) throws TrasformazioneException {
        try {
            polizzaTrasformabile.getOrigine().setCodiceDestinazione(destinazione);
            LoggingUtils.info("DATI TRASFORMABILI>>>"+Converter.objectToXml(polizzaTrasformabile));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = elaboraTrasformazione(polizzaTrasformabile, destinazione);
        try {
            return Streamer.getFile(file.getAbsolutePath());
        } catch (IOException e) {
            throw new TrasformazioneException("Errore di IO durante la trasformazione della Polizza n°: " + polizzaTrasformabile.getPolizza().getNumero(), e);
        }finally {
            file.delete();
        }
    }


    private File elaboraTrasformazione(PolizzaTrasformabile polizzaTrasformabile, int destinazione) throws TrasformazioneException {
        TrasformazioniDocGenerator trasformazioniDocGenerator = new TrasformazioniDocGenerator();
        return trasformazioniDocGenerator.generateDocument(polizzaTrasformabile, destinazione);
    }


}
