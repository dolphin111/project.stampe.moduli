package com.fideuram.stampeservice.controller;

import com.fideuram.exception.CredenzialiException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.factory.PdfFactory;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.processo.FacadeCredenziali;
import com.fideuram.stampeservice.FaultBean;
import com.fideuram.stampeservice.StampeWsException;

/**
 * User: V801068
 * Date: 02/02/16
 * Time: 18.32
 */
public class PdfRequest {
    public byte[] stampa(String xml, int action) throws StampeWsException {
        try {
            switch (action) {
                case (16):
                case (17):
                case (18):
                case (19):
                    return new FacadeCredenziali().stampa(xml, action);
                default:
                    byte[] b= new OdtRequest().stampa(xml, action);
                    return odt2pdf(b);
            }
        } catch (CredenzialiException e) {
            throw new StampeWsException("Request PDF non trovata", new FaultBean(e.getMessage()));
        }
    }

    private byte[] odt2pdf(byte[] odt) throws StampeWsException {
        byte[] pdf = new byte[0];
        try {
            pdf = PdfFactory.getPdfFromOdt(odt);
        } catch (WebServiceClientException e) {
            throw new StampeWsException(e.getMessage(),new FaultBean(e.getMessage()));
        } catch (ConverterException e) {
            throw new StampeWsException(e.getMessage(),new FaultBean(e.getMessage()));
        }
        return pdf;
    }

}
