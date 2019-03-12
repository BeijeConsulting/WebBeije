package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

	public static void main(String argv[]) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;

		try {
			conn = DButils.getConnection();
			
			String insert = "INSERT INTO tabella_prova VALUES (null, 'maria', 'rossi', 'F', '2569'";
			String query = "SELECT * tabella_prova";
			
			stmt = conn.createStatement();

			 stmt.execute(insert);
			rset = stmt.executeQuery(query);


			while (rset.next()) {
				int id = rset.getInt("id");
				String nome = rset.getString("nome");
				String cognome = rset.getString("cognome");

				System.out.println("" + id + "\t" + nome + "     \t" + cognome);
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

}

