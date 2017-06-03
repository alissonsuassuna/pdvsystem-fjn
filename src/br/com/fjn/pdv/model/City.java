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
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_city")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "gen_city", sequenceName = "seq_city")
	private Integer codCity;
	private String name;
	
	@JoinColumn
	@ManyToOne(cascade = CascadeType.ALL)
	private State state;
	
	//Métodos ge e set
	public Integer getCodCity() {
		return codCity;
	}

	public void setCodCity(Integer codCity) {
		this.codCity = codCity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}	
}