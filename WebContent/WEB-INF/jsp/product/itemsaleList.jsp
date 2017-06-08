<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
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


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Vendas</title>
</head>
<body>
	<div id="wrapper">

		<div class="container">
			<h1>Lista de Vendas</h1>

			<table class="table table-stripped table-hover table-bordered">
				<thead>
				    <th>Produto</th>
				    <th>Valor Unitário</th>
					<th>Data</th>
					<th>Valor Total</th>
				</thead>
				<tbody>
					<c:forEach items="${itemsaleList}" var="itemsale">
						<tr>
						    <td>${itemsale.product.name}</td>
						    <td>${itemsale.product.unitaryValue}</td>
							<td>${itemsale.sale.date}</td>
							<td>${itemsale.sale.valueTotal}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>


	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="../js/jquery.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="../js/bootstrap.min.js"></script>

	<!-- Menu Toggle Script -->
	<script>
		$("#menu-toggle").click(function(e) {
			e.preventDefault();
			$("#wrapper").toggleClass("toggled");
		});
	</script>

</body>
</html>