package it.beije.utils;

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

@WebServlet("/cerca")
public class SearchNome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchNome() {
        super();
    }
	
	public static StringBuilder CercaNome(String nome) {
		StringBuilder builder = new StringBuilder();
		String query = null;
		
		query = "SELECT * FROM tabella_dipendenti WHERE nome = '" + nome + "'";
		System.out.println("query: " + query);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		
		
		try {
			conn = DButils.getConnection();

			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int id  = rset.getInt("id");
				nome = rset.getString("nome");
				String cognome = rset.getString("cognome");
				String data_nascita = rset.getString("data_nascita");
				String luogo_nascita = rset.getString("luogo_nascita");
				String sesso = rset.getString("sesso");
				String codice_fiscale = rset.getString("codice_fiscale");
				String telefono = rset.getString("telefono");
				String mail = rset.getString("mail");

				builder.append(id).append("&nbsp&nbsp|&nbsp&nbsp").append(nome).append("&nbsp&nbsp|&nbsp&nbsp").append(cognome).append("&nbsp&nbsp|&nbsp&nbsp").append(data_nascita).append("&nbsp&nbsp|&nbsp&nbsp").append(luogo_nascita)
				.append("&nbsp&nbsp|&nbsp&nbsp").append(sesso).append("&nbsp&nbsp|&nbsp&nbsp").append(codice_fiscale).append("&nbsp&nbsp|&nbsp&nbsp").append(telefono).append("&nbsp&nbsp|&nbsp&nbsp").append(mail).append("<br>");
				
			}
			
			}catch (SQLException se) {
				System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
			}
			catch(Exception e) {
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
		System.out.println(builder);
		return builder;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ciao angelica");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
//		String nome = request.getParameter("nome");
//		System.out.println("nome : " + nome);
		
		response.setContentType("text/html");
		
		//response.getWriter().append(SearchNome.CercaNome(request, response));
	}


}


