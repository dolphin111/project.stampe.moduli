package com.fideuram.processo.prospetti.sintetico;

import java.io.File;

import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.ProspettoBase;
/**
 * 
 * @author cmollica
 *
 */
public class AddendumGemini  extends ProspettoBase {
	
        @Override
        public File generateDocument(PubblicazioneConsob doc, String dir) throws ProspettoDiOffertaException {
            doc.cleanDoc(true);             
            doc.indexSelectionFunds(0);      
            for (int i=0;i<doc.getSelectionFunds().size();i++){
                doc.getSelectionFunds().get(i).setPuntatore(doc.getSelectionFunds().get(i).getPuntatore()+(doc.getSelectionFunds().get(i).isFondoEsterno()==true?" FONDI ESTERNI -":" FONDI INTERNI "));
            }
            pubblicazioneConsob=doc;
            percorso=dir;
            return start(FV_GEMINI_ADDENDUM,true);
        }


}
