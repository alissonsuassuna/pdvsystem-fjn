$("#menu-toggle").click(function(e) {
	e.preventDefault();
	$("#wrapper").toggleClass("toggled");
});

$(document).ready(function() {
	$('#click-add-product').click(function() {
		$('#layout').load('administrador/produtoadicionar');
	});
});
/*
$(document).ready(function() {
	$('#form-add').submit(function(event) {
		event.preventDefault();
		$.post('administrador/p-adicionar', $(this).serialize(), function(data){
			$("#content-add").html(data);
			//$.get('administrador/produtoadicionar', $(this).serialize(), function(data){
				//$("#content-add").html(data);
			//});
		});
		
	});
});

*/


$(document).ready(function() {
	$('#click-update-product').click(function() {
		$('#layout').load('administrador/produtoatualizar');
	});
});

$(document).ready(function() {
	$('#click-search-product').click(function() {
		$('#layout').load('administrador-vendedor/produtobuscar');
	});
});

$(document).ready(function() {
	$('#click-list-product').click(function() {
		$('#layout').load('administrador-vendedor/produtolistar');
	});
});

$(document).ready(function() {
	$('#click-sell').click(function() {
		$('#layout').load('administrador-vendedor/produtovender');
	});
});

$(document).ready(function() {
	$('#click-add-employee').click(function() {
		$('#layout').load('administrador/funcionarioadicionar');
	});
});

$(document).ready(function() {
	$('#click-update-employee').click(function() {
		$('#layout').load('administrador/funcionarioatualizar');
	});
});

$(document).ready(function() {
	$('#click-search-employee').click(function() {
		$('#layout').load('administrador/funcionariobuscar');
	});
});

$(document).ready(function() {
	$('#click-list-employee').click(function() {
		$('#layout').load('administrador/funcionariolistar');
	});
});

$(document).ready(function() {
	$('#click-search-sale').click(function() {
		$('#layout').load('administrador-vendedor/vendabuscar');
	});
});

$(document).ready(function() {
	$('#click-up-stock').click(function() {
		$('#layout').load('administrador/estoqueaumentar');
	});
});

//Função para buscar produto via ajax
/*
$(document).ready(function() {
	$('#form-buscar').submit(function(event) {
		event.preventDefault();
		$.post('administrador/p-buscar', $(this).serialize(), function(data){
			$("#content").html(data);
			
		});
		
	});
	*/
