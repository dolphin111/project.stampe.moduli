package com.fideuram.stampe.servizi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fideuram.config.CrmProperties;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.puc.service.impl.FvRolVO;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.stampe.exeption.CorrispondenzaException;
import com.fideuram.stampe.modello.corrispondenza.CorrispondenzaRendite;
import com.fideuram.stampe.modello.corrispondenza.TipoLettera;
import com.fideuram.stampe.printer.CorrispondenzaRenditaGenerator;
import com.fideuram.stampe.printer.EsitoStampaCorrispondenze;
import com.fideuram.stampe.utils.SenderMail;
import com.fideuram.utils.LoggingUtils;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfReader;

/**
 * Created by
 * User: emrossi
 * Date: 07/04/14
 * Time: 9:02
 */

public class Facade extends ServiziGenerici {
	static String pathFiles = "";
	static String pathFilesCorrispondenzeRendita = "";
	static String pathFileStampati = "";
	static String pathFileErrori = "";
	static String pathFileZipGenerateCorrispondenzeRendita = "";
	static String pathFileGenerati = "";
	static String pathFileArchiviati = "";
	static String pathTemplate = "";
	static String tempPathFileLavorazione = "";


	public Facade(){
		pathFiles = CrmProperties.getProperty(Costanti.CORRISPONDENZE_DIR );
		pathFilesCorrispondenzeRendita = CrmProperties.getProperty(Costanti.CORRISPONDENZE_XML_DIR );
		pathFileStampati = CrmProperties.getProperty(Costanti.CORRISPONDENZE_STAMPATI_DIR);
		pathFileErrori = CrmProperties.getProperty(Costanti.CORRISPONDENZE_ERRORI_DIR );
		pathFileZipGenerateCorrispondenzeRendita = CrmProperties.getProperty(Costanti.CORRISPONDENZE_ZIP_GENERATI );
		pathFileGenerati = CrmProperties.getProperty(Costanti.CORRISPONDENZE_GENERATI );
		pathFileArchiviati = CrmProperties.getProperty(Costanti.CORRISPONDENZE_ARCHIVIATE );
		pathTemplate = CrmProperties.getProperty(Costanti.CORRISPONDENZE_TEMPLATE_DIR );
		tempPathFileLavorazione = CrmProperties.getProperty(Costanti.CORRISPONDENZE_TEMP_FILE_LAVORAZIONE_DIR);
	}


	/**
	 * 
	 * @param xml
	 * @throws CorrispondenzaException
	 */
	private void printCorrispondenzaBase(File xml,
			EsitoStampaCorrispondenze esitoStampaCorrispondenzeRendita) throws Exception {
		LoggingUtils.info("Inizio generazione Corrispondenza Rendite");
		String identificativoLettera = "";
		String nameXML = xml.getName().substring(0, xml.getName().indexOf("."));
		CorrispondenzaRendite cr =null;
		String polizza ="";
		String zipFileName ="";
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");

		try {
			LoggingUtils.info("Converto il file xml nel relativo Oggetto");
			cr = (CorrispondenzaRendite) Converter.xml2Object(new CorrispondenzaRendite(), xml);
			String numeroPezzi= cr.getNumeropezzi();
			int j=0;
			boolean uguali=false;
			boolean diversi=false;
			int countCBRolNO=0;
			int countCBRolSI=0;
			int countBen=0;
			String folderNameCBRol="";
			StampeServiceImpl pucws =null;
            String oldPolizza="";
			pucws = ClientWsFactory.getInstance().getPucClient();
            int _i=0;
			for (int i = 0; i < cr.getTipoLettera().size(); i++) {

               if(_i+150==i){
                   System.out.println("STEP: " + i);
                   _i=i;
               }

                TipoLettera tipoLettera = cr.getTipoLettera().get(i);
//                if(tipoLettera.getPolizza().equals("7045790"))   {
//                    LoggingUtils.info("LiMortacciTua");
//                }
				identificativoLettera = tipoLettera.getLettera();
				LoggingUtils.info("Controllo corrispondenza .odt con il tipoLettera ");
				// se il tipoLettera esiste nella lista dei tipiLettera conosciuti
				if(listaOdtTipoLettera(identificativoLettera+".odt")){

					polizza=tipoLettera.getPolizza();
                    if (oldPolizza.equalsIgnoreCase(polizza) )
                        LoggingUtils.info("trovate due polizze uguali: "+oldPolizza + " " + polizza);

                    oldPolizza=polizza;
					LoggingUtils.info("Numero polizza: "+polizza);
					
					folderNameCBRol="";

					FvRolVO rol= pucws.getStatoRol(polizza);

					//Controllo se Rol Attiva
					if(rol.isIsRol() && !isRenditeTemplate(identificativoLettera))
						folderNameCBRol= "CBRolSI";
					else
						folderNameCBRol= "CBRolNO";
					
					// se contraente e beneficiario sono uguali
					if(cr.getTipoLettera().get(i).getContraente().getCognome().equalsIgnoreCase(cr.getTipoLettera().get(i).getBeneficiario().getCognome())
							&&
							cr.getTipoLettera().get(i).getContraente().getNome().equalsIgnoreCase(cr.getTipoLettera().get(i).getBeneficiario().getNome())
								){
						printCorrispondenzeRendita(tipoLettera, identificativoLettera, nameXML+folderNameCBRol);
						
							if(folderNameCBRol.equalsIgnoreCase("CBRolNO")){
								countCBRolNO++;
							}
							if(folderNameCBRol.equalsIgnoreCase("CBRolSI")){
								countCBRolSI++;
								uguali=true;
							}
						}
					// se contraente e beneficiario sono diversi
					else{
						printCorrispondenzeRendita(tipoLettera, identificativoLettera, nameXML+"Ben");
						diversi=true;
						countBen++;
					}
					
					esitoStampaCorrispondenzeRendita.getListaCorrispondenzaRendite().add(polizza);
                    LoggingUtils.debug( i + " " + cr.getTipoLettera().size());
					if( i==cr.getTipoLettera().size()-1){
                        LoggingUtils.debug( "entrato ");
						String zipNameCBRolNO="";
						String zipNameBen ="";
						String zipNameCBRolSI ="";
					/*	if(diversi){    */
							if(countBen>0){
								zipNameBen= "CorrispondenzaRendite_66_"+sdf.format(new Date())+"_"+countBen+"_Ben"+ ".zip";
								zipFiles(pathFiles + File.separator + nameXML+"Ben", pathFileZipGenerateCorrispondenzeRendita + File.separator+ zipNameBen);
								File def= new File (pathFileZipGenerateCorrispondenzeRendita + File.separator+ zipNameBen);
								File generati= new File (pathFileGenerati);
								FileUtils.copyFileToDirectory(def,generati);
							}

							if(countCBRolNO>0){
								zipNameCBRolNO= "CorrispondenzaRendite_66_"+sdf.format(new Date())+"_"+countCBRolNO+"_CBRolNO"+ ".zip";
								zipFiles(pathFiles + File.separator + nameXML+"CBRolNO", pathFileZipGenerateCorrispondenzeRendita + File.separator+ zipNameCBRolNO);
								File defCBRolNO= new File (pathFileZipGenerateCorrispondenzeRendita + File.separator+ zipNameCBRolNO);
								File generatiCBRolNO= new File (pathFileGenerati);
								FileUtils.copyFileToDirectory(defCBRolNO,generatiCBRolNO);
								}
							//}

					/*	if(uguali){       */
							if(countCBRolSI>0){
								zipNameCBRolSI = "CorrispondenzaRendite_66_"+sdf.format(new Date())+"_"+countCBRolSI+"_CBRolSI"+ ".zip";
								zipFiles(pathFiles + File.separator + nameXML+"CBRolSI", pathFileZipGenerateCorrispondenzeRendita + File.separator+zipNameCBRolSI);
								File defCBRolSI= new File (pathFileZipGenerateCorrispondenzeRendita + File.separator+ zipNameCBRolSI);
								File archiviatiCBRolSI= new File (pathFileArchiviati);
								FileUtils.copyFileToDirectory(defCBRolSI,archiviatiCBRolSI);
							}
						//}
							
							/*
							 * G.C.-20161125 Aggiunto questo blocco per fare in modo che il fatto che fallisca la cancellazione
							 * delle directoty non "allarmi" gli utenti con messaggi/email di errore.
							 * Nel caso in cui per qualsiasi motivo fallisca la cancellazione, viene inviata una nuova email
							 * al nostro gruppo di lavoro in modo da consentirci eventualmente una bonifica manuale
							 * */
							try{
								FileUtils.deleteDirectory(new File(pathFiles + File.separator + nameXML+"CBRolNO"));
								FileUtils.deleteDirectory(new File(pathFiles + File.separator + nameXML+"CBRolSI"));
								FileUtils.deleteDirectory(new File(pathFiles+ File.separator + nameXML+"Ben"));
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
				}
				else{
					LoggingUtils.error("Non esiste il tipoLettera: "+identificativoLettera);
				}
			}
			LoggingUtils.info("Fine generazione Corrispondenza Rendite");
			
		} catch (CorrispondenzaException e) {
			
			LoggingUtils.error("printCorrispondenzaBase CorrispondenzaException error:"+e.getMessage());
			
			esitoStampaCorrispondenzeRendita.getListaErrori().add(
					polizza + "-" + xml.getName());
			throw e;
		} catch (Exception e) {

			LoggingUtils.error("printCorrispondenzaBase error:"+e.getMessage());

			esitoStampaCorrispondenzeRendita.getListaErrori().add(
					polizza + "-" + xml.getName()
							+ "/n errore generico:[" + e.getMessage() + "]");
			throw e;
		}
	}

	

	
	private void printCorrispondenzeRendita(TipoLettera tipoLettera, String identificativoLettera, String nameXML)
			throws Exception {
		
		String polizza= tipoLettera.getPolizza();
		PdfReader autocertificazione =null;
		boolean a1= false;
		boolean a2= false;
		boolean a3= false;
		boolean a4= false;
		String allegati = tipoLettera.getAllegati();
		LoggingUtils.info("Inizio generazione PDF");
		byte[] lbyte = new CorrispondenzaRenditaGenerator(identificativoLettera).generateDocument(tipoLettera, identificativoLettera);
		savePdf(lbyte, pathFiles + File.separator + nameXML, identificativoLettera+".pdf");
		

		Document doc= new Document();
		PdfCopy copy= new PdfCopy(doc, new FileOutputStream(pathFiles + File.separator + nameXML+File.separator+polizza.trim()+"_"+identificativoLettera+"_"+allegati+".pdf"));
		doc.open(); 

		PdfReader lettera=new PdfReader(pathFiles + File.separator + nameXML+File.separator+ identificativoLettera+".pdf");
		int n = lettera.getNumberOfPages();
		
		for (int i = 0; i < n; ) {
			copy.addPage(copy.getImportedPage(lettera, ++i));
		}
		if(tipoLettera.getAllegato1() != null && tipoLettera.getAllegato1().equalsIgnoreCase("SI")){
			byte[] odt1 = new CorrispondenzaRenditaGenerator("Allegato1").generateDocument(tipoLettera, "Allegato1.odt");
			savePdf(odt1, pathFiles + File.separator + nameXML, "Allegato1"+".pdf");
			
			PdfReader all1=new PdfReader(pathFiles + File.separator + nameXML+File.separator+ "Allegato1"+".pdf");
			all1.selectPages("1");
			copy.addPage(copy.getImportedPage(all1, 1));
			a1= true;
		}
		
		if(tipoLettera.getAll2() != null && tipoLettera.getAll2().equalsIgnoreCase("SI")){
			byte[] odt2= new CorrispondenzaRenditaGenerator("Allegato2").generateDocument(tipoLettera, "Allegato2.odt");
			savePdf(odt2, pathFiles + File.separator + nameXML, "Allegato2"+".pdf");

			PdfReader all2 = new PdfReader(pathFiles + File.separator+ nameXML+File.separator+ "Allegato2"+".pdf");
//			all2.selectPages("1-3");
//			for (int i = 0; i < 3; ) {
//				copy.addPage(copy.getImportedPage(all2, ++i));
//			}
			int nAl2 = all2.getNumberOfPages();
			
			for (int i = 0; i < nAl2; ) {
				copy.addPage(copy.getImportedPage(all2, ++i));
			}
			a2= true;
		}
		
		if(tipoLettera.getAll3() != null && tipoLettera.getAll3().equalsIgnoreCase("SI")){
			byte[] odt3= new CorrispondenzaRenditaGenerator("Allegato3").generateDocument(tipoLettera, "Allegato3.odt");
			savePdf(odt3, pathFiles + File.separator + nameXML, "Allegato3"+".pdf");
			
			PdfReader all3 = new PdfReader(pathFiles + File.separator+ nameXML+File.separator+ "Allegato3"+".pdf");
			all3.selectPages("1");
			copy.addPage(copy.getImportedPage(all3, 1));
			a3= true;
		}
		
		if(tipoLettera.getAll4() != null && tipoLettera.getAll4().equalsIgnoreCase("SI")){
			byte[] odt4= new CorrispondenzaRenditaGenerator("Allegato4").generateDocument(tipoLettera, "Allegato4.odt");
			savePdf(odt4, pathFiles + File.separator + nameXML, "Allegato4"+".pdf");
			
			PdfReader all4 = new PdfReader(pathFiles + File.separator+ nameXML+File.separator+ "Allegato4"+".pdf");
			all4.selectPages("1");
			copy.addPage(copy.getImportedPage(all4, 1));
			a4= true;
		}
		
//		if(tipoLettera.getFacta() != null && tipoLettera.getFacta().equalsIgnoreCase("SI")){
//			autocertificazione = new PdfReader(pathTemplate +File.separator+"fatca.pdf");
//			autocertificazione.selectPages("1");
//			copy.addPage(copy.getImportedPage(autocertificazione, 1));
//		}
		
		
		if(tipoLettera.getFacta() != null && tipoLettera.getFacta().equalsIgnoreCase("SI")){
			autocertificazione = new PdfReader(pathTemplate +File.separator+"FATCA1.pdf");
			autocertificazione.selectPages("1");
			copy.addPage(copy.getImportedPage(autocertificazione, 1));
			
			autocertificazione = new PdfReader(pathTemplate +File.separator+"FATCA2.pdf");
			autocertificazione.selectPages("1");
			copy.addPage(copy.getImportedPage(autocertificazione, 1));
			
			autocertificazione = new PdfReader(pathTemplate +File.separator+"FATCA3.pdf");
			autocertificazione.selectPages("1");
			copy.addPage(copy.getImportedPage(autocertificazione, 1));
			
			autocertificazione = new PdfReader(pathTemplate +File.separator+"FATCA4.pdf");
			autocertificazione.selectPages("1");
			copy.addPage(copy.getImportedPage(autocertificazione, 1));
			
			autocertificazione = new PdfReader(pathTemplate +File.separator+"FATCA5.pdf");
			autocertificazione.selectPages("1");
			copy.addPage(copy.getImportedPage(autocertificazione, 1));
			
			autocertificazione = new PdfReader(pathTemplate +File.separator+"FATCA6.pdf");
			autocertificazione.selectPages("1");
			copy.addPage(copy.getImportedPage(autocertificazione, 1));
			
			autocertificazione = new PdfReader(pathTemplate +File.separator+"FATCA7.pdf");
			autocertificazione.selectPages("1");
			copy.addPage(copy.getImportedPage(autocertificazione, 1));
		}
		
		
		
        //Aggancio il modulo del beneficiario Terzo
//        if(tipoLettera.getBeneficiarioTerzo() != null && tipoLettera.getBeneficiarioTerzo().equalsIgnoreCase("SI")){
//            autocertificazione = new PdfReader(pathTemplate +File.separator+"moduloBeneficiarioTerzo.pdf");
//            autocertificazione.selectPages("1");
//            copy.addPage(copy.getImportedPage(autocertificazione, 1));
//        }
		
			if(tipoLettera.getBeneficiarioTerzo() != null && tipoLettera.getBeneficiarioTerzo().equalsIgnoreCase("SI")){

				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVBENEFICIARIO1.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVBENEFICIARIO2.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVBENEFICIARIO3.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVBENEFICIARIO4.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVBENEFICIARIO5.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVBENEFICIARIO6.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVBENEFICIARIO7.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVBENEFICIARIO8.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVBENEFICIARIO9.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));

			}

			if(tipoLettera.getBeneficiarioTerzo() != null && tipoLettera.getBeneficiarioTerzo().equalsIgnoreCase("BT")){

				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE1.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE2.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE3.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE4.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE5.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE6.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE7.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE8.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE9.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE10.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE11.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE12.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE13.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));
	
				autocertificazione = new PdfReader(pathTemplate +File.separator+"QAVCONTRAENTE14.pdf");
				autocertificazione.selectPages("1");
				copy.addPage(copy.getImportedPage(autocertificazione, 1));

			}

		doc.close();
		
		File file= new File(pathFiles + File.separator + nameXML+File.separator+ identificativoLettera+".pdf");
		file.delete();
		if(a1)
		{
			file= new File(pathFiles + File.separator + nameXML+File.separator+ "Allegato1"+".pdf");
			file.delete();
		}
		if(a2)
		{
			file= new File(pathFiles + File.separator + nameXML+File.separator+ "Allegato2"+".pdf");
			file.delete();
		}
		if(a3)
		{
			file= new File(pathFiles + File.separator + nameXML+File.separator+ "Allegato3"+".pdf");
			file.delete();
		}
		if(a4)
		{
			file= new File(pathFiles + File.separator + nameXML+File.separator+ "Allegato4"+".pdf");
			file.delete();
		}
		LoggingUtils.info("Fine generazione PDF");

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

	
	public boolean listaOdtTipoLettera(String tipoLettera)
	{
		File f = new File(pathTemplate);
		if (f.isDirectory()) {
			String files[] = f.list();
			for (int i = 0; i < files.length; i++) {
				if(files[i].equalsIgnoreCase(tipoLettera)){
					return true;
				}
			}
		}
		return false;
	}
	
	
	
	/**
     * 
     */
	public EsitoStampaCorrispondenze printCorrispondenzeRendita(String param) {

		String corrRend = null;
		EsitoStampaCorrispondenze esitoStampaCorrispondenze = new EsitoStampaCorrispondenze();

		if(param.equalsIgnoreCase("corrispondenzaRendite"))
			corrRend = pathFilesCorrispondenzeRendita;
		else
			corrRend = "";
		 
		File f = new File(corrRend);
		if (f.isDirectory()) {
			String files[] = f.list();
			for (int i = 0; i < files.length; i++) {
				File file = new File(corrRend + File.separator + files[i]);
				if (!file.isDirectory()) {
					try {
						/*
						 * G.C.-20170420 Per nascondere il bottone relativo alla creazione dei PDF copio il file in una cartella
						 * temporanea che andrò a controllare al caricamento della jsp.
						 * Al termine dell'elaborazione (OK/KO) rimuovo a prescindere il file dalla cartella.
						 * */
						FileUtils.copyFile(file, new File(tempPathFileLavorazione + file.getName()));
						
						printCorrispondenzaBase(file, esitoStampaCorrispondenze);
						saveFile(file, pathFileStampati);
						
						/*
						 * G.C.-20170420 Al termine dell'elaborazione (OK/KO) rimuovo a prescindere il file dalla cartella temporanea.
						 * */
						removeFile(new File(tempPathFileLavorazione + file.getName()));
						
					} catch (Exception e) {
						saveFile(file, pathFileErrori);
						LoggingUtils.error(e);
					}
					removeFile(file);
				}
			}
		}
	
		return esitoStampaCorrispondenze;
	}

	/*
     * 
     */
	public List<String> listaFile(String tipoLista) {
		LoggingUtils.info("lista file tipo: ["+tipoLista+"]");
		
		List<String> listaFile = new ArrayList<String>();
		String param = null;
		if(tipoLista.equalsIgnoreCase("corrispondenzaRendite"))
			param = pathFilesCorrispondenzeRendita+ File.separator;
		else if(tipoLista.equalsIgnoreCase("corrispondenzaRenditeGenerati"))
			param = pathFileGenerati+ File.separator;
		else if(tipoLista.equalsIgnoreCase("corrispondenzaRenditeArchiviare"))
			param=pathFileArchiviati+ File.separator;
		else if(tipoLista.equalsIgnoreCase("corrispondenzaRenditeStampare"))
				{
					param=pathFileStampati;
				}

		
		File f = new File(param);
		if (f.isDirectory()) {
			String files[] = f.list();
			for (int i = 0; i < files.length; i++) {
				if (!(new File(param  + files[i])).isDirectory()) {
					listaFile.add(files[i]);
				}else if(tipoLista.equalsIgnoreCase("corrispondenzeArchiviare")) {
					listaFile.add(files[i]);
				}
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
	
	public boolean archiviaForIsideBucap(String listFiles[]){
		ServiziDiArchiviazione archivia = new ServiziDiArchiviazione();
		return archivia.archiviaForIsideBucap(listFiles);
	}
	public boolean archiviaForStoricoCorrispondenze(String listFiles[]){
		ServiziDiArchiviazione archivia = new ServiziDiArchiviazione();
		return archivia.archiviaForStoricoCorrispondenze(listFiles);
	}
	
	//test main transfer FTP
	public static void main(String args[]) {
//
		Facade facade = new Facade();
		List<String> list = facade.listaFile("corrispondenzaRendite");
		facade.printCorrispondenzeRendita("corrispondenzaRendite");

	}
	
	public boolean isRenditeTemplate(String templateName){
		boolean ret = false;
		if (getRenditeTemplatesList().contains(templateName.toUpperCase())) ret = true;
		return ret;
	}

	public ArrayList<String> getRenditeTemplatesList(){
		ArrayList<String> renditeTemplatesList = new ArrayList<String>();
		renditeTemplatesList.add("LADRC");
		renditeTemplatesList.add("LRNO");
		renditeTemplatesList.add("LRNRC");
		renditeTemplatesList.add("RERE");
		renditeTemplatesList.add("RERRC");
		renditeTemplatesList.add("RICRC");
		renditeTemplatesList.add("RNOAD");
		renditeTemplatesList.add("RREV");
		renditeTemplatesList.add("RRIC");
		return renditeTemplatesList;
	}
}
