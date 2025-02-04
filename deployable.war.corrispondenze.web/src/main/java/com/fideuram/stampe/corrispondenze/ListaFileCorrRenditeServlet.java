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

/**
 * Servlet implementation class QuietanzaServlet
 */
public class ListaFileCorrRenditeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListaFileCorrRenditeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		LoggingUtils.info("Servlet ListaFileCorrRenditeServlet Init");
		
		Facade facade = new Facade();
		
		List<String> listaFileCorrispondenzaRendite = facade.listaFile("corrispondenzaRendite");

		List<String> listaFileCorrispondenzaRenditeGenerati = facade.listaFile("corrispondenzaRenditeGenerati");
		List<String> listaFileCorrispondenzaRenditeArchiviare = facade.listaFile("corrispondenzaRenditeArchiviare");
		
		LoggingUtils.info("Servlet ListaFileCorrRenditeServlet liste caricate");
		
		request.setAttribute("listaFileCorrispondenzaRendite", listaFileCorrispondenzaRendite);
		request.getSession().setAttribute("listaFileCorrispondenzaRenditeGenerati", listaFileCorrispondenzaRenditeGenerati);
		request.getSession().setAttribute("listaFileCorrispondenzaRenditeArchiviare", listaFileCorrispondenzaRenditeArchiviare);
		
		/*G.C.-20170420 Verifico la presenza del file temporaneo copiato nella directory tmpworking per gestire
		 * la visualizzazione del bottone di stampa. Il valore "showButton" è verificato nella jsp
		 * */
		boolean isTempFile = facade.checkTempFile();
		if(isTempFile)
			request.setAttribute("showButton", "false");
		else
			request.setAttribute("showButton", "true");
		
		RequestDispatcher view = request.getRequestDispatcher("/listaCorrispondenzaRendite.jsp");
		
	    view.forward(request, response);
	
	    LoggingUtils.info("Servlet ListaFileCorrRenditeServlet End");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		doGet(request, response);
	}

}
