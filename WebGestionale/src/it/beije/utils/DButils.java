package it.beije.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {

	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "pomino2656";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/gestionale?serverTimezone=CET";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

		return conn;
	}

	public static String mostraDipendenti() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		String listaDipendenti = "";
		try {
			conn = DButils.getConnection();
			String query = "SELECT * from dipendenti";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				listaDipendenti += rset.getInt("id") + " " + rset.getString("nome") + " " + rset.getString("cognome")
						+ "<br>";
			}
			rset.close();
			stmt.close();
		} catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return listaDipendenti;
	}

	public static void inserimentoDipendente(String nome, String cognome, String dataNascita, String luogoNascita,
			String sesso, String codiceFiscale, String telefono, String mail) {
		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DButils.getConnection();

			String insert = "INSERT INTO dipendenti (codice_fiscale, nome, cognome, sesso, data_nascita, luogo_nascita, mail, telefono) VALUES ( '"
					+ codiceFiscale + "', '" + nome + "', '" + cognome + "', '" + sesso + "', '" + dataNascita + "', '"
					+ luogoNascita + "', '" + mail + "', '" + telefono + "')";

			stmt = conn.createStatement();

			stmt.execute(insert);

		} catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static String cercaDipendenteNC(String nome, String cognome) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		String dipendente = "";
		
		try {
			conn = DButils.getConnection();
			String query = "";
			stmt = conn.createStatement();
			
			if (nome != "" && cognome != "") {
				query = "SELECT * from dipendenti WHERE nome = '" + nome + "' AND cognome = '" + cognome + "'";
			} else if (nome != "") {
				query = "SELECT * from dipendenti WHERE nome = '" + nome + "'";
			} else if (cognome != "") {
				query = "SELECT * from dipendenti WHERE cognome = '" + cognome + "'";
			}
			
			rset = stmt.executeQuery(query);
			
			while (rset.next()) {
				dipendente += rset.getInt("id") + " " + rset.getString("nome") + " " + rset.getString("cognome")
						+ "<br>";
			}
			
			rset.close();
			stmt.close();
		} catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dipendente;
	}

	public static String cercaDipendenteID(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		String dipendente = "";
		try {
			conn = DButils.getConnection();
			String query = "SELECT * from dipendenti WHERE id = " + id;
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				if (id != 0) {
					dipendente = rset.getInt("id") + " " + rset.getString("nome") + " " + rset.getString("cognome");
				}
			}
			rset.close();
			stmt.close();
		} catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return dipendente;
	}

//	public static void main(String argv[]) {
//
//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rset = null;
//
//		try {
//			conn = DButils.getConnection();
//
//			String insert = "INSERT INTO tabella_prova VALUES (null, 'edi', 'paperetti', 'M', '20190221')";
//
//			String query = "SELECT * from tabella_prova";
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
//		} catch (SQLException se) {
//			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		} finally {
//			try {
//				rset.close();
//				stmt.close();
//				conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	}

}