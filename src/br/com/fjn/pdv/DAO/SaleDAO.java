package br.com.fjn.pdv.DAO;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.fjn.pdv.model.Product;
import br.com.fjn.pdv.model.Sale;

public class SaleDAO {
	
	Calendar calendar = Calendar.getInstance();
	
	public void saveSale(Sale sale){
		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		em.persist(sale);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Sale> searchSaleByDate(Date initialDate, Date finalDate) throws ParseException{
		
		EntityManager em = Connection.getManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Sale> criteria = cb.createQuery(Sale.class);
		Root<Sale> entidadeRaiz = criteria.from(Sale.class);
		criteria.where(cb.between(entidadeRaiz.get("date"), initialDate, finalDate));
		return em.createQuery(criteria).getResultList();
	}
	
	public void valueTotalSale(Product product,Sale sale, int value){
		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		int unitaryValue = (int) product.getUnitaryValue();
		int amountSale = value;
		int valueTotal = unitaryValue * amountSale;
		sale.setValueTotal(valueTotal);
		em.merge(sale);
		em.getTransaction().commit();
		em.close();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Sale> listSale() {

		EntityManager em = Connection.getManager();
		em.getTransaction().begin();
		Query query = (Query) em.createQuery("select sale from Sale sale");
		List<Sale> sale = query.getResultList();
		em.getTransaction().commit();
		em.close();
		return sale;

	}

}
