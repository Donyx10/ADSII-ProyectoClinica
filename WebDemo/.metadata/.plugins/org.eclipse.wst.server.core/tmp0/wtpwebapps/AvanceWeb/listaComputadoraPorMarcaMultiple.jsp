<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>

<!DOCTYPE html>

<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap-theme.css">
<link rel="stylesheet" href="css/bootstrapValidator.css">

<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/bootstrapValidator.js"></script>
<title>Consulta de computadora por Marca</title>
</head>
<body>

	<div class="container">
		<h1>Consulta de computadora pior nombre</h1>
				<form action="consultaXMarcaMultiple" id="id_form"> 
						<label for="id_marca">Marca</label>
						<select id="id_marca" name="opciones" multiple="multiple" style="width: 100px;height: 100px">      
							
						</select>
						<button type="submit" class="btn btn-primary" >Filtrar</button>
				</form>
		<br>
		<br>
		<br>

		<table class="table">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Precio</th>
					<th>Stock</th>
					<th>Marca</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${lstComputadora}" var="x">
					<tr>
						<td>${x.idComputadora}</td>
						<td>${x.nombre}</td>
						<td>${x.precio}</td>
						<td>${x.stock}</td>
						<td>${x.marca.nombre}</td>

					</tr>
				</c:forEach>

			</tbody>
		</table>


	</div>




</body>
<script type="text/javascript">
	
	var varCargaMarca = function (){
		$.getJSON("cargaMarca", //alias del servlet
				{}, //los parametros
				function (data, textStatus, jqXHR) { //los datos llegan en el objeto data
					$.each(data.lstMarca, function (index, item) { //attr-->atributo
							$("<option/>").attr("value",item.idMarca).text(item.nombre).appendTo("#id_marca");
					});
				}
		);
	};
	
	$(document).ready(varCargaMarca);
</script>
</html>

