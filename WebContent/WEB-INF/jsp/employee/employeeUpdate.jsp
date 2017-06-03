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
		<form action="/administrador/f-atualizar" method="post">
			Nome: <input type="text" name="employee.name" class="form-control" />
			CPF: <input type="text" name="employee.cpf" class="form-control" /> 
			Data de Nascimento: <input type="date" name="employee.dateBirth" class="form-control"/>
			Email: <input type="email" name="employee.email" class="form-control"/>
			<br>
			<div class="form-group">
				<div class="col-md-8">
					<select required="required" class="form-control">
						<option value="manager">Administrador</option>
						<option value="salesman">Vendedor</option>
					</select>
				</div>
			</div>	
			<br>
			<h1>Login</h1>
			<br>
			Nome de Usuário: <input type="text" name="user.userName" class="form-control" />
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