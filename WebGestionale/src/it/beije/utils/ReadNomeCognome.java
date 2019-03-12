package it.beije.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadNomeCognome {
	
	//per leggere nome e cognome inseriti nel db collegato con ReadNome.jsp
	public static String readNomeCognome() {
		StringBuilder builder = new StringBuilder();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = DButils.getConnection();
		
			String query = "SELECT nome, cognome from tabella_dipendenti";


			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			while (rset.next()) {

				String nome = rset.getString("nome");
				String cognome = rset.getString("cognome");


			builder.append(nome).append("&nbsp&nbsp|&nbsp&nbsp").append(cognome).append("<br>");
			
			if (query == null) {
				System.out.println("Nessun Dipendente trovato..");
			}
			}
			
			}catch (SQLException se) {
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
			
			
		return builder.toString();
	}
}



