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
	
	tr:nth-child(odd) {
	    background-color: #dddddd;
	}
</style>
</head>
<body>

<c:import url="cabecalho.jsp" /> <br>

<h2>Bem Vindo ao Forum - ${forum.titulo}</h2> 

<h2>Descrição:</h2> 
${forum.descricao} <br>

<h2>Mensagens:</h2>
        <table>
        <c:forEach var="mensagem" items="${mensagens}">
		<tr>
			<td>${mensagem.texto}</td>
			<td> <a href = "mostrarPerfil?id=${mensagem.usuId}">${mensagem.usuario.nome}</a></td>
			<c:if test="${mensagem.usuId == usuario.usuId}">
			       <td> <a href = "apagarMensagem?id=${mensagem.menId}">APAGAR</a></td>
			</c:if>
	    </tr>
	    <br>
		</c:forEach>
		</table>
 <br>
 <br>
 
 Adicionar mensagem:<br>
 <form action="cadastrarMensagem?id=${forum.forId}" method="post">     <!-- colocar comunidade -->
             <table>
              <tr>
              <td>Texto:</td>
              <td><input type="text" name="texto" /></td>
              </tr>
              <tr>
              <td><input type="submit" value="POSTAR"></td>
              </tr>
             </table>
</form>

<br>
<a href = "mostrarPerfilComunidade?id=${comunidade.comId}">voltar</a> 

</body>
</html>