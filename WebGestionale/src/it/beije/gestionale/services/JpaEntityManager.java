package it.beije.gestionale.services;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManager {
	
	private static EntityManagerFactory emfactoryGestionale = null;
	
	private JpaEntityManager() {}
	
//	static {
//		emfactoryGestionale = Persistence.createEntityManagerFactory( "Gestionale" );
//	}
	
	public static synchronized EntityManagerFactory getInstance() {
		if (emfactoryGestionale == null) {
			emfactoryGestionale = Persistence.createEntityManagerFactory("WebGestionale");
		}
		
		return emfactoryGestionale;
	}
	
}
