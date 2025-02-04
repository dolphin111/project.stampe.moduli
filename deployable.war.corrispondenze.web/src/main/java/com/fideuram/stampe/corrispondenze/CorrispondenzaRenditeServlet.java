package com.fideuram.stampe.corrispondenze;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fideuram.stampe.modello.corrispondenza.*;
import com.fideuram.stampe.printer.EsitoStampaCorrispondenze;
import com.fideuram.stampe.servizi.Facade;
import com.fideuram.utils.LoggingUtils;

/**
 * Servlet implementation class QuietanzaServlet
 */
public class CorrispondenzaRenditeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CorrispondenzaRenditeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		LoggingUtils.info("Servlet CorrispondenzaRenditeServlet Init");
		
		Facade facade = new Facade();
		String input = null;
		
		//parametro tasto
		String paramFunction[] = request.getParameterValues("function");
		
		for(int i=0;i<paramFunction.length;i++){
			input=paramFunction[i];
		}
		//recupero funzione
		String funzione = this.gestisciForward(input); 
		
		EsitoStampaCorrispondenze esitoStampaCorrispondenzaRendite = facade.printCorrispondenzeRendita(funzione);
		List<String> paramSelected = new ArrayList<String>();
		paramSelected= facade.listaFile("corrispondenzaRenditeGenerati");
		String[] ps= paramSelected.toArray(new String[paramSelected.size()]);
		
		request.setAttribute("esitoStampaCorrispondenzaRendite", esitoStampaCorrispondenzaRendite);

		RequestDispatcher view = request.getRequestDispatcher("/esito.jsp");
		
		List<String> listaFileCorrispondenzaRenditeGenerati = facade.listaFile("corrispondenzaRenditeGenerati");
		List<String> listaFileCorrispondenzaRenditeArchiviare = facade.listaFile("corrispondenzaRenditeArchiviare");
		
		request.setAttribute("sendMail", ps);
		request.getSession().setAttribute("listaFileCorrispondenzaRenditeGenerati", listaFileCorrispondenzaRenditeGenerati);
		request.getSession().setAttribute("listaFileCorrispondenzaRenditeArchiviare", listaFileCorrispondenzaRenditeArchiviare);
		
	    view.forward(request, response);
	    
	    LoggingUtils.info("ServletCorrispondenzaRenditeServlet End");
	
	}

	private String gestisciForward(String input) {
		String result = null;
		if(input.equalsIgnoreCase("Crea PDF Rendite")){
			result = "corrispondenzaRendite";
		}

		
		return result;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		doGet(request, response);
	}

}
