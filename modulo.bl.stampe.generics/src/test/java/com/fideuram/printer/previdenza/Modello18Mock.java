package com.fideuram.printer.previdenza;

import com.fideuram.printer.mock.ContraenteMock;
import com.fideuram.printer.previdenza.sharedMock.ComunicazioneMock;
import com.fideuram.printer.previdenza.sharedMock.FondoPensioneMock;
import com.fideuram.stampe.modello.contraenza.Contratto;
import com.fideuram.stampe.modello.previdenza.Documentazione;
import com.fideuram.stampe.modello.previdenza.Previdenza;

/**
 * User: V801068
 * Date: 23/07/14
 * Time: 10.24
 */
public class Modello18Mock {

    public static Previdenza getPrevidenzaMock(){
        Previdenza o = new Previdenza();
        o.setPolizza(getContratto());
        o.setDocumentazione(getDoc());
        o.setRichiesta(ComunicazioneMock.getRichiesta());
        return o;
    }

    private static Contratto getContratto(){
        Contratto contratto = new Contratto();
        contratto.setAderente(ContraenteMock.getAderente());
        contratto.setCompagniaDiDestinazione(ContraenteMock.getCompagniaProvenienza());
        contratto.setFondoPensione(FondoPensioneMock.getFondoBreve());
        return contratto;
    }

    public static Documentazione getDoc(){
        Documentazione d = new Documentazione();
        d.addDocIntegrativa("Conferma che il nominativo in oggetto sia vostro iscritto");
        d.addDocIntegrativa("Conferma che il vostro fondo rientra nelle categorie designate ...");
        d.addDocIntegrativa("Indicazione coordinate bancarie (Iban)");
        d.setSollecito(true);

        d.addDocIntegrativaAderente("Richiesta firmata dall'aderente...");
        d.addDocIntegrativaAderente("Indicazione ultimo contributo versato....");
        return d;
    }


}
