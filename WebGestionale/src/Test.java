import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

//		Connection conn = null;
//		Statement stmt = null;
//		ResultSet rset= null;

//		try {
//			conn = DButils.getConnection();

//			System.out.println("Creating table in given database...");
//		    stmt = conn.createStatement();

//		    String sql = "CREATE TABLE dipendenti (" + 
//			    		 " id int NOT NULL AUTO_INCREMENT," + 
//			    		 " nome VARCHAR(100)," + 
//			    		 " cognome VARCHAR(100)," + 
//			    		 " data_nascita date," + 
//			    		 " luogo_nascita VARCHAR(100)," + 
//			    		 " sesso char(1)," + 
//			    		 " codice_fiscale VARCHAR(20)," + 
//			    		 " telefono VARCHAR(20)," + 
//			    		 " mail VARCHAR(100)," + 
//			    		 " PRIMARY KEY (id)" + 
//			    		 ") ";
//		    
//		    stmt.executeUpdate(sql);
//		    System.out.println("Created table in given database...");

//			String insert = "INSERT INTO dipendente VALUES (1, 'edi', 'paperetti', '20190221', 'firenze', 'M', null, null, null)";
//
//		    String query = "SELECT * from dipendenti";
//			
//		    stmt = conn.createStatement();
//		    
//		    stmt.execute(insert);
//		    rset = stmt.executeQuery(query);
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
		response.getWriter().append("successfully saved");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doGet(request, response);
	}

}
