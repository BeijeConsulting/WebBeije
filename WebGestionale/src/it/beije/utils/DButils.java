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
	private static final String DB_PASSWORD = "Beije03";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/gestionale?serverTimezone=CET";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection conn = null;
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		return conn;
	}

	public static void inseriscidipendente (String nome, String cognome,String data_nascita,
			String luogo_nascita, String genere, String telefono,String email) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DButils.getConnection();
			stmt = conn.createStatement();

			String insert = "INSERT INTO dipendente (nome,cognome,data_nascita,luogo_nascita,genere,telefono,email) VALUES "
					+ "('"+nome+"', '"+cognome+"','"+data_nascita+"','"+luogo_nascita+"','"+genere+"','"+telefono+"','"+email+"')";
			stmt.execute(insert);
		}catch (Exception e){
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
	
	public static void modificadipendente (String ID, String nome, String cognome,String data_nascita,
			String luogo_nascita, String genere, String telefono,String email) {

		Connection conn = null;
		Statement stmt = null;

		try {
			conn = DButils.getConnection();
			stmt = conn.createStatement();

			String update = "UPDATE dipendente nome = '"+nome+"',cognome = '"+cognome+"',data_nascita = '"+data_nascita+"',luogo_nascita = '"+luogo_nascita+"',genere = '"+genere+"',telefono = '"+telefono+"',email = '"+email+"') Where ID = '"+ID+"' ";
					
			stmt.execute(update);
		}catch (Exception e){
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
	
	public static List visualizzadip (int ID) {
		
		Connection conn = null;
		Statement stmt = null;
		String query = "";
		ResultSet rset = null;
		List risultato = new ArrayList ();
		
		try {
			conn = DButils.getConnection();
			stmt = conn.createStatement();
			
			query = "Select * from dipendente where id = '"+ID+"' "; 
			
		rset = stmt.executeQuery(query);
	
		if (rset.next()==false) risultato.add("Nessun risultato trovato"); 
		else {
			
			risultato.add(rset.getInt("ID"));
			risultato.add(rset.getString("nome"));
			risultato.add(rset.getString("cognome"));
			risultato.add(rset.getString("data_nascita"));
			risultato.add(rset.getString("luogo_nascita"));
			risultato.add(rset.getString("genere"));
			risultato.add(rset.getString("telefono"));
			risultato.add(rset.getString("email"));
		}
		
		}catch (Exception e){
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
		return risultato;
	}
		

	
	public static String visualizzadip(String nome, String cognome) {
		
		Connection conn = null;
		Statement stmt = null;
		String result = "";
		String query = "";
		ResultSet rset = null;

		try {
			conn = DButils.getConnection();
			stmt = conn.createStatement();
			
			if (nome == "" && cognome == "") query = "select * from dipendente";
			else if (nome != "" && cognome != "") query = "select * from dipendente where nome = '"+nome+"' && cognome = '"+cognome+"'";
			else if (nome != "") query = "select * from dipendente where nome = '"+nome+"'";
			else query =  "select * from dipendente where cognome = '"+cognome+"'";
			
		rset = stmt.executeQuery(query);
		System.out.println(result);
		if (rset.next()==false) result="Nessun risultato trovato"; 
		else {
		while(rset.next()) {
			
			result += "ID"+rset.getInt("ID")+", ";
			result += "nome"+rset.getString("nome")+", ";
			result += "cognome"+rset.getString("cognome")+"<br/>";
		}
		}
		
		}catch (Exception e){
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
		return result;
	}
}
