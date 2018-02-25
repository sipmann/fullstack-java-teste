<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Viagens</title>
	<link rel="stylesheet" type="text/css" href="/main.css">
</head>
<body>
	<h1>Viagens</h1>
	
	<table>
		<thead>
			<tr>
				<td>Passageiro</td>
				<td>CIA Aérea</td>
				<td>Data Saída</td>
				<td>Cidade Saída</td>
				<td>Data Chegada</td>
				<td>Cidade Chegada</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listagem }" var="viagem">
				<tr>
					<td>${viagem.nome }</td>
					<td>${viagem.ciaaerea }</td>
					<td>${viagem.dhsaida }</td>
					<td>${viagem.cidadeorigem }</td>
					<td>${viagem.dhchegada }</td>
					<td>${viagem.cidadedestino }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>