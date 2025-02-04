package com.fideuram.stampe.servizi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;

import com.fideuram.costanti.Costanti;
import com.fideuram.utils.FTPUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

public class ServiziDiArchiviazione extends ServiziGenerici{

	static String pathFtpFolderBucap = null;
	static String pathFtpFolderIside = null;
	static String ftpHost = null;
	static String ftpUser = null;
	static String ftpPsw = null;
	
	public ServiziDiArchiviazione(){
		pathFtpFolderBucap = CrmProperties
				.getProperty(Costanti.BUCAP_FTP);
		pathFtpFolderIside = CrmProperties
				.getProperty(Costanti.ISIDE_FTP);
		ftpHost = CrmProperties
				.getProperty(Costanti.BUCAP_HOST);
		ftpUser = CrmProperties
				.getProperty(Costanti.BUCAP_USER);
		ftpPsw = CrmProperties
				.getProperty(Costanti.BUCAP_PSW);
	}
	
	//Bonifici
	ArrayList<String> uploadableForBucap(){
		ArrayList<String> result = new ArrayList<String>();
		
		File f = new File(CrmProperties.getProperty(Costanti.QUIETANZE_BONIFICI_DIR));
		if (f.isDirectory()) {
			String files[] = f.list();
			for (int i = 0; i < files.length; i++) {
					result.add(files[i]);
			}
		}
		
		return result;
	}
	
	//Assegni
	ArrayList<String> uploadableForIside(){
		ArrayList<String> result = new ArrayList<String>();
		
		File f = new File(CrmProperties.getProperty(Costanti.QUIETANZE_ASSEGNI_ISIDE_DIR));
		if (f.isDirectory()) {
			String files[] = f.list();
			for (int i = 0; i < files.length; i++) {
				 if(files[i].contains("copia"))
					result.add(files[i]);
			}
		}
		
		return result;
	}
	
	ArrayList<String> uploadableForStorico(){
		ArrayList<String> result = new ArrayList<String>();
		
		File f = new File(CrmProperties.getProperty(Costanti.QUIETANZE_ASSEGNI_STORICO_DIR));
		if (f.isDirectory()) {
			String files[] = f.list();
			for (int i = 0; i < files.length; i++) {
					result.add(files[i]);
			}
		}
		
		return result;
	}
	
	boolean archiviaForBucap(String[] files){
		boolean resultTransfer = false;
		//inizializzo il clientFTP
		FTPClient client = new FTPClient();
		String pathFileZipSource = CrmProperties.getProperty(Costanti.QUIETANZE_ZIP_GENERATI_BON);
		try{
			LoggingUtils.info("before ftpConnect bucap...");
			FTPUtils.ftpConnect(client, ftpHost, ftpUser, ftpPsw);
			LoggingUtils.info(" ... connected to bucap");
		
			//copia file in bucap
			for(int i=0; i<files.length; i++){
			
					LoggingUtils.info("lotto bonifici in trasferimento su BUCAP--> "+files[i]);
					resultTransfer = FTPUtils.uploadFile(client, 
							pathFileZipSource+"//"+files[i], 
							pathFtpFolderBucap+"/"+files[i], FTPClient.BINARY_FILE_TYPE);
					
					
					//ogni file archiviato su BUCAP
					//va archiviato anche su ISIDE
					LoggingUtils.info("lotto bonifici in trasferimento su ISIDE--> "+files[i]);
					resultTransfer = FTPUtils.uploadFile(client, 
							pathFileZipSource+"//"+files[i], 
							pathFtpFolderIside+"/"+files[i], FTPClient.BINARY_FILE_TYPE);
					
					File file = new File(pathFileZipSource+"//"+files[i]);
					saveFile(file, CrmProperties.getProperty(Costanti.QUIETANZE_ARCHIVIATE));
					removeFile(file);
			}
			
		} catch (IOException ex) {
		 	resultTransfer =false;
		 	LoggingUtils.error("Error in archiviaForBucap: " + ex.getMessage());
		    ex.printStackTrace();
		} finally {
		    try {
		    	FTPUtils.ftpDisConnect(client);
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    }
		}
		
		return resultTransfer;
		
	}
	
	boolean archiviaForIside(String[] files){
		boolean resultTransfer = false;
		
		FTPClient client = new FTPClient();
		String pathFileZipSource = CrmProperties.getProperty(Costanti.QUIETANZE_ZIP_GENERATI_ASS);
		
		try{
			LoggingUtils.info("before ftpConnect bucap...");
			FTPUtils.ftpConnect(client, ftpHost, ftpUser, ftpPsw);
			LoggingUtils.info(" ... connected to bucap");
		
		//copia file in iside
			for(int i=0; i<files.length; i++){
				LoggingUtils.info("file in trasferimento --> "+files[i]);
				resultTransfer = FTPUtils.uploadFile(client, pathFileZipSource+"/"+files[i], pathFtpFolderIside+"/"+files[i], FTPClient.BINARY_FILE_TYPE);
						
				File file = new File(pathFileZipSource+"//"+files[i]);
				saveFile(file, CrmProperties.getProperty(Costanti.QUIETANZE_ARCHIVIATE));
				removeFile(file);
			}
				
		} catch (IOException ex) {
		 	resultTransfer =false;
		 	LoggingUtils.error("Error in archiviaForIside: " + ex.getMessage());
		    ex.printStackTrace();
		} finally {
		    try {
		    	FTPUtils.ftpDisConnect(client);
		    } catch (IOException ex) {
		        ex.printStackTrace();
		    }
		}
		
		return resultTransfer;
	}
	
	boolean archiviaForStoricoAssegni(String[] listaFolder){
		boolean resultTransfer = false;
		
		String pathFileZipSource = CrmProperties.getProperty(Costanti.QUIETANZE_ASSEGNI_STORICO_DIR);

		for(int i=0; i<listaFolder.length; i++){
			try{
				if((new File(pathFileZipSource+File.separator+listaFolder[i])).isDirectory()){
					
					String zipFileName = "ASSEGNI_48_"+listaFolder[i].substring(7, 15)+"_"+listaFolder[i].substring(15,21)+"_"+listaFolder[i].substring(21);
					zipFiles(pathFileZipSource + File.separator + listaFolder[i], CrmProperties.getProperty(Costanti.QUIETANZE_ARCHIVIATE) + File.separator
							+ zipFileName + ".zip");
					
					
					FileUtils.deleteDirectory(new File(pathFileZipSource + File.separator + listaFolder[i]));
					LoggingUtils.info("file archiviato correttamente --> "+listaFolder[i]);
					resultTransfer =true;
				}
				else{
					LoggingUtils.error("La cartella non e' piu' disponibile o protetta da scrittura");
					resultTransfer =false;
				}
			}
			catch(Exception e){
				resultTransfer = false;
				e.printStackTrace();
				LoggingUtils.error("IOException in archiviaForBucap");
			}
		}
		return resultTransfer;
	}

	
}
