package com.fideuram.processo.prospetti;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.factory.FileManagerFactory;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.utils.LoggingUtils;

import java.io.File;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 12/02/13
 * Time: 11.49
 */
public abstract class GeneratoreBase {
    protected List<File> fileProdotti=null;
    protected static String temporaryDirecotry;



    /**
     * Questo metodo provvede a mergiare due o piì file odt
     * @throws ProspettoDiOffertaException
     */
    public void mergeFileProdotti() throws ProspettoDiOffertaException {
        try {
            byte[] odtUnico = FileManagerFactory.mergeOdtFiles(fileProdotti);
        } catch (DocGeneratorException e) {
            LoggingUtils.error(e);
            throw new ProspettoDiOffertaException(e.getMessage());
        }
    }

    public abstract File generatePartI(PubblicazioneConsob doc) throws ProspettoDiOffertaException;
    public abstract File generatePartII(PubblicazioneConsob doc) throws ProspettoDiOffertaException;
    public abstract File generatePartIII(PubblicazioneConsob doc) throws ProspettoDiOffertaException;
    public abstract File generateSupplemento(PubblicazioneConsob doc) throws ProspettoDiOffertaException;
    public abstract File generateRendiconto(PubblicazioneConsob doc) throws ProspettoDiOffertaException;
    public abstract File generateSchedaSintesi(PubblicazioneConsob doc) throws ProspettoDiOffertaException;
    public abstract File generateNotaInformativa(PubblicazioneConsob doc) throws ProspettoDiOffertaException;
    public abstract File generateAddendum(PubblicazioneConsob doc) throws ProspettoDiOffertaException;
}
