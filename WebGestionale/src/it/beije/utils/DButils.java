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
	private static final String DB_PASSWORD = "Beije01";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/gestionale?serverTimezone=CET";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		return conn;
	}
	
	public static void inserisciDipendente(String codiceFiscale, String nome, String cognome, String sesso, String dataNascita, String luogoNascita, String mail, String telefono ) {
		Connection conn = null;
		Statement stmt = null;
		
		
		try {
			conn = DButils.getConnection();
			stmt = conn.createStatement();
			
			String insert = "INSERT INTO dipendenti (codice_fiscale, nome, cognome, sesso, data_nascita, luogo_nascita, mail, telefono) VALUES ( '"+codiceFiscale+"', '"+nome+"', '"+cognome+"', '"+sesso+"', '"+dataNascita+"', '"+luogoNascita+"', '"+mail+"', '"+telefono+"')";
			stmt.execute(insert);
		}catch(Exception e) {
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
	
	
	public static String visualizzaDipendenti(String nome, String cognome) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;
		String result="", query=""; 
		
		try {
			conn = DButils.getConnection();
			
			if(nome=="" && cognome=="") query = "SELECT * from dipendenti";
			else if(nome!="" && cognome!= "") query = "SELECT * from dipendenti WHERE NOME='"+nome+"' && COGNOME ='"+cognome+"'";
				else if(nome!= "") query = "SELECT * from dipendenti WHERE NOME='"+nome+"'";
				else query = "SELECT * from dipendenti WHERE COGNOME='"+cognome+"'";
			

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()==false) result="NESSUN UTENTE TROVATO";
			else {
				while (rset.next()) {
				
					result += "ID: "+rset.getInt("id")+", ";
					result += "NOME: "+rset.getString("nome")+", ";
					result += "COGNOME: "+rset.getString("cognome")+", ";
					result += "SESSO: "+rset.getString("sesso")+"<br>";
				
				}
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
	
	public static List visualizzaDipendenti(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;
		String query="", result=""; 
		List ris = new ArrayList();
		
		try {
			conn = DButils.getConnection();
			
			query = "SELECT * FROM dipendenti WHERE id = '"+id+"'";
		
			

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset==null) result="NESSUN UTENTE TROVATO";
			else {
				
				
					ris.add(rset.getInt("id"));
					ris.add(rset.getString("nome"));
					ris.add(rset.getString("cognome"));
					ris.add(rset.getString("codice_fiscale"));
					ris.add(rset.getString("data_nascita"));
					ris.add(rset.getString("luogo_nascita"));
					ris.add(rset.getString("sesso"));
					ris.add(rset.getString("telefono"));
					ris.add(rset.getString("mail"));
				
				
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
		
		return ris;
		
	}

	public static void main(String argv[]) {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;

		try {
			conn = DButils.getConnection();
			
			String insert = "INSERT INTO tabella_prova VALUES (null, 'edi', 'paperetti', 'M', '20190221')";

			String query = "SELECT * from tabella_prova";


			stmt = conn.createStatement();

			stmt.execute(insert);
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int id = rset.getInt("id");
				String nome = rset.getString("nome");
				String cognome = rset.getString("cognome");

				System.out.println("" + id + ", " + nome + ", " + cognome);
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
		
	}

}