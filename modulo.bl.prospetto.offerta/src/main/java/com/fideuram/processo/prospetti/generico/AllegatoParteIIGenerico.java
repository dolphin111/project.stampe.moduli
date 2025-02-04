package com.fideuram.processo.prospetti.generico;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.file.io.OdtMerge;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.ProspettoBase;
import com.fideuram.utils.LoggingUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with
 * User: v801068
 * Date: 13/03/14
 * Time: 18.22
 */
public class AllegatoParteIIGenerico  extends ProspettoBase {
    private int parteFissa;

    public AllegatoParteIIGenerico(int parteFissa) {
        this.parteFissa=parteFissa;
    }

    @Override
    public File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException {

        pubblicazioneConsob=doc;
        percorso=dir;

        List l = new ArrayList();
        File fisso= start(parteFissa,false);
        l.add(fisso);
        File dinamico=  start(FV_GENERICO_PARTE_II,true);
        l.add(dinamico);
        try {
            StreamerFactory.saveFile(new OdtMerge().mergeFileProdotti(l), dir, "AllegatoParteII.odt");
        } catch (DocGeneratorException e) {
            LoggingUtils.error(e);
            throw new ProspettoDiOffertaException(e.getMessage());
        } catch (Exception e) {
            LoggingUtils.error(e);
            throw new ProspettoDiOffertaException(e.getMessage());
        }
        return new File(dir+ "AllegatoParteII.odt");
    }
}