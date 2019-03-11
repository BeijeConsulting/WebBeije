package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButils {
	
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Beije06";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/gestionale?serverTimezone=CET";
	private static Connection conn = null;
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		
		return conn;
	}

	public static void main(String argv[]) {
		
		Statement stmt = null;
		ResultSet rset= null;

		try {
			conn = DButils.getConnection();
			
//			String delete = "delete from tabella_prova where id = 13";

			String query = "SELECT * from tabella_prova";


			stmt = conn.createStatement();

//			stmt.execute(delete);
			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int id = rset.getInt("id");
				String nome = rset.getString("nome");
				String cognome = rset.getString("cognome");

				System.out.println("" + id + " " + nome + " " + cognome);
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