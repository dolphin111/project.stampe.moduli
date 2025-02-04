package com.fideuram.factory;

import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.pdfconverter.Converter;
import com.fideuram.pdfconverter.ConverterException;

/**
 * Created by
 * User: logan
 * Date: 17/04/13
 * Time: 9.54
 */
public class PdfFactory {
    public static byte[] getPdfFromOdt(byte[] odt) throws WebServiceClientException, ConverterException {
        Converter c = ClientWsFactory.getInstance().getPdfConverterClient();
        return c.odt2Pdf(odt);
    }
}
