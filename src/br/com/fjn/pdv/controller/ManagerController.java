package br.com.fjn.pdv.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fjn.pdv.DAO.EmployeeDAO;
import br.com.fjn.pdv.DAO.ProductDAO;
import br.com.fjn.pdv.DAO.SaleDAO;
import br.com.fjn.pdv.DAO.UserDAO;
import br.com.fjn.pdv.model.Address;
import br.com.fjn.pdv.model.City;
import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.ItemSale;
import br.com.fjn.pdv.model.Office;
import br.com.fjn.pdv.model.Product;
import br.com.fjn.pdv.model.Sale;
import br.com.fjn.pdv.model.State;
import br.com.fjn.pdv.model.User;

@Controller
public class ManagerController {

	private final Result result;
	private final Validator validator;

	@Inject
	public ManagerController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	// Esse construto é obrigado segundo as especificações do CDI, tenho que
	// coloca um construtor fazio
	@Deprecated
	public ManagerController() {
		this(null, null);
	}

	@Get("/administrador")
	public void managerUserFormView() {
		// Página principal do administrador
	}	
	
	//BUSCAR VENDAS
	@Get("/administrador-vendedor/vendabuscar")
	public void saleSearch(){
		
	}
	
	/*@Get("/administrador/buscarconteudovenda")
	public void productContentSale() throws ParseException{
	}
	
	@Post("/administrador/p-buscar-venda")
	public void saleSearch(Date beginDate, Date endDate) throws ParseException {
		System.out.println(beginDate + " " + endDate);
		SaleDAO sdao = new SaleDAO();
		result.include("saleSearch", sdao.searchSaleByDate(beginDate, endDate));
	    result.of(this).productContentSale();
	}*/
	
	//AUMENTAR ESTOQUE
	@Post("/administrador/estoque")
	public void upStock(Product product){
		ProductDAO pdao = new ProductDAO();
		Product p = pdao.searchProduct(product);
		pdao.upAmountProduct(p, product.getAmount());
		result.redirectTo(ProductController.class).productList();
	}
	
	@Get("/administrador/estoqueaumentar")
	public void upStock(){
		
	}
	

}