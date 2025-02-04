package com.fideuram.dao.elenchiufficiali;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.elenchiufficiali.ElenchiUfficiali;
import com.fideuram.modello.elenchiufficiali.ramo.Contribuente;
import com.fideuram.modello.elenchiufficiali.ramo.Importi;
import com.fideuram.modello.elenchiufficiali.ramo.Intestazione;
import com.fideuram.modello.elenchiufficiali.ramo.Ramo;
import com.fideuram.modello.elenchiufficiali.ramo.TitoliBody;
import com.fideuram.modello.elenchiufficiali.ramo.primo.RamoPrimoBody;
import com.fideuram.modello.elenchiufficiali.ramo.terzo.RamoTerzoBody;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

public class ElenchiUfficialiParseCsv {
	
	
	public static ElenchiUfficiali parseElenchiUfficiali(String fileName) throws IOException{
		
		ElenchiUfficiali result = new ElenchiUfficiali();
		boolean isRamoPrimo = ElenchiUfficialiParseCsv.isRamoPrimo(fileName);
		BufferedReader br = null;
		List<TitoliBody> titoliBodyList = null;
		List<Ramo> bodyRamoList = new ArrayList<Ramo>();
		
		String[] paramTracciato = null;
		
		try{
			 br = new BufferedReader( new FileReader(fileName) );
			 String line = "";
			 
			 int lineNum = 0, tokenNum = 0;
			 
			  while((line = br.readLine()) != null) {
				  line.trim();
	              lineNum++;
	              LoggingUtils.debug("posizione Linea del file #" + lineNum);
	              // break comma separated file line by line
	              paramTracciato = line.split(";");
	              
	              if(paramTracciato.length <= 1)
	                	 break;
	              if(lineNum == 1 && paramTracciato.length < 35){
	                	System.out.println(paramTracciato.length);
	                    throw new CollettiveFileDataReadException("length del tracciato intestazione non valida");
	              }
	              else if(lineNum == 1){
	            	  Intestazione intestazione = parseIntestElenchiUfficiali(paramTracciato, isRamoPrimo);
	            	  result.setIntestazione(intestazione);
	              }
//	              else{
//	            	  if(lineNum == 2){
//	            		  if(isRamoPrimo && paramTracciato.length < 41)
//	            			  throw new CollettiveFileDataReadException("length del tracciato ramo primo non valida, ["+paramTracciato.length+"]");
//	            		  else if(!isRamoPrimo && paramTracciato.length < 32)
//	            			  throw new CollettiveFileDataReadException("length del tracciato ramo terzo non valida, ["+paramTracciato.length+"]");
//	            		  
//	            		  titoliBodyList = parseTitoliElenchiUfficiali(paramTracciato, isRamoPrimo);
//	            		  result.setTitoliBody(titoliBodyList);
//	            	  }
//	            	  Contribuente contribuente = parseContribuenteElenchiUfficiali(paramTracciato, isRamoPrimo);
//	            	  
//	            	  if(isRamoPrimo){
//	            		  RamoPrimoBody bodyRamoPrimo = parseRamoPrimoBody(paramTracciato);
//	            		  
//	            		  bodyRamoPrimo.setContr(contribuente);
//	            		  bodyRamoList.add(bodyRamoPrimo);
//	            	  }
//	            	  else{
//	            		  RamoTerzoBody bodyRamoTerzo = parseRamoTerzoBody(paramTracciato);
//	            		  
//	            		  bodyRamoTerzo.setContr(contribuente);
//	            		  bodyRamoList.add(bodyRamoTerzo);
//	            	  }
//	              }
			  }
//			  result.setRamo(bodyRamoList);
			  
		}
		catch(CollettiveFileDataReadException e){
			e.printStackTrace();
			LoggingUtils.error("parametri non corretti: ramo ["+isRamoPrimo+"], lunghezza tracciato["+paramTracciato.length+"]");
		}
		catch(Exception e){
			e.printStackTrace();
			LoggingUtils.error("Errore nel parse del file________>"+e.getMessage());
		}
		finally{
			br.close();
		}
		return result;
	}
	
	private static Contribuente parseContribuenteElenchiUfficiali(
			String[] paramTracciato, boolean isRamoPrimo) {
		Contribuente result = new Contribuente();
		
		result.setPosizione(paramTracciato[3]);
		result.setCogn(paramTracciato[4]);
		result.setNome(paramTracciato[5]);
		result.setDatNas(paramTracciato[6]);
		result.setCodFis(paramTracciato[7]);
		result.setSesso(paramTracciato[8]);
		result.setDatDecor(isRamoPrimo?FormatterFactory.getDate(paramTracciato[11]):FormatterFactory.getDate(paramTracciato[9]));
		return result;
	}

	private static RamoTerzoBody parseRamoTerzoBody(String[] paramTracciato) {
		RamoTerzoBody result = new RamoTerzoBody();
		result.setNumConvenzione(paramTracciato[0]);
		
		result.setCodGest(paramTracciato[10]);
		result.setCodFon(paramTracciato[11]);
		result.setValNav(paramTracciato[12]);
		result.setNumQuote(paramTracciato[13]);
		result.setImpNettInv(NumberUtils.parseDouble(paramTracciato[14],".",","));
		result.setCodEmis(paramTracciato[15]);
		result.setIndTipPrest(paramTracciato[16]);
		
		result.setImpCapit(NumberUtils.parseDouble(paramTracciato[17],".",","));
		result.setImpRend(NumberUtils.parseDouble(paramTracciato[18],".",","));
		result.setCoefConvRen(paramTracciato[19]);
		result.setTipoRend(paramTracciato[20]);
		result.setImpRisMat(NumberUtils.parseDouble(paramTracciato[21],".",","));
		result.setDurResMin(paramTracciato[22]);
		result.setDurResMax(paramTracciato[23]);
		result.setCodClasTar(paramTracciato[24]);
		result.setAnniDif(paramTracciato[25]);
		result.setMesiDif(paramTracciato[26]);
		result.setDurataDif(paramTracciato[27]);
		result.setPremTar(paramTracciato[28]);
		result.setCodForAss(paramTracciato[29]);
		result.setDatFineDiff(FormatterFactory.getDate(paramTracciato[30]));
		result.setPreAnnuiPre(paramTracciato[31]);
		
		
		return result;
	}

	private static RamoPrimoBody parseRamoPrimoBody(String[] paramTracciato) {
		RamoPrimoBody result = new RamoPrimoBody();
		
		result.setAnniAss(paramTracciato[9]);
		result.setMesiAss(paramTracciato[10]);
		result.setCodClasTar(paramTracciato[12]);
		result.setAnniDif(paramTracciato[13]);
		result.setMesiDif(paramTracciato[14]);
		result.setDurDec(paramTracciato[15]);
		result.setPremTar(paramTracciato[16]);
		result.setCodForAss(paramTracciato[17]);
		result.setFraz(paramTracciato[18]);
		
		result.setImpPremio(NumberUtils.parseDouble(paramTracciato[19], ".", ","));
		result.setImpRataNetta(NumberUtils.parseDouble(paramTracciato[20], ".", ","));
		result.setImpReiRis(NumberUtils.parseDouble(paramTracciato[21], ".", ","));
		result.setImpAbbuono(NumberUtils.parseDouble(paramTracciato[22], ".", ","));
		result.setImpCapitale(NumberUtils.parseDouble(paramTracciato[23], ".", ","));
		result.setImpRendita(NumberUtils.parseDouble(paramTracciato[24], ".", ","));
		result.setImpDip(NumberUtils.parseDouble(paramTracciato[25], ".", ","));
		result.setImpAzi(NumberUtils.parseDouble(paramTracciato[26], ".", ","));
		result.setImpVol(NumberUtils.parseDouble(paramTracciato[27], ".", ","));
		result.setImpTfr(NumberUtils.parseDouble(paramTracciato[28], ".", ","));
		
		result.setPercSan(NumberUtils.parseDouble(paramTracciato[29], ".", ","));
		result.setPercSpo(NumberUtils.parseDouble(paramTracciato[30], ".", ","));
		result.setPercProf(NumberUtils.parseDouble(paramTracciato[31], ".", ","));
		result.setPercRis(NumberUtils.parseDouble(paramTracciato[32], ".", ","));
		result.setPercInval(NumberUtils.parseDouble(paramTracciato[33], ".", ","));
		
		result.setCodEmi(paramTracciato[34]);
		result.setDataDiff(FormatterFactory.getDate(paramTracciato[35]));
		result.setCodTarCompl(paramTracciato[36]);
		result.setImpRataNetta(NumberUtils.parseDouble(paramTracciato[37], ".", ","));
		result.setTipoPrestaz(paramTracciato[38]);
		result.setCodFondo(paramTracciato[39]);
		result.setDurPre(paramTracciato[40]);
		
		return result;
	}

	private static List<TitoliBody> parseTitoliElenchiUfficiali(String[] paramTracciato,boolean isRamoPrimo) {
		ArrayList<TitoliBody> result = new ArrayList<TitoliBody>();
		TitoliBody titoli1 = new TitoliBody();
		TitoliBody titoli2 = new TitoliBody();
		TitoliBody titoli3 = new TitoliBody();
		
		String codiceEmissione = null;
		boolean isPremioUnico = false;
		String codiceFormaAss = null;
		String durataDecorrenza = null;
		
		//prima riga titoli statici
		//LABEL A
		titoli1.setLabelA("Posizione");
		titoli2.setLabelA("");
		titoli3.setLabelA("");
		//LABEL B
		titoli1.setLabelB("Assicurato");
		titoli2.setLabelB("Data Nascita");
		titoli3.setLabelB("");
		//LABEL C
		titoli1.setLabelC("");
		titoli2.setLabelC("Codice Fiscale");
		titoli3.setLabelC("");
		//LABEL D
		titoli1.setLabelD("");
		titoli2.setLabelD("S");
		titoli3.setLabelD("");
		//LABEL E
		titoli1.setLabelE("Decorrenza");
		titoli2.setLabelE("");
		
		//Ramo I
		if(isRamoPrimo){
			codiceFormaAss = paramTracciato[17];
			codiceEmissione = paramTracciato[34];
			isPremioUnico =  paramTracciato[16].equalsIgnoreCase("A")?false:true; //U = unico
			durataDecorrenza = paramTracciato[15];
			//Label F
			titoli1.setLabelF("Età");
			
			if(codiceFormaAss.equalsIgnoreCase("M") && !paramTracciato[11].equalsIgnoreCase("")){
				titoli2.setLabelF("Nr. Premi");
				titoli3.setLabelF("");
			}
			else if(codiceFormaAss.equalsIgnoreCase("V") && !paramTracciato[11].equalsIgnoreCase("")){
				titoli3.setLabelE("Fine diff.to");
				
				titoli2.setLabelF("Diff.to");
				titoli3.setLabelF("aa/mm");
			}
			else if(paramTracciato[12].equalsIgnoreCase("TE") && paramTracciato[12].equalsIgnoreCase("GR")){
				titoli3.setLabelE("Scadenza");
				
				titoli2.setLabelF("Durata");
				if(Integer.getInteger(durataDecorrenza).intValue()>=1)
					titoli3.setLabelF("aa/mm");
				else
					titoli3.setLabelF("Giorni");
			}
			//Label G
			if(paramTracciato[38].equals("R")){ //codice prestazione TRF
				titoli1.setLabelG("Rendita");
				titoli2.setLabelG("assicurata");
				titoli3.setLabelG("");
			}
			else { //Rendita = "R"
				titoli1.setLabelG("Capitale");
				titoli2.setLabelG("assicurato");
				titoli3.setLabelG("");
			}
			//Label H e J
			if(isPremioUnico){
				titoli1.setLabelH("PU netto");
				titoli2.setLabelH("");
				titoli3.setLabelH("");
				
				titoli1.setLabelJ("Premio unico");
				titoli2.setLabelJ("lordo");
				titoli3.setLabelJ("");
				
				if(codiceEmissione.equalsIgnoreCase("82") ||
				   codiceEmissione.equalsIgnoreCase("89") ||
				   codiceEmissione.equalsIgnoreCase("84")){
					titoli1.setLabelH("Capitale in");
					titoli2.setLabelH("caso di morte");
					titoli1.setLabelJ("Riserva");
					titoli2.setLabelJ("Trasferita");
				}
				
			}
			else{ //premio annuale
				titoli1.setLabelH("PA netto");
				titoli2.setLabelH("");
				titoli3.setLabelH("");
				
				titoli1.setLabelJ("Rata premio");
				titoli2.setLabelJ("lorda");
				titoli3.setLabelJ("");
				
				if(codiceEmissione.equalsIgnoreCase("82") ||
						   codiceEmissione.equalsIgnoreCase("89") ||
						   codiceEmissione.equalsIgnoreCase("84")){
							titoli1.setLabelH("Capitale in");
							titoli2.setLabelH("caso di morte");
							titoli3.setLabelH("");
							
							titoli1.setLabelJ("Riserva");
							titoli2.setLabelJ("Trasferita");
							titoli3.setLabelJ("");
						}
				
			}
			//label L 
			//in caso di Reintegro Riserva o Abbuono > di 0
			//altrimenti non esiste la colonna
			//paramTracciato[21] = Importo Reintegro di riserva Matematica
			if(new Double(paramTracciato[21]).doubleValue()>0){
				titoli1.setLabelL("Reintegro di");
				titoli2.setLabelL("ris. mat.");
				titoli3.setLabelL("");
				
			}
			//paramTracciato[22] = Importo Abbuono
			else if(new Double(paramTracciato[22]).doubleValue()>0){
				titoli1.setLabelL("Abbuono");
				titoli2.setLabelL("di premio");
				titoli3.setLabelL("");
			}
			else{
				titoli1.setLabelL("");
				titoli2.setLabelL("");
				titoli3.setLabelL("");
			}
			//Label M
			//se la tariffa è caso vita altrimenti la colonna M non esiste
			if(paramTracciato[17].equalsIgnoreCase("V")){
				titoli1.setLabelM("Sp");
				titoli2.setLabelM("%");
				titoli3.setLabelM("");
			}
			else{
				titoli1.setLabelM("");
				titoli2.setLabelM("");
				titoli3.setLabelM("");
			}
			
		}
		//ramo III
		else{
			codiceFormaAss = paramTracciato[29];
			codiceEmissione = paramTracciato[15];
			isPremioUnico =  paramTracciato[28].equalsIgnoreCase("A")?false:true;
			durataDecorrenza = paramTracciato[27];
			
			if(codiceFormaAss.equalsIgnoreCase("M") && !paramTracciato[11].equalsIgnoreCase("")){
				titoli2.setLabelF("Nr. Premi");
				titoli3.setLabelF("");
			}//codice forma assicurativa
			else if(codiceFormaAss.equalsIgnoreCase("V") && !paramTracciato[11].equalsIgnoreCase("")){
				titoli3.setLabelE("Fine diff.to");
				
				titoli2.setLabelF("Diff.to");
				titoli3.setLabelF("aa/mm");
			}//codice classificazione tariffa
			else if(paramTracciato[24].equalsIgnoreCase("TE") && paramTracciato[24].equalsIgnoreCase("GR")){
				titoli3.setLabelE("Scadenza");
				
				titoli2.setLabelF("Durata");
				if(Integer.getInteger(durataDecorrenza).intValue()>=1)
					titoli3.setLabelF("aa/mm");
				else
					titoli3.setLabelF("Giorni");
			}
			
			//Label F, G
			if(codiceEmissione.equalsIgnoreCase("10")){
				if(paramTracciato[16].equals("C")){
					titoli1.setLabelF("Capitale min. gar.");
					titoli2.setLabelF("");
					titoli3.setLabelF("");
				}
				else{
					titoli1.setLabelF("Rendita min. gar.");
					titoli2.setLabelF("Tipo rendita(*)/Coeff.");
					titoli3.setLabelF("");
				}
				
				titoli1.setLabelG("Premio Unico");
				titoli2.setLabelG("investito");
				titoli3.setLabelG("");
			}
			else if(codiceEmissione.equals("82")){
				titoli1.setLabelF("Rendita min. gar.");
				titoli2.setLabelF("Tipo rendita(*)/Coeff.");
				titoli3.setLabelF("");
				titoli1.setLabelG("Riserva");
				titoli2.setLabelG("trasferita");
				titoli3.setLabelG("");
			}
			//Label H
			titoli1.setLabelH("Fondo Interno");
			titoli2.setLabelH("Valore NAV");
			titoli3.setLabelH("");
			//Label J
			titoli1.setLabelJ("N. Quote");
			titoli2.setLabelJ("attribuite");
			titoli3.setLabelJ("");
			//colonna L non presente
			titoli1.setLabelL("");
			titoli2.setLabelL("");
			titoli3.setLabelL("");
			//colonna M non presente
			titoli1.setLabelM("");
			titoli2.setLabelM("");
			titoli3.setLabelM("");
			
		}
		result.add(titoli1);
		result.add(titoli2);
		result.add(titoli3);
		
		return result;
	}

	private static Intestazione parseIntestElenchiUfficiali(String[] paramTracciato,boolean isRamoPrimo) throws IOException{
		Intestazione intestazione = new Intestazione();
		intestazione.setRamoPrimo(isRamoPrimo);
		try{
        	  intestazione.setNumConvenzione(paramTracciato[0]);
        	  intestazione.setNumElenco(paramTracciato[1]);
        	  //numero elenco
        	  intestazione.setCodCollettiva(paramTracciato[2]);
        	  intestazione.setNumAgenzia(paramTracciato[3]);
        	  //contraente
        	  intestazione.setCognome(paramTracciato[5]);
        	  intestazione.setNome(paramTracciato[6]);
        	  intestazione.setCodFisc(paramTracciato[7]);
        	  //sede sociale
        	  intestazione.setCitta(paramTracciato[8]);
        	  intestazione.setProv(paramTracciato[9]);
        	  intestazione.setCap(paramTracciato[10]);
        	  intestazione.setInd(paramTracciato[11]);
        	  //tariffa
        	  intestazione.setNumTariffa(paramTracciato[12]);
        	  intestazione.setDescTariffa(paramTracciato[13]);
        	  intestazione.setDataEmissione(DateUtils.getDate(paramTracciato[14], "dd/MM/yyyy"));
        	  String isPremioUnico = paramTracciato[15];
        	  if(isPremioUnico.equalsIgnoreCase("U"))
        		  intestazione.setPremioUnico(true);
        	  else //annuale= "A"
        		  intestazione.setPremioUnico(false);
        	  intestazione.setPremioTariffa(paramTracciato[15]);
        	  intestazione.setCodiceEmissione(paramTracciato[16]);
        	  intestazione.setDataInizioCopertura(DateUtils.getDate(paramTracciato[17], "dd/MM/yyyy"));
        	  intestazione.setDataDecorrenza(DateUtils.getDate(paramTracciato[18], "dd/MM/yyyy"));
        	  intestazione.setDataRiferimentoNav(DateUtils.getDate(paramTracciato[19], "dd/MM/yyyy"));
        	  intestazione.setCodiceFondo(paramTracciato[20]);
        	  intestazione.setFrazionamentoPremio(paramTracciato[21]);
        	  intestazione.setCodicePrestazione(paramTracciato[34]);
        	  intestazione.setImportoValoreLordo(NumberUtils.parseDouble(paramTracciato[26], ".", ","));
        	  if(isRamoPrimo)
        		  intestazione.setImportiRI(setRiepilogoImporti(paramTracciato, intestazione.isPremioUnico()));
		}
		catch(Exception e) {
	           LoggingUtils.error("Parse Error: " + e.getMessage());
	           e.printStackTrace();
	           return null;
	    } 
		
		return intestazione;
	}

	private static List<Importi> setRiepilogoImporti(String[] paramTracciato, boolean isPremioAnnuale){
		ArrayList<Importi> importi  = new ArrayList<Importi>();
		
		if(paramTracciato[28]!=null && !"".equals(paramTracciato[28])){
			Double importoAbbuono = new Double(NumberUtils.parseDouble(paramTracciato[28], ".", ","));
			if(importoAbbuono.doubleValue()!=0.0){
				Importi impAbbuono= new Importi("Abbuono di Premio", importoAbbuono);
				importi.add(impAbbuono);
			}	
		}
		if(paramTracciato[29]!=null && !"".equals(paramTracciato[29])){
			Double importoReintegro = new Double(NumberUtils.parseDouble(paramTracciato[29], ".", ","));
			if(importoReintegro.doubleValue()!=0.0){
				Importi impReintRiserva= new Importi("Reintegro di Riserva Matematica", importoReintegro);
				importi.add(impReintRiserva);
			}	
		}
		if(paramTracciato[27]!=null && !"".equals(paramTracciato[27])){
			Double importoRischio = new Double(NumberUtils.parseDouble(paramTracciato[27], ".", ","));
			if(importoRischio.doubleValue()!=0.0){
				Importi impRischioCat= new Importi("Premio Rischio Catastrofale", importoRischio);
				importi.add(impRischioCat);
			}	
		}
		if(paramTracciato[30]!=null && !"".equals(paramTracciato[30])){
			Double accessoriPolizza = new Double(NumberUtils.parseDouble(paramTracciato[30], ".", ","));
			if(accessoriPolizza.doubleValue()!=0.0){
				Importi impAccessori= new Importi("Accessori di Polizza", accessoriPolizza);
				importi.add(impAccessori);
			}	
		}
		if(paramTracciato[31]!=null && !"".equals(paramTracciato[31])){
			Double imposte = new Double(NumberUtils.parseDouble(paramTracciato[31], ".", ","));
			if(imposte.doubleValue()!=0.0){
				Importi impImposte= new Importi("Imposte", imposte);
				importi.add(impImposte);
			}	
		}
		if(isPremioAnnuale){
			Double importoNetto = importoNetto(NumberUtils.parseDouble(paramTracciato[32], ".", ","),
											   NumberUtils.parseDouble(paramTracciato[29], ".", ","), 
											   NumberUtils.parseDouble(paramTracciato[28], ".", ","));
			Importi netto= new Importi("Rata Netta Vita", importoNetto);
			importi.add(netto);
			
			if(paramTracciato[26]!=null && !"".equals(paramTracciato[26])){
				Double lordo = new Double(NumberUtils.parseDouble(paramTracciato[26], ".", ","));
				if(lordo.doubleValue()!=0.0){
					Importi impLordi= new Importi("Rata Lorda", lordo);
					importi.add(impLordi);
				}	
			}
			if(paramTracciato[33]!=null && !"".equals(paramTracciato[33])){
				Double complementare = new Double(NumberUtils.parseDouble(paramTracciato[33], ".", ","));
				if(complementare.doubleValue()!=0.0){
					Importi impComplementare= new Importi("Rata Netta Complementare", complementare);
					importi.add(impComplementare);
				}	
			}
		}
		else{ //premio Unico
			Double importoNetto = importoNetto(
					NumberUtils.parseDouble(paramTracciato[32], ".", ","),
					NumberUtils.parseDouble(paramTracciato[29], ".", ","),
					NumberUtils.parseDouble(paramTracciato[28], ".", ","));
			Importi netto = new Importi("Premio Netto Vita", importoNetto);
			importi.add(netto);

			if (paramTracciato[26] != null && !"".equals(paramTracciato[26])) {
				Double lordo = new Double(NumberUtils.parseDouble(
						paramTracciato[26], ".", ","));
				if (lordo.doubleValue() != 0.0) {
					Importi impLordi = new Importi("Premio Lorda", lordo);
					importi.add(impLordi);
				}
			}
			if (paramTracciato[33] != null && !"".equals(paramTracciato[33])) {
				Double complementare = new Double(NumberUtils.parseDouble(
						paramTracciato[33], ".", ","));
				if (complementare.doubleValue() != 0.0) {
					Importi impComplementare = new Importi(
							"Premio Netto Complementare", complementare);
					importi.add(impComplementare);
				}
			}
		}
		return importi;
	}
	
	private static boolean isRamoPrimo(String fileName){
		boolean result = false;
		if (fileName.contains("_T_"))//"U" = ramo 3
			result = true;
		return result;
	}
	
	private static Double importoNetto(Double rataNetta, Double impReintegro, Double impAbbuono){
		Double result = rataNetta - (impReintegro + impAbbuono);
		return result;
	}
}
