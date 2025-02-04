package com.fideuram.attori.bo;

import com.fideuram.attori.bo.impl.Indirizzo;

/**
 * Created by
 * User: logan
 * Date: 28/09/11
 * Time: 18.10
 */
public interface IPersona {
    public String       getTitolo();
    public String       getDenominazione() ;
    public Indirizzo    getIndirizzo() ;
	public String       getDataNascita() ;
    public String       getSesso();


    public void         setDenominazione(String cognome, String nome) ;
    public void         setIndirizzo(Indirizzo indirizzo) ;
    public void         setIndirizzo(String via, String citta, String cap,String provincia);
    public void         setDataNascita(String dataNascita) ;
    public void         setSesso(String sesso);

}
