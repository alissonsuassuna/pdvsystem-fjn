package br.com.fjn.pdv.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.crypto.Data;

@Entity
//@SecondaryTable(name = "sale_product", pkJoinColumns = {@PrimaryKeyJoinColumn(name="id")} )
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_sale")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "gen_sale", sequenceName = "seq_sale")
	private Integer codSale;
	private double valueTotal;
	private Date date;
	
	@JoinColumn
	@ManyToOne
	private Employee employee;
	
	//@JoinTable(name = "sale_product", joinColumns = {@JoinColumn(name="sale_codSale")}, inverseJoinColumns={@JoinColumn(name="product_codProduct")})
	@OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
  private List<ItemSale> itemSale;	
	

	public Integer getCodSale() {
		return codSale;
	}

	public void setCodSale(Integer codSale) {
		this.codSale = codSale;
	}


	public double getValueTotal() {
		return valueTotal;
	}

	public void setValueTotal(double valueTotal) {
		this.valueTotal = valueTotal;
	}

	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ItemSale> getItemSale() {
		return itemSale;
	}

	public void setItemSale(List<ItemSale> itemSale) {
		this.itemSale = itemSale;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}