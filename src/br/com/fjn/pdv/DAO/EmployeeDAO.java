package br.com.fjn.pdv.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.Query;

import org.hibernate.Criteria;

import org.hibernate.Session;

import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.Product;
import br.com.fjn.pdv.model.User;

public class EmployeeDAO {
	
	
	public Employee searchEmployee(String employee){
		
		EntityManager em = Connection.getManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Employee> criteria = cb.createQuery(Employee.class);
		Root<Employee> entidadeRaiz = criteria.from(Employee.class);
		criteria.where(cb.equal(entidadeRaiz.get("name"), employee));
		return em.createQuery(criteria).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Employee> listEmployee() {
	        
		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		Query query = em.createQuery("select employee from Employee employee");
		List<Employee> employee = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return employee;
     }
	
	public Employee searchEmployeeId(Employee employee) {
		EntityManager em = Connection.getManager();
		return em.find(Employee.class, employee.getCpf());
	}

	public void removeEmployeeId(Employee employee) {

		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		em.remove(em.find(Employee.class, employee.getCpf()));
		em.getTransaction().commit();
		em.close();
	} 
}
