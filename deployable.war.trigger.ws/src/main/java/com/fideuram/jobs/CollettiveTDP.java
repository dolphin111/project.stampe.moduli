package com.fideuram.jobs;

import java.io.File;
import java.io.IOException;

import javax.jms.JMSException;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.fideuram.exception.ConfigurationDirecotryException;
import com.fideuram.factory.FileManagerFactory;
import com.fideuram.factory.JmsFactory;
import com.fideuram.file.io.FileManager;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

/**
 * Created with
 * User: logan
 * Date: 13/05/13
 * Time: 10.28
 */
public class CollettiveTDP implements Job   {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LoggingUtils.debug("CollettiveTDP execute");
        try {
            printFiles();
        } catch (ConfigurationDirecotryException e) {
            LoggingUtils.info(e.getMessage());
        }
    }

    /**
     * Metodo di starting del processo di polling dei file CollettiveTDP.csv
     * @throws ConfigurationDirecotryException
     */
    public void printFiles() throws ConfigurationDirecotryException {
      LoggingUtils.debug("CollettiveTDP printFiles");
      String  dir =getObs0ervedDirectory();
      File[] files = FileManagerFactory.getFileFromDir(dir);
      send2Jobber(files);
    }


    /**
     * <br> Prende tutte le direcotry configurate tramite la properties:
     * <br> path.input.file.collettive"
     * <br> possono essere configurate più directory separate dal token ";"
     * @return
     */
    protected String getObs0ervedDirectory(){
        LoggingUtils.debug("CollettiveTDP getObs0ervedDirectory");
        String observedDir= CrmProperties.getProperty("path.collettive.input");
        LoggingUtils.debug("CollettiveTDP Obs0ervedDirectory " + observedDir);
        return observedDir;
    }



    private void send2Jobber(File files[]){
        LoggingUtils.debug("CollettiveTDP send2Jobber");
        for(int i=0; i<files.length;i++){
            File f = files[i];
            LoggingUtils.debug((new StringBuilder()).append("processo il file: ").append(f.getName()).toString());
            if(f.isDirectory())
                continue;
            else if(f.length()<=0){
            	try{
            	FileManager.move(f, CrmProperties.getProperty("path.collettive.ko"));
            	continue;
            	}
            	catch(IOException e){
            		LoggingUtils.info("Errore nello spostamento del file vuoto: "+e.getMessage());
            		continue;
            	}	
            }
            String destname = CrmProperties.getProperty("path.collettive.wk");
            try{
                FileManager.move(f, destname);
            }catch(IOException e){
                LoggingUtils.info(e.getMessage());
            }
            try{
                if(CrmProperties.getProperty("crm.test").equalsIgnoreCase("true"))
                    JmsFactory.send2Collettive((new StringBuilder()).append(destname).append(f.getName()).toString(), getIdentificativoProcesso(f), false);
                else
                    JmsFactory.send2Collettive((new StringBuilder()).append(destname).append(f.getName()).toString(), getIdentificativoProcesso(f), true);
                continue;
            }catch(JMSException e){
                LoggingUtils.error((new StringBuilder()).append("JMS ERROR ").append(e.getMessage()).toString());
                LoggingUtils.error((new StringBuilder()).append("ROLLBACK MV FILE TRANSACTION ").append(e.getMessage()).toString());
                try{
                    FileManager.move(f, CrmProperties.getProperty("path.collettive.input"));
                }catch(IOException e1){
                    LoggingUtils.error("Error move file: "+e.getMessage());
                }
            }catch(Exception e){
            	e.printStackTrace();
            	LoggingUtils.error("Errore generico: send2Jobber method " + e.getMessage()+ "_ t" + e.getStackTrace().toString());
            }
            
        }
    }

    //	identifica il processo da chiamare a seconda del nome del file
    private int getIdentificativoProcesso(File file){
    	int result;
    	if(file.getName().contains("ElenchiUfficiali_U"))
    		result = 905;
    	else if(file.getName().contains("ElenchiUfficiali_T"))
    		result = 906;
    	else if(file.getName().contains("VG715"))
    		result = 903;
    	else if(file.getName().contains("VG710") ||
    			file.getName().contains("VG714") ||
    			file.getName().contains("VG716") ||
    			file.getName().contains("VG801") ||
    			file.getName().contains("VUL01"))
    		result = 904;
    	else if(file.getName().contains("VD101"))
    		result = !file.getName().contains("SCARTI") ? 902 : 901;
    	else
    		result = 0;
        return result;
    }
    

}
