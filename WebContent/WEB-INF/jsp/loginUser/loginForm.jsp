<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="./css/bootstrap.css">

<link rel="stylesheet" type="text/css" href="./css/loginBootstrap.css">
<!--  importação do css da página login -->

<title>Login</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="col-md-offset-4 col-md-4" id="box">
				<h2>Login</h2>
				<hr>
				<form  class="form-horizontal" action=<c:url value="login/autentica"/> method="post" id="contact_form"/> 
					<fieldset>
						<div class="form-group">

							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-user"></i></span> <input name="user.userName"
										placeholder="Usuário" class="form-control" type="text">
								</div>
							</div>
						</div>
						<div class="form-group">

							<div class="col-md-12">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="glyphicon glyphicon-lock"></i></span> <input name="user.password"
										placeholder="Senha" class="form-control" type="password">
								</div>
							</div>
						</div>
				</form>

				<div class="col-md-12">
					<button type="submit" id="btn-login"
						class="btn btn-md btn-danger pull-right">Entrar</button>
				</div>
			</div>
			</fieldset>
			</form>
		</div>
		
		
		 <div >
				<p style="color: red;">${msg}</p>
			</div>
	
			<c:forEach var="error" items="${errors}">
                    ${error.category} - ${error.message}<br />
			</c:forEach>
		
	</div>
</body>
</html>