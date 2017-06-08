package br.com.fjn.pdv.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemSale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_itemSale")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "gen_itemSale", sequenceName = "seq_itemSale")
	private Integer codItemSale;
	@JoinColumn(name = "sale_codSale", nullable = false)
	@ManyToOne(cascade = CascadeType.ALL)
	private Sale sale;
	@JoinColumn(name = "product_codProduct", nullable = false)
	@OneToOne
	private Product product;
	private Integer amount;
	
	public Integer getCodItemSale() {
		return codItemSale;
	}
	public void setCodItemSale(Integer codItemSale) {
		this.codItemSale = codItemSale;
	}
	public Sale getSale() {
		return sale;
	}
	public void setSale(Sale sale) {
		this.sale = sale;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}