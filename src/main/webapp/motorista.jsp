<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Motoristas</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>
<body>
	<nav>
		<a href="<%=request.getContextPath()%>/index.jsp">Voltar ao Inicio</a>
	</nav>

	<form action="cadastro/motorista" method="POST">
		<div>
			<label for="codigo">Codigo</label>
			<input type="number" name="codigo" id="codigo">
		</div>
		<div>
			<label>Nome</label>
			<input name="nome">
		</div>
		<div>
			<label for="codigo">Naturalidade</label>
			<input name="naturalidade">
		</div>
		<input type="submit" name="botao" value="Inserir">
		<input type="submit" name="botao" value="Atualizar">
		<input type="submit" name="botao" value="Excluir">
		<input type="submit" name="botao" value="Listar">
		<input type="submit" name="botao" value="Consultar">
	</form>                        
	
	<div>
		<c:out value="${motorista.nome}"></c:out>
		<c:out value="${erro}"></c:out>
	</div>
	
	<div>
		<c:forEach var="motorista" items="${motoristas}">
			<label><c:out value="${motorista.nome }"></c:out></label>
		</c:forEach>
	</div>
	
</body>
</html>