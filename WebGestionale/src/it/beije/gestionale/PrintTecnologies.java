package it.beije.gestionale;

import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;


public class PrintTecnologies {

	public static void main(String[] args) {
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//
//		SessionFactory factory = meta.getSessionFactoryBuilder().build();
//		Session session = factory.openSession();

		Session session = HSfactory.getSession();
		Transaction t = session.beginTransaction();
		
//		Criteria criteria = session.createCriteria(Tecnologia.class);
//		List tecnologie = criteria.setMaxResults(1).list();
//
//		Iterator itr = tecnologie.iterator();
//		while (itr.hasNext()) {
//			Tecnologia tech = (Tecnologia) itr.next();
//			System.out.println(tech.getId());
//			System.out.println(tech.getTecnologia());
//		}
		
		String hql = "SELECT id, nome FROM Dipendente";
		Query query = session.createQuery(hql);
		System.out.println(query.list());
		//List<Dipendente> results = query.list();
//		for (Dipendente d : results) {
//			String hqlSC = "FROM StoricoClienti WHERE idDipendente = " + d.getId();
//			Query querySC = session.createQuery(hqlSC);
//			List<StoricoClienti> scList = querySC.list();
//			d.setStoricoClienti(scList);
//			System.out.println("Dipendente : " + d.toString());
//		}
		
		
		
		
//		Tecnologia t1 = session.load(Tecnologia.class, new Integer(1));
//		System.out.println(t1.getId());
//		System.out.println(t1.getTecnologia());

		t.commit();
		//factory.close();
		session.close();   
	}

}
