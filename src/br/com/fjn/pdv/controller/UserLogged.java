package br.com.fjn.pdv.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.User;

@SessionScoped
@Named
public class UserLogged implements Serializable{
	
	private User user;
	private Employee employee;
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
