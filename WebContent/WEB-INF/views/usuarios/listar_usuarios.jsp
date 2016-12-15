<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<c:import url="cabecalho.jsp" /> <br>

<h2>Usuarios:</h2><br>
<table style="width:50%">
		<c:forEach var="usuario" items="${usuarios}">
		<tr>
			<td> <a href = "mostrarPerfil?id=${usuario.usuId}">${usuario.nome}</a></td>
	    </tr>
		</c:forEach>
</table>

</body>
</html>