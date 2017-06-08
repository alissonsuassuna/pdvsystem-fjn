package br.com.fjn.pdv.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.Product;

public class ProductDAO {

	public void AddProduct(Product product) {

		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
	}

	public void updateProduct(Product product, double unitaryValue) {

		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		product.setUnitaryValue(unitaryValue);
		em.merge(product);
		em.getTransaction().commit();
		em.close();
	}

	public Product searchProduct(Product product) {
		
		EntityManager em = Connection.getManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Product> criteria = cb.createQuery(Product.class);
		Root<Product> entidadeRaiz = criteria.from(Product.class);
		criteria.where(cb.equal(entidadeRaiz.get("name"), product.getName()));
		return em.createQuery(criteria).getSingleResult();

	}



	public void removeProductId(Product product) {
		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		em.remove(em.find(Product.class, product.getCodProduct()));
		em.getTransaction().commit();
		em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Product> listProducts() {

		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		Query query = (Query) em.createQuery("select product from Product product");
		List<Product> product = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return product;

	}

	public void upAmountProduct(Product product, int value) {

		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		int amount = product.getAmount();
		int amountTotal = amount + value;
		product.setAmount(amountTotal);
		em.merge(product);
		em.getTransaction().commit();
		em.close();
	}

	public void lowerAmountProduct(Product product, int value) {

		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		int amount = product.getAmount();
		int amountTotal = amount - value;
		product.setAmount(amountTotal);
		em.merge(product);
		em.getTransaction().commit();
		em.close();
	}

}
