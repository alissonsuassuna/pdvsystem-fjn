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
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/simple-sidebar.css" rel="stylesheet">

<link href="../css/bootstrap.css" rel="stylesheet">
<link href="../css/bootstrap-theme.css" rel="stylesheet">


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<div class="container">
		<h1>Adicionar Produto</h1>
		<!--  -->
		<form id="form-add" action="administrador/p-adicionar" method="post">

			Nome: <input type="text" name="product.name" class="form-control" />
			Valor unitario: <input type="text" name="product.unitaryValue"
				class="form-control" /> Fábricante: <input type="text"
				name="product.manufacturer" class="form-control" /> Quantidade: <input
				type="number" name="product.amount" class="form-control" /> <br>
			<button type="submit" class="btn btn-primary">Adicionar</button>
		</form>
	</div>

	<c:if test="${not empty errors}">
		<div class="alert alert-danger">
			<c:forEach var="error" items="${errors}">
                    ${error.category} - ${error.message}<br />
			</c:forEach>
		</div>
	</c:if>


	<!-- jQuery -->
	<script src="../js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../js/bootstrap.min.js"></script>

	<!-- Menu Toggle Script -->
	<script src="../js/scriptAjax.js"></script>

	<!-- <script type="text/javascript">
		$(document).ready(function() {
			$('#botao').click(function() {
				alert("Produto adicionado com Sucesso!");
			});
		});
		</script> -->

</body>
</html>