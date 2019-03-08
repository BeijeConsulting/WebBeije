package it.beije.servlet;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CSVutils;

/**
 * Servlet implementation class SimpleWebService
 */
@WebServlet("/SimpleWebService")
public class SimpleWebService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SimpleWebService() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//recupero i dati (da file, da db, da altre fonti...)
			List<String> strings = CSVutils.getFileAsStrings("C:\\temp\\rubrica.txt");
			
			StringBuilder builder = new StringBuilder();
			builder.append("<?xml version=\"1.0\" ?>\n<rubrica>\n");
			
			for (String s : strings) {
				StringTokenizer tokenizer = new StringTokenizer(s, ";");
				String id = tokenizer.nextToken();
				String nome = tokenizer.nextToken();
				String cognome = tokenizer.nextToken();
				String telefono = tokenizer.nextToken();
				
				builder.append("<nominativo>\n");
				builder.append("<id>").append(id).append("</id>\n");
				builder.append("<nome>").append(nome).append("</nome>\n");
				builder.append("<cognome>").append(cognome).append("</cognome>\n");
				builder.append("<telefono>").append(telefono).append("</telefono>\n");
				builder.append("</nominativo>\n");
			}

			builder.append("</rubrica>");

			response.setContentType("text/xml");
			response.getWriter().append(builder.toString());
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(404);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
