package br.com.fjn.pdv.controller;

import javax.inject.Inject;
import javax.persistence.NoResultException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.fjn.pdv.DAO.UserDAO;
import br.com.fjn.pdv.annotations.Public;
import br.com.fjn.pdv.model.Employee;
import br.com.fjn.pdv.model.User;

@Controller
public class LoginUserController {

	private final UserLogged userLogged;
	private final Result result;
	private final Validator validator;

	private UserDAO userDao;
	private User userFromDB;

	@Inject
	public LoginUserController(Result result, Validator validator, UserLogged userLogged, UserDAO userDao,
			User userFromDB) {
		this.result = result;
		this.validator = validator;
		this.userLogged = userLogged;
		this.userDao = userDao;
		this.userFromDB = userFromDB;
	}

	// Esse construto é obrigado segundo as especificações do CDI, tenho que
	// coloca um construtor fazio
	@Deprecated
	public LoginUserController() {
		this(null, null, null, null, null);
	}

	@Public
	@Path("/login")
	public void loginForm() {

	}

	@Public
	@Post("login/autentica")
	public void checkUserLogin(User user) {

		userFromDB = userDao.userExist(user);

		if (userFromDB == null) {
			result.include("msgLogin", "Login inv�lido!").redirectTo(this).loginForm();

		} else {
			userLogged.setUser(userFromDB);
			if (userFromDB.getEmployee().isAdmin()) {
				result.redirectTo(ManagerController.class).managerUserFormView();
			} else {
				result.redirectTo(SalesmanController.class).salesmanUserFormView();
			}
		}

		// result.redirectTo(this);

	}

	@Get("login/logout")
	public void logout() {

	}
}
