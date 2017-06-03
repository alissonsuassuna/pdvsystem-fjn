package br.com.fjn.pdv.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connection {
	
	private static EntityManagerFactory factory;

	public static EntityManagerFactory getFactory() {

		if (factory == null) {
			factory = Persistence.createEntityManagerFactory("PdvFJN");
		}

		return factory;
	}

	public static EntityManager getManager() {
		return getFactory().createEntityManager();
	}
}
