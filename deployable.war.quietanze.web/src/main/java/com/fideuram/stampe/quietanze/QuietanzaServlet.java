package com.fideuram.stampe.quietanze;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fideuram.stampe.modello.quietanza.EsitoStampaQuietanze;
import com.fideuram.stampe.servizi.Facade;
import com.fideuram.utils.LoggingUtils;

/**
 * Servlet implementation class QuietanzaServlet
 */
public class QuietanzaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public QuietanzaServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException {
		
		try{
		
			LoggingUtils.info("Servlet QuietanzaServlet Init");
			
			Facade facade = new Facade();
			String input = null;
			
			//parametro tasto
			String paramFunction[] = request.getParameterValues("function");
			
			for(int i=0;i<paramFunction.length;i++){
				input=paramFunction[i];
			}
			//recupero funzione
			String funzione = this.gestisciForward(input);

LoggingUtils.info("Servlet QuietanzaServlet 1");
			EsitoStampaQuietanze esitoStampaQuietanze = facade.printQuietanze(funzione);
LoggingUtils.info("Servlet QuietanzaServlet 2");

			request.setAttribute("esitoStampaQuietanze", esitoStampaQuietanze);
LoggingUtils.info("Servlet QuietanzaServlet 3");

			RequestDispatcher view = request.getRequestDispatcher("/esito.jsp");
LoggingUtils.info("Servlet QuietanzaServlet 4");

			List<String> listaFileBonificiGenerati = facade.listaFile("bonificiGenerati");
LoggingUtils.info("Servlet QuietanzaServlet 5");
			List<String> listaFileAssegniGenerati = facade.listaFile("assegniGenerati");
LoggingUtils.info("Servlet QuietanzaServlet 6");
			List<String> listaFileAssegniArchiviare = facade.listaFile("assegniArchiviare");
LoggingUtils.info("Servlet QuietanzaServlet 7");

			request.getSession().setAttribute("listaFileBonificiGenerati", listaFileBonificiGenerati);
LoggingUtils.info("Servlet QuietanzaServlet 8");
			request.getSession().setAttribute("listaFileAssegniGenerati", listaFileAssegniGenerati);
LoggingUtils.info("Servlet QuietanzaServlet 9");
			request.getSession().setAttribute("listaFileAssegniArchiviare", listaFileAssegniArchiviare);
LoggingUtils.info("Servlet QuietanzaServlet 10");

		    view.forward(request, response);
LoggingUtils.info("Servlet QuietanzaServlet 2");

		    LoggingUtils.info("Servlet QuietanzaServlet End");
		}catch(Exception e){
			 e.printStackTrace();
			 LoggingUtils.error("QuietanzaServlet Error : "+e.getLocalizedMessage());
		   }
	
	}

	private String gestisciForward(String input) {
		String result = null;
		if(input.equalsIgnoreCase("Crea PDF Assegni")){
			result = "assegni";
		}
		if(input.equalsIgnoreCase("Crea PDF Bonifici")){
			result = "bonifici";
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
