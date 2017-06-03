package br.com.fjn.pdv.DAO;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.Office;
import br.com.fjn.pdv.model.Product;
import br.com.fjn.pdv.model.User;

public class UserDAO {

	public void addUser(User user){
		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		em.close();
	}
	public User searchUserId(User user) {
		EntityManager em = Connection.getManager();
		return em.find(User.class, user.getCodUser());
	}
	
	public void removeUserId(User user) {
	
		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		em.remove(em.find(User.class, user.getCodUser()));
		em.getTransaction().commit();
		em.close();
	}

	
	public void updateUser(User user){
		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		em.merge(user);
		em.getTransaction().commit();
		em.close();
	}
	public User userExist(User user){
		
		
		EntityManager em = Connection.getManager();

			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<User> criteria = cb.createQuery(User.class);
			Root<User> entidadeRaiz = criteria.from(User.class);
			Predicate userNamePredicate = cb.equal(entidadeRaiz.get("userName"), user.getUserName());
			Predicate passwordPredicate = cb.equal(entidadeRaiz.get("password"), user.getPassword());
			Predicate nameAndPasswod = cb.and(userNamePredicate, passwordPredicate);
			
		 	criteria.where(nameAndPasswod);
		
		 	return em.createQuery(criteria).getSingleResult();
	}
	
	public User searchUser(String nameSearch){
		EntityManager em = Connection.getManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> entidadeRaiz = criteria.from(User.class);
		criteria.where(cb.equal(entidadeRaiz.get("userName"), nameSearch));
		return em.createQuery(criteria).getSingleResult();
	}
	
	public Employee checkOffice(Office office){
		EntityManager em = Connection.getManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
		Root<Employee> entidadeRaiz = criteria.from(Employee.class);
		Predicate managerPredicate = cb.equal(entidadeRaiz.get("office"), office.ADMINISTRADOR);
		Predicate salesmanPredicate = cb.equal(entidadeRaiz.get("office"), office.VENDEDOR);
		Predicate managerAndsalesman = cb.and(managerPredicate, salesmanPredicate);
		criteria.where(managerAndsalesman);
		
		return em.createQuery(criteria).getSingleResult();
		
	}

}