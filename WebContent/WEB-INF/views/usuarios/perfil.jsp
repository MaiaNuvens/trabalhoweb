<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="cabecalho.jsp" /> <br>
<h2>Dados Pessoais:</h2><br>

Nome : ${usuario.nome} <br>
Email : ${usuario.email} <br>
Idade : ${usuario.idade} <br>

<h2>Comunidades de ${usuario.nome}:</h2><br>
        <c:forEach var="comunidade" items="${comunidades}">
		     <a href = "mostrarPerfilComunidade?id=${comunidade.comId}">${comunidade.nome}</a>
	         <br>
		</c:forEach>


<br>
<a href="listarUsuarios">Voltar a encontrar amigos</a><br />		

</body>
</html>