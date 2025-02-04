package com.fideuram.stampe.quietanze;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fideuram.stampe.servizi.Facade;
import com.fideuram.utils.LoggingUtils;


public class ArchiviazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * Default constructor. 
     */
    public ArchiviazioneServlet() {
        // TODO Auto-generated constructor stub
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	LoggingUtils.info("Servlet ArchiviazioneServlet Init");
    	Facade facade = new Facade();
    	boolean resultArchiviazione = false;
    	String message = "";
    	//parametro tasto
    	String paramFunction[] = request.getParameterValues("function");
    	String paramSelected[] = null;
    	
    	//parametro funzione
    	String input = null;
    	for(int i=0;i<paramFunction.length;i++){
    		input=paramFunction[i];
    		LoggingUtils.info("Servlet ArchiviazioneServlet Init-->funzione chiamata:"+input);
    	}
    	String forward = this.gestisciForward(input);
    	
    	//file selezionati
    	if(forward.contains("Assegni")){
    		paramSelected=request.getParameterValues("selectedAssegni");
    		try{
    			resultArchiviazione = facade.archiviaForIside(paramSelected);
    		}
    		catch(Exception e){
    			LoggingUtils.error("error--->"+e.getMessage());
    			message = "Impossibile archiviare il file zip: Assegni";
    		}
    	}
    	else if(forward.contains("Bonifici")){
    		paramSelected=request.getParameterValues("selectedBonifici");
    		try{
    			resultArchiviazione = facade.archiviaForBucap(paramSelected);
    			SenderMail.sendMailBucap(paramSelected);
    		}
    		catch(Exception e){
    			LoggingUtils.error("error--->"+e.getMessage());
    			message = "Impossibile archiviare il file zip: Bonifici";
    		}
    	}
    	else{ //archivia stampati ("storicizza")
    		paramSelected=request.getParameterValues("selectedAssegniArchiviare");
    		try{
    			resultArchiviazione = facade.archiviaForStoricoAssegni(paramSelected);
//    			SenderMail.sendMailBucap(paramSelected);
    		}
    		catch(Exception e){
    			LoggingUtils.error("error--->"+e.getMessage());
    			message = "Impossibile storicizzare la cartella: da archiviare";
    		}
    	}
    	
    	message = resultArchiviazione?"archiviazione avvenuta con successo":"ci sono stati problemi nell'archiviazione del file";
    	
    	//liste statiche
    	List<String> listaFileBonifici = facade.listaFile("bonifici");
		List<String> listaFileAssegni = facade.listaFile("assegni");
		List<String> listaFileBonificiGenerati = facade.listaFile("bonificiGenerati");
		List<String> listaFileAssegniGenerati = facade.listaFile("assegniGenerati");
		List<String> listaFileAssegniArchiviare = facade.listaFile("assegniArchiviare");
		
		request.setAttribute("listaFileBonifici", listaFileBonifici);
		request.setAttribute("listaFileAssegni", listaFileAssegni);
		request.getSession().setAttribute("listaFileBonificiGenerati", listaFileBonificiGenerati);
		request.getSession().setAttribute("listaFileAssegniGenerati", listaFileAssegniGenerati);
		request.getSession().setAttribute("listaFileAssegniArchiviare", listaFileAssegniArchiviare);
		
		request.setAttribute("message", message);
		
    	
    	RequestDispatcher view = request.getRequestDispatcher("/listaQuietanze.jsp");
		
	    view.forward(request, response);
    	
    	LoggingUtils.info("Servlet ArchiviazioneServlet End");
    	
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		doGet(request, response);
	}

	private String gestisciForward(String input) {
		String result = null;
		if(input.equalsIgnoreCase("Archivia Bonifici")){
			result = "archiviaBonifici";
		}
		if(input.equalsIgnoreCase("Archivia Assegni")){
			result = "archiviaAssegni";
		}
		
		if(input.equalsIgnoreCase("Storicizza Assegni")){
			result = "storicizza";
		}
		
		return result;
	}
}
