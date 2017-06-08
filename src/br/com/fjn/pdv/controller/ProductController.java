package br.com.fjn.pdv.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.fjn.pdv.DAO.EmployeeDAO;
import br.com.fjn.pdv.DAO.ProductDAO;
import br.com.fjn.pdv.DAO.SaleDAO;
import br.com.fjn.pdv.DAO.UserDAO;
import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.ItemSale;
import br.com.fjn.pdv.model.Product;
import br.com.fjn.pdv.model.Sale;

@Controller
public class ProductController {

	private final Result result;
	private final Validator validator;

	@Inject
	public ProductController(Result result, Validator validator) {
		this.result = result;
		this.validator = validator;
	}

	@Deprecated
	public ProductController() {
		this(null, null);
	}

	@Get("/administrador-vendedor/produtobuscar")
	public void productSearch() {

	}
// /administrador/p-adicionar
	// ADD PRODUTO
	@Post("administrador/p-adicionar")
	public void productAdd(@Valid Product product) {
         System.out.println("Passou!");
		
       validator.onErrorForwardTo(this).productAdd();

		ProductDAO productDAO = new ProductDAO();
		productDAO.AddProduct(product);
		//result.of(Results.json()).from("Produto adicionado com sucesso").serialize();
	//	result.include("msgSucesso", "Produto adicionado com sucesso!");
		result.redirectTo(this).productList();
	}
	///administrador/produtoadicionar
	@Get("administrador/produtoadicionar")
	public void productAdd() {
		//get do ajax
	}
	
	
	// Remove produto pelo id na view
	@Get("/administrador/remove")
	public void productRemove(Product product) {
		System.out.println("passou aqui" + product.getCodProduct());
		ProductDAO productDAO = new ProductDAO();
		productDAO.removeProductId(product);
	}

	// ATUALIZAR PRODUTO
	@Post("/administrador/p-atualizar")
	public void productUpdate(Product product) {
		ProductDAO pdao = new ProductDAO();
	    Product p = pdao.searchProduct(product);
		pdao.updateProduct(p, product.getUnitaryValue());
		result.redirectTo(this).productList();
	}

	@Get("/administrador/produtoatualizar")
	public void productUpdate() {

	}
	
	@Get("/administrador/buscarconteudo")
	public void productContentSearch(){
		
		
	}

	// BUSCAR PRODUTO
	@Post("/administrador/p-buscar")
	public void productSearch(Product product) {
		ProductDAO pdao = new ProductDAO();
	    result.include("product", pdao.searchProduct(product));
	    result.redirectTo(this).productContentSearch();
	}
	

	// LISTAR PRODUTOS
	@Get("/administrador-vendedor/produtolistar")
	public List<Product> productList() {

		ProductDAO productDAO = new ProductDAO();

		return productDAO.listProducts();
	}

	// VENDER PRODUTO
	@Post("/administrador-vendedor/vender")
	public void productSale(Sale sale, Product product, ItemSale it, Employee employee) {
		SaleDAO sdao = new SaleDAO();
		
        EmployeeDAO edao = new EmployeeDAO();
        Employee e = edao.searchEmployee(employee.getName());
        
		ProductDAO productDAO = new ProductDAO();
		Product p = productDAO.searchProduct(product);

		sdao.valueTotalSale(p, sale, product.getAmount());
		sale.setDate(new java.util.Date());
		it.setProduct(p);
		it.setSale(sale);
		it.setAmount(product.getAmount());
		ArrayList<ItemSale> list = new ArrayList<>();
		list.add(it);
		sale.setItemSale(list);
		sale.setEmployee(e);
	    sdao.saveSale(sale);
	    
		productDAO.lowerAmountProduct(p, product.getAmount());
		System.out.println("List " + sdao.listSale());
		result.include("itemsaleList", sdao.listSale());
		result.redirectTo(this).itemsaleList();
	}

	@Get("/administrador-vendedor/produtovender")
	public void productSale() {

	}
	
	@Get("/administrador-vendedor/vendalistar")
	public List<ItemSale> itemsaleList(){
		SaleDAO sdao = new SaleDAO();
		return sdao.listSale();
	}
	
	
}
