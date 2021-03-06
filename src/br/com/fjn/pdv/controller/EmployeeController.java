package br.com.fjn.pdv.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fjn.pdv.DAO.EmployeeDAO;
import br.com.fjn.pdv.DAO.ProductDAO;
import br.com.fjn.pdv.DAO.UserDAO;
import br.com.fjn.pdv.model.Address;
import br.com.fjn.pdv.model.City;
import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.Office;
import br.com.fjn.pdv.model.Product;
import br.com.fjn.pdv.model.State;
import br.com.fjn.pdv.model.User;

@Controller
public class EmployeeController {

	private final Result result;
	private final Validator validator;

	@Inject
	public EmployeeController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	@Deprecated
	public EmployeeController() {
		this(null, null);
	}

	// ADD FUNCIONARIO
	@Post("/administrador/f-adicionar")
	public void employeeAdd(String emp, User user, Employee employee, Office office, Address address, City city,
			State state) {
		if (emp.equals("a")) {
			employee.setOffice(office.ADMINISTRADOR);
		} else {
			employee.setOffice(office.VENDEDOR);
		}
		city.setState(state);
		address.setCity(city);
		employee.setAddress(address);
		user.setEmployee(employee);
		UserDAO udao = new UserDAO();
		udao.addUser(user);
		result.redirectTo(this).employeeList();
	}

	@Get("/administrador/funcionarioadicionar")
	public void employeeAdd() {

	}

	/*@Get("/administrador/user-remove")
	public void removeUser(User user) {
		UserDAO userDAO = new UserDAO();
		userDAO.removeUserId(user);
	}*/

	// ATUALIZAR FUNCIONARIO
	@Post("/administrador/f-atualizar")
	public void employeeUpdate(User user, Employee employee, Office office, Address address, City city, State state,
			String emp) {

		UserDAO udao = new UserDAO();
		if (emp.equals("a")) {
			employee.setOffice(office.ADMINISTRADOR);
		} else {
			employee.setOffice(office.VENDEDOR);
		}
		User u = udao.searchUser(user);
		udao.updateUser(u, employee, address, city, state, office, employee.getEmail(), address.getStreet(),
				address.getBurgh(), address.getNumber(), city.getName(), state.getName());
		result.redirectTo(this).employeeList();

	}

	@Get("/administrador/funcionarioatualizar")
	public void employeeUpdate() {

	}

	// BUSCAR FUNCIONARIO

	// LISTAR FUNCIONARIOS
	@Get("/administrador/funcionariolistar")
	public List<Employee> employeeList() {

		EmployeeDAO employeeDAO = new EmployeeDAO();

		return employeeDAO.listEmployee();
	}

	// Remove funcionario pelo id na view
	/*@Get("/administrador/funcionarioremover")
	public void EmployeeRemove() {
		
	}*/
	
	/*
	public void EmployeeRemove(User user){
		UserDAO dao = new UserDAO();
		dao.removeUser(user);
		result.redirectTo(this).EmployeeContentRemove();
		
	}
	
	@Get("/removeEmployee")
	public void EmployeeContentRemove(){
		
	}*/

}
