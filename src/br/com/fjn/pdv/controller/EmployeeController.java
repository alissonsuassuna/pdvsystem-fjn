package br.com.fjn.pdv.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fjn.pdv.DAO.EmployeeDAO;
import br.com.fjn.pdv.DAO.UserDAO;
import br.com.fjn.pdv.model.Address;
import br.com.fjn.pdv.model.City;
import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.Office;
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

	@Get("/administrador/user-remove")
	public void removeUser(User user) {
		UserDAO userDAO = new UserDAO();
		userDAO.removeUserId(user);
	}

	// ATUALIZAR FUNCIONARIO
	@Post("/administrador/f-atualizar")
	public void employeeUpdate(String emp, User user, Employee employee, Office office, Address address, City city,
			State state) {
		
		EmployeeDAO edao = new EmployeeDAO();
		UserDAO udao = new UserDAO();
		Employee e = edao.searchEmployee(employee);
		if (emp.equals("a")) {
			e.setOffice(office.ADMINISTRADOR);
		} else {
			e.setOffice(office.VENDEDOR);
		}
		user.setEmployee(e);
		udao.updateUser(user, employee, address, city, state);
		result.redirectTo(this).employeeList();
		
	}

	@Get("/administrador/funcionarioatualizar")
	public void employeeUpdate() {

	}

	// BUSCAR FUNCIONARIO
	@Get("/administrador/funcionariobuscar")
	public void employeeSearch(String name) {

	}

	// LISTAR FUNCIONARIOS
	@Get("/administrador/funcionariolistar")
	public List<Employee> employeeList() {

		EmployeeDAO employeeDAO = new EmployeeDAO();

		return employeeDAO.listEmployee();
	}

}
