package it.beije.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.beije.utils.DButils;

/**
 * Servlet implementation class Find
 */
@WebServlet("/find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Find() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static StringBuilder searchDipendenti(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	StringBuilder sb = new StringBuilder();
    	String query = null;
    	
    	if(request.getParameter("nome") != "") {
    		if(request.getParameter("cognome") != "") {
    			query = "SELECT * from dipendenti where nome = '" + request.getParameter("nome") + "' && cognome = '" + request.getParameter("cognome") + "'";
    		}
    		else {
    			query = "SELECT * from dipendenti where nome = '" + request.getParameter("nome") + "'";
    		}
    	} else if (request.getParameter("cognome") != "") {
    		query = "SELECT * from dipendenti where cognome = '" + request.getParameter("cognome") + "'";
    	} else {
    		response.sendRedirect("error.jsp");
    	}
    	
    	Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;

		try {
			conn = DButils.getConnection();

			

			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);
			
			if (rset.next() == false) {
				response.sendRedirect("error.jsp");
			} else {
				rset.beforeFirst();
			}

			while (rset.next()) {
				int id = rset.getInt("id");
				String nome = rset.getString("nome");
				String cognome = rset.getString("cognome");
				char sesso = rset.getString("sesso").charAt(0);
				String dataNascita = rset.getString("data_nascita");
				String mail = rset.getString("mail");

				sb.append(id).append("&nbsp&nbsp").append(nome).append("&nbsp,&nbsp").append(cognome).append("&nbsp,&nbsp")
				.append(sesso).append("&nbsp,&nbsp").append(dataNascita).append("&nbsp,&nbsp").append(mail).append("<br>");

			}

		}
		catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
    	return sb;
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(searchDipendenti(request, response));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append(searchDipendenti(request, response));
	}

}
