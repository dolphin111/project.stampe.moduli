package com.fideuram.stampe.corrispondenze;

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
    	String forward = null;
    	if(paramFunction==null){
    		forward =null;
    	}
    	else{
	    	for(int i=0;i<paramFunction.length;i++){
	    		input=paramFunction[i];
	    		LoggingUtils.info("Servlet ArchiviazioneServlet Init-->funzione chiamata:"+input);
	    	}
	    	forward = this.gestisciForward(input);
    	}
    	
    	if(forward!=null){
	    	//file selezionati
	    	if(forward.equalsIgnoreCase("corrispondenzaRenditeArchivia")){
	    		paramSelected=request.getParameterValues("corrispondenzaRenditeArchiviare");
	    		try{
	    			resultArchiviazione = facade.archiviaForIsideBucap(paramSelected);
		    		if(resultArchiviazione){
		    			message = "Archiviazione avvenuta con successo";
		    			SenderMail.sendMailBucap(paramSelected,"archivia");
		    		}
		    		else{
		    			LoggingUtils.error("error--->"+"Impossibile archiviare il file zip. Il file potrebbe non essere piu' disponibile o protetto da scrittura ");
		    			message = "Impossibile archiviare il file zip. Il file potrebbe non essere piu' disponibile o protetto da scrittura ";
		    		}
	    		}
	    		catch(Exception e){
	    			LoggingUtils.error("error--->"+e.getMessage());
	    			message = "Impossibile archiviare il file zip";
	    		}

	    	}
	    	else{ //archivia stampati ("storicizza")
	    		paramSelected=request.getParameterValues("corrispondenzaRenditeStampare");
	    		try{
	    			resultArchiviazione = facade.archiviaForStoricoCorrispondenze(paramSelected);
		    		if(resultArchiviazione){
		    			LoggingUtils.info("============================>Stampa avvenuta con successo ... invio email a bucap ...");
		    			message = "Stampa avvenuta con successo";
		    			SenderMail.sendMailBucap(paramSelected,"creaPdf");
		    		}
		    		else{
		    			LoggingUtils.error("error--->"+"Impossibile archiviare il file zip. Il file potrebbe non essere piu' disponibile o protetto da scrittura ");
		    			message = "Impossibile archiviare il file zip. Il file potrebbe non essere piu' disponibile o protetto da scrittura ";
		    		}
	    		}
	    		catch(Exception e){
	    			LoggingUtils.error("error--->"+e.getMessage());
	    			message = "Impossibile archiviare il file zip";
	    		}

	    	}
    	}
    	
    	
    	
    	//liste statiche
    	List<String> listaFileCorrispondenzaRendite = facade.listaFile("corrispondenzaRendite");
		List<String> listaFileCorrispondenzaRenditeGenerati = facade.listaFile("corrispondenzaRenditeGenerati");
		List<String> listaFileCorrispondenzaRenditeArchiviare = facade.listaFile("corrispondenzaRenditeArchiviare");
		
		request.setAttribute("listaFileCorrispondenzaRendite", listaFileCorrispondenzaRendite);
		request.getSession().setAttribute("listaFileCorrispondenzaRenditeGenerati", listaFileCorrispondenzaRenditeGenerati);
		request.getSession().setAttribute("listaFileCorrispondenzaRenditeArchiviare", listaFileCorrispondenzaRenditeArchiviare);
		
		request.setAttribute("message", message);
		
    	
    	RequestDispatcher view = request.getRequestDispatcher("/listaCorrispondenzaRendite.jsp");
		
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
		if(input.equalsIgnoreCase("Archivia Corrispondenze")){
			result = "corrispondenzaRenditeArchivia";
		}
		
		else{
			result = "corrispondenzaRenditeStoricizza";
		}
		
		return result;
	}
}
