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

import it.beije.gestionale.entities.Dipendente;
import it.beije.utils.DButils;

/**
 * Servlet implementation class findId
 */
@WebServlet("/findId")
public class findId extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findId() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public static Dipendente searchDipendentiId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Dipendente user = new Dipendente();
    	String query = null;
    	
    	if(request.getParameter("id") != "") {
    		query = "SELECT * from dipendenti where id = " + request.getParameter("id");
    		System.out.println(query);
    	} 
        else {
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
				System.out.println(rset.getString("nome"));
				user.setNome(rset.getString("nome"));
				user.setCognome(rset.getString("cognome"));
				user.setSesso(rset.getString("sesso").charAt(0));
				user.setMail(rset.getString("mail"));
				user.setDataNascita(rset.getString("data_nascita"));
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
    	return user;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Dipendente dip = searchDipendentiId(request, response);
		request.getSession().putValue("dipendente", dip);
		response.sendRedirect("FormId.jsp");
	}

}
