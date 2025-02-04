package com.fideuram.stampe.servizi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fideuram.costanti.Costanti;
import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.exeption.QuietanzaException;
import com.fideuram.stampe.modello.quietanza.Assegno;
import com.fideuram.stampe.modello.quietanza.Bonifico;
import com.fideuram.stampe.modello.quietanza.EsitoStampaQuietanze;
import com.fideuram.stampe.modello.quietanza.ListaAssegni;
import com.fideuram.stampe.modello.quietanza.ListaBonifici;
import com.fideuram.stampe.printer.AssegnoGenerator;
import com.fideuram.stampe.printer.BonificoGenerator;
import com.fideuram.stampe.utils.SenderMail;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

/**
 * Created by User: logan Date: 15/02/13 Time: 15.25
 */
public class Facade extends ServiziGenerici {
	static String pathFiles = null;
	static String pathFilesBonifici = null;
	static String pathFilesAssegni = null;
	static String pathFilesAssegniArchiviazione = null;
	static String pathFileStampati = null;
	static String pathFileErrori = null;
	static String pathFileZipGeneratiBonifici = null;
	static String pathFileZipGeneratiAssegni = null;
	
	static String pathFileBucap = null;
	
	static String pathFileArchiviati = null;
	
	static String tempPathFileLavorazione = null;
	
	static String assegnoTemplateName = "Assegno.odt";
	static String assegnoCopiaTemplateName = "AssegnoCopia.odt";
	static String bonificoPdfName = "Bonifico.pdf";
	static String assegnoPdfName = "Assegno.pdf";
	static String assegnoPdfCopiaName = "AssegnoCopia.pdf";

	public Facade(){
		pathFileZipGeneratiBonifici = CrmProperties
				.getProperty(Costanti.QUIETANZE_ZIP_GENERATI_BON);
		pathFileZipGeneratiAssegni =CrmProperties
				.getProperty(Costanti.QUIETANZE_ZIP_GENERATI_ASS);
		pathFiles = CrmProperties.getProperty(Costanti.QUIETANZE_DIR);
		pathFileStampati = CrmProperties
				.getProperty(Costanti.QUIETANZE_STATO_STAMPATI_DIR);
		pathFileErrori = CrmProperties
				.getProperty(Costanti.QUIETANZE_STATO_ERRORI_DIR);
		pathFilesAssegni = CrmProperties
				.getProperty(Costanti.QUIETANZE_ASSEGNI_ISIDE_DIR);
		pathFilesAssegniArchiviazione = CrmProperties
				.getProperty(Costanti.QUIETANZE_ASSEGNI_STORICO_DIR);
		pathFilesBonifici = CrmProperties
				.getProperty(Costanti.QUIETANZE_BONIFICI_DIR);
		
		tempPathFileLavorazione = CrmProperties
				.getProperty(Costanti.QUIETANZE_TEMP_FILE_LAVORAZIONE_DIR);
	}
	/**
	 * 
	 * @param xml
	 * @throws QuietanzaException
	 */
	private void printQuietanza(File xml,
			EsitoStampaQuietanze esitoStampaQuietanze) throws Exception {

		String identificativoQuietanza = "";
		String nameXML = xml.getName().substring(0, xml.getName().indexOf("."));
		try {
			if ("BONIFICI".contains(xml.getName().substring(0, 8))) {
				ListaBonifici q = (ListaBonifici) Converter.xml2Object(
						new ListaBonifici(), xml);
				for (int i = 0; i < q.getBonifico().size(); i++) {
					Bonifico bonifico = q.getBonifico().get(i);
					identificativoQuietanza = bonifico.getProtocollo();
					printBonifico(bonifico, nameXML);
					esitoStampaQuietanze.getListaBonifici().add(identificativoQuietanza);
				}
				String zipFileName = "BONIFICI_48_"+nameXML.substring(8, 16)+"_"+nameXML.substring(16,22)+"_"+nameXML.substring(22);
				zipFiles(pathFiles +  nameXML, pathFileZipGeneratiBonifici +  zipFileName + ".zip");
				
				/*
				 * G.C.-20161125 Aggiunto questo blocco per fare in modo che il fatto che fallisca la cancellazione
				 * delle directoty non "allarmi" gli utenti con messaggi/email di errore.
				 * Nel caso in cui per qualsiasi motivo fallisca la cancellazione, viene inviata una nuova email
				 * al nostro gruppo di lavoro in modo da consentirci eventualmente una bonifica manuale
				 * */
				try{

					FileUtils.deleteDirectory(new File(pathFiles + nameXML));
				
				}catch(IOException ex){
					
					String from = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_FROM);
					String to = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_TO);
					String cc = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_CC);
					String mailSubject ="Errore in fase di cancellazione directory";
					String mailText = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_TEXT);
					
					LoggingUtils.error(mailSubject+":"+ex.getMessage());
					
					SenderMail.sendMail(from, to, cc, mailSubject, mailText, ex.getMessage());
				}
				
				
			} else {
				ListaAssegni a = (ListaAssegni) Converter.xml2Object(new ListaAssegni(), xml);
				printAssegno(a, nameXML);
				for (int i = 0; i < a.getAssegno().size(); i++) {
					Assegno assegno = a.getAssegno().get(i);
					identificativoQuietanza = assegno.getProtocollo();
					//printAssegno(assegno, nameXML, i);
					esitoStampaQuietanze.getListaAssegni().add(
							identificativoQuietanza);
				}
				String zipFileName = "ASSEGNI_48_"+nameXML.substring(7, 15)+"_"+nameXML.substring(15,21)+"_"+nameXML.substring(21);
//				zipFiles(pathFiles + File.separator + nameXML, pathFileZipGeneratiAssegni + File.separator
//						+ zipFileName + ".zip");
//			    zipFiles(pathFiles + File.separator + nameXML, pathFilesAssegniArchiviazione + File.separator
//						+ zipFileName + ".zip");
			    FileUtils.copyDirectoryToDirectory(new File(pathFiles +  nameXML), new File(pathFilesAssegniArchiviazione));

			    /*
				 * G.C.-20161125 Aggiunto questo blocco per fare in modo che il fatto che fallisca la cancellazione
				 * delle directoty non "allarmi" gli utenti con messaggi/email di errore.
				 * Nel caso in cui per qualsiasi motivo fallisca la cancellazione, viene inviata una nuova email
				 * al nostro gruppo di lavoro in modo da consentirci eventualmente una bonifica manuale
				 * */
				try{
					FileUtils.deleteDirectory(new File(pathFiles +  nameXML));
					
				}catch(IOException ex){
					
					String from = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_FROM);
					String to = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_TO);
					String cc = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_CC);
					String mailSubject ="Errore in fase di cancellazione directory";
					String mailText = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_TEXT);
					
					LoggingUtils.error(mailSubject+":"+ex.getMessage());
					
					SenderMail.sendMail(from, to, cc, mailSubject, mailText, ex.getMessage());
				}
				
				String zipFileNameCopia = "ASSEGNI_48_"+nameXML.substring(7, 15)+"_"+nameXML.substring(15,21)+"_"+nameXML.substring(21)+"_copia";
				zipFiles(pathFiles +  nameXML+"_copia", pathFileZipGeneratiAssegni 
						+ zipFileNameCopia + ".zip");
				
				/*
				 * G.C.-20161125 Aggiunto questo blocco per fare in modo che il fatto che fallisca la cancellazione
				 * delle directoty non "allarmi" gli utenti con messaggi/email di errore.
				 * Nel caso in cui per qualsiasi motivo fallisca la cancellazione, viene inviata una nuova email
				 * al nostro gruppo di lavoro in modo da consentirci eventualmente una bonifica manuale
				 * */
				try{

					FileUtils.deleteDirectory(new File(pathFiles  + nameXML+"_copia"));
				
				}catch(IOException ex){
					
					String from = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_FROM);
					String to = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_TO);
					String cc = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_CC);
					String mailSubject ="Errore in fase di cancellazione directory";
					String mailText = CrmProperties.getProperty(Costanti.STAMPE_DELETE_DIRECTORY_MAIL_TEXT);
					
					LoggingUtils.error(mailSubject+":"+ex.getMessage());
					
					SenderMail.sendMail(from, to, cc, mailSubject, mailText, ex.getMessage());
				}
			}
		} catch (QuietanzaException e) {
			
			LoggingUtils.error("printCorrispondenzaBase QuietanzaException error:"+e.getMessage());
			
			esitoStampaQuietanze.getListaErrori().add(
					identificativoQuietanza + "-" + xml.getName());
			throw e;
		} catch (Exception e) {
			
			LoggingUtils.error("printQuietanza error:"+e.getMessage());
			
			esitoStampaQuietanze.getListaErrori().add(
					identificativoQuietanza + "-" + xml.getName()
							+ "/n errore generico:[" + e.getMessage() + "]");
			throw e;
		}
	}

	
	/**
	 * 
	 * @param bonifico
	 * @throws Exception
	 * @throws URISyntaxException
	 */
	private void printBonifico(Bonifico bonifico, String pathDestinazionPdf)
			throws Exception {
		byte[] lbyte = new BonificoGenerator().generateDocument(bonifico);
		savePdf(lbyte, pathFiles + pathDestinazionPdf,
				bonifico.getOggetto().getPolizza()+"_"+bonifico.getProtocollo()+".pdf");
	}

	/**
	 * 
	 * @param assegno
	 * @throws QuietanzaException
	 */
	private void printAssegno(Assegno assegno, String pathDestinazionePdf)
			throws Exception {
//		byte[] lbyte = new AssegnoGenerator(assegnoTemplateName).generateDocument(assegno);
//		savePdf(lbyte, pathFiles + File.separator + pathDestinazionePdf,
//				assegno.getProtocollo()+"_"+assegno.getOggetto().getPolizza()+"_"+ assegno.getNumeroAssegno()+ ".pdf");
//				//assegno.getOggetto().getPolizza()+"_"+assegno.getProtocollo()+".pdf");

		byte[] lbyteCopia = new AssegnoGenerator(assegnoCopiaTemplateName).generateDocument(assegno);
		savePdf(lbyteCopia, pathFiles +  pathDestinazionePdf+"_copia",
				assegno.getProtocollo()+"_"+assegno.getOggetto().getPolizza()+"_"+ assegno.getNumeroAssegno()+"_copia.pdf");				
				//assegno.getOggetto().getPolizza()+"_"+assegno.getProtocollo()+"_copia.pdf");

	}
	
	private void printAssegno(ListaAssegni assegni, String pathDestinazionePdf)
			throws Exception {
		int size = assegni.getAssegno().size();
		String nameFile = "";
		if(size == 1 ){
			nameFile = assegni.getAssegno().get(0).getProtocollo()+assegni.getAssegno().get(0).getProtocollo()+".pdf";
		}
		else if(size > 1){
			nameFile = assegni.getAssegno().get(0).getProtocollo()+"_"+assegni.getAssegno().get(0).getNumeroAssegno()+"_"+
					   assegni.getAssegno().get(size-1).getProtocollo()+"_"+assegni.getAssegno().get(size-1).getNumeroAssegno()+".pdf";
		}
		else{
			nameFile = "nessunAssegnoPresente.pdf";
		}
		byte[] lbyte = new AssegnoGenerator(assegnoTemplateName).generateDocument(assegni);
		savePdf(lbyte, pathFiles + pathDestinazionePdf, nameFile);
		
		for(int i=0;i<assegni.getAssegno().size(); i++){
			Assegno assegno = assegni.getAssegno().get(i);
			printAssegno(assegno,pathDestinazionePdf);
		}
	}


	/**
	 * 
	 * @param stream
	 * @param pathFile
	 * @param nomefile
	 * @return
	 * @throws Exception
	 */
	private File savePdf(byte[] stream, String pathFile, String nomefile)
			throws Exception {
		LoggingUtils.info("Save Init >>" + pathFile + File.separator + nomefile);
		File outFolder = new File(pathFile);
		boolean folderCreate = true;
		if (!outFolder.isDirectory())
			folderCreate = outFolder.mkdir();
		if(!folderCreate){
			LoggingUtils.error("Error create folder >>" + pathFile + File.separator+ nomefile);
			throw new Exception("creazione cartella non riuscita, contattare l'assistenza tecnica");
		}
		File out = new File(pathFile + File.separator + nomefile);
		FileOutputStream os = null;

		try {
			os = new FileOutputStream(out);
			os.write(stream);
			os.flush();

		} catch (Throwable t) {
			LoggingUtils.error("Save Error file >>" + pathFile + File.separator
					+ nomefile);
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

	/**
     * 
     */
	public EsitoStampaQuietanze printQuietanze(String param) {

		String bonOrAss = null;
		EsitoStampaQuietanze esitoStampaQuietanze = new EsitoStampaQuietanze();

		if(param.equalsIgnoreCase("bonifici"))
			bonOrAss = pathFilesBonifici;
		else
			bonOrAss = pathFilesAssegni;
		
		File f = new File(bonOrAss);
		if (f.isDirectory()) {
			String files[] = f.list();
			for (int i = 0; i < files.length; i++) {
				File file = new File(bonOrAss +  files[i]);
				if (!file.isDirectory()) {
					try {
						
						/*
						 * G.C.-20170420 Per nascondere il bottone relativo alla creazione dei PDF copio il file in una cartella
						 * temporanea che andrò a controllare al caricamento della jsp.
						 * Al termine dell'elaborazione (OK/KO) rimuovo a prescindere il file dalla cartella.
						 * */
						FileUtils.copyFile(file, new File(tempPathFileLavorazione + file.getName()));
						
						printQuietanza(file, esitoStampaQuietanze);
						saveFile(file, pathFileStampati);
						
						/*
						 * G.C.-20170420 Al termine dell'elaborazione (OK/KO) rimuovo a prescindere il file dalla cartella temporanea.
						 * */
						removeFile(new File(tempPathFileLavorazione + file.getName()));
						
					} catch (Exception e) {
						saveFile(file, pathFileErrori);
						e.printStackTrace();
					}
					removeFile(file);
				}
			}
		}
		//aggiorniamo le cartelle di generazione dei file compressi
		ServiziDiArchiviazione archiviaDocumenti = new ServiziDiArchiviazione();
		esitoStampaQuietanze.setListaBonificiGenerati(archiviaDocumenti.uploadableForBucap());
		esitoStampaQuietanze.setListaAssegniGeneratiArchiviazione(archiviaDocumenti.uploadableForIside());
		esitoStampaQuietanze.setListaAssegniGeneratiStorico(archiviaDocumenti.uploadableForStorico());
		
		return esitoStampaQuietanze;
	}

	/*
     * 
     */
	public List<String> listaFile(String tipoLista) {
		LoggingUtils.info("lista file tipo: ["+tipoLista+"]");
		
		List<String> listaFile = new ArrayList<String>();
		String param = null;
		if(tipoLista.equalsIgnoreCase("bonifici"))
			param = pathFilesBonifici;
		else if(tipoLista.equalsIgnoreCase("assegni"))
			param = pathFilesAssegni;
		else if(tipoLista.equalsIgnoreCase("bonificiGenerati"))
			param = pathFileZipGeneratiBonifici;
		else if(tipoLista.equalsIgnoreCase("assegniGenerati"))
			param = pathFileZipGeneratiAssegni;
		else //assegni da archiviare (assegniArchiviare)
			param = pathFilesAssegniArchiviazione;
		File f = new File(param);
		if (f.isDirectory()) {
			String files[] = f.list();
			for (int i = 0; i < files.length; i++) {
				if (!(new File(param +  files[i])).isDirectory())
					listaFile.add(files[i]);
				else if(tipoLista.equalsIgnoreCase("assegniArchiviare"))
					listaFile.add(files[i]);
			}
		}
		return listaFile;
	}
	
	public boolean checkTempFile(){
		File f= new File(tempPathFileLavorazione);
		File[] listOfFiles = f.listFiles(); 

		if(listOfFiles != null && listOfFiles.length > 0)
			return true;
		else
			return false;
	}
	
	//public for servlet
	public boolean archiviaForBucap(String listFiles[]){
		ServiziDiArchiviazione archivia = new ServiziDiArchiviazione();
		return archivia.archiviaForBucap(listFiles);
	}
	public boolean archiviaForIside(String listFiles[]){
		ServiziDiArchiviazione archivia = new ServiziDiArchiviazione();
		return archivia.archiviaForIside(listFiles);
	}
	public boolean archiviaForStoricoAssegni(String listFiles[]){
		ServiziDiArchiviazione archivia = new ServiziDiArchiviazione();
		return archivia.archiviaForStoricoAssegni(listFiles);
	}
	
	//test main transfer FTP
	public static void main(String args[]) {
//
		Facade facade = new Facade();
		List<String> list = facade.listaFile("assegni");
		//List<String> list = facade.listaFile("bonifici");
		facade.printQuietanze("assegni");
		//facade.printQuietanze("bonifici");

//		String file[] = new String[1];
//		file[0] = "ASSEGNI240920131137420014";
////		file[1] = "ASSEGNI_48_20130514_125550.zip";
//		
//		ServiziDiArchiviazione archivia = new ServiziDiArchiviazione();
		//boolean resultArchivio = archivia.archiviaForStoricoAssegni(file);
		//System.out.println("result-->"+resultArchivio);
	}
}
