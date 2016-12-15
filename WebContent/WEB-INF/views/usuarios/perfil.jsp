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
<h2>Dados Pessoais:</h2><br>
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
<h2>Comunidades de ${usuario.nome}:</h2>
        <table>
        <c:forEach var="comunidade" items="${comunidades}">
        <tr>
		     <td><a href = "mostrarPerfilComunidade?id=${comunidade.comId}">${comunidade.nome}</a></td>
	    </tr>
		</c:forEach>
       </table>
<h2>Amigos de ${usuario.nome}:</h2><br>
       <table>
       <c:forEach var="amigo" items="${amigos}">
       <tr>
		     <td><a href = "mostrarPerfil?id=${amigo.usuarioAlvo.usuId}">${amigo.usuarioAlvo.nome}</a></td>
	   </tr>
       </c:forEach>
       </table>
<a href="listarUsuarios">Voltar a encontrar amigos</a><br />		

</body>
</html>