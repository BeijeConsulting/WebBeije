package it.beije.gestionale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import it.beije.gestionale.entities.Cliente;
import it.beije.gestionale.entities.Dipendente;
import it.beije.gestionale.entities.StoricoClienti;
import it.beije.gestionale.entities.Tecnologia;

@Deprecated
public class HSfactory {

	private static SessionFactory factory;

	static {
		factory = new Configuration().configure()
				.addAnnotatedClass(Dipendente.class)
				.addAnnotatedClass(Tecnologia.class)
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(StoricoClienti.class)
				.buildSessionFactory();
	}

	public static Session getSession() {
		return factory.openSession();
	}
}