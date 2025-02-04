package com.fideuram.attori.controller;

import com.fideuram.attori.bo.impl.Destinatari;
import com.fideuram.exception.crm.DestinatariException;
import com.fideuram.exception.ws.CrmException;

/**
 * Created by
 * User: logan
 * Date: 06/10/11
 * Time: 11.28
 */
public interface IDestinatariLettera {
    public Destinatari configuraDestinatari() throws CrmException, DestinatariException;
}
