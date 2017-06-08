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
		<h1>Remover Funcionario</h1>
		<!--  -->
		<form action="administrador/f-remove" method="post">
			Nome de usuario: <input type="text" name="user.userName" class="form-control"/>
			<br>
			<br>
			<button type="submit" class="btn btn-primary">OK</button>
		</form>
	</div>
	<div> <p>${msg }</p></div>
</body>
</html>