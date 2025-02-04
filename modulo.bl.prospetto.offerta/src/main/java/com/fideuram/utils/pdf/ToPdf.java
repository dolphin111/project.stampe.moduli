package com.fideuram.utils.pdf;


import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.pdfconverter.Converter;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.utils.LoggingUtils;

import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 03/10/12
 * Time: 9.15
 */
public class ToPdf {
    public static byte[] getPdf(byte[] odt) throws WebServiceClientException {
        byte [] bytes=null;
        Converter c = (Converter) ClientWsFactory.getInstance().getPdfConverterClient();
        try {
            bytes = c.odt2Pdf(odt);
        } catch (ConverterException e) {
            throw new WebServiceClientException("ConverterException",e);
        }
        LoggingUtils.info("Converter2PdfClient.getPdf: "+new Date() + "PDF GENERATO");
        return  bytes;
    }


}
