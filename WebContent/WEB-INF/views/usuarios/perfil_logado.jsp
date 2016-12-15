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
<h2>Meus dados:</h2><br>

Nome : ${usuario.nome} <br>
Email : ${usuario.email} <br>
Idade : ${usuario.idade} <br>

<h2>Alterar dados:</h2><br>
<form action="alterarUsuario" method="post">
	<input type="hidden" name="usuId" value="${usuario.usuId}">
	<table>
		<tr>
			<td>NOME:</td>
			<td><input type="text" name="nome" value="${usuario.nome}" /></td>
		</tr>
		<tr>
			<td>LOGIN:</td>
			<td><input type="text" name="login" value="${usuario.login}" /></td>
		</tr>
		<tr>
			<td>SENHA:</td>
			<td><input type="text" name="senha" value="${usuario.senha}"/></td>
		</tr>
		<tr>
			<td>EMAIL:</td>
			<td><input type="text" name="email" value="${usuario.email}" /></td>
		</tr>
		<tr>
			<td>IDADE:</td>
			<td><input type="text" name="idade" value="${usuario.idade}" /></td>
		</tr>
		 
		<tr>
			<td colspan="2"><input type="submit" value="ENVIAR"/></td>
		</tr>
	</table>
</form>  
<h2>Minhas Comunidades:</h2>

        <c:forEach var="comunidade" items="${comunidades}">
		     <a href = "mostrarPerfilComunidade?id=${comunidade.comId}">${comunidade.nome}</a>
	         <br>
		</c:forEach>
<br>
<a href="cadastrarComunidadeFormulario">Criar Comunidade</a><br />

</body>
</html>