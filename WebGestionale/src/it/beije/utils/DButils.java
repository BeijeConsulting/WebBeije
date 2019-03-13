package it.beije.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

	public static void creaTabella() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = DButils.getConnection();

			System.out.println("Creating table in given database...");
			stmt = conn.createStatement();

			String sql = "CREATE TABLE dipendenti (" + " id int NOT NULL AUTO_INCREMENT," + " nome VARCHAR(100),"
					+ " cognome VARCHAR(100)," + " data_nascita date," + " luogo_nascita VARCHAR(100),"
					+ " sesso char(1)," + " codice_fiscale VARCHAR(20)," + " telefono VARCHAR(20),"
					+ " mail VARCHAR(100)," + " PRIMARY KEY (id)" + ") ";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");

			String insert = "INSERT INTO dipendente VALUES (1, 'edi', 'paperetti', '20190221', 'firenze', 'M', null, null, null)";

			String query = "SELECT * from dipendenti";

//		    stmt = conn.createStatement();

			stmt.execute(insert);
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int id = rset.getInt("id");
				String nome = rset.getString("nome");
				String cognome = rset.getString("cognome");

				System.out.println("" + id + ", " + nome + ", " + cognome);
			}

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
				listaDipendenti += rset.getInt("id") + ": " + rset.getString("nome") + " " + rset.getString("cognome")
						+ ";<br>";
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
				dipendente += rset.getInt("id") + ": " + rset.getString("nome") + " " + rset.getString("cognome") + ", "
						+ rset.getString("data_nascita") + ", " + rset.getString("luogo_nascita") + ", "
						+ rset.getString("sesso") + ", " + rset.getString("codice_fiscale") + ", "
						+ rset.getString("telefono") + ", " + rset.getString("mail") + ";<br>";
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

	public static List<String> cercaDipendenteID(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		List<String> dipendente = new ArrayList<String>();
		try {
			conn = DButils.getConnection();
			String query = "SELECT * from dipendenti WHERE id = " + id;
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				if (id != 0) {
					dipendente.add(String.valueOf(rset.getInt("id")));
					dipendente.add(rset.getString("nome"));
					dipendente.add(rset.getString("cognome"));
					dipendente.add(rset.getString("data_nascita"));
					dipendente.add(rset.getString("luogo_nascita"));
					dipendente.add(rset.getString("sesso"));
					dipendente.add(rset.getString("codice_fiscale"));
					dipendente.add(rset.getString("telefono"));
					dipendente.add(rset.getString("mail"));

//					dipendente = rset.getInt("id") + ": " + rset.getString("nome") + " " + rset.getString("cognome")
//							+ ", " + rset.getString("data_nascita") + ", " + rset.getString("luogo_nascita") + ", "
//							+ rset.getString("sesso") + ", " + rset.getString("codice_fiscale") + ", "
//							+ rset.getString("telefono") + ", " + rset.getString("mail") + ";";
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

}