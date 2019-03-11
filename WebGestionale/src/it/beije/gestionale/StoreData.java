package it.beije.gestionale;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import it.beije.gestionale.entities.Cliente;
import it.beije.gestionale.entities.Dipendente;
import it.beije.gestionale.entities.StoricoClienti;
import it.beije.gestionale.entities.Tecnologia;


public class StoreData {

	public static void main( String[] args ) {
		//StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		//Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		Session session = HSfactory.getSession();
		Transaction t = session.beginTransaction();

		Tecnologia tc = new Tecnologia();
		tc.setTecnologia("Java EE");
		session.save(tc);
		
		Cliente c = new Cliente();
		c.setRagioneSociale("Reply");
		c.setCitta("Milano");
		session.save(c);

		StoricoClienti sc = new StoricoClienti();
		sc.setIdCliente(c.getId());
		sc.setDataInizio(LocalDate.now());
		sc.setDataFine(LocalDate.now().plusMonths(6));
		//sc.setIdDipendente(d.getId());
		session.save(sc);
		
		Dipendente d = new Dipendente();
		//d.setId(1);  
		d.setNome("sonoo");  
		d.setCognome("jaiswal");
		Set<Tecnologia> techs = new HashSet<Tecnologia>();
		techs.add(tc);
		d.setTecnologie(techs);
		d.setStoricoClienti(new ArrayList<StoricoClienti>());
		d.getStoricoClienti().add(sc);
		session.save(d);

//		d.setStoricoClienti(new ArrayList<StoricoClienti>());
//		d.getStoricoClienti().add(sc);

		t.commit();
		System.out.println("successfully saved");
		//factory.close();
		session.close();   
	}
}
