<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Viagens</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/style.css">
</head>
<body>
	<form  method="POST">
		<div>
			<label for="codigo">Codigo</label>
			<input type="number" name="codigo" id="codigo">
		</div>
		<div>
			<label>Motorista</label>
			<select>
				<option value="" disabled selected>Selecione um motorista</option>
				<c:forEach var="motorista" items="${motoristas}">
					<option value="${motorista.codigo }">
						<c:out value="${motorista.nome}"/>
					</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label for="codigo">Onibus</label>
			<select name="onibus">
				<option value="" disabled selected>Selecione um onibus</option>
				<c:forEach var="onibus" items="${onibuses}">
					<option value="${onibus.placa }">
						<c:out value="${onibus.placa}"></c:out>
					</option>
				</c:forEach>
			</select>
		</div>
		<input type="submit">
	</form>
</body>
</html>