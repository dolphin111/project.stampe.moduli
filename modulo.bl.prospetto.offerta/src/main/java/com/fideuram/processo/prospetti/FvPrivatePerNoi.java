package com.fideuram.processo.prospetti;

import java.io.File;

import com.fideuram.costanti.Frasi;
import com.fideuram.exception.ProspettoDiOffertaException;
import com.fideuram.modello.PubblicazioneConsob;
import com.fideuram.processo.prospetti.sintetico.SupplementoProspettoSintetico;


/**
 * User: v801068
 * Date: 05/11/14
 * Time: 12.33
 */
public class FvPrivatePerNoi extends FvInsiemePrivate{

    public FvPrivatePerNoi(String dir) {
        super(dir);
    }
    

    public File generateSupplemento(PubblicazioneConsob doc) throws ProspettoDiOffertaException {
        doc.setNomeProdotto("Fideuram Vita Insieme Private Per Noi");
        doc.getSupplemento().setPremessaParte1("");
        doc.getSupplemento().setPremessaParte1A(Frasi.getFrase("fv.private.parte.1.A"));
        doc.getSupplemento().setArt(Frasi.getFrase("fv.private.art"));
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

}
