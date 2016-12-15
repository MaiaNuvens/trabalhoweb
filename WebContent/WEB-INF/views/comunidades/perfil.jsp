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
<h2>Comunidade - ${comunidade.nome}</h2> <c:if test="${pertence == false}">
			                                <a href = "adicionarUsuario?id=${comunidade.comId}"> Entrar </a>
			                             </c:if>

<br>
<h2>Participantes:</h2> 

		<c:forEach var="usuario" items="${usuarios}">
		
			 <a href = "mostrarPerfil?id=${usuario.usuId}">${usuario.nome}</a>
	         <br>
		</c:forEach>


<h2>Foruns:</h2> 

		<c:forEach var="forum" items="${foruns}">
		
			 <td><a href = "mostrarPerfilForum?id=${forum.forId}">${forum.titulo}</a></td>
			 <c:if test="${forum.usuId == usuario.usuId}">
			       <td> <a href = "apagarForum?id=${forum.forId}">APAGAR</a></td>
			 </c:if>
	         <br>
		</c:forEach>

<br>
Criar forum : <br>
<form action="cadastrarForum?id=${comunidade.comId}" method="post">     <!-- colocar comunidade -->

              Titulo:<input type="text" name="titulo" /> <br />
              Descricao: <input type="text" name="descricao" /> <br />
              <input type="submit" value="OK">
</form>

<br>
<a href="listarComunidades">Voltar para comunidades</a><br />


</body>
</html>