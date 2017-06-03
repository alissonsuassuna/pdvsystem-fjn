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
		<h1>Buscar Produto</h1>
		<!--  -->
		<form id="form-buscar" action="administrador/p-buscar" method="post">
			Nome: <input type="text" name="product.name" class="form-control" />
			<br>
			<button id="click-buscar" type="submit" class="btn btn-primary">Buscar</button>
		</form>
		<br>

		<div id="content">

		</div>
	</div>

	<script src="./js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="./js/bootstrap.min.js"></script>

	<!-- Menu Toggle Script -->
	<script src="./js/scriptAjax.js"></script>
	<script src="./js/script.js"></script>
</body>
</html>