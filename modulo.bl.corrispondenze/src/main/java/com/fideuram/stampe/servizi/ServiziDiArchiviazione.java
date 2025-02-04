package com.fideuram.stampe.servizi;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTPClient;
import com.fideuram.costanti.Costanti;
import com.fideuram.utils.FTPUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

public class ServiziDiArchiviazione extends ServiziGenerici{

	static String pathStorico = null;
	static String pathFtpFolderIsideB = null;
	static String pathFtpFolderIsideCB = null;
	static String pathFtpFolderBucap = null;
	static String ftpHost = null;
	static String ftpUser = null;
	static String ftpPsw = null;
	
	public ServiziDiArchiviazione(){
		pathFtpFolderIsideB = CrmProperties
				.getProperty(Costanti.CORRISPONDENZEB_ISIDE_DIR);
		pathFtpFolderIsideCB = CrmProperties
				.getProperty(Costanti.CORRISPONDENZECB_ISIDE_DIR);
		pathFtpFolderBucap = CrmProperties
				.getProperty(Costanti.CORRISPONDENZE_BUCAP_FTP);
		ftpHost = CrmProperties
				.getProperty(Costanti.BUCAP_HOST);
		ftpUser = CrmProperties
				.getProperty(Costanti.BUCAP_USER);
		ftpPsw = CrmProperties
				.getProperty(Costanti.BUCAP_PSW);
		pathStorico = CrmProperties
				.getProperty(Costanti.CORRISPONDENZE_STORICO_DIR);
	}
	
	
	boolean archiviaForIsideBucap(String[] files){
		boolean resultTransfer = false;
		
		FTPClient client = new FTPClient();
		String pathFileZipSource = CrmProperties.getProperty(Costanti.CORRISPONDENZE_GENERATI);
		
		try{
			LoggingUtils.info("before ftpConnect bucap...");
			FTPUtils.ftpConnect(client, ftpHost, ftpUser, ftpPsw);
			LoggingUtils.info(" ... connected to bucap");
		
			//copia file in Bucap e Iside
			for(int i=0; i<files.length; i++){
					LoggingUtils.info("file in trasferimento --> "+files[i]);
					if(new File(pathFileZipSource+"//"+files[i]).exists()){
						String zipName=files[i];						
						if(zipName.contains("Ben")){
							resultTransfer = FTPUtils.uploadFile(client, 
									pathFileZipSource+"//"+files[i], 
									pathFtpFolderIsideB+"/"+files[i], FTPClient.BINARY_FILE_TYPE);
						}
						if(zipName.contains("CB")){
							resultTransfer = FTPUtils.uploadFile(client, 
									pathFileZipSource+"//"+files[i], 
									pathFtpFolderIsideCB+"/"+files[i], FTPClient.BINARY_FILE_TYPE);
						}
						
						resultTransfer = FTPUtils.uploadFile(client, 
								pathFileZipSource+"//"+files[i], 
								pathFtpFolderBucap+"/"+files[i], FTPClient.BINARY_FILE_TYPE);
						
						File file = new File(pathFileZipSource+"//"+files[i]);
						saveFile(file, pathStorico);
						removeFile(file);
					}
					else{
						LoggingUtils.error("Il file non e' piu' disponibile o protetto da scrittura");
						resultTransfer =false;
					}
			}
				
		 } catch (IOException ex) {
			 	resultTransfer =false;
			 	LoggingUtils.error("Error: " + ex.getMessage());
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
	
	@SuppressWarnings("unused")
	boolean archiviaForStoricoCorrispondenze(String[] listaFolder){
		boolean resultTransfer = false;
		FTPClient client = new FTPClient();
		String pathFileZipSource = CrmProperties.getProperty(Costanti.CORRISPONDENZE_ARCHIVIATE);
	
		try{
			LoggingUtils.info("before ftpConnect bucap...");
			FTPUtils.ftpConnect(client, ftpHost, ftpUser, ftpPsw);
			LoggingUtils.info(" ... connected to bucap");

		//copia file in Iside
			for(int i=0; i<listaFolder.length; i++){
				LoggingUtils.info("file in trasferimento --> "+listaFolder[i]);
					String zipName=listaFolder[i];
					if(new File(pathFileZipSource+"/"+listaFolder[i]).exists()){
						if(zipName.contains("Ben")){
							resultTransfer = FTPUtils.uploadFile(client,
									pathFileZipSource+"/"+listaFolder[i], 
									pathFtpFolderIsideB+"/"+listaFolder[i], FTPClient.BINARY_FILE_TYPE);
						}
						if(zipName.contains("CB")){
							resultTransfer = FTPUtils.uploadFile(client, 
									pathFileZipSource+"/"+listaFolder[i], 
									pathFtpFolderIsideCB+"/"+listaFolder[i], FTPClient.BINARY_FILE_TYPE);
						}
						
						LoggingUtils.info(" start zip files ... ");
						zipFiles(Facade.pathFileArchiviati,pathStorico +listaFolder[i]);
						
						LoggingUtils.info(" start force delete file : "+Facade.pathFileArchiviati + File.separator + listaFolder[i]);
						FileUtils.forceDelete(new File(Facade.pathFileArchiviati + File.separator + listaFolder[i]));
						
						if(resultTransfer)
							LoggingUtils.info("file archiviato correttamente --> "+listaFolder[i]);
					}
					else{
						LoggingUtils.error("Il file non e' piu' disponibile o protetto da scrittura");
						resultTransfer =false;
					}
	
				}
		 } catch (IOException ex) {
			 	resultTransfer =false;
			 	LoggingUtils.error("Error in archiviaForStoricoCorrispondenze: " + ex.getMessage());
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

	
}
