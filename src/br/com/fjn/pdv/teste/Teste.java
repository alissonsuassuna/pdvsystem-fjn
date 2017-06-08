package br.com.fjn.pdv.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import br.com.fjn.pdv.DAO.Connection;
import br.com.fjn.pdv.DAO.EmployeeDAO;
import br.com.fjn.pdv.DAO.SaleDAO;
import br.com.fjn.pdv.DAO.UserDAO;
import br.com.fjn.pdv.model.Address;
import br.com.fjn.pdv.model.City;
import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.ItemSale;
import br.com.fjn.pdv.model.Office;
import br.com.fjn.pdv.model.Sale;
import br.com.fjn.pdv.model.State;
import br.com.fjn.pdv.model.User;

public class Teste {

	public static void main(String[] args) throws ParseException {
		
		//Criação de usuário interno para acessar o sistem
		/*
		State state = new State();
		state.setName("Rio Grande Do Norte");
		City city = new City();
		city.setName("Patu");
		city.setState(state);
		Address address = new Address();
		address.setBurgh("Santa Terezinha");
		address.setStreet("Rua Boa Vista");
		address.setNumber(987);
		address.setCity(city);
		Employee employee = new Employee();
		employee.setAddress(address);
		employee.setCpf(12222233323332l);
		employee.setName("System");
		employee.setOffice(Office.ADMINISTRADOR);
		employee.setEmail("pdv@gmail");
		employee.setDateBirth("01/12/2017");
		User user = new User();
		user.setEmployee(employee);
		user.setPassword("pdv");
		user.setUserName("pdv");
		UserDAO userDao = new UserDAO();
		
		userDao.addUser(user);
		*/
		
		//Listar vendas
		/*SaleDAO udao = new SaleDAO();
		List<ItemSale> i = udao.listSale();
		for (ItemSale itemSale : i) {
			System.out.println(itemSale.getProduct().getName() + "\n" + itemSale.getSale().getValueTotal());
		}*/

		
		//Buscar venda por data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = sdf.parse("06/06/2017");
		Date d = sdf.parse("07/06/2017");
		
		SaleDAO dao = new SaleDAO();
		List<Sale> list = dao.searchSaleByDate(date, d);
		for (Sale sale : list) {
			System.out.println(sale.getDate());
		}
		
		//Update
		/*UserDAO dao = new UserDAO();
		User u = dao.searchUser("pdv");
		u.setPassword("000");
		dao.updateUser(u);*/
		
		
		
	}
}
