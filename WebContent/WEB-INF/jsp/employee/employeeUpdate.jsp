<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="pt-br">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, shrink-to-fit=no, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>PDV System - Administrador</title>

<!-- Bootstrap Core CSS -->
<link href="./css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="./css/simple-sidebar.css" rel="stylesheet">

<link href="./css/bootstrap.css" rel="stylesheet">
<link href="./css/bootstrap-theme.css" rel="stylesheet">


</head>
<body>

	<div class="container">
		<h1>Editar Funcionario</h1>
		<!--  -->
		<form action="administrador/f-atualizar" method="post">
			Nome do funcionário a ser editado: <input type="text" name="employee.name" class="form-control" />
			Email: <input type="email" name="employee.email" class="form-control"/>
			Cidade: <input type="text" name="city.name" class="form-control"/>
			Estado: <input type="text" name="state.name" class="form-control"/>
			Rua: <input type="text" name="address.street" class="form-control"/>
			Bairro: <input type="text" name="address.burgh" class="form-control"/>
			Número: <input type="text" name="address.number" class="form-control"/>
			<br>
			<div class="form-group">
				<div class="col-md-8">
					<select name="emp" required="required" class="form-control">
						<option value="a">Administrador</option>
						<option value="v">Vendedor</option>
					</select>
				</div>
			</div>	
			<br>
			<h1>Login</h1>
			<br>
			Novo Nome de Usuário: <input type="text" name="user.userName" class="form-control" />
			Nova Senha: <input type="password" name="user.password" class="form-control" />
			<br>
			<br>
			<br>
			<button type="submit" class="btn btn-primary">OK</button>
		</form>
	</div>
	<div> <p>${msg }</p></div>
</body>
</html>