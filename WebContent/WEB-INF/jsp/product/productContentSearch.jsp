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

<table class="table table-stripped table-hover table-bordered">
	<thead>
		<th>Nome</th>
		<th>Valor Unitário</th>
		<th>Fabricante</th>
		<th>Quantidade</th>
		<th>Remover</th>
	</thead>
	<tbody>
		<tr>
			<td>${product.name}</td>
			<td>${product.unitaryValue}</td>
			<td>${product.manufacturer}</td>
			<td>${product.amount}</td>
			<td><a
				href="<c:url value='/administrador/remove?product.codProduct=${product.codProduct}'/>">Remover</a>
			</td>
		</tr>

	</tbody>
</table>

