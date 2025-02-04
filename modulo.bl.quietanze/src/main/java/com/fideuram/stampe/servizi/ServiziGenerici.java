package com.fideuram.stampe.servizi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.fideuram.utils.LoggingUtils;

public class ServiziGenerici {

	/**
	 * 
	 * @param fileIn
	 * @param pathFile
	 */
	protected void saveFile(File fileIn, String pathFile) {
		LoggingUtils
				.debug("  Copia File Init >>" + pathFile + fileIn.getName());

		if (!fileIn.isDirectory()) {
			try {
				if (fileIn.renameTo(new File(pathFile + fileIn.getName()))) {
					LoggingUtils.info("File is moved successful!");
				} else {
					LoggingUtils.error("File is failed to move!");
				}
			} catch (Exception e) {
				LoggingUtils.error("File is failed to move!");
				e.printStackTrace();
			}

			LoggingUtils.debug("  Copia File End >>" + pathFile
					+ fileIn.getName());
		}
	}
	
	/**
	 * 
	 * @param fileIn
	 */
	protected void removeFile(File fileIn) {
		if (!fileIn.isDirectory()) {
			LoggingUtils.info("  Remove File Init >>" + fileIn.getName());
			try{
			fileIn.delete();
			LoggingUtils.info("  Remove File End >>" + fileIn.getName());
			}
			catch(Exception e){
				LoggingUtils.error("  Remove File Error >>" + fileIn.getName()+", message:["+e.getMessage()+"]");
			}	
		}
	}
	
	@SuppressWarnings("finally")
	 protected boolean zipFiles(String srcFolder, String destZipFile) {
		LoggingUtils.info(" srcFolder[" + srcFolder + "], destZipFile["
				+ destZipFile + "]");
		boolean result = false;
		try {
			LoggingUtils.info(" Program Start zipping the given files");
			/*
			 * send to the zip procedure
			 */
			zipFolder(srcFolder, destZipFile);
			result = true;
			LoggingUtils.info("Lo zip e&grave stato creato con successo");
		} catch (Exception e) {
			LoggingUtils
					.error("Alcuni errori durante il processo di zip dei file");
		} finally {
			return result;
		}
	}

	 protected void zipFolder(String srcFolder, String destZipFile) {
		ZipOutputStream zip = null;
		FileOutputStream fileWriter = null;

		try {
			fileWriter = new FileOutputStream(destZipFile);
			zip = new ZipOutputStream(fileWriter);

			addFolderToZip("", srcFolder, zip);

		} catch (Exception e) {
			LoggingUtils.error("ZIP Folder error: [" + e.getMessage() + "]");
		} finally {
			try {
				zip.flush();
				zip.close();
			} catch (IOException e) {
				LoggingUtils.error("ZIP flush or close stream error: ["
						+ e.getMessage() + "]");
			}
		}
	}

	protected void addFileToZip(String path, String srcFile, ZipOutputStream zip,
			boolean flag) throws Exception {
		
		FileInputStream inInput = null;
		File folder = new File(srcFile);
		if (flag == true) {
			zip.putNextEntry(new ZipEntry(path + "/" + folder.getName() + "/"));
		} 
		else { 
			if (folder.isDirectory()) {
				addFolderToZip(path, srcFile, zip);
			} else {
				byte[] buf = new byte[1024];
				int len;
				try{
					inInput = new FileInputStream(srcFile);
					zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
					while ((len = inInput.read(buf)) > 0) {
						zip.write(buf, 0, len);
						}
					
				}
				catch(Exception e){
					LoggingUtils.error("addFileToZip method error, message:["+e.getMessage()+"]");
				}
				finally{
					inInput.close();
				}
			}
		}
	}

	protected void addFolderToZip(String path, String srcFolder,
			ZipOutputStream zip) throws Exception {
		File folder = new File(srcFolder);

		if (folder.list().length == 0) {
			addFileToZip(path, srcFolder, zip, true);
		} else {
			for (String fileName : folder.list()) {
				if (path.equals("")) {
					addFileToZip(folder.getName(), srcFolder + "/" + fileName,
							zip, false);
				} else {
					addFileToZip(path + "/" + folder.getName(), srcFolder + "/"
							+ fileName, zip, false);
				}
			}
		}
	}

}
