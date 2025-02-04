package com.fideuram.servizi.cud;


import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.modello.cud.CUD;
import com.fideuram.utils.LoggingUtils;

import freemarker.template.TemplateException;


public class FacadeCUD {
	private static List<String> fileList = new ArrayList<String>();
	
	
	public static void generaErrore(String  codFis)
	{
		try {
			PrintWriter writer = new PrintWriter(
				new BufferedWriter(
					new FileWriter(CrmProperties.getProperty("cud.errori.temp.path")+ "Errori.txt",
						true)));
		
			Date date = new Date();
			writer.write(date+": "+codFis+"\n");
			writer.close();
		} catch (IOException e) {
			LoggingUtils.error(e);
		} 
	}
	
	
	public static List<String> searchFile(File pathFile, String estensione) {
		//List<String> fileList = new ArrayList<String>();
		File listFile[] = pathFile.listFiles();
		if (listFile != null) {
			for (int i = 0; i < listFile.length; i++) {
				if (listFile[i].isDirectory()) {
					searchFile(listFile[i], estensione);
				} else {

					if (estensione != null) {

						if (listFile[i].getName().endsWith(estensione)) {

							fileList.add(listFile[i].toString());
						}

					} else {

						fileList.add(listFile[i].toString());
					}

				}
			}
		}
		return fileList;
	}
	
	
	public static List<String> leggiXmlDaFile() throws IOException
	{
		//List<String> fileList = new ArrayList<String>();
		List<String> rfList = new ArrayList<String>();
		String xml="";
		File f= new File(CrmProperties.getProperty("cud.xml.temp.path"));
		fileList=searchFile(f, "xml");
		for(int i=0; i<fileList.size();i++)
		{
			FileReader reader = new FileReader(fileList.get(i));
		    Scanner in = new Scanner(reader);
		      xml="";
		      while(in.hasNextLine())
		      { xml = xml+in.nextLine();
		      } 
		      rfList.add(xml); 
		      reader.close();
		      in.close();
		    
		}
	
		return rfList;
	}
	
	
	public static String leggiXmlDaFile(String fileXml) throws IOException
	{
		//List<String> fileList = new ArrayList<String>();
		String xml = "";
		File f= new File(CrmProperties.getProperty("cud.xml.temp.path")+File.separator+fileXml);
			FileReader reader = new FileReader(f);
		    Scanner in = new Scanner(reader);
		      xml="";
		      while(in.hasNextLine())
		      { xml = xml+in.nextLine();
		      } 
		      reader.close();
		      in.close();
		return xml;
	}
	
	
	public static void eliminaXmlFile(String fileXml)
	{
		File f= new File(fileXml);
	

	    // Controllo se esiste il file
	    if (!f.exists())
	      throw new IllegalArgumentException("Il File o la Directory non esiste: " + fileXml);

	    // Controllo se il file è writable
	    if (!f.canWrite())
	      throw new IllegalArgumentException("Non ho il permesso di scrittura: " + fileXml);

	    // Verifico cartella vuota
	    if (f.isDirectory()) {
	      String[] files = f.list();
	      if (files.length > 0)
	        throw new IllegalArgumentException("La Directory non è vuota: " + fileXml);
	    }

	    boolean success = f.delete();

	    if (!success)
	      throw new IllegalArgumentException("Cancellazione fallita");
	}
	
	
	
	public static void spostaFileXml(int index, String fileName) throws IOException
	{
		File f= new File(fileList.get(index));

		String asdf= CrmProperties.getProperty("cud.errori.temp.path")+fileName+".xml";
		f.renameTo(new File(asdf));
	}
	
	
	public static void eliminaXmlFile(int index)
	{
		File f= new File(fileList.get(index));
	

	    // Controllo se esiste il file
	    if (!f.exists())
	      throw new IllegalArgumentException("Il File o la Directory non esiste: " + fileList.get(index));

	    // Controllo se il file è writable
	    if (!f.canWrite())
	      throw new IllegalArgumentException("Non ho il permesso di scrittura: " + fileList.get(index));

	    // Verifico cartella vuota
	    if (f.isDirectory()) {
	      String[] files = f.list();
	      if (files.length > 0)
	        throw new IllegalArgumentException("La Directory non è vuota: " + fileList.get(index));
	    }

	    boolean success = f.delete();

	    if (!success)
	      throw new IllegalArgumentException("Cancellazione fallita");
	}
	
	
	
	public static String valoreNodoXml(String xml, String element) throws SAXException, IOException, ParserConfigurationException
	{
		String valore="";
//		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//		DocumentBuilder db = dbf.newDocumentBuilder();
		
	    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//	    dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
//	    dbf.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
	    DocumentBuilder db = dbf.newDocumentBuilder();
	/**********************************************************************************/
		
		ByteArrayInputStream bis = new ByteArrayInputStream(xml.getBytes());
		Document doc = db.parse(bis);
		Node n = doc.getFirstChild();
		NodeList nl = n.getChildNodes();
		Node an,an2;
		
		for (int i=0; i < nl.getLength(); i++) {
		    an = nl.item(i);
		    if(an.getNodeType()==Node.ELEMENT_NODE) {
		        NodeList nl2 = an.getChildNodes();
		        for(int i2=0; i2<nl2.getLength(); i2++) {
		           an2 = nl2.item(i2);
		               if(an2.hasChildNodes() && an2.getNodeName().equals(element) && an2.getTextContent().length()==16)
		               valore=an2.getTextContent();
		        }

		    }
		}
		return valore;
	}
	
	public File getStampa(String xml) throws SAXException, IOException, ParserConfigurationException{
        CUD cud=new CUD();
        File cudS = null;
            try {
				Converter.xml2Object(cud,xml);
				//cudS = new Cud().stampa((CUD)Converter.xml2Object(cud,xml));
				
			} catch (JAXBException e) {
				 LoggingUtils.error(e);
				 generaErrore(valoreNodoXml(xml,"codFis"));
			} catch (ClassNotFoundException e) {
				 LoggingUtils.error(e);
				 generaErrore(valoreNodoXml(xml,"codFis"));
			} catch (IllegalAccessException e) {
				 LoggingUtils.error(e);
				 generaErrore(valoreNodoXml(xml,"codFis"));
			} catch (InstantiationException e) {
				 LoggingUtils.error(e);
				 generaErrore(valoreNodoXml(xml,"codFis"));
			} catch (Exception e) {
				 LoggingUtils.error(e);
				 generaErrore(valoreNodoXml(xml,"codFis"));
			}
			return cudS;
    
    }

	
	public static void cudXmlToOdt() throws SAXException, IOException, ParserConfigurationException
	{
		LoggingUtils.info("START");
			List<String> listXml = new ArrayList<String>();
			String fileName="";
			String xml ="";
			int index=0;
			try {
                listXml = leggiXmlDaFile();
                for(int i=0; i<listXml.size(); i++){
                    index=i;
                    xml="";
                    xml= listXml.get(i);
                    File file;
                    file = new  FacadeCUD().getStampa(xml);
                    byte[] odt= StreamerFactory.getStreamFromFile(file);
                    fileName = file.getName();
                    eliminaXmlFile(i);
                    LoggingUtils.info("END");
                }
			} catch (SAXException e) {
                LoggingUtils.error(e);
                erroreXmlToOdt(fileName,index,xml);
			} catch (IOException e) {
                LoggingUtils.error(e);
				erroreXmlToOdt(fileName,index,xml);
			} catch (ParserConfigurationException e) {
                LoggingUtils.error(e);
                erroreXmlToOdt(fileName,index,xml);
			}
	}

	
	
	
	public static void cudXmlToOdt(String fileXml) throws SAXException, IOException, ParserConfigurationException
	{
		LoggingUtils.info("START");
		String xml = "";
		String fileName="";
		try { 
		    xml = leggiXmlDaFile(fileXml);
	        File file;
			file = new  FacadeCUD().getStampa(xml);
	        byte[] odt= StreamerFactory.getStreamFromFile(file);
	        fileName = file.getName();
	        eliminaXmlFile(CrmProperties.getProperty("cud.xml.temp.path")+File.separator+fileXml);
	        LoggingUtils.info("END");		        
		} catch (SAXException e) {
            LoggingUtils.error(e);
            generaErrore(valoreNodoXml(xml,"codFis"));
		} catch (IOException e) {
            LoggingUtils.error(e);
            generaErrore(valoreNodoXml(xml,"codFis"));
		} catch (ParserConfigurationException e) {
            LoggingUtils.error(e);
			generaErrore(valoreNodoXml(xml,"codFis"));
		}
	}
	
	public static void erroreXmlToOdt(String fileName, int index, String xml) throws SAXException, IOException, ParserConfigurationException
	{
    	String fn= fileName.replace(".odt", "");
    	int bin=0;
    	int ein=0;
    	bin= fn.indexOf("_");
    	ein=fn.lastIndexOf("_");
    	fn= fn.substring(bin+1, ein);
    	spostaFileXml(index,fn);
    	generaErrore(valoreNodoXml(xml,"codFis"));
	}
	
	
	
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws TemplateException 
	 */

	public static void main(String[] args) throws Exception {
		File f= new File(CrmProperties.getProperty("cud.xml.temp.path"));
		fileList=searchFile(f, "xml");
		for(int i=0; i<fileList.size();i++)
		{
			cudXmlToOdt(fileList.get(i).replace(CrmProperties.getProperty("cud.xml.temp.path"), ""));
		}
//		LoggingUtils.info("START");
////		List<CUD> cud = Cud.execute();
////		for (int i =0; i<cud.size(); i++){
//			//String xml = Converter.objectToXml(cud.get(i));
//			List<String> listXml = new ArrayList<String>();
//			listXml = leggiXmlDaFile();
//			String xml ="";
//			for(int i=0; i<listXml.size(); i++){
//				xml= listXml.get(i);
//		        File file =new  FacadeCUD().getStampa(xml);
//		        byte[] odt= StreamerFactory.getStreamFromFile(file);
//		        //byte[] pdf= PdfFactory.getPdfFromOdt(odt);
//		        //if(StreamerFactory.saveFile(pdf, CrmProperties.getProperty("cud.generated.temp.path"), file.getName().replace(".odt", "")+".pdf").length()>0)
//		        if(odt.length>0)
//		        {
//		        	//StreamerFactory.saveFile(pdf, CrmProperties.getProperty("cud.generated.temp.path"), file.getName().replace(".odt", "")+".pdf");
//	        	    eliminaXmlFile(i);
//		        }
//		        else
//		        {
//		        	String fn= file.getName().replace(".odt", "");
//		        	int bin=0;
//		        	int ein=0;
//		        	bin= fn.indexOf("_");
//		        	ein=fn.lastIndexOf("_");
//		        	fn= fn.substring(bin+1, ein);
//		        	spostaFileXml(i,fn);
//		        	generaErrore(valoreNodoXml(xml,"codFis"));
//		        }
//		        LoggingUtils.info("END");
//		        xml="";
//			}
//		}       
	}

}
