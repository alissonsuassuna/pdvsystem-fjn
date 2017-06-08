package br.com.fjn.pdv.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_address")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "gen_address", sequenceName = "seq_address")
	private Integer codAddress;
	private String burgh;
	private Integer number;
	private String street;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private City city;

	public Integer getCodAddress() {
		return codAddress;
	}

	public void setCodAddress(Integer codAddress) {
		this.codAddress = codAddress;
	}

	public String getBurgh() {
		return burgh;
	}

	public void setBurgh(String burgh) {
		this.burgh = burgh;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
}
