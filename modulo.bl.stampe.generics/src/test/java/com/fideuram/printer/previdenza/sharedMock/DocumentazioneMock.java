package com.fideuram.printer.previdenza.sharedMock;

import com.fideuram.stampe.modello.previdenza.Documentazione;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 19/08/14
 * Time: 17.13
 * To change this template use File | Settings | File Templates.
 */
public class DocumentazioneMock {
    public static Documentazione getDocIntegrativa(){
        Documentazione d = new Documentazione();
        d.addDocIntegrativa("Documenrazione Integrativa 1");
        d.addDocIntegrativa("Documenrazione Integrativa 2");
        d.addDocIntegrativa("Documenrazione Integrativa 3");
       // d.setSollecito(true);
        return d;
    }

    public static Documentazione getDocIntegrativaConAderente(){
        Documentazione d = new Documentazione();
        d.addDocIntegrativa("Documenrazione Integrativa 1");
        d.addDocIntegrativa("Documenrazione Integrativa 2");
        d.addDocIntegrativa("Documenrazione Integrativa 3");

        d.addDocIntegrativaAderente("Documenrazione Integrativa Aderente 1");
        d.addDocIntegrativaAderente("Documenrazione Integrativa Aderente 2");
        d.setSollecito(true);
        return d;
    }

    public static Documentazione getDocIntegrativaAderente(){
        Documentazione d = new Documentazione();
        d.addDocIntegrativaAderente("Documenrazione Integrativa Aderente 1");
        d.addDocIntegrativaAderente("Documenrazione Integrativa Aderente 2");
       // d.setSollecito(true);
        return d;
    }
}
