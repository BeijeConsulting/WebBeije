package utils;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	
	public String readFile() throws Exception {
		StringBuilder builder = new StringBuilder();
		
		//leggo il file e carico ciascuna riga in un array di stringhe
		List<String> strings = CSVutils.getFileAsStrings("C:\\temp\\rubrica.txt"); // TODO: Da cambiare path file

		//ciclo sull'array di stringhe
		for (String row : strings) {
			builder.append(row).append("\n");
		}
		
		return builder.toString();
	}

}
