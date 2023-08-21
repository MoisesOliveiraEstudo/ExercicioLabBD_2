<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Motorista</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>
<body>
	<form action="cadastro/onibus" method="POST">
		<div>
			<label for="codigo">Placa</label>
			<input type="text" name="placa">
		</div>
		<div>
			<label>Marca</label>
			<input name="marca">
		</div>
		<div>
			<label for="codigo">Ano</label>
			<input type="number" name="ano">
		</div>
		<div>
			<label for="codigo">Descrição</label>
			<input type="text" name="descricao">
		</div>
		<input type="submit" name="botao" value="Inserir">
		<input type="submit" name="botao" value="Atualizar">
		<input type="submit" name="botao" value="Excluir">
		<input type="submit" name="botao" value="Listar">
		<input type="submit" name="botao" value="Consultar">
	</form>
	<div>
		<c:out value="${erro}"></c:out>
	</div>
	
</body>
</html>