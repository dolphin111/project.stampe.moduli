package com.fideuram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;

import com.fideuram.exception.StampaCollettiveException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.file.io.FileManager;
import com.fideuram.manager.elenchiufficiali.CollettiveRamoManager;
import com.fideuram.manager.metodiPagamento.MetodiPagamentoManager;
import com.fideuram.manager.tdp.TDPManagerRiepilogo;
import com.fideuram.manager.tdp.TDPManagerScarti;
import com.fideuram.manager.vgitext.VGITextManager;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;
import com.itextpdf.text.Document;

/**
 * Created with
 * User: logan
 * Date: 14/05/13
 * Time: 10.55
 */
public class FacadeCollettive {

    public void printCollettiva(String file, int processo) {
    	LoggingUtils.info("printCollettiva method --> file:["+file+"], processo["+processo+"]" );
        File f = new File(file);
        String repo = "";
        String storicoInput = "";
        byte[] pdf=null;
        Document documentIText = null;
        String macroPratica="";
        if (f.exists() && f.length()>0){
            try{
                switch (processo){
                    case 901:
                        pdf=TDPManagerScarti.getPdfScartiTDP(f);
                        repo=CrmProperties.getProperty("path.collettive.tdp.pdf.repo");
                        storicoInput = CrmProperties.getProperty("path.collettive.tdp.ok");
                        this.archiviazione(processo, pdf, repo, storicoInput, f);
                        break;
                    case 902:
                        pdf=TDPManagerRiepilogo.getPdfRiepilogoTDP(f);
                        repo=CrmProperties.getProperty("path.collettive.tdp.pdf.repo");
                        storicoInput = CrmProperties.getProperty("path.collettive.tdp.ok");
                        this.archiviazione(processo, pdf, repo, storicoInput, f);
                        break;
                    case 903:
                    	pdf=MetodiPagamentoManager.getPdfMetodiPagamento(f);
                    	repo=CrmProperties.getProperty("path.collettive.mpagamenti.repo");
                    	storicoInput = CrmProperties.getProperty("path.collettive.mpagamenti.ok");
                    	this.archiviazione(processo, pdf, repo, storicoInput, f);
                    	break;
                    case 904:
                    	
                    	//inserimento numero macropratica nel nome del file
                    	macroPratica=getMacropratica(f);
                    	String newFName=f.getName().replace(".txt", "");
                    	newFName= newFName+"_"+macroPratica+".txt";
                    	File newF= new File(f.getAbsolutePath().replace(f.getName(), "").concat(newFName));
                    	FileUtils.copyFile(f, newF);
                    	//
                    	
                    	documentIText=VGITextManager.print(newF);
                    	String folderName = f.getName().substring(0, 5);
                    	if(f.getName().contains("VUL01"))
                    		repo=CrmProperties.getProperty("path.collettive.vgitext.vul01")+folderName+"/";
                    	else	
                    		repo=CrmProperties.getProperty("path.collettive.vgitext")+folderName+"/";
                    	storicoInput = repo+"StoricoInput/";
                    	this.archiviazione(processo, pdf, repo, storicoInput, newF);
            	        FileUtils.forceDelete(f);
                    	break;
                    case 905: //ramo III
                    	if(f.getName().contains(".csv"))
                    		break;
                    	pdf=CollettiveRamoManager.getPdfElenchiUfficiali(f, false);
                    	repo=CrmProperties.getProperty("path.collettive.elenchiuff.pdf.repo");
                    	storicoInput = CrmProperties.getProperty("path.collettive.elenchiuff.ok");
                    	moveFileCSVElenchiUfficiali(new File(f.getAbsolutePath().replace(".txt", ".csv")),repo);
                    	this.archiviazione(processo, pdf, repo, storicoInput, f);
                    	break;
                    case 906: //ramo I
                    	if(f.getName().contains(".csv"))
                    		break;
                    	pdf=CollettiveRamoManager.getPdfElenchiUfficiali(f, true);
                    	repo=CrmProperties.getProperty("path.collettive.elenchiuff.pdf.repo");
                    	storicoInput = CrmProperties.getProperty("path.collettive.elenchiuff.ok");
                    	moveFileCSVElenchiUfficiali(new File(f.getAbsolutePath().replace(".txt", ".csv")),repo);
                    	this.archiviazione(processo, pdf, repo, storicoInput, f);
                    	break;
                }
                
            } catch (StampaCollettiveException e) {
                LoggingUtils.error("Errore durante la Stampa di: " + file, e);
                saveError(f);
            } catch (URISyntaxException e) {
                LoggingUtils.error("Errore durante la save del PDF relativo a: " + file, e);
                saveError(f);
            } catch (Exception e) {
                LoggingUtils.error("Errore durante la save del PDF relativo a: " + file, e);
                saveError(f);
            }

        }else{
        	LoggingUtils.info("IL FILE NON ESISTE O HA UNA LENGTH PARI A 0");
        	try{
        		FileUtils.copyFileToDirectory(f, new File(CrmProperties.getProperty("path.collettive.tdp.ok")));
        		this.removeFile(f);
        	}
        	catch(IOException e){
        		LoggingUtils.error("Errore durante la copia del file relativo a: " + file, e);
        	}
        }
    }
    
    
    private String getMacropratica(File f) throws FileNotFoundException{
    	
    	Scanner in = new Scanner(f);
    	 String macropratica="";
    	 boolean trovato= false;
    	 long mp=0;
    	 try{
	    	 while (in.hasNextLine())
	    	 { 
	    		 if(trovato==true )
	    			 break;
	    		 
		    	 String line = in.nextLine();
		    	 Scanner t = new Scanner(line);
		    	 while (t.hasNext())
		    	 {
			    	if( t.next().contains("MACROPRATICA"))
			    	{
			    		mp=t.nextInt();
			    		trovato=true;
			    		break;
			    	}
			    	 
		    	 }
	    	 }
    	 }catch (Exception e){
    		 LoggingUtils.error("Errore durante la lettura del file ");
    	 }
    	 in.close();
    	macropratica= String.valueOf(mp);
    	return macropratica;	
    }
    
    
    
    private void archiviazione(int processo, byte[] pdf, String repOutput, String repInput, File f){
    	
    	LoggingUtils.info("path repository file:["+repOutput+"]");
    	try{
	        if(processo!=904)
	        	StreamerFactory.saveFile(pdf,repOutput,getPdfFileName(f));
	
	        Thread.sleep(5000);
	        FileManager.move(f, repInput);
    	}
        catch (IOException e) {
            LoggingUtils.error("IOException durante la save del PDF relativo a: " + f.getAbsolutePath(), e);
            saveError(f);
        }
    	catch (InterruptedException e){
    		LoggingUtils.error("InterruptedException durante la save del PDF relativo a: " + f.getAbsolutePath(), e);
            saveError(f);
    	} catch (Exception e) {
    		LoggingUtils.error("Errore generico durante la save del PDF relativo a: " + f.getAbsolutePath(), e);
    		saveError(f);
		}
    }
       
    protected void removeFile(File fileIn) {
		if (!fileIn.isDirectory()) {
			LoggingUtils.info("  Remove File Init >>" + fileIn.getName());
			try{
			fileIn.delete();
			LoggingUtils.info("  Remove File End >>" + fileIn.getName());
			}
			catch(Exception e){
				LoggingUtils.error("  Remove File Error >>" + fileIn.getName()+", message:["+e.getMessage()+"]");
				saveError(fileIn);
			}	
		}
	}
    
    protected void moveFileCSVElenchiUfficiali(File fileIn, String storicoOutput) {
		if (!fileIn.isDirectory()) {
			LoggingUtils.info("  Move File CSV Init >>" + fileIn.getName());
			try{
				FileManager.move(fileIn, storicoOutput);
			LoggingUtils.info("  Remove File End >>" + fileIn.getName());
			}
			catch(Exception e){
				LoggingUtils.error("  Remove File Error >>" + fileIn.getName()+", message:["+e.getMessage()+"]");
				saveError(fileIn);
			}	
		}
	}

    private void saveError(File f){
        try {
            FileManager.move(f, CrmProperties.getProperty("path.collettive.ko"));
        } catch (IOException e) {
            LoggingUtils.error("Errore durante il savlataggio del file nella dir di Errore " + f.getName(), e);
        }
    }

    private String getPdfFileName(File file) throws IOException {
        String  nome = file.getName().toUpperCase().replace(".TXT", ".PDF");
        LoggingUtils.info("nome file in elaborazione: ["+nome+"]");
        return nome;
    }

    public static void main(String args[]){
        //new FacadeCollettive().printCollettiva("C:\\\\Fideuram\\AutomazioneCollettive\\INPUT\\VD101_R1_ElenchiUfficiali5985_2004062013_035303.txt",902);
        System.out.println(" ----------------->FINE ELABORAZIONE RIEPILOGO<---------------------");
        new FacadeCollettive().printCollettiva("C:\\Fideuram\\configCRM\\Collettive\\INPUT\\VG714_DATICON_130628_085244681.txt",904);
        new FacadeCollettive().printCollettiva("C:\\Fideuram\\configCRM\\Collettive\\INPUT\\VG714_DATICON_130628_085244682.txt",904);

 }
}
