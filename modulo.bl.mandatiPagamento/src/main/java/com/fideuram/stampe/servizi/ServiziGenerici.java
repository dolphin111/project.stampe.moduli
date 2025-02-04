package com.fideuram.stampe.servizi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.fideuram.config.CrmProperties;
import com.fideuram.costanti.Costanti;
import com.fideuram.utils.LoggingUtils;
import org.apache.commons.io.FileUtils;

public class ServiziGenerici extends Costanti{
    public ServiziGenerici() {
        super();
    }

    /**
	 * 
	 * @param fileIn
	 * @param pathFile
	 */
	public void saveFile(File fileIn, String pathFile) {
	//	LoggingUtils
			//	.debug("  Copia File Init >>" + pathFile + fileIn.getName());

		if (!fileIn.isDirectory()) {
			try {
				if (fileIn.renameTo(new File(pathFile + fileIn.getName()))) {
                    //	LoggingUtils.info("File is moved successful!");
				} else {
                    //	LoggingUtils.error("File is failed to move!");
				}
			} catch (Exception e) {
                //	LoggingUtils.error("File is failed to move!");
				e.printStackTrace();
			}

            //	LoggingUtils.debug("  Copia File End >>" + pathFile 					+ fileIn.getName());
		}
	}
	
	/**
	 * 
	 * @param fileIn
	 */
	protected void removeFile(File fileIn) {
		if (!fileIn.isDirectory()) {
            //LoggingUtils.info("  Remove File Init >>" + fileIn.getName());
			try{
			fileIn.delete();
                //	LoggingUtils.info("  Remove File End >>" + fileIn.getName());
			}
			catch(Exception e){
                //	LoggingUtils.error("  Remove File Error >>" + fileIn.getName()+", message:["+e.getMessage()+"]");
			}	
		}
	}
	
	@SuppressWarnings("finally")
	 protected boolean zipFiles(String srcFolder, String destZipFile) {
        //	LoggingUtils.info(" srcFolder[" + srcFolder + "], destZipFile["  				+ destZipFile + "]");
		boolean result = false;
		try {
            //	LoggingUtils.info(" Program Start zipping the given files");
			/*
			 * send to the zip procedure
			 */
			zipFolder(srcFolder, destZipFile);
			result = true;
            //		LoggingUtils.info("Lo zip e&grave stato creato con successo");
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
            //		LoggingUtils.error("ZIP Folder error: [" + e.getMessage() + "]");
		} finally {
			try {
				zip.flush();
				zip.close();
			} catch (IOException e) {
                //			LoggingUtils.error("ZIP flush or close stream error: ["    						+ e.getMessage() + "]");
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
                    //	LoggingUtils.error("addFileToZip method error, message:["+e.getMessage()+"]");
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

    boolean archiviazioneMandatiPagamento(String[] listaFolder){

        boolean resultTransfer = true;

        String pathFileZipSource = CrmProperties.getProperty(Costanti.MANDATIPAGAMENTO_GENERATI);

        for(int i=0; i<listaFolder.length; i++){
            try{
                String zipFileName = listaFolder[i];
                File file = new File(pathFileZipSource+"//"+zipFileName);

                try {
                    saveFile(file,CrmProperties.getProperty(Costanti.MANDATIPAGAMENTO_ARCHIVIATE));
                    removeFile(file);
                }
                catch (Exception e) {
                    resultTransfer = false;
                    e.printStackTrace();
                }




            }
            catch(Exception e){
                resultTransfer = false;
                e.printStackTrace();
                LoggingUtils.error("IOException in a");
            }
        }
        return resultTransfer;
    }


    public boolean archiviazione(String listFiles[]){
        ServiziGenerici archivia = new ServiziGenerici();
        return archivia.archiviazioneMandatiPagamento(listFiles);
    }



    /**
     *
     * @param stream
     * @param pathFile
     * @param nomefile
     * @return
     * @throws Exception
     */
    public File savePdf(byte[] stream, String pathFile, String nomefile) throws Exception {
        LoggingUtils.info("Save Init >>" + pathFile + File.separator + nomefile);
        File outFolder = new File(pathFile);
        boolean folderCreate = true;
        if (!outFolder.isDirectory())
            folderCreate = outFolder.mkdir();
        if(!folderCreate){
            //LoggingUtils.error("Error create folder >>" + pathFile + File.separator+ nomefile);
            throw new Exception("creazione cartella non riuscita, contattare l'assistenza tecnica");
        }
        File out = new File(pathFile + File.separator + nomefile);
        FileOutputStream os = null;

        try {
            os = new FileOutputStream(out);
            os.write(stream);
            os.flush();

        } catch (Throwable t) {
            //LoggingUtils.error("Save Error file >>" + pathFile + File.separator                        + nomefile);
            throw new Exception(pathFile +"--->"+ nomefile + " " + t.getMessage());

        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                    throw new Exception(pathFile + File.separator +nomefile + " "
                            + e.getMessage());
                }
            }
        }
        LoggingUtils.info("Save End >>" + pathFile + File.separator + nomefile);

        return out;
    }



    /*
    *
    */
    public List<String> listaFile(String tipoLista) {
        //LoggingUtils.info("lista file tipo: ["+tipoLista+"]");

        List<String> listaFile = new ArrayList<String>();
        String param = null;
        if(tipoLista.equalsIgnoreCase("mandatiPagamento"))
            param = Facade.pathFilesMandati;
        else if(tipoLista.equalsIgnoreCase("mandatiPagamentoGenerati"))
            param = Facade.pathFileGenerati;
        else if(tipoLista.equalsIgnoreCase("mandatiPagamentoArchiviare"))
            param = Facade.pathFileArchiviati;

        File f = new File(param);
        if (f.isDirectory()) {
            String files[] = f.list();
            for (int i = 0; i < files.length; i++) {
                if (!(new File(param + File.separator + files[i])).isDirectory())
                    listaFile.add(files[i]);
                else if(tipoLista.equalsIgnoreCase("mandatiPagamentoArchiviare"))
                    listaFile.add(files[i]);
            }
        }
        return listaFile;
    }


}
