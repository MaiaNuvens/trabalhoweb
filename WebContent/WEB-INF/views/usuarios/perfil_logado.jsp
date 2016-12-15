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


<h2>Meus dados:</h2><br>
<table>
          <tr>
               <td>Nome:</td> 
               <td>${usuario.nome}</td>
          </tr>
          <tr>
               <td>Email:</td>
               <td>${usuario.email}</td>
          </tr>
          <tr>
                <td>Idade:</td>
                <td>${usuario.idade}</td>
          </tr>
    
</table>
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
        <table >
        <c:forEach var="comunidade" items="${comunidades}">
        <tr>
		     <td><a href = "mostrarPerfilComunidade?id=${comunidade.comId}">${comunidade.nome}</a></td>
	       </tr>
		</c:forEach>
		</table>
<br>
<h2>Meus Amigos:</h2><br>
       <table>
       <c:forEach var="amigo" items="${amigos}">
       <tr>
		     <td><a href = "mostrarPerfil?id=${amigo.usuarioAlvo.usuId}">${amigo.usuarioAlvo.nome}</a></td>
	   </tr>
       </c:forEach>
       </table>


</body>
</html>