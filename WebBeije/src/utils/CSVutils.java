package utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	
	public static boolean saveOnDB(String nome, String cognome, String telefono) {
		StringBuilder insert = new StringBuilder();
		boolean ret = false;
		Connection conn = null;
		Statement stmt = null;
		
		//ciclo sull'array di stringhe
			
			insert = new StringBuilder("INSERT INTO rubrica (nome, cognome, telefono) VALUES ('");
			insert.append(nome).append("','");
			insert.append(cognome).append("','");
			insert.append(telefono).append("')");
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
	

}
