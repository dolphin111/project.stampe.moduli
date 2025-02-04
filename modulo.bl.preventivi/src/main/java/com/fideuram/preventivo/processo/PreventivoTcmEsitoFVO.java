package com.fideuram.preventivo.processo;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;

import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.file.manipolation.odt.OdtWriter;
import com.fideuram.pdfconverter.ConverterException;
import com.fideuram.preventivo.config.Templates;
import com.fideuram.preventivo.modello.PreventivoFVO;
import com.fideuram.preventivo.modello.PreventivoStampabileFVO;
import com.fideuram.template.TemplateFinder;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;


public class PreventivoTcmEsitoFVO {

    public Object getDocumento(PreventivoFVO p, int richiesta)
            throws DocGeneratorException
    {
        LoggingUtils.debug("com.fideuram.crm.stampe.engine.processi.preventivi.PreventivoTcmEsitoFVI.getDocumento");
        HashMap map = new HashMap();
        try{
            PreventivoStampabileFVO preventivoStampabile = new PreventivoStampabileFVO();
            try {
                BeanUtils.copyProperties(preventivoStampabile, p);  //todo eliminare xkè inutile
            } catch (IllegalAccessException e) {
                LoggingUtils.error("PreventivoTcmEsitoFVO.getDocumento "+e.getMessage());
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                LoggingUtils.error("PreventivoTcmEsitoFVO.getDocumento "+e.getMessage());
                e.printStackTrace();
            }
            
            map.put("preventivo", preventivoStampabile);
        	
        	return generatoreOdt(map, Templates.TEMPLATE_ESITO_TCM_FVO);
        	
        }catch(DocGeneratorException e){
            throw new DocGeneratorException("Eccezione in stampa preventivi PreventivoTcmEsitoFVI:--->"+e);
        }
    }

    private PreventivoStampabileFVO formatField(PreventivoStampabileFVO preventivoStampabile) {
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
