package it.beije.utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.beije.utils.DButils;

public class CSVutils {
	
//	CREATE TABLE rubrica (
//	  ID int NOT NULL AUTO_INCREMENT,
//	  nome VARCHAR(100),
//	  cognome VARCHAR(100),
//	  telefono VARCHAR(20),
//	  PRIMARY KEY (ID)
//	)

	public static List<String> getFileAsStrings(String pathFile) throws Exception {
		List<String> content = new ArrayList<String>();
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(pathFile));
			
			while(reader.ready()) {
				content.add(reader.readLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				reader.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		}
		
		return content;
	}
	
	public static boolean saveOnDB(String nome, String cognome, char sesso, String mail, String dataNascita) {
		StringBuilder insert = new StringBuilder();
		boolean ret = false;
		Connection conn = null;
		Statement stmt = null;
		
		//ciclo sull'array di stringhe
			
			insert = new StringBuilder("INSERT INTO dipendenti (nome, cognome, sesso, mail, data_nascita) VALUES ('");
			insert.append(nome).append("','");
			insert.append(cognome).append("','");
			insert.append(sesso).append("','");
			insert.append(mail).append("','");
			insert.append(dataNascita).append("')");
			System.out.println(insert.toString());
			
			//mi connetto al DB e lancio la query
			try {
				conn = DButils.getConnection();
				stmt = conn.createStatement();
				stmt.execute(insert.toString());
				ret = true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					stmt.close();
					conn.close();
				} catch (SQLException sqlException) {
					sqlException.printStackTrace();
				}
		}
		
		return ret;
	}
	
	public static StringBuilder selectFromDB() {
		
		StringBuilder sb = new StringBuilder();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;

		try {
			conn = DButils.getConnection();

			String query = "SELECT * from dipendenti";

			stmt = conn.createStatement();

			rset = stmt.executeQuery(query);

			while (rset.next()) {
				int id = rset.getInt("id");
				String nome = rset.getString("nome");
				String cognome = rset.getString("cognome");
				char sesso = rset.getString("sesso").charAt(0);
				String dataNascita = rset.getString("data_nascita");
				String mail = rset.getString("mail");
				
				sb.append(id).append("&nbsp&nbsp").append(nome).append("&nbsp,&nbsp").append(cognome).append("&nbsp,&nbsp")
				.append(sesso).append("&nbsp,&nbsp").append(dataNascita).append("&nbsp,&nbsp").append(mail).append("<br>");

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
		 return sb;
	}

}