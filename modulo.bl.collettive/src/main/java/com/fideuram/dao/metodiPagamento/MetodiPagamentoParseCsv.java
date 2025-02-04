package com.fideuram.dao.metodiPagamento;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.metodiPagamento.ListMetodiPagamento;
import com.fideuram.modello.metodiPagamento.Mandato;
import com.fideuram.modello.metodiPagamento.MetodiPagamento;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

public class MetodiPagamentoParseCsv {

	
	public static ListMetodiPagamento parseMetodiPagamento(String filename) throws CollettiveFileDataReadException, IOException{
        ListMetodiPagamento listMetodPagamenti = new ListMetodiPagamento();
        BufferedReader br = null;
        try {
            List<Mandato> mandati =  new ArrayList<Mandato>();
            MetodiPagamento metodPagamento = null;
            //local var
            String nextMandato = null;
            double importoTotale = 0.0;
            br = new BufferedReader( new FileReader(filename) );
            String line = "";
            String[] paramTracciato = null;
            int lineNum = 0, tokenNum = 0;

            while((line = br.readLine()) != null) {
            	line.trim();
                lineNum++;
                LoggingUtils.debug("posizione Linea del file #" + lineNum);

                // break comma separated file line by line
                paramTracciato = line.split(";");
                if(paramTracciato.length <= 1)
                	 break;
                if(paramTracciato.length < 40){
                	LoggingUtils.error("paramTracciato length ERROR: " + paramTracciato.length);
                    throw new CollettiveFileDataReadException("length del tracciato non valida");
                }
                else if(nextMandato!=null && nextMandato.equals(paramTracciato[1])){
                	//nuova linea di mandato e ricalcolo dell'importo totale
                	mandati.add(parseMandato(paramTracciato));
                    importoTotale = importoTotale + Double.parseDouble(paramTracciato[32].replace(",", "."));
                    metodPagamento.setTotaleMandati(importoTotale);
                    metodPagamento.setMandati(mandati);
                }
                else if(nextMandato!=null && !nextMandato.equals(paramTracciato[1])){
                	
                	importoTotale = 0d;
                	nextMandato = paramTracciato[1];
                	//nuovo metodo di pagamento
                	metodPagamento.setMandati(mandati);
                	metodPagamento = parseMetodoPag(paramTracciato);
                	importoTotale = importoTotale + Double.parseDouble(paramTracciato[32].replace(",", "."));
                	metodPagamento.setTotaleMandati(importoTotale);
                	mandati = new ArrayList<Mandato>();
                	mandati.add(parseMandato(paramTracciato));
                	metodPagamento.setMandati(mandati);
                	listMetodPagamenti.getMetodPag().add(metodPagamento);
                }
                else {
               		
               		metodPagamento = parseMetodoPag(paramTracciato);
               		importoTotale = importoTotale + Double.parseDouble(paramTracciato[32].replace(",", "."));
               		metodPagamento.setTotaleMandati(importoTotale);
                	mandati.add(parseMandato(paramTracciato));
                	metodPagamento.setMandati(mandati);
                	listMetodPagamenti.getMetodPag().add(metodPagamento);
                	nextMandato = paramTracciato[1];
                }
             
            }
           
        } catch(Exception e) {
           LoggingUtils.error(e);
            return null;
        } finally{
            br.close();
        }

        return listMetodPagamenti;
    }
	
	private static Mandato parseMandato(String[] paramTracciato) throws ParseException{
		
		Mandato mandato = new Mandato();
		//nuovo mandato
   	 	mandato.setNumeroProgressivo(paramTracciato[0]);
   	 	mandato.setDataValuta(DateUtils.getDate(paramTracciato[5], "yyyy-MM-dd"));
   	 	
   	 	mandato.setDataLiquidazione(DateUtils.getDate(paramTracciato[4], "yyyy-MM-dd"));
   	 		//indirizzo beneficiario
   	 	mandato.setBeneficiario(paramTracciato[14]);
   	 	mandato.setIndiBen(paramTracciato[15]);
   	 	mandato.setCapBen(paramTracciato[16]);
   	 	mandato.setCittaBen(paramTracciato[17]);
   	    mandato.setProvBen(paramTracciato[18]);
   	    	//altro destinatario
   	    mandato.setAltroDest(paramTracciato[20]);
   	    mandato.setIndiDest(paramTracciato[21]);
   	    mandato.setCapDest(paramTracciato[22]);
   		mandato.setCittaDest(paramTracciato[23]);
   		mandato.setProvDest(paramTracciato[24]);
   			//banca Iban
   		mandato.setBanca(paramTracciato[27]);
   		mandato.setIbanBanca(paramTracciato[40]);
   			//importo
   		mandato.setImporto(Double.parseDouble(paramTracciato[32].replace(",", ".")));
   		
   		return mandato;
	}
	
	private static MetodiPagamento parseMetodoPag(String[] paramTracciato) throws ParseException{
		MetodiPagamento metodPagamento = new MetodiPagamento();
		//nuovo mandato
		metodPagamento.setNumeroMandato(paramTracciato[1]);
    	metodPagamento.setDataMandato(DateUtils.getDate(paramTracciato[3], "yyyy-MM-dd"));
    	metodPagamento.setNumeroCollettiva(paramTracciato[6]);
    	metodPagamento.setTipoPagamento(paramTracciato[26].trim());
    		//dati contraente
    	metodPagamento.setContraente(paramTracciato[8].trim());
    	metodPagamento.setIndirizzo(paramTracciato[9].trim());
    	metodPagamento.setCap(paramTracciato[10]);
    	metodPagamento.setCitta(paramTracciato[11]);
    	metodPagamento.setProv(paramTracciato[12]);
   		
   		return metodPagamento;
	}

}
