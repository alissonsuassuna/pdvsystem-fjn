package br.com.fjn.pdv.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.fjn.pdv.annotations.Public;
import br.com.fjn.pdv.controller.LoginUserController;
import br.com.fjn.pdv.controller.UserLogged;

@Intercepts
public class AuthorizerInterceptor {
	
	private final UserLogged userLogged;
	private final Result result;
	private final ControllerMethod controllerMethod;
	
	
	@Inject
	public AuthorizerInterceptor(UserLogged userLogged, Result result, ControllerMethod controllerMethod) {
		this.userLogged = userLogged;
		this.result = result;
		this.controllerMethod = controllerMethod;
	}
	@Deprecated
	public AuthorizerInterceptor() {
		this(null,null, null);
	}
	@Accepts
	public boolean accepts() {
		return !controllerMethod.containsAnnotation(Public.class);
	}
	
	
	@AroundCall
	public void intercepta(SimpleInterceptorStack stack){
		
		if(userLogged.getUser() == null){
			result.redirectTo(LoginUserController.class).loginForm();
			return;
		}
		
		//antes
		stack.next();
		//depois
	}
}
