package br.com.fjn.pdv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_produto")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "gen_produto", sequenceName = "seq_produto")
	private Integer codProduct;
	@NotNull @NotEmpty @Size(min = 0)
	private String name;
	@Min(value = 0, message="{unitary.value}")
	private double unitaryValue;
	@NotNull @NotEmpty @Size(min = 0)
	private String manufacturer;
	@Min(value=0, message="{amount.negative}")
	private Integer amount;
	
	
	public Integer getCodProduct() {
		return codProduct;
	}
	public void setCodProduct(Integer codProduct) {
		this.codProduct = codProduct;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getUnitaryValue() {
		return unitaryValue;
	}
	public void setUnitaryValue(double unitaryValue) {
		this.unitaryValue = unitaryValue;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}	
}