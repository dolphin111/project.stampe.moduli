package com.fideuram.preventivo.processo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.preventivo.config.Templates;
import com.fideuram.preventivo.modello.Dichiarazione;
import com.fideuram.preventivo.modello.DichiarazioneDomandaRisposta;
import com.fideuram.preventivo.modello.PremiFVI;
import com.fideuram.preventivo.modello.PremiFVIStr;
import com.fideuram.preventivo.modello.PreventivoFVI;
import com.fideuram.preventivo.modello.PreventivoStampabilePlus;
import com.fideuram.preventivo.modello.PreventivoStampabilePlusFVI;
import com.fideuram.preventivo.modello.Questionario;
import com.fideuram.template.TemplateFinder;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

/**
 * Created by
 * User: logan
 * Date: 19/03/13
 * Time: 14.45
 */
public class PreventivoTcmEsitoFVI {

    public Object getDocumento(PreventivoFVI p, int richiesta)
            throws DocGeneratorException
    {
        LoggingUtils.debug("com.fideuram.crm.stampe.engine.processi.preventivi.PreventivoTcmEsitoFVI.getDocumento");
        HashMap map = new HashMap();
        try{
            PreventivoStampabilePlusFVI preventivoStampabile = new PreventivoStampabilePlusFVI();
            try {
                BeanUtils.copyProperties(preventivoStampabile, p);  //todo eliminare xkè inutile
            } catch (IllegalAccessException e) {
                LoggingUtils.error("PreventivoTcmEsitoFVI.getDocumento "+e.getMessage());
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                LoggingUtils.error("PreventivoTcmEsitoFVI.getDocumento "+e.getMessage());
                e.printStackTrace();
            }
            
            map.put("preventivo", preventivoStampabile);
        	
        	return generatoreOdt(map, Templates.TEMPLATE_ESITO_TCM_FVI);
        	
        }catch(DocGeneratorException e){
            throw new DocGeneratorException("Eccezione in stampa preventivi PreventivoTcmEsitoFVI:--->"+e);
        }
    }

    private PreventivoStampabilePlus formatField(PreventivoStampabilePlus preventivoStampabile) {
        preventivoStampabile.getCapitale().setCapitaleAssicurato(NumberUtils.getNullSefeCurrency(convertToDouble(preventivoStampabile.getCapitale().getCapitaleAssicurato())));
        return preventivoStampabile;
    }

    private double convertToDouble(String importo){
        double d = new BigDecimal(importo).doubleValue();
        return d;
    }

    private byte[] generatoreOdt(HashMap data, String template) throws DocGeneratorException {
        byte templateData[] = new byte[0];
        try {
            templateData = TemplateFinder.getTemplate(template);
            LoggingUtils.debug((new StringBuilder("template")).append(templateData.toString()).toString());
            byte doc[] =  new OdtWriter().mergeData(templateData, data);
            
//            try {
//				FileUtils.writeByteArrayToFile(new File("C:\\app\\preventiviFvInsiemeODT\\FVI\\temp\\"+template), doc);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
            
            doc = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(doc);
            return doc;
        } catch (TemplateLoaderExcepion templateLoaderExcepion) {
            templateLoaderExcepion.printStackTrace();
        }
        catch (ConverterException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (WebServiceClientException e) {
            throw new DocGeneratorException(e.getMessage());
        }
        return null;
    }

}
