package com.fideuram.stampe.printer;

import java.io.File;
import java.util.HashMap;

import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.stampe.exeption.MandatiPagamentoException;
import com.fideuram.stampe.modello.mandatiPagamento.DettaglioPagamenti;
import com.fideuram.stampe.modello.mandatiPagamento.MandatiPagamento;
import com.fideuram.stampe.modello.mandatiPagamento.Pagamento;
import com.fideuram.stampe.modello.mandatiPagamento.RiepilogoPagamenti;
import com.fideuram.utils.LoggingUtils;


public class MandatiPagamentoGenerator extends MandatiPagamentoBase{
    

	
    public MandatiPagamentoGenerator(String nomeTemplate) throws DocGeneratorException{
    	new MandatiPagamentoBase(nomeTemplate+".odt");
    }
	
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public byte[] generateDocument(Pagamento doc, String nomeTemplate) throws MandatiPagamentoException {
        
    	byte[] lbyte =null;
        try
        {	
        	//LoggingUtils.debug("Generazione Pagamento");

            HashMap map = new HashMap();
            map.put("PAGAMENTO", doc);
            lbyte = generatorePdf(map, nomeTemplate);

            //LoggingUtils.debug("Pagamento Prodotto");
            
        } catch (DocGeneratorException e) {
            //LoggingUtils.error(doc.numeroDistinta+nomeTemplate + e.getMessage());
            throw new MandatiPagamentoException("Mandati di Pagamento : Pagamento.generateDocument: TemplateLoaderExcepion",e);
		}
        return lbyte;
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    public byte[] generateDocument(RiepilogoPagamenti doc, String nomeTemplate) throws MandatiPagamentoException {

        byte[] lbyte =null;
        try
        {
            // LoggingUtils.debug("Generazione Riepilogo Pagamento");

            HashMap map = new HashMap();
            map.put("RIEPILOGOPAGAMENTI", doc);
            lbyte = generatorePdf(map, nomeTemplate);

            //  LoggingUtils.debug("Fine Riepilogo Pagamento");

        } catch (DocGeneratorException e) {
            //  LoggingUtils.error(nomeTemplate + e.getMessage());
            throw new MandatiPagamentoException("Mandati di Pagamento : Riepilogo Pagamento.generateDocument: TemplateLoaderExcepion",e);
        }
        return lbyte;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public byte[] generateDocument(DettaglioPagamenti doc, String nomeTemplate) throws MandatiPagamentoException {

        byte[] lbyte =null;
        try
        {
            // LoggingUtils.debug("Generazione Riepilogo Pagamento");

            HashMap map = new HashMap();
            map.put("DETTAGLIOPAGAMENTI", doc);
            lbyte = generatorePdf(map, nomeTemplate);

            //  LoggingUtils.debug("Fine Riepilogo Pagamento");

        } catch (DocGeneratorException e) {
            //  LoggingUtils.error(nomeTemplate + e.getMessage());
            throw new MandatiPagamentoException("Mandati di Pagamento : Dettaglio Distinte di Pagamento.generateDocument: TemplateLoaderExcepion",e);
        }
        return lbyte;
    }



}
