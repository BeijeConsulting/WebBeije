

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.beije.gestionale.HSfactory;
import it.beije.gestionale.entities.Cliente;
import it.beije.gestionale.entities.Dipendente;
import it.beije.gestionale.entities.StoricoClienti;
import it.beije.gestionale.entities.Tecnologia;
import it.beije.gestionale.services.JpaEntityManager;
import it.beije.utils.DButils;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset= null;

		try {
			conn = DButils.getConnection();
			
//			String insert = "INSERT INTO tabella_prova VALUES (null, 'edi', 'paperetti', 'M', '20190221')";
//
//			String query = "SELECT * from tabella_prova";
//
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

		response.getWriter().append("successfully saved");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
