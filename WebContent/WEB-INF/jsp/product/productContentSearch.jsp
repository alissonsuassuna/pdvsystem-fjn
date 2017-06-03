<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<td>${teste}</td>
			<td>${teste.manufacturer}</td>
			<td>${teste.amount}</td>
			<td><a
				href="<c:url value='/administrador/remove?product.codProduct=${product.codProduct}'/>">Remover</a>
			</td>
		</tr>

	</tbody>
</table>

