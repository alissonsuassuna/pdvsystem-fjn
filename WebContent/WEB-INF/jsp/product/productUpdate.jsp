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


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>

	<div class="container">
		<h1>Editar Produto</h1>
		<!--  -->
		<form action="administrador/p-atualizar" method="post">

           <input type="hidden" name="product.codProduct" 
                  value="${product.codProduct }" /> 
			Nome: <input type="text" name="product.name" value="${product.name }" class="form-control" />
			Valor unitario: <input type="text" name="product.unitaryValue" value="${product.unitaryValue }"
				class="form-control" /> Fábricante: <input type="text"
				name="product.manufacturer" value="${product.manufacturer }" class="form-control" />
             
            <br> 
			<button type="submit" class="btn btn-primary">OK</button>
		</form>
	</div>
</body>
</html>