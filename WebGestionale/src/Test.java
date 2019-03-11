

import java.io.IOException;
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
		
		//JPA
//		EntityManagerFactory emfactory = JpaEntityManager.getInstance();
//		EntityManager entitymanager = emfactory.createEntityManager();
//		entitymanager.getTransaction().begin();
//
//		Dipendente d = new Dipendente();
//		//d.setId(1);  
//		d.setNome("sonoo");  
//		d.setCognome("jaiswal");
//
//		entitymanager.persist(d);
//		entitymanager.getTransaction().commit();
//
//		entitymanager.close();
//		emfactory.close();
//		System.out.println("successfully saved");
		
		//H
		Session session = HSfactory.getSession();
		Transaction t = session.beginTransaction();
		
		Dipendente d = new Dipendente();
		//d.setId(1);  
		d.setNome("sonoo");  
		d.setCognome("jaiswal");
		session.save(d);

		t.commit();
		System.out.println("successfully saved");
		session.close();   

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
