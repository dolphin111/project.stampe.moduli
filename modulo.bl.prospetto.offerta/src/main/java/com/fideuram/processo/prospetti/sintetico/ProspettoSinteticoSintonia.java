package com.fideuram.processo.prospetti.sintetico;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.ProspettoBase;

import java.io.File;


public class ProspettoSinteticoSintonia  extends ProspettoBase {
        @Override
        public File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException {
            doc.cleanDoc(true);              //elimina le  selection vuote
            doc.indexSelectionFunds(0);      //indicizzo le selectionFund a partire dalla posizione 0 con A) ...B) ETC

            for (int i=0;i<doc.getSelectionFunds().size();i++){
                doc.getSelectionFunds().get(i).setPuntatore(doc.getSelectionFunds().get(i).getPuntatore()+(doc.getSelectionFunds().get(i).isFondoEsterno()==true?" FONDI ESTERNI -":" FONDI INTERNI "));
            }

            pubblicazioneConsob=doc;
            percorso=dir;
            return start(FV_SINTONIA_SCHEDA_SINTETICA,false);
        }


}
