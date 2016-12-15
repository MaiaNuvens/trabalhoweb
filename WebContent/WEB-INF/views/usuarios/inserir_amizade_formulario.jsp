<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table {
	    font-family: arial, sans-serif;
	    border-collapse: collapse;
	    width: 50%;
	}
	
	td, th {
	    border: 1px solid white;
	    text-align: left;
	    padding: 5px;
	}
	
	tr:nth-child(even) {
	    background-color: #dddddd;
	}
	tr:nth-child(odd) {
	    background-color: #dddddd;
	}
</style>
</head>
<body>
<form action="inserirAmizade" method="post">

<h2>Usuarios para seguir:</h2><br>
Selecione os usuarios que voce deseja seguir <br>
	<table >
		<c:forEach var="u" items="${potenciais_amigos}">
		<tr>

			<td><a href = "mostrarPerfil?id=${u.usuId}">${u.nome}</a></td>
			<td><form:checkbox path="amizade.amigos" value="${u.usuId}" /> </td>
			
		</tr>
		</c:forEach>
	</table>
	<input type="submit" value="OK" />

</form>
</body>
</html>