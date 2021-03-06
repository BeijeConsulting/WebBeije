package it.beije.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import utils.CSVutils;


/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/servlet")
public class ServletTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		StringBuilder builder = new StringBuilder();
//		Enumeration<String> paramNames = request.getParameterNames();
//		String name;
//		while (paramNames.hasMoreElements()) {
//			name = paramNames.nextElement();
//			builder.append(name).append(" : ")
//			.append(request.getParameterMap().get(name)[0])
//			.append("<br>");
//		}
//		
//		response.setContentType("text/html");
//		response.getWriter().append("Served at: ").append(request.getContextPath())
//		.append("    <br><br>    ").append(request.getRemoteAddr()).append("    <br><br>    ")
//		.append("ELENCO PARAMETRI<br><br>").append(builder.toString());

//		response.setContentType("text/html");
//		response.getWriter().append("ciao GET");

		try {
			response.setContentType("text/plain");
			response.getWriter().append(new CSVutils().readFile().toString());
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
		User user = new User();
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		request.getSession().putValue("utente", user);

		response.sendRedirect("user.jsp");
	}

}
