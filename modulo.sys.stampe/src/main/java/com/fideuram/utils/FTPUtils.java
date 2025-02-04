package com.fideuram.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPConnectionClosedException;
import org.apache.commons.net.io.CopyStreamException;

public class FTPUtils {

	
	    public static void ftpConnect(FTPClient ftpclient, String host, String username, String password) throws IOException {
	    	LoggingUtils.info("FTPUtils :: Logging in FTP..");
	        try{
	            ftpclient.connect(host);
	            if (!ftpclient.login(username, password)) {
	                throw new IOException("Supplied wrong credentials to FTP Server");
	            }

	            if (ftpclient.getReplyCode() != 0) {
	            	System.out.println(ftpclient.getReplyString());
	            }
	        }catch(IOException ioe){
	            ioe.printStackTrace();
	            System.out.println("FTP Client is not able to Connect to host");
	            throw new IOException("FTP Client is not able to Connect to host");
	        }
	        LoggingUtils.info("FTPUtils :: FTP Login Successful..");
	    }

	    /**
	     * disconnect to FTP server
	     * 
	     * @param ftpclient is Object which is having details of FTP server like IP, user name and password
	     * @throws IOException throws Exception
	     */
	    public static void ftpDisConnect(FTPClient ftpclient) throws IOException {
	    	LoggingUtils.info("FTPUtils :: FTP Logging out..");
	        ftpclient.logout();
	        ftpclient.disconnect();
	        LoggingUtils.info("FTPUtils :: FTP Disconnected Successfully..");
	    }

	    /**
	     * download's file from source path to destination path by using FTP Client.
	     * 
	     * @param ftpclient is Object which is having details of FTP server like IP, user name and password
	     * @param sourcePath is String from where to download's file
	     * @param destinationPath is String to where to download's file.
	     * @return boolean true if download's with out any fail else false
	     * @throws IOException will throw any problem with file system
	     */
	    public static boolean downloadFile(FTPClient ftpclient, String sourcePath, String destinationPath) throws IOException {
	    	LoggingUtils.info("FTPUtils :: RemoteFile download starts ..FTP SOURCE " + sourcePath + " DESTINATION " + destinationPath);
	        FileOutputStream fos = null;
	        boolean result = false;
	        try{            
	            ftpclient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
	            ftpclient.setFileType(FTP.BINARY_FILE_TYPE);
	            File fDestination = new File(destinationPath);
	            fos = new FileOutputStream(fDestination);
	            result = ftpclient.retrieveFile(sourcePath, fos);
	            if (result) {
	            	LoggingUtils.info("FTPUtils :: RemoteFile download Completed..FTP " + sourcePath);
	            }
	        }catch(IOException ioe){
	            ioe.printStackTrace();
	            LoggingUtils.error("FTP is not able to Download the files from host");
	            throw new IOException("FTP is not able to Download the files from host");
	        }finally{
	            fos.close();
	        }
	        return result;
	    }

	    /**
	     * @param ftpclient
	     * @param sourcePath
	     * @param destinationPath
	     * @param fileTypeUpload = FTPClient.BINARY_FILE_TYPE or FTPClient.ASCII_FILE_TYPE ...
	     * @throws IOException
	     * @throws Exception 
	     */
	    public static boolean uploadFile(FTPClient ftpclient, String sourcePath, String destinationPath, int fileTypeUpload) throws IOException {
	    	InputStream inputStream = null;
	        boolean result = false;
	        try {
	        	LoggingUtils.debug("sourcePath : "+sourcePath);
	        	LoggingUtils.debug("destinationPath : "+destinationPath);
	        	LoggingUtils.debug("fileTypeUpload : "+fileTypeUpload);
	        	URL url = new URL("file://"+sourcePath);
	        	inputStream = url.openStream();
	            ftpclient.setFileType(fileTypeUpload);
	            LoggingUtils.info("Start uploading file ...");
	            try{
	            	result =  ftpclient.storeFile(destinationPath, inputStream);
	            }catch(FTPConnectionClosedException  ftpcce){
	            	LoggingUtils.error("Error during transfer file to path.Error: "+ftpcce.getMessage());
	            }catch(CopyStreamException cse){
	            	LoggingUtils.error("Error during transfer file to path.Error: "+cse.getMessage());
	            }
	            if(result)
	        	   LoggingUtils.info("The file is uploaded successfully.");
	            
	            inputStream.close();
	        }catch(IOException ioe){
	            ioe.printStackTrace();
	            LoggingUtils.error("Ftp transfer file error: "+ioe.getMessage());
	            throw new IOException("Error during ftp transfer file");
	        }
	        
	        return result;
	    }
	    
	   
	        public static void main(String[] str) throws Exception{
	        	/* Adeguamenti Sonar e PT ***********************************************/

	        	Properties prop = new Properties();
	        	ClassLoader loader = FTPUtils.class.getClassLoader();
	        	InputStream stream = loader.getResourceAsStream("externalized.properties");
	        	prop.load(stream);

	        	FTPClient ftpclient = new FTPClient();
	        	LoggingUtils utils= new LoggingUtils();
	        	try {
	        	// FTPUtils.ftpConnect(ftpclient, "10.10.33.1", "v900003", "Fv900003");
	        	FTPUtils.ftpConnect(ftpclient, prop.getProperty("bracciano.ip"), prop.getProperty("bracciano.user"), prop.getProperty("bracciano.password"));

	        	/*************************************************************************/
	                //FTPUtils.uploadFile(ftpclient, "//10.100.8.173/ftpprod/VR114$PU/zipGeneratiBonifici/BONIFICI_48_28052013_154917.zip", "//ftp_bucap/CRMS/Bucap/Servgen/Documenti_in_uscita/LiquidazioneRendita");
	                FTPUtils.uploadFile(ftpclient, "D://sito/BONIFICI_48_28052013_154917.zip", "/ftp_bucap/CRMS/Bucap/Servgen/Documenti_in_uscita/LiquidazioneRendita/BONIFICI_48_28052013_154917.zip", FTPClient.BINARY_FILE_TYPE);
	            } catch (IOException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
}
