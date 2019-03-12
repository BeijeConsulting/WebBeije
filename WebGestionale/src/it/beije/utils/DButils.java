package it.beije.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {
	
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Beije02";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/gestionale?serverTimezone=CET";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		return conn;
	}
	
	// INSERIMENTO DIPENDENTI
	
	public static void inserimentoDipendente(String nome, String cognome, String dataNascita, String luogoNascita, String sesso, String codiceFiscale, String telefono, String mail) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;

		try {
			conn = DButils.getConnection();
			
			String insert = "INSERT INTO dipendente (codice_fiscale, nome, cognome, sesso, data_nascita, luogo_nascita, mail, telefono) VALUES ( '"+codiceFiscale+"', '"+nome+"', '"+cognome+"', '"+sesso+"', '"+dataNascita+"', '"+luogoNascita+"', '"+mail+"', '"+telefono+"')";

			String query = "SELECT * from dipendente";
			stmt = conn.createStatement();

			stmt.execute(insert);
			rset = stmt.executeQuery(query);
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
		
	}
	
	//VISUALIZZAZIONE TUTTI DIPENDENTI
	
	public static String visualizzaTuttiDipendenti() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;
		String result = "";
		try {
			conn = DButils.getConnection();

			String query = "SELECT * FROM dipendente";
			stmt = conn.createStatement();

			//stmt.execute(insert);
			rset = stmt.executeQuery(query);
			while (rset.next()) {
				result += rset.getInt("id") + " " +  rset.getString("nome") + " " + rset.getString("cognome") + "<br>";
			
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
		return result;
	}
	
	// RICERCA DIPENDENTE SPECIFICO
	
	public static  String cercaDipendente(String nome, String cognome) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;
		String result = "";
		try {
			conn = DButils.getConnection();
			String query = "";
			if(nome != "" && cognome != "" ) {
				query = "SELECT * FROM dipendente WHERE ( nome = '"+nome+"' AND cognome = '"+cognome+"')";
			} else if (nome != "") {
				query = "SELECT * FROM dipendente WHERE ( nome = '"+nome+"')";
			} else if (cognome != "") {
				query = "SELECT * FROM dipendente WHERE ( cognome = '"+cognome+"')";
			}
			
			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);
			while (rset.next()) {
				result += rset.getInt("id") + " " +  rset.getString("nome") + " " + rset.getString("cognome") + "<br>";
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
	return result;
	}
	
}

//	public static void main(String argv[]) {
//		
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rset= null;
//
//		try {
//			conn = DButils.getConnection();
//			
//			String insert = "INSERT INTO tabella_prova VALUES (null, 'edi', 'paperetti', 'M', '20190221')";
//
//			String query = "SELECT * from tabella_prova";
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
//
//				System.out.println("" + id + ", " + nome + ", " + cognome);
//			}
//
//		}
//		catch (SQLException se) {
//			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
//		}
//		catch(Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//		finally {
//			try {
//				rset.close();
//				stmt.close();
//				conn.close();
//			}catch (Exception e) {
//				e.printStackTrace();
//			}
//		}