package it.beije.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.utils.CSVutils;
import it.beije.utils.DButils;

/**
 * Servlet implementation class RubricaDB
 */
@WebServlet("/rubrica")
public class RubricaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<String> rows = null;
		String tipo = request.getParameter("tipo");
		
		if (tipo != null) {
			if (tipo.equalsIgnoreCase("csv")) {
				rows = CSVutils.getFileAsStrings("C:\\temp\\rubrica.txt");
			} else if (tipo.equalsIgnoreCase("db")) {
				rows = DButils.getRubrica();
			}
		}
		
		response.setContentType("text/html");
		
		if (rows != null) {
			for (String r : rows) {
				response.getWriter().append(r).append("<br>");
			}
		} else {
			response.getWriter().append("SPECIFICARE IL TIPO");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String phone = request.getParameter("phone");
		
		System.out.println("firstname : " + firstname);
		System.out.println("lastname : " + lastname);
		System.out.println("phone : " + phone);
		
		StringBuilder row = new StringBuilder();
		row.append(firstname).append(';');
		row.append(lastname).append(';');
		row.append(phone).append(';');
		
		CSVutils.appendRowsInFile("C:\\temp\\rubrica.txt", row.toString());
		
//		response.setContentType("text/html");
//		response.getWriter()
//		.append("firstname : " + firstname + "<br>")
//		.append("lastname : " + lastname + "<br>")
//		.append("phone : " + phone + "<br>");
		
		response.sendRedirect("end.jsp");
	}

}
