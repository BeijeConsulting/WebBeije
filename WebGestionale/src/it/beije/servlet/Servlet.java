package it.beije.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.utils.DButils;


/**
 * Servlet implementation class ServletTest
 */
@WebServlet("/servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String data_nascita = request.getParameter("data_nascita");
			String luogo_nascita = request.getParameter("luogo_nascita");
			String genere = request.getParameter("genere");
			String telefono = request.getParameter("telefono");
			String email = request.getParameter("email");
			DButils.inseriscidipendente(nome, cognome, data_nascita, luogo_nascita, genere, telefono, email);
		}
	
		
	}

