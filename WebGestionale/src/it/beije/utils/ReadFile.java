package it.beije.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class ReadFile {
	
	//per leggere il file del db collegato a ReadFile.jsp
	public static String readFile() {
		StringBuilder builder = new StringBuilder();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = DButils.getConnection();
			
			
			String query = "SELECT * from tabella_dipendenti";


			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int id = rset.getInt("id");
				String nome = rset.getString("nome");
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
