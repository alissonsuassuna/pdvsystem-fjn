package br.com.fjn.pdv.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class State {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_state")
	@SequenceGenerator(allocationSize = 1, initialValue = 1, name = "gen_state", sequenceName = "seq_state")
	private Integer codState;
	private String name;
	
	//Métodos get e set
	public Integer getCodState() {
		return codState;
	}
	public void setCodState(Integer codState) {
		this.codState = codState;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}