package com.fideuram.dao.tdp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.modello.tdp.Collettive;
import com.fideuram.modello.tdp.elaborati.RiepilogoTDP;
import com.fideuram.modello.tdp.scarti.ScartoTDP;
import com.fideuram.utils.LoggingUtils;

/**
 * Created by
 * User: logan
 * Date: 09/05/13
 * Time: 10.02
 */
public class TdpParserCsv {
    public static Collettive parseScartoTDP(String filename) throws CollettiveFileDataReadException, IOException{
        Collettive collettive = new Collettive();
        BufferedReader br = null ;
        try {
            List<ScartoTDP> scartoTDPs =  new ArrayList<ScartoTDP>();

            br = new BufferedReader( new FileReader(filename) );
            String line = "";
            StringTokenizer token = null;
            int lineNum = 0, tokenNum = 0;

            while((line = br.readLine()) != null) {
                ScartoTDP scarto = new ScartoTDP();
                lineNum++;
                LoggingUtils.debug("posizione Linea del file #" + lineNum);

                // break comma separated file line by line
                token = new StringTokenizer(line, ";");

                if(token.countTokens()<9){
                   throw new CollettiveFileDataReadException();
                }else{
                   scarto.setCollettiva(token.nextToken());
                   scarto.setElenco(token.nextToken());
                   scarto.setPolizza(token.nextToken());
                   scarto.setAppendice(token.nextToken());
                   scarto.setTariffa(token.nextToken());
                   scarto.setIngresso(token.nextToken());
                   scarto.setDataDecorrenza(new Date(token.nextToken()));
                   scarto.setDataScadenza(new Date(token.nextToken()));
                   scarto.setDescrizione(token.nextToken());
                }
                scartoTDPs.add(scarto);
            }
            collettive.setScarti(scartoTDPs);
           
        } catch(Exception e) {
        	LoggingUtils.error("Parse Error: " + e.getMessage());
        	br.close();
       		return null ;
        }
        finally{
        	br.close();
        }
        
        return collettive;
        
    }


    public static Collettive parseRiepilogoTDP(String filename) throws CollettiveFileDataReadException, IOException{
        Collettive collettive = new Collettive();
        BufferedReader br = null;
        try {
            List<RiepilogoTDP> riepilogoTDPs =  new ArrayList<RiepilogoTDP>();

            br = new BufferedReader( new FileReader(filename) );
            String line = "";
            StringTokenizer token = null;
            int lineNum = 0, tokenNum = 0;

            while((line = br.readLine()) != null) {
                RiepilogoTDP riepilogoTDP = new RiepilogoTDP();
                lineNum++;
                LoggingUtils.info("posizione Linea del file #" + lineNum);

                // break comma separated file line by line
                token = new StringTokenizer(line, ";");

                if(token.countTokens()!=5){
                    throw new CollettiveFileDataReadException();
                }else{
                    riepilogoTDP.setCollettiva(token.nextToken());
                    riepilogoTDP.setElenco(token.nextToken());
                    riepilogoTDP.setRataLorda(token.nextToken());
                    riepilogoTDP.setNumeroGaranzie(token.nextToken());
                    String data=token.nextToken().trim();
                    riepilogoTDP.setDataDecorrenza(FormatterFactory.getDate(data));
                    //riepilogoTDP.setDataDecorrenza(new Date(token.nextToken().trim()));


                }
                riepilogoTDPs.add(riepilogoTDP);
            }
            collettive.setRiepiloghi(riepilogoTDPs);
           
        } catch(Exception e) {
            LoggingUtils.error("Parse Error: " + e.getMessage());
            return null;
        }
        finally{
        	 br.close();
        }
       
        return collettive;
    }

}
