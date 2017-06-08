package br.com.fjn.pdv.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.fjn.pdv.model.Address;
import br.com.fjn.pdv.model.City;
import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.Office;
import br.com.fjn.pdv.model.State;
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
	
	public void removeUser(User user) {
	
		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		User u = searchUser(user);
		em.remove(u);
		//em.remove(user);
		em.getTransaction().commit();
		em.close();
	}

	
	public void updateUser(User user, Employee employee, Address address, City city, State state,
			Office office, String email, String street,String burgh, int number,
			String city_name, String state_name){
		
		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		
		state.setName(state_name);
		
		city.setState(state);
		city.setName(city_name);
		
		address.setCity(city);
		address.setStreet(street);
		address.setBurgh(burgh);
		address.setNumber(number);
		
		employee.setAddress(address);
		employee.setEmail(email);
		
		user.setEmployee(employee);
		user.setPassword(user.getPassword());
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
		 	List<User> result = em.createQuery(criteria).getResultList();	
		    if (result.isEmpty()){
		    	return null;
		    }
		 	return result.get(0);
		 	
	}
	
	public User searchUser(User user){
		EntityManager em = Connection.getManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<User> criteria = cb.createQuery(User.class);
		Root<User> entidadeRaiz = criteria.from(User.class);
		criteria.where(cb.equal(entidadeRaiz.get("userName"), user.getUserName()));
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