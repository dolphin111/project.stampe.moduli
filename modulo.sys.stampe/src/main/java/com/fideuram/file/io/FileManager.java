package com.fideuram.file.io;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.fideuram.exception.ConfigurationDirecotryException;
import com.fideuram.utils.LoggingUtils;

/**
 * Created with IntelliJ IDEA.
 * User: logan
 * Date: 13/05/13
 * Time: 16.29
 */
public class FileManager {



    public static void move(File file, String dest)throws IOException{
        try {
            LoggingUtils.info("TENTO DI COPIARE " + file.getName() + " NELLA CARTELLA "+dest);
            FileUtils.copyFileToDirectory(file, new File(dest));
            File wkgfile= new File(dest+file.getName());
            if(wkgfile.exists()){
                LoggingUtils.info("FILE COPIATO CORRETTAMENTE: path[" + wkgfile.getPath()+"]");
                if(file.exists()){
                	LoggingUtils.info("TENTO DI CANCELLARE " + file.getName());
                	FileUtils.forceDelete(file);
                	if(file.exists())
                		LoggingUtils.info("RIMOZIONE FILE NON RIUSCITA" + file.getName());
                	else
                		LoggingUtils.info("RIMOZIONE FILE RIUSCITA");
                }
            }
            else{
            	LoggingUtils.info("FILE NON COPIATO IN ["+dest+file.getName()+"]");
            }
        } catch (IOException e) {
            LoggingUtils.error("IOException: Errore nello spostamento del file: "+ e.getMessage());
            throw e;
        } catch (Exception e){
        	LoggingUtils.error("Exception generica: Errore nello spostamento del file: "+ e.getMessage());
        }
        
    }



    /**
     * Pesca tutti i file presenti nella directory passata
     * @param dir deve rappresentare una directory.
     * @return
     * @throws ConfigurationDirecotryException
     */
    public static File[] getFiles(String dir) throws ConfigurationDirecotryException {
        File directory = new File(dir);
        if(directory.isDirectory()){
            return directory.listFiles();
        }else{
        	LoggingUtils.error("La directory configurata non è una directory e sarà scartata: La dir in questione è: " + directory.getName());
            throw new ConfigurationDirecotryException("La directory configurata non è una directory e sarà scartata: La dir in questione è: " + directory.getName() );
        }
    }

}
