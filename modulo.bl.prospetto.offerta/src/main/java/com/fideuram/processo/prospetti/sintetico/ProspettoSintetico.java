package com.fideuram.processo.prospetti.sintetico;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.ProspettoBase;

import java.io.File;

/**
 * Created by V801068 on 06/06/14.
 */
public class ProspettoSintetico  extends ProspettoBase {
        @Override
        public File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException {
            doc.cleanDoc(true);              //elimina le  selection vuote
            doc.indexSelectionFunds(0);      //indicizzo le selectionFund a partire dalla posizione 0 con A) ...B) ETC

            for (int i=0;i<doc.getSelectionFunds().size();i++){
                doc.getSelectionFunds().get(i).setPuntatore(doc.getSelectionFunds().get(i).getPuntatore()+
                		(doc.getSelectionFunds().get(i).isFondoEsterno()==true?
                				(!doc.getSelectionFunds().get(i).getNome().contains("FONDI ESTERNI") ? " FONDI ESTERNI -" : "")
                				:" FONDI INTERNI "));
            }

            pubblicazioneConsob=doc;
            percorso=dir;
            return start(FV_PROSPETTO_SISNTETICO_GENERICO,false);
        }


}
