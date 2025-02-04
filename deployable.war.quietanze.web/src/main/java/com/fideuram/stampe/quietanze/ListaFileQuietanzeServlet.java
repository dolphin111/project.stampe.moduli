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

/**
 * Servlet implementation class QuietanzaServlet
 */
public class ListaFileQuietanzeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListaFileQuietanzeServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		LoggingUtils.info("Servlet ListaFileQuietanzeServlet Init");
		
		Facade facade = new Facade();
		
		List<String> listaFileBonifici = facade.listaFile("bonifici");
		List<String> listaFileAssegni = facade.listaFile("assegni");
		List<String> listaFileBonificiGenerati = facade.listaFile("bonificiGenerati");
		List<String> listaFileAssegniGenerati = facade.listaFile("assegniGenerati");
		List<String> listaFileAssegniArchiviare = facade.listaFile("assegniArchiviare");
		
		LoggingUtils.info("Servlet ListaFileQuietanzeServlet liste caricate");
		
		request.setAttribute("listaFileBonifici", listaFileBonifici);
		request.setAttribute("listaFileAssegni", listaFileAssegni);
		request.getSession().setAttribute("listaFileBonificiGenerati", listaFileBonificiGenerati);
		request.getSession().setAttribute("listaFileAssegniGenerati", listaFileAssegniGenerati);
		request.getSession().setAttribute("listaFileAssegniArchiviare", listaFileAssegniArchiviare);
		
		/*G.C.-20170420 Verifico la presenza del file temporaneo copiato nella directory tmpworking per gestire
		 * la visualizzazione del bottone di stampa. Il valore "showButton" è verificato nella jsp
		 * */
		boolean isTempFile = facade.checkTempFile();
		if(isTempFile)
			request.setAttribute("showButton", "false");
		else
			request.setAttribute("showButton", "true");
		
		RequestDispatcher view = request.getRequestDispatcher("/listaQuietanze.jsp");
		
	    view.forward(request, response);
	
	    LoggingUtils.info("Servlet ListaFileQuietanzeServlet End");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		doGet(request, response);
	}

}
