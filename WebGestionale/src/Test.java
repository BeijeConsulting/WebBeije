

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.utils.DButils;


/**
 * Servlet implementation class Test
 */

@WebServlet("/test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("successfully saved");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String dataNascita = request.getParameter("data_nascita");
		String luogoNascita = request.getParameter("luogo_nascita");
		String sesso = request.getParameter("sesso");
		String cf = request.getParameter("codice_fiscale");
		String telefono = request.getParameter("telefono");
		String mail = request.getParameter("mail");
		
		DButils.inserisciDati(nome, cognome, dataNascita, luogoNascita, sesso, cf, telefono, mail);
		
		doGet(request, response);	
	}

}
