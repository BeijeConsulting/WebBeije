package it.beije.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {
	
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "beije05";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/gestionale?serverTimezone=CET";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		return conn;
	}

		
		public static void inserisciDati(String nome, String cognome, String data_nascita, String luogo_nascita, String sesso, String codice_fiscale, String telefono, String mail ) {
		Connection conn = null;
		Statement stmt = null;


		try {
			conn = DButils.getConnection();
			
			//inserire nuovo dipendente da form
			String insert = "INSERT INTO tabella_dipendenti (nome , cognome, data_nascita, luogo_nascita, sesso, codice_fiscale, telefono, mail) VALUES ('"+nome+"', '"+cognome+"', '"+data_nascita+"' , '"+luogo_nascita+"' , '"+sesso+"' , '"+codice_fiscale+"' , '"+telefono+"' , '"+mail+"')";	
				
					stmt = conn.createStatement();
					stmt.execute(insert);

					
					System.out.println("Dipendente inserito con successo..");
					
					

			
//			String insert = "INSERT INTO tabella_dipendenti VALUES (null, 'antonio', 'rossi', '20/04/1990', 'Roma', 'M', 'ntnsso90d04h895l', '3289654123', 'antonio@gmail.com')";
//
//			String query = "SELECT * from tabella_dipendenti";
//
//
//			stmt = conn.createStatement();
//
//			stmt.execute(insert);
//			rset = stmt.executeQuery(query);
//
//			while (rset.next()) {
//				int id = rset.getInt("id");
//				String nome = rset.getString("nome");
//				String cognome = rset.getString("cognome");
//				String data_nascita = rset.getString("data_nascita");
//				String luogo_nascita = rset.getString("luogo_nascita");
//				String sesso = rset.getString("sesso");
//				String codice_fiscale = rset.getString("codice_fiscale");
//				String telefono = rset.getString("telefono");
//				String mail = rset.getString("mail");
//				
//
//				System.out.println("" + id + ", " + nome + ", " + cognome + ", " + data_nascita + ", " + luogo_nascita + ", " + sesso + ", " + codice_fiscale + ", " + telefono + ", " + mail);
//			}

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
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		}
}

